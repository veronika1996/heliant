package com.project.heliant.controller;

import com.project.heliant.dto.FormularPopunjen;
import com.project.heliant.service.FormularPopunjenService;
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
@RequestMapping("/api/formulari-popunjeni")
public class FormularPopunjenController {
	private final FormularPopunjenService formularPopunjenService;

	public FormularPopunjenController(FormularPopunjenService formularPopunjenService) {
		this.formularPopunjenService = formularPopunjenService;
	}

	@PostMapping
	public ResponseEntity<FormularPopunjen> kreirajFormularPopunjen(@Valid @RequestBody FormularPopunjen formularPopunjen) {
		FormularPopunjen kreiraniFormularPopunjen = formularPopunjenService.kreirajFormularPopunjen(formularPopunjen);
		return ResponseEntity.ok().body(kreiraniFormularPopunjen);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FormularPopunjen> dobaviFormularPopunjen(@PathVariable Integer id) {
		FormularPopunjen formularPopunjen = formularPopunjenService.dobaviFormularPopunjen(id);
		return ResponseEntity.ok().body(formularPopunjen);
	}

	@GetMapping
	public ResponseEntity<List<FormularPopunjen>> dobaviSveFormularePopunjene() {
		List<FormularPopunjen> formulariPopunjeni = formularPopunjenService.dobaviSveFormularePopunjene();
		return ResponseEntity.ok().body(formulariPopunjeni);
	}

	@PutMapping("/{id}")
	public ResponseEntity<FormularPopunjen> azurirajFormularPopunjen(@PathVariable Integer id, @Valid @RequestBody FormularPopunjen formularPopunjenDetails) {
		FormularPopunjen azuriraniFormularPopunjen = formularPopunjenService.azurirajFormularPopunjen(id, formularPopunjenDetails);
		return ResponseEntity.ok().body(azuriraniFormularPopunjen);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> obrisiFormularPopunjen(@PathVariable Integer id) {
		formularPopunjenService.obrisiFormularPopunjen(id);
		return ResponseEntity.ok().build();
	}
}