package com.project.heliant.service.impl;

import com.project.heliant.dto.Formular;
import com.project.heliant.dto.PoljePopunjeno;
import com.project.heliant.entity.FormularEntity;
import com.project.heliant.entity.PoljePopunjenoEntity;
import com.project.heliant.repository.PoljePopunjenoRepository;
import com.project.heliant.service.PoljePopunjenoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PoljePopunjenoServiceImpl implements PoljePopunjenoService {
	private final PoljePopunjenoRepository poljePopunjenoRepository;
	private final ModelMapper modelMapper;

	public PoljePopunjenoServiceImpl(PoljePopunjenoRepository poljePopunjenoRepository, ModelMapper modelMapper) {
		this.poljePopunjenoRepository = poljePopunjenoRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PoljePopunjeno kreirajPoljePopunjeno(PoljePopunjeno poljePopunjeno) {
		PoljePopunjenoEntity poljePopunjenoEntity = modelMapper.map(poljePopunjeno, PoljePopunjenoEntity.class);
		return modelMapper.map(poljePopunjenoRepository.save(poljePopunjenoEntity), PoljePopunjeno.class);
	}

	@Override
	public List<PoljePopunjeno> dobaviSvaPoljaPopunjena() {
		return poljePopunjenoRepository.findAll()
									   .stream()
									   .map(poljePopunjenoEntity -> modelMapper.map(poljePopunjenoEntity, PoljePopunjeno.class))
									   .collect(
											   Collectors.toList());
	}

	@Override
	public PoljePopunjeno dobaviPoljePopunjeno(int id) {
		Optional<PoljePopunjenoEntity> poljePopunjenoEntity = poljePopunjenoRepository.findById(id);
		if(poljePopunjenoEntity.isEmpty()) {
			throw new EntityNotFoundException("Popunjeno polje sa id-em: " + id + " nije pronadjeno");
		}
		return modelMapper.map(poljePopunjenoEntity.get(), PoljePopunjeno.class);
	}

	@Override
	public PoljePopunjeno azurirajPoljePopunjeno(int id, PoljePopunjeno poljePopunjenoDetails) {
		Optional<PoljePopunjenoEntity> poljePopunjenoEntity = poljePopunjenoRepository.findById(id);
		if (poljePopunjenoEntity.isEmpty()) {
			throw new EntityNotFoundException("Popunjeno polje sa id-em: " + id + " nije pronadjeno");
		}
		PoljePopunjenoEntity poljeZaAzuriranje = modelMapper.map(poljePopunjenoDetails, PoljePopunjenoEntity.class);
		poljeZaAzuriranje.setId(id);
		return modelMapper.map(poljePopunjenoRepository.save(poljeZaAzuriranje), PoljePopunjeno.class);
	}

	@Override
	public void obrisiPoljePopunjeno(int id) {
		poljePopunjenoRepository.deleteById(id);
	}
}