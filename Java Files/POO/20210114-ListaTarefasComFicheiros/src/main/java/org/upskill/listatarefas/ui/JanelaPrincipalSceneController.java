/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.listatarefas.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.upskill.listatarefas.controller.AplicacaoController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class JanelaPrincipalSceneController implements Initializable {

    private AplicacaoController appController;
    @FXML
    private ListView<String> lstViewTarefas;
    @FXML
    private Menu menuFile;
    @FXML
    private MenuItem menuItemExit;
    @FXML
    private MenuItem menuItemOpenBinary;
    @FXML
    private MenuItem menuItemOpenBinaryFrom;
    @FXML
    private MenuItem menuItemRemoveAll;
    @FXML
    private MenuItem menuItemRemoveSelected;
    @FXML
    private MenuItem menuItemSaveBinary;
    @FXML
    private MenuItem menuItemSaveBinaryAs;
    @FXML
    private MenuItem menuItemSaveTextAs;
    @FXML
    private MenuItem menuItemTaskAdd;
    @FXML
    private Menu menuRemove;
    @FXML
    private Menu menuTask;

    private Stage novaTarefaStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarTarefaScene.fxml")); // prepare FXML file
            Parent root = loader.load(); // root Node receives and load the FXML content
            Scene scene = new Scene(root); // new scene is created in root.

            novaTarefaStage = new Stage();
            novaTarefaStage.initModality(Modality.APPLICATION_MODAL);
            novaTarefaStage.setTitle("Nova Tarefa");
            novaTarefaStage.setResizable(false);
            novaTarefaStage.setScene(scene);

            this.appController = new AplicacaoController();

            AdicionarTarefaSceneController tarefaSceneController = loader.getController();
            tarefaSceneController.associarParentUI(this);

        } catch (IOException ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "Erro ao criar aplicação", "Erro ao criar aplicação", String.format("Erro ao criar aplicação.%n%s%n%s", ex.getCause(), ex.getMessage()));
        }
    }

    private void confirmToSaveText(ActionEvent event) {
        String title, head, msg;
        title = "Export Text file";
        head = "Text Export";
        Optional<ButtonType> bt = AlertUI.createConfirmartionUI(title, head, "Export to text file?");
        if (bt.get() == ButtonType.YES) {
            FileChooser fc = new FileChooser();
            File myFile = fc.showSaveDialog(lstViewTarefas.getScene().getWindow());
            saveToText(myFile, title, head);

        } else {
            event.consume();
        }
    }

    private void confirmToSave(ActionEvent event) {
        String title, head, msg;
        title = "Save binary file";
        head = "File save";
        Optional<ButtonType> bt = AlertUI.createConfirmartionUI(title, head, "Save to binary file?");
        if (bt.get() == ButtonType.YES) {
            FileChooser fc = new FileChooser();
            File myFile = fc.showSaveDialog(lstViewTarefas.getScene().getWindow());
            saveToFile(myFile, title, head);
        } else {
            event.consume();
        }

//        FileChooser fc = new FileChooser();
//        File myFile = fc.showSaveDialog(lstViewTarefas.getScene().getWindow());
//        appController.saveToFile(myFile);
    }


    private int getListViewSelectionIndex() {
        return lstViewTarefas.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void lstViewTarefasContextMenuRequested(ContextMenuEvent event) {
//        AlertUI.createUI(Alert.AlertType.INFORMATION, "", "", String.valueOf(lstViewTarefas.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    private void menuFileOnShowing(Event event) {
        menuItemSaveBinary.setDisable(appController.listaVazia());
        menuItemSaveBinaryAs.setDisable(appController.listaVazia());
        menuItemSaveTextAs.setDisable(appController.listaVazia());
    }

    @FXML
    private void menuItemExitAction(ActionEvent event) {
        try {
            appController.saveToFileSilently();
        } catch (IOException ex) {
            AlertUI.createUI(Alert.AlertType.ERROR, "Filed to backup the Task List", "Failed to Backup File", "There was an error during the auto sabe operation.");
        }
        Platform.exit();
    }

    @FXML
    void menuItemOpenBinaryAction(ActionEvent event) {
        int addedTasks = appController.readFromFile();
        if (addedTasks > 0) {
            AlertUI.createUI(Alert.AlertType.INFORMATION, "Importação de Tarefas", addedTasks + " tasks were added", addedTasks + " tasks were added");
            updateList();
        } else {
            AlertUI.createUI(Alert.AlertType.INFORMATION, "Importação de Tarefas", addedTasks + " tasks were added", addedTasks + " tasks were added");
        }
    }

    @FXML
    private void menuItemOpenBinaryFromAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File myFile = fc.showOpenDialog(lstViewTarefas.getScene().getWindow());
        int addedTasks = appController.readFromFile(myFile);
        if (addedTasks > 0) {
            AlertUI.createUI(Alert.AlertType.INFORMATION, "Importação de Tarefas", addedTasks + " tasks were added", addedTasks + " tasks were added");
            updateList();
        } else {
            AlertUI.createUI(Alert.AlertType.INFORMATION, "Importação de Tarefas", addedTasks + " tasks were added", addedTasks + " tasks were added");
        }
    }

    @FXML
    private void menuItemRemoveAllAction(ActionEvent event) {
        appController.removeAllTasks();
        updateList();
    }

    @FXML
    private void menuItemRemoveSelectedAction(ActionEvent event) {
        int selectTask = getListViewSelectionIndex();
        if (selectTask > -1) {
            String tarefaParaRemover = lstViewTarefas.getItems().get(selectTask);
            String tarefaParaRemoverArray[] = tarefaParaRemover.split(" - ");
            String[] removedTask = appController.removeTask(tarefaParaRemoverArray[0], tarefaParaRemoverArray[1]);
            if (removedTask != null) {
                updateList();
            }
        } else {
            AlertUI.createUI(Alert.AlertType.WARNING, "Remover Tarefa", "Nenhuma tarefa selecionada", "Nenhuma tarefa selecionada. Por favor selectione uma tarefa para remover.");
        }

    }

    @FXML
    private void menuItemSaveBinaryAction(ActionEvent event) {
        saveToFile("Save to File", "Save to Binary File");
    }

    @FXML
    private void menuItemSaveBinaryAsAction(ActionEvent event) {
//        FileChooser fc = new FileChooser();
//        File myFile = fc.showSaveDialog(lstViewTarefas.getScene().getWindow());
        confirmToSave(event);
    }

    @FXML
    private void menuItemSaveTextAsAction(ActionEvent event) {
//        FileChooser fc = new FileChooser();
//        File myFile = fc.showSaveDialog(lstViewTarefas.getScene().getWindow());
//        confirmToSaveText(event, myFile);
        confirmToSaveText(event);
    }

    @FXML
    private void menuItemTaskAddAction(ActionEvent event) {
        novaTarefaStage.show();
    }

    @FXML
    private void menuTaskAction(ActionEvent event) {
    }

    @FXML
    private void menuTaskOnShowing(Event event) {
        menuRemove.setDisable(appController.listaVazia());
    }

    private void saveToFile(File myFile, String title, String head) {
        String msg;
        if (appController.saveToFile(myFile)) {
            msg = "File was succesfully recorded.";
        } else {
            msg = "Failed to record the file";
        }
        AlertUI.createUI(Alert.AlertType.INFORMATION, title, head, msg);
    }

    private void saveToFile(String title, String head) {
        File myFile = null;
        saveToFile(myFile, title, head);
    }

    private void saveToText(File myFile, String title, String head) {
        String msg;
        if (appController.saveAsTextFile(myFile)) {
            msg = "Text was succesfully exported.";
        } else {
            msg = "Failed to export.";
        }
        AlertUI.createUI(Alert.AlertType.INFORMATION, title, head, msg);
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
    }

    AplicacaoController getAppController() {
        return appController;
    }

    void updateList() {
        lstViewTarefas.getItems().clear();
        if (!appController.listaVazia()) {
            lstViewTarefas.getItems().addAll(appController.getListaTarefasAsArray());
        }
    }

}
