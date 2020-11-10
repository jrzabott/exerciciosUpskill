/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioescola;

/**
 *
 * @author user
 */
public class Professor extends Pessoa implements Pagavel {

    private String categoria;

    private static double salarioBase = 1500.0;
    private static double extraAssistente = 0.0;
    private static double extraAdjunto = 20.0;
    private static double extraCoordenador = 50.0;

    private static final String CATEGORIA_DEFAULT = "";
    private static final String PROF_CAT_ASSISTENTE = "assistente";
    private static final String PROF_CAT_ADJUNTO = "adjunto";
    private static final String PROF_CAT_COORDENADOR = "coordenador";

    public Professor(String nome, int idCivil, String categoria) {
        super(nome, idCivil);
        this.categoria = categoria;
    }

    public Professor() {
        super();
        this.categoria = CATEGORIA_DEFAULT;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Professor{" + "categoria=" + categoria + '}' + super.toString();
    }

        
    @Override
    public double calcularPagamento() {
        double result  = getSalarioBase();
        
        switch(getCategoria().toLowerCase()) {
            case PROF_CAT_ADJUNTO:
                result += getSalarioBase() * (getExtraAdjunto() / FATOR_PERCENTAGEM);
                break;
        
            case PROF_CAT_ASSISTENTE:
                result += getSalarioBase() * (getExtraAssistente()/ FATOR_PERCENTAGEM);
                break;

            case PROF_CAT_COORDENADOR:
                result += getSalarioBase() * (getExtraCoordenador()/ FATOR_PERCENTAGEM);
                break;

            default:
        }
        return result;
    }

    /**
     * @return the salarioBase
     */
    public static double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @return the extraAssistente
     */
    public static double getExtraAssistente() {
        return extraAssistente;
    }

    /**
     * @return the extraAdjunto
     */
    public static double getExtraAdjunto() {
        return extraAdjunto;
    }

    /**
     * @return the extraCoordenador
     */
    public static double getExtraCoordenador() {
        return extraCoordenador;
    }

    /**
     * @param aSalarioBase the salarioBase to set
     */
    public static void setSalarioBase(double aSalarioBase) {
        salarioBase = aSalarioBase;
    }

    /**
     * @param aExtraAssistente the extraAssistente to set
     */
    public static void setExtraAssistente(double aExtraAssistente) {
        extraAssistente = aExtraAssistente;
    }

    /**
     * @param aExtraAdjunto the extraAdjunto to set
     */
    public static void setExtraAdjunto(double aExtraAdjunto) {
        extraAdjunto = aExtraAdjunto;
    }

    /**
     * @param aExtraCoordenador the extraCoordenador to set
     */
    public static void setExtraCoordenador(double aExtraCoordenador) {
        extraCoordenador = aExtraCoordenador;
    }

}
