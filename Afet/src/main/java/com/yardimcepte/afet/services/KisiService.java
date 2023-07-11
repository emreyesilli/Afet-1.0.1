package com.yardimcepte.afet.services;

import com.yardimcepte.afet.dto.request.KisiEkleRequest;
import com.yardimcepte.afet.dto.request.KisiGuncelleRequest;
import com.yardimcepte.afet.dto.response.KisiResponse;
import com.yardimcepte.afet.exception.ErrorResponse;
import com.yardimcepte.afet.exception.ModelNotFoundException;
import com.yardimcepte.afet.exception.ModelUniqueException;
import com.yardimcepte.afet.model.Kisi;
import com.yardimcepte.afet.model.enums.CinsiyetEnum;
import com.yardimcepte.afet.model.enums.KisiDurumEnum;
import com.yardimcepte.afet.repository.KisiRepository;
import com.yardimcepte.afet.util.mapper.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KisiService {
    private final KisiRepository kisiRepository;
    private final ModelMapperService modelMapperService;

    public KisiService(KisiRepository kisiRepository, ModelMapperService modelMapperService) {
        this.kisiRepository = kisiRepository;
        this.modelMapperService = modelMapperService;
    }

    public KisiResponse addUser(KisiEkleRequest kisiEkleRequest) {
        Kisi addedUser = modelMapperService.forRequest().map(kisiEkleRequest, Kisi.class);
        if (checkIfTcNoExist(addedUser.getTcNo())) {
            kisiRepository.save(addedUser);
            return modelMapperService.forDto().map(addedUser, KisiResponse.class);
        } else {
            throw new ModelUniqueException(new ErrorResponse(false, "Aynı tc ile kayıtlı kullanıcı var"));
        }
    }

    public List<KisiResponse> getAllKisi() {
        List<Kisi> kisiList = kisiRepository.findAll();
        List<KisiResponse> liste = kisiList.stream().map(k -> modelMapperService.forDto().map(k, KisiResponse.class)).collect(Collectors.toList());
        return convertEnumToStringFromList(liste);
    }

    public KisiResponse kisiGuncelle(KisiGuncelleRequest kisiGuncelleRequest) {
        kisiRepository.findById(kisiGuncelleRequest.getId()).orElseThrow(
                () -> new ModelNotFoundException(new ErrorResponse(false, "Kullanıcı bulunamadı!")));
        Kisi kisiDto = modelMapperService.forRequest().map(kisiGuncelleRequest, Kisi.class);
        kisiRepository.save(kisiDto);
        KisiResponse kisiRes = modelMapperService.forDto().map(kisiDto, KisiResponse.class);
        return convertEnumToString(kisiRes);
    }

    public KisiResponse kisiSil(Long id) {
        Kisi kisi = kisiRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "Kullanıcı bulunamadı!")));
        kisiRepository.delete(kisi);
        KisiResponse kisiDto = modelMapperService.forRequest().map(kisi, KisiResponse.class);
        return convertEnumToString(kisiDto);
    }

    public List<KisiResponse> iyiDurumdakileriGetir() {
        List<Kisi> kisiList = kisiRepository.getKisisByDurum(0);
        List<KisiResponse> liste = kisiList.stream().map(k -> modelMapperService.forDto().map(k, KisiResponse.class)).collect(Collectors.toList());
        return convertEnumToStringFromList(liste);
    }

    public List<KisiResponse> kayiplariGetir() {
        List<Kisi> kisiList = kisiRepository.getKisisByDurum(1);
        List<KisiResponse> liste = kisiList.stream().map(k -> modelMapperService.forDto().map(k, KisiResponse.class)).collect(Collectors.toList());
        return convertEnumToStringFromList(liste);
    }

    private List<KisiResponse> convertEnumToStringFromList(List<KisiResponse> list) {
        for (KisiResponse res : list) {
            res.setDurum(KisiDurumEnum.getLabelById(Integer.parseInt(res.getDurum())));
            res.setCinsiyet(CinsiyetEnum.getLabelById(Integer.parseInt(res.getCinsiyet())));
        }
        return list;
    }

    private KisiResponse convertEnumToString(KisiResponse kisi) {
        kisi.setDurum(KisiDurumEnum.getLabelById(Integer.parseInt(kisi.getDurum())));
        kisi.setCinsiyet(CinsiyetEnum.getLabelById(Integer.parseInt(kisi.getCinsiyet())));
        return kisi;
    }

    private boolean checkIfTcNoExist(String tcNo) {
        Kisi kisi = kisiRepository.getKisiByTcNo(tcNo);
        return kisi == null;
    }
}
