package com.jovi.magic.service.impl;

import com.jovi.magic.entity.*;
import com.jovi.magic.repository.*;
import com.jovi.magic.service.PersonInfoService;
import com.jovi.magic.util.FileUtil;
import com.jovi.magic.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author fanjiawei
 * @date Created on 2018/11/22
 */
@Slf4j
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    private PersonInfoRepository personInfoRepository;

    @Autowired
    private PersonBuildingInfoRepository personBuildingInfoRepository;

    @Autowired
    private StandardAddressBuildRepository standardAddressBuildRepository;

    @Autowired
    private PersonCardInfoRepository personCardInfoRepository;

    @Autowired
    private ActualBuildingRepository actualBuildingRepository;

    private final static String DISTRICT_PREFIX = "江苏省常州市";

    private final static String JIAHONG_DISTRICT = "天宁区";

    private final static String SHUANGZI_DISTRICT = "武进区";

//    @Value("${address.jiahongshengshi}")
//    private String JIAHONGSHENGSHI;
//
//    @Value("${address.shuangzixingzuo}")
//    private String SHUANGZIXINGZUO;

    @Value("${img.base_url}")
    private String imgBaseUrl;

//    Map<String, StandardAddressBuild> buildMap = new HashMap<>();

    private Map<String, ActualBuilding> actualBuildingMap = new HashMap<>();

    @Override
    public void analysePersonData(List<String[]> dataList) {
        if (CollectionUtils.isEmpty(dataList))
            return;

        Set<String[]> dataSet;
        // 数据筛选
        dataSet = dataList.stream().filter(data -> StringUtils.isNotEmpty(data[18]) && (data[18].contains("嘉宏盛世商务广场10幢") || data[18].contains("双子星座公寓"))).collect(Collectors.toSet());

        // 根据身份证，地址信息去重
        dataSet = dataSet.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(data -> data[18] + ";" + data[10] + ";" + data[16]))), HashSet::new));

        if (CollectionUtils.isEmpty(dataSet))
            return;

        System.out.println(">>>>>>>>>>>>>>>>>>>> after : " + dataSet.size());

        // TODO 读取房屋 地址/id的映射关系
        List<ActualBuilding> actualBuildingList = actualBuildingRepository.findAll();

        if (CollectionUtils.isEmpty(actualBuildingList))
            return;

        actualBuildingMap = actualBuildingList.stream().collect(Collectors.toMap(ActualBuilding::getBuildingAddress, Function.identity()));
//        List<StandardAddressBuild> buildList = standardAddressBuildRepository.findAll();
//
//        if (CollectionUtils.isEmpty(buildList))
//            return;
//
//        buildMap = buildList.stream().collect(Collectors.toMap(StandardAddressBuild::getStandardAddressName, Function.identity()));

        PersonInfoService personInfoServiceProxy = SpringUtil.getBean(PersonInfoService.class);

        for (String[] strings : dataSet) {
            try {
                personInfoServiceProxy.installData(strings);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    @Async("asyncServiceExecutor")
    @Transactional(rollbackFor = Exception.class)
    public void installData(String[] data) {
        log.info("start to process data : identityCardNo - {}, startTime - {} ", data[10], new Date());
        PersonInfo personInfo = personInfoRepository.findByIdentityCard(data[10]);

        if (Objects.isNull(personInfo)) {   // 如果还没有用户信息，新建用户信息插入数据库

            // 组装人员信息数据
            personInfo = installPersonInfo(data);
        } else if (StringUtils.isEmpty(personInfo.getPhotoUrl()) && StringUtils.isNotEmpty(data[16])) {

            personInfo.setPhotoUrl(data[16].trim());

            personInfoRepository.save(personInfo);
        }
        // 组装身份证信息
        installCardInfo(personInfo);

        // 组装用户房屋信息
        installPersonBuildInfo(personInfo, data);
        log.info("finish to process data : identityCardNo - {}, endTime - {} ", data[10], new Date());
    }

    private void installCardInfo(PersonInfo personInfo) {
        if (Objects.isNull(personInfo))
            return;

        PersonCardInfo personCardInfo = personCardInfoRepository.findByCardNo(personInfo.getIdentityCard());

        if (Objects.nonNull(personCardInfo))
            return;

        personCardInfo = new PersonCardInfo();

        personCardInfo.setCardType("ID");
        personCardInfo.setCardNo(personInfo.getIdentityCard());
        personCardInfo.setPersonId(personInfo.getId());
        personCardInfo.setCreatedBy("anonymous");
        personCardInfo.setUpdatedBy("anonymous");

        personCardInfoRepository.save(personCardInfo);
    }

    private PersonInfo installPersonInfo(String[] data) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");

        PersonInfo personInfo = new PersonInfo();

        if (StringUtils.isNotEmpty(data[11]))           // 用户姓名
            personInfo.setPersonName(data[11].trim());
        if (StringUtils.isNotEmpty(data[10]) && data[10].length() == 18) {      // 18位合法身份证
            String idCard = data[10].trim();
            personInfo.setIdentityCard(idCard);
            String birthDayStr = data[10].substring(6, 14);
            try {
                personInfo.setBirthDate(formatDate.parse(birthDayStr));     // 根据身份证解析出来的生日
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        if (StringUtils.isNotEmpty(data[12])) {     // 性别
            if ("1".equals(data[12]))
                personInfo.setPersonGender("M");
            else if ("2".equals(data[12]))
                personInfo.setPersonGender("F");
        }
        if (StringUtils.isNotEmpty(data[16])) {     // 照片地址
//            String imgUrl = data[16].trim().replace("LOC:", imgBaseUrl);
////            personInfo.setPhotoUrl(imgUrl);
            personInfo.setPhotoUrl(data[16].trim());
        }
        if (StringUtils.isNotEmpty(data[18])) {     // 户籍地址
            //personInfo.setDomicilePlace(DISTRICT_PREFIX + data[18].trim());
            if (data[18].contains("嘉宏盛世商务广场10幢"))
                personInfo.setDomicilePlace(DISTRICT_PREFIX + JIAHONG_DISTRICT + data[18].trim());
            if (data[18].contains("双子星座公寓"))
                personInfo.setDomicilePlace(DISTRICT_PREFIX + SHUANGZI_DISTRICT + data[18].trim());
        }
        else
            return null;

        personInfo.setNativePlaceId(10L);
        personInfo.setPersonRace("汉");
        personInfo.setPersonStatus("N");
        personInfo.setAuditStatus("A");
        personInfo.setPersonType("P");
        personInfo.setCreatedBy("anonymous");
        personInfo.setUpdatedBy("anonymous");

        return personInfoRepository.save(personInfo);
    }

    private PersonBuildingInfo installPersonBuildInfo(PersonInfo personInfo, String[] data) {
        if (Objects.isNull(personInfo))
            return null;

        PersonBuildingInfo personBuildingInfo = new PersonBuildingInfo();

        personBuildingInfo.setPersonId(personInfo.getId());

        // 匹配住址
        String matchStr;
        if (StringUtils.isNotEmpty(data[18])) {
            matchStr = cutAddress(data[18]);
        }
//        else if (StringUtils.isNotEmpty(data[19])) {
//            matchStr = cutAddress(data[19]);
//        }
        else {
            return null;
        }

        if (Objects.isNull(actualBuildingMap) || StringUtils.isEmpty(matchStr))
            return null;

        if (actualBuildingMap.containsKey(matchStr)) {      //  设置楼宇id

            Long buildingId = actualBuildingMap.get(matchStr).getId();

            PersonBuildingInfo oldBuildingInfo = personBuildingInfoRepository.findByPersonIdAndBuildingId(personInfo.getId(), buildingId);

            if (Objects.nonNull(oldBuildingInfo))       // 已经存在人员房屋对应关系
                return null;

            personBuildingInfo.setBuildingId(actualBuildingMap.get(matchStr).getId());
        }
        else
            return null;
//        if (Objects.isNull(buildMap) || StringUtils.isEmpty(matchStr))
//            return null;
//
//        if (buildMap.containsKey(matchStr))     //  设置楼宇id
//            personBuildingInfo.setBuildingId(buildMap.get(matchStr).getId());
//        else
//            return null;

        personBuildingInfo.setLiveType("PB");
        personBuildingInfo.setLiveDateFrom(new Date());
        personBuildingInfo.setRelationStatus("A");
        personBuildingInfo.setStatus("A");
        personBuildingInfo.setRelationshipWithHomeowner("S");
        personBuildingInfo.setCreatedBy("anonymous");
        personBuildingInfo.setUpdatedBy("anonymous");

        return personBuildingInfoRepository.save(personBuildingInfo);
    }

    private String cutAddress(String address) {
        if (address.contains("单元")) {
            address = address.replace("幢甲单元", "栋1单元");
            address = address.replace("幢乙单元", "栋2单元");
            address = address.replace("幢丙单元", "栋3单元");
            address = address.replace("幢丁单元", "栋4单元");
            return address.substring(0, address.length() - 1);      //  去掉最后一位室字
        } else {
            Matcher matcher = Pattern.compile("[0-9]+").matcher(address);
            if(matcher.find()) {
//            System.out.println(matcher.start() + " " + matcher.end());
                return address.substring(0, matcher.end()) + "栋1单元" + address.substring(matcher.end() + 1, address.length() - 1);
            } else {
                return "";
            }
        }
    }

    @Override
    public void fixData() {
        List<PersonInfo> personInfoList = personInfoRepository.findAll();

        if (CollectionUtils.isEmpty(personInfoList))
            return;

        personInfoList.forEach(personInfo -> {


        });
    }

    @Override
    public void processPersonData(List<String[]> dataList) {
        String fileName = "UpdatePerson-" + new Date().getTime() + ".sql";

        String filePath = "F:/" + fileName;
        dataList.forEach(data -> {
            String newLine = System.getProperty("line.separator");
            String updateSql = "UPDATE person_info SET person_type = '" + data[1] + "' WHERE identity_card = '" + data[0] + "';" + newLine;
            FileUtil.writeToFile(filePath, updateSql, true);
        });
    }
//    public static void main(String[] args) {
//        String address = "双子星座公寓11幢1819室";
//        Matcher matcher = Pattern.compile("[0-9]+").matcher(address);
//        if(matcher.find()) {
////            System.out.println(matcher.start() + " " + matcher.end());
//            System.out.println(address.substring(0, matcher.end()) + "栋1单元" + address.substring(matcher.end() + 1, address.length() - 1));
//        } else {
//            System.out.println("not found");
//        }
//    }
}
