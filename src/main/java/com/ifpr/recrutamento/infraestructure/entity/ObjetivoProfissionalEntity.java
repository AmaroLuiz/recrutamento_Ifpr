package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "objetivo_profissional")
public class ObjetivoProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false, unique = true)
    private AlunoEntity alunoEntity;

    @Column(name = "faculdade_desejada", length = 150)
    private String faculdadeDesejada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_vaga_id", referencedColumnName = "id", nullable = false)
    private TipoVagaEntity tipoVagaEntity;

}
