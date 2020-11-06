/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciotrabalhador;

/**
 *
 * @author user
 */
public class TrabalhadorHora2 extends Trabalhador{
    private double horasTrabalhadas;
    private double valorHora;
    private final double VALOR_HORA_DEFAULT = 10.0;
    private final double HORAS_TRABALHADAS_DEFAULT = 0.0;

    public TrabalhadorHora2(double horasTrabalhadas, double valorHora, String nome) {
        super(nome);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public TrabalhadorHora2() {
        super();
        this.horasTrabalhadas = HORAS_TRABALHADAS_DEFAULT;
        this.valorHora = VALOR_HORA_DEFAULT;
    }

    
    
    /**
     * @return the horasTrabalhadas
     */
    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    /**
     * @return the valorHora
     */
    public double getValorHora() {
        return valorHora;
    }

    /**
     * @param horasTrabalhadas the horasTrabalhadas to set
     */
    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    /**
     * @param valorHora the valorHora to set
     */
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public float calcularVencimento() {
        return (float) (getHorasTrabalhadas() * getValorHora());
    }
 
    
}
    