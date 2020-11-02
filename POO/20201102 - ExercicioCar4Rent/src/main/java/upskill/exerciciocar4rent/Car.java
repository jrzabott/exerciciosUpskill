/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciocar4rent;

import java.util.Date;

/**
 *
 * @author user
 */
public class Car {

    private String license;
    private int year;
    private double fuelConsumption;
    private double kmAutonomy;
    private double cc;

    private final String LICENSE_DEFAULT = "AA-00-AA";
    private final int YEAR_DEFAULT = 1900;
    private final double FUEL_CONSUMPTION_DEFAULT = 0.0;
    private final double KM_AUTONOMY_DEFAULT = 0.0;
    private final double CC_DEFAULT = 0.0;
    private final Date TODAY = new Date();

    public static int anoClassificacaoRecente = 1;
    public static int anoClassificacaoContemporaneo = 20;

    public static String CLASSIFICACAO_RECENTE = "recente";
    public static String CLASSIFICACAO_CONTEMP = "contemporaneo";
    public static String CLASSIFICACAO_CLASSICO = "classico";

    public Car() {
        this.license = LICENSE_DEFAULT;
        this.year = YEAR_DEFAULT;
        this.fuelConsumption = FUEL_CONSUMPTION_DEFAULT;
        this.fuelConsumption = FUEL_CONSUMPTION_DEFAULT;
        this.cc = CC_DEFAULT;
    }

    public Car(String license, int year, double fuelConsumption, double kmAutonomy, double cc) {
        if (!license.isEmpty()) {
            this.license = license;
        } else {
            this.license = LICENSE_DEFAULT;
        }
        if (year < 1900) {
            this.year = YEAR_DEFAULT;
        } else {
            this.year = year;
        }
        this.fuelConsumption = fuelConsumption;
        this.kmAutonomy = kmAutonomy;
        this.cc = cc;

    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getKmAutonomy() {
        return kmAutonomy;
    }

    public void setKmAutonomy(double kmAutonomy) {
        this.kmAutonomy = kmAutonomy;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public double getImpostoDeCirculacao(double txAmb) {
        return txAmb * cc;
    }

    public String getClassificacao() {
        return (this.year >= calcularAnoClassificacao(anoClassificacaoRecente))
                ? CLASSIFICACAO_RECENTE
                : (this.year >= calcularAnoClassificacao(anoClassificacaoContemporaneo))
                ? (CLASSIFICACAO_CONTEMP)
                : CLASSIFICACAO_CLASSICO;
    }

    @Override
    public String toString() {
        return "Car{" + "license=" + license + ", year=" + year + ", fuelConsumption=" + fuelConsumption + ", kmAutonomy=" + kmAutonomy + ", cc=" + cc + ", LICENSE_DEFAULT=" + LICENSE_DEFAULT + ", YEAR_DEFAULT=" + YEAR_DEFAULT + ", today=" + TODAY + ", CONSUMPTION_DEFAULT=" + FUEL_CONSUMPTION_DEFAULT + ", KM_AUTONOMY_DEFAULT=" + KM_AUTONOMY_DEFAULT + '}';
    }

    public void setANO_CLASSIFICACAO_RECENTE(int ANO_CLASSIFICACAO_RECENTE) {
        this.anoClassificacaoRecente = ANO_CLASSIFICACAO_RECENTE;
    }

    public void setANO_CLASSIFICACAO_CONTEMP(int ANO_CLASSIFICACAO_CONTEMP) {
        this.anoClassificacaoContemporaneo = ANO_CLASSIFICACAO_CONTEMP;
    }

    final public int calcularAnoClassificacao(int anoClassificacao) {
        return 1900 + TODAY.getYear() - anoClassificacao;
    }

}
