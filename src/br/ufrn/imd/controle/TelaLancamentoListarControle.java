package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.LancamentoDAO;
import br.ufrn.imd.exception.TelaExceptionListaLancFaltaData;
import br.ufrn.imd.exception.TelaExceptionListaLancSemLanc;
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

public class TelaLancamentoListarControle {
	
	private Stage listaLancamentoStage;

	// Lista que armazena os lançamentos
	LancamentoDAO bdLancamento;

    @FXML
    private TextArea txaListaLancamentos;

    @FXML
    private Button btnListarLancamentos;

    @FXML
    private Button btnSairPlanoContas;

    @FXML
    private Label lblDataLancamento;

    @FXML
    private DatePicker dtPckDataLancamento;

    @FXML
    void listarLancamentos(ActionEvent event) throws IOException {
		
    	try {
    		txaListaLancamentos.clear();
    		bdLancamento = LancamentoDAO.getInstance();

			String data = dtPckDataLancamento.getValue().toString();

			String lista = bdLancamento.listarLancamento(data);

			// Setar a caixa de texto
			if(!lista.equals("0")) {
				txaListaLancamentos.setText(txaListaLancamentos.getText() + "\n" + lista);
			} else {
				try {
	        		// Sem lançamento nesta data: exibir tela secundária de informação
			    	FXMLLoader loader = new FXMLLoader();
			    	loader.setLocation(TelaExceptionListaLancSemLanc.class.getResource("/br/ufrn/imd/visao/TelaExceptionListaLancSemLanc.fxml"));
			    	AnchorPane page = (AnchorPane) loader.load();
			    	
			    	Stage mostraInfoStage = new Stage();
			    	mostraInfoStage.setTitle("Mensagem!!!");
			    	mostraInfoStage.setResizable(false);
			    	Scene scene = new Scene(page);
			    	mostraInfoStage.setScene(scene);
			    	
			    	TelaExceptionListaLancSemLanc controller = loader.getController();
			    	controller.setMostraInfoStage(mostraInfoStage);
			    	mostraInfoStage.showAndWait();
	        	} catch (IOException ex) {
	        		ex.printStackTrace();
	        	}
			}
		} catch (Exception e) {
			try {
        		// Se falta data: exibir tela secundária de informação
		    	FXMLLoader loader = new FXMLLoader();
		    	loader.setLocation(TelaExceptionListaLancFaltaData.class.getResource("/br/ufrn/imd/visao/TelaExceptionListaLancFaltaData.fxml"));
		    	AnchorPane page = (AnchorPane) loader.load();
		    	
		    	Stage mostraInfoStage = new Stage();
		    	mostraInfoStage.setTitle("Mensagem!!!");
		    	mostraInfoStage.setResizable(false);
		    	Scene scene = new Scene(page);
		    	mostraInfoStage.setScene(scene);
		    	
		    	TelaExceptionListaLancFaltaData controller = loader.getController();
		    	controller.setMostraInfoStage(mostraInfoStage);
		    	mostraInfoStage.showAndWait();
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
		}
    }

    @FXML
    void sairTelaListarLancamentos(ActionEvent event) throws IOException {
    	listaLancamentoStage.close();
    }
    
    public void setListaLancamentoStage(Stage listarLancamentoStage) throws IOException {
    	this.listaLancamentoStage = listarLancamentoStage;
    }

}
