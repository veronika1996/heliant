package com.project.heliant.service;


import com.project.heliant.dto.Formular;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface FormularService {
	Formular kreirajFormular(Formular formular);

	List<Formular> dobaviSveFormulare();

	Page<Formular> dobaviSveFormulareSaPaginacijom(Pageable pageablea);

	Formular dobaviFormular(int id);

	Formular azurirajFormular(int id, Formular formularDetails);

	void obrisiFormular(int id);

}