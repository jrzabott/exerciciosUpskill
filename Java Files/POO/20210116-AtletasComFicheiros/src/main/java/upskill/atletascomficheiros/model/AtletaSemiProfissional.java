package upskill.atletascomficheiros.model;

/**
 *
 * @author Daniel Junior Data de criação: 24/11/2020
 * @version 0.1
 */
public class AtletaSemiProfissional extends AtletaNaoProfissional implements RetencaoIRS {

    /**
     * Variável de classe - valor monetário fixo auferido pelo atleta (igual
     * para todos os atletas semi-profissionais)
     */
    private static double parcelaFixa = 0.0;

    /**
     * Variável de classe - conta o número de instâncias criadas do tipo atleta
     * semi-profissional
     */
    private static int contadorAtletaSemiProfissional = 0;

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
    public AtletaSemiProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio, int antiguidade) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, antiguidade);
        contadorAtletaSemiProfissional++;
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
    public AtletaSemiProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, int antiguidade) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, antiguidade);
        contadorAtletaSemiProfissional++;
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public AtletaSemiProfissional() {
        super();
        contadorAtletaSemiProfissional++;
    }

    /**
     *
     * @return o cálculo da parcela variável do cálculo do vencimento do atleta
     * semi-profissional (depende da antiguidade do atleta em relação ao clube
     * desportivo)
     */
    public double getparcelaVariavel() {
        double result;
        int anos = this.getAntiguidade();

        if (anos >= getLimiteAntiguidadeInferior() && anos <= getLimiteAntiguidadeIntermedio()) {
            result = getPercAntiguidade1() / 100.0 * AtletaSemiProfissional.getParcelaFixa();
        } else if (anos > getLimiteAntiguidadeIntermedio() && anos <= getLimiteAntiguidadeSuperior()) {
            result = getPercAntiguidade2() / 100.0 * AtletaSemiProfissional.getParcelaFixa();
        } else if (anos > getLimiteAntiguidadeSuperior()) {
            result = getPercAntiguidade3() / 100.0 * AtletaSemiProfissional.getParcelaFixa();
        } else {
            result = 0;
        }
        return result;
    }

    /**
     *
     * @return o cálculo do vencimento auferido pelo atleta semi-profissional
     */
    @Override
    public double calcularVencimento() {
        return getParcelaFixa() + getparcelaVariavel();
    }

    /**
     *
     * @return o cálculo do valor da retenção de IRS a deduzir ao vencimento do
     * atleta semi-profissional
     */
    @Override
    public double calcularRetencaoIRS() {
        return TAXA_RETENCAO_IRS / 100.0 * calcularVencimento();
    }

    /**
     *
     * @return Override do método toString
     */
    @Override
    public String toString() {
        return "AtletaSemiProfissional{"
                + super.toString() + '}';
    }

    /**
     * @return o número de instâncias criadas do tipo atleta semi-profissional
     */
    public static int getContadorAtletaSemiProfissional() {
        return contadorAtletaSemiProfissional;
    }

    /**
     * @return valor monetário fixo auferido pelo atleta (igual para todos os
     * atletas semi-profissionais)
     */
    public static double getParcelaFixa() {
        return parcelaFixa;
    }

    /**
     * @param aParcelaFixa especifica um novo valor monetário fixo auferido pelo
     * atleta (igual para todos os atletas semi-profissionais)
     */
    public static void setParcelaFixa(double aParcelaFixa) {
        parcelaFixa = aParcelaFixa;
    }

}
