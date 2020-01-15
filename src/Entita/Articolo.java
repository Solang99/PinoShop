package Entita;

import java.awt.Image;
import java.io.File;

public class Articolo {
		private String id;
		private String produttore;
		private String taglia;
		private String colore;
		private String collezione;
		private int quantita;
		private int prezzo;
		private String genere;
		private File foto;
		
		
		
		public File getFoto() {
			return foto;
		}
		public void setFoto(File foto) {
			this.foto = foto;
		}
		public String getGenere() {
			return genere;
		}
		public void setGenere(String genere) {
			this.genere = genere;
		}
		
		
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
	

		
	

}
