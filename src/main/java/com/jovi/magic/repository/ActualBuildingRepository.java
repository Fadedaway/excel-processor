package com.jovi.magic.repository;

import com.jovi.magic.entity.ActualBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fanjiawei
 * @date Created on 2018/11/23
 */
@Repository
public interface ActualBuildingRepository extends JpaRepository<ActualBuilding, Long> {
}
