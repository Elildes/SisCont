package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Conta;

public class ContaDAO {

	private ArrayList<Conta> planoContas;
	private static ContaDAO bdPlanoContas;
	
	public ContaDAO() {
		planoContas = new ArrayList<Conta>();
	}

	public static ContaDAO getInstance() {
		if (bdPlanoContas == null) {
			bdPlanoContas = new ContaDAO();
		}
		return bdPlanoContas;
	}

	public void adicionarConta(Conta c) {
		planoContas.add(c);
	}
	
	public String listarPlanoContas() {
		String str = "Código da Conta" + "\t" + "Nome da Conta\n";
		for(Conta c : planoContas) {
			str += c.getCodigoConta() + "\t\t\t" + c.getNomeConta() + "\n";
		}
		return str;
	}

	public ArrayList<Conta> getPlanoContas() {
		return planoContas;
	}
	
	public String buscaNomeConta(String nomeConta) {
		for(Conta c : planoContas) {
			if(c.getNomeConta().equalsIgnoreCase(nomeConta)) {
				return c.getNomeConta();		
			}
		}
		return "0";		
	}
	
	public String buscaCodigoConta(String nomeConta) {
		for(Conta c : planoContas) {
			if(c.getNomeConta().equalsIgnoreCase(nomeConta)) {
				return c.getCodigoConta();		
			}
		}
		return "0";		
	}
}
