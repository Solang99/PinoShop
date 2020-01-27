package Entita;

import java.util.ArrayList;

public class Cassa {
	private String pagamentoType;
	private float resto;
	private float pagamentoDovuto;
	private float pagamentoVersato;
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
	public float getResto() {
		return resto;
	}
	public void setResto(float resto) {
		this.resto = resto;
	}
	public float getPagamentoDovuto() {
		
		return pagamentoDovuto;
	}
	public void setPagamentoDovuto(float pagamentoDovuto) {
		for (Articolo a : carrello) {
			pagamentoDovuto +=( a.getPrezzo() * a.getQuantita());
		}
		this.pagamentoDovuto = pagamentoDovuto;
	}
	public float getPagamentoVersato() {
		return pagamentoVersato;
	}
	public void setPagamentoVersato(float pagamentoVersato) {
		
		this.pagamentoVersato = pagamentoVersato;
	}
}
 