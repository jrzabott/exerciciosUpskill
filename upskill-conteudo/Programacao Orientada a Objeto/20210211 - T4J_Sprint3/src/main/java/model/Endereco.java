/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nunocastro
 */
public class Endereco {
    private String endLocal;
    private String endPostal;
    private String localidade;

    public String getEndLocal() {
        return endLocal;
    }

    public void setEndLocal(String endLocal) {
        this.endLocal = endLocal;
    }

    public String getEndPostal() {
        return endPostal;
    }

    public void setEndPostal(String endPostal) {
        this.endPostal = endPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Endereco(String endLocal, String endPostal, String localidade) {
        this.endLocal = endLocal;
        this.endPostal = endPostal;
        this.localidade = localidade;
    }
    
}
