package com.project.heliant.service;

import com.project.heliant.dto.FormularPopunjen;

import java.util.List;


public interface FormularPopunjenService {
	FormularPopunjen kreirajFormularPopunjen(FormularPopunjen formularPopunjen);

	List<FormularPopunjen> dobaviSveFormularePopunjene();
	FormularPopunjen dobaviFormularPopunjen(int id);
	FormularPopunjen azurirajFormularPopunjen(int id, FormularPopunjen formularPopunjenDetails);
	void obrisiFormularPopunjen(int id);
}
