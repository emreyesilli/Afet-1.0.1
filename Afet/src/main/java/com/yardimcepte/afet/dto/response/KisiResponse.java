package com.yardimcepte.afet.dto.response;

import lombok.Data;

@Data
public class KisiResponse {
    private Long id;
    private String isim;
    private String soyad;
    private String tcNo;
    private String cinsiyet;
    private int yas;
    private String durum;
    private AdresResponse adres;
}
