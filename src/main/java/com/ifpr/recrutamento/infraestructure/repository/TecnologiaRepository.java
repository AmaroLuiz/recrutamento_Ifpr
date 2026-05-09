package com.ifpr.recrutamento.infraestructure.repository;

import com.ifpr.recrutamento.infraestructure.entity.TecnologiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TecnologiaRepository extends JpaRepository<TecnologiaEntity, Long> {

    @Override
    Optional<TecnologiaEntity> findById(Long id);
}
