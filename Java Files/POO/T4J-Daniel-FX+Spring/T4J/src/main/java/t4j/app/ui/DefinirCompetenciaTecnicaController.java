package t4j.app.ui;

import t4j.app.controller.UIDefinirCompetenciaTecnicaController;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.RegistoAreasAtividadeDTO;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.service.AreaAtividadeService;
import t4j.app.utils.AlgoritmoGeradorPasswords;

public class DefinirCompetenciaTecnicaController implements Initializable {

    @FXML
    private TextField txtFieldCodCompetenciaTecnica;
    @FXML
    private TextField txtFieldNomeCompetenciaTecnica;
    @FXML
    private TextArea txtAreaDescCompetenciaTecnica;
    @FXML
    private ComboBox<String> cmbAreaAtividadeCT;

    private MainSceneController mainSceneController;
    private UIDefinirCompetenciaTecnicaController uidctc;

    @FXML
    private TextField txtFieldGrauCompetencia;
    @FXML
    private Button btnAddGrauCompetencia;
    @FXML
    private ListView<String> listViewGrauCompetencia;
    @FXML
    private Button btnRemoverGrauCompetencia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.uidctc = new UIDefinirCompetenciaTecnicaController();

        Platform.runLater(() -> {
            // popular combobox
            preencherAreasDeAtividade();
        });
    }

    @FXML
    private void btnRegistarCompetenciaTecnica(ActionEvent event) {
        if (cmbAreaAtividadeCT.getValue() == null) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.WARNING,
                    "Competência Técnica",
                    "Competência Técnica",
                    "Deve selecionar uma Área de Atividade.");
            a.show();
            return;
        }
        if (listViewGrauCompetencia.getItems().size() < 1) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.WARNING,
                    "Competência Técnica",
                    "Competência Técnica",
                    "Uma competência técnica deve ter ao menos um grau de proficiência registado.");
            a.show();
            return;
        }
        try {
            CompetenciaTecnicaDTO ctdto = new CompetenciaTecnicaDTO();
            ctdto.setCodigoCompetenciaTecnica(txtFieldCodCompetenciaTecnica.getText().trim());
            ctdto.setDescricaoBreve(txtFieldNomeCompetenciaTecnica.getText().trim());
            ctdto.setDescricaoDetalhada(txtAreaDescCompetenciaTecnica.getText().trim());
            ctdto.setAreaAtividade(new AreaAtividadeDTO());

            ///////////////////////////////////////////////////////////////////
            // Preparar Graus de Competência e GrauProficienciaDTO
            ArrayList<GrauProficienciaDTO> gpdtos = new ArrayList<>();

            for (String item : listViewGrauCompetencia.getItems()) {
                GrauProficienciaDTO gpdto = new GrauProficienciaDTO();
                gpdto.setDesignacao(item.substring(4));
                gpdto.setValor(item.substring(0, 2));
                gpdtos.add(gpdto);
            }
            ctdto.setGrausProficiencia(gpdtos);

            ///////////////////////////////////////////////////////////////////
            // Preparar Area de Atividade e AreaAtividadeDTO
            String[] codAreaAtividadeArray = cmbAreaAtividadeCT.getValue().split(" - ");
            String codAreaAtividade = codAreaAtividadeArray[0].trim();
            ctdto.getAreaAtividade().setCodigo(codAreaAtividade);

            boolean result = this.uidctc.adicionarCompetenciaTecnica(ctdto);
            if (result) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Competência Técnica",
                        "Competência Técnica",
                        "Competência Técnica criada com sucesso.");
                a.show();
                return;
            }
        } catch (Exception e) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Competência Técnica",
                    "Competência Técnica",
                    e.getMessage());
            a.show();
        }
    }

    @FXML
    private void btnLimparRegistarCompetenciaTecnica(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void btnCancelarRegistarCompetenciaTecnica(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private void limparCampos() {
        this.txtFieldCodCompetenciaTecnica.clear();
        this.txtFieldNomeCompetenciaTecnica.clear();
        this.txtAreaDescCompetenciaTecnica.clear();
        this.cmbAreaAtividadeCT.setValue(null);
        this.listViewGrauCompetencia.getItems().clear();
        this.txtFieldGrauCompetencia.clear();
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        String codCompetenciaTecnica = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS_NUMEROS, 20);
        String nomeCompetenciaTecnica = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS_NUMEROS, 60);
        String descCompetenciaTecnica = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX, 1024);

        this.txtFieldCodCompetenciaTecnica.setText(codCompetenciaTecnica);
        this.txtFieldNomeCompetenciaTecnica.setText(nomeCompetenciaTecnica);
        this.txtAreaDescCompetenciaTecnica.setText(descCompetenciaTecnica);

        Random rnd = new Random();
        int numOfGraus = rnd.nextInt(6) + 3;
        listViewGrauCompetencia.getItems().clear();
        for (int i = 0; i < numOfGraus; i++) {
            addGrau2List(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX, rnd.nextInt(15) + 5));
        }

        preencherAreasDeAtividade();
    }

    private void preencherAreasDeAtividade() {
        // preencherAreasDeAtividade() {}
        RegistoAreasAtividadeDTO raadto = new RegistoAreasAtividadeDTO();
        raadto = AreaAtividadeService.getRegistoAreasAtividade();
        cmbAreaAtividadeCT.getItems().clear();
        if (raadto != null && raadto.getAtividades().size() > 0) {
            for (AreaAtividadeDTO atividade : raadto.getAtividades()) {
                cmbAreaAtividadeCT.getItems().add(atividade.getCodigo() + " - " + atividade.getDescBreve());
            }
        }
    }

    @FXML
    private void btnAddGrauCompetenciaAction(ActionEvent event) {
        addGrau2List(txtFieldGrauCompetencia.getText());
        txtFieldGrauCompetencia.requestFocus();
    }

    @FXML
    private void btnRemoverGrauCompetenciaAction(ActionEvent event) {
        int index = 0;
        index = this.listViewGrauCompetencia.getSelectionModel().getSelectedIndex();
        if (index > -1 && this.listViewGrauCompetencia.getItems().size() > 0) {
            listViewGrauCompetencia.getItems().remove(index);
            for (int i = index; i < this.listViewGrauCompetencia.getItems().size(); i++) {
                StringBuilder sb = new StringBuilder();
                String s = this.listViewGrauCompetencia.getItems().get(i);
                if (i < 10) {
                    sb.append("0");
                }
                sb.append(i + 1).append(". ");
                sb.append(s.substring(4));
                this.listViewGrauCompetencia.getItems().set(i, sb.toString());
            }
        }
    }

    private void addGrau2List(String s) throws ElementoInvalidoException {
        if (!s.trim().isEmpty()) {
            int numOfItens = (listViewGrauCompetencia.getItems().size());
            String grau = s.trim();
            StringBuilder sb = new StringBuilder();
            if (numOfItens < 9) {
                sb.append("0");
            }
            if (numOfItens >= 99) {
                throw new ElementoInvalidoException("Não é possível haver mais de 100 Graus de competência.");
            }
            sb.append(numOfItens + 1).append(". ").append(grau);
            boolean itemExists = false;
            for (String item : listViewGrauCompetencia.getItems()) {
                if (item.substring(4).equalsIgnoreCase(sb.toString().substring(4))) {
                    itemExists = true;
                }
            }
            if (!itemExists) {
                this.listViewGrauCompetencia.getItems().add(sb.toString());
            }
        }
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }
}
