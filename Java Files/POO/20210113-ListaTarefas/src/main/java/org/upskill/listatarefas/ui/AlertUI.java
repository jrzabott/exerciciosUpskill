/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 *
 * @author user
 */
public class AlertUI {
    
    /**
     *
     * @param msg
     * @param header
     */
    private AlertUI(String msg, String header, Alert.AlertType type) {
        Alert alert = new Alert(type, msg, ButtonType.OK);
            alert.setHeaderText(header);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
    }
    
    public static void newErrorUI(String msg, String header) {
        new AlertUI(msg, header, AlertType.ERROR);
}
    public static void newInfoUI(String msg, String header) {
        new AlertUI(msg, header, AlertType.INFORMATION);
}
    
}
