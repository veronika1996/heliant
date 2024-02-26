package com.project.heliant.repository;

import com.project.heliant.entity.FormularPopunjenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FormularPopunjenRepository extends JpaRepository<FormularPopunjenEntity, Integer> {

    List<FormularPopunjenEntity> findByVremeKreiranjaBetween(LocalDateTime localDateTime, LocalDateTime dan);
}
