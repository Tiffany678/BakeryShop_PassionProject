package com.Yingjie.springboot.repository;

import com.Yingjie.springboot.model.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BakeryRepository extends JpaRepository<Bakery, Long> {
	List<Bakery> findByInInterest(boolean inInterest);
	List<Bakery> findAll();
	//int getItemCount(Long id);
	Bakery findByTitle(String title);
}
