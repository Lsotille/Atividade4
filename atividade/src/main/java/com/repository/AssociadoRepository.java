package com.repository;
import com.entity.Associados;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssociadoRepository extends JpaRepository<Associados, Long>{

    List<Associados> findByCargo(String cargo);

}
