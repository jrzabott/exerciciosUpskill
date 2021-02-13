package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "tarefas")
public class RegistoTarefasDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo tarefa
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "tarefa")
    private ArrayList<TarefaDTO> tarefas;

    /**
     * Construtor vazio de lista de tarefas
     */
    public RegistoTarefasDTO() {
    }

    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo tarefa
     */
    public ArrayList<TarefaDTO> getTarefas() {
        return tarefas;
    }

    /**
     * 
     * @param tarefas especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo tarefa
     */
    public void setTarefas(ArrayList<TarefaDTO> tarefas) {
        this.tarefas = tarefas;
    }
}
