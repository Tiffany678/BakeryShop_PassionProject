package com.Yingjie.springboot.modelTest;

import com.Yingjie.springboot.repositoryTest.BakeryController;
import com.Yingjie.springboot.model.Order;
import com.Yingjie.springboot.repository.BakeryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;



@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
    @Mock
    private BakeryRepository bakeryRepository;
    @InjectMocks
    private BakeryController bakeryController;

    @Test
    public void OrderDescriptionTest() {

        Order order = new Order("Fruit Cake", 15, 40.0, 55.0);

        String expect ="Fruit Cake";
        Assert.assertEquals(expect, order.getDescription());
    }
    @Test
    public void BakeryCategoryTest() {
        Order order = new Order("Fruit Cake", 15, 40.0, 55.0);

        Assert.assertEquals(15, order.getShipping(),0.01);
    }
    @Test
    public void BakeryPriceTest() {
        Order order = new Order("Fruit Cake", 15, 40.0, 55.0);

        Assert.assertEquals(40, order.getSubtotal(),0.01);
    }
}