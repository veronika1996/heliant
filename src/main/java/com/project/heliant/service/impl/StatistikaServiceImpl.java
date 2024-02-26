package com.project.heliant.service.impl;

import com.project.heliant.entity.StatistikaEntity;
import com.project.heliant.repository.StatistikaRepository;
import com.project.heliant.service.FormularPopunjenService;
import com.project.heliant.service.StatistikaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class StatistikaServiceImpl implements StatistikaService {
	private final FormularPopunjenService formularPopunjenService;
	private final StatistikaRepository statistikaRepository;

	public StatistikaServiceImpl(FormularPopunjenService formularPopunjenService, StatistikaRepository statistikaRepository) {
		this.formularPopunjenService = formularPopunjenService;
		this.statistikaRepository = statistikaRepository;
	}

	@Scheduled(cron = "0 0 0 * * *") // Ponoć svakog dana
	public void azurirajStatistiku() {
		LocalDateTime dan = LocalDateTime.now();

		int brojPopunjenihFormulara = formularPopunjenService.brojPopunjenihFormularaUdanu(dan);

		StatistikaEntity statistika = new StatistikaEntity();
		statistika.setDatum(LocalDate.now().minusDays(1L));
		statistika.setBrojPopunjenihFormulara(brojPopunjenihFormulara);

		statistikaRepository.save(statistika);
	}
}