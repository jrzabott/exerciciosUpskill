/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciocontadoresdomesticos;

/**
 *
 * @author user
 */
public abstract class Contador {



    /**
     * @return the formatStringID
     */
    private String nome;
    private String id;
    private int consumoMes;

    private final int CONSUMO_MES_DEFAULT = 0;
    private final String ID_DEFAULT = "N/A";
    private final String NOME_DEFAULT = "John Smith";

    private static String formatStringID = "%s-%d";

    public abstract double calcularConsumo();

    public Contador(String nome, String id, int consumoMes) {
        this.nome = nome;
        this.id = id;
        this.consumoMes = consumoMes;
    }

    public Contador() {
        this.nome = NOME_DEFAULT;
        this.id = ID_DEFAULT;
        this.consumoMes = CONSUMO_MES_DEFAULT;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the consumoMes
     */
    public int getConsumoMes() {
        return consumoMes;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param consumoMes the consumoMes to set
     */
    public void setConsumoMes(int consumoMes) {
        this.consumoMes = consumoMes;
    }

    public static String obterID(String prefix, int sufix) {
        return String.format(Contador.getFormatStringID(),prefix, sufix);
    }

    /**
     * @return the formatStringID
     */
    public static String getFormatStringID() {
        return formatStringID;
    }

    /**
     * @param aFormatStringID the formatStringID to set
     */
    public static void setFormatStringID(String aFormatStringID) {
        formatStringID = aFormatStringID;
    }

    @Override
    public String toString() {
        return "Contador{" + "nome=" + getNome() + ", id=" + getId() + ", consumoMes=" + getConsumoMes() + '}';
    }

}
