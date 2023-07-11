package com.yardimcepte.afet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "adresler")
public class Adres extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "sehir_id")
	private Sehir sehir;
	private String text;
	@OneToMany(mappedBy = "adres")
	private List<Kisi> kisiler;
	@OneToMany(mappedBy = "adres")
	private List<Ihtiyac> ihtiyaclar;
	@ManyToOne
	@JoinColumn(name = "tir_id")
	private YardimTiri yardimTiri;
}
