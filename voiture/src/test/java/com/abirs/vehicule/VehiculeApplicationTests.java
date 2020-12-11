package com.abirs.vehicule;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.abirs.vehicule.entities.Vehicule;
import com.abirs.vehicule.repos.VehiculeRepository;
import com.abirs.vehicule.service.VehiculeService;

@SpringBootTest
class VehiculeApplicationTests {

	@Autowired
	private VehiculeRepository vehiculeRepository;
	@Autowired
	private VehiculeService vehiculeService ;
	@Test
	public void testCreateVehicule() {
	Vehicule voiture = new Vehicule("Fiat","bleu", 12000.500,new Date());
	vehiculeRepository.save(voiture);
	}
	 @Test
	 public void testFindVehicule()
	 {
		 Vehicule v = vehiculeRepository.findById(1L).get();
	 System.out.println(v);
	 }
	 @Test
	 public void testUpdateProduit()
	 {
		 com.abirs.vehicule.entities.Vehicule v = vehiculeRepository.findById(1L).get();
	 v.setPrixVehicule(9000.000);
	 vehiculeRepository.save(v);
	 }
	 @Test
	 public void testDeleteVehicule() {
		 
		 vehiculeRepository.deleteById(1L);
		 
		 
	 }
	 @Test
	 public void testListerTousVehicule()
	 {
	 List<Vehicule> voiture = vehiculeRepository.findAll();
	 for (Vehicule v : voiture)
	 {
	 System.out.println(v);
	 }
	 }
	 @Test
	 public void testFindByMarqueVehiculeContains()
	 {
	 Page<Vehicule> ve = vehiculeService.getAllVehiculeParPage(0,2);
	 System.out.println(ve.getSize());
	 System.out.println(ve.getTotalElements());
	 System.out.println(ve.getTotalPages());
	 ve.getContent().forEach(v -> {System.out.println(v.toString());
	  });
	 
	 }
	 @Test
	 public void testFindByMarqueVehicule()
	 {
	 List<Vehicule> veh= vehiculeRepository.findByMarqueVehiculeContainss("kia");
	 for (Vehicule v : veh)
	 {
	 System.out.println(v);
	 }
	 }
	 @Test
	 public void testFindByMarqueVehiculeContainss()
	 {
	 List<Vehicule> veh=vehiculeRepository.findByMarqueVehiculeContainss("kia");
	 for (Vehicule v : veh)
	 {
	 System.out.println(v);
	 } }

}
