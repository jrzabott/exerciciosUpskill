package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "grausproficiencia")
public class RegistoGrausProficienciaDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "grauproficiencia")
    private ArrayList<GrauProficienciaDTO> grausProficiencia;

    /**
     * Construtor vazio de lista de competências técnicas
     */
    public RegistoGrausProficienciaDTO() {
    }

    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public ArrayList<GrauProficienciaDTO> getGrausProficiencia() {
        return grausProficiencia;
    }

    /**
     * 
     * @param grausProficiencia especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public void setGrausProficiencia(ArrayList<GrauProficienciaDTO> grausProficiencia) {
        this.grausProficiencia = grausProficiencia;
    }
}
