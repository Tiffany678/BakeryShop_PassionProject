package com.Yingjie.springboot.controller;

import com.Yingjie.springboot.model.Bakery;
import com.Yingjie.springboot.repository.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BakeryController {

	@Autowired
	BakeryRepository bakeryRepository;

	public BakeryRepository getBakeryRepository() {return bakeryRepository;}

	@GetMapping("/bakery")
	public List<Bakery> getAllCakes()
	{
		return bakeryRepository.findAll();
	}

	@GetMapping("/bakery/{id}")
	public Bakery getCakeById(@PathVariable(value = "id") long id) {

		return bakeryRepository.findById(id).get();
	}


	@GetMapping("/cakes/{id}")
	public int getItemCount(@PathVariable(value = "id") Long id) {
		Bakery b = bakeryRepository.findById(id).get();
		return b.getCount();
	}

	@GetMapping("/price/{id}")
	public double getItemPrice(@PathVariable(value = "id") Long id) {
		Bakery b = bakeryRepository.findById(id).get();
		return b.getPrice();
	}

	@GetMapping("/checkCake/{id}")
	public boolean checkCake(@PathVariable(value = "id") Long id, @RequestBody int count) {
		Bakery b = bakeryRepository.findById(id).get();
		if (b.getCount()>=count)
			return true;
		else return false;
	}

	@PostMapping("/cakes/{id}")
	public void buyCake(@PathVariable(value = "id") Long id, @RequestBody int count) {
		Bakery b = bakeryRepository.findById(id).get();
		if (b.getCount()>=count)
			b.setCount(b.getCount()-count);
	}

//	Added Here
	@GetMapping("/cake/{id}")
	public int getCakeCount(@PathVariable(value = "id") Long id) {
		Bakery b = bakeryRepository.findById(id).get();
		return b.getCount();
	}


	public void processOrder(String orderDesc){
		String[] cakeArr= orderDesc.split(",");
		for (int i=0;i<cakeArr.length;i++) {
			String[] tmp = cakeArr[i].split(":");
			Bakery b= bakeryRepository.findByTitle(tmp[0]);
			//tmp[1].replace(" ","");
			if (b!=null){
				int diff = b.getCount()-Integer.parseInt(tmp[1]);
				if(diff>=0) {
					b.setCount(diff);
					//b.setCount(10);
					bakeryRepository.save(b);
				}
			}
		}
	}

	@PostMapping("/orderCake")
	public ResponseEntity<Bakery> orderCake (@RequestBody String orderDesc) {
		Bakery b=new Bakery();
		try {
			String[] cakeArr= orderDesc.split(",");
			for (int i=0;i<cakeArr.length;i++) {
				String[] tmp = cakeArr[i].split(":");
				b= bakeryRepository.findByTitle(tmp[0]);
				tmp[1].replace(" ","");
				if (b!=null){
					b.setCount(b.getCount()-Integer.parseInt(tmp[1]));
					bakeryRepository.save(b);
				}
			}
			return new ResponseEntity<>(b, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}


	@PostMapping("/bakery/new")
	public ResponseEntity<Bakery> createBakery(@RequestBody Bakery bakery) {
		try {
			Bakery _bakery = bakeryRepository
					.save(new Bakery(bakery.getTitle(),bakery.getPrice(),bakery.getCount(),
							bakery.isInInterest(), bakery.getCategory(),
							bakery.getInformation()));
			return new ResponseEntity<>(_bakery, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	@Override
	public String toString() {
		return "BakeryController{" +
				"bakeryRepository=" + bakeryRepository +
				'}';
	}
}