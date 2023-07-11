package com.yardimcepte.afet.services;

import com.yardimcepte.afet.dto.request.IhtiyacEkleRequest;
import com.yardimcepte.afet.dto.request.IhtiyacGuncelleRequest;
import com.yardimcepte.afet.dto.response.IhtiyacResponse;
import com.yardimcepte.afet.exception.ErrorResponse;
import com.yardimcepte.afet.exception.ModelNotFoundException;
import com.yardimcepte.afet.model.Ihtiyac;
import com.yardimcepte.afet.model.enums.AcilEnum;
import com.yardimcepte.afet.model.enums.KisiDurumEnum;
import com.yardimcepte.afet.repository.IhtiyacRepository;
import com.yardimcepte.afet.util.mapper.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IhtiyacService {
    private final IhtiyacRepository ihtiyacRepository;
    private final ModelMapperService modelMapperService;

    public IhtiyacService(IhtiyacRepository ihtiyacRepository, ModelMapperService modelMapperService) {
        this.ihtiyacRepository = ihtiyacRepository;
        this.modelMapperService = modelMapperService;
    }

    public IhtiyacResponse addIhtiyac(IhtiyacEkleRequest ihtiyacEkleRequest) {
        Ihtiyac ihtiyac = modelMapperService.forRequest().map(ihtiyacEkleRequest, Ihtiyac.class);
        ihtiyacRepository.save(ihtiyac);
        return modelMapperService.forDto().map(ihtiyac, IhtiyacResponse.class);
    }

    public List<IhtiyacResponse> getAllIhtiyac() {
        List<Ihtiyac> ihtiyacList = ihtiyacRepository.findAll();
        List<IhtiyacResponse> liste = ihtiyacList.stream().map(k -> modelMapperService.forDto().map(k, IhtiyacResponse.class)).collect(Collectors.toList());
        return convertEnumToStringFromList(liste);
    }

    public IhtiyacResponse ihtiyacGuncelle(IhtiyacGuncelleRequest ihtiyacGuncelleRequest) {
        ihtiyacRepository.findById(ihtiyacGuncelleRequest.getId()).orElseThrow(() -> new ModelNotFoundException(new ErrorResponse(false, "İhtiyaç bulunamadı!")));
        Ihtiyac ihtiyac = modelMapperService.forRequest().map(ihtiyacGuncelleRequest, Ihtiyac.class);
        ihtiyacRepository.save(ihtiyac);
        IhtiyacResponse kisiRes = modelMapperService.forDto().map(ihtiyac, IhtiyacResponse.class);
        return convertEnumToString(kisiRes);
    }

    public IhtiyacResponse ihtiyacSil(Long id) {
        Ihtiyac ihtiyac = ihtiyacRepository.findById(id).orElseThrow(() -> {
            throw new ModelNotFoundException(new ErrorResponse(false, "İhtiyaç bulunamadı!"));
        });
        ihtiyacRepository.delete(ihtiyac);
        IhtiyacResponse ihtiyacDto = modelMapperService.forRequest().map(ihtiyac, IhtiyacResponse.class);
        return convertEnumToString(ihtiyacDto);
    }


    private List<IhtiyacResponse> convertEnumToStringFromList(List<IhtiyacResponse> list) {
        List<IhtiyacResponse> returnList = new ArrayList<>();
        for (IhtiyacResponse res : list) {
            res.setAciliyet(AcilEnum.getLabelById(Integer.parseInt(res.getAciliyet())));
            returnList.add(res);
        }
        return returnList;
    }

    private IhtiyacResponse convertEnumToString(IhtiyacResponse ihtiyac) {
        ihtiyac.setAciliyet(KisiDurumEnum.getLabelById(Integer.parseInt(ihtiyac.getAciliyet())));
        return ihtiyac;
    }
}
