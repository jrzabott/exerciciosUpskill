package upskill.atletascomficheiros.ui;

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
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/JanelaPrincipalScene.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Atletas com Ficheiros");
        stage.setScene(scene);

        stage.sizeToScene();
        stage.setResizable(false);

        stage.show();
    }

    
    private void test1 () {
        if (true) {
            throw new IllegalArgumentException("extends RunTimeException");
        } else {
            throw new myException("myException extends Exception");
        }
        throw new RuntimeException("RunTime Exception");
    }
    
    class myException extends RuntimeException {

        public myException(String string) {
            super(string);
        }
        
    }
}
