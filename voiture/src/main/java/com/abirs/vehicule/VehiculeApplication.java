package com.abirs.vehicule;



import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abirs.vehicule.entities.Vehicule;
import com.abirs.vehicule.service.VehiculeService;

@SpringBootApplication
public class VehiculeApplication implements CommandLineRunner {
	VehiculeService vehiculeService ;
	public static void main(String[] args) {
		SpringApplication.run(VehiculeApplication.class, args);
	}

	public void run(String... args) throws Exception {
		vehiculeService.saveVehicule(new Vehicule("kia","rouge",180.000,new Date()));
		vehiculeService.saveVehicule(new Vehicule("FIAT","GRIS",50.000,new Date()));
		vehiculeService.saveVehicule(new Vehicule("CITROEN","rouge",100.000,new Date()));
		
	}

}
