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
public class AlunoTipoVaga {

    @EmbeddedId
    private AlunoTipoVagaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tipoVagaId")
    @JoinColumn(name = "tipo_vaga_id", nullable = false)
    private TipoVaga tipoVaga;

}