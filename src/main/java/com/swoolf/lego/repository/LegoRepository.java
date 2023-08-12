package com.swoolf.lego.repository;

import com.swoolf.lego.entity.LegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegoRepository extends JpaRepository<LegoEntity, Long> {
}
