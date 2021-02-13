package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Colaborador implements Serializable {

    /**
     * Variável de instância - nome do colaborador
     */
    private String nome;

    /**
     * Variável de instância - função do colaborador
     */
    private String funcao;

    /**
     * Variável de instância - telefone do colaborador
     */
    private String telefone;

    /**
     * Variável de instância - e-Mail do colaborador
     */
    private String email;

    /**
     * Construtor completo de colaborador
     *
     * @param nome nome do colaborador
     * @param funcao função do colaborador
     * @param telefone telefone do colaborador
     * @param email e-Mail do colaborador
     */
    public Colaborador(String nome, String funcao, String telefone, String email) {
        setNome(nome);
        setFuncao(funcao);
        setTelefone(telefone);
        setEmail(email);
    }

    /**
     * Construtor vazio de colaborador
     */
    public Colaborador() {

    }

    /**
     * Construtor cópia de colaborador
     *
     * @param outroColaborador instância colaborador a ser copiada
     */
    public Colaborador(Colaborador outroColaborador) {
        setNome(outroColaborador.nome);
        setFuncao(outroColaborador.funcao);
        setTelefone(outroColaborador.telefone);
        setEmail(outroColaborador.email);
    }

    /**
     *
     * @return nome do colaborador
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return função do colaborador
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     *
     * @return telefone do colaborador
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return e-Mail do colaborador
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param nome especifica um novo nome do colaborador
     */
    public void setNome(String nome) throws ElementoInvalidoException {
        nome = nome.trim();
        if (Validacao.validaNomeColaborador(nome)) {
            this.nome = nome;
        } else {
            throw new ElementoInvalidoException("Nome de colaborador inválido.");
        }
    }

    /**
     *
     * @param funcao especifica uma nova função do colaborador
     */
    public void setFuncao(String funcao) throws ElementoInvalidoException {
        funcao = funcao.trim();
        if (Validacao.validaFuncaoColaborador(funcao)) {
            this.funcao = funcao;
        } else {
            throw new ElementoInvalidoException("Função inválida.");
        }
    }

    /**
     *
     * @param telefone especifica um novo telefone do colaborador
     */
    public void setTelefone(String telefone) throws ElementoInvalidoException {
        telefone = telefone.trim();
        if (Validacao.validaTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new ElementoInvalidoException("Telefone de colaborador inválido.");
        }
    }

    /**
     *
     * @param email especifica um novo e-Mail do colaborador
     */
    public void setEmail(String email) throws ElementoInvalidoException {
        email = email.trim();
        if (Validacao.validaEmail(email)) {
            this.email = email;
        } else {
            throw new ElementoInvalidoException("Email de colaborador inválido.");
        }
    }

    /**
     *
     * @return retorna uma String com a descrição do colaborador (nome, função, telefone, e-Mail)
     */
    @Override
    public String toString() {
        return String.format("Colaborador:\n nome = %s\n função = %s\n telefone = %s\n e-Mail = %s", getFuncao(), getFuncao(), getTelefone(), getEmail());
    }

    /**
     *
     * @param outroObjeto instancia de colaborador a ser comparado
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
        Colaborador outroColab = (Colaborador) outroObjeto;
        return nome.equalsIgnoreCase(outroColab.nome)
                && funcao.equalsIgnoreCase(outroColab.funcao)
                && telefone.equalsIgnoreCase(outroColab.telefone)
                && email.equalsIgnoreCase(outroColab.email);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.funcao);
        hash = 23 * hash + Objects.hashCode(this.telefone);
        hash = 23 * hash + Objects.hashCode(this.email);
        return hash;
    }
}
