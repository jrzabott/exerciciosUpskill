/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.RegistarOrganizacaoController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nunocastro
 */
public class RegistarOrganizacaoUIController {

    private RegistarOrganizacaoController roc;
    
    RegistarOrganizacaoUIController(RegistarOrganizacaoController roc) {
        this.roc = roc;
        
        //Simular o submit
        introduzirDados();
        confirmarDados();
    }
    
    public void introduzirDados() {
        try {
            roc.novaOrganizacao("Upskill",
                    "12131313", "Rua Xpto", "12123-555", "Porto", "2652652465", "www.upskill.pt", "eu@upskill.pt",
                    "Gestor upskill", "gestor", "2762157625", "gestor@upskill.pt");
        } catch (Exception ex) {
            System.out.println("Dados inválidos");
        }
    }

    public void confirmarDados() {
        try {
            roc.registaOrganizacao();
        } catch (Exception ex) {
            System.out.println("Impossível confirmar");
        }
    }

}
