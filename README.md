# Overview of My Bakery Web Application


In this tutorial, We will build a simple web application with Spring Boot. In this tutorial, we'll use Spring Boot for implementing a RESTful backend and test REST endpoint with RestTemplate.

## The Spring Boot Application

Our demo web applications's functionality will be pretty simplistic indeed. It will narrowed to fetching and displaying a List of JPA entities from an in-memory H2 database.

### Maven Dependencies

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

## Setting Up the H2 Database
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

## The JPA Entity Class
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

## The CakeRepository Interface
To quickly prototype our application’s domain layer, we will use spring feature, JDBCTemplate to help us execute sql statement.

```
public interface CakeRepository{
	Cake create(Cake cake);
	List<Cake> findAll();
	//some other methods
	}
```

## The CakeService Interface
The service layer is for implementing the business requirement of the application.

```
public interface CakeRepository{
	Cake create(Cake cake);
	List<Cake> findAll();
	
	//some other methods
	
	}
```

## The REST Controller
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

## The Junit test cases
Finally, let’s test our API endpoint with RestTemplate:

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

## Showing Some API endpoint testing result by Postman
After running our application, We can also view our data with Postman tool

Test the get all request:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanGet.png" alt="Get request" width="650"/>

Test the get item by id request:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanGetById.png" alt="Get request" width="650"/>

Test the Post request:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanPostMethod.png" alt="Get request" width="650"/>

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanTestPost.png" alt="Get request" width="650"/>


## Conclusion
In this article, we learned how to build a basic web application with Spring Boot.

