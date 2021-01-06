/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciolistatelefonica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ListaTelefonica {
    List<Contacto> lista;

    public ListaTelefonica() {
        this.lista = new ArrayList<Contacto>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListaTelefonica{lista=").append(lista);
        sb.append('}');
        return sb.toString();
    }

    public boolean novoContacto(Contacto c){
        return lista.add(c);
    }
    public boolean novoContacto(String nome, String telefone, String email){
        return lista.add(new Contacto(nome, telefone, email));
    }

    public List<Contacto> getLista() {
        return lista;
    }
    
    
    
}
