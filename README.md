# 1. Overview of My Full Stack Bakery Web Application


In this tutorial, We will build a simple web application with Spring Boot. In this tutorial, we'll use Spring Boot for implementing a RESTful backend and test REST endpoint with RestTemplate.

## 2. The Spring Boot Application

Our demo web application's functionality will be pretty simplistic indeed. It will narrow to fetching and displaying a List of JPA entities from an in-memory H2 database.

### 2.1 The Maven Dependencies

Below are the required Dependencies for the pom.xml

These are the Spring Boot dependencies:
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
</dependency>
```
And finally - the Junit and RestTemplate:
```
<dependency>
	<groupId>org.junit.platform</groupId>
	<artifactId>junit-platform-launcher</artifactId>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```
We can also use [Spring Initializr](https://start.spring.io/) to quickly set up the project with needed dependencies.

## 2.2 Setting Up the H2 Database
We will use the H2 localhost database with Spring Boot. This is the property setting on the _src/main/resources/application.properties_.

```
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.datasource.url=jdbc:h2:file:./data/spring6jdbc3
spring.sql.init.mode=always
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## 2.3 The JPA Entity Class
To quickly prototype our application’s domain layer, let’s define a simple JPA entity class, which will be responsible for modelling cake:

```
@Entity
@Table(name = "cake")
public class Cake {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "title")
	private String title;
	
	//some other fields, standard constructors / setters / getters
}	
```

## 2.4 The CakeRepository Interface
To quickly prototype our application’s domain layer, we will use spring feature, JDBCTemplate to help us execute sql statement.

```
public interface CakeRepository{
	Cake create(Cake cake);
	List<Cake> findAll();
	//some other methods
	}
```

## 2.5 The CakeService Interface
The service layer is for implementing the business requirement of the application.

```
public interface CakeRepository{
	Cake create(Cake cake);
	List<Cake> findAll();
	//some other methods
	
	}
```

## 2.6 The REST Controller
Now let’s implement the REST API. In this case, it’s just a simple REST controller:

```
@RestController
public class CakeController {

    // standard constructors
    
	private CakeService cakeService;

	@PostMapping("/cake")
	public Cake createCake(@RequestBody Cake cake){
		return cakeService.create(cake);
	}
	//Some other operation methods
}
```

## 2.7 The Junit test cases
The RestTemplate object helps us test the Rest API end point.
let’s write some unit test cases and test some methods.

```
public class CakeTests {
    
    @Test
    void testGetACake() {
        RestTemplate restTemplate = new RestTemplate();

        Cake cake= restTemplate.getForObject("http://localhost:8080/cake/{id}", Cake.class, 1);

        System.out.println(cake.getTitle());
    }
	//Some other Junit test cases
}
```

## 2.8 Showing Some API endpoint testing result by Postman
After running our application, We can also view our data with Postman tool

Test the get all request:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/Postman_GetCake.png" alt="Get request" width="650"/>


## 3. The Angular Application
After our Spring Boot application up and running, we are ready to retrieve data from backend.

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/Frontend_productList1.png" alt="Angular product list" width="650"/>

## Conclusion
In this article, we learned how to build a basic web application with Spring Boot and Angular.

