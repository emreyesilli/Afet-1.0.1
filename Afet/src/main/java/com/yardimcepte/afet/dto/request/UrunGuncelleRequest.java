package com.yardimcepte.afet.dto.request;

import lombok.Data;

@Data
public class UrunGuncelleRequest {
    private long id;
    private String urunAdi;
    private int ihtiyacId;
    private int yardimTiriId;
}
