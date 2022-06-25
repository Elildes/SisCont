package br.ufrn.imd.controle;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPrincipalControle {

    @FXML
    private MenuItem mnItemCadastrarEmpresa;

    @FXML
    private MenuItem mnItemCadastrarPlanoContas;
    
    @FXML
    private MenuItem mnItemListarEmpresas;

    @FXML
    private MenuItem mnItemListarPlanoContas;

    @FXML
    private MenuItem mnItemRegistrarLancamentos;

    @FXML
    private MenuItem mnItemListarLancamento;

    @FXML
    private MenuItem mnItemDiario;

    @FXML
    private MenuItem mnItemSobre;

    @FXML
    private Button btnSair;

    @FXML
    void abrirTelaCadastrarEmpresa(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaCadastroEmpresaControle.class.getResource("/br/ufrn/imd/visao/TelaCadastroEmpresa.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage empresaStage = new Stage();
	    	empresaStage.setTitle("Cadastro de Empresas");
	    	empresaStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	empresaStage.setScene(scene);
	    	
	    	TelaCadastroEmpresaControle controller = loader.getController();
	    	controller.setEmpresaStage(empresaStage);
	    	empresaStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void abrirTelaCadastrarPlanoContas(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaCadastroPlanoContasControle.class.getResource("/br/ufrn/imd/visao/TelaCadastroPlanoContas.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage planoContasStage = new Stage();
	    	planoContasStage.setTitle("Cadastro de Plano de Contas");
	    	planoContasStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	planoContasStage.setScene(scene);
	    	
	    	TelaCadastroPlanoContasControle controller = loader.getController();
	    	controller.setPlanoContasStage(planoContasStage);
	    	planoContasStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void abrirTelaDiario(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaRelatorioDiarioControle.class.getResource("/br/ufrn/imd/visao/TelaRelatorioDiario.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage relatorioDiarioStage = new Stage();
	    	relatorioDiarioStage.setTitle("Livro Diário");
	    	relatorioDiarioStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	relatorioDiarioStage.setScene(scene);
	    	
	    	TelaRelatorioDiarioControle controller = loader.getController();
	    	controller.setRelatorioDiarioStage(relatorioDiarioStage);
	    	relatorioDiarioStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void abrirTelaRegistrarLancamentos(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaLancamentoRegistrarControle.class.getResource("/br/ufrn/imd/visao/TelaLancamentoRegistrar.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage registrarLancamentoStage = new Stage();
	    	registrarLancamentoStage.setTitle("Registrar Lançamentos");
	    	registrarLancamentoStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	registrarLancamentoStage.setScene(scene);
	    	
	    	TelaLancamentoRegistrarControle controller = loader.getController();
	    	controller.setRegistrarLancamentoStage(registrarLancamentoStage);
	    	registrarLancamentoStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void listarLancamentos(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaLancamentoRegistrarControle.class.getResource("/br/ufrn/imd/visao/TelaLancamentoListar.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage listaLancamentoStage = new Stage();
	    	listaLancamentoStage.setTitle("Listagem de Lançamentos");
	    	listaLancamentoStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	listaLancamentoStage.setScene(scene);
	    	TelaLancamentoListarControle controller = loader.getController();
	    	controller.setListaLancamentoStage(listaLancamentoStage);
	    	listaLancamentoStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void abrirTelaSobre(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaSobreControle.class.getResource("/br/ufrn/imd/visao/TelaSobre.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage sobreStage = new Stage();
	    	sobreStage.setTitle("Tela Sobre");
	    	sobreStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	sobreStage.setScene(scene);
	    	TelaSobreControle controller = loader.getController();
	    	controller.setSobreStage(sobreStage);
	    	sobreStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void listarEmpresas(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaCadastroEmpresaControle.class.getResource("/br/ufrn/imd/visao/TelaCadListarEmpresa.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage listaEmpresaStage = new Stage();
	    	listaEmpresaStage.setTitle("Listagem de Empresas");
	    	listaEmpresaStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	listaEmpresaStage.setScene(scene);
	    	TelaCadListarEmpresaControle controller = loader.getController();
	    	controller.setListaEmpresaStage(listaEmpresaStage);
	    	listaEmpresaStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void listarPlanoContas(ActionEvent event) throws IOException {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TelaCadastroPlanoContasControle.class.getResource("/br/ufrn/imd/visao/TelaCadListarPlanoContas.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	Stage listaPlanoContasStage = new Stage();
	    	listaPlanoContasStage.setTitle("Listagem de Plano de Contas");
	    	listaPlanoContasStage.setResizable(false);
	    	Scene scene = new Scene(page);
	    	listaPlanoContasStage.setScene(scene);
	    	TelaCadListarPlanoContasControle controller = loader.getController();
	    	controller.setListaPlanoContasStage(listaPlanoContasStage);
	    	listaPlanoContasStage.showAndWait();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void sairSistema(ActionEvent event) throws IOException {
    	System.exit(0);
    }

}

