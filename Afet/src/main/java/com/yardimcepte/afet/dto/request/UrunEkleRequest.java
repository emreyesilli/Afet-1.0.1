package com.yardimcepte.afet.dto.request;

import lombok.Data;

@Data
public class UrunEkleRequest {
    private String urunAdi;
    private int ihtiyacId;
    private int yardimTiriId;
}
