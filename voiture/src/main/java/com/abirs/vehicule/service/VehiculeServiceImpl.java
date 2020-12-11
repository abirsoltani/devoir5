package com.abirs.vehicule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.abirs.vehicule.entities.Vehicule;
import com.abirs.vehicule.repos.VehiculeRepository;

@Service
public class VehiculeServiceImpl implements  VehiculeService {
	
	@Autowired
	 VehiculeRepository  vehiculeRepository;


	@Override
	public void deleteVehiculeById(Long id) {
		vehiculeRepository.deleteById(id);
		
	}

	@Override
	public Vehicule saveVehicule(Vehicule v) {
		return vehiculeRepository.save(v) ;
		
	}

	@Override
	public Vehicule updateVehicule(Vehicule v) {
		return vehiculeRepository.save(v) ;
		
	}

	@Override
	public void deleteVehicule(Vehicule v) {
		vehiculeRepository.delete(v);
		
		
	}

	@Override
	public Vehicule getVehicule(Long id) {
		return vehiculeRepository.findById(id).get();
		
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		return vehiculeRepository.findAll();
	
	}

	@Override
	public Page<Vehicule> getAllVehiculeParPage(int page, int size) {
		return vehiculeRepository.findAll(PageRequest.of(page, size));
		
	}

}
