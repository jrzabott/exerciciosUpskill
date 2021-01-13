package org.upskill.listatarefas.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        txtAreaTarefas.requestFocus();
    }

    public void atualizaTextAreaListaDeTarefas() {
        txtAreaTarefas.setText(controller.getListaTarefas());
        btnLimparTarefas.setDisable((controller.listaVazia()));
    }
    public void atualizaTextAreaListaDeTarefas(String l) {
        txtAreaTarefas.setText(l);
        btnLimparTarefas.setDisable((controller.listaVazia()));
    }

    @FXML
    private void adicionarTarefaAction(ActionEvent event) {
        novaTarefaStage.show();
    }

    @FXML
    private void limparTarefasAction(ActionEvent event) {
        controller.eliminarTarefas();
        atualizaTextAreaListaDeTarefas();
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
        limparUltimaTarefa(event);
        ordenarListaPorPrioridade(event);
        ordenarListaPorHora(event);
    }

    private void ordenarListaPorHora(KeyEvent event) {
        if (event.isControlDown() && event.getCode() == KeyCode.O) {
            atualizaTextAreaListaDeTarefas(controller.getListaTarefasPorHora());
        }
    }

    private void ordenarListaPorPrioridade(KeyEvent event) {
        if (event.isControlDown() && event.getCode() == KeyCode.P) {
            atualizaTextAreaListaDeTarefas(controller.getListaTarefasPorPrioridade());
        }
    }

    private void limparUltimaTarefa(KeyEvent event) { 
        if (event.isControlDown() && event.getCode() == KeyCode.Z) {
            controller.eliminarUltimaTarefa();
            atualizaTextAreaListaDeTarefas();
        }
    }

    public AplicacaoController getAplicacaoController() {
        return controller;
    }

}
