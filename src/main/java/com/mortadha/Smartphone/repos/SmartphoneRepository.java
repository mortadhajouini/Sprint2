package com.mortadha.Smartphone.repos;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.JpaRepository;

import com.mortadha.Smartphone.entities.Classe;
import com.mortadha.Smartphone.entities.Smartphone;
public interface SmartphoneRepository extends org.springframework.data.jpa.repository.JpaRepository<Smartphone, Long> {
	List<Smartphone> findByNomSmartphone(String nom);
	 List<Smartphone> findByNomSmartphoneContains(String nom); 
	 @Query("select p from Smartphone p where p.nomSmartphone like %?1 and p.prixSmartphone > ?2")
	 List<Smartphone> findByNomPrix (String nom, Double prix);
	 @Query("select p from Smartphone p where p.Classe = ?1")
	 List<Smartphone> findByClasse (Classe classe);
	 List<Smartphone> findByClasseIdCat(Long id);
	 List<Smartphone> findByOrderByNomSmartphoneAsc();
	 @Query("select p from Smartphone p order by p.nomSmartphone ASC, p.prixSmartphone DESC")
	 List<Smartphone> trierSmartphonesNomsPrix ();

}
