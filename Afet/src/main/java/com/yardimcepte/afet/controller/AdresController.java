package com.yardimcepte.afet.controller;

import com.yardimcepte.afet.dto.request.AdresEkleRequest;
import com.yardimcepte.afet.dto.request.AdresGuncelleRequest;
import com.yardimcepte.afet.services.AdresService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/afet/adres")
public class AdresController {
    private final AdresService adresService;

    public AdresController(AdresService adresService) {
        this.adresService = adresService;
    }

    @PostMapping
    public ResponseEntity<?> addAdres(@Valid @RequestBody AdresEkleRequest adresEkleRequest) {
        return ResponseEntity.ok(adresService.addAdres(adresEkleRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(adresService.getAllAdres());
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody AdresGuncelleRequest adresGuncelleRequest) {
        return ResponseEntity.ok(adresService.adresGuncelle(adresGuncelleRequest));
    }

    @DeleteMapping("/{adresId}")
    public ResponseEntity<?> deleteUser(@PathVariable long adresId) {
        return ResponseEntity.ok(adresService.adresSil(adresId));
    }
}
