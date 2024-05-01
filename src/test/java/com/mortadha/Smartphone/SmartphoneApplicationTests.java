package com.mortadha.Smartphone;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.mortadha.Smartphone.entities.Classe;
import com.mortadha.Smartphone.entities.Smartphone;
import com.mortadha.Smartphone.repos.SmartphoneRepository;
import com.mortadha.Smartphone.service.SmartphoneService;
import com.mortadha.Smartphone.service.SmartphoneServiceImpl;
@SpringBootTest
class SmartphonesApplicationTests {
	
	@Autowired
	private SmartphoneRepository SmartphoneRepository;
	@Test
	public void testCreateSmartphone() {
	Smartphone prod = new Smartphone("Samsung S24",6200.500,new Date());
	SmartphoneRepository.save(prod);
	}

@Test
public void testFindSmartphone()
{
Smartphone p = SmartphoneRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdateSmartphone()
{
Smartphone p = SmartphoneRepository.findById(1L).get();
p.setPrixSmartphone(1000.0);
SmartphoneRepository.save(p);
}
@Test
public void testDeleteSmartphone()
{
SmartphoneRepository.deleteById(1L);;
}
 
@Test
public void testListerTousSmartphones()
{
List<Smartphone> prods = SmartphoneRepository.findAll();
for (Smartphone p : prods)
{
System.out.println(p);
}
}

@Test
public void testFindByNomSmartphone()
{
List<Smartphone> prods = SmartphoneRepository.findByNomSmartphone("iphone X");
for (Smartphone p : prods)
{
System.out.println(p);
}
}

@Test
public void testFindByNomSmartphoneContains()
{
List<Smartphone> prods=SmartphoneRepository.findByNomSmartphoneContains("iphone");
for (Smartphone p : prods)
{
System.out.println(p);
} }

@Test
public void testfindByNomPrix()
{
List<Smartphone> prods = SmartphoneRepository.findByNomPrix("iphone X", 1000.0);
for (Smartphone p : prods)
{
System.out.println(p);
}
}

@Test
public void testfindByClasse()
{
Classe cat = new Classe();
cat.setIdCat(1L);
List<Smartphone> prods = SmartphoneRepository.findByClasse(cat);
for (Smartphone p : prods)
{
System.out.println(p);
}
}

@Test
public void findByClasseIdCat()
{
List<Smartphone> prods = SmartphoneRepository.findByClasseIdCat(1L);
for (Smartphone p : prods)
{
System.out.println(p);
}
 }

@Test
public void testfindByOrderByNomSmartphoneAsc()
{
List<Smartphone> prods = 
SmartphoneRepository.findByOrderByNomSmartphoneAsc();
for (Smartphone p : prods)
{
System.out.println(p);
}
}

@Test
public void testTrierSmartphonesNomsPrix()
{
List<Smartphone> prods = SmartphoneRepository.trierSmartphonesNomsPrix();
for (Smartphone p : prods)
{
System.out.println(p);
}
}




}