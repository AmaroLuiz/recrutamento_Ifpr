package com.ifpr.recrutamento.controller;


import com.ifpr.recrutamento.business.ProfessorService;
import com.ifpr.recrutamento.business.dto.ProfessorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")

public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> salvaUsuario(@RequestBody ProfessorDTO professorDTO){
        return ResponseEntity.ok(professorService.salvaProfessor(professorDTO));
    }

    @PostMapping("/login")


    @GetMapping
    public ResponseEntity<ProfessorDTO> buscarProfessorPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(professorService.buscarProfessorPorEmail(email));
    }
}
