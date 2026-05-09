package com.ifpr.recrutamento.business.mapper;

import com.ifpr.recrutamento.business.dto.AlunoTecnologiaDTO;
import com.ifpr.recrutamento.business.dto.TecnologiaDTO;
import com.ifpr.recrutamento.infraestructure.entity.AlunoTecnologiaEntity;
import com.ifpr.recrutamento.infraestructure.entity.TecnologiaEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AlunoTecnologiaConverter {

    @Mapping(target = "alunoId", source = "alunoId")
    @Mapping(target = "tecnologiaId", source = "tecnologiaId")
    @Mapping(target = "nivel", source = "nivel")
    AlunoTecnologiaDTO paraTecnologiaDTO(AlunoTecnologiaEntity dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TecnologiaEntity updateTecnologia(TecnologiaDTO dto, @MappingTarget TecnologiaEntity entity);

}
