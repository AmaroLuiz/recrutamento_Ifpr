package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recomendacao")
public class RecomendacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false)
    private AlunoEntity alunoEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = false)
    private ProfessorEntity professorEntity;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private LocalDate data = LocalDate.now();

}
