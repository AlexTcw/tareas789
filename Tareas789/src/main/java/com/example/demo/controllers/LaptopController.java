package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Laptop;
import com.example.demo.repositories.LaptopRepository;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
	// atributos
	private final Logger log = LoggerFactory.getLogger(LaptopController.class);
	private LaptopRepository laptopRepository;
	// constructores

	public LaptopController(LaptopRepository laptopRepository) {
		this.laptopRepository = laptopRepository;
	}
	// CRUD

	// CREATE LAPTOP IN THE DATABASE
	@PostMapping("/api/laptops")
	public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
		System.out.println(headers.get("User-Agent"));
		// guardar el libro recibido por parámetro en la base de datos
		if (laptop.getId() != null) { // quiere decir que existe el id y por tanto no es una creación
			log.warn("trying to create a book with id");
			System.out.println("trying to create a book with id");
			return ResponseEntity.badRequest().build();
		}
		Laptop result = laptopRepository.save(laptop);
		return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
	}

	// REED LAPTOP IN THE DATABASE
	@GetMapping("/api/laptops")
	public List<Laptop> findAll() {
		return laptopRepository.findAll();
	}

	@ApiOperation("Buscar una laptop por su clave primaria")
	@GetMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> findById(@PathVariable Long id) {
		Optional<Laptop> laptopOptional = laptopRepository.findById(id);
		if (laptopOptional.isPresent()) {
			return ResponseEntity.ok(laptopOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// UPDATE LAPTOP IN THE DATABASE
	@PutMapping("/api/laptops")
	public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
		if (laptop.getId() == null) {
			log.warn("trying to updae a non existing laptop");
			return ResponseEntity.badRequest().build();
		}
		if (!laptopRepository.existsById(laptop.getId())) {
			log.warn("trying to updae a non existing laptop");
			return ResponseEntity.badRequest().build();
		}
		Laptop result = laptopRepository.save(laptop);
		return ResponseEntity.ok(result);

	}

	// DELETE LAPTOP IN THE DATABASE
	@ApiIgnore
	@DeleteMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> delete(@PathVariable Long id) {

		if (!laptopRepository.existsById(id)) {
			log.warn("Trying to delete a non existing laptop");
			return ResponseEntity.notFound().build();
		}
		laptopRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@ApiIgnore
	@DeleteMapping("/api/laptops")
	public ResponseEntity<Laptop> deleteAll(){
		log.info("REST request for delete all laptops");
		laptopRepository.deleteAll();
		return ResponseEntity.noContent().build();
	}


}
