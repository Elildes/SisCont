package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaSobreControle {
	
	private Stage sobreStage;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnOk;

    @FXML
    private Label lblInfo1;

    @FXML
    private Label lblInfo11;

    @FXML
    private Label lblInfo2;

    @FXML
    private Label lblInfo111;

    @FXML
    private Label lblInfo1111;

    @FXML
    private Label lblInfo11111;

    @FXML
    void sairTelaSobre(ActionEvent event) {
    	sobreStage.close();
    }

    public void setSobreStage(Stage sobreStage) {
		this.sobreStage = sobreStage;
	}
}
