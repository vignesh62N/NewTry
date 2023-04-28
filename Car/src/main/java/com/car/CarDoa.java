package com.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDoa {
	@Autowired
CarRepository cr;
	public String setCar(Car c) {
		cr.save(c);
		return "Save";
	}
	
	public String setCar1(List<Car> c) {
		cr.saveAll(c);
		return "sucess";
	}
	public List<Car> getAllObject() {
		
		return cr.findAll();
	}

	public Car getCarObjectId(int id) {
		
	return cr.findById(id).get();
	}

	public String deleteObjectById(int id) {
	cr.deleteById(id);
		return "deleted succesfully";
	}

	public String getBrandById(int id) {
		Car a=cr.findById(id).get();
		String b=a.getBrand();
		return b;
	}

}
