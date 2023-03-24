package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long>{

}
