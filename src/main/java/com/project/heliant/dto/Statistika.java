package com.project.heliant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistika {

	private int id;

	private LocalDate datum;

	private int brojPopunjenihFormulara;

}