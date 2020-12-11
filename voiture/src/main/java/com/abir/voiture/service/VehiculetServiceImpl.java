package com.abir.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.voiture.entities.Vehicule;
import com.abir.voiture.repos.VehiculeRepos;

@Service
public class VehiculetServiceImpl implements VehiculeService{

	@Autowired
	VehiculeRepos vehiculeRepository;
	
	@Override
	public Vehicule saveVehicule(Vehicule p) {
		return vehiculeRepository.save(p);
	}

	@Override
	public Vehicule updateVehiculet(Vehicule p) {
		return vehiculeRepository.save(p);
	}

	@Override
	public void deleteVehicule(Vehicule p) {
		vehiculeRepository.delete(p);
		
	}

	@Override
	public void deleteVehiculeById(Long id) {
		vehiculeRepository.deleteById(id);
		
	}

	@Override
	public Vehicule getVehicule(Long id) {
		return vehiculeRepository.findById(id).get();
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		return vehiculeRepository.findAll();
	}
	
	

}

