package com.Yingjie.springboot.controller;

import com.Yingjie.springboot.model.Order;
import com.Yingjie.springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BakeryController bakeryController;

    public BakeryController getBakeryController() {return bakeryController;}
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    @PostMapping("/order")
    public ResponseEntity<Order> submitOrder(@RequestBody Order myorder) {
        try {
            Order _order = orderRepository
                    .save(new Order(myorder.getDescription(), myorder.getShipping(), myorder.getSubtotal(), myorder.getTotal()));
            bakeryController.processOrder(myorder.getDescription());
            System.out.println("order received");
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
