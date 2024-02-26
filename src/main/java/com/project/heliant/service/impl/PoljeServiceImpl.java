package com.project.heliant.service.impl;

import com.project.heliant.dto.Polje;
import com.project.heliant.dto.PoljePopunjeno;
import com.project.heliant.entity.PoljeEntity;
import com.project.heliant.entity.PoljePopunjenoEntity;
import com.project.heliant.repository.PoljeRepository;
import com.project.heliant.service.PoljeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PoljeServiceImpl implements PoljeService {
	private final PoljeRepository poljeRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public PoljeServiceImpl(PoljeRepository poljeRepository, ModelMapper modelMapper) {
		this.poljeRepository = poljeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Polje kreirajPolje(Polje polje) {
		PoljeEntity poljeEntity = modelMapper.map(polje, PoljeEntity.class);
		return modelMapper.map(poljeRepository.save(poljeEntity), Polje.class);
	}

	@Override
	public List<Polje> dobaviSvaPolja() {
		return poljeRepository.findAll()
							  .stream()
							  .map(poljeEntity -> modelMapper.map(poljeEntity, Polje.class))
							  .collect(Collectors.toList());
	}

	@Override
	public Polje dobaviPolje(int id) {
		Optional<PoljeEntity> poljeEntity = poljeRepository.findById(id);
		if(poljeEntity.isEmpty()) {
			throw new EntityNotFoundException("Polje sa id-em: " + id + " nije pronadjeno");
		}
		return modelMapper.map(poljeEntity.get(), Polje.class);
	}

	@Override
	public Polje azurirajPolje(int id, Polje poljeDetails) {
		Optional<PoljeEntity> poljeEntity = poljeRepository.findById(id);
		if (poljeEntity.isEmpty()) {
			throw new EntityNotFoundException("Polje sa id-em: " + id + " nije pronadjeno");
		}
		PoljeEntity poljeZaAzuriranje = modelMapper.map(poljeDetails, PoljeEntity.class);
		poljeZaAzuriranje.setId(id);
		return modelMapper.map(poljeRepository.save(poljeZaAzuriranje), Polje.class);
	}

	@Override
	public void obrisiPolje(int id) {
		poljeRepository.deleteById(id);
	}
}