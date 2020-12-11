package com.abirs.vehicule.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abirs.vehicule.entities.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
	List<Vehicule> findByMarqueVehicule(String marque);
	 List<Vehicule> findByMarqueVehiculeContainss(String marque); 
}
