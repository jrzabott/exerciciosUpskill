package upskill.convertergui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    @FXML
    private Button btnSair;
    @FXML
    private TextField txtFieldC;
    @FXML
    private TextField txtFieldF;
    @FXML
    private Button btnAction;
    @FXML
    private Button btnConverter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnSairAction(ActionEvent event) {
        Alert mensagemSaida = new Alert(Alert.AlertType.CONFIRMATION);
        mensagemSaida.setTitle("Aplicação");
        mensagemSaida.setHeaderText("Confirmação da Ação:");
        mensagemSaida.setContentText("Deseja mesmo fechar a aplicação?");

        ((Button) mensagemSaida.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
        ((Button) mensagemSaida.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");

        if (mensagemSaida.showAndWait().get() == ButtonType.OK) {
            btnSair.getScene().getWindow().hide();
        }
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        txtFieldC.setText("");
        txtFieldF.setText("");
    }

    @FXML
    private void btnConverterAction(ActionEvent event) {

        try {
            float valorCelsius = Float.parseFloat(txtFieldC.getText());
            float valorFahrenheit = 0;
            valorFahrenheit = 1.8f * valorCelsius + 32.0f;
            txtFieldF.setText(String.valueOf(valorFahrenheit));
        } catch (NumberFormatException e) {
            Alert mensagemErro = new Alert(Alert.AlertType.ERROR);
            mensagemErro.setTitle("Erro ao calcular");
            mensagemErro.setHeaderText("Temperatura em Celsius Inválida.");
            mensagemErro.setContentText("Favor inserir um número válido.");
            mensagemErro.show();
        }
    }
}
