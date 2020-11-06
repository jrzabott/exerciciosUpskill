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
public abstract class ContadorEletricidade extends Contador {


    // Class Properties
    private static int eletricidadeIDCounter = 1;

    // Class Constants
    private static final String PREFIXO_ID_DEFAULT = "ELECT";
    private static final String UNIDADE_DE_MEDIDA = "kVh";

    // MÉTODOS DE INSTÂNCIA
    public ContadorEletricidade(String nome, int consumoMes) {
        super(
                nome,
                 obterID(PREFIXO_ID_DEFAULT, eletricidadeIDCounter),
                 consumoMes
        );
        eletricidadeIDCounter++;
    }

    public ContadorEletricidade() {
        super();
        ContadorEletricidade.eletricidadeIDCounter++;
    }

    /**
     * @return the eletricidadeIDCounter
     */
    public static int getEletricidadeIDCounter() {
        return eletricidadeIDCounter;
    }
}
