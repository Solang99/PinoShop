package Entita;

import java.util.ArrayList;

public class Cassa {
	private int numeroOrdine;
	private String pagamentoType;
	private float resto;
	private float pagamentoDovuto;
	private float pagamentoVersato;
	private String usernameCommesso;


	
	
	public String getUsernameCommesso() {
		return usernameCommesso;
	}

	public void setUsernameCommesso(String usernameCommesso) {
		this.usernameCommesso = usernameCommesso;
	}

	public int getNumeroOrdine() {
		return numeroOrdine;
	}
	
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;		
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
		
		this.pagamentoDovuto = pagamentoDovuto;
	}
	public float getPagamentoVersato() {
		return pagamentoVersato;
	}
	public void setPagamentoVersato(float pagamentoVersato) {
		
		this.pagamentoVersato = pagamentoVersato;
	}
}
 