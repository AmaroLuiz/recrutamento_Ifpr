package com.ifpr.recrutamento.business.dto;

import com.ifpr.recrutamento.infraestructure.entity.CampusEntity;
import com.ifpr.recrutamento.infraestructure.enums.AreaAtuacaoEnums;
import com.ifpr.recrutamento.infraestructure.enums.CargoEnums;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {

    private String nomeCompleto;
    private String senhaHash;
    private String emailInstitucional;
    private LocalDate dataNascimento;
    private AreaAtuacaoEnums areaAtuacao;
    private CampusEntity campus;
    private CargoEnums cargo;

}
