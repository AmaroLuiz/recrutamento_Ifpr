package com.ifpr.recrutamento.business.dto;

import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import com.ifpr.recrutamento.infraestructure.entity.TecnologiaEntity;
import com.ifpr.recrutamento.infraestructure.enums.NivelTecnologiaEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoTecnologiaDTO {

    private Long id;
    private AlunoEntity alunoId;
    private TecnologiaEntity tecnologiaId;
    private NivelTecnologiaEnum nivel;

}
