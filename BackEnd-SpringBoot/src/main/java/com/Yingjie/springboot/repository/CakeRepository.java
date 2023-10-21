package com.Yingjie.springboot.repository;

import com.Yingjie.springboot.model.Cake;
import java.util.List;

public interface CakeRepository{
	Cake create(Cake cake);
	List<Cake> findAll();
	Cake getCakeById(int id);
	Cake update(Cake cake);
	void delete(int id);

}
