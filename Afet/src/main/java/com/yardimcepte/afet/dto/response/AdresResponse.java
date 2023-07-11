package com.yardimcepte.afet.dto.response;

import lombok.Data;

@Data
public class AdresResponse {
    private String text;
    private String yardimTiriPlaka;
    private SehirResponse sehir;

}
