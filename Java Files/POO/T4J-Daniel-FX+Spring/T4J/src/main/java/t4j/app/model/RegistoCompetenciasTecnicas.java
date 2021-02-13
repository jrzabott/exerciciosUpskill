package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoCompetenciasTecnicas implements Serializable {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    private ArrayList<CompetenciaTecnica> competenciasTecnicas;

    /**
     * Construtor completo de lista de competências técnicas
     *
     * @param competenciasTecnicas
     */
    public RegistoCompetenciasTecnicas(ArrayList<CompetenciaTecnica> competenciasTecnicas) {
        this.competenciasTecnicas = new ArrayList<>(competenciasTecnicas);
    }

    /**
     * Construtor vazio de lista de competências técnicas
     */
    public RegistoCompetenciasTecnicas() {
        this.competenciasTecnicas = new ArrayList<>();
    }

    /**
     * Construtor cópia de lista de competências técnicas
     *
     * @param outroRegistoCompetenciasTecnicas instância do tipo lista de competências técnicas a ser copiada
     */
    public RegistoCompetenciasTecnicas(RegistoCompetenciasTecnicas outroRegistoCompetenciasTecnicas) {
        this.competenciasTecnicas = new ArrayList<>(outroRegistoCompetenciasTecnicas.competenciasTecnicas);
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public ArrayList<CompetenciaTecnica> getCompetenciasTecnicas() {
        return competenciasTecnicas;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de competências técnicas:\n");
        for (int i = 0; i < competenciasTecnicas.size(); i++) {
            competenciasTecnicas.get(i).toString();
            sb.append(competenciasTecnicas.get(i).toString());
        }
        return sb.toString();
    }

    /**
     *
     * @param codigoCompetenciaTecnica código de competências técnicas
     * @return a competência técnica ao qual pertence o código introduzido por parâmetro
     */
    public CompetenciaTecnica getCompetenciaTecnicaByCodigoCompetenciaTecnica(String codigoCompetenciaTecnica) {
        for (CompetenciaTecnica competenciaTecnica : competenciasTecnicas) {
            if (competenciaTecnica.getCodigoCompetenciaTecnica().equalsIgnoreCase(codigoCompetenciaTecnica)) {
                return competenciaTecnica;
            }
        }
        return null;
    }

    /**
     *
     * @param competenciaTecnica instância do tipo competência técnica a ser adicionada ao contentor competenciasTecnicas
     * @return devolve verdadeiro se adicionou e falso se não adicionou
     */
    public boolean addCompetenciaTecnica(CompetenciaTecnica competenciaTecnica) {
        return (validaCompetenciaTecnica(competenciaTecnica) != null) ? competenciasTecnicas.add(competenciaTecnica) : false;
    }

    /**
     *
     * @param codCT
     * @param ct 
     */
    public void updateCompetenciaTecnica(String codCT, CompetenciaTecnica ct) {
        CompetenciaTecnica competenciaTecnica = null;
        boolean updated = false;
        for (int i = 0; i < this.competenciasTecnicas.size(); i++) {
            competenciaTecnica = this.competenciasTecnicas.get(i);
            if (competenciaTecnica.getCodigoCompetenciaTecnica().equals(codCT)) {
                this.competenciasTecnicas.set(i, ct);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(codCT + ": Não existe esta competência técnica!!");
        }
    }

    /**
     *
     * @param codCT
     */
    public void removeCompetenciaTecnica(String codCT) {
        CompetenciaTecnica competenciaTecnica = null;
        for (int i = 0; i < this.competenciasTecnicas.size(); i++) {
            competenciaTecnica = this.competenciasTecnicas.get(i);
            if (competenciaTecnica.getCodigoCompetenciaTecnica().equals(codCT)) {
                this.competenciasTecnicas.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(codCT + ": Não existe esta competência técnica!!");
            }
        }
    }

    /**
     *
     * @param outroObjeto instância de lista de competências técnicas a ser comparada
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
        RegistoCompetenciasTecnicas outroRegistoCompetenciaTecnica = (RegistoCompetenciasTecnicas) outroObjeto;
        return competenciasTecnicas.equals(outroRegistoCompetenciaTecnica.competenciasTecnicas);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.competenciasTecnicas);
        return hash;
    }

    /**
     *
     * @param competenciaTecnica instância do tipo competência técnica a ser validada
     * @return retorna a instância do tipo competência técnica para adição ao contentor depois de validada
     * @throws ElementoDuplicadoException
     */
    private CompetenciaTecnica validaCompetenciaTecnica(CompetenciaTecnica competenciaTecnica) throws ElementoDuplicadoException {
        if (getCompetenciaTecnicaByCodigoCompetenciaTecnica(competenciaTecnica.getCodigoCompetenciaTecnica()) == null) {
            return competenciaTecnica;
        } else {
            throw new ElementoDuplicadoException("Já existe uma competência técnica com esse código!");
        }
    }
}
