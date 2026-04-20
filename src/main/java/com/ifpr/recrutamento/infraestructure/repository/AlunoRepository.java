package com.ifpr.recrutamento.infraestructure.repository;

import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    boolean existsByEmailInstitucional(String email);

    Optional<AlunoEntity> findByEmailInstitucional(String emailInstitucional);
}
