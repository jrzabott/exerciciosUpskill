/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.ui;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 *
 * @author user
 */
public class AlertUI {


    public static Optional<ButtonType> createConfirmartionUI(String title, String header, String msg) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.setHeaderText(header);
        a.setContentText(msg);
        a.setTitle(title);
        a.getButtonTypes().clear();
        a.getButtonTypes().add(ButtonType.YES);
        a.getButtonTypes().add(ButtonType.NO);
        return a.showAndWait();
    }
    public static void createUI(Alert.AlertType type, String title, String header, String msg) {
        Alert a = new Alert(type);
        a.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.setHeaderText(header);
        a.setContentText(msg);
        a.setTitle(title);
        a.show();
    }
}
