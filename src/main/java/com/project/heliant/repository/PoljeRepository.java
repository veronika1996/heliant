package com.project.heliant.repository;

import com.project.heliant.entity.PoljeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PoljeRepository extends JpaRepository<PoljeEntity, Integer> {

}
