package com.jovi.magic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jovi.magic.entity.DeptTree;
import com.jovi.magic.entity.Menu;
import com.jovi.magic.entity.ResultMsg;
import com.jovi.magic.util.TreeUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author fanjiawei
 * @date Created on 2019/1/17
 */
public class TestTreeMain {

    private static int id = 1;

    static int getId() {
        return id ++;
    }

    private static String getIdStr() {
        return String.valueOf(getId());
    }

    public static void main(String[] args) {
//        List<Menu> list=new ArrayList<>();
//        Menu menu1=new Menu();
//        menu1.setId("1");
//        menu1.setParentId("0");
//        menu1.setName("菜单1");
//        list.add(menu1);
//
//        Menu menu2=new Menu();
//        menu2.setId("2");
//        menu2.setParentId("0");
//        menu2.setName("菜单2");
//        list.add(menu2);
//
//        Menu menu3=new Menu();
//        menu3.setId("3");
//        menu3.setParentId("1");
//        menu3.setName("菜单13");
//        list.add(menu3);
//
//        Menu menu4=new Menu();
//        menu4.setId("4");
//        menu4.setParentId("3");
//        menu4.setName("菜单134");
//        list.add(menu4);
//
//        Menu menu5=new Menu();
//        menu5.setId("5");
//        menu5.setParentId("2");
//        menu5.setName("菜单25");
//        list.add(menu5);
//
//        List<Menu> menus= TreeUtil.getTreeList("0",list);
//        System.out.println(menus);
        //menus.forEach(System.out::println);

//        List<Menu> result = new ArrayList<>();


//        List<Menu> children = collectMenus(menus, result);
//        while (CollectionUtils.isNotEmpty(children)) {
//            children = collectMenus(children, result);
//        }

//        result.forEach(System.out::println);
        Map<String, String> pathStore = new HashMap<>();
        List<Menu> result = new ArrayList<>();

        ResultMsg resultMsg = JSON.parseObject("{\"code\":\"0\",\"fields\":[],\"result\":[{\"children\":[{\"code\":\"102001\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1536158052564,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c91808a65a7c1690165aa27b14603f1\",\"level\":2,\"name\":\"虎丘分局\",\"path\":\"0g6s-pqp4\",\"sortIndex\":101,\"status\":1,\"updateTime\":1545188663507,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"103001\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1536158488544,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c91808a65a7c1690165aa2e57e703f2\",\"level\":2,\"name\":\"枫桥派出所\",\"path\":\"0g6s-1fjp\",\"sortIndex\":10101,\"status\":1,\"updateTime\":1536158488544,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"104001\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1536158503073,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c91808a65a7c1690165aa2e90ad03f3\",\"level\":2,\"name\":\"科达小区\",\"path\":\"0g6s-s1in\",\"sortIndex\":1010101,\"status\":1,\"updateTime\":1536158503073,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"1030\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1540861490033,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949ea666aedc0e0166c28073d20000\",\"level\":2,\"name\":\"测试部门无效\",\"path\":\"0g6s-nt2m\",\"sortIndex\":101,\"status\":1,\"updateTime\":1540888105033,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"}],\"code\":\"101000\",\"createDeptCode\":\"101000\",\"createDeptName\":\"科达科技\",\"createTime\":1532931894118,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"description\":\"\",\"id\":\"216\",\"level\":1,\"name\":\"苏州市公安局\",\"path\":\"0g6s\",\"sortIndex\":1,\"status\":0,\"updateTime\":1545188674101,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"KD01\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1537254169881,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc0165eb7d1d4b0005\",\"level\":1,\"name\":\"姑苏分局\",\"path\":\"a2l6\",\"sortIndex\":1,\"status\":1,\"updateTime\":1537254169881,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"children\":[{\"children\":[{\"code\":\"898989\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1538286253191,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc01662901748d0142\",\"level\":3,\"name\":\"冒烟测试\",\"path\":\"0nvk-slix-5du2\",\"sortIndex\":10101,\"status\":1,\"updateTime\":1538286289333,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"cs999\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1539674022109,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc01667bb920e60657\",\"level\":3,\"name\":\"测试9999\",\"path\":\"0nvk-slix-a99o\",\"sortIndex\":10101,\"status\":0,\"updateTime\":1539674050755,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"}],\"code\":\"cs1111\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1538206982893,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc01662447e2f30132\",\"level\":2,\"name\":\"测试111\",\"path\":\"0nvk-slix\",\"sortIndex\":101,\"status\":1,\"updateTime\":1538206982893,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"cs112\",\"createDeptCode\":\"101000\",\"creatorCode\":\"admin\",\"id\":\"2c949e9b65e7dbcc0166244a7d050133\",\"level\":2,\"name\":\"测试\",\"path\":\"0nvk-cyts\",\"sortIndex\":101,\"status\":1,\"updateTime\":1538207312592,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"}],\"code\":\"BU123\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1537512265658,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc0165fadf57be0008\",\"level\":1,\"name\":\"测试\",\"path\":\"0nvk\",\"sortIndex\":1,\"status\":0,\"updateTime\":1537512265658,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"children\":[{\"code\":\"104231\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1540520838837,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc0166ae3286bb0660\",\"level\":2,\"name\":\"测试22\",\"path\":\"jddt-72jw\",\"sortIndex\":101,\"status\":1,\"updateTime\":1540520838837,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"}],\"code\":\"BU234\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1537512281106,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc0165fadf94180009\",\"level\":1,\"name\":\"测试2\",\"path\":\"jddt\",\"sortIndex\":1,\"status\":0,\"updateTime\":1537512291960,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"KD008\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1537870609651,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc0166103b3cf8000a\",\"level\":1,\"name\":\"测试3\",\"path\":\"jzn7\",\"sortIndex\":1,\"status\":0,\"updateTime\":1537870620006,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"children\":[{\"code\":\"10101332\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1539149569918,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc01665c769f85022b\",\"level\":2,\"name\":\"锐晶301\",\"path\":\"3pru-kwqs\",\"sortIndex\":101,\"status\":1,\"updateTime\":1539149569918,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"10101333\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1539149611140,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc01665c77408b022c\",\"level\":2,\"name\":\"锐晶302\",\"path\":\"3pru-jext\",\"sortIndex\":101,\"status\":0,\"updateTime\":1539149611140,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"10101334\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1539149823568,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc01665c7a7e58022d\",\"level\":2,\"name\":\"锐晶303\",\"path\":\"3pru-4ehp\",\"sortIndex\":101,\"status\":1,\"updateTime\":1539149823568,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"children\":[{\"code\":\"10101336\",\"createDeptCode\":\"101000\",\"creatorCode\":\"admin\",\"id\":\"2c949e9b65e7dbcc01665c80b077022f\",\"level\":3,\"name\":\"锐晶3041\",\"path\":\"3pru-w4gc-09z5\",\"sortIndex\":10101,\"status\":1}],\"code\":\"10101335\",\"createDeptCode\":\"101000\",\"creatorCode\":\"admin\",\"id\":\"2c949e9b65e7dbcc01665c7e379b022e\",\"level\":2,\"name\":\"锐晶304\",\"path\":\"3pru-w4gc\",\"sortIndex\":101,\"status\":1},{\"code\":\"10101337\",\"createDeptCode\":\"101000\",\"creatorCode\":\"admin\",\"id\":\"2c949e9b65e7dbcc01665c80b07f0230\",\"level\":2,\"name\":\"锐晶305\",\"path\":\"3pru-nh20\",\"sortIndex\":101,\"status\":1}],\"code\":\"10101330\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1539149486773,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949e9b65e7dbcc01665c755abd022a\",\"level\":1,\"name\":\"锐晶测试\",\"path\":\"3pru\",\"sortIndex\":1,\"status\":1,\"updateTime\":1539149529437,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"103017\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1540888794398,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949ea666aedc0e0166c421152b015e\",\"level\":1,\"name\":\"科技城\",\"path\":\"e1h9\",\"sortIndex\":1,\"status\":1,\"updateTime\":1540888818231,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"10086\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1540889284050,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949ea666aedc0e0166c4288de10161\",\"level\":1,\"name\":\"测试无效\",\"path\":\"i25p\",\"sortIndex\":1,\"status\":1,\"updateTime\":1540889284050,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"},{\"code\":\"DEPT001\",\"createDeptCode\":\"101000\",\"createDeptName\":\"苏州市公安局\",\"createTime\":1544749414797,\"creatorCode\":\"admin\",\"creatorName\":\"admin\",\"id\":\"2c949eb0675587b50167aa3d7c8701a4\",\"level\":1,\"name\":\"小程序测试部门\",\"path\":\"myk6\",\"sortIndex\":1,\"status\":1,\"updateTime\":1544749414797,\"updaterCode\":\"admin\",\"updaterName\":\"admin\"}],\"status\":200,\"timestamp\":1547776623164}", ResultMsg.class);

        String deptJsonStr = JSONObject.toJSONString(resultMsg.getResult());

        List<DeptTree> deptTreeList = JSONObject.parseArray(deptJsonStr, DeptTree.class);

        analysisDeptTreeListDG(deptTreeList, result, pathStore);
//        List<DeptTree> children = analysisDeptTreeList(deptTreeList, result, pathStore);
//        while (CollectionUtils.isNotEmpty(children)) {
//
//            children = analysisDeptTreeList(children, result, pathStore);
//        }
//        System.out.println(deptTreeList.get(0).getPath());

        result.forEach(System.out::println);
    }

    private static List<Menu> collectMenus(List<Menu> menus, List<Menu> resultList) {
        if (CollectionUtils.isEmpty(menus))
            return new ArrayList<>();

        List<Menu> children = new ArrayList<>();

        menus.forEach(menu -> {
            if (StringUtils.isEmpty(menu.getPath()))
                menu.setPath(menu.getParentId()+","+menu.getId());

            if (CollectionUtils.isNotEmpty(menu.getChildList())) {
                children.addAll(menu.getChildList().stream().peek(childrenMenu -> childrenMenu.setPath(menu.getPath()+","+childrenMenu.getId())).collect(Collectors.toList()));
                menu.setChildList(null);
            }
            resultList.add(menu);
        });

        return children;
    }

    private static List<DeptTree> analysisDeptTreeList(List<DeptTree> deptTreeList, List<Menu> resultList, Map<String, String> pathStore) {
        if (CollectionUtils.isEmpty(deptTreeList))
            return new ArrayList<>();

        List<DeptTree> children = new ArrayList<>();

        deptTreeList.forEach(deptTree -> {
            String path, parentId;
            String localId = getIdStr();

            String originPath = deptTree.getPath();     //  获取部门树路径
            String[] pathCode = originPath.split("-");

            if (1 == deptTree.getLevel()) {
                parentId = "-1";
                path = "-1," + localId;
            } else {
                String upPath = pathStore.get(pathCode[pathCode.length-2]);
                String[] parentIds = upPath.split(",");
                path = upPath + "," + localId;
                parentId = parentIds[parentIds.length-1];
            }

            pathStore.put(pathCode[pathCode.length-1], path);
            Menu menu = new Menu().setId(localId).setName(deptTree.getName()).setParentId(parentId)
                    .setPath(path).setCode(deptTree.getCode()).setOriginId(deptTree.getId());

            resultList.add(menu);

            if (CollectionUtils.isNotEmpty(deptTree.getChildren()))
                children.addAll(deptTree.getChildren());
        });
        return children;
    }

    // 递归
    private static void analysisDeptTreeListDG(List<DeptTree> deptTreeList, List<Menu> resultList, Map<String, String> pathStore) {
        if (CollectionUtils.isEmpty(deptTreeList))
            return;

        List<DeptTree> children = new ArrayList<>();

        deptTreeList.forEach(deptTree -> {
            String path, parentId;
            String localId = getIdStr();

            String originPath = deptTree.getPath();     //  获取部门树路径
            String[] pathCode = originPath.split("-");

            if (1 == deptTree.getLevel()) {
                parentId = "-1";
                path = "-1," + localId;
            } else {
                String upPath = pathStore.get(pathCode[pathCode.length-2]);
                String[] parentIds = upPath.split(",");
                path = upPath + "," + localId;
                parentId = parentIds[parentIds.length-1];
            }

            pathStore.put(pathCode[pathCode.length-1], path);
            Menu menu = new Menu().setId(localId).setName(deptTree.getName()).setParentId(parentId)
                    .setPath(path).setCode(deptTree.getCode()).setOriginId(deptTree.getId());

            resultList.add(menu);

            if (CollectionUtils.isNotEmpty(deptTree.getChildren()))
                children.addAll(deptTree.getChildren());
        });

        analysisDeptTreeListDG(children, resultList, pathStore);
    }

}
