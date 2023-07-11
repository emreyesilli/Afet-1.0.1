package com.yardimcepte.afet.services;

import com.yardimcepte.afet.dto.request.AdresEkleRequest;
import com.yardimcepte.afet.dto.request.AdresGuncelleRequest;
import com.yardimcepte.afet.dto.response.AdresResponse;
import com.yardimcepte.afet.exception.ErrorResponse;
import com.yardimcepte.afet.exception.ModelNotFoundException;
import com.yardimcepte.afet.model.Adres;
import com.yardimcepte.afet.repository.AdresRepository;
import com.yardimcepte.afet.util.mapper.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdresService {
    private final AdresRepository adresRepository;
    private final ModelMapperService modelMapperService;

    public AdresService(AdresRepository adresRepository, ModelMapperService modelMapperService) {
        this.adresRepository = adresRepository;
        this.modelMapperService = modelMapperService;
    }

    public AdresResponse addAdres(AdresEkleRequest adresEkleRequest) {
        Adres addedAdres = modelMapperService.forRequest().map(adresEkleRequest, Adres.class);
        adresRepository.save(addedAdres);
        return modelMapperService.forDto().map(addedAdres, AdresResponse.class);
    }

    public List<AdresResponse> getAllAdres() {
        List<Adres> adresList = adresRepository.findAll();
        return adresList.stream().map(k -> modelMapperService.forDto().map(k, AdresResponse.class)).collect(Collectors.toList());
    }

    public AdresResponse adresGuncelle(AdresGuncelleRequest adresGuncelleRequest) {
        adresRepository.findById(adresGuncelleRequest.getId()).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "Adres bulunamadı!")));
        Adres adres = modelMapperService.forRequest().map(adresGuncelleRequest, Adres.class);
        adresRepository.save(adres);
        return modelMapperService.forRequest().map(adres, AdresResponse.class);
    }

    public AdresResponse adresSil(Long id) {
        Adres adres = adresRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "Adres bulunamadı!")));
        adresRepository.delete(adres);
        return modelMapperService.forRequest().map(adres, AdresResponse.class);
    }

}
