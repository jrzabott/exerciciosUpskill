package org.upskill.listatarefas.ui;

import com.sun.scenario.effect.impl.Renderer;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.upskill.listatarefas.controller.AplicacaoController;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/JanelaPrincipalScene.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Lista de Tarefas");
        stage.setScene(scene);

        stage.sizeToScene();
        stage.setResizable(false);

        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    AplicacaoController appController = ((JanelaPrincipalSceneController)loader.getController()).getAppController();
                    String[] s = appController.getListaTarefasAsArray();
                    appController.saveToFileSilently();
                } catch (IOException ex) {
                    AlertUI.createUI(Alert.AlertType.ERROR, "Filed to backup the Task List", "Failed to Backup File", "There was an error during the auto sabe operation.");
                }
            }
        });
    }

}
