package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "certificado")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false)
    private Aluno aluno;

    @Column(name = "nome_certificado", length = 150, nullable = false)
    private String nomeCertificado;

    @Column(name = "instituicao", length = 150)
    private String instituicao;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    @Lob
    @Column(name = "arquivo_pdf", nullable = false)
    private String arquivoPDF;


}

