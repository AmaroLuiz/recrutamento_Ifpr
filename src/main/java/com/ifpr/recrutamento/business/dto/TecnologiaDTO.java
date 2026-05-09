package com.ifpr.recrutamento.business.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TecnologiaDTO {

    private Long id;
    private String nome;
    private Long tipoId;
}
