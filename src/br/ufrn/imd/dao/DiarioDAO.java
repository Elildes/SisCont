package br.ufrn.imd.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import br.ufrn.imd.modelo.Diario;
import br.ufrn.imd.modelo.Lancamento;

public class DiarioDAO {

	private ArrayList<Diario> livroDiario;
	private static DiarioDAO bdLivroDiario;
	
	public DiarioDAO() {
		livroDiario = new ArrayList<Diario>();
	}
	
	public static DiarioDAO getInstance() {
		if(bdLivroDiario == null) {
			bdLivroDiario = new DiarioDAO();
		}
		return bdLivroDiario;
	}
	
	public Lancamento buscaLancamento(String data) {
		for(Lancamento lanc : LancamentoDAO.getInstance().getLancamentos()) {
			if(data.equals(lanc.getDataLancamento())) {
				return lanc;
			}
		}
		return null;
	}

	public void adicionarLivroDiario(Diario d) {
		livroDiario.add(d);
	}
	
	public ArrayList<Diario> getDiario() {
		return livroDiario;
	}

	/**
	 * Relatório diário por data
	 * @throws ParseException 
	 */
	public String relatorioDiario(String dataInicial, String dataFinal) throws ParseException {

		LancamentoDAO bdLancamento = LancamentoDAO.getInstance();	// Pegar a lista de lançamentos		
		DiarioDAO bdLivroDiario = DiarioDAO.getInstance();			// Pegar a lista do livro diário

		String str = "";

		int counter = 0;		

		// Setar o array do diário
		for(Lancamento lanc : bdLancamento.getLancamentos()) {
			// Comparar datas
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
			Date dateBegin = formato.parse(dataInicial);
			Date dateEnd = formato.parse(dataFinal);
			Date dateLanc = formato.parse(lanc.getDataLancamento());
			
			if(dateLanc.equals(dateBegin) ||
			   dateLanc.equals(dateEnd) ||
			   dateLanc.after(dateBegin) && dateLanc.before(dateEnd)) {

				// Copiar lançamento para o diário
				Diario diario = new Diario();
				diario.setDataLancamento(lanc.getDataLancamento());
				diario.setCodigoLancamento(lanc.getCodigoLancamento());
				diario.setContaDebito(lanc.getContaDebito());
				diario.setContaCredito(lanc.getContaCredito());
				diario.setHistorico(lanc.getHistorico());
				diario.setValorLancamento(lanc.getValorLancamento());

				bdLivroDiario.adicionarLivroDiario(diario);

				 str += "Data: " + diario.getDataLancamento() + "\t" +
						"Conta Débito: " + diario.getContaDebito().getCodigoConta() + "-" + diario.getContaDebito().getNomeConta() + "\t\t" +
						"Histórico: " + diario.getHistorico() + "\t\t" +
						"Valor Débito (R$) " + diario.getValorLancamento() + "\t\t" +
						"Valor Crédito (R$) 0,00" + "\n" +

						"Data: " + diario.getDataLancamento() + "\t" +
						"Conta Crédito: " + diario.getContaCredito().getCodigoConta() + "-" + diario.getContaCredito().getNomeConta() + "\t\t" +
						"Histórico: " + diario.getHistorico() + "\t\t" +
						"Valor Dédito (R$) 0,00" + "\t\t" +
						"Valor Crédito (R$) " + diario.getValorLancamento() + "\n\n";
				 counter++;				 
		    }
		}
		if(counter != 0) {
			return str;			
		} else {
			return "0";
		}
	}
}
