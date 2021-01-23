package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "freguesias")
public class ListaFreguesiaDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "freguesia")
    private ArrayList<FreguesiaDTO> freguesias;

    public ListaFreguesiaDTO() {
    }

    public ArrayList<FreguesiaDTO> getFreguesias() {
        return freguesias;
    }

    public void setFreguesias(ArrayList<FreguesiaDTO> freguesias) {
        this.freguesias = freguesias;
    }

}
