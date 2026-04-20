package com.ifpr.recrutamento.business.mapper;


import com.ifpr.recrutamento.business.dto.AlunoDTO;
import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoConverter {

    AlunoEntity paraAluno(AlunoDTO alunoDTO);

    AlunoDTO paraAlunoDTO(AlunoEntity alunoDTO);

    AlunoDTO paraAlunoEntity(AlunoEntity entity);
}
