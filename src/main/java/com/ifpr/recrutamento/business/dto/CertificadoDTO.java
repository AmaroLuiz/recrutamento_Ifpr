package com.ifpr.recrutamento.business.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificadoDTO {

    private String nomeCertificado;
    private String instituicao;
    private Integer cargaHoraria;
    private LocalDate dataConclusao;
    private String arquivoPDF;

}
