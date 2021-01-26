package com.company.dto;

import com.company.model.ListaTerreno;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"nif", "nome", "nascimento", "terrenosPossuidos"})
@JacksonXmlRootElement(localName = "pessoa")

public class PessoaDTO {

    @JacksonXmlProperty(localName = "nif")
    private long nif;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "data_nascimento")
    private DataDTO nascimento;
    @JacksonXmlProperty(localName = "terrenosPossuidos")
    private ListaTerrenoDTO terreno;

    public PessoaDTO() {
        this.terreno = new ListaTerrenoDTO();
    }

    public long getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public DataDTO getNascimento() {
        return nascimento;
    }

    public ListaTerrenoDTO getTerrenos() {
        return terreno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public void setNascimento(DataDTO nascimento) {
        this.nascimento = nascimento;
    }

    public void setTerrenos(ListaTerrenoDTO terrenoDTO) {
//        this.terreno = new ListaTerrenoDTO(terreno);
        this.terreno = new ListaTerrenoDTO();
        this.terreno.setTerrenos(terrenoDTO.getTerrenos());
    }

}
