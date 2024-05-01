package com.mortadha.Smartphone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mortadha.Smartphone.entities.Classe;
import com.mortadha.Smartphone.entities.Smartphone;
import com.mortadha.Smartphone.repos.SmartphoneRepository;
@Service
public class SmartphoneServiceImpl implements SmartphoneService {
@Autowired
SmartphoneRepository SmartphoneRepository;
@Override
public Smartphone saveSmartphone(Smartphone p) {
return SmartphoneRepository.save(p);
}
@Override
public Smartphone updateSmartphone(Smartphone p) {
return SmartphoneRepository.save(p);
}
@Override
public void deleteSmartphone(Smartphone p) {
SmartphoneRepository.delete(p);
}
 @Override
public void deleteSmartphoneById(Long id) {
SmartphoneRepository.deleteById(id);
}
@Override
public Smartphone getSmartphone(Long id) {
return SmartphoneRepository.findById(id).get();
}
@Override
public List<Smartphone> getAllSmartphones() {
return SmartphoneRepository.findAll();
}
@Override
public Page<Smartphone> getAllSmartphonesParPage(int page, int size) {
return SmartphoneRepository.findAll(PageRequest.of(page, size));
}
@Override
public List<Smartphone> findByNomSmartphone(String nom) {
return SmartphoneRepository.findByNomSmartphone(nom);
}
@Override
public List<Smartphone> findByNomSmartphoneContains(String nom) {
return SmartphoneRepository.findByNomSmartphoneContains(nom);
}
@Override
public List<Smartphone> findByNomPrix(String nom, Double prix) {
return SmartphoneRepository.findByNomPrix(nom, prix);
}
@Override
public List<Smartphone> findByClasse(Classe classe) {
return SmartphoneRepository.findByClasse(classe);
}
@Override
public List<Smartphone> findByClasseIdCat(Long id) {
return SmartphoneRepository.findByClasseIdCat(id);
}
@Override
public List<Smartphone> findByOrderByNomSmartphoneAsc() {
return SmartphoneRepository.findByOrderByNomSmartphoneAsc();
}
@Override
public List<Smartphone> trierSmartphonesNomsPrix() {
return SmartphoneRepository.trierSmartphonesNomsPrix();


}
