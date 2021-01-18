package upskill.atletascomficheiros.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author Jorge Pires Data de criação: 24/11/2020
 * @version 0.1
 *
 * @author Daniel Junior Data de criação: 25/11/2020
 * @version 0.2
 */
public class ClubeDesportivo {

    /**
     * Variável de instância - nome do clube desportivo
     */
    private String nome;

    /**
     * Variável de instância - data da fundação do clube desportivo
     */
    private Date data;

    /**
     * Variável de instância - criação do contentor do tipo {@literal <Atleta>}
     */
    private List<Atleta> atletas; // alterada criação do contentor para o tipo List. Porém, contento ainda será do tipo ArrayList. Essa alteração foi necessária para que possamos utilizar a função Sort da Interface Collections e ordenar a ArrayList fazendo uso da interface Comparable

    /**
     * Valor por omissão - nome do clube desportivo
     */
    private static String NOME_POR_OMISSAO = "sem designação";

    /**
     * Valor por omissão - data da fundação do clube desportivo
     */
    private static Date DATA_POR_OMISSAO = java.util.Calendar.getInstance().getTime();

    /**
     *
     * @param nome - nome do clube desportivo
     * @param data - data da fundação do clube desportivo
     * @param atletas criação do contentor do tipo {@literal <Atleta>}
     */
    public ClubeDesportivo(String nome, Date data, List<Atleta> atletas) {
        this.nome = nome;
        this.data = data;
        this.atletas = atletas;
    }

    /**
     *
     * @param nome - nome do clube desportivo
     * @param data - data da fundação do clube desportivo
     */
    public ClubeDesportivo(String nome, Date data) {
        this.nome = nome;
        this.data = data;
        this.atletas = new ArrayList<Atleta>();
    }

    /**
     *
     * @param nome - nome do clube desportivo
     */
    public ClubeDesportivo(String nome) {
        this.nome = nome;
        this.data = DATA_POR_OMISSAO;
        this.atletas = new ArrayList<Atleta>();
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public ClubeDesportivo() {
        nome = NOME_POR_OMISSAO;
        data = DATA_POR_OMISSAO;
        atletas = new ArrayList<Atleta>();
    }

    public String[] getListaAtletasAsStringArray() {
        String[] arrayAtletas = new String[atletas.size()];
        int i = 0;
        for (Atleta atleta : atletas) {
            arrayAtletas[i++] = atleta.toString();
        }
        return arrayAtletas;
    }

    /**
     * @return nome do clube desportivo
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return data da fundação do clube desportivo
     */
    public Date getData() {
        return data;
    }

    /**
     * @return do contentor do tipo {@literal <Atleta>}
     */
    public List<Atleta> getAtletas() {
        return atletas;
    }

    /**
     * @param nome especifica um novo nome do clube desportivo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param data especifica uma nova data da fundação do clube desportivo
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     *
     * @return Override do método toString
     */
    @Override
    public String toString() {
        return "Clube Desportivo{"
                + "Nome: " + nome
                + ", Data de fundação: " + data
                + ", Possui atualmente: " + atletas.size() + " atletas registados."
                + '}';
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.data);
        hash = 43 * hash + Objects.hashCode(this.atletas);
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
        final ClubeDesportivo other = (ClubeDesportivo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.atletas, other.atletas)) {
            return false;
        }
        return true;
    }

    // Métodos (com overloading) para adição de um atleta profissional utilizando os 3 construtores possíveis
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
    public void adicionarAtletaProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio, double parcelaFixa) {
        atletas.add(new AtletaProfissional(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, parcelaFixa));
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
    public void adicionarAtletaProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double parcelaFixa) {
        atletas.add(new AtletaProfissional(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, parcelaFixa));
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public void adicionarAtletaProfissional() {
        atletas.add(new AtletaProfissional());
    }

    // Métodos (com overloading) para adição de um atleta semiprofissional utilizando os 3 construtores possíveis
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
    public void adicionarAtletaSemiProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio, int antiguidade) {
        atletas.add(new AtletaSemiProfissional(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, antiguidade));
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
    public void adicionarAtletaSemiProfissional(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, int antiguidade) {
        atletas.add(new AtletaSemiProfissional(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, antiguidade));
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public void adicionarAtletaSemiProfissional() {
        atletas.add(new AtletaSemiProfissional());
    }

    // Métodos (com overloading) para adição de um atleta amador utilizando os 3 construtores possíveis
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
     * @return 
     */
    public void adicionarAtletaAmador(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, double premio, int antiguidade) {
        atletas.add(new AtletaAmador(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, antiguidade));
    }
    public boolean adicionarAtletaAmador(String nome, String idCivil, String genero, String idade, String tipoAtividade, String iT, String fcr, String premio, String antiguidade) throws  IllegalArgumentException{
        return atletas.add(new AtletaAmador(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, premio, antiguidade));
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
    public void adicionarAtletaAmador(String nome, int idCivil, String genero, int idade, String tipoAtividade, double iT, int fcr, int antiguidade) {
        atletas.add(new AtletaAmador(nome, idCivil, genero, idade, tipoAtividade, iT, fcr, antiguidade));
    }

    /**
     * Construtor com valores POR_OMISSAO
     */
    public void adicionarAtletaAmador() {
        atletas.add(new AtletaAmador());
    }

    /**
     *
     * @return um contentor temporário com os objetos do tipo
     * {@literal <Atleta>} listados por ordem alfabética
     */
    public List<Atleta> listarAtletasOrdemAlfabetica() {
        List<Atleta> tempAtletas = new ArrayList<Atleta>(atletas);
        Collections.sort(tempAtletas);
        return tempAtletas;
    }

    /**
     *
     * @return um contentor temporário com os objetos do tipo
     * {@literal <Atleta>} listados por ordem alfabética inversa
     */
    public List<Atleta> listarAtletasOrdemPremiosInversa() {
        List<Atleta> tempAtletas = new ArrayList<Atleta>(atletas);
        Collections.sort(tempAtletas, Collections.reverseOrder(new AtletaValorPremioComparator()));
        return tempAtletas;
    }

    /**
     *
     * @return um contentor temporário com os objetos do tipo
     * {@literal <Atleta>} listados por ordem categoria, modalidade e nome
     */
    public List<Atleta> listarAtletasPorCategoriaModalidadeENome() {
        List<Atleta> tempAtletas = new ArrayList<Atleta>(atletas);
        Collections.sort(tempAtletas, new AtletaCategoriaModalidadeENomeComparator());
        return tempAtletas;
    }

    /**
     *
     * @return o cálculo da soma dos valores da retenção de IRS a deduzir aos
     * vencimentos dos atletas
     */
    public double calcularIRSTotal() {
        double sumIRS = 0.0;
        for (Atleta atleta : this.getAtletas()) {
            if (atleta != null && atleta instanceof RetencaoIRS) {
                sumIRS += ((RetencaoIRS) atleta).calcularRetencaoIRS();
            }
        }
        return sumIRS;
    }

}
