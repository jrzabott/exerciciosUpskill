package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nif", "nome", "nascimento"})
@JacksonXmlRootElement(localName = "pessoa")
public class PessoaDTO {

    @JacksonXmlProperty(localName = "nif")
    private long nif;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "data_nascimento")
    private DataDTO nascimento;

    public PessoaDTO() {
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DataDTO getNascimento() {
        return nascimento;
    }

    public void setNascimento(DataDTO nascimento) {
        this.nascimento = nascimento;
    }
}
