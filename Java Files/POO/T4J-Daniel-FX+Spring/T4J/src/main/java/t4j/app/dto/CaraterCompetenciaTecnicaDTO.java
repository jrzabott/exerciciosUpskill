/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import t4j.app.dto.CompetenciaTecnicaDTO;

/**
 *
 * @author user
 */
@JsonPropertyOrder({"competenciaTecnica", "grauProficiencia", "obrigatorio"})
@JacksonXmlRootElement(localName = "caraterCompetenciaTecnica")
public class CaraterCompetenciaTecnicaDTO {

    @JacksonXmlProperty(localName = "obrigatorio")
    private boolean obrigatorio;
    @JacksonXmlProperty(localName = "competenciaTecnica")
    private CompetenciaTecnicaDTO competenciaTecnica;
    @JacksonXmlProperty(localName = "grauProficiencia")
    private GrauProficienciaDTO grauProficiencia;

    public CaraterCompetenciaTecnicaDTO() {
        this.competenciaTecnica = new CompetenciaTecnicaDTO();
        this.grauProficiencia = new GrauProficienciaDTO();
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public CompetenciaTecnicaDTO getCompetenciaTecnica() {
        return competenciaTecnica;
    }

    public void setCompetenciaTecnica(CompetenciaTecnicaDTO competenciaTecnica) {
        this.competenciaTecnica = competenciaTecnica;
    }

    public GrauProficienciaDTO getGrauProficiencia() {
        return grauProficiencia;
    }

    public void setGrauProficiencia(GrauProficienciaDTO grauProficiencia) {
        this.grauProficiencia = grauProficiencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CaraterCompetenciaTecnicaDTO:\nobrigatorio: ").append(obrigatorio);
        sb.append("\ngrauProficiencia: ").append(grauProficiencia.toString());
        sb.append("\ncompetenciaTecnica: ").append(competenciaTecnica.toString());
        sb.append('}');
        return sb.toString();
    }
    
    

}
