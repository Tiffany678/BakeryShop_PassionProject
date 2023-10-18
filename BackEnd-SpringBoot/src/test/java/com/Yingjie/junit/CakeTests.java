package com.Yingjie.junit;
import com.Yingjie.springboot.model.Cake;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CakeTests {
    @Test
    public void testCreateCake(){
        RestTemplate restTemplate = new RestTemplate();
        Cake cake= new Cake();
        cake.setTitle("Strawberry Cake");
        cake.setPrice(30.90);
        cake.setLimitedNum(5);
        cake.setInformation("This is the information about this cake");

        restTemplate.put("http://localhost:8080/cake",cake);

        System.out.println("Id: "+cake.getId()
                +"\nName: "+cake.getTitle()
                +"\nprice: "+cake.getPrice()
                +"\nMaximum number to order: "+cake.getLimitedNum()
                +"\nInformation: "+cake.getInformation()
                +"\n");
    }
    @Test
    public void testGetCake(){
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<List<Cake>> cakeResponse =restTemplate.exchange(
                "http://localhost:8080/cake", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Cake>>() {
                    });
        assertTrue(cakeResponse.getBody()!=null, "Body is null");
    }
    @Test
    public void testUpdate(){
        RestTemplate restTemplate= new RestTemplate();
        Cake cake = restTemplate.getForObject("http://localhost:8080/cake/{id}", Cake.class,1);
        cake.setTitle("Test Cake");
        restTemplate.put("http://localhost:8080/cake", cake);
        assertTrue(cake.getTitle().equals("Test Cake"));
        System.out.println("Id: "+cake.getId()
                +"\nName: "+cake.getTitle()
                +"\nprice: "+cake.getPrice()
                +"\nMaximum number to order: "+cake.getLimitedNum()
                +"\nInformation: "+cake.getInformation()
                +"\n");
    }
}
