package com.project.heliant.controller;

import com.project.heliant.dto.Formular;
import com.project.heliant.service.FormularService;
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
@RequestMapping("/api/formulari")
public class FormularController {
	private final FormularService formularService;

	public FormularController(FormularService formularService) {
		this.formularService = formularService;
	}

	@PostMapping
	public ResponseEntity<Formular> kreirajFormular(@RequestBody Formular formular) {
		Formular kreiraniFormular = formularService.kreirajFormular(formular);
		return ResponseEntity.ok().body(kreiraniFormular);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Formular> dobaviFormular(@PathVariable Integer id) {
		Formular formular = formularService.dobaviFormular(id);
		return ResponseEntity.ok().body(formular);
	}

	@GetMapping
	public ResponseEntity<List<Formular>> dobaviSveFormulare() {
		List<Formular> formulari = formularService.dobaviSveFormulare();
		return ResponseEntity.ok().body(formulari);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Formular> azurirajFormular(@PathVariable Integer id, @RequestBody Formular formularDetails) {
		Formular azuriraniFormular = formularService.azurirajFormular(id, formularDetails);
		return ResponseEntity.ok().body(azuriraniFormular);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> obrisiFormular(@PathVariable Integer id) {
		formularService.obrisiFormular(id);
		return ResponseEntity.ok().build();
	}
}
