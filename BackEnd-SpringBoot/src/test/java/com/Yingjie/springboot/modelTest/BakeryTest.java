package com.Yingjie.springboot.modelTest;

import com.Yingjie.springboot.controller.BakeryController;
import com.Yingjie.springboot.model.Bakery;
import com.Yingjie.springboot.repository.BakeryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BakeryTest {
    @Mock
    private BakeryRepository bakeryRepository;
    @InjectMocks
    private BakeryController bakeryController;

    @Test
    public void BakeryIdTest() {
        Bakery bakery = new Bakery("Fruit Cake", 40.0, 2, true,"Fruit","Fruit Cake");
        bakery.setId(11L);

        long expect =11L;
        Assert.assertEquals(expect, bakery.getId());
    }
    @Test
    public void BakeryTitleTest() {
        Bakery bakery = new Bakery("Fruit Cake", 40.0, 2, true,"Fruit","Fruit Cake");
        bakery.setTitle("TestFruitCake");

        String expect ="TestFruitCake";
        Assert.assertEquals(expect, bakery.getTitle());
    }
    @Test
    public void BakeryInterestedTest() {
        Bakery bakery = new Bakery("Fruit Cake", 40.0, 2, true,"Fruit","Fruit Cake");
        bakery.setId(11L);

        assertTrue(bakery.isInInterest());
    }
}