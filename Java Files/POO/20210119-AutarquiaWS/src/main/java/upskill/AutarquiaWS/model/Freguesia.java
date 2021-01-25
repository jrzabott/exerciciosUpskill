/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.model;

import java.io.Serializable;
import java.util.ArrayList;
import upskill.AutarquiaWS.exception.NomeFreguesiaInvalidoException;
import upskill.AutarquiaWS.exception.IdInvalidoException;
import java.util.Objects;
import upskill.AutarquiaWS.exception.ElementoNaoExistenteException;
import upskill.AutarquiaWS.exception.TerrenoDuplicadoException;

/**
 *
 * @author user
 */
public class Freguesia implements Serializable {

    private final static long ID_DEFAULT = 0;
    private final static String NOME_DEFAULT = "";

    private long id;
    private String nome;
    private ArrayList<Terreno> terrenos;

    public Freguesia(long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.terrenos = new ArrayList<>();
    }

    public Freguesia() {
        this.id = ID_DEFAULT;
        this.nome = NOME_DEFAULT;
        this.terrenos = new ArrayList<>();
    }

    public void addTerreno(Terreno terreno) {
        Terreno t = getTerrenoByNumber(terreno.getNumber());
        if (t == null) {
            this.terrenos.add(terreno);
        } else {
            throw new TerrenoDuplicadoException(terreno.getNumber() + ": Terreno já existe.");
        }
    }

    public void removeTerreno(long number) {
        Terreno terreno = null;
        for (int i = 0; i < this.getTerrenos().size(); i++) {
            terreno = this.getTerrenos().get(i);
            if (terreno.getNumber() == number) {
                this.terrenos.remove(i);
                return;
            }
        }
        throw new ElementoNaoExistenteException(number + ": Não existe este terreno");
    }

    public void updateTerreno(long number, Terreno t) {
        Terreno terreno = null;
        boolean atualizado = false;
        for (int i = 0; i < this.getTerrenos().size(); i++) {
            terreno = this.getTerrenos().get(i);
            if (terreno.getNumber() == number) {
//                terreno = t;
                this.terrenos.set(i, t);
                atualizado = true;
            }
        }
        if (!atualizado) {
            throw new ElementoNaoExistenteException(number + ": Não existe este terreno");
        }
    }

    public ArrayList<Terreno> getTerrenos() {
        Terreno terreno;
        ArrayList<Terreno> lista = new ArrayList<>();

        for (int i = 0; i < this.terrenos.size(); i++) {
            terreno = this.terrenos.get(i);
            lista.add(terreno);
        }
        return lista;
    }

    public Terreno getTerreno(long number) {
        return getTerrenoByNumber(number);
    }

    private Terreno getTerrenoByNumber(long number) {
        Terreno terreno;
        for (int i = 0; i < this.getTerrenos().size(); i++) {
            terreno = this.getTerrenos().get(i);
            if (terreno.getNumber() == number) {
                Terreno copia;
                switch (terreno.getShape()) {
                    case CIRCLE:
                        copia = new TerrenoCircular((TerrenoCircular) terreno);
                        break;
                    case RECTANGLE:
                        copia = new TerrenoRetangular((TerrenoRetangular) terreno);
                        break;
                    case TRIANGLE:
                        copia = new TerrenoTriangular((TerrenoTriangular) terreno);
                        break;
                    default:
                        copia = null;
                }
                return copia;
            }
        }
        return null;
    }

    public Freguesia(Freguesia freguesia) {
        setId(freguesia.id);
        setNome(freguesia.nome);
        setTerrenos(freguesia.terrenos);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (this.id >= 0) {
            this.id = id;
        } else {
            throw new IdInvalidoException(id + ": é um ID inválido.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (eNomeValido(nome)) {
            this.nome = nome;
        } else {
            throw new NomeFreguesiaInvalidoException(nome + ": Nome da Freguesia inválido ");
        }
    }

    private boolean eNomeValido(String nome) {
        boolean result = true;
        if (nome == null || nome.trim().isEmpty()) {
            result = false;
        }
        if (nome.length() < 3) {
            result = false;
        }
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) >= '0' && nome.charAt(i) <= '9') {
                result = false;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + Objects.hashCode(this.nome);
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
        final Freguesia other = (Freguesia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Freguesia{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append('}');
        return sb.toString();
    }

    /**
     * @param terrenos the terrenos to set
     */
    public void setTerrenos(ArrayList<Terreno> terrenos) {
        this.terrenos = terrenos;
    }

}
