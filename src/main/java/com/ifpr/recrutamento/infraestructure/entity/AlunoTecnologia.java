package com.ifpr.recrutamento.infraestructure.entity;

import com.ifpr.recrutamento.infraestructure.enums.NivelTecnologiaEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno_tecnologia")
public class AlunoTecnologia {


    @EmbeddedId
    private AlunoTecnologiaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tecnologiaId")
    @JoinColumn(name = "tecnologia_id", nullable = false)
    private Tecnologia tecnologia;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", nullable = false)
    private NivelTecnologiaEnum nivel;

//Sem LAZY:
//Hibernate usa EAGER por padrão em ManyToOne
//Isso gera:
//carregamento desnecessário
//perda de performance
//possível efeito cascata em queries




}
