/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "funcionarios")
public class ListaFuncionarioDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "funcionario")
    private ArrayList<FuncionarioDTO> funcionarios;

    public ListaFuncionarioDTO() {
    }

    public ArrayList<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<FuncionarioDTO> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
