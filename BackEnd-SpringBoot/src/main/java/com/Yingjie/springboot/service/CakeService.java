package com.Yingjie.springboot.service;

import com.Yingjie.springboot.model.Cake;

import java.util.List;

public interface CakeService {
    List<Cake> findAll();
    Cake create(Cake cake);
    Cake getCakeById(int id);
    Cake update(Cake cake);

    void delete(int id);

}
