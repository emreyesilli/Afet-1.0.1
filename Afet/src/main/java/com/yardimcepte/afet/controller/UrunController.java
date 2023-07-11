package com.yardimcepte.afet.controller;

import com.yardimcepte.afet.dto.request.UrunEkleRequest;
import com.yardimcepte.afet.dto.request.UrunGuncelleRequest;
import com.yardimcepte.afet.services.UrunService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/afet/urun")
public class UrunController {
    private final UrunService urunService;

    public UrunController(UrunService urunService) {
        this.urunService = urunService;
    }

    @PostMapping
    public ResponseEntity<?> addUrun(@Valid @RequestBody UrunEkleRequest urunEkleRequest) {
        return ResponseEntity.ok(urunService.addUrun(urunEkleRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllUrun() {
        return ResponseEntity.ok(urunService.getAllUrun());
    }

    @PutMapping
    public ResponseEntity<?> urunGuncelle(@Valid @RequestBody UrunGuncelleRequest urunGuncelleRequest) {
        return ResponseEntity.ok(urunService.urunGuncelle(urunGuncelleRequest));
    }

    @DeleteMapping("/{urunId}")
    public ResponseEntity<?> urunSil(@PathVariable long urunId) {
        return ResponseEntity.ok(urunService.urunSil(urunId));
    }
}
