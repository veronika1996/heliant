package com.project.heliant.service.impl;

import com.project.heliant.dto.FormularPopunjen;
import com.project.heliant.dto.PoljePopunjeno;
import com.project.heliant.entity.FormularEntity;
import com.project.heliant.entity.FormularPopunjenEntity;
import com.project.heliant.repository.FormularPopunjenRepository;
import com.project.heliant.repository.FormularRepository;
import com.project.heliant.repository.PoljePopunjenoRepository;
import com.project.heliant.service.FormularPopunjenService;
import com.project.heliant.service.PoljePopunjenoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FormularPopunjenServiceImpl implements FormularPopunjenService {
	private final FormularPopunjenRepository formularPopunjenRepository;
	private final ModelMapper modelMapper;

	private final FormularRepository formularRepository;

	private final PoljePopunjenoService poljePopunjenoService;

	public FormularPopunjenServiceImpl(FormularPopunjenRepository formularPopunjenRepository, ModelMapper modelMapper, FormularRepository formularRepository, PoljePopunjenoService poljePopunjenoService) {
		this.formularPopunjenRepository = formularPopunjenRepository;
		this.modelMapper = modelMapper;
		this.formularRepository = formularRepository;
        this.poljePopunjenoService = poljePopunjenoService;
    }

	@Override
	public FormularPopunjen kreirajFormularPopunjen(FormularPopunjen formularPopunjen) {
		Optional<FormularEntity> formularEntity = formularRepository.findById(formularPopunjen.getId_formulara());
		if(formularEntity.isPresent()) {
			List<PoljePopunjeno> poljaPopunjena = formularPopunjen.getPopunjenaPolja().stream().map(poljePopunjenoService::kreirajPoljePopunjeno).toList();
			FormularPopunjenEntity formularPopunjenEntity = modelMapper.map(formularPopunjen, FormularPopunjenEntity.class);
			FormularPopunjen formular =  modelMapper.map(formularPopunjenRepository.save(formularPopunjenEntity), FormularPopunjen.class);
			formular.setPopunjenaPolja(poljaPopunjena);
			return formular;
		}
		throw new EntityNotFoundException("Formular sa datim id-em ne postoji stoga ne moze biti popunjen");
	}

	@Override
	public List<FormularPopunjen> dobaviSveFormularePopunjene() {
		return formularPopunjenRepository.findAll()
										 .stream()
										 .map(entity -> modelMapper.map(entity, FormularPopunjen.class))
										 .collect(
												 Collectors.toList());
	}

	@Override
	public FormularPopunjen dobaviFormularPopunjen(int id) {
		Optional<FormularPopunjenEntity> formularPopunjenEntity = formularPopunjenRepository.findById(id);
		if(formularPopunjenEntity.isEmpty()) {
			throw new EntityNotFoundException("Popunjeni formular sa id-em: " + id + " nije pronadjen");
		}
		return modelMapper.map(formularPopunjenEntity.get(), FormularPopunjen.class);
	}

	@Override
	public FormularPopunjen azurirajFormularPopunjen(int id, FormularPopunjen formularPopunjenDetails) {
		Optional<FormularPopunjenEntity> formularPopunjenEntity = formularPopunjenRepository.findById(id);
		if (formularPopunjenEntity.isEmpty()) {
			throw new EntityNotFoundException("Popunjeni formular sa id-em: " + id + " nije pronadjen");
		}
		FormularPopunjenEntity formularZaAzuriranje = modelMapper.map(formularPopunjenDetails, FormularPopunjenEntity.class);
		formularZaAzuriranje.setId(id);
		return modelMapper.map(formularPopunjenRepository.save(formularZaAzuriranje), FormularPopunjen.class);
	}

	@Override
	public void obrisiFormularPopunjen(int id) {
		formularPopunjenRepository.deleteById(id);
	}

	@Override
	public int brojPopunjenihFormularaUdanu(LocalDateTime dan) {
		List<FormularPopunjenEntity> formulari = formularPopunjenRepository.findByVremeKreiranjaBetween(dan.minusDays(1L), dan);
		return formulari.size();
	}
}