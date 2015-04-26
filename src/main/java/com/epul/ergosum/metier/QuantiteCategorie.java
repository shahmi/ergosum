package com.epul.ergosum.metier;

public class QuantiteCategorie implements java.io.Serializable {

	private int nbJouet;
	private Categorie cat;
	
	public QuantiteCategorie(){
		
	}

	public int getNbJouet() {
		return nbJouet;
	}

	public void setNbJouet(int nbJouet) {
		this.nbJouet = nbJouet;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	
}
