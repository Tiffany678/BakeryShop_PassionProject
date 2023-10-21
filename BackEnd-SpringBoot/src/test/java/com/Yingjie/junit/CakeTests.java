package com.Yingjie.junit;

import com.Yingjie.springboot.model.Cake;
import com.Yingjie.springboot.repository.util.CakeRowMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CakeTests {
    @Test
    void testGetACake() {
        RestTemplate restTemplate = new RestTemplate();

        Cake cake= restTemplate.getForObject("http://localhost:8080/cake/{id}", Cake.class, 1);

        System.out.println(cake.getTitle());
    }

    @Test
    public void testGetAllCake(){
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<List<Cake>> cakeResponse =restTemplate.exchange(
                "http://localhost:8080/cake", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Cake>>() {
                });
        assertTrue(cakeResponse.getBody()!=null, "Body is null");

        List<Cake> cakes = cakeResponse.getBody();
        for(Cake cake: cakes){
            System.out.println("Id: "+cake.getId()
                    +"\nName: "+cake.getTitle()
                    +"\nprice: "+cake.getPrice()
                    +"\nMaximum number to order: "+cake.getLimitedNum()
                    +"\nInformation: "+cake.getInformation()
                    +"\n");
        }

    }
    @Test
    public void testCreateCake(){
        RestTemplate restTemplate = new RestTemplate();
        Cake cake= new Cake();
        cake.setTitle("Create a Strawberry Cake");
        cake.setPrice(30.90);
        cake.setLimitedNum(5);
        cake.setInformation("This is the information about this cake");

        restTemplate.postForObject("http://localhost:8080/cake",cake, Cake.class);
        System.out.println("Id: "+cake.getId()
                +"\nName: "+cake.getTitle()
                +"\nprice: "+cake.getPrice()
                +"\nMaximum number to order: "+cake.getLimitedNum()
                +"\nInformation: "+cake.getInformation()
                +"\n");
    }
    @Test
    public void testUpdateCake(){
        RestTemplate restTemplate= new RestTemplate();
        Cake cake = restTemplate.getForObject("http://localhost:8080/cake/{id}", Cake.class,1);

        cake.setInformation("Update a Cake");
        restTemplate.put("http://localhost:8080/cake", cake);

        assertTrue(cake.getInformation().equals("Update a Cake"));

        System.out.println("Id: "+cake.getId()
                +"\nName: "+cake.getTitle()
                +"\nprice: "+cake.getPrice()
                +"\nMaximum number to order: "+cake.getLimitedNum()
                +"\nInformation: "+cake.getInformation()
                +"\n");
    }
    @Test
    public void testDeleteCake(){

        testGetAllCake();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/cake/delete/{id}",1);
        testGetAllCake();
    }
    @Test
    void testException() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getForObject("http://localhost:8080/cake/test", Cake.class);

    }
}
