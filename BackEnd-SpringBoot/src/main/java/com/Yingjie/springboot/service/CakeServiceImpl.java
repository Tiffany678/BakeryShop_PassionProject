package com.Yingjie.springboot.service;

import com.Yingjie.springboot.model.Cake;
import com.Yingjie.springboot.repository.CakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("cakeService")
public class CakeServiceImpl implements CakeService{
    private CakeRepository cakeRepository;

    public CakeServiceImpl(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    @Override
    public List<Cake> findAll() {
        return cakeRepository.findAll();
    }

    @Override
    public Cake create(Cake cake) {
        return cakeRepository.create(cake);
    }

    @Override
    public Cake getCakeById(int id) {
        return cakeRepository.getCakeById(id);
    }

    @Override
    public Cake update(Cake cake) {
        return cakeRepository.update(cake);
    }


    @Override
    public void delete(int id) {
         cakeRepository.delete(id);
    }
}
