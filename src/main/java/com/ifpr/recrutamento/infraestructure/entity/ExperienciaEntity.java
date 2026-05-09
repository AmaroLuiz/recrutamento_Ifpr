package com.ifpr.recrutamento.infraestructure.entity;

import com.ifpr.recrutamento.infraestructure.enums.TipoExperienciaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "experiencia")
public class ExperienciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false)
    private AlunoEntity alunoEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoExperienciaEnum tipo;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "data_inicio")
    private LocalDate dataInicial;

    @Column(name = "data_fim")
    private LocalDate dataFinal;
}
