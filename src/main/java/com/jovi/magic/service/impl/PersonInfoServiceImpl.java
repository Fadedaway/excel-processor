package com.jovi.magic.service.impl;

import com.jovi.magic.entity.PersonInfo;
import com.jovi.magic.repository.PersonInfoRepository;
import com.jovi.magic.service.PersonInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fanjiawei
 * @date Created on 2018/11/22
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    private PersonInfoRepository personInfoRepository;

    @Override
    public void analysePersonData(List<String[]> dataList) {
        if (CollectionUtils.isEmpty(dataList))
            return;

        Set<String[]> dataSet;
        // 数据筛选
        dataSet = dataList.stream().filter(data -> StringUtils.isNotEmpty(data[18]) && (data[18].contains("嘉宏盛世花园") || data[18].contains("双子星座公寓"))).collect(Collectors.toSet());

        if (CollectionUtils.isEmpty(dataSet))
            return;

        System.out.println(">>>>>>>>>>>>>>>>>>>> after : " + dataSet.size());
        dataSet.forEach(this::installData);
    }

    @Override
    @Async("asyncServiceExecutor")
    @Transactional(rollbackFor = Exception.class)
    public void installData(String[] data) {
        PersonInfo personInfo = new PersonInfo();

        // TODO 组装人员信息数据
        personInfoRepository.save(personInfo);
    }
}
