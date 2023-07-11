package com.yardimcepte.afet.services;

import com.yardimcepte.afet.repository.SehirRepository;
import org.springframework.stereotype.Service;

@Service
public class SehirService {
	private final SehirRepository sehirRepository;

	public SehirService(SehirRepository sehirRepository) {
		this.sehirRepository = sehirRepository;
	}
}
