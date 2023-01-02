
package com.Yingjie.springboot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.security.test.context.support.WithMockUser;

import com.Yingjie.springboot.model.Bakery;
import com.Yingjie.springboot.controller.BakeryController;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;






@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BakeryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // @InjectMocks
    // private  HelloResource helloResource;

    @Before
    public void setUp() throws Exception {
        // mockMvc = MockMvcBuilders.standaloneSetup(helloResource)
        //           .build();
    }


    @Test
    public void getCakeInfo() throws Exception {

        //Mockito.when(bakeryController.getCakeById(1)).thenReturn(bakery);
        String expected = "{\"id\": 1,\"title\": \"Fruit Cake\",\"price\": 40.0,\"count\": 3,\"inInterest\": true,\"category\": \"Fruits\",\"information\": \"Fruit Cake\"}";

        System.out.println(expected);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/bakery/1");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //System.out.println(result.getResponse());
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}