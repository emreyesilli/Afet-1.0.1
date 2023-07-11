package com.yardimcepte.afet.dto.response;

import lombok.Data;

@Data
public class IhtiyacResponse {
    private long id;
    private long kisiId;
    private long adresId;
    private int sayi;
    private String aciliyet;
}
