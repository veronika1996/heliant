package com.project.heliant.service;


import com.project.heliant.dto.PoljePopunjeno;

import java.util.List;

public interface PoljePopunjenoService {
	PoljePopunjeno kreirajPoljePopunjeno(PoljePopunjeno poljePopunjeno);

	List<PoljePopunjeno> dobaviSvaPoljaPopunjena();

	PoljePopunjeno dobaviPoljePopunjeno(int id);

	PoljePopunjeno azurirajPoljePopunjeno(int id, PoljePopunjeno poljePopunjenoDetails);

	void obrisiPoljePopunjeno(int id);
}
