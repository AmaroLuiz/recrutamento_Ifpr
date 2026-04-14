package com.ifpr.recrutamento.infraestructure.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "senha_hash", nullable = false)
    private String senhaHash;

    @Column(name = "nome_completo", length = 150, nullable = false)
    private String nomeCompleto;

    @Column(name = "email_institucional", length = 150, nullable = false, unique = true )
    private String emailInstitucional;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id", referencedColumnName = "id")
    private Campus campus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)
    private Curso curso;


    @Column(name = "ativo_na_instituicao", nullable = false)
    private Boolean ativoNaInstituicao;

    @URL
    @Column(name = "link_github", unique = true)
    private String linkGitHub;

    @URL
    @Column(name = "link_linkedin")
    private String linkLinkedin;

    @Column(name = "indicado_por_professor")
    private Boolean indicadoPorProfessor;

    @Column(name = "ativo_em_projetos")
    private Boolean ativoEmProjetos;

    @Lob
    @Column(name = "curriculo_pdf", columnDefinition = "TEXT")
    private String curriculoPDF;

    @PrePersist
    public void prePersist(){
        if (ativoNaInstituicao == null){
            ativoNaInstituicao = true;
        }
        if (indicadoPorProfessor == null){
            indicadoPorProfessor = false;
        }
        if (ativoEmProjetos == null){
            ativoEmProjetos = false;
        }
    }
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certificado> certificados = new ArrayList<>();




}
