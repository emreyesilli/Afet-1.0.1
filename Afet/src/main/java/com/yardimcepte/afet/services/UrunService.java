package com.yardimcepte.afet.services;

import com.yardimcepte.afet.dto.request.UrunEkleRequest;
import com.yardimcepte.afet.dto.request.UrunGuncelleRequest;
import com.yardimcepte.afet.dto.response.UrunResponse;
import com.yardimcepte.afet.exception.ErrorResponse;
import com.yardimcepte.afet.exception.ModelNotFoundException;
import com.yardimcepte.afet.model.Urun;
import com.yardimcepte.afet.repository.UrunRepository;
import com.yardimcepte.afet.util.mapper.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UrunService {
    private final UrunRepository urunRepository;
    private final ModelMapperService modelMapperService;

    public UrunService(UrunRepository urunRepository, ModelMapperService modelMapperService) {
        this.urunRepository = urunRepository;
        this.modelMapperService = modelMapperService;
    }

    public UrunResponse addUrun(UrunEkleRequest urunEkleRequest) {
        Urun addedUrun = modelMapperService.forRequest().map(urunEkleRequest, Urun.class);
        urunRepository.save(addedUrun);
        return modelMapperService.forDto().map(addedUrun, UrunResponse.class);
    }

    public List<UrunResponse> getAllUrun() {
        List<Urun> urunList = urunRepository.findAll();
        return urunList.stream().map(k -> modelMapperService.forDto().map(k, UrunResponse.class)).collect(Collectors.toList());
    }

    public UrunResponse urunGuncelle(UrunGuncelleRequest urunGuncelleRequest) {
        urunRepository.findById(urunGuncelleRequest.getId()).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "Ürün bulunamadı!")));
        Urun urun = modelMapperService.forRequest().map(urunGuncelleRequest, Urun.class);
        urunRepository.save(urun);
        return modelMapperService.forRequest().map(urun, UrunResponse.class);
    }

    public UrunResponse urunSil(Long id) {
        Urun urun = urunRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "Ürün bulunamadı!")));
        urunRepository.delete(urun);
        return modelMapperService.forRequest().map(urun, UrunResponse.class);
    }

}
