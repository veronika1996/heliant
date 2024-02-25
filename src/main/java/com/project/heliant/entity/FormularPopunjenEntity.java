package com.project.heliant.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formular_popunjen")
public class FormularPopunjenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_formular_popunjen", referencedColumnName = "id")
	private List<PoljePopunjenoEntity> popunjenaPolja;

	@CreationTimestamp
	@Column(name = "vreme_kreiranja", nullable = false)
	private Date vremeKreiranja;

	@UpdateTimestamp
	@Column(name = "vreme_poslednje_izmene")
	private Date vremePoslednjeIzmene;

}