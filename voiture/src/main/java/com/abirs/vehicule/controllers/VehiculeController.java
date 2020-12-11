package com.abirs.vehicule.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abirs.vehicule.entities.Vehicule;
import com.abirs.vehicule.service.VehiculeService;

@Controller
public class VehiculeController {
	
	@Autowired
	VehiculeService vehiculetService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createVehicule";
	}
	
	@RequestMapping("/saveVehicule")
	public String saveVehicule(@ModelAttribute("Vehicule") Vehicule vehicule)
	{
		vehiculetService.saveVehicule(vehicule);
	return "createVehicule";
	}
	@RequestMapping("/ListeVehicule")
	public String listeVehicule(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)

	{
		Page<Vehicule> prods = vehiculetService.getAllVehiculeParPage(page, size);
		modelMap.addAttribute("Vehicule", prods);
		 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVehicule";
	}
	@RequestMapping("/supprimerVehicule")
	public String supprimerVehicule(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
		vehiculetService.deleteVehiculeById(id);

		Page<com.abirs.vehicule.entities.Vehicule>  v = vehiculetService.getAllVehiculeParPage(page,
				size);
				modelMap.addAttribute("vehicule", v);
				modelMap.addAttribute("pages", new int[v.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
				return "listeVehicule";

	}
	@RequestMapping("/modifierVehicule")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	com.abirs.vehicule.entities.Vehicule v= vehiculetService.getVehicule(id);
	modelMap.addAttribute("Vehicule", v);
	return "editerVehicule";
	}
	@RequestMapping("/updateVehicule")
	public String updateProduit(@ModelAttribute("Vehicule") Vehicule vehicule,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 vehicule.setDateCreation(dateCreation);

		 vehiculetService.updateVehicule(vehicule);
		 List<Vehicule> prods = vehiculetService.getAllVehicule();
		 modelMap.addAttribute("Vehicule", prods);
		return "listeVehicule";

	}
}
