# Overview of My Bakery Web Application


In this tutorial, I'll implement a simple e-commerce application. I'll develop an API using Spring Boot and a client application that will consume the API using React.

Basically, the user will be able to add/remove products from a shopping cart/ favorite page, increasing/ decreasing item counts and to place an order.

## Backend Part

To develop the API, I use the latest version of Spring Boot. I also use JPA and Mysql for the persistence side of things.


### Maven Dependencies

Below are the required Dependencies for the pom.xml

These are the Spring Boot dependencies:
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Then, the H2 database:

```
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
</dependency>
```

And finally - the Jackson library:

```
<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>2.9.6</version>
</dependency>
```

We can also use [Spring Initializr](https://start.spring.io/) to quickly set up the project with needed dependencies.

## Setting Up the MySQL Database
We will use Mysql localhost database with Spring Boot. This is the property setting on the _src/main/resources/application.properties_.

```
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.datasource.url=jdbc:h2:file:./data/spring6jdbc3
spring.sql.init.mode=always
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## Postman testing for API endpoint

Test the get request with Postman:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanGet.png" alt="Get request" width="650"/>

Test the get by id requst:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanGetById.png" alt="Get request" width="650"/>

Test the Post requst:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanPostMethod.png" alt="Get request" width="650"/>

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/PostmanTestPost.png" alt="Get request" width="650"/>


## Conclusion
In this article, I created a simple e-commerce application. I created an API on the backend using Spring Boot and then consumed it in the frontend application made in React. It demonstrates how to make the components, make them communicate with each other and retrieve/send data from/to the API.




