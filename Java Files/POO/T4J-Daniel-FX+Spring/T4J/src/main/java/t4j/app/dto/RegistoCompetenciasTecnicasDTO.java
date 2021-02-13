package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "competenciasTecnicas")
public class RegistoCompetenciasTecnicasDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "competenciaTecnica")
    private ArrayList<CompetenciaTecnicaDTO> competenciasTecnicas;

    /**
     * Construtor vazio de lista de competências técnicas
     */
    public RegistoCompetenciasTecnicasDTO() {
    }

    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public ArrayList<CompetenciaTecnicaDTO> getCompetenciasTecnicas() {
        return competenciasTecnicas;
    }

    /**
     * 
     * @param competenciasTecnicas especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public void setCompetenciasTecnicas(ArrayList<CompetenciaTecnicaDTO> competenciasTecnicas) {
        this.competenciasTecnicas = competenciasTecnicas;
    }
}
