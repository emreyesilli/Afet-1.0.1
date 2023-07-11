package com.yardimcepte.afet.dto.request;

import lombok.Data;

@Data
public class AdresEkleRequest {

    private Long sehirId;
    private String text;
    private Long yardimTiriId;
}
