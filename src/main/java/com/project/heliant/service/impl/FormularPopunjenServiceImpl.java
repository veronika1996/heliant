package com.project.heliant.service.impl;

import com.project.heliant.dto.FormularPopunjen;
import com.project.heliant.entity.FormularPopunjenEntity;
import com.project.heliant.repository.FormularPopunjenRepository;
import com.project.heliant.service.FormularPopunjenService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FormularPopunjenServiceImpl implements FormularPopunjenService {
	private final FormularPopunjenRepository formularPopunjenRepository;
	private final ModelMapper modelMapper;

	public FormularPopunjenServiceImpl(FormularPopunjenRepository formularPopunjenRepository, ModelMapper modelMapper) {
		this.formularPopunjenRepository = formularPopunjenRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public FormularPopunjen kreirajFormularPopunjen(FormularPopunjen formularPopunjen) {
		FormularPopunjenEntity formularPopunjenEntity = modelMapper.map(formularPopunjen, FormularPopunjenEntity.class);
		return modelMapper.map(formularPopunjenRepository.save(formularPopunjenEntity), FormularPopunjen.class);
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
}