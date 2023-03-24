package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.Laptop;
import com.example.demo.repositories.LaptopRepository;

@SpringBootApplication
public class Tareas4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Tareas4Application.class, args);
		context.getBean(LaptopRepository.class);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		
		//Crear laptops
		//crear entidades
		Laptop laptop1 = new Laptop(null,"Acer",10000.0,true);
		//guardar entidades
		laptopRepository.save(laptop1);
	}

}
