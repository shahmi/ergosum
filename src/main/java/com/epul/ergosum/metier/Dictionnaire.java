package com.epul.ergosum.metier;

import java.util.ArrayList;
import java.util.List;

public class Dictionnaire implements java.io.Serializable {
	private int annee;
	private List<QuantiteCategorie> cat = new ArrayList<QuantiteCategorie>();
	
	public Dictionnaire(){
		
	}
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public List<QuantiteCategorie> getCat() {
		return cat;
	}
	public void setCat(List<QuantiteCategorie> cat) {
		this.cat = cat;
	}
	
	public void addCat(QuantiteCategorie cat){
		this.cat.add(cat);
	}
	
}
