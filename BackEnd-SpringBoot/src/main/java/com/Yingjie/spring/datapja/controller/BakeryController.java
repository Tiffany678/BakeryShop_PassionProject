package com.Yingjie.spring.datapja.controller;

import com.Yingjie.spring.datapja.model.Bakery;
import com.Yingjie.spring.datapja.repository.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BakeryController {

	@Autowired
	BakeryRepository bakeryRepository;


	@GetMapping("/bakery")
	public List<Bakery> getAllNotes()
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


//	@PostMapping("/order")
//	public void submitOrder(String desc,double subtotal,double shipping, double total){
//		Order myorder = new Order(desc,shipping,subtotal,total);
//	}




	public ResponseEntity<List<Bakery>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Bakery> bakery = new ArrayList<>();

			if (title == null)
				bakeryRepository.findAll().forEach(bakery::add);
			else
				bakeryRepository.findByTitleContaining(title).forEach(bakery::add);

			if (bakery.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(bakery, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


//	public ResponseEntity<Bakery> getTutorialById(@PathVariable("id") long id) {
//		Optional<Bakery> bakeryData = bakeryRepository.findById(id);
//
//		if (bakeryData.isPresent()) {
//			return new ResponseEntity<>(bakeryData.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

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

//	@PutMapping("/bakery/{id}")
//	public ResponseEntity<Bakery> updateBakery(@PathVariable("id") long id, @RequestBody Bakery bakery) {
//		Optional<Bakery> bakeryData = bakeryRepository.findById(id);
//
//		if (bakeryData.isPresent()) {
//			Bakery _bakery = bakeryData.get();
//			_bakery.setTitle(bakery.getTitle());
//			_bakery.setPrice(bakery.getPrice());
//			_bakery.setCount(bakery.getCount());
//			_bakery.setInInterest(bakery.isInInterest());
//			_bakery.setCategory(bakery.getCategory());
//			_bakery.setInformation(bakery.getInformation());
//			return new ResponseEntity<>(bakeryRepository.save(_bakery), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

//	@DeleteMapping("/bakery/{id}")
//	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//		try {
//			bakeryRepository.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@DeleteMapping("/bakery")
//	public ResponseEntity<HttpStatus> deleteAllTutorials() {
//		try {
//			bakeryRepository.deleteAll();
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@GetMapping("/bakery/inInterest")
////	public ResponseEntity<List<Bakery>> findByInInterest(boolean inInterest) {
//	public ResponseEntity<List<Bakery>> findByInInterest() {
//		try {
//			List<Bakery> bakeries = bakeryRepository.findByInInterest(true);
//
//			if (bakeries.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(bakeries, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@Override
	public String toString() {
		return "BakeryController{" +
				"bakeryRepository=" + bakeryRepository +
				'}';
	}
}