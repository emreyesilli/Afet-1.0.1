package com.yardimcepte.afet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ihtiyaclar")
public class Ihtiyac extends BaseEntity {
    @OneToMany(mappedBy = "ihtiyac")
    private List<Urun> urunler;
    @ManyToOne
    @JoinColumn(name = "kisi_id")
    private Kisi kisi;
    @ManyToOne
    @JoinColumn(name = "adres_id")
    private Adres adres;
    private int sayi;
    private int aciliyet;
}
