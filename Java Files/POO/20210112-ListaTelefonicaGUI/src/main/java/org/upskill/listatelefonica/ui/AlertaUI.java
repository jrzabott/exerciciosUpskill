package org.upskill.listatelefonica.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

public class AlertaUI {

    public static Alert criarAlerta(Alert.AlertType tipoAlerta, String titulo, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);
        
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); // Added by Daniel Junior at 20200112 14:06
        alerta.setContentText(mensagem);
        
        if (tipoAlerta == Alert.AlertType.CONFIRMATION) {
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");
        }
        
        return alerta;
    }
}
