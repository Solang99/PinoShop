package Entita;

import java.util.ArrayList;

public class Cassa {
	private String pagamentoType;
	private int resto;
	private int pagamentoDovuto;
	private int pagamentoVersato;
	private ArrayList<Articolo> carrello;
	
	public ArrayList<Articolo> getArticolo() {

		return carrello;
	}
	public void setArticolo(ArrayList<Articolo> articolo) {
		
		this.carrello = articolo;
	}
	
	public String getPagamentoType() {
		return pagamentoType;
	}
	public void setPagamentoType(String pagamentoType) {
		this.pagamentoType = pagamentoType;
	}
	public int getResto() {
		return resto;
	}
	public void setResto(int resto) {
		this.resto = resto;
	}
	public int getPagamentoDovuto() {
		
		return pagamentoDovuto;
	}
	public void setPagamentoDovuto(int pagamentoDovuto) {
		for (Articolo a : carrello) {
			pagamentoDovuto +=( a.getPrezzo() * a.getQuantita());
		}
		this.pagamentoDovuto = pagamentoDovuto;
	}
	public int getPagamentoVersato() {
		return pagamentoVersato;
	}
	public void setPagamentoVersato(int pagamentoVersato) {
		
		this.pagamentoVersato = pagamentoVersato;
	}
}
 