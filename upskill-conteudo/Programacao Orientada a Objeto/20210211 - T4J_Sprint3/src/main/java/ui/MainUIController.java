/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.RegistarOrganizacaoController;
import model.Plataforma;

/**
 *
 * @author nunocastro
 */
public class MainUIController {

    MainUIController() {
        Plataforma plataforma = Plataforma.getInstance();
        
        //Simular o click na opção de menu.
        menuItemRegistarOrganizacaoClick();
    }
    
    public void menuItemRegistarOrganizacaoClick() {
        RegistarOrganizacaoController roc = new RegistarOrganizacaoController();
        //a)
        RegistarOrganizacaoUIController roui = new RegistarOrganizacaoUIController(roc);
        //b)
//        RegistarOrganizacaoUIController roui = new RegistarOrganizacaoUIController();
//        roui.setController(roc);
    }
}
