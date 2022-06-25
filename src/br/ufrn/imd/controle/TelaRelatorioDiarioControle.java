package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.DiarioDAO;
import br.ufrn.imd.exception.TelaExceptionRelatDiarioFaltaData;
import br.ufrn.imd.exception.TelaExceptionRelatDiarioSemLanc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaRelatorioDiarioControle {
	
	private Stage relatorioDiarioStage;
	
	// Lista que armazena o diário
	DiarioDAO bdLivroDiario;

    @FXML
    private TextArea txaRelatorioDiario;

    @FXML
    private Button btnRelatorioDiario;

    @FXML
    private Button btnSairPlanoContas;

    @FXML
    private Label lblDataInicial;

    @FXML
    private DatePicker dtPckDataInicial;

    @FXML
    private Label lblDataFinal;

    @FXML
    private DatePicker dtPckDataFinal;

    @FXML
    void relatorioDiario(ActionEvent event) throws IOException {
    	try {
    		txaRelatorioDiario.clear();
    		
    		bdLivroDiario = DiarioDAO.getInstance();
    		bdLivroDiario.getDiario().clear();

    		String dataInicial = dtPckDataInicial.getValue().toString();
			String dataFinal = dtPckDataFinal.getValue().toString();
			
			// Copiar o conteúdo do livro diário de um período
			String diario = bdLivroDiario.relatorioDiario(dataInicial, dataFinal);
			
			// Setar a caixa de texto
			if(!diario.equals("0")) {
				txaRelatorioDiario.setText(txaRelatorioDiario.getText() + "\n" + diario);
			} else {
				try {
	        		dtPckDataInicial.setValue(null);
	        		dtPckDataFinal.setValue(null); 
	        		// Se nenhum lançamento neste período: exibir tela secundária de informação
			    	FXMLLoader loader = new FXMLLoader();
			    	loader.setLocation(TelaExceptionRelatDiarioSemLanc.class.getResource("/br/ufrn/imd/visao/TelaExceptionRelatDiarioSemLanc.fxml"));
			    	AnchorPane page = (AnchorPane) loader.load();
			    	
			    	Stage mostraInfoStage = new Stage();
			    	mostraInfoStage.setTitle("Mensagem!!!");
			    	mostraInfoStage.setResizable(false);
			    	Scene scene = new Scene(page);
			    	mostraInfoStage.setScene(scene);
			    	
			    	TelaExceptionRelatDiarioSemLanc controller = loader.getController();
			    	controller.setMostraInfoStage(mostraInfoStage);
			    	mostraInfoStage.showAndWait();
	        	} catch (IOException ex) {
	        		ex.printStackTrace();
	        	}
			}
    	} catch (Exception e) {   		
    		try {
        		dtPckDataInicial.setValue(null);
        		dtPckDataFinal.setValue(null); 
        		// Se falta data inicial/final: exibir tela secundária de informação
		    	FXMLLoader loader = new FXMLLoader();
		    	loader.setLocation(TelaExceptionRelatDiarioFaltaData.class.getResource("/br/ufrn/imd/visao/TelaExceptionRelatDiarioFaltaData.fxml"));
		    	AnchorPane page = (AnchorPane) loader.load();
		    	
		    	Stage mostraInfoStage = new Stage();
		    	mostraInfoStage.setTitle("Mensagem!!!");
		    	mostraInfoStage.setResizable(false);
		    	Scene scene = new Scene(page);
		    	mostraInfoStage.setScene(scene);
		    	
		    	TelaExceptionRelatDiarioFaltaData controller = loader.getController();
		    	controller.setMostraInfoStage(mostraInfoStage);
		    	mostraInfoStage.showAndWait();
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
    	}
    }

    @FXML
    void sairTelaRelatorioDiario(ActionEvent event) throws IOException {
    	relatorioDiarioStage.close();
    }
    
    public void setRelatorioDiarioStage(Stage relatorioDiarioStage) throws IOException {
    	this.relatorioDiarioStage = relatorioDiarioStage;
    }
}
