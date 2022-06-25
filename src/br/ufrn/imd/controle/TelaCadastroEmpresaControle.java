package br.ufrn.imd.controle;

import br.ufrn.imd.dao.EmpresaDAO;
import br.ufrn.imd.modelo.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroEmpresaControle {
	
	private Stage empresaStage;
	private boolean btnConfirmarClicked = false;
	
	EmpresaDAO bdEmpresa;

    @FXML
    private Label lblCodigoEmpresa;

    @FXML
    private Label lblNomeEmpresa;

    @FXML
    private Label lblEnderecoEmpresa;

    @FXML
    private Label lblCnpj;

    @FXML
    private TextField tfCodigoEmpresa;

    @FXML
    private TextField tfNomeEmpresa;

    @FXML
    private TextField tfEnderecoEmpresa;

    @FXML
    private TextField tfCnpj;

    @FXML
    private Button btnCadastrarEmpresa;

    @FXML
    private Button btnSairTela;
    
    public boolean isBtnConfirmarClicked() {
		return btnConfirmarClicked;
	}

	public void setBtnConfirmarClicked(boolean btnConfirmarClicked) {
		this.btnConfirmarClicked = btnConfirmarClicked;
	}
	
    @FXML
    void cadastrarEmpresa(ActionEvent event) {
    	
    	btnConfirmarClicked = true;
    	
    	// Salvar se e somente se todos os campos estiverem preenchidos
    	if (btnConfirmarClicked = true && !tfNomeEmpresa.getText().equals("")
    								   && !tfEnderecoEmpresa.getText().equals("")
    								   && !tfCnpj.getText().equals("")) {
    		
    		bdEmpresa = EmpresaDAO.getInstance();
    		
    		int cod = bdEmpresa.buscaCodigoEmpresa();
    		cod++;
    		
    		Empresa e = new Empresa();
    		e.setIdEmpresa(cod);
    		e.setNomeEmpresa(tfNomeEmpresa.getText());
    		e.setEnderecoEmpresa(tfEnderecoEmpresa.getText());
    		e.setCnpjEmpresa(tfCnpj.getText());
    		
    		bdEmpresa.adicionarEmpresa(e);    		
    	}
    	tfNomeEmpresa.clear();
    	tfEnderecoEmpresa.clear();
    	tfCnpj.clear();
    }

    @FXML
    void sairCadastroEmpresa(ActionEvent event) {
    	empresaStage.close();
    }
    
    public void setEmpresaStage(Stage empresaStage) {
		this.empresaStage = empresaStage;
	}
}

