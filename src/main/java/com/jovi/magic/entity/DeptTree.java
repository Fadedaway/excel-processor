package com.jovi.magic.entity;

import lombok.Data;

import java.util.List;

/**
 * @author fanjiawei
 * @date Created on 2019/1/18
 */
@Data
public class DeptTree {

    private String id;
    private String code;
    private String createDeptCode;
    private String createDeptName;
    private Long createTime;
    private String creatorCode;
    private String creatorName;
    private Integer level;
    private String name;
    private String path;
    private Integer sortIndex;
    private Integer status;
    private Long updateTime;
    private String updaterCode;
    private String updaterName;
    private List<DeptTree> children;
}
