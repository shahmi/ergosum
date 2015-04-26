package com.epul.ergosum.controle;

import com.epul.ergosum.meserrreurs.*;
import com.epul.ergosum.metier.*;
import com.epul.ergosum.service.GestionErgosum;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;







import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MultiController extends MultiActionController {

	private static final Logger logger = LoggerFactory
			.getLogger(MultiController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private Jouet unJouet;

	@RequestMapping(value = "home.htm", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "/home";
	}
	
	@RequestMapping(value = "accueil.htm")

public ModelAndView accueil(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String destinationPage = "/index";
		
		return new ModelAndView(destinationPage);
	}
	
	@RequestMapping(value = "")

	public ModelAndView ifNull(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String destinationPage = "/index";
		
		return new ModelAndView(destinationPage);
	}

	/**
	 * Affichage de tous les jouets
	 */
	@RequestMapping(value = "afficherJouets.htm")

public ModelAndView afficherLesJouets(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Jouet> listJ = null;
		String destinationPage = "";
		try
		{
			GestionErgosum unService = new GestionErgosum();
			if (unService != null) {
				int categorieCode;
				int trancheCode;
				String categorie = request.getParameter("codecateg");
				String tranche = request.getParameter("codetranche");
				if(categorie == null && tranche == null) {
					categorieCode = 0;
					trancheCode = 0;
				} else {
					categorieCode = Integer.parseInt(categorie);
					trancheCode = Integer.parseInt(tranche);
				}
				listJ = unService.listerTousLesJouets();
				request.setAttribute("mesJouets", listJ);
			}
		}

		 catch (MonException e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		destinationPage = "/listeJouets";
		
		return new ModelAndView(destinationPage);
	}
	
	

	/**
	 * Formulaire d'ajout d'un jouet
	 */
	@RequestMapping(value = "formJouet.htm")

public ModelAndView formAjoutJouet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String destinationPage = "";

		try
		{
			GestionErgosum unService = new GestionErgosum();
			
			if (unService != null)
			{
				request.setAttribute("categories", unService.listerToutesLesCategories());
				request.setAttribute("tranches", unService.listerToutesLesTranches());
				request.setAttribute("annees", unService.listerToutesLesAnnees());
				
		         destinationPage = "/formJouet";
			}
		}  catch (MonException e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		
		return new ModelAndView(destinationPage);
	} 
	
	/**
	 * ajout d'un jouet
	 */
	@RequestMapping(value = "ajoutJouet.htm")

public ModelAndView ajoutJouet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String destinationPage = "";

		try
		{
			GestionErgosum unService = new GestionErgosum();
			
			if (unService != null)
			{
				Jouet jouet = new Jouet();
				Categorie categorie = new Categorie();
				Trancheage tranche = new Trancheage();
				Catalogue cata = new Catalogue();
				Comporte comporte = new Comporte();
				ComporteId comporteId = new ComporteId();
				categorie.setCodecateg(request.getParameter("categorie"));
				tranche.setCodetranche(request.getParameter("tranche"));
				jouet.setNumero(request.getParameter("id"));
				jouet.setLibelle(request.getParameter("libelle"));
				jouet.setCategorie(categorie);
				jouet.setTrancheage(tranche);
				cata.setAnnee(Integer.parseInt(request.getParameter("annee")));
				comporteId.setAnnee(Integer.parseInt(request.getParameter("annee")));
				comporteId.setNumero(request.getParameter("id"));
				comporte.setCatalogue(cata);
				comporte.setId(comporteId);
				comporte.setJouet(jouet);
				comporte.setQuantite(Integer.parseInt(request.getParameter("quantite")));
				
				unService.ajouter(jouet);
				unService.ajouterComporte(comporte);
				
		        destinationPage = "/index";
			}
		}  catch (MonException e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		
		return new ModelAndView(destinationPage);
	} 
	
	
	/**
	 * Sélection d'une année par catégorie
	 */
	@RequestMapping(value = "selectionnerAnnee.htm")

public ModelAndView selectionAnnee(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String destinationPage = "";
		destinationPage = "/selectionAnneeCat";
		return new ModelAndView(destinationPage);	
	}
	
	/**
	 * Sélection d'une année Ctagoriet
	 */
	@RequestMapping(value = "choixCatalogue.htm")

public ModelAndView choixCatalogue(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String destinationPage = "/choixCatalogue";	
		
		
		return new ModelAndView(destinationPage);	
	}
	
	
	/**
	 *  afficher Catalogue
	 */	
	@RequestMapping(value = "afficherCatalogues.htm")
	public ModelAndView afficherCatalogue(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "/Erreur";
		List<Comporte> listC = null;
		try
		{
			GestionErgosum unService = new GestionErgosum();
			
			if (unService != null){
				String anneeDepart = request.getParameter("anneeDepart");
				String nbAnnee = request.getParameter("nbAnnee").toString();
				int anneeFin = Integer.parseInt(anneeDepart) + Integer.parseInt(nbAnnee);
				String anneeF = Integer.toString(anneeFin);
				request.setAttribute("anneeDepart", anneeDepart);
				request.setAttribute("anneeFin", anneeF);
				listC = unService.listerTousLesCatalogues(anneeDepart,anneeF);
				request.setAttribute("MesCatalogues", listC);
			    destinationPage = "/listeCatalogues";
			}
		}  catch (MonException e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		
		
		return new ModelAndView(destinationPage);
	}
	
	/**
	 * Formulaire d'ajout d'un jouet
	 */
	@RequestMapping(value = "formModifJouet.htm")

public ModelAndView formModifJouet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String destinationPage = "";

		try
		{
			GestionErgosum unService = new GestionErgosum();
			
			if (unService != null)
			{
				String id = request.getParameter("idJouet");
				request.setAttribute("jouet",unService.getJouet(id));
				request.setAttribute("qAndY",unService.getqAndY(id));
				request.setAttribute("categories", unService.listerToutesLesCategories());
				request.setAttribute("tranches", unService.listerToutesLesTranches());
				request.setAttribute("annees", unService.listerToutesLesAnnees());
				
		         destinationPage = "/modificationJouet";
			}
		}  catch (MonException e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		
		return new ModelAndView(destinationPage);
	}
	
	
	/**
	 * Modifier Jouet
	 */
	@RequestMapping(value = "modifierJouet.htm")

public ModelAndView modifierJouet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String destinationPage = "";

		try
		{
			GestionErgosum unService = new GestionErgosum();
			
			if (unService != null)
			{
				Jouet jouet = new Jouet();
				Categorie categorie = new Categorie();
				Trancheage tranche = new Trancheage();
				Catalogue cata = new Catalogue();
				Comporte comporte = new Comporte();
				ComporteId comporteId = new ComporteId();
				categorie.setCodecateg(request.getParameter("categorie"));
				tranche.setCodetranche(request.getParameter("tranche"));
				jouet.setNumero(request.getParameter("id"));
				jouet.setLibelle(request.getParameter("libelle"));
				jouet.setCategorie(categorie);
				jouet.setTrancheage(tranche);
				comporteId.setNumero(request.getParameter("id"));
				comporte.setCatalogue(cata);
				comporte.setId(comporteId);
				comporte.setJouet(jouet);
				comporte.setQuantite(Integer.parseInt(request.getParameter("quantite")));
				unService.modifier(jouet);
				unService.modifierComporte(comporte);
				
				
		        destinationPage = "";
			}
		}  catch (MonException e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		
		return new ModelAndView("redirect:afficherJouets.htm");
	}
			
		
	
	/**
	 *  effacer  jouet
	 */	
	@RequestMapping(value = "effacerJouet.htm")
	public ModelAndView effacerJouet(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try
		{
			String id = request.getParameter("idJouetaSup");
			System.out.println(id);
			GestionErgosum unService = new GestionErgosum();
			unService.effacerComporte(id);
			unService.effacer(id);
		}
		catch (Exception e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		return new ModelAndView("redirect:afficherJouets.htm");	
	}
	
	

	/**
	 *  afficher le Dictionnaire
	 */	
	@RequestMapping(value = "afficherDictionnaire.htm")
	public ModelAndView afficherDictionnaire(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String destinationPage="/Erreur";
		List<Catalogue> listC = null;
		List<Dictionnaire> dico = null;
		try
		{
			GestionErgosum unService = new GestionErgosum();
			
			if (unService != null){
				listC = unService.listerToutesLesAnnees();
				request.setAttribute("catalogues", listC);
				dico = unService.rechercherDictionnaire();
				request.setAttribute("dictionnaire", dico);
			    destinationPage = "/dictionnaire";
			}
		}  catch (MonException e)
		{
			request.setAttribute("MesErreurs", e.getMessage());
		}
		
		return new ModelAndView(destinationPage);	
	}
	
}

	