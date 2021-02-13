package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoTarefas implements Serializable {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo tarefa
     */
    private ArrayList<Tarefa> tarefas;

    /**
     * Construtor completo de lista de tarefas
     *
     * @param tarefas contentor do tipo ArrayList que guarda todas as instâncias do tipo tarefa
     */
    public RegistoTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = new ArrayList<>(tarefas);
    }

    /**
     * Construtor vazio de lista de tarefas
     */
    RegistoTarefas() {
        this.tarefas = new ArrayList<>();
    }

    /**
     * Construtor cópia de lista de tarefas
     *
     * @param outroRegistoTarefas instância do tipo lista de tarefas a ser copiada
     */
    public RegistoTarefas(RegistoTarefas outroRegistoTarefas) {
        this.tarefas = new ArrayList<>(outroRegistoTarefas.tarefas);
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo tarefa
     */
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de tarefas:\n");
        for (int i = 0; i < tarefas.size(); i++) {
            tarefas.get(i).toString();
            sb.append(tarefas.get(i).toString());
        }
        return sb.toString();
    }

    /**
     *
     * @param referencia referência de tarefa
     * @return a tarefa ao qual pertence a referência introduzida por parâmetro
     */
    public Tarefa getTarefaByReferencia(String referencia) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getReferencia().equalsIgnoreCase(referencia)) {
                return tarefa;
            }
        }
        return null;
    }

    /**
     *
     * @param tarefa instância do tipo tarefa a ser adicionada ao contentor tarefas
     * @return devolve verdadeiro se adicionou e falso se não adicionou
     */
    public boolean addTarefa(Tarefa tarefa) {
        return (validaTarefa(tarefa) != null) ? tarefas.add(tarefa) : false;
    }

    /**
     *
     * @param referencia referência de tarefa
     * @throws ElementoNaoExistenteException
     */
    public void removeTarefa(String referencia) throws ElementoNaoExistenteException {
        Tarefa tarefa = null;
        for (int i = 0; i < this.tarefas.size(); i++) {
            tarefa = this.tarefas.get(i);
            if (tarefa.getReferencia().equals(referencia)) {
                this.tarefas.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(referencia + ": Não existe esta tarefa!!");
            }
        }
    }

    /**
     *
     * @param referencia referência de tarefa
     * @param t instância do tipo tarefa a ser atualizada no contentor tarefas
     * @throws ElementoNaoExistenteException
     */
    public void updateTarefa(String referencia, Tarefa t) throws ElementoNaoExistenteException {
        Tarefa tarefa = null;
        boolean updated = false;
        for (int i = 0; i < this.tarefas.size(); i++) {
            tarefa = this.tarefas.get(i);
            if (tarefa.getReferencia().equals(referencia)) {
                this.tarefas.set(i, t);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(referencia + ": Não existe esta tarefa!!");
        }
    }

    /**
     *
     * @param outroObjeto instância de lista de tarefas a ser comparada
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
        RegistoTarefas outraListaTarefas = (RegistoTarefas) outroObjeto;
        return tarefas.equals(outraListaTarefas.tarefas);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.tarefas);
        return hash;
    }

    /**
     *
     * @param tarefa instância do tipo tarefa a ser validada
     * @return retorna a instância do tipo tarefa para adição ao contentor depois de validada
     * @throws ElementoDuplicadoException
     */
    private Tarefa validaTarefa(Tarefa tarefa) throws ElementoDuplicadoException {
        if (getTarefaByReferencia(tarefa.getReferencia()) == null) {
            return tarefa;
        } else {
            throw new ElementoDuplicadoException("Já existe uma tarefa com essa referência!");
        }
    }
}
