package com.jovi.magic.repository;

import com.jovi.magic.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fanjiawei
 * @date Created on 2018/11/22
 */
@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {
}
