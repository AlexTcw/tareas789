package com.example.demo.entities;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@ApiModel("Entidad laptop para representar un elemento didáctico")
public class Laptop {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("Clave ficticia autoincremental tipo Long")
	private Long id;
	private String marca;
	@ApiModelProperty("Precio en pesos")
	private Double precio;
	private boolean disponible;
	//Constructores
	public Laptop() {
		super();
	}
	public Laptop(Long id, String marca, Double precio, boolean disponible) {
		super();
		this.id = id;
		this.marca = marca;
		this.precio = precio;
		this.disponible = disponible;
	}
	//getters y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
