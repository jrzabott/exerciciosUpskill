/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciofilme;

/**
 *
 * @author user
 */
public enum CategoriaEnum {
    ACAO("ação"), 
    ANIMACAO("animação"), 
    COMEDIA("comédia"), 
    DRAMA("drama"), 
    TERROR("terror");
    private String nomeCategoria;

    private CategoriaEnum(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria.toUpperCase();
    }
    public String getNomeCategoria(){
        return this.nomeCategoria;
    }

    
    
}
