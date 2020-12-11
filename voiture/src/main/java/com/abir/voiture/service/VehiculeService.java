package com.abir.voiture.service;

import java.util.List;

import com.abir.voiture.entities.Vehicule;

public interface VehiculeService {
	Vehicule saveVehicule(Vehicule p);
	Vehicule updateVehiculet(Vehicule p);
	void deleteVehicule(Vehicule p);
	void deleteVehiculeById(Long id);
	Vehicule getVehicule(Long id);
	List<Vehicule> getAllVehicule();

}
