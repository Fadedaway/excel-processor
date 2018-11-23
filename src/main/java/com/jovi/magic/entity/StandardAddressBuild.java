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
@Table(name = "standard_address_build")
@EntityListeners(AuditingEntityListener.class)
public class StandardAddressBuild {

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
       * 标准地址基础ID
       */
     @Basic
     private Long standardAddressBaseId;
     /**
       * 经度
       */
     @Basic
     private BigDecimal longitude;
     /**
       * 纬度
       */
     @Basic
     private BigDecimal latitude;

     /**
      * 地理地貌信息
      */
     @Basic
     private String geoShapeInfo;
     /**
       * 标准地址名字
       */
     @Basic
     private String standardAddressName;
     /**
       * 楼栋
       */
     @Basic
     private String buildNo;
     /**
       * 创建者组织机构id
       */
     @Basic
     private Long creatorOrgId;

     /**
       * 状态
       */
     @Basic
     private String status = "A";

     public StandardAddressBuild(){

     }

     public StandardAddressBuild(Long standardAddressBaseId, String standardAddressName, String buildNo,BigDecimal longitude,BigDecimal latitude) {
          this.standardAddressBaseId = standardAddressBaseId;
          this.standardAddressName = standardAddressName;
          this.buildNo = buildNo;
          this.longitude = longitude;
          this.latitude = latitude;
     }

     public StandardAddressBuild(Long standardAddressBaseId, String standardAddressName, String buildNo,BigDecimal longitude,BigDecimal latitude ,String geoShapeInfo) {
          this.standardAddressBaseId = standardAddressBaseId;
          this.standardAddressName = standardAddressName;
          this.buildNo = buildNo;
          this.longitude = longitude;
          this.latitude = latitude;
          this.geoShapeInfo = geoShapeInfo;
     }
}
