package com.ifpr.recrutamento.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tecnologia")
public class TecnologiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false, unique = true)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private TipoTecnologiaEntity tipoTecnologiaEntity;



}
