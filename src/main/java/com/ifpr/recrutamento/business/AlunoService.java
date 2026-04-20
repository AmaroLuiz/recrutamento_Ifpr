package com.ifpr.recrutamento.business;

import com.ifpr.recrutamento.business.dto.AlunoDTO;
import com.ifpr.recrutamento.business.dto.ProfessorDTO;
import com.ifpr.recrutamento.business.mapper.AlunoConverter;
import com.ifpr.recrutamento.business.mapper.ProfessorConverter;
import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import com.ifpr.recrutamento.infraestructure.exceptions.ConflictException;
import com.ifpr.recrutamento.infraestructure.exceptions.ResourceNotFoundException;
import com.ifpr.recrutamento.infraestructure.repository.AlunoRepository;
import com.ifpr.recrutamento.infraestructure.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoConverter alunoConverter;

    public AlunoDTO salvaAluno(AlunoDTO alunoDTO){
        emailExist(alunoDTO.getEmailInstitucional());
        AlunoEntity alunoEntity = alunoConverter.paraAluno(alunoDTO);
        return alunoConverter.paraAlunoDTO(
                alunoRepository.save(alunoEntity)
        );
    }

    public void emailExist(String email){
        try {
            boolean exist = verificaEmailExistente(email);
            if(exist){
                throw new ConflictException("Email já cadastrado" + email);
            }

        } catch (ConflictException e) {
            throw new RuntimeException("Email não encontrado", e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return alunoRepository.existsByEmailInstitucional(email);
    }

    public AlunoDTO buscarAlunoPorEmail(String email){
        try {
            return alunoConverter.paraAlunoDTO(
                    alunoRepository.findByEmailInstitucional(email)
                            .orElseThrow(
                    () -> new ResourceNotFoundException("Email não encontrado" + email)
                    )
            );
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("email não encontrado" + email);
        }
    }
}
