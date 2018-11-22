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
@Table(name = "person_info")
@EntityListeners(AuditingEntityListener.class)
public class PersonInfo {

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
     * 姓名
     */
    @Column(name = "person_name")
    private String personName;

    /**
     * 身份证号
     */
    @Column(name = "identity_card")
    private String identityCard;

    /**
     * 性别
     */
    @Column(name = "person_gender")
    private String personGender;

    /**
     * 出生日期
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * 民族
     */
    @Column(name = "person_race")
    private String personRace;

    /**
     * 照片路径
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 身份证正面照片
     */
    @Column(name = "id_photo_front_url")
    private String idPhotoFrontUrl;

    /**
     * 身份证反面照片
     */
    @Column(name = "id_photo_back_url")
    private String idPhotoBackUrl;

    /**
     * 身份证地址
     */
    @Column(name = "identity_card_address")
    private String identityCardAddress;

    /**
     * 服兵役情况
     */
    @Column(name = "military_service_status")
    private String militaryServiceStatus;

    /**
     * 文化程度
     */
    @Column(name = "education_degree")
    private String educationDegree;

    /**
     * 婚姻状况
     */
    @Column(name = "marital_status")
    private String maritalStatus;

    /**
     * 政治面貌
     */
    @Column(name = "politics_status")
    private String politicsStatus;

    /**
     * 联系电话
     */
    @Column(name = "contact_no")
    private String contactNo;

    /**
     * 户籍地址
     */
    @Column(name = "domicile_place")
    private String domicilePlace;

    /**
     * 身份证有效日期
     */
    @Column(name = "identity_valid_date")
    private Date identityValidDate;

    /**
     * 别名
     */
    @Column(name = "alias")
    private String alias;

    /**
     * 曾用名
     */
    @Column(name = "former_name")
    private String formerName;

    /**
     * qq号
     */
    @Column(name = "qq_no")
    private String qqNo;

    /**
     * 交通工具
     */
    @Column(name = "transport_tool")
    private String transportTool;

    /**
     * 牌照号码
     */
    @Column(name = "license_plate_no")
    private String licensePlateNo;

    /**
     * 人员状态
     */
    @Column(name = "person_status")
    private String personStatus;

    /**
     * 审核状态
     */
    @Column(name = "audit_status")
    private String auditStatus;

    /**
     * 人员类型
     */
    @Column(name = "person_type")
    private String personType;

    /**
     * 籍贯信息ID
     */
    @Column(name = "native_place_id")
    private Long nativePlaceId;

    /**
     * 猎鹰系统中该人员的objId，标记该人员是否已经录入到猎鹰库里
     */
    @Column(name = "obj_id")
    private String objId;

    /**
     * 标识该人员是否更新过
     */
    @Column(name = "update_status")
    private String updateStatus;

    /**
     * 是否为工作人员
     */
    @Column(name = "staff_status")
    private String staffStatus;
}
