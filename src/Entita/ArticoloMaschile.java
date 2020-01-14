package Entita;

import java.awt.Image;

public class ArticoloMaschile {
	private String id;
	private String produttore;
	private String taglia;
	private String colore;
	private String stagione;
	private String collezione;
	private int quantita;
	private int prezzo;
	private Image foto ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduttore() {
		return produttore;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	public String getTaglia() {
		return taglia;
	}
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getStagione() {
		return stagione;
	}
	public void setStagione(String stagione) {
		this.stagione = stagione;
	}
	public String getCollezione() {
		return collezione;
	}
	public void setCollezione(String collezione) {
		this.collezione = collezione;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}
	
	
}
