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
public class AreaAtividade {
    private String cod;
    String dsBreve;
    String dsDet;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDsBreve() {
        return dsBreve;
    }

    public void setDsBreve(String dsBreve) {
        this.dsBreve = dsBreve;
    }

    public String getDsDet() {
        return dsDet;
    }

    public void setDsDet(String dsDet) {
        this.dsDet = dsDet;
    }

    public AreaAtividade(String cod, String dsBreve, String dsDet) {
        this.cod = cod;
        this.dsBreve = dsBreve;
        this.dsDet = dsDet;
    }
    
   
    
}
