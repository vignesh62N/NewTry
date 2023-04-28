package com.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CarController {
	@Autowired
	@Qualifier("/CarService1")
	private CarService cs;
	
	@Autowired
	@Qualifier("/CarService2")
	private CarService cs2;
	
	
	@PostMapping("/setCar")
public String setCar(@RequestBody Car c) {
		return cs.setCar(c);
	
}
	@PostMapping ("/setCar1")
	public String setCar1(@RequestBody List<Car> c) {
		return cs.setCar1(c);
	}
	@GetMapping("/getAllObject")
	public List<Car> getAllObject() {
		return cs.getAllObject();
		
	}
	@GetMapping("/getCarObjectId/{id}")
	public Car getCarObjectId(@PathVariable int id) {
		return cs.getCarObjectId(id);
	}
	@DeleteMapping("/deleteObjectById/{id}")
	public String deleteObjectById(@PathVariable int id) {
		return cs.deleteObjectById(id);
	}
	@GetMapping("/getBrandById/{id}")
	public String getBrandById(@PathVariable int id) {
		return cs.getBrandById(id);
	}
	@Autowired
	RestTemplate rt;
	@GetMapping("/getBikeName/{id}")
	public String getBikeName(@PathVariable int id) {
		String url="http://localhost:8080/getBrandById/"+id;
		ResponseEntity<String> s=rt.exchange(url, HttpMethod.GET,null,String.class);
		String x=s.getBody();
		return x;
				
	}
	@GetMapping("/name")
	public String Name() {
		return "viki";
	}
}
