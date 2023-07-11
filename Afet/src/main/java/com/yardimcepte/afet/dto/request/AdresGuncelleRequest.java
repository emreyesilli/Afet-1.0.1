package com.yardimcepte.afet.dto.request;

import lombok.Data;

@Data
public class AdresGuncelleRequest {

    private Long id;
    private Long sehirId;
    private String text;
    private Long yardimTiriId;
}

