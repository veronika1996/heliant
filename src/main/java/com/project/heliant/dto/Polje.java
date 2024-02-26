package com.project.heliant.dto;

import com.project.heliant.entity.Tip;
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

	private String naziv;

	private int prikazniRedosled;

	private Tip tip;

}
