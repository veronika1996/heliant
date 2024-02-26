package com.project.heliant.service;



import com.project.heliant.dto.Formular;

import java.time.LocalDate;
import java.util.List;


public interface FormularService {
	Formular kreirajFormular(Formular formular);

	List<Formular> dobaviSveFormulare();

	Formular dobaviFormular(int id);

	Formular azurirajFormular(int id, Formular formularDetails);

	void obrisiFormular(int id);

}