/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioempregado;

import java.time.LocalDate;
import upskill.utilitarios.Data;
import upskill.utilitarios.Tempo;

/**
 *
 * @author user
 */
public class Empregado {

    private String primeiroNome, ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;

    static final String PRIMEIRO_NOME_DEFAULT = "Nome nao Atribuido";
    static final String ULTIMO_NOME_DEFAULT = "Ultimo Nome nao Atribuido";
    static final double DIAS_TRABALHO_SEMANA = 5.0;
    static final double CONVERSAO_SEGUNDOS_PARA_HORAS = 3600.0;

    /**
     * @return the primeiroNome
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     * @return the ultimoNome
     */
    public String getUltimoNome() {
        return ultimoNome;
    }

    /**
     * @return the dataContrato
     */
    public Data getDataContrato() {
        return dataContrato;
    }

    /**
     * @return the horaEntrada
     */
    public Tempo getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @return the horaSaida
     */
    public Tempo getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param primeiroNome the primeiroNome to set
     */
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    /**
     * @param ultimoNome the ultimoNome to set
     */
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    /**
     * @param dataContrato the dataContrato to set
     */
    public void setDataContrato(Data dataContrato) {
        this.dataContrato = dataContrato;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = dataContrato;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public Empregado(String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data();
        this.horaEntrada = new Tempo();
        this.horaSaida = new Tempo();
    }

    public Empregado() {
        this.primeiroNome = PRIMEIRO_NOME_DEFAULT;
        this.ultimoNome = ULTIMO_NOME_DEFAULT;
        this.dataContrato = new Data();
        this.horaEntrada = new Tempo();
        this.horaSaida = new Tempo();
    }

    public double calculateHorasTrabalhoSemanal() {
        return horaSaida.diferencaEmSegundos(horaEntrada)
                / CONVERSAO_SEGUNDOS_PARA_HORAS
                * DIAS_TRABALHO_SEMANA;
    }

    public int calculateTempoContrato() {
        java.time.LocalDate currentDate = LocalDate.now();
        Data today = new Data(
                currentDate.getYear(),
                currentDate.getMonthValue(),
                currentDate.getDayOfMonth()
        );
        return today.diferenca(dataContrato);
    }

    @Override
    public String toString() {
        return "Empregado{" + "primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", dataContrato=" + dataContrato + ", horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida + '}';
    }

    
    
}
