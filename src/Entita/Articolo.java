package Entita;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Articolo {
	private String id;
	private String colore;
	private String taglia;
	private int prezzo; 
	private String diposibile;
	private String descrizione;
	private	Image foto;
	private String genere;
	private String indumentiFamminili;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getTaglia() {
		return taglia;
	}
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public String getDiposibile() {
		return diposibile;
	}
	public void setDiposibile(String diposibile) {
		this.diposibile = diposibile;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getIndumentiFamminili() {
		return indumentiFamminili;
	}
	public void setIndumentiFamminili(String indumentiFamminili) {
		this.indumentiFamminili = indumentiFamminili;
	}

	
	
}
