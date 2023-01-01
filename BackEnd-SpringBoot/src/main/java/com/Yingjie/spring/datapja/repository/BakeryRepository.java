package com.Yingjie.spring.datapja.repository;

import com.Yingjie.spring.datapja.model.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BakeryRepository extends JpaRepository<Bakery, Long> {
	List<Bakery> findByInInterest(boolean inInterest);
	List<Bakery> findAll();
	//int getItemCount(Long id);
	List<Bakery> findByTitleContaining(String title);
}
