package com.jovi.magic.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author fanjiawei
 * @date Created on 2018/11/23
 */
@Entity
@Data
@Table(name = "person_card_info")
@EntityListeners(AuditingEntityListener.class)
public class PersonCardInfo {

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
     * 卡类型
     */
    @Basic
    private String cardType;
    /**
     * 卡号
     */
    @Basic
    private String cardNo;
    /**
     * 卡id
     */
    @Basic
    private Long cardId;
    /**
     * 人员id
     */
    @Basic
    private Long personId;
    /**
     * 别名
     */
    @Basic
    private String alias;

    /**
     * 微信用户openid
     */
    @Basic
    private String openId;

    /**
     * 微信用户unionid
     */
    @Basic
    private String unionId;

}
