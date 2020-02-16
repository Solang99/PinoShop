package Entita;

import java.awt.Image;


public class Articolo {
		private String nome;
		private String id;
		private String produttore;
		private String taglia;
		private String colore;
		private String collezione;
		private int quantita;
		private float prezzo;
		private String genere;
		private Image foto;
		private String categoria;
		
		public Articolo() {
			
		}
		
		
		//OverLoad
		public Articolo(String nome,String id, String produttore,String taglia,String colore, String collezione, int quantita,float prezzo,String genere,Image foto,String categoria) {
			setNome(nome);
			setId(id);
			setProduttore(produttore);
			setTaglia(taglia);
			setColore(colore);
			setCollezione(collezione);
			setQuantita(quantita);			
			setPrezzo(prezzo);
			setGenere(genere);
			setFoto(foto);
			setCategoria(categoria);
		}
		
		@Override
		public String toString() {
			return "Articolo"  + id ;
		}


		
		
		public String getCategoria() {
			return categoria;
		}


		public void setCategoria(String categoria) {
			this.categoria = categoria;
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
		public float getPrezzo() {
			return prezzo;
		}
		public void setPrezzo(float prezzo) {
			this.prezzo = prezzo;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}
	

		
	

}
