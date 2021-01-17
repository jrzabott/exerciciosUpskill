package upskill.atletascomficheiros.model;

/**
 *
 * @author Jorge Pires Data de criação: 24/11/2020
 * @version 0.1
 */
public class AtletaAmador extends AtletaNaoProfissional {

    /**
     * Variável de classe - valor percentual do prémio que o atleta amador
     * recebe
     */
    private static double percValorPremio = 7;

    /**
     * Variável de classe - especifica o valor mínimo que o atleta amador recebe
     */
    private static double valorMinimo = 5;

    /**
     * Variável de classe - conta o número de instâncias criadas do tipo atleta
     * amador
     */
    private static int contadorAtletasAmadores = 0;

    /**
     *
     * @param nome nome do atleta
     * @param idCivil número de identificação civil
     * @param genero género do atleta (masculino ou feminino)
     * @param idade idade do atleta
     * @param tipoAtividade tipo de atividade desportiva que o atleta pratica
     * (corrida, caminhada, natação ou ciclismo)
     * @param iT percentagem de intensidade de treino do atleta (queimar gordura
     * ou trabalhar capacidade cardiorrespiratória)
     * @param fcr valor da frequência cardíaca em repouso do atleta (representa
     * o número de batimentos cardíacos em repouso durante 1 minuto)
     * @param premio valor monetário que o atleta conquistou em competições
     * @param antiguidade número de anos que o atleta tem de filiação no clube
     * desportivo
     */
    public AtletaAmador(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio, int antiguidade) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, antiguidade);
        contadorAtletasAmadores++;
    }

    /**
     *
     * @param nome nome do atleta
     * @param idCivil número de identificação civil
     * @param genero género do atleta (masculino ou feminino)
     * @param idade idade do atleta
     * @param tipoAtividade tipo de atividade desportiva que o atleta pratica
     * (corrida, caminhada, natação ou ciclismo)
     * @param iT percentagem de intensidade de treino do atleta (queimar gordura
     * ou trabalhar capacidade cardiorrespiratória)
     * @param fcr valor da frequência cardíaca em repouso do atleta (representa
     * o número de batimentos cardíacos em repouso durante 1 minuto)
     * @param antiguidade número de anos que o atleta tem de filiação no clube
     * desportivo
     */
    public AtletaAmador(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, int antiguidade) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, antiguidade);
        contadorAtletasAmadores++;
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public AtletaAmador() {
        super();
        contadorAtletasAmadores++;
    }

    /**
     *
     * @return Override do método toString
     */
    @Override
    public String toString() {
        return String.format("%s {%s}", this.getClass().getSimpleName(), super.toString());
    }

    /**
     *
     * @return o cálculo da primeira parcela do cálculo do vencimento do atleta
     * amador (depende da antiguidade do atleta em relação ao clube desportivo)
     */
    public double calcularPrimeiraParcela() {
        double parcela1;
        if (getAntiguidade() < getLimiteAntiguidadeInferior()) {
            parcela1 = 0;
        } else if (getAntiguidade() >= getLimiteAntiguidadeInferior() && getAntiguidade()
                <= getLimiteAntiguidadeIntermedio()) {
            parcela1 = getPremio() * getPercAntiguidade1() / 100;
        } else if (getAntiguidade() > getLimiteAntiguidadeIntermedio() && getAntiguidade()
                <= getLimiteAntiguidadeSuperior()) {
            parcela1 = getPremio() * getPercAntiguidade2() / 100;
        } else {
            parcela1 = getPremio() * getPercAntiguidade3() / 100;
        }
        return parcela1;
    }

    /**
     *
     * @return o cálculo da segunda parcela do cálculo do vencimento do atleta
     * amador (valor percentual do prémio obtido pelo atleta amador em
     * competições)
     */
    public double calcularSegundaParcela() {
        return getPremio() * getPercValorPremio() / 100;
    }

    /**
     *
     * @return o cálculo do vencimento auferido pelo atleta amador (recebe um
     * valor mínimo)
     */
    @Override
    public double calcularVencimento() {
        double calculo = calcularPrimeiraParcela() + calcularSegundaParcela();
        if (calculo < getValorMinimo()) {
            return getValorMinimo();
        } else {
            return calculo;
        }
    }

    /**
     * @return o valor percentual do prémio que o atleta amador recebe
     */
    public static double getPercValorPremio() {
        return percValorPremio;
    }

    /**
     * @return o valor mínimo que o atleta amador aufere
     */
    public static double getValorMinimo() {
        return valorMinimo;
    }

    /**
     * @return o número de instâncias criadas do tipo atleta amador
     */
    public static int getContadorAtletasAmadores() {
        return contadorAtletasAmadores;
    }

    /**
     * @param aPercValorPremio especifica um novo valor para o percentual do
     * prémio que o atleta amador recebe
     */
    public static void setPercValorPremio(double aPercValorPremio) {
        percValorPremio = aPercValorPremio;
    }

    /**
     * @param aValorMinimo especifica um novo valor para o valor mínimo que o
     * atleta amador
     */
    public static void setValorMinimo(double aValorMinimo) {
        valorMinimo = aValorMinimo;
    }

}
