package com.Yingjie.springboot.controllerTest;

import com.Yingjie.springboot.controller.BakeryController;
import com.Yingjie.springboot.model.Bakery;
import com.Yingjie.springboot.repository.BakeryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BakeryControllerTest {
    @Mock
    private BakeryRepository bakeryRepository;

    @InjectMocks
    private BakeryController bakeryController;

    @Test
    public void bakeryControllerTest_whenGetMethod()
            throws Exception {
        List<Bakery> bakeries = new ArrayList<>();
        Bakery bakery = new Bakery("Fruit Cake", 40.0, 2, true,"Fruit","Fruit Cake");
        bakery.setId(1L);
        bakeries.add(bakery);

        given(bakeryController.getAllCakes()).willReturn(bakeries);
        Assert.assertEquals(bakeryController.getAllCakes(), bakeries);
    }
}