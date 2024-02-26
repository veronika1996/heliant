package com.project.heliant.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Korisnik {

	private int id;
	@NotNull(message = "Korisnicko ime je obavezno polje za korisnika")
	private String korisnickoIme;
	@NotNull(message = "Lozinka obavezno polje za korisnika")
	private String lozinka;

}