package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.ContaDAO;
import br.ufrn.imd.dao.LancamentoDAO;
import br.ufrn.imd.exception.TelaExceptionLancContaInvalida;
import br.ufrn.imd.exception.TelaExceptionLancFaltaCampo;
import br.ufrn.imd.exception.TelaExceptionLancFaltaDataValor;
import br.ufrn.imd.modelo.Conta;
import br.ufrn.imd.modelo.Lancamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaLancamentoRegistrarControle {

	private Stage registrarLancamentoStage;
	
	// Lista que armazena os lançamentos
	LancamentoDAO bdLancamento;
	ContaDAO bdPlanoContas;	
	
	@FXML
    private TextArea txaHistorico;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnSairTela;

    @FXML
    private Label lblHistorico;

    @FXML
    private DatePicker dtPckDataLancamento;

    @FXML
    private TextField tfNrLancamento;

    @FXML
    private Label lblNrLancamento;

    @FXML
    private Label lblDataLancamento;

    @FXML
    private Label lblContaDebito;

    @FXML
    private Label lblContaCredito;

    @FXML
    private Label lblValorLancamento;

    @FXML
    private TextField tfNomeContaDebito;

    @FXML
    private TextField tfNomeContaCredito;

    @FXML
    private TextField tfValorLancamento;

	@FXML
    void salvarLancamento(ActionEvent event) throws IOException {

		try {
			String data = dtPckDataLancamento.getValue().toString();

	    	// Salvar somente se todos os campos estiverem preenchidos
	    	if (!tfNomeContaDebito.getText().equals("")
	    		&& !tfNomeContaCredito.getText().equals("")
	    		&& !tfValorLancamento.getText().equals("")
	    		&& !txaHistorico.getText().equals("")) {
	
	    		Lancamento l = new Lancamento();

	    		// Testar conta débito
	    		Conta contaDebito = new Conta();
	    		bdPlanoContas = ContaDAO.getInstance();
	    		String strDeb = bdPlanoContas.buscaNomeConta(tfNomeContaDebito.getText());

	    		// Testar conta crédito
	    		Conta contaCredito = new Conta();
	    		String strCred = bdPlanoContas.buscaNomeConta(tfNomeContaCredito.getText());

	    		// Setar se as contas estão cadastradas
	    		if(strDeb != "0" && strCred != "0") {
	    			
		    		// Exibir, setar e incrementar o código a ser usado
		    		tfNrLancamento.setText(LancamentoDAO.getCodigoLancamento());	    		
		    		l.setCodigoLancamento(tfNrLancamento.getText());
		    		LancamentoDAO.setCodigoLancamento();

		    		// Setar data lançamento
		    		l.setDataLancamento(data);

		    		// Setar conta débito	    			
		    		contaDebito.setNomeConta(tfNomeContaDebito.getText());
		    		contaDebito.setCodigoConta(bdPlanoContas.buscaCodigoConta(tfNomeContaDebito.getText()));
		    		l.setContaDebito(contaDebito);
		    		
		    		// Setar conta crédito
	    			contaCredito.setNomeConta(tfNomeContaCredito.getText());
	    			contaCredito.setCodigoConta(bdPlanoContas.buscaCodigoConta(tfNomeContaCredito.getText()));
		    		l.setContaCredito(contaCredito);
		    		
		    		// Setar valor lançamento
		    		//.......... implementar NumberFormatException (se a string não for um double)
		    		l.setValorLancamento(Double.parseDouble(tfValorLancamento.getText()));
		
		    		// Setar histórico
		    		l.setHistorico(txaHistorico.getText());
		
		    		// Persiste os dados do lançamento no banco
		    		bdLancamento = LancamentoDAO.getInstance();    
		    		bdLancamento.adicionarLancamento(l);
		    		
	    		} else {	    			
	    			try {
	            		// Se conta inválida: exibir tela secundária de informação
	    		    	FXMLLoader loader = new FXMLLoader();
	    		    	loader.setLocation(TelaExceptionLancContaInvalida.class.getResource("/br/ufrn/imd/visao/TelaExceptionLancContaInvalida.fxml"));
	    		    	AnchorPane page = (AnchorPane) loader.load();
	    		    	
	    		    	Stage mostraInfoStage = new Stage();
	    		    	mostraInfoStage.setTitle("Mensagem!!!");
	    		    	mostraInfoStage.setResizable(false);
	    		    	Scene scene = new Scene(page);
	    		    	mostraInfoStage.setScene(scene);
	    		    	
	    		    	TelaExceptionLancContaInvalida controller = loader.getController();
	    		    	controller.setMostraInfoStage(mostraInfoStage);
	    		    	mostraInfoStage.showAndWait();
	            	} catch (IOException e) {
	            		e.printStackTrace();
	            	}
	    		}
	        	tfNomeContaDebito.clear();
	        	tfNomeContaCredito.clear();
	        	tfValorLancamento.clear();
	        	txaHistorico.clear();
	    	} else {
	    		try {
            		// Se tem algum campo em branco: exibir tela secundária de informação
    		    	FXMLLoader loader = new FXMLLoader();
    		    	loader.setLocation(TelaExceptionLancFaltaCampo.class.getResource("/br/ufrn/imd/visao/TelaExceptionLancFaltaCampo.fxml"));
    		    	AnchorPane page = (AnchorPane) loader.load();
    		    	
    		    	Stage mostraInfoStage = new Stage();
    		    	mostraInfoStage.setTitle("Mensagem!!!");
    		    	mostraInfoStage.setResizable(false);
    		    	Scene scene = new Scene(page);
    		    	mostraInfoStage.setScene(scene);
    		    	
    		    	TelaExceptionLancFaltaCampo controller = loader.getController();
    		    	controller.setMostraInfoStage(mostraInfoStage);
    		    	mostraInfoStage.showAndWait();
            	} catch (IOException e) {
            		e.printStackTrace();
            	}
	    	}
		} catch (Exception e) {
    		try {
        		// Se data ou valor inválido: exibir tela secundária de informação
		    	FXMLLoader loader = new FXMLLoader();
		    	loader.setLocation(TelaExceptionLancFaltaDataValor.class.getResource("/br/ufrn/imd/visao/TelaExceptionLancFaltaDataValor.fxml"));
		    	AnchorPane page = (AnchorPane) loader.load();
		    	
		    	Stage mostraInfoStage = new Stage();
		    	mostraInfoStage.setTitle("Mensagem!!!");
		    	mostraInfoStage.setResizable(false);
		    	Scene scene = new Scene(page);
		    	mostraInfoStage.setScene(scene);
		    	
		    	TelaExceptionLancFaltaDataValor controller = loader.getController();
		    	controller.setMostraInfoStage(mostraInfoStage);
		    	mostraInfoStage.showAndWait();
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
		}
    }

    @FXML
    void sairTela(ActionEvent event) {
    	registrarLancamentoStage.close();
    }
	
	public void setRegistrarLancamentoStage(Stage registrarLancamentoStage) {
    	this.registrarLancamentoStage = registrarLancamentoStage;
    }
}
