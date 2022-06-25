package br.ufrn.imd.modelo;

public class Lancamento {

	private String codigoLancamento;
	private String dataLancamento;
	private Conta contaDebito;
	private Conta contaCredito;
	private double valorLancamento;
	private String historico;

	public Lancamento(){
		valorLancamento = 0.00;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}
	
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public String getCodigoLancamento() {
		return codigoLancamento;
	}
	
	public void setCodigoLancamento(String codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}
	
	public String getHistorico() {
		return historico;
	}
	
	public void setHistorico(String historico) {
		this.historico = historico;
	}	

	public Conta getContaDebito() {
		return contaDebito;
	}

	public void setContaDebito(Conta contaDebito) {
		this.contaDebito = contaDebito;
	}

	public Conta getContaCredito() {
		return contaCredito;
	}

	public void setContaCredito(Conta contaCredito) {
		this.contaCredito = contaCredito;
	}

	public double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}
}
