package com.project.heliant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "korisnik")
public class KorisnikEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "korisnicko_ime", length = 256, nullable = false)
	private String korisnickoIme;

	@Column(length = 256, nullable = false)
	private String lozinka;

	@CreationTimestamp
	@Column(name = "vreme_kreiranja")
	private LocalDateTime vremeKreiranja;

	@UpdateTimestamp
	@Column(name = "vreme_poslednje_izmene")
	private LocalDateTime vremePoslednjeIzmene;

}