package com.project.heliant.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "polje_popunjeno")
public class PoljePopunjenoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "vrednost_tekst", length = 256)
	private String vrednostTekst;

	@Column(name = "vrednost_broj")
	private Double vrednostBroj;

	@CreationTimestamp
	@Column(name = "vreme_kreiranja")
	private LocalDateTime vremeKreiranja;

	@UpdateTimestamp
	@Column(name = "vreme_poslednje_izmene")
	private LocalDateTime vremePoslednjeIzmene;

}