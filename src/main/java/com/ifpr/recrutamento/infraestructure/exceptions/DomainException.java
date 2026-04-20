package com.ifpr.recrutamento.infraestructure.exceptions;

public class DomainException extends RuntimeException {

    public DomainException(String mensagem) {
        super(mensagem);
    }

    public DomainException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
