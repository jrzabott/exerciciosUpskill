package upskill.exerciciodatagui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;

public class FXMLController implements Initializable {

    @FXML
    private Button btnWeekDay;
    @FXML
    private Button btnFullDate;
    @FXML
    private Button btnLimpar;
    @FXML
    private TextField txtFieldUserDate;
    @FXML
    private TextField txtFieldWeekDay;
    @FXML
    private Label lblResult;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnWeekDayAction(ActionEvent event) {
        Data d = getData();
        if (d != null) {
            txtFieldWeekDay.setText(d.diaDaSemana());
        }
    }

    @FXML
    private void btnFullDateAction(ActionEvent event) {
        Data d = getData();
        if (d != null)
            lblResult.setText(d.toString());
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        txtFieldUserDate.clear();
        txtFieldWeekDay.clear();
        lblResult.setText("");
    }

    @FXML
    private void txtFieldUserDateKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnFullDateAction(new ActionEvent(this, txtFieldUserDate));
//            lblResult.setText("You pressed Enter");
        }
    }

    private boolean validarData(String data) {

        boolean result = false;
        try {
            result = Data.validaDataString(data);
        } catch (MesInvalidoException | DiaInvalidoException | IllegalArgumentException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            a.setContentText(ex.getMessage());
            a.show();
            lblResult.setText("");
            txtFieldWeekDay.clear();
            
        }
        return result;
    }

    private Data getData() {
        Data result = null;
        String userDate = txtFieldUserDate.getText();
        if (validarData(userDate)) {
            String[] sData = userDate.split("/");
            Data d = new Data(Integer.parseInt(sData[0]), Integer.parseInt(sData[1]), Integer.parseInt(sData[2]));
            return d;
        }
        return result;
    }
}
