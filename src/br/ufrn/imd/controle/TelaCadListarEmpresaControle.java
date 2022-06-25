package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.EmpresaDAO;
import br.ufrn.imd.exception.TelaExceptionListaEmpresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadListarEmpresaControle {

	EmpresaDAO bdEmpresa;
	private Stage listaEmpresaStage;
	
    @FXML
    private TextArea txaListaEmpresa;

    @FXML
    private Button btnListarEmpresa;

    @FXML
    private Button btnSair;

    @FXML
    void listarCadastroEmpresa(ActionEvent event) throws IOException {
    	bdEmpresa = EmpresaDAO.getInstance();
    	if(bdEmpresa.getEmpresas().size() != 0) {
        	String lista = bdEmpresa.listarEmpresa();
        	txaListaEmpresa.setText(txaListaEmpresa.getText() + "\n" + lista);
    	}
    	else {
        	try {
        		// Se lista vazia: exibir tela secundária de informação
		    	FXMLLoader loader = new FXMLLoader();
		    	loader.setLocation(TelaExceptionListaEmpresa.class.getResource("/br/ufrn/imd/visao/TelaExceptionListaEmpresa.fxml"));
		    	AnchorPane page = (AnchorPane) loader.load();
		    	
		    	Stage mostraInfoStage = new Stage();
		    	mostraInfoStage.setTitle("Mensagem!!!");
		    	mostraInfoStage.setResizable(false);
		    	Scene scene = new Scene(page);
		    	mostraInfoStage.setScene(scene);
		    	
		    	TelaExceptionListaEmpresa controller = loader.getController();
		    	controller.setMostraInfoStage(mostraInfoStage);
		    	mostraInfoStage.showAndWait();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}        	
    	}
    }

    @FXML
    void sairTela(ActionEvent event) {
    	listaEmpresaStage.close();
    }
    
	public void setListaEmpresaStage(Stage listaEmpresaStage) {
		this.listaEmpresaStage = listaEmpresaStage;
	}

}
