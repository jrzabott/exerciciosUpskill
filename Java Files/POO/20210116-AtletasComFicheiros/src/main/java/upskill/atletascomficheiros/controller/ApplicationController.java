/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.atletascomficheiros.controller;

import java.util.Date;
import upskill.atletascomficheiros.model.AtletaAmador;
import upskill.atletascomficheiros.model.ClubeDesportivo;

/**
 *
 * @author user
 */
public class ApplicationController {

    ClubeDesportivo clubeDesportivo;

    public ApplicationController() {
        this.clubeDesportivo = new ClubeDesportivo();
        clubeDesportivo.setData(new Date(120, 0, 1));
        clubeDesportivo.setNome("O Clube Desp");
    }

    public String[] getIntensidadeTreinos() {
        return upskill.atletascomficheiros.model.Atleta.getIntensidadeTreinos();
    }

    public String[] getListaAtletas() {
        return clubeDesportivo.getListaAtletasAsStringArray();
    }

    public String[] getTipoAtividades() {
        return upskill.atletascomficheiros.model.Atleta.getTipoAtividades();
    }

    public boolean adicionarAtletaAmador(String nome, String idCivil, String genero, String idade, String tipoAtividade, String iT, String fcr, String premio, String antiguidade) throws  IllegalArgumentException{
        boolean added = clubeDesportivo.adicionarAtletaAmador(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, antiguidade);
        return added;
    }
}
