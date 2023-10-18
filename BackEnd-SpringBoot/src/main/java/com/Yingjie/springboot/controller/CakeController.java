package com.Yingjie.springboot.controller;

import com.Yingjie.springboot.model.Cake;
import com.Yingjie.springboot.service.CakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
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

		return cakeService.getCake(id);
	}

	@PutMapping("/cake/{id}")
	public Cake update(@RequestBody Cake cake) {
		System.out.println("Id: "+cake.getId()
				+"\nName: "+cake.getTitle()
				+"\nprice: "+cake.getPrice()
				+"\nMaximum number to order: "+cake.getLimitedNum()
				+"\nInformation: "+cake.getInformation()
				+"\n");
		return cakeService.update(cake);
	}




//
//
//	@GetMapping("/{id}")
//	public int getItemCount(@PathVariable(value = "id") Long id) {
//		Bakery b = bakeryRepository.findById(id).get();
//		return b.getLimit();
//	}
//
//	@GetMapping("/price/{id}")
//	public double getItemPrice(@PathVariable(value = "id") Long id) {
//		Bakery b = bakeryRepository.findById(id).get();
//		return b.getPrice();
//	}
//
//	@GetMapping("/{id}")
//	public boolean checkCake(@PathVariable(value = "id") Long id, @RequestBody int count) {
//		Bakery b = bakeryRepository.findById(id).get();
//		if (b.getLimit()>=count)
//			return true;
//		else return false;
//	}
//
//	@PostMapping("/{id}")
//	public void buyCake(@PathVariable(value = "id") Long id, @RequestBody int count) {
//		Bakery b = bakeryRepository.findById(id).get();
//		if (b.getLimit()>=count)
//			b.setLimit(b.getLimit()-count);
//	}
//
////	Added Here
//	@GetMapping("/{id}")
//	public int getCakeCount(@PathVariable(value = "id") Long id) {
//		Bakery b = bakeryRepository.findById(id).get();
//		return b.getLimit();
//	}
//
//
//	public void processOrder(String orderDesc){
//		String[] cakeArr= orderDesc.split(",");
//		for (int i=0;i<cakeArr.length;i++) {
//			String[] tmp = cakeArr[i].split(":");
//			Bakery b= bakeryRepository.findByTitle(tmp[0]);
//			//tmp[1].replace(" ","");
//			if (b!=null){
//				int diff = b.getLimit()-Integer.parseInt(tmp[1]);
//				if(diff>=0) {
//					b.setLimit(diff);
//					//b.setCount(10);
//					bakeryRepository.save(b);
//				}
//			}
//		}
//	}
//
//	@PostMapping("/orderCake")
//	public ResponseEntity<Bakery> orderCake (@RequestBody String orderDesc) {
//		Bakery b=new Bakery();
//		try {
//			String[] cakeArr= orderDesc.split(",");
//			for (int i=0;i<cakeArr.length;i++) {
//				String[] tmp = cakeArr[i].split(":");
//				b= bakeryRepository.findByTitle(tmp[0]);
//				tmp[1].replace(" ","");
//				if (b!=null){
//					b.setLimit(b.getLimit()-Integer.parseInt(tmp[1]));
//					bakeryRepository.save(b);
//				}
//			}
//			return new ResponseEntity<>(b, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
//
//
////	@PostMapping("/bakery/new")
////	public ResponseEntity<Bakery> createBakery(@RequestBody Bakery bakery) {
////		try {
////			Bakery _bakery = bakeryRepository
////					.save(new Bakery(bakery.getTitle(),bakery.getPrice(),bakery.getLimit(),
////							bakery.getInformation()));
////			return new ResponseEntity<>(_bakery, HttpStatus.CREATED);
////		} catch (Exception e) {
////			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////		}
//	//}
//
//@PostMapping("/")
//public Bakery createCake(@RequestBody Bakery bakery){
//	System.out.println("Name"+bakery.getTitle()+"/nPrice"+bakery.getPrice());
//	return null;
//}
//
//	@Override
//	public String toString() {
//		return "BakeryController{" +
//				"bakeryRepository=" + bakeryRepository +
//				'}';
//	}
}