package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlunoTipoVagaIdEntity implements Serializable {

    private Long alunoId;
    private Long tipoVagaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlunoTipoVagaIdEntity)) return false;
        AlunoTipoVagaIdEntity that = (AlunoTipoVagaIdEntity) o;
        return Objects.equals(alunoId, that.alunoId) &&
                Objects.equals(tipoVagaId, that.tipoVagaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoId, tipoVagaId);
    }
}