package com.ifpr.recrutamento.controller;

import com.ifpr.recrutamento.business.AlunoService;
import com.ifpr.recrutamento.business.dto.AlunoDTO;
import com.ifpr.recrutamento.business.dto.ProfessorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")

public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTO> salvaUsuario(@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.ok(alunoService.salvaAluno(alunoDTO));
    }

    @GetMapping
    public ResponseEntity<AlunoDTO> buscarAlunoPorEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(alunoService.buscarAlunoPorEmail(email));
    }

}
