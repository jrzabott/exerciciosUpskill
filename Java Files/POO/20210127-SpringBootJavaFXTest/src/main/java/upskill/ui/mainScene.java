/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.ui;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javax.activation.DataContentHandler;
import upskill.controller.DataController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class mainScene implements Initializable {

    @FXML
    private TextArea lblLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionTeste(ActionEvent event) {
        
        StringBuilder sb = new StringBuilder();
//        sb.append();
        lblLabel.setText(sb.toString());
    }
    
}
