package com.ifpr.recrutamento.infraestructure.entity;

import com.ifpr.recrutamento.infraestructure.enums.NivelTecnologiaEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "aluno_tecnologia",
        uniqueConstraints = @UniqueConstraint(columnNames = {"aluno_id", "tecnologia_id"})
)
public class AlunoTecnologiaEntity {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoEntity alunoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tecnologia_id", nullable = false)
    private TecnologiaEntity tecnologiaId;


    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", nullable = false)
    private NivelTecnologiaEnum nivel;



}
