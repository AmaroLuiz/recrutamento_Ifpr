package com.ifpr.recrutamento.infraestructure.repository;

import com.ifpr.recrutamento.infraestructure.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

    boolean existsByEmailInstitucional(String email);

    Optional<ProfessorEntity> findByEmailInstitucional(String emailInstitucional);
}
