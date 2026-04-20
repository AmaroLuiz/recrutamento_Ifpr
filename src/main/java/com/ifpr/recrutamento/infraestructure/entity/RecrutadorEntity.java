package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recrutador")
public class RecrutadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", length = 150, nullable = false )
    private String nomeCompleto;

    @Column(name = "senha_hash", nullable = false)
    private String senhaHash;

    @Column(name = "email_recrutador", length = 150, nullable = false, unique = true)
    private String emailRecrutador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id",referencedColumnName = "id",nullable = false)
    private EmpresaEntity empresaEntity;


}
