package com.ifpr.recrutamento.business.dto;

import com.ifpr.recrutamento.infraestructure.entity.CampusEntity;
import com.ifpr.recrutamento.infraestructure.entity.CertificadoEntity;
import com.ifpr.recrutamento.infraestructure.entity.CursoEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoDTO {

    private String nomeCompleto;
    private String emailInstitucional;
    private String senhaHash;
    private LocalDate dataNascimento;
    private CampusEntity campusEntity;
    private CursoEntity cursoEntity;
    private Boolean ativoNaInstituicao;
    private String linkGitHub;
    private String linkLinkedin;
    private Boolean indicadoPorProfessor;
    private Boolean ativoEmProjetos;
    private String curriculoPDF;
    private List<CertificadoDTO> certificado;

}
