package com.mortadha.Smartphone.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mortadha.Smartphone.entities.Classe;
import com.mortadha.Smartphone.entities.Smartphone;
public interface SmartphoneService {
	Smartphone saveSmartphone(Smartphone p);
	Smartphone updateSmartphone(Smartphone p);
	void deleteSmartphone(Smartphone p);
	void deleteSmartphoneById(Long id);
	Smartphone getSmartphone(Long id);
	List<Smartphone> getAllSmartphones();
	List<Smartphone> findByNomSmartphone(String nom);
	List<Smartphone> findByNomSmartphoneContains(String nom);
	List<Smartphone> findByNomPrix (String nom, Double prix);
	List<Smartphone> findByClasse (Classe classe);
	List<Smartphone> findByClasseIdCat(Long id);
	List<Smartphone> findByOrderByNomSmartphoneAsc();
	List<Smartphone> trierSmartphonesNomsPrix();




}
