package com.project.heliant.controller;

import com.project.heliant.dto.Polje;
import com.project.heliant.service.PoljeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/polja")
public class PoljeController {

	private final PoljeService poljeService;

	public PoljeController(PoljeService poljeService) {
		this.poljeService = poljeService;
	}

	@PostMapping
	public ResponseEntity<Polje> kreirajPolje(@RequestBody Polje polje) {
		Polje kreiranoPolje = poljeService.kreirajPolje(polje);
		return ResponseEntity.ok().body(kreiranoPolje);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Polje> dobaviPolje(@PathVariable Integer id) {
		Polje polje = poljeService.dobaviPolje(id);
		return ResponseEntity.ok().body(polje);
	}

	@GetMapping
	public ResponseEntity<List<Polje>> dobaviSvaPolja() {
		List<Polje> polja = poljeService.dobaviSvaPolja();
		return ResponseEntity.ok().body(polja);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Polje> azurirajPolje(@PathVariable Integer id, @RequestBody Polje poljeDetails) {
		Polje azuriranoPolje = poljeService.azurirajPolje(id, poljeDetails);
		return ResponseEntity.ok().body(azuriranoPolje);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> obrisiPolje(@PathVariable Integer id) {
		poljeService.obrisiPolje(id);
		return ResponseEntity.ok().build();
	}
}