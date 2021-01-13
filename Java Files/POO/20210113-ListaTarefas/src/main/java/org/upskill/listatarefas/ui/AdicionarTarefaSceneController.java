package org.upskill.listatarefas.ui;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.upskill.listatarefas.controller.AplicacaoController;
import org.upskill.listatarefas.model.Prioridade;

public class AdicionarTarefaSceneController implements Initializable {

    private JanelaPrincipalSceneController janelaPrincipalSceneController;

    @FXML
    private Button btnCriarTarefa;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTarefa;
    @FXML
    private Label lblPrioridade;
    @FXML
    private TextField txtTarefa;
    @FXML
    private ComboBox<String> cmbPrioridade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCriarTarefa.setText("Adicionar");
        btnCancelar.setText("Cancelar");
        lblPrioridade.setText("Prioridade:");
        lblTarefa.setText("Descrição da Tarefa:");
        cmbPrioridade.getItems().add("");
        cmbPrioridade.setValue("");
        for (Prioridade p : Prioridade.values()) {
            cmbPrioridade.getItems().add(p.toString());
        }

    }

    @FXML
    private void criarTarefaAction(ActionEvent event) {
        AplicacaoController controller = janelaPrincipalSceneController.getAplicacaoController();

        boolean added = false;

        try {
            added = controller.adicionarTarefa(txtTarefa.getText(), cmbPrioridade.getValue());
            if (added) {
                janelaPrincipalSceneController.atualizaTextAreaListaDeTarefas();
                cleanFields();
            }

            AlertUI.newInfoUI(
                    (added)
                            ? "Tarefa adicionada com sucesso."
                            : "Não foi possível adicionar a tarefa.",
                    "Adicionar Nova Tarefa"
            );
        } catch (IllegalArgumentException ex) {
            AlertUI.newErrorUI(ex.getMessage(), "Erro ao Adicionar Nova Tarefa");
        } catch (Exception e) {
            AlertUI.newErrorUI(e.getMessage() + "\n" + e.getStackTrace(), "Erro Bizarro");
        }
        txtTarefa.requestFocus();
    }

    @FXML
    private void cancelarAction(ActionEvent event) {
        hideNovaTarefa(event);
    }

    private void hideNovaTarefa(ActionEvent event) {
        cleanFields();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private void cleanFields() {
        txtTarefa.clear();
        cmbPrioridade.getSelectionModel().select(0);
    }

    void associarParentUI(JanelaPrincipalSceneController janelaPrincipalSceneController) {
        this.janelaPrincipalSceneController = janelaPrincipalSceneController;
    }

}
