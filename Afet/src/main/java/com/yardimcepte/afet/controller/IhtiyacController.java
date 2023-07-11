package com.yardimcepte.afet.controller;

import com.yardimcepte.afet.dto.request.IhtiyacEkleRequest;
import com.yardimcepte.afet.dto.request.IhtiyacGuncelleRequest;
import com.yardimcepte.afet.services.IhtiyacService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/afet/ihtiyac")
public class IhtiyacController {
    private final IhtiyacService ihtiyacService;

    public IhtiyacController(IhtiyacService ihtiyacService) {
        this.ihtiyacService = ihtiyacService;
    }

    @PostMapping
    public ResponseEntity<?> addIhtiyac(@Valid @RequestBody IhtiyacEkleRequest ihtiyacEkleRequest) {
        return ResponseEntity.ok(ihtiyacService.addIhtiyac(ihtiyacEkleRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllIhtiyac() {
        return ResponseEntity.ok(ihtiyacService.getAllIhtiyac());
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody IhtiyacGuncelleRequest ihtiyacGuncelleRequest) {
        return ResponseEntity.ok(ihtiyacService.ihtiyacGuncelle(ihtiyacGuncelleRequest));
    }

    @DeleteMapping("/{ihtiyacId}")
    public ResponseEntity<?> deleteUser(@PathVariable long ihtiyacId) {
        return ResponseEntity.ok(ihtiyacService.ihtiyacSil(ihtiyacId));
    }
}
