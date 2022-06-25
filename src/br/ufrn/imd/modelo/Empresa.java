package br.ufrn.imd.modelo;

public class Empresa {

	private int idEmpresa;
	private String nomeEmpresa;
	private String enderecoEmpresa;
	private String cnpjEmpresa;
		
    public Empresa(){}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int cod) {
		this.idEmpresa = cod;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
}
