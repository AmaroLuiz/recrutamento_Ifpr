package com.ifpr.recrutamento.controller;

import com.ifpr.recrutamento.business.AlunoService;
import com.ifpr.recrutamento.business.AlunoTecnologiaService;
import com.ifpr.recrutamento.business.dto.AlunoDTO;
import com.ifpr.recrutamento.business.dto.AlunoTecnologiaDTO;
import com.ifpr.recrutamento.infraestructure.entity.AlunoEntity;
import com.ifpr.recrutamento.infraestructure.entity.AlunoTecnologiaEntity;
import com.ifpr.recrutamento.infraestructure.repository.AlunoRepository;
import com.ifpr.recrutamento.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")

public class AlunoController {

    private final AlunoService alunoService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AlunoRepository alunoRepository;
    private final AlunoTecnologiaService alunoTecnologiaService;

    @PostMapping
    public ResponseEntity<AlunoDTO> salvaUsuario(@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.ok(alunoService.salvaAluno(alunoDTO));
    }

    @PostMapping("/login")
    public String login(@RequestBody AlunoDTO alunoDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        alunoDTO.getEmailInstitucional(),
                        alunoDTO.getSenhaHash())
        );

        AlunoEntity aluno = alunoRepository.findByEmailInstitucional(authentication.getName())
                .orElseThrow();

        return "Bearer " + jwtUtil.generateToken(aluno.getId());
    }

    @GetMapping
    public ResponseEntity<AlunoDTO> buscarAlunoPorEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(alunoService.buscarAlunoPorEmail(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaAlunoPorEmail(@PathVariable String email){
        alunoService.deletaAlunoPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<AlunoDTO> updateAluno(@RequestHeader("Authorization") String token,
                                                @RequestBody AlunoDTO dto){
        return ResponseEntity.ok(alunoService.atualizaDadosALuno(token, dto));
    }

//    @GetMapping("/debug-auth")
//    public ResponseEntity<String> debugAuth() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        System.out.println("NAME: " + auth.getName());
//        System.out.println("PRINCIPAL: " + auth.getPrincipal());
//        System.out.println("AUTHORITIES: " + auth.getAuthorities());
//
//        return ResponseEntity.ok("Check console");
//    }

    @PostMapping("/tecnologia")
    public ResponseEntity<AlunoTecnologiaDTO> salvaTecnologia(@RequestBody AlunoTecnologiaDTO alunoTecnologiaDTO){
        return ResponseEntity.ok(alunoTecnologiaService.salvaTecnologiaAluno(alunoTecnologiaDTO));
    }
    @GetMapping("/tecnologia")
    public ResponseEntity<AlunoTecnologiaDTO> pesquisaTecnologiaPorAluno(@RequestParam("id") Long id){
        return ResponseEntity.ok(alunoTecnologiaService.pesquisaTecnologiaPorAluno(id));
    }

    @GetMapping("/tecnologias")
    public ResponseEntity<List<AlunoTecnologiaDTO>> listarTecnologiasAluno() {
        return ResponseEntity.ok(alunoTecnologiaService.listarTecnologiasAluno());
    }

    @DeleteMapping("/tecnologia")
    public ResponseEntity<Void> apagarTecnologia(@RequestParam("id") Long id){
        alunoTecnologiaService.deletaTecnologiaPorId(id);
        return ResponseEntity.ok().build();
    }



}


