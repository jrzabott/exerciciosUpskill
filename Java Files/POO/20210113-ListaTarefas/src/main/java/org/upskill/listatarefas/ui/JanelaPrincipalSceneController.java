package org.upskill.listatarefas.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.upskill.listatarefas.controller.AplicacaoController;

public class JanelaPrincipalSceneController implements Initializable {

    @FXML
    private Button btnAdicionarTarefas;
    @FXML
    private Button btnLimparTarefas;
    @FXML
    private TextArea txtAreaTarefas;

    private AplicacaoController controller;
    private Stage novaTarefaStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);
            novaTarefaStage.setTitle("Nova Tarefa");
            novaTarefaStage.setResizable(false);
            novaTarefaStage.setScene(scene);
            
            controller = new AplicacaoController();
            
            AdicionarTarefaSceneController tarefaSceneController = loader.getController();
            tarefaSceneController.associarParentUI(this);

            atualizaTextAreaListaDeTarefas();
        } catch (IOException ex) {
            AlertUI.newErrorUI("Erro ao criar janela \"Nova Tarefa\".", "Nova Tarefa");
        }
            btnAdicionarTarefas.setText("Adicionar Tarefa");
            btnLimparTarefas.setText("Limpar Tarefas");

    }


    public void atualizaTextAreaListaDeTarefas() {
        if (!controller.getListaTarefas().trim().isEmpty()) {
            txtAreaTarefas.setText(controller.getListaTarefas());
            btnLimparTarefas.setDisable(false);
        }
    }

    @FXML
    private void adicionarTarefaAction(ActionEvent event) {
        novaTarefaStage.show();
    }

    @FXML
    private void limparTarefasAction(ActionEvent event) {
        txtAreaTarefas.clear();
        controller.eliminarTarefas();
        btnLimparTarefas.setDisable(true);
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
    }

    public AplicacaoController getAplicacaoController() {
        return controller;
    }

}
