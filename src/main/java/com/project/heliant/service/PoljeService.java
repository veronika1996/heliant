package com.project.heliant.service;

import com.project.heliant.dto.Polje;

import java.util.List;

public interface PoljeService {
	Polje kreirajPolje(Polje polje);

	List<Polje> dobaviSvaPolja();

	Polje dobaviPolje(int id);

	Polje azurirajPolje(int id, Polje poljeDetails);

	void obrisiPolje(int id);
}