package com.mortadha.Smartphone;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mortadha.Smartphone.entities.Smartphone;
import com.mortadha.Smartphone.service.SmartphoneService;
@SpringBootApplication
public class SmartphoneApplication implements CommandLineRunner {
@Autowired
SmartphoneService SmartphoneService;
public static void main(String[] args) {
SpringApplication.run(SmartphoneApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
SmartphoneService.saveSmartphone(new Smartphone("Apple Iphone 15 Pro", 5600.0, new Date()));
SmartphoneService.saveSmartphone(new Smartphone("Oppo Reno 8T", 2800.0, new Date()));
SmartphoneService.saveSmartphone(new Smartphone("Google Pixel 8 Pro", 900.0, new Date()));
}
}

