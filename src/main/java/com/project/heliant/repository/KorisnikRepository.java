package com.project.heliant.repository;

import com.project.heliant.entity.KorisnikEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<KorisnikEntity, Long> {

    Optional<KorisnikEntity> findByKorisnickoIme(String korisnickoIme);
}
