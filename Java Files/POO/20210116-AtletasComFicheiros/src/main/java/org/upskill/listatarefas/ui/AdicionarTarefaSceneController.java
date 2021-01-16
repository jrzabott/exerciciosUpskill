/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.upskill.listatarefas.controller.AplicacaoController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdicionarTarefaSceneController implements Initializable {

    private AplicacaoController appController;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCriarTarefa;
    @FXML
    private ComboBox<String> cmbPrioridade;

    private JanelaPrincipalSceneController janelaPrincipalSceneController;
    @FXML
    private Label lblPrioridade;
    @FXML
    private Label lblTarefa;
    @FXML
    private TextField txtTarefa;

    public void associarParentUI(JanelaPrincipalSceneController janelaPrincipalSceneController) {
        this.janelaPrincipalSceneController = janelaPrincipalSceneController;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            this.appController = janelaPrincipalSceneController.getAppController();
            criarComboBox();
            txtTarefa.requestFocus();
        });
    }

    @FXML
    private void cancelarAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private void criarComboBox() {

        cmbPrioridade.getItems().add("");
        cmbPrioridade.setValue("");
        String[] prioridades = appController.getPrioridades();
        for (String prioridade : prioridades) {
            cmbPrioridade.getItems().add(prioridade);
        }
    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {
        AplicacaoController ac = janelaPrincipalSceneController.getAppController();

        try {
            if (txtTarefa.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Descrição Tarefa não pode ser vazia.");
            }
            if (cmbPrioridade.getValue().trim().isEmpty()) {
                throw new IllegalArgumentException("Deve selecionar uma prioridade na listagem acima.");
            }

            if (ac.adicionarTarefa(txtTarefa.getText(), cmbPrioridade.getValue())) {
                limparCampos();
                janelaPrincipalSceneController.updateList();
            }
        } catch (IllegalArgumentException iae) {
            String errorMessage = iae.getMessage();
            errorMessage = errorMessage.toUpperCase();
            if (iae.getMessage().toUpperCase().contains("TAREFA")) {
                AlertUI.createUI(Alert.AlertType.ERROR, "Descrição Tarefa", "Descrição Tarefa", "Descrição Tarefa não pode ser vazia.");
            }
            if (iae.getMessage().toUpperCase().contains("PRIORIDADE")) {
                AlertUI.createUI(Alert.AlertType.ERROR, "Prioridade", "Prioridade", "Deve selecionar uma prioridade na listagem acima.");
            }
        } catch (Exception ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "Erro", "Erro ao criar tarefa", ex.getMessage());
        }
        txtTarefa.requestFocus();
    }

    private void limparCampos() {
        txtTarefa.clear();
        cmbPrioridade.setValue("");
    }

}
