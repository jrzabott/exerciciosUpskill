package t4j.app.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import sun.java2d.pipe.SpanShapeRenderer;
import t4j.app.controller.UIApplicationController;
import t4j.app.controller.UIEspecificarTarefaController;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.RegistoCategoriasDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.service.TarefasService;
import t4j.app.utils.AlgoritmoGeradorPasswords;

public class EspecificarTarefaController implements Initializable {

    private UIApplicationController appController;
    private MainSceneController mainSceneController;
    private UIEspecificarTarefaController uietc;
    private RegistoCategoriasDTO rcdto;

    @FXML
    private TextField txtFieldCodTarefa;
    @FXML
    private TextField txtFieldNomeTarefa;
    @FXML
    private TextArea txtAreaDescTarefa;
    @FXML
    private TextArea txtAreaDTecnicaTarefa;
    @FXML
    private TextField txtFieldDuracaoTarefa;
    @FXML
    private TextField txtFieldCustoTarefa;
    @FXML
    private ComboBox<CategoriaTarefaDTO> cmbCategoria;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uietc = new UIEspecificarTarefaController();
        rcdto = uietc.getRegistoCategoriasDTO();

        Platform.runLater(() -> {
            preencherComboBox();
        });
    }

    @FXML
    private void btnRegistarTarefa(ActionEvent event) {
        TarefaDTO tdto = new TarefaDTO();
        tdto.setReferencia(txtFieldCodTarefa.getText().trim());
        tdto.setCustoEstimado(txtFieldCustoTarefa.getText().trim());
        tdto.setDescricaoInformal(txtAreaDescTarefa.getText().trim());
        tdto.setDescricaoTecnica(txtAreaDTecnicaTarefa.getText().trim());
        tdto.setDesignacao(txtFieldNomeTarefa.getText().trim());
        tdto.setDuracaoEstimada(txtFieldDuracaoTarefa.getText().trim());

        CategoriaTarefaDTO ctdto = cmbCategoria.getValue();
        
        tdto.setCategoria(ctdto);
        try {
            boolean result = uietc.addTarefa(tdto);
            if (result) {
                Alert a = AlertaUI.criarAlerta(Alert.AlertType.INFORMATION,
                        "Especificar Tarefa",
                        "Criação de Nova Tarefa", "Tarefa criada com sucesso");
                a.show();
                limparCampos();
                return;
            }
        } catch (Exception e) {
                Alert a = AlertaUI.criarAlerta(Alert.AlertType.ERROR,
                        "Especificar Tarefa",
                        "Erro ao criar nova Tarefa", e.getMessage());
                a.show();
            
        }
    }

    @FXML
    private void btnLimparRegistarTarefa(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void btnCancelarRegistarTarefa(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void btnPopAction(ActionEvent event) {
        txtFieldCodTarefa.setText(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.LETRAS_NUMEROS, 8));
        txtFieldNomeTarefa.setText(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX, 20));
        txtAreaDescTarefa.setText(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX + " ", 300));
        txtAreaDTecnicaTarefa.setText(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX + " ", 300));
        txtFieldDuracaoTarefa.setText(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 4));
        txtFieldCustoTarefa.setText(AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 4) + "." + AlgoritmoGeradorPasswords.
                        geraString(AlgoritmoGeradorPasswords.NUMEROS, 2));
    }

    private void limparCampos() {
        this.txtFieldCodTarefa.clear();
        this.txtFieldNomeTarefa.clear();
        this.txtAreaDescTarefa.clear();
        this.txtAreaDTecnicaTarefa.clear();
        this.txtFieldDuracaoTarefa.clear();
        this.txtFieldCustoTarefa.clear();
        cmbCategoria.setValue(null);
    }

    private void preencherComboBox() {
        cmbCategoria.setItems(FXCollections.observableArrayList(rcdto.
                getCategorias()));
        Callback<ListView<CategoriaTarefaDTO>, ListCell<CategoriaTarefaDTO>> cellFactory
                = new Callback<ListView<CategoriaTarefaDTO>, ListCell<CategoriaTarefaDTO>>() {

            @Override
            public ListCell<CategoriaTarefaDTO> call(
                    ListView<CategoriaTarefaDTO> l) {
                return new ListCell<CategoriaTarefaDTO>() {

                    @Override
                    protected void updateItem(CategoriaTarefaDTO item,
                            boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(
                                    String.format("%s - %s...",
                                            item.getIdCategoria(),
                                            item.getDescricao().substring(0, 40)));
                        }
                    }
                };
            }
        };
        cmbCategoria.setButtonCell(cellFactory.call(null));
        cmbCategoria.setCellFactory(cellFactory);
    }

    void associarParentUI(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
        this.appController = mainSceneController.getAppController();
    }
}