package com.yardimcepte.afet.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class KisiEkleRequest {
    @NotNull
    @NotBlank
    private String isim;
    @NotNull
    @NotBlank
    private String soyad;
    @NotNull
    @NotBlank
    private String tcNo;
    @Min(-1)
    @Max(2)
    private int cinsiyet;
    private int yas;
    @Min(-1)
    @Max(2)
    private int durum;
    private long adresId;
}
