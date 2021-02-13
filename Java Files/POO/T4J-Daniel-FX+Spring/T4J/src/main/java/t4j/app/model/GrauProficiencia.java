package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

public class GrauProficiencia implements Serializable {

    /**
     * Variável de instância - valorGrauProficiencia do grau de proficiência
     */
    private String valorGrauProficiencia;

    /**
     * Variável de instância - designação do grau de proficiência
     */
    private String designacaoGrauProficiencia;

    /**
     * Construtor completo de grau de proficiência
     *
     * @param valorGrauProficiencia valorGrauProficiencia do grau de proficiência
     * @param designacaoGrauProficiencia designação do grau de proficiência
     */
    public GrauProficiencia(String valorGrauProficiencia, String designacaoGrauProficiencia) {
        setValorGrauProficiencia(valorGrauProficiencia);
        setDesignacaoGrauProficiencia(designacaoGrauProficiencia);
    }

    /**
     * Construtor vazio de grau de proficiência
     */
    public GrauProficiencia() {
    }

    /**
     * Construtor cópia de grau de proficiência
     *
     * @param outroGrauProficiencia instância de grau de proficiência a ser copiada
     */
    public GrauProficiencia(GrauProficiencia outroGrauProficiencia) {
        setValorGrauProficiencia(outroGrauProficiencia.valorGrauProficiencia);
        setDesignacaoGrauProficiencia(outroGrauProficiencia.designacaoGrauProficiencia);
    }

    /**
     *
     * @return valorGrauProficiencia do grau de proficiência
     */
    public String getValorGrauProficiencia() {
        return valorGrauProficiencia;
    }

    /**
     *
     * @return designação do grau de proficiência
     */
    public String getDesignacaoGrauProficiencia() {
        return designacaoGrauProficiencia;
    }

    /**
     *
     * @param valorGrauProficiencia especifica um novo valorGrauProficiencia de grau de proficiência
     */
    public void setValorGrauProficiencia(String valorGrauProficiencia) throws ElementoInvalidoException {
        valorGrauProficiencia = valorGrauProficiencia.trim();
        if (Validacao.validaValorGrauProficiencia(valorGrauProficiencia)) {
            this.valorGrauProficiencia = valorGrauProficiencia;
        } else {
            throw new ElementoInvalidoException("Valor inválido.");
        }
    }

    /**
     *
     * @param designacaoGrauProficiencia especifica uma nova designação de grau de proficiência
     */
    public void setDesignacaoGrauProficiencia(String designacaoGrauProficiencia) throws ElementoInvalidoException {
        designacaoGrauProficiencia = designacaoGrauProficiencia.trim();
        if (Validacao.validaDesignacaoGrauProficiencia(designacaoGrauProficiencia)) {
            this.designacaoGrauProficiencia = designacaoGrauProficiencia;
        } else {
            throw new ElementoInvalidoException("Designação inválida.");
        }
    }

    /**
     *
     * @return retorna uma String com a descrição do grau de proficiência (valorGrauProficiencia, designação)
     */
    @Override
    public String toString() {
        return String.format("Grau de proficiência:\n valor = %s\n designação = %s\n", getValorGrauProficiencia(), getDesignacaoGrauProficiencia());
    }

    /**
     *
     * @param outroObjeto instância de grau de proficiência a ser comparada
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
        GrauProficiencia outroGrau = (GrauProficiencia) outroObjeto;
        return valorGrauProficiencia.equalsIgnoreCase(outroGrau.valorGrauProficiencia)
                && designacaoGrauProficiencia.equalsIgnoreCase(outroGrau.designacaoGrauProficiencia);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.valorGrauProficiencia);
        hash = 97 * hash + Objects.hashCode(this.designacaoGrauProficiencia);
        return hash;
    }
}
