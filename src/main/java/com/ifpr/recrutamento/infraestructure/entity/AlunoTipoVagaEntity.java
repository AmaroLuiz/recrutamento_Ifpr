package com.ifpr.recrutamento.infraestructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno_tipo_vaga")
public class AlunoTipoVagaEntity {

    @EmbeddedId
    private AlunoTipoVagaIdEntity id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoEntity alunoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tipoVagaId")
    @JoinColumn(name = "tipo_vaga_id", nullable = false)
    private TipoVagaEntity tipoVagaEntity;

}