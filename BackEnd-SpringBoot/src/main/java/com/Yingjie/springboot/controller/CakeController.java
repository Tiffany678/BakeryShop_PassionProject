package com.Yingjie.springboot.controller;

import com.Yingjie.springboot.model.Cake;
import com.Yingjie.springboot.service.CakeService;
import com.Yingjie.springboot.util.ServiceError;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CakeController {

	private CakeService cakeService;

	public CakeController(CakeService cakeService) {
		this.cakeService = cakeService;
	}
	@PostMapping("/cake")

	public Cake createCake(@RequestBody Cake cake){
		return cakeService.create(cake);
	}

	@GetMapping("/cake")

	public List<Cake> getCakes()
	{
		return cakeService.findAll();
	}

	@GetMapping("/cake/{id}")

	public Cake getCakeById(@PathVariable(value = "id") int id) {

		return cakeService.getCakeById(id);
	}

	@PutMapping("/cake")
	public Cake updateCake(@RequestBody Cake cake) {
		System.out.println("Id: "+cake.getId()
				+"\nName: "+cake.getTitle()
				+"\nprice: "+cake.getPrice()
				+"\nMaximum number to order: "+cake.getInventory()
				+"\nInformation: "+cake.getInformation()
				+"\nImageUrl"+cake.getImageUrl()
				+"\ncategory"+cake.getCategory()
				+"\n");
		return cakeService.update(cake);
	}
	@DeleteMapping("/cake/delete/{id}")
	public Object DeleteCakeById(@PathVariable(value = "id") int id) {
				cakeService.delete(id);
				return null;
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle (RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return  new ResponseEntity<>(error, HttpStatus.OK);
	}
}