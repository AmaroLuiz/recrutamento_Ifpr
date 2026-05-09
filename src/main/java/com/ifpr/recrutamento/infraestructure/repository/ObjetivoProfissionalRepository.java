package com.ifpr.recrutamento.infraestructure.repository;

import com.ifpr.recrutamento.infraestructure.entity.ObjetivoProfissionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoProfissionalRepository extends JpaRepository<ObjetivoProfissionalEntity, Long> {
}
