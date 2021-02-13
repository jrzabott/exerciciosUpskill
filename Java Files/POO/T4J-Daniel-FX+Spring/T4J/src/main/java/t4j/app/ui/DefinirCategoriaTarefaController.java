package t4j.app.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import t4j.app.controller.UIDefinirCategoriaTarefaController;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CaraterCompetenciaTecnicaDTO;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.RegistoAreasAtividadeDTO;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.utils.AlgoritmoGeradorPasswords;

public class DefinirCategoriaTarefaController implements Initializable {

    private UIDefinirCategoriaTarefaController uidctc;
    private RegistoCompetenciasTecnicasDTO rctdto;
    private ArrayList<CaraterCompetenciaTecnicaDTO> cctdtos;
    private ObservableList<CaraterCompetenciaTecnicaDTO> cctdtosByAreaAtividade;

    @FXML
    private TextField txtFieldCodCategoria;
    @FXML
    private TextArea txtAreaDescCategoria;
    @FXML
    private ComboBox<AreaAtividadeDTO> cmbAreaAtividadeCategoria;
    @FXML
    private TableView<CaraterCompetenciaTecnicaDTO> tableViewGrausCompTec;
    @FXML
    private TableColumn<CaraterCompetenciaTecnicaDTO, String> tbColCodigo;
    @FXML
    private TableColumn<CaraterCompetenciaTecnicaDTO, String> tbColNome;
    @FXML
    private TableColumn<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO> tbColGrau;
    @FXML
    private TableColumn<CaraterCompetenciaTecnicaDTO, Boolean> tbColObrigatorio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uidctc = new UIDefinirCategoriaTarefaController();
        rctdto = uidctc.getRegistoCompetenciasTecnicas();
        cctdtos = new ArrayList<>();
        for (CompetenciaTecnicaDTO ct : uidctc.getRegistoCompetenciasTecnicas().
                getCompetenciasTecnicas()) {
            CaraterCompetenciaTecnicaDTO cctdto
                    = new CaraterCompetenciaTecnicaDTO();
            cctdto.setCompetenciaTecnica(ct);
            cctdtos.add(cctdto);
        }
        Platform.runLater(() -> {
            preencherComboBox();
            cmbAreaAtividadeCategoria.valueProperty().addListener(
                    new ChangeListener<AreaAtividadeDTO>() {
                @Override
                public void changed(
                        ObservableValue<? extends AreaAtividadeDTO> observable,
                        AreaAtividadeDTO oldValue,
                        AreaAtividadeDTO newValue) {
                    if (newValue != null || rctdto != null || rctdto.
                            getCompetenciasTecnicas() != null) {
                        cctdtosByAreaAtividade = FXCollections.
                                observableArrayList();
                        for (CaraterCompetenciaTecnicaDTO cctdto : cctdtos) {
                            if (cctdto.getCompetenciaTecnica().
                                    getAreaAtividade().getCodigo().
                                    equalsIgnoreCase(newValue.getCodigo())) {
                                cctdtosByAreaAtividade.add(cctdto);
                            }
                        }
                    }
                    preencherTableView2();
                }
            });
        });
    }

    @FXML
    private void btnRegistarCategoria(ActionEvent event) {
        try {
            ArrayList<CaraterCompetenciaTecnicaDTO> cctdtos = new ArrayList<>(
                    tableViewGrausCompTec.getItems());

            CategoriaTarefaDTO ctdto = new CategoriaTarefaDTO();
            ctdto.setCaraterCompetenciaTecnica(cctdtos);
            ctdto.setAreaAtividade(cmbAreaAtividadeCategoria.getValue());
            ctdto.setDescricao(txtAreaDescCategoria.getText().trim());
            ctdto.setIdCategoria(txtFieldCodCategoria.getText().trim());

            boolean result = uidctc.addCategoriaTarefa(ctdto);
            if (result) {
                String mensagem = String.format(
                        "Codigo: %s%n%nDescricao: %s%n%nArea de Atividade: %s - %s",
                        ctdto.getIdCategoria(),
                        ctdto.getDescricao(),
                        ctdto.getAreaAtividade().getCodigo(),
                        ctdto.getAreaAtividade().getDescBreve()
                );

                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Adicionar Categoria de Tarefas",
                        "Categoria de Tarefa adicionada com sucesso.",
                        mensagem);
                a.show();
                limparCampos();
            }

        } catch (Exception e) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.ERROR,
                    "Adicionar Categoria de Tarefas",
                    "Erro ao adicionar categoria de tarefa",
                    e.getMessage());
            a.show();
        }
    }

    @FXML
    private void btnLimparRegistarCategoria(ActionEvent event) {
        limparCampos();
    }

    @FXML
    private void btnCancelarRegistarCategoria(ActionEvent event) {
        limparCampos();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    private MainSceneController mainSceneController;

    private void preencherComboBox() {
        Callback<ListView<AreaAtividadeDTO>, ListCell<AreaAtividadeDTO>> cellFactory
                = new Callback<ListView<AreaAtividadeDTO>, ListCell<AreaAtividadeDTO>>() {
            @Override
            public ListCell<AreaAtividadeDTO> call(
                    ListView<AreaAtividadeDTO> listView) {
                return new ListCell<AreaAtividadeDTO>() {
                    @Override
                    protected void updateItem(AreaAtividadeDTO item,
                            boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(String.format(
                                    "%s - %s",
                                    item.getCodigo(),
                                    item.getDescBreve())
                            );
                        }
                    }
                };
            }
        };
        cmbAreaAtividadeCategoria.setButtonCell(cellFactory.call(null));
        cmbAreaAtividadeCategoria.setCellFactory(cellFactory);

        RegistoAreasAtividadeDTO raadto = uidctc.getRegistoAreasAtividadeDTO();
        cmbAreaAtividadeCategoria.getItems().addAll(raadto.getAtividades());

    }

    @FXML
    private void btnPopAction(ActionEvent event) {

//        for (CaraterCompetenciaTecnicaDTO item : tableViewGrausCompTec.getItems()) {
//            System.out.println(item.getCompetenciaTecnica().toString() + " - " + item.getGrauProficiencia().getDesignacao());
//        }
        String codigo = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.NUMEROS, 6);
        String desc = AlgoritmoGeradorPasswords.geraString(AlgoritmoGeradorPasswords.MIX,
                300);

        this.txtFieldCodCategoria.setText(codigo);
        this.txtAreaDescCategoria.setText(desc);

    }

    private void limparCampos() {
        this.txtFieldCodCategoria.clear();
        this.txtAreaDescCategoria.clear();
        cmbAreaAtividadeCategoria.setValue(null);
        tableViewGrausCompTec.getItems().clear();
    }

    void associarParentUI(MainSceneController mnc) {
        this.mainSceneController = mnc;
    }

    void preencherTableView2() {
        for (CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO
                : cctdtosByAreaAtividade) {

        }

        tbColCodigo.setPrefWidth(75);
        tbColNome.setPrefWidth(280);
        tbColGrau.setPrefWidth(105);
        tbColObrigatorio.setPrefWidth(100);

        /////////////////////////////////////////////
        // Coluna Cod Competencia Tecnica
        /////////////////////////////////////////////
        tbColCodigo.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().
                        getCompetenciaTecnica().getDescricaoBreve());
            }
        });
        tbColCodigo.setCellFactory(TextFieldTableCell.forTableColumn());

        /////////////////////////////////////////////
        // Coluna Desc Breve Competencia Tecnica
        /////////////////////////////////////////////
        tbColNome.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<CaraterCompetenciaTecnicaDTO, String> param) {
                return new SimpleStringProperty(param.getValue().
                        getCompetenciaTecnica().getDescricaoBreve());
            }
        });
        tbColNome.setCellFactory(TextFieldTableCell.forTableColumn());

        /////////////////////////////////////////////
        // Coluna Grau Proficiencia
        /////////////////////////////////////////////
        Callback<TableColumn<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO>, TableCell<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO>> cellFactory
                = new Callback<TableColumn<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO>, TableCell<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO>>() {
            @Override
            public TableCell<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO> call(
                    TableColumn<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO> p) {
                return new ComboBoxCell();
            }
        };

        tbColGrau.setEditable(true);
        tbColGrau.setCellValueFactory(
                new PropertyValueFactory<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO>(
                        "grauProficiencia"));
        tbColGrau.setCellFactory(cellFactory);
        tbColGrau.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO>>() {
            @Override
            public void handle(
                    TableColumn.CellEditEvent<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO> t) {
                ((CaraterCompetenciaTecnicaDTO) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setGrauProficiencia(t.
                        getNewValue());
            }
        }
        );

        /////////////////////////////////////////////
        // Coluna Obrigatorio
        /////////////////////////////////////////////
        tbColObrigatorio.setCellValueFactory(c -> new SimpleBooleanProperty(c.
                getValue().isObrigatorio()));
        tbColObrigatorio.setCellFactory(p -> {
            CheckBox checkBox = new CheckBox();
            TableCell<CaraterCompetenciaTecnicaDTO, Boolean> cell
                    = new TableCell<CaraterCompetenciaTecnicaDTO, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    if (empty) {
                        setGraphic(null);
                    } else {
                        checkBox.setSelected(item);
                        setGraphic(checkBox);
                    }
                }
            };
            checkBox.selectedProperty().addListener((obs, wasSelected,
                    isSelected)
                    -> ((CaraterCompetenciaTecnicaDTO) cell.getTableRow().
                            getItem()).setObrigatorio(isSelected));
            cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cell.setAlignment(Pos.CENTER);
            return cell;
        });

        tableViewGrausCompTec.setEditable(true);
        tableViewGrausCompTec.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE);
        tableViewGrausCompTec.getItems().clear();
        tableViewGrausCompTec.getItems().addAll(cctdtosByAreaAtividade);
    }

    class ComboBoxCell extends TableCell<CaraterCompetenciaTecnicaDTO, GrauProficienciaDTO> {

        private ComboBox<GrauProficienciaDTO> comboBox;

        public ComboBoxCell() {
            comboBox = new ComboBox<>();
            comboBox.valueProperty().addListener(
                    new ChangeListener<GrauProficienciaDTO>() {
                @Override
                public void changed(
                        ObservableValue<? extends GrauProficienciaDTO> observable,
                        GrauProficienciaDTO oldValue,
                        GrauProficienciaDTO newValue) {
                    tableViewGrausCompTec.requestFocus();
                }
            });
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();

                comboBox.setItems(FXCollections.observableArrayList(
                        getTableView().getItems().get(getIndex()).
                                getCompetenciaTecnica().getGrausProficiencia()));
                comboBox.getSelectionModel().select(getItem());

                comboBox.focusedProperty().addListener(
                        new ChangeListener<Boolean>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Boolean> observable,
                            Boolean oldValue, Boolean newValue) {
                        if (!newValue) {
                            commitEdit(comboBox.getSelectionModel().
                                    getSelectedItem());
                        }
                    }
                });

                setText(null);
                setGraphic(comboBox);
            }

        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(getItem().toString());
            setGraphic(null);
        }

        @Override
        public void updateItem(GrauProficienciaDTO item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    setText(null);
                    setGraphic(comboBox);
                } else {
                    setText(getItem().toString());
                    setGraphic(null);
                }
            }
            commitEdit(item);
        }

    }
}
