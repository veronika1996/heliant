package com.project.heliant.repository;

import com.project.heliant.entity.FormularPopunjenEntity;
import org.modelmapper.internal.bytebuddy.build.RepeatedAnnotationPlugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FormularPopunjenRepository extends JpaRepository<FormularPopunjenEntity, Integer> {

}
