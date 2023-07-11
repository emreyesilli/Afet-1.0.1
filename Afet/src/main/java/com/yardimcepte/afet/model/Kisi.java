package com.yardimcepte.afet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "kisiler")
@Data
public class Kisi extends BaseEntity {

	private String isim;
	private String soyad;
	private String tcNo;
	private int cinsiyet;
	private int yas;
	private int durum;
	@ManyToOne
	@JoinColumn(name = "adres_id")
	private Adres adres;
	@OneToMany(mappedBy = "kisi")
	private List<Ihtiyac> ihtiyaclar;
}
