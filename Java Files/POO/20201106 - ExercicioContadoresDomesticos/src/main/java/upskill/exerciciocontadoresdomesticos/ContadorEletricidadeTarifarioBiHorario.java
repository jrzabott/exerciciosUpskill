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
public class ContadorEletricidadeTarifarioBiHorario extends ContadorEletricidade {

    private int consumoForaDeHorasVazio;

    private final int CONSUMO_FORA_DE_HORAS_VAZIO_DEFAULT = 0;

    private static double custoPotenciaVazio = 0.066;
    private static double custoPotenciaFora = 0.14;

    public ContadorEletricidadeTarifarioBiHorario(
            String nome,
            int consumoEmHorasVazio,
            int consumoForaDeHorasVazio
            ) {
        super(nome, consumoEmHorasVazio);
        this.consumoForaDeHorasVazio = consumoForaDeHorasVazio;
    }

    public ContadorEletricidadeTarifarioBiHorario() {
        super();
        this.consumoForaDeHorasVazio = CONSUMO_FORA_DE_HORAS_VAZIO_DEFAULT;
    }

    /**
     * @return the consumoForaDeHorasVazio
     */
    public int getConsumoForaDeHorasVazio() {
        return consumoForaDeHorasVazio;
    }

    /**
     * @param consumoForaDeHorasVazio the consumoForaDeHorasVazio to set
     */
    public void setConsumoForaDeHorasVazio(int consumoForaDeHorasVazio) {
        this.consumoForaDeHorasVazio = consumoForaDeHorasVazio;
    }

    @Override
    public String toString() {
        return "ContadorEletricidadeTarifarioBiHorario{" + "consumoForaDeHorasVazio=" + getConsumoForaDeHorasVazio() + '}';
    }

    @Override
    public double calcularConsumo() {
        return getConsumoMes() * getCustoPotenciaVazio() 
                + getConsumoForaDeHorasVazio() * getCustoPotenciaFora();
    }

    /**
     * @return the custoPotenciaVazio
     */
    public static double getCustoPotenciaVazio() {
        return custoPotenciaVazio;
    }

    /**
     * @return the custoPotenciaFora
     */
    public static double getCustoPotenciaFora() {
        return custoPotenciaFora;
    }

    /**
     * @param aCustoPotenciaVazio the custoPotenciaVazio to set
     */
    public static void setCustoPotenciaVazio(double aCustoPotenciaVazio) {
        custoPotenciaVazio = aCustoPotenciaVazio;
    }

    /**
     * @param aCustoPotenciaFora the custoPotenciaFora to set
     */
    public static void setCustoPotenciaFora(double aCustoPotenciaFora) {
        custoPotenciaFora = aCustoPotenciaFora;
    }

}
