package com.ifpr.recrutamento.infraestructure.entity;

import com.ifpr.recrutamento.infraestructure.enums.EstadoEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "campus")
public class CampusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",length = 150, nullable = false)
    private String nome;

    @Column(name = "cidade",length = 150, nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 2, nullable = false)
    private EstadoEnum estado;

}
