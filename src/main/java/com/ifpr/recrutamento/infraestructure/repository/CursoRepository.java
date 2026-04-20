package com.ifpr.recrutamento.infraestructure.repository;

import com.ifpr.recrutamento.infraestructure.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
}
