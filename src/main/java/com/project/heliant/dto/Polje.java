package com.project.heliant.dto;

import com.project.heliant.entity.Tip;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Polje {

	private int id;
	@NotNull(message = "Naziv je obavezno polje za polje")
	private String naziv;
	private int prikazniRedosled;
	@NotNull(message = "Tip je obavezno polje za polje")
	private Tip tip;

}
