package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.ContaDAO;
import br.ufrn.imd.exception.TelaExceptionListaPlanoContas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadListarPlanoContasControle {
	
	ContaDAO bdPlanoContas;
	private Stage listaPlanoContasStage;

    @FXML
    private TextArea txaListaPlanoContas;

    @FXML
    private Button btnListarPlanoContas;

    @FXML
    private Button btnSairPlanoContas;

    @FXML
    void listarCadastroPlanoContas(ActionEvent event) throws IOException {
    	bdPlanoContas = ContaDAO.getInstance();
    	if(bdPlanoContas.getPlanoContas().size() != 0) {
    		txaListaPlanoContas.clear();
        	String lista = bdPlanoContas.listarPlanoContas();
        	txaListaPlanoContas.setText(txaListaPlanoContas.getText() + "\n" + lista);
    	}
    	else {
        	try {
        		// Se lista vazia: exibir tela secundária de informação
		    	FXMLLoader loader = new FXMLLoader();
		    	loader.setLocation(TelaExceptionListaPlanoContas.class.getResource("/br/ufrn/imd/visao/TelaExceptionListaPlanoContas.fxml"));
		    	AnchorPane page = (AnchorPane) loader.load();
		    	
		    	Stage mostraInfoStage = new Stage();
		    	mostraInfoStage.setTitle("Mensagem!!!");
		    	mostraInfoStage.setResizable(false);
		    	Scene scene = new Scene(page);
		    	mostraInfoStage.setScene(scene);
		    	
		    	TelaExceptionListaPlanoContas controller = loader.getController();
		    	controller.setMostraInfoStage(mostraInfoStage);
		    	mostraInfoStage.showAndWait();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}        	
    	}
    }

    @FXML
    void sairTelaPlanoContas(ActionEvent event) {
    	listaPlanoContasStage.close();
    }

    public void setListaPlanoContasStage(Stage listaPlanoContasStage) {
		this.listaPlanoContasStage = listaPlanoContasStage;
	}
}
