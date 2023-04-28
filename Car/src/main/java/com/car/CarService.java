package com.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarService {
	@Autowired
	CarDoa cd;
	public String setCar(Car c) {
		return cd.setCar(c);
	}
	
	public String setCar1(List<Car> c) {
		// TODO Auto-generated method stub
		return cd.setCar1(c);
	}

	public List<Car> getAllObject() {
		// TODO Auto-generated method stub
		return cd.getAllObject();
	}

	public Car getCarObjectId(int id) {
		// TODO Auto-generated method stub
		return cd.getCarObjectId(id);
	}

	public String deleteObjectById(int id) {
		
		return cd.deleteObjectById(id);
	}

	public String getBrandById(int id) {
		
		return cd.getBrandById(id);
	}

}
