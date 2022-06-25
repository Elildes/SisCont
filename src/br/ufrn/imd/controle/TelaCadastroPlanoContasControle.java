package br.ufrn.imd.controle;

import br.ufrn.imd.dao.ContaDAO;
import br.ufrn.imd.modelo.Conta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroPlanoContasControle {
	
	private Stage planoContasStage;
	private boolean btnConfirmarClicked = false;

	ContaDAO bdPlanoContas;	

    @FXML
    private Label lblNomeConta;

    @FXML
    private Label lblCodigoConta;

    @FXML
    private TextField tfNomeConta;

    @FXML
    private TextField tfCodigoConta;

    @FXML
    private Button btnCadastrarConta;

    @FXML
    private Button btnSairTela;
    
    public boolean isBtnConfirmarClicked() {
		return btnConfirmarClicked;
	}

	public void setBtnConfirmarClicked(boolean btnConfirmarClicked) {
		this.btnConfirmarClicked = btnConfirmarClicked;
	}

    @FXML
    void cadastrarConta(ActionEvent event) {

    	btnConfirmarClicked = true;

    	// Salva se e somente se todos os campos estiverem preenchidos
    	if (btnConfirmarClicked = true && !tfCodigoConta.getText().equals("")
    								   && !tfNomeConta.getText().equals("")){

    		bdPlanoContas = ContaDAO.getInstance();    
    		
    		Conta c = new Conta();
    		c.setCodigoConta(tfCodigoConta.getText());
    		c.setNomeConta(tfNomeConta.getText());

    		bdPlanoContas.adicionarConta(c);
    	}    	
    	tfCodigoConta.clear();
    	tfNomeConta.clear();   
    }

    @FXML
    void sairTela(ActionEvent event) {
    	planoContasStage.close();
    }
    
    public void setPlanoContasStage(Stage planoContasStage) {
		this.planoContasStage = planoContasStage;
	}
}
