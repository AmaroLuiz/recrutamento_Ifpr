package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlunoTecnologiaIdEntity implements Serializable {

    private Long alunoId;
    private Long tecnologiaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlunoTecnologiaIdEntity)) return false;
        AlunoTecnologiaIdEntity that = (AlunoTecnologiaIdEntity) o;
        return Objects.equals(alunoId, that.alunoId) &&
                Objects.equals(tecnologiaId, that.tecnologiaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoId, tecnologiaId);
    }
}