package com.ifpr.recrutamento.business;

import com.ifpr.recrutamento.business.dto.AlunoDTO;
import com.ifpr.recrutamento.business.mapper.AlunoConverter;
import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import com.ifpr.recrutamento.infraestructure.exceptions.ConflictException;
import com.ifpr.recrutamento.infraestructure.exceptions.ResourceNotFoundException;
import com.ifpr.recrutamento.infraestructure.repository.AlunoRepository;
import com.ifpr.recrutamento.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoConverter alunoConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public AlunoDTO salvaAluno(AlunoDTO alunoDTO){
        emailExist(alunoDTO.getEmailInstitucional());
        alunoDTO.setSenhaHash(passwordEncoder.encode(alunoDTO.getSenhaHash()));
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

    public void deletaAlunoPorEmail(String email){
        alunoRepository.deleteByEmailInstitucional(email);
    }

    public AlunoDTO atualizaDadosALuno(String token, AlunoDTO dto){

        String email = jwtUtil.extrairIdToken(token.substring(7));

        dto.setSenhaHash(dto.getSenhaHash() != null ? passwordEncoder.encode(dto.getSenhaHash()) : null);

        AlunoEntity alunoEntity = alunoRepository.findByEmailInstitucional(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado" + email));

        AlunoEntity aluno = alunoConverter.updateAluno(dto, alunoEntity);

        return alunoConverter.paraAlunoDTO(alunoRepository.save(aluno));
    }
}
