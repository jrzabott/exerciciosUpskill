package org.upskill.listatarefas.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Lista de Tarefas");
        stage.setScene(scene);

        stage.sizeToScene();
        stage.setResizable(false);

        stage.show();

//        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                AplicacaoController appController = new AplicacaoController();
//                try {
//                    System.out.println("Task launched");
//                    if (appController.saveToFile()) {
//                        AlertUI.createUI(Alert.AlertType.INFORMATION, "Backup Salvo", "Backup Salvo", "Backup Salvo");
//                    } else {
//                        AlertUI.createUI(Alert.AlertType.INFORMATION, "Backup Perdido", "Backup Perdido", "Backup Perdido");
//                    }
//                } finally {
//
//                    Platform.exit();
//                }
//            }
//        });
    }

}
