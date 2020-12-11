package com.abir.voiture.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abir.voiture.entities.Vehicule;
import com.abir.voiture.service.VehiculeService;

@Controller
public class VehiculeController {
	@Autowired
	VehiculeService vehiculeService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createVehicule";
	}
	
	@RequestMapping("/saveVehicule")
	public String saveVehicule(@ModelAttribute("Vehicule") Vehicule vehicule, 
							  @RequestParam("date") String date,
							  ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        vehicule.setDateCreation(dateCreation);
      
		 Vehicule saveVehicule = vehiculeService.saveVehicule(vehicule);
		 String msg ="vehicule enregistré avec Id "+saveVehicule.getIdVehicule();
		 modelMap.addAttribute("msg", msg);
		return "createVehicule";
	}
	
	@RequestMapping("/ListeVehicule")
	public String listeProduits(ModelMap modelMap)
	{
		List<Vehicule> prods = vehiculeService.getAllVehicule();
		modelMap.addAttribute("vehicule", prods);		
		return "listeVehicule";	
	}
	
	@RequestMapping("/supprimerVehicule")
	public String supprimerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Vehicule p= new Vehicule();
		p.setIdVehicule(id);
		vehiculeService.deleteVehicule(p);
		List<Vehicule> prods = vehiculeService.getAllVehicule();
		modelMap.addAttribute("vehicule", prods);	
		return "listeVehicule";	
	}
	
	@RequestMapping("/modifierVehicule")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Vehicule p=vehiculeService.getVehicule(id);
		modelMap.addAttribute("produit", p);	
		return "editerVehicule";	
	}

	@RequestMapping("/updateVehicule")
	public String updateVehicule(@ModelAttribute("vehicule") Vehicule vehicule,
								@RequestParam("date") String date,
			                    ModelMap modelMap) throws ParseException 
	{
		
		//conversion de la date 
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        vehicule.setDateCreation(dateCreation);
        
        vehiculeService.updateVehiculet(vehicule);
		  List<Vehicule> prods = vehiculeService.getAllVehicule();
		  modelMap.addAttribute("vehicule", prods);	
		
		return "listeVehicule";
	}



}


