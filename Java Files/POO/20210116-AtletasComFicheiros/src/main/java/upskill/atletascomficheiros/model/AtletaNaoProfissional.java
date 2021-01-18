package upskill.atletascomficheiros.model;

/**
 *
 * @author Jorge Pires Data de criação: 24/11/2020
 * @version 0.1
 */
public abstract class AtletaNaoProfissional extends Atleta {

    /**
     * Variável de instância - número de anos de filiação do atleta no clube
     * desportivo
     */
    private int antiguidade;

    /**
     * Valor por omissão - número de anos de filiação do atleta no clube
     * desportivo
     */
    private static final int ANTIGUIDADE_POR_OMISSAO = 0;

    /**
     * Variável de classe - valor percentual a aplicar no cálculo da parcela de
     * vencimento se a filiação do atleta é [5, 10] anos
     */
    private static double percAntiguidade1 = 2;

    /**
     * Variável de classe - valor percentual a aplicar no cálculo da parcela de
     * vencimento se a filiação do atleta é ]10, 20] anos
     */
    private static double percAntiguidade2 = 8;

    /**
     * Variável de classe - valor percentual a aplicar no cálculo da parcela de
     * vencimento se a filiação do atleta é maior que 20 anos
     */
    private static double percAntiguidade3 = 20;

    /**
     * Variável de classe - valor do limite de antiguidade inferior
     */
    private static int limiteAntiguidadeInferior = 5;

    /**
     * Variável de classe - valor do limite de antiguidade intermédio
     */
    private static int limiteAntiguidadeIntermedio = 10;

    /**
     * Variável de classe - valor do limite de antiguidade superior
     */
    private static int limiteAntiguidadeSuperior = 20;

    /**
     * Variável de classe - conta o número de instâncias criadas do tipo atleta
     * não profissional
     */
    private static int contadorAtletasNaoProfissionais = 0;

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
    public AtletaNaoProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio, int antiguidade) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio);
        this.antiguidade = antiguidade;
        contadorAtletasNaoProfissionais++;
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
    public AtletaNaoProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, int antiguidade) {
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr);
        this.antiguidade = antiguidade;
        contadorAtletasNaoProfissionais++;
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public AtletaNaoProfissional() {
        super();
        antiguidade = ANTIGUIDADE_POR_OMISSAO;
        contadorAtletasNaoProfissionais++;
    }
    
    public AtletaNaoProfissional(String nome, String idCivil, String genero, String idade, String tipoAtividade, String iT, String fcr, String premio, String antiguidade) throws IllegalArgumentException{
        super(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, antiguidade);
    }

    /**
     * @return número de anos de filiação do atleta no clube desportivo
     */
    public int getAntiguidade() {
        return antiguidade;
    }

    /**
     * @param antiguidade especifica um novo número de anos de filiação do
     * atleta no clube desportivo
     */
    public void setAntiguidade(int antiguidade) {
        this.antiguidade = antiguidade;
    }

    /**
     *
     * @return Override do método toString
     */
    @Override
    public String toString() {
        return String.format("%s Antiguidade: %d anos", super.toString(), getAntiguidade());
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.antiguidade;
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
        final AtletaNaoProfissional other = (AtletaNaoProfissional) obj;
        if (this.antiguidade != other.antiguidade) {
            return false;
        }
        return true;
    }

    /**
     * @return o valor percentual a aplicar no cálculo da parcela de vencimento
     * se a filiação do atleta é [5, 10] anos
     */
    public static double getPercAntiguidade1() {
        return percAntiguidade1;
    }

    /**
     * @return o valor percentual a aplicar no cálculo da parcela de vencimento
     * se a filiação do atleta é ]10, 20] anos
     */
    public static double getPercAntiguidade2() {
        return percAntiguidade2;
    }

    /**
     * @return o valor percentual a aplicar no cálculo da parcela de vencimento
     * se a filiação do atleta é maior que 20 anos
     */
    public static double getPercAntiguidade3() {
        return percAntiguidade3;
    }

    /**
     * @return o número de instâncias criadas do tipo atleta não profissional
     */
    public static int getContadorAtletasNaoProfissionais() {
        return contadorAtletasNaoProfissionais;
    }

    /**
     * @return o valor do limite de antiguidade inferior
     */
    public static int getLimiteAntiguidadeInferior() {
        return limiteAntiguidadeInferior;
    }

    /**
     * @return o valor do limite de antiguidade intermédio
     */
    public static int getLimiteAntiguidadeIntermedio() {
        return limiteAntiguidadeIntermedio;
    }

    /**
     * @return o valor do limite de antiguidade superior
     */
    public static int getLimiteAntiguidadeSuperior() {
        return limiteAntiguidadeSuperior;
    }

    /**
     * @param aPercAntiguidade1 especifica novo valor percentual a aplicar no
     * cálculo da parcela de vencimento se a filiação do atleta é [5, 10] anos
     */
    public static void setPercAntiguidade1(double aPercAntiguidade1) {
        percAntiguidade1 = aPercAntiguidade1;
    }

    /**
     * @param aPercAntiguidade2 especifica novo valor percentual a aplicar no
     * cálculo da parcela de vencimento se a filiação do atleta é ]10, 20] anos
     */
    public static void setPercAntiguidade2(double aPercAntiguidade2) {
        percAntiguidade2 = aPercAntiguidade2;
    }

    /**
     * @param aPercAntiguidade3 especifica novo valor percentual a aplicar no
     * cálculo da parcela de vencimento se a filiação do atleta é maior que 20
     * anos
     */
    public static void setPercAntiguidade3(double aPercAntiguidade3) {
        percAntiguidade3 = aPercAntiguidade3;
    }

    /**
     * @param aLimiteAntiguidadeInferior especifica novo valor do limite de
     * antiguidade inferior
     */
    public static void setLimiteAntiguidadeInferior(int aLimiteAntiguidadeInferior) {
        limiteAntiguidadeInferior = aLimiteAntiguidadeInferior;
    }

    /**
     * @param aLimiteAntiguidadeIntermedio especifica novo valor do limite de
     * antiguidade intermédio
     */
    public static void setLimiteAntiguidadeIntermedio(int aLimiteAntiguidadeIntermedio) {
        limiteAntiguidadeIntermedio = aLimiteAntiguidadeIntermedio;
    }

    /**
     * @param aLimiteAntiguidadeSuperior especifica novo valor do limite de
     * antiguidade superior
     */
    public static void setLimiteAntiguidadeSuperior(int aLimiteAntiguidadeSuperior) {
        limiteAntiguidadeSuperior = aLimiteAntiguidadeSuperior;
    }

    /**
     *
     * @return o cálculo do vencimento auferido pelo atleta não profissional
     */
    @Override
    public abstract double calcularVencimento();

}
