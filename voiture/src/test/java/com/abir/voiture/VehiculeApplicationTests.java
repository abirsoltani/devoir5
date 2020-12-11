package com.abir.voiture;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.abir.voiture.entities.Vehicule;
import com.abir.voiture.repos.VehiculeRepos;

@SpringBootTest
class VehiculeApplicationTests {

	@Autowired
	private VehiculeRepos vehiculeRepository;
	
	@Test
	public void testCreateVehicule() {
	Vehicule prod = new Vehicule("kia","rouge",1500.500,new Date());
	vehiculeRepository.save(prod);
	}
	
	@Test
	public void testFindVehicule()
	{
	Vehicule p = vehiculeRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateVehicule()
	{
	Vehicule p = vehiculeRepository.findById(1L).get();
	p.setPrixVehicule(2000.0);
	vehiculeRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteVehicule()
	{
		vehiculeRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllVehicule()
	{
		List<Vehicule> prods = vehiculeRepository.findAll();
		
		for (Vehicule p:prods)
			 System.out.println(p);
		
	}
	

}
