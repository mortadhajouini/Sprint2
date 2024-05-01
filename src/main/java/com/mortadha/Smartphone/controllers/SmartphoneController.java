package com.mortadha.Smartphone.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mortadha.Smartphone.entities.Smartphone;
import com.mortadha.Smartphone.service.SmartphoneService;
@Controller
public class SmartphoneController {
@Autowired
SmartphoneService SmartphoneService;
 @RequestMapping("/ListeSmartphones")

public String listeSmartphones(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,	 
@RequestParam (name="size", defaultValue = "2") int size)
	 {
	 Page<Smartphone> prods = SmartphoneService.getAllSmartphonesParPage(page, size);
	 modelMap.addAttribute("Smartphones", prods);
	  modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	 modelMap.addAttribute("currentPage", page);
	 return "listeSmartphones";
}
 @RequestMapping("/showCreate")
public String showCreate()
{
return "createSmartphone";
}
@RequestMapping("/saveSmartphone")
public String saveSmartphone(@ModelAttribute("Smartphone") Smartphone Smartphone, 
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException 
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 Smartphone.setDateCreation(dateCreation);
 
Smartphone saveSmartphone = SmartphoneService.saveSmartphone(Smartphone);
String msg ="Smartphone enregistré avec Id "+saveSmartphone.getIdSmartphone();
modelMap.addAttribute("msg", msg);
return "createSmartphone";
}
 
@RequestMapping("/supprimerSmartphone")
public String supprimerSmartphone(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
SmartphoneService.deleteSmartphoneById(id);
Page<Smartphone> prods = SmartphoneService.getAllSmartphonesParPage(page, 
size);
modelMap.addAttribute("Smartphones", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeSmartphones";
}

 
 @RequestMapping("/modifierSmartphone")
public String editerSmartphone(@RequestParam("id") Long id,
 ModelMap modelMap)
{
Smartphone p= SmartphoneService.getSmartphone(id);
modelMap.addAttribute("Smartphone", p);
return "editerSmartphone";
}
@RequestMapping("/updateSmartphone")
public String updateSmartphone(@ModelAttribute("Smartphone") Smartphone 
Smartphone, @RequestParam("date") String date,
 ModelMap modelMap) throws ParseException 
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 Smartphone.setDateCreation(dateCreation);
 
 SmartphoneService.updateSmartphone(Smartphone);
 List<Smartphone> prods = SmartphoneService.getAllSmartphones();
 modelMap.addAttribute("Smartphones", prods);
return "listeSmartphones";
}

}
