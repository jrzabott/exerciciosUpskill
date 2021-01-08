/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciofilme;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class ListaFilmes {

    private List<Filme> filmes;
    private String id;

    private final static String ID_DEFAULT = "N/A";

    {
        this.id = ID_DEFAULT;
        this.setFilmes(new ArrayList<>());
    }

    public ListaFilmes(List<Filme> filmes) {
        this.filmes = filmes;
        
    }

    public ListaFilmes() {
    }

    /**
     * @return the filmes
     */
    public List<Filme> getFilmes() {
        return filmes;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param filmes the filmes to set
     */
    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) throws IdentificadorInvalidoException {
        if (validaIdentificador(id)) {
            this.id = id;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.filmes);
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaFilmes other = (ListaFilmes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.filmes, other.filmes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista: ").append(id);
        sb.append(", Filmes:").append(filmes);
        sb.append(".\n");
        return sb.toString();
    }

    public boolean addFilme(Filme f) {
        return filmes.add(f);

    }

    private boolean validaIdentificador(String i) throws IdentificadorInvalidoException {
        if (i.isEmpty()) {
            throw new IdentificadorInvalidoException("Identificador não pode ser vazio");
        }
        char maiusculas[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        boolean isMaiuscula = false;

        for (char maiuscula : maiusculas) {
            if (maiuscula == i.charAt(0)) {
                isMaiuscula = true;
            }
        }
        if (!isMaiuscula) {
            throw new IdentificadorInvalidoException("A primeira letra do identificador deve ser uma letra maiúscula.");
        }
        return isMaiuscula;
    }

}
