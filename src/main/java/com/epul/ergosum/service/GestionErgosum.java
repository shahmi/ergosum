package com.epul.ergosum.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;









import com.epul.ergosum.persistance.DialogueBd;
import com.epul.ergosum.meserrreurs.MonException;
import com.epul.ergosum.metier.Catalogue;
import com.epul.ergosum.metier.Categorie;
import com.epul.ergosum.metier.Comporte;
import com.epul.ergosum.metier.ComporteId;
import com.epul.ergosum.metier.Dictionnaire;
import com.epul.ergosum.metier.Jouet;
import com.epul.ergosum.metier.QuantiteCategorie;
import com.epul.ergosum.metier.Trancheage;

public class GestionErgosum {

	public Jouet rechercherJouet(String id) throws MonException{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Jouet> listerTousLesJouets(int categorieCode, int trancheCode) throws MonException{
		List<Object> rs;
		List<Jouet> allCat = new ArrayList<Jouet>();
		int index = 0;
		try {
			String mysql = "SELECT * FROM `jouet` WHERE `CODECATEG`="+categorieCode+" AND `CODETRANCHE`="+trancheCode+"";
			rs = DialogueBd.lecture(mysql);
			
			while (index < rs.size()) {
				// On crée un stage
				Jouet jouet = new Jouet();
				// il faut redecouper la liste pour retrouver les lignes
				jouet.setNumero(rs.get(index + 0).toString());

				// On incrémente tous les 2 champs
				index = index + 2;
				allCat.add(jouet);
			}

			return allCat;
			
		} catch (MonException e) {
			throw e;
		}
		
	}

	public List<Categorie> listerToutesLesCategories() throws MonException{
		List<Object> rs;
		List<Categorie> allCat = new ArrayList<Categorie>();
		int index = 0;
		try {
			String mysql = "SELECT * FROM `categorie`";
			rs = DialogueBd.lecture(mysql);
			
			while (index < rs.size()) {
				// On crée un stage
				Categorie cat = new Categorie();
				// il faut redecouper la liste pour retrouver les lignes
				cat.setCodecateg(rs.get(index + 0).toString());
				cat.setLibcateg(rs.get(index + 1).toString());
				// On incrémente tous les 2 champs
				index = index + 2;
				allCat.add(cat);
			}

			return allCat;
			
		} catch (MonException e) {
			throw e;
		}
	}

	public List<Comporte> listerTousLesCatalogues(String anneeDebut, String anneeF) throws MonException{
		List<Object> rs;
		List<Comporte> allCat = new ArrayList<Comporte>();
		int index = 0;
		try {
			String mysql = "SELECT * FROM `comporte` JOIN `catalogue` ON `comporte`.`ANNEE`=`catalogue`.`ANNEE` JOIN `jouet`ON `comporte`.`NUMERO` = `jouet`.`NUMERO` WHERE `comporte`.`ANNEE`>="+anneeDebut+" AND `comporte`.`ANNEE`<"+anneeF+"";
			rs = DialogueBd.lecture(mysql);
			
			while (index < rs.size()) {
				Comporte comp = new Comporte();
				ComporteId compID = new ComporteId();
				Catalogue cat = new Catalogue();
				Jouet jouet = new Jouet();
				compID.setAnnee(Integer.parseInt(rs.get(index + 0).toString()));				
				jouet.setNumero(rs.get(index + 1).toString());
				jouet.setLibelle(rs.get(index + 8).toString());
				cat.setQuantiteDistribuee(Integer.parseInt(rs.get(index + 4).toString()));
				comp.setId(compID);
				comp.setJouet(jouet);
				comp.setQuantite(Integer.parseInt(rs.get(index + 2).toString()));
				comp.setCatalogue(cat);
				index = index + 9;
				allCat.add(comp);
			}

			return allCat;
			
		} catch (MonException e) {
			throw e;
		}
	}
	
	public List<Catalogue> listerToutesLesAnnees() throws MonException{
		List<Object> rs;
		List<Catalogue> allAnnee = new ArrayList<Catalogue>();
		int index = 0;
		try {
			String mysql = "SELECT * FROM `catalogue`";
			rs = DialogueBd.lecture(mysql);
			
			while (index < rs.size()) {
				Catalogue cata = new Catalogue();
				cata.setAnnee(Integer.parseInt(rs.get(index + 0).toString()));
				index = index + 2;
				allAnnee.add(cata);
			}

			return allAnnee;
			
		} catch (MonException e) {
			throw e;
		}
	}
	
	public List<Trancheage> listerToutesLesTranches() throws MonException{
		List<Object> rs;
		List<Trancheage> allTranche = new ArrayList<Trancheage>();
		int index = 0;
		try {
			String mysql = "SELECT * FROM `trancheage`";
			rs = DialogueBd.lecture(mysql);
			
			while (index < rs.size()) {
				Trancheage tranche = new Trancheage();
				tranche.setCodetranche(rs.get(index + 0).toString());
				tranche.setAgemin(Integer.parseInt(rs.get(index + 1).toString()));
				tranche.setAgemax(Integer.parseInt(rs.get(index + 2).toString()));
				index = index + 3;
				allTranche.add(tranche);
			}

			return allTranche;
			
		} catch (MonException e) {
			throw e;
		}
	}

	public Categorie rechercherCategorie(String parameter) throws MonException{
		// TODO Auto-generated method stub
		return null;
	}

	public Trancheage rechercherTrancheage(String parameter) throws MonException{
		// TODO Auto-generated method stub
		return null;
	}

	public void modifier(Jouet unJouet) throws MonException{
		try {
			String mysql = "";
			mysql = "UPDATE `ergosum`.`jouet` SET ";
			mysql = mysql + " `CODECATEG` = \'"
					+ unJouet.getCategorie().getCodecateg() + "\', `CODETRANCHE` = ";
			mysql = mysql + "\'" + unJouet.getTrancheage().getCodetranche()
					+ "\', `LIBELLE` = " + "\'" + unJouet.getLibelle() + "\',";
			mysql = mysql + "`CODECATEG` = \'"
					+ unJouet.getCategorie().getCodecateg() + "\' WHERE `jouet`.`NUMERO` =" + "\'" + unJouet.getNumero()+ "\'";
			DialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		
	}

	public void modifierComporte(Comporte comp) throws MonException{
		try {
			String mysql = "";
			mysql = "UPDATE `ergosum`.`comporte` SET ";
			mysql = mysql + "  `QUANTITE` = ";
			mysql = mysql + "\'" + comp.getQuantite() +"\' WHERE `comporte`.`NUMERO` =" + "\'" + comp.getJouet().getNumero()+ "\'";
			DialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		
	}
	
	public Catalogue rechercherCatalogue(String parameter) throws MonException{
		// TODO Auto-generated method stub
		return null;
	}

	public void modifierCatalogue(Catalogue leCatalogue) throws MonException{
		// TODO Auto-generated method stub
		
	}

	public void ajouter(Jouet unJouet) throws MonException{
		try {
			String mysql = "";

			mysql = "INSERT INTO `ergosum`.`jouet` (`NUMERO`, `CODECATEG`, `CODETRANCHE`, `LIBELLE`) VALUES (";
			mysql = mysql + "\'" + unJouet.getNumero() + "\', \'"
					+ unJouet.getCategorie().getCodecateg() + "\', ";
			mysql = mysql + "\'" + unJouet.getTrancheage().getCodetranche()
					+ "\', " + "\'" + unJouet.getLibelle() + "\')";
			DialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		
	}
	public void ajouterComporte(Comporte comporte) throws MonException{
		try {
			String mysql = "";
			mysql = "INSERT INTO `ergosum`.`comporte` (`ANNEE`, `NUMERO`, `QUANTITE`) VALUES (";
			mysql = mysql + "\'" + comporte.getCatalogue().getAnnee() + "\', \'"
					+ comporte.getJouet().getNumero() + "\', ";
			mysql = mysql + "\'" + comporte.getQuantite()+ "\')";
			DialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		
	}

	public List<Jouet> listerTousLesJouets() throws MonException{
		List<Object> rs;
		
		int index = 0;
		try {
			String mysql = "SELECT * FROM `jouet` JOIN `categorie` ON `jouet`.`CODECATEG`= `categorie`.`CODECATEG` JOIN `trancheage`ON `jouet`.`CODETRANCHE` = `trancheage`. `CODETRANCHE` GROUP BY `jouet`.`NUMERO`";
			rs = DialogueBd.lecture(mysql);
			List<Jouet> allJ = new ArrayList<Jouet>();
			while (index < rs.size()) {
				// On crée un stage
				Jouet jouet = new Jouet();
				Categorie cat = new Categorie();
				Trancheage trancheage = new Trancheage();
				
				// il faut redecouper la liste pour retrouver les lignes
				jouet.setNumero(rs.get(index + 0).toString());
				cat.setCodecateg(rs.get(index + 1).toString());
				trancheage.setCodetranche(rs.get(index + 2).toString());
				jouet.setLibelle(rs.get(index + 3).toString());
				cat.setLibcateg(rs.get(index + 5).toString());
				trancheage.setAgemin(Integer.parseInt(rs.get(index + 7).toString()));
				trancheage.setAgemax(Integer.parseInt(rs.get(index + 8).toString()));
				jouet.setCategorie(cat);
				jouet.setTrancheage(trancheage);
				
				// On incrémente tous les 2 champs
				index = index + 9;
				allJ.add(jouet);
			}
			return allJ;
			
		} catch (MonException e) {
			throw e;
		}
	}
	 

	public void effacer(String id) throws MonException{
		try {
			String mysql = "";
			mysql = "DELETE FROM `ergosum`.`jouet` WHERE `jouet`.`NUMERO` = \'"+id+"\'";
			DialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		
	}
	public void effacerComporte(String id) throws MonException{
		try {
			String mysql = "";
			mysql = "DELETE FROM `ergosum`.`comporte` WHERE `comporte`.`NUMERO` = \'"+id+"\'";
			DialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
		
	}

	public Object listerCatalogueQuantites(int parseInt, int parseInt2) throws MonException{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dictionnaire> rechercherDictionnaire() throws MonException{
		List<Object> rs;
		List<Catalogue> annee = this.listerToutesLesAnnees();
		List<Dictionnaire> dictionnaire= new ArrayList<Dictionnaire>();
		for (Catalogue a : annee) {
			Dictionnaire unDico = new Dictionnaire();
			String mysql = "SELECT `categorie`.`LIBCATEG`, SUM(`comporte`.`QUANTITE`) as nbcat FROM `comporte` JOIN `jouet` ON `comporte`.`NUMERO`= `jouet`.`NUMERO` JOIN `categorie` ON `jouet`.`CODECATEG`=`categorie`.`CODECATEG` WHERE `ANNEE`='"+a.getAnnee()+"' GROUP BY `categorie`.`LIBCATEG`";
			rs = DialogueBd.lecture(mysql);
			int index = 0;
			while (index < rs.size()) {
				QuantiteCategorie qc = new QuantiteCategorie();
				Categorie cat = new Categorie();
				unDico.setAnnee(a.getAnnee());
				cat.setLibcateg(rs.get(index + 0).toString());
				qc.setCat(cat);
				qc.setNbJouet(Integer.parseInt(rs.get(index + 1).toString()));
				unDico.addCat(qc);
				
				index = index + 2;
			}
			dictionnaire.add(unDico);
		}
		return dictionnaire;
	}

	public Jouet getJouet(String id) throws MonException {
		List<Object> rs;
		Jouet jouet = new Jouet();
		int index = 0;
		try {
			String mysql = "SELECT * FROM `jouet` WHERE `NUMERO`="+id+"";
			rs = DialogueBd.lecture(mysql);
			
			while (index < rs.size()) {
				// On crée un stage
				// il faut redecouper la liste pour retrouver les lignes
				Categorie categorie = new Categorie();
				Trancheage trancheage = new Trancheage();
				categorie.setCodecateg(rs.get(index + 1).toString());
				trancheage.setCodetranche(rs.get(index + 2).toString());
				jouet.setNumero(rs.get(index + 0).toString());
				jouet.setCategorie(categorie);
				jouet.setLibelle(rs.get(index + 3).toString());
				jouet.setTrancheage(trancheage);

				// On incrémente tous les 2 champs
				index = index + 4;
			}

			return jouet;
			
		} catch (MonException e) {
			throw e;
		}
	} 
	
	public Comporte getqAndY(String id) throws MonException {
		List<Object> rs;
		Comporte comp = new Comporte();
		int index = 0;
		try {
			String mysql = "SELECT * FROM `comporte` WHERE `NUMERO`="+id+"";
			rs = DialogueBd.lecture(mysql);
			
			while (index < rs.size()) {
				// On crée un stage
				// il faut redecouper la liste pour retrouver les lignes
				Catalogue cat = new Catalogue();
				Jouet jouet = new Jouet();
				cat.setAnnee(Integer.parseInt(rs.get(index + 0).toString()));
				jouet.setNumero(rs.get(index + 1).toString());
				comp.setQuantite(Integer.parseInt(rs.get(index + 2).toString()));
				comp.setJouet(jouet);
				comp.setCatalogue(cat);

				// On incrémente tous les 2 champs
				index = index + 3;
			}

			return comp;
			
		} catch (MonException e) {
			throw e;
		}
	} 

}
