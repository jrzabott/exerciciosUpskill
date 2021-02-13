package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class EnderecoPostal implements Serializable {

    /**
     * Variável de instância - morada
     */
    private String morada;

    /**
     * Variável de instância - código postal
     */
    private String codigoPostal;

    /**
     * Variável de instância - localidade
     */
    private String localidade;

    /**
     * Construtor completo de endereço postal
     *
     * @param morada morada
     * @param codigoPostal código postal
     * @param localidade localidade
     */
    public EnderecoPostal(String morada, String codigoPostal, String localidade) {
        setMorada(morada);
        setCodigoPostal(codigoPostal);
        setLocalidade(localidade);
    }

    /**
     * Construtor vazio de endereço postal
     */
    public EnderecoPostal() {
    }

    /**
     * Construtor cópia de endereço postal
     *
     * @param outroEnderecoPostal instância endereço postal a ser copiada
     */
    public EnderecoPostal(EnderecoPostal outroEnderecoPostal) {
        setMorada(outroEnderecoPostal.morada);
        setCodigoPostal(outroEnderecoPostal.codigoPostal);
        setLocalidade(outroEnderecoPostal.localidade);
    }

    /**
     *
     * @return morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @return código postal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     *
     * @return localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     *
     * @param morada especifica uma nova morada do endereço postal
     */
    public void setMorada(String morada) throws ElementoInvalidoException {
        morada = morada.trim();
        if (Validacao.validaMorada(morada)) {
            this.morada = morada;
        } else {
            throw new ElementoInvalidoException("Morada inválida.");
        }
    }

    /**
     *
     * @param codigoPostal especifica um novo código postal do endereço postal
     */
    public void setCodigoPostal(String codigoPostal) throws ElementoInvalidoException {
        codigoPostal = codigoPostal.trim();
        if (Validacao.validaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ElementoInvalidoException("Código postal inválido.");
        }
    }

    /**
     *
     * @param localidade especifica uma nova localidade do endereço postal
     */
    public void setLocalidade(String localidade) throws ElementoInvalidoException {
        localidade = localidade.trim();
        if (Validacao.validaLocalidade(localidade)) {
            this.localidade = localidade;
        } else {
            throw new ElementoInvalidoException("Localidade inválida.");
        }
    }

    /**
     *
     * @return retorna uma String com a descrição do endereço postal (morada, código postal, localidade)
     */
    @Override
    public String toString() {
        return String.format("Endereço postal:\n morada = %s\n códido postal = %s\n localidade = %s", getMorada(), getCodigoPostal(), getLocalidade());
    }

    /**
     *
     * @param outroObjeto instância de endereço postal a ser comparada
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
        EnderecoPostal outroEndereco = (EnderecoPostal) outroObjeto;
        return morada.equalsIgnoreCase(outroEndereco.morada)
                && codigoPostal.equalsIgnoreCase(outroEndereco.codigoPostal)
                && localidade.equalsIgnoreCase(outroEndereco.localidade);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.morada);
        hash = 29 * hash + Objects.hashCode(this.codigoPostal);
        hash = 29 * hash + Objects.hashCode(this.localidade);
        return hash;
    }
}
