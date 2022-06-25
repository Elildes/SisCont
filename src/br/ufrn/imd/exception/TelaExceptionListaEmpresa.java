package br.ufrn.imd.exception;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaExceptionListaEmpresa {
	
	private Stage mostraInfoStage;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnOk;

    @FXML
    void sairTelaInfo(ActionEvent event) {
    	mostraInfoStage.close();
    }
    
    public void setMostraInfoStage(Stage mostraInfoStage) {
    	this.mostraInfoStage = mostraInfoStage;
    }
}
