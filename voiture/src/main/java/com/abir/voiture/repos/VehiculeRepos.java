package com.abir.voiture.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abir.voiture.entities.Vehicule;



public interface VehiculeRepos extends JpaRepository<Vehicule, Long> {

}
