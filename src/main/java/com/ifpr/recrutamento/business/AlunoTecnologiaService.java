package com.ifpr.recrutamento.business;

import com.ifpr.recrutamento.business.dto.AlunoTecnologiaDTO;
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

import java.util.List;

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

    public AlunoTecnologiaDTO pesquisaTecnologiaPorAluno(Long id){
        try{
            return alunoTecnologiaConverter.paraTecnologiaDTO(
                    alunoTecnologiaRepository.findById(id).
                            orElseThrow(
                            () -> new ResourceNotFoundException("Tecnologia de aluno não encontrada" + id)));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Tecnologia de aluno não encontrada" + e);
        }

    }

    public void idAlunoExiste(Long id){
        try {

            boolean exist = verificaIdAlunoExistente(id);

            if(exist){
                throw new ConflictException("Aluno(a) já cadastrado");
            }

        } catch (Exception e) {
            throw new RuntimeException("Aluno(a) não cadastrado");
        }
    }

    public boolean verificaIdAlunoExistente(Long id){
        return alunoRepository.existsById(id);
    }

    public List<AlunoTecnologiaDTO> listarTecnologiasAluno() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Long alunoId = Long.parseLong(auth.getName());

        List<AlunoTecnologiaEntity> tecnologias = alunoTecnologiaRepository.findByAlunoId_Id(alunoId);

        return tecnologias.stream()
                .map(alunoTecnologiaConverter::paraTecnologiaDTO)
                .toList();
    }

    public void deletaTecnologiaPorId(Long id){
        alunoTecnologiaRepository.deleteById(id);
    }

}


