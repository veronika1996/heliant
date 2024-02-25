package com.project.heliant.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formular")
public class FormularEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 256)
	private String naziv;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_formulara", referencedColumnName = "id")
	private List<PoljeEntity> polja;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_formulara", referencedColumnName = "id")
	private List<FormularPopunjenEntity> popunjeniFormulari;

	@CreationTimestamp
	@Column(name = "vreme_kreiranja")
	private LocalDateTime vremeKreiranja;

	@UpdateTimestamp
	@Column(name = "vreme_poslednje_izmene")
	private LocalDateTime vremePoslednjeIzmene;
}