package com.project.heliant.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Formular {

	private int id;
	@NotNull(message = "Naziv je obavezno polje za formular")
	private String naziv;
	private List<@Valid Polje> polja;;

}