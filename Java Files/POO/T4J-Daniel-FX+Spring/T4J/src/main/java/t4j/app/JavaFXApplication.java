/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import t4j.app.model.Plataforma;
import t4j.app.repo.Dados;
import t4j.app.ui.AlertaUI;
import t4j.app.ui.MainSceneController;

/**
 *
 * @author user
 */
public class JavaFXApplication extends Application {

    private ConfigurableApplicationContext context;
    Parent root;
    Stage stage;
    FXMLLoader loader;

    // Daniel Junior 20210212 - 1250:
    // Movida para construtor privado da Plataforma
//    public static final String TITULO_APLICACAO = "Tasks For Joe - T4J";
    
    public static void main(String[] args) {
        launch(args);
    }
    // Method start, já inclui componentes da UI.
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root = this.loader.load();
        Scene scene = new Scene(this.root);
        this.stage = new Stage();

        this.stage.setTitle(Plataforma.getTITULO_APLICACAO());
        this.stage.setScene(scene);

        this.stage.sizeToScene();
        this.stage.setResizable(false);
        this.stage.setOnCloseRequest((WindowEvent event) -> {
            Alert alerta = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, stage.getTitle(), "Confirmação da ação.", "Deseja mesmo encerrar a aplicação?");
            
            if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                event.consume();
            }
            
            MainSceneController msc = loader.getController();
            msc.logoutAction(true);
        });
        this.stage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
        Platform.exit();
    }

    // Method Init, antes de qualquer operação gráfica
    @Override
    public void init() throws Exception {
        super.init();
        ApplicationContextInitializer<GenericApplicationContext> initializer
                = ac -> {
                    ac.registerBean(Application.class, () -> JavaFXApplication.this);
                    ac.registerBean(Parameters.class, this::getParameters);
                    ac.registerBean(HostServices.class, this::getHostServices);
                };
        context = new SpringApplicationBuilder()
                .sources(AppApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));

        loader = new FXMLLoader(MainSceneController.class.getResource("/fxml/MainScene.fxml"));
        
        // Testar desserialização de Plataforma, em caso de erro gerar um novo ficheiro:
        try {
            Plataforma p = Dados.carregarDados();
        } catch (Exception e) {
            Plataforma p1 = Plataforma.getInstance();
            Dados.guardarDados(p1);
            System.out.println("==============================================="
                    + "Erro na Desserialização. Possível diferença de "
                    + "versões entre Classes SerialUID.\n"
                    + "Criado novo ficheiro binário.\n\n" + e.getMessage());
        }
    }

}