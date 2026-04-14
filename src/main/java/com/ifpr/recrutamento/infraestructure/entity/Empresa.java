package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "email_empresa", length = 150, nullable = false, unique = true)
    private String emailEmpresa;

    @Column(name = "senha_hash", columnDefinition = "TEXT", nullable = false)
    private String senhaHash;

    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "site")
    private String site;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "empresa")
    private Set<Recrutador> recrutadores;


}
