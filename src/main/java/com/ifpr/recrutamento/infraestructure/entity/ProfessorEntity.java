package com.ifpr.recrutamento.infraestructure.entity;

import com.ifpr.recrutamento.infraestructure.enums.AreaAtuacaoEnums;
import com.ifpr.recrutamento.infraestructure.enums.CargoEnums;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "professor")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "senha_hash", nullable = false)
    private String senhaHash;

    @Column(name = "email_institucional", unique = true, nullable = false)
    private String emailInstitucional;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "area_atuacao")
    private AreaAtuacaoEnums areaAtuacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id",referencedColumnName = "id", nullable = false)
    private CampusEntity campus;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private CargoEnums cargo;



}
