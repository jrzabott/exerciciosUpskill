package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;

public class CaraterCompetenciaTecnica implements Serializable {

    /**
     * Variável de instância - caráter obrigatório da competência técnica
     */
    private boolean obrigatorio;

    /**
     * Variável de instância - competência técnica
     */
    private CompetenciaTecnica competenciaTecnica;

    /**
     * Variável de instância - grauProficiencia de proficiência
     */
    private GrauProficiencia grauProficiencia;

    /**
     * Valor por omissão - caráter obrigatório da competência técnica
     */
    private static final boolean OBRIGATORIO_POR_OMISSAO = false;

    /**
     * Construtor completo do caráter da competência técnica
     *
     * @param obrigatorio caráter obrigatório da competência técnica
     * @param competenciaTecnica competência técnica
     * @param grauProficiencia grauProficiencia de proficiência
     */
    public CaraterCompetenciaTecnica(boolean obrigatorio, CompetenciaTecnica competenciaTecnica, GrauProficiencia grauProficiencia) {
        this.obrigatorio = obrigatorio;
        this.competenciaTecnica = new CompetenciaTecnica(competenciaTecnica);
        this.grauProficiencia = new GrauProficiencia(grauProficiencia);
    }

    /**
     * Construtor vazio do caráter da competência técnica
     */
    public CaraterCompetenciaTecnica() {
        this.obrigatorio = OBRIGATORIO_POR_OMISSAO;
        this.competenciaTecnica = new CompetenciaTecnica();
        this.grauProficiencia = new GrauProficiencia();
    }

    /**
     * Construtor cópia do caráter obrigatório da competência técnica
     *
     * @param outroCaraterCompetenciaTecnica instancia de caráter obrigatório da competência técnica a ser copiado
     */
    public CaraterCompetenciaTecnica(CaraterCompetenciaTecnica outroCaraterCompetenciaTecnica) {
        this.obrigatorio = outroCaraterCompetenciaTecnica.obrigatorio;
        this.competenciaTecnica = new CompetenciaTecnica(outroCaraterCompetenciaTecnica.competenciaTecnica);
        this.grauProficiencia = new GrauProficiencia(outroCaraterCompetenciaTecnica.grauProficiencia);
    }

    /**
     *
     * @return caráter obrigatório da competência técnica
     */
    public boolean isObrigatorio() {
        return obrigatorio;
    }

    /**
     *
     * @return competência técnica
     */
    public CompetenciaTecnica getCompetenciaTecnica() {
        return competenciaTecnica;
    }

    /**
     *
     * @return grauProficiencia de proficiência
     */
    public GrauProficiencia getGrauProficiencia() {
        return grauProficiencia;
    }

    /**
     *
     * @param obrigatorio especifica um novo caráter obrigatório da competência técnica
     */
    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    /**
     *
     * @param competenciaTecnica especifica uma nova competência técnica
     */
    public void setCompetenciaTecnica(CompetenciaTecnica competenciaTecnica) {
        this.competenciaTecnica = competenciaTecnica;
    }

    /**
     *
     * @param grauProficiencia especifica um novo grauProficiencia de proficiência
     */
    public void setGrauProficiencia(GrauProficiencia grauProficiencia) {
        this.grauProficiencia = grauProficiencia;
    }

    /**
     *
     * @return retorna uma String com a descrição do carácter da competência técnica (obrigatório, competência técnica, grauProficiencia de proficiência)
     */
    @Override
    public String toString() {
        return String.format(
                "Carater competência técnica:\n  "
                        + "obrigatório = %s\n "
                        + "competência técnica = %s\n "
                        + "grau = %s", 
                isObrigatorio(), 
                getCompetenciaTecnica().toString(), 
                getGrauProficiencia().toString());
    }

    /**
     *
     * @param outroObjeto instancia de caráter de competência técnica a ser comparada
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
        CaraterCompetenciaTecnica outroCaraterCompetenciaTecnica = (CaraterCompetenciaTecnica) outroObjeto;
        return competenciaTecnica.equals(outroCaraterCompetenciaTecnica.competenciaTecnica)
                && grauProficiencia.equals(outroCaraterCompetenciaTecnica.grauProficiencia);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.competenciaTecnica);
        hash = 67 * hash + Objects.hashCode(this.grauProficiencia);
        return hash;
    }
}
