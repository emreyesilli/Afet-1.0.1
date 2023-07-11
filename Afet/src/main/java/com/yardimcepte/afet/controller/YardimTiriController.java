package com.yardimcepte.afet.controller;

import com.yardimcepte.afet.dto.request.YardimTiriEkleRequest;
import com.yardimcepte.afet.dto.request.YardimTiriGuncelleRequest;
import com.yardimcepte.afet.services.YardimTiriService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/afet/yardimtiri")
public class YardimTiriController {
	private final YardimTiriService yardimTiriService;

	public YardimTiriController(YardimTiriService yardimTiriService) {
		this.yardimTiriService = yardimTiriService;
	}

	@PostMapping
	public ResponseEntity<?> addYardimTiri(@Valid @RequestBody YardimTiriEkleRequest yardimTiriEkleRequest) {
		return ResponseEntity.ok(yardimTiriService.addYardimTiri(yardimTiriEkleRequest));
	}

	@GetMapping
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.ok(yardimTiriService.getAllYardimTiri());
	}

	@PutMapping
	public ResponseEntity<?> yardimTiriGuncelle(@Valid @RequestBody YardimTiriGuncelleRequest yardimTiriGuncelleRequest) {
		return ResponseEntity.ok(yardimTiriService.yardimTiriGuncelle(yardimTiriGuncelleRequest));
	}

	@DeleteMapping("/{yardimTiriId}")
	public ResponseEntity<?> deleteUser(@PathVariable long yardimTiriId) {
		return ResponseEntity.ok(yardimTiriService.yardimTiriSil(yardimTiriId));
	}
}
