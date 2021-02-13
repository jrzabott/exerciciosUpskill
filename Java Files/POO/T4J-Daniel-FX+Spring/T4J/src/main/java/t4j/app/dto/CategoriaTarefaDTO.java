package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JsonPropertyOrder({"idCategoria", "descricao", "areaAtividade"})
@JacksonXmlRootElement(localName = "categoria")
public class CategoriaTarefaDTO {

    @JacksonXmlProperty(localName = "idCategoria")
    private String idCategoria;
    @JacksonXmlProperty(localName = "descricao")
    private String descricao;
    @JacksonXmlProperty(localName = "areaAtividade")
    private AreaAtividadeDTO areaAtividade;
    @JacksonXmlProperty(localName = "caraterCompetenciaTecnica")
    private ArrayList<CaraterCompetenciaTecnicaDTO> caraterCompetenciaTecnica;
    

    public CategoriaTarefaDTO() {
        this.idCategoria = "";
        this.descricao = "";
        this.areaAtividade = new AreaAtividadeDTO();
        this.caraterCompetenciaTecnica = new ArrayList<>();
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AreaAtividadeDTO getAreaAtividade() {
        return areaAtividade;
    }

    public void setAreaAtividade(AreaAtividadeDTO areaAtividade) {
        this.areaAtividade = areaAtividade;
    }

    public ArrayList<CaraterCompetenciaTecnicaDTO> getCaraterCompetenciaTecnica() {
        return caraterCompetenciaTecnica;
    }

    public void setCaraterCompetenciaTecnica(ArrayList<CaraterCompetenciaTecnicaDTO> caraterCompetenciaTecnica) {
        this.caraterCompetenciaTecnica = caraterCompetenciaTecnica;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoriaTarefaDTO\nidCategoria: ").append(idCategoria);
        sb.append("\ndescricao: ").append(descricao);
        sb.append("\nareaAtividade: ").append(areaAtividade.toString());
        sb.append("\ncaraterCompetenciaTecnica:");
        for (CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO : caraterCompetenciaTecnica) {
            sb.append("\n\t").append(caraterCompetenciaTecnicaDTO.toString());
        }
        return sb.toString();
    }
}
