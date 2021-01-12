/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioshift;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SceneController implements Initializable {

    List<Label> labels;

    @FXML
    private Button shiftLeft;
    @FXML
    private Button shiftRight;
    @FXML
    private HBox hBox;
    @FXML
    private TextField txtNumLetras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnConfirmarAction(new ActionEvent());
    }

    @FXML
    private void shiftLeftAction(ActionEvent event) {
        Label firstNode = (Label) hBox.getChildren().get(1);
        hBox.getChildren().remove(firstNode);
        hBox.getChildren().add(hBox.getChildren().size() - 1, firstNode);
    }

    @FXML
    private void shiftRightAction(ActionEvent event) {
        Label lastNode = (Label) hBox.getChildren().get(hBox.getChildren().size()-2);
        hBox.getChildren().remove(lastNode);
        hBox.getChildren().add(1, lastNode);
    }

    @FXML
    private void btnConfirmarAction(ActionEvent event) {
        int option = 0;
        try {
            try {
                option = Integer.parseInt(txtNumLetras.getText());
                if (option < 3 || option > 7) {
                    throw new IllegalArgumentException("No número deve ser um inteiro entre 3 e 7.");
                }
                if (hBox.getChildren().size() > 2) {
                    limparLabels();
                }
                createLabels(option);
            } catch (NumberFormatException numberFormatException) {
                option = 0;
                throw new IllegalArgumentException("No número deve ser um inteiro, entre 3 e 7.");
            }
        } catch (IllegalArgumentException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            a.show();
        }
    }

    private void createLabels(int n) {
        System.out.println(hBox.getChildren() + "Length: " + hBox.getChildren().size());

        char c = 'A';
        for (int i = 0; i < n; i++) {
            hBox.getChildren().add(hBox.getChildren().size() - 1, new Label(Character.toString((char) (c + i))));
        }

        for (Node node : hBox.getChildren()) {
            System.out.print(node.getId());
            if (node instanceof Label) {
                System.out.print(" - It is a Label");
                ((Label) node).setFont(new Font("Arial", 30));
            }
            System.out.println("");
        }

    }

    private void limparLabels() {
        hBox.getChildren().remove(1, hBox.getChildren().size() - 1);
    }
}
