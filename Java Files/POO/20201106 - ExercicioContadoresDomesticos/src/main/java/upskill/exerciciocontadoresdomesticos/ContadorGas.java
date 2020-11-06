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
public class ContadorGas extends Contador {

    // Class Properties
    private static double custoUnitario = 0.8;
    private static int gasIDCounter = 1;

    // Class Constants
    private static final String PREFIXO_ID_DEFAULT = "GAS";
    private static final String UNIDADE_DE_MEDIDA = "m3";

    // MÉTODOS DE INSTÂNCIA
    public ContadorGas(int consumoMes, String nome) {
        super(
                nome,
                Contador.obterID(PREFIXO_ID_DEFAULT, gasIDCounter),
                consumoMes
        );
        gasIDCounter++;
    }

    public ContadorGas() {
        super();
        gasIDCounter++;
    }

    @Override
    public String toString() {
        return String.format("ContadorGas{consumoMes=%d%s, id=%s}+%s",
                this.getConsumoMes(),
                ContadorGas.getUnidadeDeMedida(),
                super.getId(),
                super.toString()
        );
    }

    @Override
    public double calcularConsumo() {
        return getConsumoMes() * getCustoUnitario();
    }

    // MÉTODOS ESTÁTICOS
    /**
     * @return the custoUnitario
     */
    public static double getCustoUnitario() {
        return custoUnitario;
    }

    /**
     * @return the gasIDCounter
     */
    public static int getGasIDCounter() {
        return gasIDCounter;
    }

    /**
     * @return the UNIDADE_DE_MEDIDA
     */
    public static String getUnidadeDeMedida() {
        return UNIDADE_DE_MEDIDA;
    }

    /**
     * @param aCustoUnitario the custoUnitario to set
     */
    public static void setCustoUnitario(double aCustoUnitario) {
        custoUnitario = aCustoUnitario;
    }

    /**
     * @param aGasIDCounter the gasIDCounter to set
     */
    public static void setGasIDCounter(int aGasIDCounter) {
        gasIDCounter = aGasIDCounter;
    }

}
