package com.abirs.vehicule.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.abirs.vehicule.entities.Vehicule;

public interface VehiculeService {
	
	Vehicule saveVehicule(Vehicule vehicule);
	Vehicule updateVehicule(Vehicule vehicule);
	void deleteVehicule(Vehicule v);
	 void deleteVehiculeById(Long id);
	 Vehicule getVehicule(Long id);
	List<Vehicule> getAllVehicule();
	Page<Vehicule> getAllVehiculeParPage(int page, int size);
}
