package upskill.atletascomficheiros.model;

import java.util.Objects;

/**
 *
 * @author Jorge Pires Data de criação: 24/11/2020
 * @version 0.1 Assumimos que os Atletas serão criados apenas uma vez por mês,
 * ao fim deste. Portanto, a premiação correspondente ao mês sendo registado,
 * assume que já conhecemos os prémios obtidos. Sendo assim, os métodos
 * contrutores dos Atletas requerem que informemos os valores dos prémios
 * obtidos por cada um dos atleta.
 *
 * @author Daniel Junior Data de criação: 24/11/2020
 * @version 0.2 Implementados getters, setters, equals, toString e construtores:
 * sem argumentos, com todos os argumentos excepto prémio, completo (a incluir
 * premio).
 *
 * @author Jorge Pires Data de criação: 25/11/2020
 * @version 0.3 Implementados os métodos de cálculo da FCM e da FCT.
 */
public abstract class Atleta implements Atividade, Comparable<Object> {

    
    /**
     * Variável de instância - nome do atleta
     */
    private String nome;

    /**
     * Variável de instância - número de identificação civil do atleta
     */
    private int idCivil;

    /**
     * Variável de instância - género do atleta (masculino ou feminino)
     */
    private String genero;

    /**
     * Variável de instância - idade do atleta
     */
    private int idade;

    /**
     * Variável de instância - tipo de atividade desportiva que o atleta pratica
     * (corrida, caminhada, natação ou ciclismo)
     */
    private String tipoAtividade;

    /**
     * Variável de instância - percentagem de intensidade de treino do atleta
     * (queimar gordura ou trabalhar capacidade cardiorrespiratória)
     */
    private double iT;

    /**
     * Variável de instância - valor da frequência cardíaca em repouso do atleta
     * (representa o número de batimentos cardíacos em repouso durante 1 minuto)
     */
    private int fcr;

    /**
     * Variável de instância - valor monetário que o atleta conquistou em
     * competições
     */
    private double premio;

    /**
     * Valor por omissão - nome do atleta
     */
    private static final String NOME_POR_OMISSAO = "sem nome";

    /**
     * Valor por omissão - número de identificação civil do atleta
     */
    private static final int ID_CIVIL_POR_OMISSAO = 0;

    /**
     * Valor por omissão - género do atleta (masculino ou feminino)
     */
    private static final String GENERO_POR_OMISSAO = "";

    /**
     * Valor por omissão - idade do atleta
     */
    private static final int IDADE_POR_OMISSAO = 0;

    /**
     * Valor por omissão - tipo de atividade desportiva que o atleta pratica
     * (corrida, caminhada, natação ou ciclismo)
     */
    private static final String TIPO_ATIVIDADE_POR_OMISSAO = "";

    /**
     * Valor por omissão - valor da frequência cardíaca em repouso do atleta
     * (representa o número de batimentos cardíacos em repouso durante 1 minuto)
     */
    private static final double IT_POR_OMISSAO = 0.6;

    /**
     * Variável de instância por omissão - valor da frequência cardíaca em
     * repouso do atleta (representa o número de batimentos cardíacos em repouso
     * durante 1 minuto)
     */
    private static final int FCR_POR_OMISSAO = 0;

    /**
     * Variável de instância por omissão - valor monetário que o atleta
     * conquistou em competições
     */
    private static final double PREMIO_POR_OMISSAO = 0.0;

    /**
     * Variável de classe - conta o número de instâncias criadas do tipo atleta
     */
    private static int contadorAtletas = 0;

    // TODOS OS CONSTRUTORS/SETTERS NÃO ESTÃO A SER VALIDADOS - Validar tipoAtividade baseado na Interface "Atividade" que contém constantes das atividades permitidas.
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
     *
     */
    public Atleta(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio) {
        this.nome = nome;
        this.idCivil = idCivil;
        this.genero = genero;
        this.idade = idade;
        this.tipoAtividade = tipoAtividade;
        this.iT = iT;
        this.fcr = fcr;
        this.premio = premio;
        contadorAtletas++;
    }

    /**
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
     * @premio recebe o valor PREMIO_POR_OMISSAO
     */
    public Atleta(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr) {
        this.nome = nome;
        this.idCivil = idCivil;
        this.genero = genero;
        this.idade = idade;
        this.tipoAtividade = tipoAtividade;
        this.iT = iT;
        this.fcr = fcr;
        this.premio = PREMIO_POR_OMISSAO;
        contadorAtletas++;
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public Atleta() {
        nome = NOME_POR_OMISSAO;
        idCivil = ID_CIVIL_POR_OMISSAO;
        genero = GENERO_POR_OMISSAO;
        idade = IDADE_POR_OMISSAO;
        tipoAtividade = TIPO_ATIVIDADE_POR_OMISSAO;
        iT = IT_POR_OMISSAO;
        fcr = FCR_POR_OMISSAO;
        premio = PREMIO_POR_OMISSAO;
        contadorAtletas++;
    }

    /**
     * @return nome do atleta
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return número de identificação civil
     */
    public int getIdCivil() {
        return idCivil;
    }

    /**
     * @return género do atleta (masculino ou feminino)
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @return idade do atleta
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @return tipo de atividade desportiva que o atleta pratica (corrida,
     * caminhada, natação ou ciclismo)
     */
    public String getTipoAtividade() {
        return tipoAtividade;
    }

    /**
     * @return percentagem de intensidade de treino do atleta (queimar gordura
     * ou trabalhar capacidade cardiorrespiratória)
     */
    public double getiT() {
        return iT;
    }

    /**
     * @return valor da frequência cardíaca em repouso do atleta (representa o
     * número de batimentos cardíacos em repouso durante 1 minuto)
     */
    public int getFcr() {
        return fcr;
    }

    /**
     * @return valor monetário que o atleta conquistou em competições
     */
    public double getPremio() {
        return premio;
    }

    /**
     * @param nome especifica um novo nome do atleta
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param idCivil especifica um novo número de identificação civil
     */
    public void setIdCivil(int idCivil) {
        this.idCivil = idCivil;
    }

    /**
     * @param genero especifica um novo género do atleta (masculino ou feminino)
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @param idade especifica uma nova idade do atleta
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @param tipoAtividade especifica um novo
     */
    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    /**
     * @param iT especifica um novo tipo de atividade desportiva que o atleta
     * pratica (corrida, caminhada, natação ou ciclismo)
     */
    public void setiT(double iT) {
        this.iT = iT;
    }

    /**
     * @param fcr especifica uma nova percentagem de intensidade de treino do
     * atleta (queimar gordura ou trabalhar capacidade cardiorrespiratória)
     */
    public void setFcr(int fcr) {
        this.fcr = fcr;
    }

    /**
     * @param premio especifica um novo valor monetário que o atleta conquistou
     * em competições
     */
    public void setPremio(double premio) {
        this.premio = premio;
    }

    /**
     *
     * @return Override do método toString
     */
    @Override
    public String toString() {
        return "Atleta{"
                + "Nome: " + nome
                + ", idCivil: " + idCivil
                + ", genero: " + genero
                + ", idade: " + idade
                + ", tipoAtividade: " + tipoAtividade
                + ", iT: " + iT
                + ", FCR: " + fcr
                + ", premio: " + premio
                + '}';
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + this.idCivil;
        hash = 19 * hash + Objects.hashCode(this.genero);
        hash = 19 * hash + this.idade;
        hash = 19 * hash + Objects.hashCode(this.tipoAtividade);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.iT) ^ (Double.doubleToLongBits(this.iT) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.premio) ^ (Double.doubleToLongBits(this.premio) >>> 32));
        hash = 19 * hash + this.fcr;
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
        final Atleta other = (Atleta) obj;
        if (this.idCivil != other.idCivil) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (this.fcr != other.fcr) {
            return false;
        }
        if (Double.doubleToLongBits(this.iT) != Double.doubleToLongBits(other.iT)) {
            return false;
        }
        if (Double.doubleToLongBits(this.premio) != Double.doubleToLongBits(other.premio)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.tipoAtividade, other.tipoAtividade)) {
            return false;
        }
        return true;
    }

    /**
     * @return o número de instâncias criadas do tipo atleta
     */
    public static int getContadorAtletas() {
        return contadorAtletas;
    }

    /**
     *
     * @return o cáclculo da frequência cardíaca máxima
     */
    public double calcularFCM() {
        double calculo;

        switch (this.getTipoAtividade()) {
            case CAMINHADA:
            case CORRIDA: {
                calculo = 208.75 - (0.73 * getIdade());
                break;
            }
            case CICLISMO: {
                calculo = (this.getGenero().equalsIgnoreCase(GENERO_F))
                        ? 189 - (0.56 * getIdade())
                        : 202 - (0.72 * getIdade());
                break;
            }

            case NATACAO: {
                calculo = 204 - (1.7 * getIdade());
                break;
            }
            default:
                calculo = 0.0;

        } // Alterada if-cascade para Switch-Statement - Daniel junior - 2020-11-25 12:02

//        if (this.getTipoAtividade().equalsIgnoreCase(CAMINHADA)) || this.getTipoAtividade().equalsIgnoreCase(CORRIDA) && this.getGenero().equalsIgnoreCase(GENERO_F) || this.getGenero().equalsIgnoreCase(GENERO_M)) {
//            calculo = 208.75 - (0.73 * getIdade());
//        } else if (this.getTipoAtividade().equalsIgnoreCase(CICLISMO) && this.getGenero().equalsIgnoreCase(GENERO_F)) {
//            calculo = 189 - (0.56 * getIdade());
//        } else if (this.getTipoAtividade().equalsIgnoreCase(CICLISMO) && this.getGenero().equalsIgnoreCase(GENERO_M)) {
//            calculo = 202 - (0.72 * getIdade());
//        } else {
//            calculo = 204 - (1.7 * getIdade());
//        }
        return calculo;
    }

    /**
     *
     * @return o cálculo da frequência cardíaca de trabalho
     */
    public double calcularFCT() {
        return getFcr() + (getiT() * (calcularFCM() - getFcr()));
    }

    /**
     *
     * @return o cálculo do vencimento auferido pelo atleta
     */
    public abstract double calcularVencimento();

    /**
     *
     * @param o objeto a ser comparado
     * @return a diferença numérica entre os caractéres de uma string
     * @see String.compareTo()
     */
    @Override
    public int compareTo(Object o) { // Daniel Junior Adicionou a função CompareTo in 2020-11-25 07:51
        return this.getNome().compareToIgnoreCase(((Atleta) o).getNome());
    }

    /**
     *
     * @return all the values contained in TipoAtividades Enum (created in 
     * 20210117 1656 by Daniel Junior) for populating the ComboBox for the UI 
     * interface.
     */
    public static String[] getTipoAtividades(){
        String[] result = new String[TipoAtividades.values().length];
        int i = 0;
        for (TipoAtividades tipoatividade : TipoAtividades.values()) {
            result[i++] = tipoatividade.toString();
        }
        return result;
    }
    
    /**
     * @return all the values contained in IntensidadeTreinos Enum (created in 
     * 20210117 1656 by Daniel Junior) for populating the ComboBox for the UI 
     * interface.
     */
    public static String[] getIntensidadeTreinos() {
        return new String[20];
    }

    
}
