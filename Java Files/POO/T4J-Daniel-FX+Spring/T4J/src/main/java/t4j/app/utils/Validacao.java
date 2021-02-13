package t4j.app.utils;

import t4j.app.exception.ElementoInvalidoException;
import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.UrlValidator;

public class Validacao {

    /**
     * Constante - número máximo de caractéres do código da área de atividade
     */
    private static final int CODIGO_AREA_ATIVIDADE_LENGTH = 20;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String CODIGO_AREA_ATIVIDADE_REGEX = "[a-zA-Z0-9]+";
    
    /**
     * Constante - número máximo de caractéres do código da competência técnica
     */
    private static final int CODIGO_COMPETENCIA_TECNICA_LENGTH = 20;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String CODIGO_COMPETENCIA_TECNICA_REGEX = "[a-zA-Z0-9]+";
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String CODIGO_POSTAL_REGEX = "[1-9][0-9]{3}-[0-9]{3}";
    
    /**
     * Constante - caractéres que a validação aceita
     */
    private static final int CUSTO_ESTIMADO_TAREFA_LENGTH = 16;
    
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String CUSTO_ESTIMADO_TAREFA_REGEX = "[0-9,.]+";
    
    /**
     * Constante - número máximo de caractéres da descrição da área de atividade
     */
    private static final int DESCRICAO_BREVE_AREA_ATIVIDADE_LENGTH = 256;
    
    /**
     * Constante - número máximo de caractéres da descrição breve da competência técnica
     */
    private static final int DESCRICAO_BREVE_COMPETENCIA_TECNICA_LENGTH = 60;
    
    /**
     * Constante - número máximo de caractéres da descrição de categoria de tarefa
     */
    private static final int DESCRICAO_CATEGORIA_LENGTH = 1024;
    
    /**
     * Constante - número máximo de caractéres da descrição detalhada da área de atividade
     */
    private static final int DESCRICAO_DETALHADA_AREA_ATIVIDADE_LENGTH = 1024;
    
    /**
     * Constante - número máximo de caractéres da descrição detalhada da competência técnica
     */
    private static final int DESCRICAO_DETALHADA_COMPETENCIA_TECNICA_LENGTH = 1024;
    
    /**
     * Constante - número máximo de caractéres da descrição informal da tarefa
     */
    private static final int DESCRICAO_INFORMAL_TAREFA_LENGTH = 1024;
    
    /**
     * Constante - número máximo de caractéres da descrição técnica da tarefa
     */
    private static final int DESCRICAO_TECNICA_TAREFA_LENGTH = 1024;
    
    /**
     * Constante - número máximo de caractéres da descrição do grau de proficiência
     */
    private static final int DESIGNACAO_GRAU_PROFICIENCIA_LENGTH = 256;
    
    /**
     * Constante - número máximo de caractéres da designação da tarefa
     */
    private static final int DESIGNACAO_TAREFA_LENGTH = 60;
    
    /**
     * Constante - número máximo de dígitos da duração estimada de tarefa
     */
    private static final int DURACAO_ESTIMADA_TAREFA_LENGTH = 6;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String DURACAO_ESTIMADA_TAREFA_REGEX = "[0-9]+";
    
    /**
     * Constante - número máximo de caractéres do email
     */
    private static final int EMAIL_LENGTH = 254;
    
    /**
     * Constante - número máximo de caractéres da função do colaborador
     */
    private static final int FUNCAO_COLABORADOR_LENGTH = 50;
    
    /**
     * Constante - número máximo de caractéres da localidade
     */
    private static final int LOCALIDADE_LENGTH = 50;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String LOCALIDADE_REGEX = "[a-zA-ZÀ-ú ]+";
    
    /**
     * Constante - número máximo de caractéres da morada
     */
    private static final int MORADA_LENGTH = 256;
    
    /**
     * Constante - número máximo de dígitos do NIF
     */
    private static final int NIF_LENGTH = 9;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String NIF_REGEX = "[0-9]+";
    
    /**
     * Constante - número máximo de caractéres do nome do colaborador
     */
    private static final int NOME_COLABORADOR_LENGTH = 50;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String NOME_COLABORADOR_REGEX = "[a-zA-ZÀ-ú ]+";
    
    /**
     * Constante - número máximo de caractéres do nome da organização
     */
    private static final int NOME_ORGANIZACAO_LENGTH = 50;
    
    /**
     * Constante - número máximo de caractéres da referência da tarefa
     */
    private static final int REFERENCIA_TAREFA_LENGTH = 20;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String REFERENCIA_TAREFA_REGEX = "[a-zA-Z0-9 ]+";
    
    
    /**
     * Constante - número máximo de dígitos do telefone
     */
    private static final int TELEFONE_LENGTH_MAX = 16;
    
    
    /**
     * Constante - número mínimo de dígitos do telefone
     */
    private static final int TELEFONE_LENGTH_MIN = 9;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String TELEFONE_REGEX = "[0-9]+";
    
    /**
     * Constante - número máximo de dígitos do grau de proficiência
     */
    private static final int VALOR_GRAU_PROFICIENCIA_LENGTH = 2;
    
    /**
     * Constante - caractéres que a validação aceita e seu formato
     */
    private static final String VALOR_GRAU_PROFICIENCIA_REGEX = "[0-9]+";
    
    /**
     * Constante - número máximo de caractéres do website
     */
    private static final int WEBSITE_LENGTH = 253;

    /**
     * 
     * @param codigoAreaAtividade código de área de atividade a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaCodigoAreaAtividade(String codigoAreaAtividade) {
        return codigoAreaAtividade != null
                && validaRegex(codigoAreaAtividade, CODIGO_AREA_ATIVIDADE_REGEX)
                && validaTamanhoMaximo(codigoAreaAtividade.length(), CODIGO_AREA_ATIVIDADE_LENGTH);
    }

    /**
     * 
     * @param codigoCompetenciaTecnica código de competencia técnica a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaCodigoCompetenciaTecnica(String codigoCompetenciaTecnica) {
        return codigoCompetenciaTecnica != null
                &&validaRegex(codigoCompetenciaTecnica, CODIGO_COMPETENCIA_TECNICA_REGEX)
                && validaTamanhoMaximo(codigoCompetenciaTecnica.length(), CODIGO_COMPETENCIA_TECNICA_LENGTH);
    }

    /**
     * 
     * @param codigoPostal código postal a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaCodigoPostal(String codigoPostal) {
        return codigoPostal != null
                && validaRegex(codigoPostal, CODIGO_POSTAL_REGEX);
    }

    /**
     * 
     * @param custoEstimado custo estimado da tarefa a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaCustoEstimadoTarefa(String custoEstimado) {
        return Double.valueOf(custoEstimado) != null
                && validaRegex(custoEstimado, CUSTO_ESTIMADO_TAREFA_REGEX)
                && validaTamanhoMaximo(custoEstimado.length(), CUSTO_ESTIMADO_TAREFA_LENGTH);
    }

    /**
     * 
     * @param descricaoBreveAreaAtividade descrição breve da área de atividade a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDescricaoBreveAreaAtividade(String descricaoBreveAreaAtividade) {
        return descricaoBreveAreaAtividade != null
                && !descricaoBreveAreaAtividade.isEmpty()
                && validaTamanhoMaximo(descricaoBreveAreaAtividade.length(), DESCRICAO_BREVE_AREA_ATIVIDADE_LENGTH);
    }

    /**
     * 
     * @param descricaoBreve descrição breve da compmtência técnica a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDescricaoBreveCompetenciaTecnica(String descricaoBreve) {
        return descricaoBreve != null
                && !descricaoBreve.isEmpty()
                && validaTamanhoMaximo(descricaoBreve.length(), DESCRICAO_BREVE_COMPETENCIA_TECNICA_LENGTH);
    }

    /**
     * 
     * @param descricaoCategoria descrição da categoria a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDescricaoCategoria(String descricaoCategoria) {
        return descricaoCategoria != null
                && !descricaoCategoria.isEmpty()
                && validaTamanhoMaximo(descricaoCategoria.length(), DESCRICAO_CATEGORIA_LENGTH);
    }

    /**
     * 
     * @param descricaoDetalhadaAreaAtividade descrição detalhada da área de atividade a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDescricaoDetalhadaAreaAtividade(String descricaoDetalhadaAreaAtividade) {
        return descricaoDetalhadaAreaAtividade != null
                && !descricaoDetalhadaAreaAtividade.isEmpty()
                && validaTamanhoMaximo(descricaoDetalhadaAreaAtividade.length(), DESCRICAO_DETALHADA_AREA_ATIVIDADE_LENGTH);
    }

    /**
     * 
     * @param descricaoDetalhada descrição detalhada da competência técnica a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDescricaoDetalhadaCompetenciaTecnica(String descricaoDetalhada) {
        return descricaoDetalhada != null
                && !descricaoDetalhada.isEmpty()
                && validaTamanhoMaximo(descricaoDetalhada.length(), DESCRICAO_DETALHADA_COMPETENCIA_TECNICA_LENGTH);
    }

    /**
     * 
     * @param descricaoInformal descrição informal da tarefa a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDescricaoInformalTarefa(String descricaoInformal) {
        return descricaoInformal != null
                && !descricaoInformal.isEmpty()
                && validaTamanhoMaximo(descricaoInformal.length(), DESCRICAO_INFORMAL_TAREFA_LENGTH);
    }

    /**
     * 
     * @param descricaoTecnica descrição técnica da tarefa a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDescricaoTecnicaTarefa(String descricaoTecnica) {
        return descricaoTecnica != null&&
                !descricaoTecnica.isEmpty()
                && validaTamanhoMaximo(descricaoTecnica.length(), DESCRICAO_TECNICA_TAREFA_LENGTH);
    }

    /**
     * 
     * @param designacaoGrauProficiencia designação do grau de proficiência a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDesignacaoGrauProficiencia(String designacaoGrauProficiencia) {
        return designacaoGrauProficiencia != null
                && !designacaoGrauProficiencia.isEmpty()
                && validaTamanhoMaximo(designacaoGrauProficiencia.length(), DESIGNACAO_GRAU_PROFICIENCIA_LENGTH);
    }

    /**
     * 
     * @param designacao designação da tarefa a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDesignacaoTarefa(String designacao) {
        return designacao != null
                && !designacao.isEmpty()
                && validaTamanhoMaximo(designacao.length(), DESIGNACAO_TAREFA_LENGTH);
    }

    /**
     * 
     * @param duracaoEstimada duração estimada da tarefa a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaDuracaoEstimadaTarefa(String duracaoEstimada) {
        return duracaoEstimada != null
                && validaRegex(duracaoEstimada, DURACAO_ESTIMADA_TAREFA_REGEX)
                && validaTamanhoMaximo(duracaoEstimada.length(), DURACAO_ESTIMADA_TAREFA_LENGTH);
    }

    /**
     * 
     * @param email email a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return email != null
                && emailValidator.isValid(email)
                && validaTamanhoMaximo(email.length(), EMAIL_LENGTH);
    }

    /**
     * 
     * @param funcao função do colaborador a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaFuncaoColaborador(String funcao) {
        return funcao != null
                && !funcao.isEmpty()
                && validaTamanhoMaximo(funcao.length(), FUNCAO_COLABORADOR_LENGTH);
    }

    /**
     * 
     * @param localidade nome da localidade a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaLocalidade(String localidade) {
        return localidade != null
                && validaRegex(localidade, LOCALIDADE_REGEX)
                && validaTamanhoMaximo(localidade.length(), LOCALIDADE_LENGTH);
    }

    /**
     * 
     * @param morada morada a ser validada
     * @return true se válido e false se inválido
     */
    public static boolean validaMorada(String morada) {
        return morada != null
                &&!morada.isEmpty()
                && validaTamanhoMaximo(morada.length(), MORADA_LENGTH);
    }

    /**
     * 
     * @param nif nif a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaNif(String nif) {
        return nif != null
                && validaRegex(nif, NIF_REGEX)
                && nif.length() == NIF_LENGTH;
    }

    /**
     * 
     * @param nome nome do colaborador a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaNomeColaborador(String nome) {
        return nome != null
                &&validaRegex(nome, NOME_COLABORADOR_REGEX)
                && validaTamanhoMaximo(nome.length(), NOME_COLABORADOR_LENGTH);
    }

    /**
     * 
     * @param nome nome da organização a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaNomeOrganizacao(String nome) {
        return nome != null
                &&!nome.isEmpty()
                && validaTamanhoMaximo(nome.length(), NOME_ORGANIZACAO_LENGTH);
    }

    /**
     * 
     * @param referencia referência de tarefa a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaReferenciaTarefa(String referencia) {
        return referencia != null
                && validaRegex(referencia, REFERENCIA_TAREFA_REGEX)
                && validaTamanhoMaximo(referencia.length(), REFERENCIA_TAREFA_LENGTH);
    }

    /**
     * 
     * @param telefone telefone a ser vaidado
     * @return true se válido e false se inválido
     */
    public static boolean validaTelefone(String telefone) {
        return telefone != null
                && validaRegex(telefone, TELEFONE_REGEX)
                && telefone.length() >= TELEFONE_LENGTH_MIN && telefone.length() <= TELEFONE_LENGTH_MAX;
    }

    /**
     * 
     * @param valorGrauProficiencia valor do grau de proficiência a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaValorGrauProficiencia(String valorGrauProficiencia) {
        return valorGrauProficiencia != null
                && validaRegex(valorGrauProficiencia, VALOR_GRAU_PROFICIENCIA_REGEX)
                && validaTamanhoMaximo(valorGrauProficiencia.length(), VALOR_GRAU_PROFICIENCIA_LENGTH);
    }

    /**
     * 
     * @param website wbsite a ser validado
     * @return true se válido e false se inválido
     */
    public static boolean validaWebsiteOrganizacao(String website) {
        UrlValidator urlValidator = new UrlValidator();
        return website != null
                && urlValidator.isValid(website)
                && validaTamanhoMaximo(website.length(), WEBSITE_LENGTH);
    }
    
    /**
     * 
     * @param regex string a ser validada
     * @param regexValido caractéres que a validação aceita e seu formato
     * @return true se válido e false se inválido
     */
    private static boolean validaRegex(String regex, String regexValido) {
        return regex.matches(regexValido);
    }
    
    /**
     * 
     * @param tamanho número de dígitos do número a validar
     * @param tamanhoValido número máximo de dígitos
     * @return true se válido e false se inválido
     */
    private static boolean validaTamanhoMaximo(int tamanho, int tamanhoValido) {
        return tamanho <= tamanhoValido;
    }
}
