package com.ifpr.recrutamento.business.mapper;

import com.ifpr.recrutamento.business.dto.ProfessorDTO;
import com.ifpr.recrutamento.infraestructure.entity.ProfessorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorConverter {

    ProfessorEntity paraProfessor(ProfessorDTO professorDTO);

    ProfessorDTO paraProfessorDTO(ProfessorEntity professorDTO);

    ProfessorDTO paraProfessorEntity(ProfessorEntity entity);
}
