/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.exception;

/**
 *
 * @author Daniel Pina
 */
public class NumeroFuncionarioDuplicadoException extends RuntimeException {

    public NumeroFuncionarioDuplicadoException(String s) {
        super(s);
    }
}