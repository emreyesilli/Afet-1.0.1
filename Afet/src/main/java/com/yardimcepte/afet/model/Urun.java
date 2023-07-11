package com.yardimcepte.afet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "urunler")
@Data
public class Urun extends BaseEntity {
	private String urunAdi;
	@ManyToOne
	@JoinColumn(name = "ihtiyac_id")
	private Ihtiyac ihtiyac;
	@ManyToOne
	@JoinColumn(name = "tir_id")
	private YardimTiri yardimTiri;
}
