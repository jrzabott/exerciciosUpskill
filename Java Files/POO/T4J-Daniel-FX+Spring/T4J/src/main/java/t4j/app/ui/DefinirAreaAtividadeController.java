package t4j.app.ui;

import t4j.app.controller.UIAtividadesController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import t4j.app.JavaFXApplication;
import t4j.app.utils.AlgoritmoGeradorPasswords;

public class DefinirAreaAtividadeController implements Initializable {

    private MainSceneController mainSceneController;
    
    @FXML
    private TextField txtFieldCodAreaAtividade;
    @FXML
    private TextField txtFieldNomeAreaAtividade;
    @FXML
    private TextArea txtAreaDescAreaAtividade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        String codAtividade, descBreve, descDet;

        codAtividade = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS_NUMEROS, 6);
        descBreve = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS_NUMEROS, 20);
        descDet = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX, 1000);

        txtFieldCodAreaAtividade.setText(codAtividade);
        txtFieldNomeAreaAtividade.setText(descBreve);
        txtAreaDescAreaAtividade.setText(descDet);

        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n\n");
        sb.append("codAtividade = ").append(codAtividade);
        sb.append("descBreve = ").append(descBreve);
        sb.append("descDet = ").append(descDet);
        sb.append("==========================================\n\n");

    }

    @FXML
    private void btnRegistarAreaAtividade(ActionEvent event) {
        boolean result;
        try {
            String codAtividade, descBreve, descDet;

            codAtividade = txtFieldCodAreaAtividade.getText();
            descBreve = txtFieldNomeAreaAtividade.getText();
            descDet = txtAreaDescAreaAtividade.getText();

            result = UIAtividadesController.registarAreaAtividade(
                    codAtividade,
                    descBreve,
                    descDet
            );
            if (result) {
                String mensagem = String.format(
                        "A area de atividade:%n%nCódigo: %s%nDescrição Breve: %s"
                        + "%n%nFoi adicionada com sucesso.",
                        codAtividade, descBreve);
                Alert a = AlertaUI.criarAlerta(Alert.AlertType.INFORMATION,
                        "REGISTAR NOVA AREA DE ATIVIDADE",
                        "Registo de Area de Atividade",
                        mensagem);
                a.show();

            }
        } catch (Exception e) {
            Alert a = AlertaUI.criarAlerta(Alert.AlertType.ERROR,
                    "REGISTAR NOVA AREA DE ATIVIDADE",
                    "Registo de Area de Atividade", e.getMessage());
            a.show();
        }
    }

    @FXML
    private void btnLimparRegistarAreaAtividade(ActionEvent event) {
        this.txtFieldCodAreaAtividade.clear();
        this.txtFieldNomeAreaAtividade.clear();
        this.txtAreaDescAreaAtividade.clear();
    }

    @FXML
    private void btnCancelarRegistarAreaAtividade(ActionEvent event) {
        this.txtFieldCodAreaAtividade.clear();
        this.txtFieldNomeAreaAtividade.clear();
        this.txtAreaDescAreaAtividade.clear();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

//    private MenuAdministrativoController menuAdministrativoController;
//    void associarParentUI(MenuAdministrativoController mnc) {
//        this.menuAdministrativoController = mnc;
//    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }
}
