package com.project.heliant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "polje")
public class PoljeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 256)
	private String naziv;

	@Column(name = "prikazni_redosled", nullable = false)
	private int prikazniRedosled;

	@Enumerated(EnumType.STRING)
	private Tip tip;

	@CreationTimestamp
	@Column(name = "vreme_kreiranja")
	private LocalDateTime vremeKreiranja;

	@UpdateTimestamp
	@Column(name = "vreme_poslednje_izmene")
	private LocalDateTime vremePoslednjeIzmene;

}
