package com.jovi.magic.entity;

import javax.persistence.Basic;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author fanjiawei
 * @date Created on 2018/11/26
 */
public class PersonBaseArchives {

    /**
     * 外键，人员基本信息ID
     */
    @Basic
    private Long personId;

    /**
     * 外键，标准地址BaseID
     */
    @Basic
    private Long baseId;

    /**
     * 猎鹰系统中该人员的objId,标记该人员是否已经录入到猎鹰库里
     */
    @Basic
    private String objId;

    /**
     * 状态
     */
    @Basic
    private String status;
}
