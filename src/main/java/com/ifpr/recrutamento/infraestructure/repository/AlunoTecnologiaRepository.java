package com.ifpr.recrutamento.infraestructure.repository;

import com.ifpr.recrutamento.infraestructure.entity.AlunoTecnologiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoTecnologiaRepository extends JpaRepository<AlunoTecnologiaEntity, Long> {

    @Override
    Optional<AlunoTecnologiaEntity> findById(Long id);

    @Override
    boolean existsById(Long id);

    List<AlunoTecnologiaEntity> findByAlunoId_Id(Long alunoId);

    @Transactional
    void deleteById(Long id);
}
