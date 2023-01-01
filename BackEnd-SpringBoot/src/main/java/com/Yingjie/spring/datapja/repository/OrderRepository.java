package com.Yingjie.spring.datapja.repository;

import com.Yingjie.spring.datapja.model.Bakery;
import com.Yingjie.spring.datapja.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //List<Order> findByOrderId(Long id);
    List<Order> findAll();
}
