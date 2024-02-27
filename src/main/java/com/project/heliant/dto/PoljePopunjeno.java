package com.project.heliant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PoljePopunjeno {

	private int id;
	private String vrednostTekst;
	private Double vrednostBroj;
	private int id_polja;
}