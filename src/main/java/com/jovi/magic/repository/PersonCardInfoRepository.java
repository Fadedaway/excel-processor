package com.jovi.magic.repository;

import com.jovi.magic.entity.PersonCardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fanjiawei
 * @date Created on 2018/11/23
 */
@Repository
public interface PersonCardInfoRepository extends JpaRepository<PersonCardInfo, Long> {

    /**
     * 根据身份证信息查询与人员的关联信息
     * @param identityCard 身份证号码
     */
    PersonCardInfo findByCardNo(String identityCard);
}
