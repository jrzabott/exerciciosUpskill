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
public class ContadorEletricidadeTarifarioSimples extends ContadorEletricidade {

    private double potenciaContratada;

    private final double POTENCIA_CONTRATADA_DEFAULT = 0;

    private static double custoPotenciaBaixa = 0.13;
    private static double custoPotenciaAlta = 0.16;
    private static double potenciaLimite = 6.9;

    public ContadorEletricidadeTarifarioSimples(double potenciaContratada
            , String nome, int consumoMes
    ) {
        super(nome, consumoMes);
        this.potenciaContratada = potenciaContratada;
    }

    public ContadorEletricidadeTarifarioSimples() {
        super();
        this.potenciaContratada = POTENCIA_CONTRATADA_DEFAULT;
    }

    /**
     * @return the potenciaContratada
     */
    public double getPotenciaContratada() {
        return potenciaContratada;
    }

    /**
     * @param potenciaContrada the potenciaContratada to set
     */
    public void setPotenciaContrada(double potenciaContrada) {
        this.potenciaContratada = potenciaContrada;
    }

    @Override
    public String toString() {
        return "ContadorEletricidadeTarifarioSimples{" + "potenciaContratada=" + potenciaContratada + '}' + super.toString();
    }

    @Override
    public double calcularConsumo() {
        double result = getConsumoMes();
        result *= (getPotenciaContratada() >= getPotenciaLimite())
                ? getCustoPotenciaAlta()
                : getCustoPotenciaBaixa();
        return result;
    }

    /**
     * @return the custoPotenciaBaixa
     */
    public static double getCustoPotenciaBaixa() {
        return custoPotenciaBaixa;
    }

    /**
     * @return the custoPotenciaAlta
     */
    public static double getCustoPotenciaAlta() {
        return custoPotenciaAlta;
    }

    /**
     * @return the potenciaLimite
     */
    public static double getPotenciaLimite() {
        return potenciaLimite;
    }

    /**
     * @param aCustoPotenciaBaixa the custoPotenciaBaixa to set
     */
    public static void setCustoPotenciaBaixa(double aCustoPotenciaBaixa) {
        custoPotenciaBaixa = aCustoPotenciaBaixa;
    }

    /**
     * @param aCustoPotenciaAlta the custoPotenciaAlta to set
     */
    public static void setCustoPotenciaAlta(double aCustoPotenciaAlta) {
        custoPotenciaAlta = aCustoPotenciaAlta;
    }

    /**
     * @param aPotenciaLimite the potenciaLimite to set
     */
    public static void setPotenciaLimite(double aPotenciaLimite) {
        potenciaLimite = aPotenciaLimite;
    }

}
