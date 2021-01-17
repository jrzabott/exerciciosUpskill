package upskill.atletascomficheiros.model;

/**
 *
 * @author Jorge Pires Data de criação: 24/11/2020
 * @version 0.1
 */
public class AtletaProfissional extends Atleta implements RetencaoIRS {

    /**
     * Variável de instância - valor monetário fixo auferido pelo atleta
     */
    private double parcelaFixa;

    /**
     * Valor por omissão - valor monetário fixo auferido pelo atleta
     */
    private static final double PARCELAFIXA_POR_OMISSAO = 0;

    /**
     * Variável de classe - valor percentual a aplicar na parcela variável do
     * cálculo do vencimento do atleta profissional
     */
    private static double percParcelaVariavel = 20;

    /**
     * Variável de classe - conta o número de instâncias criadas do tipo atleta
     * profissional
     */
    private static int contadorAtletasProfissionais = 0;

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
     * @param parcelaFixa valor monetário fixo auferido pelo atleta
     */
    public AtletaProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio, double parcelaFixa) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio);
        this.parcelaFixa = parcelaFixa;
        contadorAtletasProfissionais++;
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
     * @param parcelaFixa valor monetário fixo auferido pelo atleta
     */
    public AtletaProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double parcelaFixa) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr);
        this.parcelaFixa = parcelaFixa;
        contadorAtletasProfissionais++;
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public AtletaProfissional() {
        super();
        parcelaFixa = PARCELAFIXA_POR_OMISSAO;
        contadorAtletasProfissionais++;
    }

    /**
     * @return o valor da parcela fixa do vencimento do atleta profissional
     */
    public double getParcelaFixa() {
        return parcelaFixa;
    }

    /**
     * @param parcelaFixa especifica um novo valor da parcela fixa do vencimento
     * do atleta profissional
     */
    public void setParcelaFixa(double parcelaFixa) {
        this.parcelaFixa = parcelaFixa;
    }

    /**
     *
     * @return Override do método toString
     */
    @Override
    public String toString() {
        return String.format("%s {%s Parcela Fixa: %.2f€}}", this.getClass().getSimpleName(), super.toString(), getParcelaFixa());
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.parcelaFixa) ^ (Double.doubleToLongBits(this.parcelaFixa) >>> 32));
        return hash;
    }

    /**
     *
     * @param obj
     * @return Override do método equals e retorna boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final AtletaProfissional other = (AtletaProfissional) obj;
        if (Double.doubleToLongBits(this.parcelaFixa) != Double.doubleToLongBits(other.parcelaFixa)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return o cálculo da parcela variável do vencimento do atleta
     * profissional
     */
    public double calcularParcelaVariavel() {
        return getPremio() * getPercParcelaVariavel() / 100;
    }

    /**
     *
     * @return o cálculo do vencimento auferido pelo atleta profissional
     */
    @Override
    public double calcularVencimento() {
        return getParcelaFixa() + calcularParcelaVariavel();
    }

    /**
     *
     * @return o cálculo do valor da retenção de IRS a deduzir ao vencimento do
     * atleta profissional
     */
    @Override
    public double calcularRetencaoIRS() {
        return calcularVencimento() * TAXA_RETENCAO_IRS / 100;
    }

    /**
     * @return o valor percentual da parcela variável do vencimento do atleta
     * profissional
     */
    public static double getPercParcelaVariavel() {
        return percParcelaVariavel;
    }

    /**
     * @return o número de instâncias criadas do tipo atleta profissional
     */
    public static int getContadorAtletasProfissionais() {
        return contadorAtletasProfissionais;
    }

    /**
     * @param aPercParcelaVariavel especifica um novo valor percentual da
     * parcela variável do vencimento do atleta profissional
     */
    public static void setPercParcelaVariavel(double aPercParcelaVariavel) {
        percParcelaVariavel = aPercParcelaVariavel;
    }

}
