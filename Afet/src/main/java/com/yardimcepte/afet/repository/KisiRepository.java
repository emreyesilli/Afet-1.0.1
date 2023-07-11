package com.yardimcepte.afet.repository;

import com.yardimcepte.afet.model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KisiRepository extends JpaRepository<Kisi, Long> {
    List<Kisi> getKisisByDurum(int id);

    Kisi getKisiByTcNo(String tcNo);
}
