package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;
import t4j.app.exception.ElementoNaoExistenteException;

public class CompetenciaTecnica implements Serializable {

    /**
     * Variável de instância - código de competência técnica
     */
    private String codigoCompetenciaTecnica;

    /**
     * Variável de instância - descrição breve de competência técnica
     */
    private String descricaoBreve;

    /**
     * Variável de instância - descrição detalhada de competência técnica
     */
    private String descricaoDetalhada;

    /**
     * Variável de instância - área de atividade à qual se refere a competência técnica
     */
    private AreaAtividade areaAtividade;

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    private ArrayList<GrauProficiencia> grausProficiencia;

    /**
     * Construtor completo de competência técnica
     *
     * @param codigoCompetenciaTecnica código de competência técnica
     * @param descricaoBreve descrição breve de competência técnica
     * @param descricaoDetalhada descrição detalhada de competência técnica
     * @param areaAtividade área de atividade à qual se refere a competência técnica
     * @param grausProficiencia contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public CompetenciaTecnica(String codigoCompetenciaTecnica, String descricaoBreve, String descricaoDetalhada, AreaAtividade areaAtividade, ArrayList<GrauProficiencia> grausProficiencia) {
        setCodigoCompetenciaTecnica(codigoCompetenciaTecnica);
        setDescricaoBreve(descricaoBreve);
        setDescricaoDetalhada(descricaoDetalhada);
        this.areaAtividade = new AreaAtividade(areaAtividade);
        this.grausProficiencia = new ArrayList<>(grausProficiencia);
    }

    /**
     * Construtor vazio de competência técnica
     */
    public CompetenciaTecnica() {
        this.areaAtividade = new AreaAtividade();
        this.grausProficiencia = new ArrayList<GrauProficiencia>();
    }

    /**
     * Construtor cópia de competência técnica
     *
     * @param outraCompetenciaTecnica instância do tipo competência técnica a ser copiada
     */
    public CompetenciaTecnica(CompetenciaTecnica outraCompetenciaTecnica) {
        setCodigoCompetenciaTecnica(outraCompetenciaTecnica.codigoCompetenciaTecnica);
        setDescricaoBreve(outraCompetenciaTecnica.descricaoBreve);
        setDescricaoDetalhada(outraCompetenciaTecnica.descricaoDetalhada);
        this.areaAtividade = new AreaAtividade(outraCompetenciaTecnica.areaAtividade);
        this.grausProficiencia = new ArrayList<>(outraCompetenciaTecnica.grausProficiencia);
    }

    /**
     *
     * @return código de competência técnica
     */
    public String getCodigoCompetenciaTecnica() {
        return codigoCompetenciaTecnica;
    }

    /**
     *
     * @return descrição breve de competência técnica
     */
    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    /**
     *
     * @return descrição detalhada de competência técnica
     */
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    /**
     *
     * @return área de atividade à qual se refere a competência técnica
     */
    public AreaAtividade getAreaAtividade() {
        return areaAtividade;
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public ArrayList<GrauProficiencia> getGrausProficiencia() {
        return grausProficiencia;
    }

    /**
     *
     * @param codigoCompetenciaTecnica especifica um novo código de competência técnica
     */
    public void setCodigoCompetenciaTecnica(String codigoCompetenciaTecnica) throws ElementoInvalidoException {
        codigoCompetenciaTecnica = codigoCompetenciaTecnica.trim();
        if (Validacao.validaCodigoCompetenciaTecnica(codigoCompetenciaTecnica)) {
            this.codigoCompetenciaTecnica = codigoCompetenciaTecnica;
        } else {
            throw new ElementoInvalidoException("Código inválido.");
        }
    }

    /**
     *
     * @param descricaoBreve especifica uma nova descrição breve de competência técnica
     */
    public void setDescricaoBreve(String descricaoBreve) throws ElementoInvalidoException {
        descricaoBreve = descricaoBreve.trim();
        if (Validacao.validaDescricaoBreveCompetenciaTecnica(descricaoBreve)) {
            this.descricaoBreve = descricaoBreve;
        } else {
            throw new ElementoInvalidoException("Descrição breve inválida.");
        }
    }

    /**
     *
     * @param descricaoDetalhada especifica uma nova descrição detalhada de competência técnica
     */
    public void setDescricaoDetalhada(String descricaoDetalhada) throws ElementoInvalidoException {
        descricaoDetalhada = descricaoDetalhada.trim();
        if (Validacao.validaDescricaoDetalhadaCompetenciaTecnica(descricaoDetalhada)) {
            this.descricaoDetalhada = descricaoDetalhada;
        } else {
            throw new ElementoInvalidoException("Descrição detalhada inválida.");
        }
    }

    /**
     *
     * @param areaAtividade especifica uma nova área de atividade à qual se refere a competência técnica
     */
    public void setAreaAtividade(AreaAtividade areaAtividade) {
        this.areaAtividade = areaAtividade;
    }

    /**
     *
     * @param grausProficiencia cria um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo graus de proficiência
     */
    public void setGrausProficiencia(ArrayList<GrauProficiencia> grausProficiencia) {
        this.grausProficiencia = grausProficiencia;
    }

    /**
     *
     * @return retorna uma String com a descrição da competência técnica (código de competência técnica, descrição breve de competência técnica, descrição detalhada de competência técnica, area de atividade à qual se refere a competência técnica, graus de proficiência)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format(
                        "Competência técnica:\n "
                                + "código competência técnica = %s\n "
                                + "descrição breve = %s\n "
                                + "descrição detalhada = %s\n "
                                + "área de atividade = %s\n "
                                + "graus de proficiência = \n", 
                        getCodigoCompetenciaTecnica(), 
                        getDescricaoBreve(), 
                        getDescricaoDetalhada(), 
                        getAreaAtividade().toString()));
        sb.append("(\n");
        for (GrauProficiencia grauProficiencia : grausProficiencia) {
            sb.append(grauProficiencia).append("\n");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     *
     * @param grauProficiencia instância do tipo grau de proficiência a ser adicionado ao contentor grausProficiencia
     * @return devolve verdadeiro se adicionou e falso se não adicionou
     */
    public boolean addGrauProficiencia(GrauProficiencia grauProficiencia) {
        return (validaGrauProficiencia(grauProficiencia) != null) ? grausProficiencia.add(grauProficiencia) : false;
    }

    /**
     *
     * @param valor valor do grau de proficiência que vai ser atualizado
     * @param gP grau de proficiência a ser atualizado
     */
    public void updateGrauProficiencia(String valor, GrauProficiencia gP) throws ElementoNaoExistenteException {
        GrauProficiencia grauProficiencia = null;
        boolean updated = false;
        for (int i = 0; i < grausProficiencia.size(); i++) {
            grauProficiencia = this.grausProficiencia.get(i);
            if (grauProficiencia.getValorGrauProficiencia().equals(valor)) {
                this.grausProficiencia.set(i, gP);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(valor + ": Grau de proficiência não existe!!");
        }
    }

    /**
     *
     * @param valor valor do grau de proficiência a ser removido
     * @throws ElementoNaoExistenteException
     */
    public void removeGrauProficiencia(String valor) throws ElementoNaoExistenteException {
        GrauProficiencia grauProficiencia = null;
        for (int i = 0; i < grausProficiencia.size(); i++) {
            grauProficiencia = this.grausProficiencia.get(i);
            if (grauProficiencia.getValorGrauProficiencia().equals(valor)) {
                this.grausProficiencia.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(valor + ": Grau de proficiência não existe!!");
            }
        }
    }

    /**
     *
     * @param grauProficiencia 
     * @return a instância do tipo grau de proficiência
     */
    public GrauProficiencia getGrauProficiencia(GrauProficiencia grauProficiencia) {
        for (GrauProficiencia grau : grausProficiencia) {
            if (grau.getValorGrauProficiencia().equalsIgnoreCase(grauProficiencia.getValorGrauProficiencia())) {
                return grauProficiencia;
            }
        }
        return null;
    }

    /**
     *
     * @param valor valor do grau de proficiência que se quer obter
     * @return o grau de proficiência com um determinado valor
     */
    public GrauProficiencia getGrauProficiencia(String valor) {
        return getGrauProficienciaByValor(valor);
    }

    /**
     *
     * @param outroObjeto instância de competência técnica a ser comparada
     * @return reescrita do método equals e retorna um booleano
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        CompetenciaTecnica outraCompetenciaTecnica = (CompetenciaTecnica) outroObjeto;
        return codigoCompetenciaTecnica.equalsIgnoreCase(outraCompetenciaTecnica.codigoCompetenciaTecnica)
                && descricaoBreve.equalsIgnoreCase(outraCompetenciaTecnica.descricaoBreve)
                && descricaoDetalhada.equalsIgnoreCase(outraCompetenciaTecnica.descricaoDetalhada)
                && areaAtividade.equals(outraCompetenciaTecnica.areaAtividade)
                && grausProficiencia.equals(outraCompetenciaTecnica.grausProficiencia);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codigoCompetenciaTecnica);
        hash = 17 * hash + Objects.hashCode(this.descricaoBreve);
        hash = 17 * hash + Objects.hashCode(this.descricaoDetalhada);
        hash = 17 * hash + Objects.hashCode(this.areaAtividade);
        hash = 17 * hash + Objects.hashCode(this.grausProficiencia);
        return hash;
    }

    /**
     * 
     * @param valor valor do grau de proficiência que se pretende
     * @return o grau de proficiência que corresponde a um determinado valor
     */
    private GrauProficiencia getGrauProficienciaByValor(String valor) {
        GrauProficiencia grauProficiencia = null;
        for (int i = 0; i < grausProficiencia.size(); i++) {
            grauProficiencia = this.grausProficiencia.get(i);
            if (grauProficiencia.getValorGrauProficiencia().equals(valor)) {
                GrauProficiencia copiaGP = new GrauProficiencia(grauProficiencia);
                return copiaGP;
            }
        }
        return null;
    }

    /**
     *
     * @param grauProficiencia instância do tipo grau de proficiência a ser validado
     * @return a instância do tipo grau de proficiência para adição ao contentor depois de validado
     */
    private GrauProficiencia validaGrauProficiencia(GrauProficiencia grauProficiencia) {
        if (getGrauProficiencia(grauProficiencia) == null) {
            return grauProficiencia;
        } else {
            return null;
        }
    }
}
