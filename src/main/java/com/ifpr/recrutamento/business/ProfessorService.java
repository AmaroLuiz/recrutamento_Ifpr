package com.ifpr.recrutamento.business;

import com.ifpr.recrutamento.business.dto.AlunoDTO;
import com.ifpr.recrutamento.business.dto.ProfessorDTO;
import com.ifpr.recrutamento.business.mapper.ProfessorConverter;
import com.ifpr.recrutamento.infraestructure.entity.ProfessorEntity;
import com.ifpr.recrutamento.infraestructure.exceptions.ConflictException;
import com.ifpr.recrutamento.infraestructure.exceptions.ResourceNotFoundException;
import com.ifpr.recrutamento.infraestructure.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorConverter professorConverter;

    public ProfessorDTO salvaProfessor(ProfessorDTO professorDTO){
        emailExist(professorDTO.getEmailInstitucional());
        ProfessorEntity professorEntity = professorConverter.paraProfessor(professorDTO);
        return professorConverter.paraProfessorDTO(
                professorRepository.save(professorEntity)
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
        return professorRepository.existsByEmailInstitucional(email);
    }

    public ProfessorDTO buscarProfessorPorEmail(String email){
        try {
            return professorConverter.paraProfessorDTO(
                    professorRepository.findByEmailInstitucional(email)
                            .orElseThrow(
                                    () -> new ResourceNotFoundException("Email não encontrado" + email)
                            )
            );
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("email não encontrado" + email);
        }
    }
}
