package org.upskill.tributaveis;

public class Veiculo implements Cores, Tributavel {
    private String matricula;
    private int cilindrada;
    private String cor;

//    Variáveis para a alínea 13    
    private static int limiteEscalao1 = 1500;
    private static float impostoEscalao1 = 15;
    private static float impostoEscalao2 = 40;    

    public Veiculo(String matricula, int cilindrada, String cor) {
        this.matricula = matricula;
        this.cilindrada = cilindrada;
        this.cor = cor;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String getCor() {
        return cor;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return String.format("Veículo com matrícula %s e cilindrada %d tem cor %s", getMatricula(), getCilindrada(), cor);
    }

    @Override
    public double calcularImposto() {
        return (getCilindrada() < getLimiteEscalao1()) ? getImpostoEscalao1(): getImpostoEscalao2();
    }

    /**
     * @return the limiteEscalao1
     */
    public static int getLimiteEscalao1() {
        return limiteEscalao1;
    }

    /**
     * @return the impostoEscalao1
     */
    public static float getImpostoEscalao1() {
        return impostoEscalao1;
    }

    /**
     * @return the impostoEscalao2
     */
    public static float getImpostoEscalao2() {
        return impostoEscalao2;
    }

    /**
     * @param aLimiteEscalao1 the limiteEscalao1 to set
     */
    public static void setLimiteEscalao1(int aLimiteEscalao1) {
        limiteEscalao1 = aLimiteEscalao1;
    }

    /**
     * @param aImpostoEscalao1 the impostoEscalao1 to set
     */
    public static void setImpostoEscalao1(float aImpostoEscalao1) {
        impostoEscalao1 = aImpostoEscalao1;
    }

    /**
     * @param aImpostoEscalao2 the impostoEscalao2 to set
     */
    public static void setImpostoEscalao2(float aImpostoEscalao2) {
        impostoEscalao2 = aImpostoEscalao2;
    }
}