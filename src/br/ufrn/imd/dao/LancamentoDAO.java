package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Lancamento;

public class LancamentoDAO {

	private ArrayList<Lancamento> lancamentos;
	private static LancamentoDAO bdLancamento;
	private static String idLancamento = "1000";
	
	public LancamentoDAO() {
		lancamentos = new ArrayList<Lancamento>();
	}
	
	public static LancamentoDAO getInstance() {
		if(bdLancamento == null) {
			bdLancamento = new LancamentoDAO();
		}
		return bdLancamento;
	}
	
	public void adicionarLancamento(Lancamento l) {
		lancamentos.add(l);
	}

	/**
	 * Listar lançamentos por data
	 */
	public String listarLancamento(String data) {
		String str = "";
		int counter = 0;
		for(Lancamento lanc : lancamentos) {
			if(data.equals(lanc.getDataLancamento())) {
				 str += "Data: " + lanc.getDataLancamento() + "\t" +
						"Código: " + lanc.getCodigoLancamento() + "\t" +
						"Conta Débito: " + lanc.getContaDebito().getCodigoConta() + "-" + lanc.getContaDebito().getNomeConta() + "\t\t" +
						"Conta Crédito: " + lanc.getContaCredito().getCodigoConta() + "-" + lanc.getContaCredito().getNomeConta() + "\t\t" +
						"Valor (R$) " + lanc.getValorLancamento() + "\t\t" +
						"Histórico: " + lanc.getHistorico() + "\n";
				 counter++;
		    }
		}
		if(counter != 0) {
			return str;			
		} else {
			return "0";
		}
	}
	
	// Retorna o código atual
	public static final String getCodigoLancamento() {
		return idLancamento;
	}
	
	// Incrementa o próximo código
	public static final void setCodigoLancamento() {
        int num = Integer.parseInt(idLancamento);
		num++;
		idLancamento = Integer.toString(num);
	}
	
	public ArrayList<Lancamento> getLancamentos() {
		return lancamentos;
	}
}
