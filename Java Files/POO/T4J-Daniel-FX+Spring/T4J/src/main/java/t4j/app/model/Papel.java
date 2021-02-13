package t4j.app.model;

import java.io.Serializable;

public class Papel implements Serializable {

    /**
     * Variável de instância - nome do papel do utilizador
     */
    private String nomePapel;
    
    /**
     * Variável de instância - descrição do papel do utilizador
     */
    private String descPapel;

    /**
     * Constante por omissão da descrição do papel do utilizador
     */
    private static final String DESCPAPEL_POR_OMISSAO = "";

    /**
     * Construtor completo de papel
     * @param nomePapel
     * @param descPapel 
     */
    public Papel(String nomePapel, String descPapel) {
        this.nomePapel = nomePapel;
        this.descPapel = descPapel;
    }

    /**
     * Construtor parcial de papel
     * @param nomePapel 
     */
    public Papel(String nomePapel) {
        this.nomePapel = nomePapel;
        this.descPapel = DESCPAPEL_POR_OMISSAO;
    }

    /**
     * 
     * @return nome do papel do utilizador
     */
    public String getNomePapel() {
        return nomePapel;
    }

    /**
     * 
     * @return descrição do papel do utilizador
     */
    public String getDescPapel() {
        return descPapel;
    }

    /**
     * 
     * @param nomePapel especifica um novo nome do papel do utilizador
     */
    public void setNomePapel(String nomePapel) {
        this.nomePapel = nomePapel;
    }

    /**
     * 
     * @param descPapel especifica uma nova descrição do papel do utilizador
     */
    public void setDescPapel(String descPapel) {
        this.descPapel = descPapel;
    }
}
