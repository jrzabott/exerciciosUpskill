package com.company.exception;

public class ConversaoException extends RuntimeException {

    public ConversaoException(String classe) {
        super("Erro a converter a classe:" + classe);

    }
}
