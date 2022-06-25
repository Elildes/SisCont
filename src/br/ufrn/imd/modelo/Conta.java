package br.ufrn.imd.modelo;

public class Conta {
	
	private String nomeConta;
	private String codigoConta;
	
    public Conta(){}
    
	public String getNomeConta() {
		return nomeConta;
	}
	
	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}
	
	public String getCodigoConta() {
		return codigoConta;
	}
	
	public void setCodigoConta(String codigoConta) {
		this.codigoConta = codigoConta;
	}
}
