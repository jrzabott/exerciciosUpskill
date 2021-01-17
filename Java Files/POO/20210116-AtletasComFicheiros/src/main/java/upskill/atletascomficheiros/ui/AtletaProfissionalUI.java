/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.atletascomficheiros.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AtletaProfissionalUI implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCancel;
    @FXML
    private ComboBox<?> cmbBoxIntensidadeTreino;
    @FXML
    private ComboBox<?> cmbBoxTipoAtividade;
    @FXML
    private ToggleGroup generoToggleGroup;
    @FXML
    private RadioButton radioButtonFeminino;
    @FXML
    private RadioButton radioButtonMasculino;
    @FXML
    private TextField txtFieldAntiguidade;
    @FXML
    private TextField txtFieldFCR;
    @FXML
    private TextField txtFieldIDCivil;
    @FXML
    private TextField txtFieldIdade;
    @FXML
    private TextField txtFieldNome;
    @FXML
    private TextField txtFieldPremio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAddAction(ActionEvent event) {
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
    }

    private JanelaPrincipalSceneController janelaPrincipalSceneController;

    void associarParentUI(JanelaPrincipalSceneController jpsc) {
        this.janelaPrincipalSceneController = jpsc;
    }
}
