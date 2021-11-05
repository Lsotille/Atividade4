package com.repository;

import com.entity.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partidos, Long> {

    List<Partidos> findByIdeologia(String ideologia);

}
