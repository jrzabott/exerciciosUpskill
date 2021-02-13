package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "AreaAtividades")
public class RegistoAreasAtividadeDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo área de atividade
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "atividades")
    private ArrayList<AreaAtividadeDTO> atividades;

    /**
     * Construtor vazio de lista de áreas de atividade
     */
    public RegistoAreasAtividadeDTO() {
        this.atividades = new ArrayList<>();
    }

    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo área de atividade
     */
    public ArrayList<AreaAtividadeDTO> getAtividades() {
        return atividades;
    }

    /**
     * 
     * @param atividades especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo área de atividade
     */
    public void setAtividades(ArrayList<AreaAtividadeDTO> atividades) {
        this.atividades = atividades;
    }
}
