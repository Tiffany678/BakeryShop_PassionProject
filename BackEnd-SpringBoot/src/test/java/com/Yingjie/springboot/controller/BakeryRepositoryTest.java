
package com.Yingjie.springboot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.Yingjie.springboot.model.Bakery;
import com.Yingjie.springboot.repository.BakeryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BakeryRepositoryTest {
    @Mock
    private BakeryRepository bakeryRepository;

    @InjectMocks
    private BakeryController bakeryController;
@Test
    public void bakeryRepository_returnAllBakeryTest(){
    List<Bakery> bakeries = new ArrayList<>();
    Bakery bakery = new Bakery("Fruit Cake", 40.0, 2, true,"Fruit","Fruit Cake");
    bakeries.add(bakery);

    given(bakeryRepository.findAll()).willReturn(bakeries);
    List<Bakery> expected = bakeryController.getAllCakes();
    assertEquals(expected, bakeries);
    verify(bakeryRepository).findAll();
}
    @Test
    public void bakeryRepository_getCakeByIDTest(){
        List<Bakery> bakeries = new ArrayList<>();
        Bakery bakery = new Bakery("Fruit Cake", 40.0, 2, true,"Fruit","Fruit Cake");
        bakery.setId(1L);
        bakeries.add(bakery);

        given(bakeryRepository.findByInInterest(true)).willReturn(bakeries);
        List<Bakery> expected = bakeryRepository.findByInInterest(true);
        assertEquals(expected, bakeries);
    }

    @Test
    public void bakeryRepository_findByTitleTest(){
        List<Bakery> bakeries = new ArrayList<>();
        Bakery bakery = new Bakery("Fruit Cake", 40.0, 2, true,"Fruit","Fruit Cake");
        bakery.setId(1L);
        bakeries.add(bakery);

        given(bakeryRepository.findByTitle("Fruit Cake")).willReturn(bakery);
        Bakery expected = bakeryRepository.findByTitle("Fruit Cake");
        assertEquals(expected, bakery);
    }
}