package com.Yingjie.springboot.repository;

import com.Yingjie.springboot.model.Cake;
import java.util.List;

public interface CakeRepository{
	Cake create(Cake cake);
	List<Cake> findAll();
	Cake getCake(int id);
	Cake update(Cake cake);
	void update(List<Object[]> pairs);
	void delete(int id);
	Cake findByTitle(String title);
}
