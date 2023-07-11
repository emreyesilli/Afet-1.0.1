package com.yardimcepte.afet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "sehirler")
public class Sehir extends BaseEntity {
	private Long id;
	private String sehirAdi;
	@OneToMany(mappedBy = "sehir")
	private List<Adres> adres;
}
