package com.yardimcepte.afet.dto.request;

import lombok.Data;

@Data
public class IhtiyacGuncelleRequest {
    private long id;
    private long kisiId;
    private long adresId;
    private int sayi;
    private int aciliyet;
}
