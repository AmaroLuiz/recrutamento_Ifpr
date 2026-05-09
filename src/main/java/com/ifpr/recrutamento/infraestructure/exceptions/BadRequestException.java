package com.ifpr.recrutamento.infraestructure.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String mensagem) {
        super(mensagem);
    }

    public BadRequestException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
