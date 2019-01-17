package com.jovi.magic.repository;

import com.jovi.magic.entity.PersonBuildingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fanjiawei
 * @date Created on 2018/11/22
 */
@Repository
public interface PersonBuildingInfoRepository extends JpaRepository<PersonBuildingInfo, Long> {

    PersonBuildingInfo findByPersonIdAndBuildingId(Long id, Long buildingId);
}
