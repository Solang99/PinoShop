package Entita;

import java.awt.Image;
import java.util.ArrayList;

import Database.MagazzinoDAO;

public class Magazzino {
	private ArrayList<Articolo> articolo ;
	private String reparti;
	private int capacita;
	private MagazzinoDAO magazzino;
	
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
		return reparti;
	}
	public void setReparti(String reparti) {
		this.reparti = reparti;
	}
	public int getCapacita() {
		return capacita;
	}
	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}
	
}
