package t4j.app.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import t4j.app.controller.UIApplicationController;
import t4j.app.controller.UIRegistarOrganizacaoController;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.EnderecoPostalDTO;
import t4j.app.dto.OrganizacaoDTO;

public class RegistarOrganizacaoController implements Initializable {

    private UIApplicationController appController;
    private MainSceneController mainSceneController;

    @FXML
    private TextField txtFieldEmailGestor;
    @FXML
    private TextField txtFieldEmailOrganizacao;
    @FXML
    private TextField txtFieldEndCodigoPostalOrganizacao;
    @FXML
    private TextField txtFieldEndLocalidadeOrganizacao;
    @FXML
    private TextField txtFieldEndMoradaOrganizacao;
    @FXML
    private TextField txtFieldFuncaoGestor;
    @FXML
    private TextField txtFieldNifOrganizacao;
    @FXML
    private TextField txtFieldNomeGestor;
    @FXML
    private TextField txtFieldNomeOrganizacao;
    @FXML
    private TextField txtFieldTelefoneGestor;
    @FXML
    private TextField txtFieldTelefoneOrganizacao;
    @FXML
    private TextField txtFieldWebsiteOrganizacao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            txtFieldEndMoradaOrganizacao.setPromptText("Morada");
            txtFieldEndCodigoPostalOrganizacao.setPromptText("Código Postal");
            txtFieldEndLocalidadeOrganizacao.setPromptText("Localidade");
        });
    }

    @FXML
    private void btnCancelarRegistarOrg(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnLimparRegistarOrg(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        String charsNum = "0123456789";
        String charsLetters = "abcdefghijklmnopqrstuvwxyz";

        // Endereço Postal ////////////////////////////////////
        txtFieldEndMoradaOrganizacao.setText("Viela dos Anjos, 123");
        txtFieldEndCodigoPostalOrganizacao.setText(geraString(charsNum, 4) + "-" + geraString(charsNum, 3));
        txtFieldEndLocalidadeOrganizacao.setText("Matosinhos");

        // Organização//// ////////////////////////////////////
        String companyName = geraString(charsLetters, 10);
        txtFieldNomeOrganizacao.setText(companyName);
        txtFieldNifOrganizacao.setText(geraString(charsNum, 9));
        txtFieldEmailOrganizacao.setText(String.format("%s@%s.com", companyName, companyName));
        txtFieldTelefoneOrganizacao.setText("555552323");
        txtFieldWebsiteOrganizacao.setText("http://www." + companyName + ".pt");

        // Gestor /////////////////////////////////////////////
        String nameManager = geraString(charsLetters, 6);
        txtFieldNomeGestor.setText(nameManager);
        txtFieldFuncaoGestor.setText("Capataz");
        txtFieldTelefoneGestor.setText("555551234");
        txtFieldEmailGestor.setText(String.format("%s@%s.com", nameManager, companyName));
    }

    public String geraString(String chars, int length) {
        String SALTCHARS;
        if (chars.isEmpty()) {
            SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%=-";
        } else {
            SALTCHARS = chars;
        }
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    @FXML
    private void btnRegistarOrg(ActionEvent event) {
        try {
            OrganizacaoDTO odto = new OrganizacaoDTO();
            EnderecoPostalDTO epdto = new EnderecoPostalDTO();
            ColaboradorDTO gestordto = new ColaboradorDTO();

            // Endereço Postal ////////////////////////////////////
            epdto.setMorada(this.txtFieldEndMoradaOrganizacao.getText().trim());
            epdto.setCodPostal(this.txtFieldEndCodigoPostalOrganizacao.getText().trim());
            epdto.setLocalidade(this.txtFieldEndLocalidadeOrganizacao.getText().trim());

            // Gestor /////////////////////////////////////////////
            gestordto.setNome(this.txtFieldNomeGestor.getText().trim());
            gestordto.setFuncao(this.txtFieldFuncaoGestor.getText().trim());
            gestordto.setTelefone(this.txtFieldTelefoneGestor.getText().trim());
            gestordto.setEmail(this.txtFieldEmailGestor.getText().trim());

            // Gestor Deve ser um Colaborador  ///////////////////
            ArrayList<ColaboradorDTO> list = new ArrayList<>();
            list.add(gestordto);
            odto.setColaboradores(list);

            // Organização//// ////////////////////////////////////
            odto.setNomeOrganizacao(this.txtFieldNomeOrganizacao.getText().trim());
            odto.setNifOrganizacao(this.txtFieldNifOrganizacao.getText().trim());
            odto.setEmailOrganizacao(this.txtFieldEmailOrganizacao.getText().trim());
            odto.setTelefoneOrganizacao(this.txtFieldTelefoneOrganizacao.getText().trim());
            odto.setWebsiteOrganizacao(this.txtFieldWebsiteOrganizacao.getText().trim());

            // Organização + EndPostal e Gestor ///////////////////
            odto.setEnderecoPostalDTO(epdto);
            odto.setGestorDTO(gestordto);

            boolean registada = UIRegistarOrganizacaoController.registarOrganizacao(odto);
//        
//
//        // Endereço Postal ////////////////////////////////////
//        epdto.setMorada("Viela dos Anjos, 123");
//        epdto.setCodPostal("4321-567");
//        epdto.setLocalidade("Matosinhos");
//        
//        // Gestor /////////////////////////////////////////////
//        gestordto.setNome("Gabriel");
//        gestordto.setFuncao("Capataz");
//        gestordto.setTelefone("555551234");
//        gestordto.setEmail("miguel@primeiratentativa.pt");
//        
//        // Organização//// ////////////////////////////////////
//        odto.setNomeOrganizacao("Segunda Tentativa");
//        odto.setNifOrganizacao("123123126");
//        odto.setEmailOrganizacao("pt@segundatentativa.pt");
//        
//        // Organização + EndPostal e Gestor ///////////////////
//        odto.setEnderecoPostalDTO(epdto);
//        odto.setGestorDTO(gestordto);
//        
//        // Gestor Deve ser um Colaborador  ///////////////////
//        list = new ArrayList<>();
//        list.add(gestordto);
//        odto.setColaboradores(list);
//        
//        odto.setTelefoneOrganizacao("555552323");
//        odto.setWebsiteOrganizacao("http://www.primeiratentativa.pt");
//        boolean registada = UIRegistarOrganizacaoController.registarOrganizacao(odto);

            if (registada) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Registo de Organizacoes",
                        "Registo de Organização.",
                        "Organização Registada com Sucesso."
                );
                a.show();

                ((Node) event.getSource()).getScene().getWindow().hide();
                limparCampos();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Registo de Organizacoes",
                    "Por favor corrija os itens abaixo:",
                    e.getMessage());
            a.show();
        }
    }

    private void limparCampos() {
        this.txtFieldNomeOrganizacao.clear();
        this.txtFieldNifOrganizacao.clear();
        this.txtFieldEndMoradaOrganizacao.clear();
        this.txtFieldEmailOrganizacao.clear();
        this.txtFieldNomeGestor.clear();
        this.txtFieldFuncaoGestor.clear();
        this.txtFieldTelefoneGestor.clear();
        this.txtFieldEmailGestor.clear();
        this.txtFieldEndCodigoPostalOrganizacao.clear();
        this.txtFieldEndLocalidadeOrganizacao.clear();
        this.txtFieldWebsiteOrganizacao.clear();
    }

    void associarParentUI(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
        this.appController = mainSceneController.getAppController();
    }
}
/*
Ny8-DPsTxm8rO5jwj1
Enviar email: pt@potato.pt
Password: Ny8-DPsTxm8rO5jwj1
 */
