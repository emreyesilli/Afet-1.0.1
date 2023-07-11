package com.yardimcepte.afet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "yardim_tirlari")
public class YardimTiri extends BaseEntity {
	private String plaka;
	@OneToMany(mappedBy = "yardimTiri")
	private List<Adres> kalkisAdresleri;
	@OneToMany(mappedBy = "yardimTiri")
	private List<Adres> varisAdresleri;
	@OneToMany(mappedBy = "yardimTiri")
	private List<Urun> yuk;
}
