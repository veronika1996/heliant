package com.project.heliant.service.impl;

import com.project.heliant.dto.Formular;
import com.project.heliant.dto.FormularPopunjen;
import com.project.heliant.entity.FormularEntity;
import com.project.heliant.entity.FormularPopunjenEntity;
import com.project.heliant.repository.FormularRepository;
import com.project.heliant.service.FormularService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FormularServiceImpl implements FormularService {
	private final FormularRepository formularRepository;
	private final ModelMapper modelMapper;

	public FormularServiceImpl(FormularRepository formularRepository, ModelMapper modelMapper) {
		this.formularRepository = formularRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Formular kreirajFormular(Formular formular) {
		FormularEntity formularEntity = modelMapper.map(formular, FormularEntity.class);
		return modelMapper.map(formularRepository.save(formularEntity), Formular.class);
	}

	@Override
	public List<Formular> dobaviSveFormulare() {
		return formularRepository.findAll().stream().map(formularEntity -> modelMapper.map(formularEntity, Formular.class)).collect(
				Collectors.toList());
	}
	@Override
	public Formular dobaviFormular(int id) {
		Optional<FormularEntity> formularEntity = formularRepository.findById(id);
		if(formularEntity.isEmpty()) {
			throw new EntityNotFoundException("Formular sa id-em: " + id + " nije pronadjen");
		}
		return modelMapper.map(formularEntity.get(), Formular.class);

	}

	@Override
	public Formular azurirajFormular(int id, Formular formularDetails) {
		Optional<FormularEntity> formularEntity = formularRepository.findById(id);
		if (formularEntity.isEmpty()) {
			throw new EntityNotFoundException("Formular sa id-em: " + id + " nije pronadjen");
		}
		FormularEntity formularZaAzuriranje = modelMapper.map(formularDetails, FormularEntity.class);
		formularZaAzuriranje.setId(id);
		return modelMapper.map(formularRepository.save(formularZaAzuriranje), Formular.class);
	}

	@Override
	public void obrisiFormular(int id) {
		formularRepository.deleteById(id);
	}

}
