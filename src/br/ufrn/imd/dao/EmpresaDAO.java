package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Empresa;

public class EmpresaDAO {
	
	private ArrayList<Empresa> empresas;
	private static EmpresaDAO bdEmpresa;
	
	public EmpresaDAO() {
		empresas = new ArrayList<Empresa>();
	}

	public static EmpresaDAO getInstance() {
		if(bdEmpresa == null) {
			bdEmpresa = new EmpresaDAO();
		}
		return bdEmpresa;
	}
	
	public void adicionarEmpresa(Empresa e) {
		empresas.add(e);
	}
	
	public String listarEmpresa() {
		String str = "";
		for(Empresa e : empresas) {
			str += "Código: " + e.getIdEmpresa() + "\t\t" + "Nome: " + e.getNomeEmpresa() +
					"\t\t" + "Endereço: " + e.getEnderecoEmpresa() + "\t\t" + "CNPJ nº: "+ e.getCnpjEmpresa() + "\n";
		}
		return str;
	}
	
	public int buscaCodigoEmpresa() {
		int tam = empresas.size();
		return tam;
	}

	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}
}
