package Entita;

import java.util.ArrayList;


public class Magazzino {
	private ArrayList<Articolo> articolo ;
	private String reparto;
	private int capacita;
	
	
	public Magazzino() {

		articolo = new ArrayList<Articolo>();
	}
	
	public ArrayList<Articolo> getArticolo() {

		return articolo;
	}
	public void setArticolo(ArrayList<Articolo> articolo) {
		
		this.articolo = articolo;
	}
	public String getReparti() {
		return reparto;
	}
	public void setReparti(String reparti) {
		this.reparto = reparti;
	}
	public int getCapacita() {
		return capacita;
	}
	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}
	
}
