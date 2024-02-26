package com.project.heliant.controller;

import com.project.heliant.dto.PoljePopunjeno;
import com.project.heliant.service.PoljePopunjenoService;
import jakarta.validation.Valid;
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
@RequestMapping("/api/polja-popunjena")
public class PoljePopunjenoController {

	private final PoljePopunjenoService poljePopunjenoService;

	public PoljePopunjenoController(PoljePopunjenoService poljePopunjenoService) {
		this.poljePopunjenoService = poljePopunjenoService;
	}

	@PostMapping
	public ResponseEntity<PoljePopunjeno> kreirajPoljePopunjeno(@Valid @RequestBody PoljePopunjeno poljePopunjeno) {
		PoljePopunjeno kreiranoPoljePopunjeno = poljePopunjenoService.kreirajPoljePopunjeno(poljePopunjeno);
		return ResponseEntity.ok().body(kreiranoPoljePopunjeno);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PoljePopunjeno> dobaviPoljePopunjeno(@PathVariable Integer id) {
		PoljePopunjeno poljePopunjeno = poljePopunjenoService.dobaviPoljePopunjeno(id);
		return ResponseEntity.ok().body(poljePopunjeno);
	}

	@GetMapping
	public ResponseEntity<List<PoljePopunjeno>> dobaviSvaPoljaPopunjena() {
		List<PoljePopunjeno> poljaPopunjena = poljePopunjenoService.dobaviSvaPoljaPopunjena();
		return ResponseEntity.ok().body(poljaPopunjena);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PoljePopunjeno> azurirajPoljePopunjeno(@PathVariable Integer id, @Valid @RequestBody PoljePopunjeno poljePopunjenoDetails) {
		PoljePopunjeno azuriranoPoljePopunjeno = poljePopunjenoService.azurirajPoljePopunjeno(id, poljePopunjenoDetails);
		return ResponseEntity.ok().body(azuriranoPoljePopunjeno);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> obrisiPoljePopunjeno(@PathVariable Integer id) {
		poljePopunjenoService.obrisiPoljePopunjeno(id);
		return ResponseEntity.ok().build();
	}
}
