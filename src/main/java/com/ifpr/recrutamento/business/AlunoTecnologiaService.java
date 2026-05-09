package com.ifpr.recrutamento.business;

import com.ifpr.recrutamento.business.dto.AlunoTecnologiaDTO;
import com.ifpr.recrutamento.business.dto.TecnologiaDTO;
import com.ifpr.recrutamento.business.dto.TecnologiaResumoDTO;
import com.ifpr.recrutamento.business.mapper.AlunoTecnologiaConverter;
import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import com.ifpr.recrutamento.infraestructure.entity.AlunoTecnologiaEntity;
import com.ifpr.recrutamento.infraestructure.entity.TecnologiaEntity;
import com.ifpr.recrutamento.infraestructure.exceptions.ConflictException;
import com.ifpr.recrutamento.infraestructure.exceptions.ResourceNotFoundException;
import com.ifpr.recrutamento.infraestructure.repository.AlunoRepository;
import com.ifpr.recrutamento.infraestructure.repository.AlunoTecnologiaRepository;
import com.ifpr.recrutamento.infraestructure.repository.TecnologiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static java.lang.Long.parseLong;

@Service
@RequiredArgsConstructor
public class AlunoTecnologiaService {

    private final AlunoTecnologiaRepository alunoTecnologiaRepository;
    private final AlunoRepository alunoRepository;
    private final TecnologiaRepository tecnologiaRepository;
    private final AlunoTecnologiaConverter alunoTecnologiaConverter;

    public AlunoTecnologiaDTO salvaTecnologiaAluno( AlunoTecnologiaDTO dto ){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Long alunoId = Long.parseLong(auth.getName());

        AlunoEntity aluno = alunoRepository.findById(alunoId).orElseThrow(
                () -> new ResourceNotFoundException("Aluno não encontrado " + alunoId));

        Long id = dto.getTecnologia().getId();

        TecnologiaEntity tecnologia = tecnologiaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tecnologia não encontrada " + dto.getTecnologia()));

        AlunoTecnologiaEntity entity = AlunoTecnologiaEntity.builder()
                .alunoId(aluno)
                .tecnologiaId(tecnologia)
                .nivel(dto.getNivel())
                .build();

        AlunoTecnologiaEntity salvo = alunoTecnologiaRepository.save(entity);

        return alunoTecnologiaConverter.paraTecnologiaDTO(salvo);


    }

    public void idExiste(Long id){
        try {

            boolean exist = verificaIdExistente(id);

            if(exist){
                throw new ConflictException("Aluno já cadastrado");
            }

        } catch (Exception e) {
            throw new RuntimeException("Aluno não cadastrado");
        }
    }

    public boolean verificaIdExistente(Long id){
        return alunoRepository.existsById(id);
    }

}


