package com.car;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Primary

@Table(name="car_details")
public class Car {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@Transient
	private String brand;
	private int price;
	private String color;
	private int cc;
	private float rating;
	private String model;
	private String fuelType;
	private String noPlate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;  
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getNoPlate() {
		return noPlate;
	}
	public void setNoPlate(String noPlate) {
		this.noPlate = noPlate;
	}
	
	

}
