package com.ifpr.recrutamento.infraestructure.entity;

import com.ifpr.recrutamento.infraestructure.enums.EstadoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "campus",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "cidade", "estado" })
)
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",length = 2, nullable = false)
    private String nome;

    @Column(name = "cidade",length = 150, nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 2, nullable = false)
    private EstadoEnum estado;

}
