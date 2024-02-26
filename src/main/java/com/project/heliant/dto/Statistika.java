package com.project.heliant.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistika {

	private int id;
	@NotNull(message = "Datum je obavezno polje za statistiku")
	private LocalDateTime datum;
	private int brojPopunjenihFormulara;

}