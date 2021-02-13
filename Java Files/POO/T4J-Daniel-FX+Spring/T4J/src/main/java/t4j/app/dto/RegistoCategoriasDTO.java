package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "Categorias")
public class RegistoCategoriasDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo categoria
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "categorias")
    private ArrayList<CategoriaTarefaDTO> categorias;

    /**
     * Construtor vazio de lista de categorias
     */
    public RegistoCategoriasDTO() {
    }

    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo categoria
     */
    public ArrayList<CategoriaTarefaDTO> getCategorias() {
        return categorias;
    }

    /**
     * 
     * @param categorias especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo categoria
     */
    public void setCategorias(ArrayList<CategoriaTarefaDTO> categorias) {
        this.categorias = categorias;
    }
}
