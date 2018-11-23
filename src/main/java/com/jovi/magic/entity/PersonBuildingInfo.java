package com.jovi.magic.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author fanjiawei
 * @date Created on 2018/11/22
 */
@Entity
@Data
@Table(name = "person_building_info")
@EntityListeners(AuditingEntityListener.class)
public class PersonBuildingInfo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @CreatedDate
    @Column(name = "created_time")
    private Date createdTime;

    //@CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_time")
    private Date updatedTime;

    //@LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @Version
    @Column(name = "version")
    private Long version;

    /**
     * 外键，人员基本信息ID
     */
    @Column(name = "person_id")
    private Long personId;

    /**
     * 外键，房屋ID
     */
    @Column(name = "building_id")
    private Long buildingId;

    /**
     * 房间ID
     */
    @Column(name = "room_id")
    private Long roomId;

    /**
     * 居住类型
     */
    @Column(name = "live_type")
    private String liveType;

    /**
     * 入住时间
     */
    @Column(name = "live_date_from")
    private Date liveDateFrom;

    /**
     * 迁出时间
     */
    @Column(name = "live_date_to")
    private Date liveDateTo;

    /**
     * 关系状态
     */
    @Column(name = "relation_status")
    private String relationStatus;

    /**
     * 承租途径
     */
    @Column(name = "rent_way")
    private String rentWay;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 状态
     */
    @Column(name = "status")
    private String status;

    /**
     * 删除修改原因
     */
    @Column(name = "reason")
    private String reason;

    /**
     * 房产证或租赁合同保存路径
     */
    @Column(name = "certificate_image_url")
    private String certificateImageUrl;

    /**
     * 和房主关系
     */
    @Column(name = "relationship_with_homeowner")
    private String relationshipWithHomeowner;
}
