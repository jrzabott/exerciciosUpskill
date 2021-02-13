package t4j.app.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class AlertaUI {

    public static Alert criarAlerta(Alert.AlertType tipoAlerta, String titulo, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
//        alerta.setContentText(mensagem);
        alerta.getDialogPane().setPrefWidth(800);
        
        TextArea ta = new TextArea(mensagem);
        ta.setWrapText(true);
        ta.setEditable(false);
        
        alerta.getDialogPane().setContent(ta);
        if (tipoAlerta == Alert.AlertType.CONFIRMATION) {
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");
        }
        return alerta;
    }
}
