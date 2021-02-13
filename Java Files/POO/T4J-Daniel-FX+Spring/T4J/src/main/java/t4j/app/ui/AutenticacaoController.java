package t4j.app.ui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import t4j.app.controller.UIApplicationController;
import t4j.app.controller.UIAutenticacaoController;
import t4j.app.dto.ErroUsersAPIDTO;
import t4j.app.dto.UserInfoDTO;

@SuppressWarnings("Convert2Lambda")
public class AutenticacaoController implements Initializable {

    private MainSceneController mainSceneController;
    private UIApplicationController appController;
    private UIAutenticacaoController uiac;

    @FXML
    private TextField txtFieldIDUtilizador;
    @FXML
    private TextField txtFieldPasswordOld;
    @FXML
    private PasswordField pwdFieldPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.uiac = new UIAutenticacaoController();
        Platform.runLater(() -> {
            pwdFieldPassword.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    txtFieldPasswordOld.setText(newValue);
                }
            });
            txtFieldPasswordOld.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    pwdFieldPassword.setText(newValue);
                }
            });

            uiac.setAppController(appController);
            uiac.setMainSceneController(mainSceneController);
            mainSceneController.setUiac(this.uiac);
        });

    }

    public UIAutenticacaoController getUiac() {
        return uiac;
    }

    public void setUiac(UIAutenticacaoController uiac) {
        this.uiac = uiac;
    }

    @FXML
    private void btnLoginCancelar(ActionEvent event) {
        this.txtFieldIDUtilizador.clear();
        this.pwdFieldPassword.clear();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLoginEntrar(ActionEvent event) {
        // Itens do JavaFX
        String username = txtFieldIDUtilizador.getText().trim();
        String password = pwdFieldPassword.getText().trim();

        UserInfoDTO u = mainSceneController.getUidto();
        u.setUsername(username);
        u.setPassword(password);

        try {
            boolean login = uiac.login(u);
            if (!login) {
                String httpResponse = mainSceneController.getUidto().getLastHttpResponse();
                ArrayList<ErroUsersAPIDTO> euapidto = new ArrayList<>();
                TypeReference<ArrayList<ErroUsersAPIDTO>> tr = new TypeReference<ArrayList<ErroUsersAPIDTO>>() {
                };
                euapidto = new ObjectMapper().readValue(httpResponse, tr);

                Alert a = AlertaUI.criarAlerta(Alert.AlertType.ERROR,
                        "Login",
                        "Login",
                        String.format(
                                "%s\n\n===============================\n%s\n\n===============================\n%s",
                                "Login mal sucedido.",
                                euapidto.get(0).toString(),
                                this.mainSceneController.getUidto().toString()
                        )
                );
                a.showAndWait();
                return;
            }

            Alert a = AlertaUI.criarAlerta(Alert.AlertType.INFORMATION,
                    "Login",
                    "Login", String.format(
                            "%s\n\n=================================\n%s",
                            "Login bem sucedido.",
                            this.mainSceneController.getUidto().toString())
            );
            a.showAndWait();
            mainSceneController.setMenuItemLoginText(u.getUsername());
            mainSceneController.setMenuItemLogoutDisabled(!login);
            appController.showMenusByRole(u);
            ((Node) event.getSource()).getScene().getWindow().hide();

        } catch (Exception e) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Erro ao efetuar Login",
                    "Ocorreu um erro ao efetuar o Login:",
                    e.getMessage());
            a.show();
        }
//        String username = txtFieldIDUtilizador.getText();
//        String password = pwdFieldPassword.getText();
//        try {
//            /**
//             * Não existe uidto (na mainScene) solicita login efetua login login
//             * é bem-sucedido é criado novo uidto é armazenado este uidto no
//             * mainSceneController
//             */
//
//            boolean login = uiac.login(username, password);
//
//            String mensagem = "Não foi possível efetuar o login.";
//            if (login) {
//                mensagem = uiac.getSession();
//                mainSceneController.setApp_context(uiac.getApp_context());
//                mainSceneController.setSession(uiac.getSession());
//
//                UserInfoDTO uidto = mainSceneController.getUidto();
//                if (uidto == null) {
//                    uidto = new UserInfoDTO();
//                }
//                uidto.setUsername(username);
//                uidto.setPassword(password);
//                uidto.setEmail(username);
//                uidto.setApp_context(uiac.getApp_context());
//                String roles[] = uiac.getRoles();
//                String rolesAsString = String.join(",", roles);
//                uidto.setRolenames(rolesAsString);
//                mainSceneController.setUidto(uidto);
//            }
//
//            Alert a = AlertaUI.criarAlerta(
//                    Alert.AlertType.INFORMATION,
//                    "Teste Login",
//                    "Teste do Login",
//                    (mensagem + "\n\n=================================\n"
//                    + "Dados do user armazenados localmente:\n"
//                    + ((uiac.getUserByUsername(username).isEmpty())
//                    ? "Não há info disponível."
//                    : uiac.getUserByUsername(username)))
//            );
//            a.showAndWait();
//
//            ((Node) event.getSource()).getScene().getWindow().hide();
//
//        } catch (Exception e) {
//            Alert a = AlertaUI.criarAlerta(
//                    Alert.AlertType.ERROR,
//                    "Teste Login",
//                    "Teste do Login",
//                    e.getMessage() + "\n\nInformações do Cache Local:\n"
//                    + ((uiac.getUserByUsername(username).isEmpty())
//                    ? "Não há info disponível."
//                    : uiac.getUserByUsername(username))
//            );
//            a.show();
//        }
    }

    @FXML
    private void txtFieldPasswordOldAction(ActionEvent event
    ) {
        pwdFieldPassword.setText(txtFieldPasswordOld.getText());
        System.out.println(txtFieldPasswordOld.getText());
    }

    void associarParentUI(MainSceneController mnc
    ) {
        this.mainSceneController = mnc;
        this.appController = mainSceneController.getAppController();
    }
}
