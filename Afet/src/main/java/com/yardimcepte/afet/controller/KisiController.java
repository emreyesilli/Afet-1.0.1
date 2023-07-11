package com.yardimcepte.afet.controller;

import com.yardimcepte.afet.dto.request.KisiEkleRequest;
import com.yardimcepte.afet.dto.request.KisiGuncelleRequest;
import com.yardimcepte.afet.services.KisiService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/afet/kisi")

public class KisiController {
    private final KisiService kisiService;

    public KisiController(KisiService kisiService) {
        this.kisiService = kisiService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody KisiEkleRequest kisiEkleRequest) {
        return ResponseEntity.ok(kisiService.addUser(kisiEkleRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(kisiService.getAllKisi());
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody KisiGuncelleRequest kisiGuncelleRequest) {
        return ResponseEntity.ok(kisiService.kisiGuncelle(kisiGuncelleRequest));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable long userId) {
        return ResponseEntity.ok(kisiService.kisiSil(userId));
    }

    @GetMapping("iyigetir")
    public ResponseEntity<?> iyiDurumdakileriGetir() {
        return ResponseEntity.ok(kisiService.iyiDurumdakileriGetir());
    }

    @GetMapping("kayipgetir")
    public ResponseEntity<?> kayipDurumdakileriGetir() {
        return ResponseEntity.ok(kisiService.kayiplariGetir());
    }
}
