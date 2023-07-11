package com.yardimcepte.afet.services;

import com.yardimcepte.afet.dto.request.YardimTiriEkleRequest;
import com.yardimcepte.afet.dto.request.YardimTiriGuncelleRequest;
import com.yardimcepte.afet.dto.response.YardimTiriResponse;
import com.yardimcepte.afet.exception.ErrorResponse;
import com.yardimcepte.afet.exception.ModelNotFoundException;
import com.yardimcepte.afet.model.YardimTiri;
import com.yardimcepte.afet.repository.YardimTiriRepository;
import com.yardimcepte.afet.util.mapper.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YardimTiriService {
    private final YardimTiriRepository yardimTiriRepository;
    private final ModelMapperService modelMapperService;

    public YardimTiriService(YardimTiriRepository yardimTiriRepository, ModelMapperService modelMapperService) {
        this.yardimTiriRepository = yardimTiriRepository;
        this.modelMapperService = modelMapperService;
    }

    public YardimTiriResponse addYardimTiri(YardimTiriEkleRequest yardimTiriEkleRequestEkleRequest) {
        YardimTiri addedYardimTiri = modelMapperService.forRequest().map(yardimTiriEkleRequestEkleRequest, YardimTiri.class);
        yardimTiriRepository.save(addedYardimTiri);
        return modelMapperService.forDto().map(addedYardimTiri, YardimTiriResponse.class);
    }

    public List<YardimTiriResponse> getAllYardimTiri() {
        List<YardimTiri> urunList = yardimTiriRepository.findAll();
        return urunList.stream().map(k -> modelMapperService.forDto().map(k, YardimTiriResponse.class)).collect(Collectors.toList());
    }

    public YardimTiriResponse yardimTiriGuncelle(YardimTiriGuncelleRequest yardimTiriGuncelleRequest) {
        yardimTiriRepository.findById(yardimTiriGuncelleRequest.getId()).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "Yardim tırı bulunamadı!")));
        YardimTiri yardimTiri = modelMapperService.forRequest().map(yardimTiriGuncelleRequest, YardimTiri.class);
        yardimTiriRepository.save(yardimTiri);
        return modelMapperService.forRequest().map(yardimTiri, YardimTiriResponse.class);
    }

    public YardimTiriResponse yardimTiriSil(Long id) {
        YardimTiri yardimTiri = yardimTiriRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "Yardim tırı bulunamadı!")));
        yardimTiriRepository.delete(yardimTiri);
        return modelMapperService.forRequest().map(yardimTiri, YardimTiriResponse.class);
    }

}
