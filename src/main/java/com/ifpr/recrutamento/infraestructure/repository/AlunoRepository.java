package com.ifpr.recrutamento.infraestructure.repository;

import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    boolean existsByEmailInstitucional(String email);

    @Override
    boolean existsById(Long id);

    Optional<AlunoEntity> findByEmailInstitucional(String emailInstitucional);

    Optional<AlunoEntity> findById(Long id);

    @Transactional
    void deleteByEmailInstitucional(String email);
}
