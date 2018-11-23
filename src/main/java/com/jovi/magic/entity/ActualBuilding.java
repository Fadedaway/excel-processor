package com.jovi.magic.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author fanjiawei
 * @date Created on 2018/11/23
 */
@Entity
@Data
@Table(name = "actual_building")
@EntityListeners(AuditingEntityListener.class)
public class ActualBuilding {

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

    @Basic
    private String buildingCode;
    @Basic
    private BigDecimal buildingArea;
    /**
     * 房屋地址
     */
    @Basic
    private String buildingAddress;
    /**
     * 房屋结构
     */
    @Basic
    private String buildingStructure;
    /**
     * 房屋等级
     */
    @Basic
    private Integer buildingLevel;
    /**
     * 房屋类型
     */
    @Basic
    private String buildingType;
    /**
     * 房屋户型
     */
    @Basic
    private String buildingLayout;
    /**
     * 房屋用途
     */
    @Basic
    private String buildingUsage;
    /**
     * 登记日期
     */
    @Basic
    private Date registerDate;
    /**
     * 居住面积
     */
    @Basic
    private BigDecimal liveArea;
    /**
     * 居住间数
     */
    @Basic
    private Integer liveRoomNumber;
    /**
     * 所属分局
     */
    @Basic
    private String substation;
    /**
     * 所属分局代码
     */
    @Basic
    private String substationCode;
    /**
     * 所属派出所
     */
    @Basic
    private String policeStation;
    /**
     * 所属派出所代码
     */
    @Basic
    private String policeStationCode;
    /**
     * 所属社区
     */
    @Basic
    private String community;
    /**
     * 所属社区代码
     */
    @Basic
    private String communityCode;
    /**
     * 所属网格
     */
    @Basic
    private String grid;
    /**
     * 精确到号的标准地址id
     */
    @Basic
    private Long standardAddressBaseId;
    /**
     * 精确到栋的标准地址id
     */
    @Basic
    private Long standardAddressBuildId;
    /**
     * 楼栋号
     */
    @Basic
    private String buildingNo;
    /**
     * 居住人数
     */
    @Basic
    private Integer livePeopleNumber;
    /**
     * 室号
     */
    @Basic
    private String roomNo;
    /**
     * 房屋状态
     */
    @Basic
    private String status;
    /**
     * 单元
     */
    @Basic
    private String unitNo;

    @Basic
    private Long standardAddressId;

    /**
     * 单元表id
     */
    @Basic
    private Long  unitId;
    /**
     * 室号表id
     */
    @Basic
    private Long  roomNoId;
    /**
     * 房屋性质
     */
    @Basic
    private String buildingNature;
}
