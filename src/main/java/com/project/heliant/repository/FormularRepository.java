package com.project.heliant.repository;

import com.project.heliant.entity.FormularEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FormularRepository extends JpaRepository<FormularEntity, Integer> {

}
