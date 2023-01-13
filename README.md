# Overview of My Bakery Web Application


In this tutorial, I'll implement a simple e-commerce application. I'll develop an API using Spring Boot and a client application that will consume the API using React.

Basically, the user will be able to add/remove products from a shopping cart/ favorite page, increasing/ decreasing item counts and to place an order.

## Backend Part

To develop the API, I use the latest version of Spring Boot. I also use JPA and Mysql for the persistence side of things.


## Maven Dependencies

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

Then, the Mysql database:

```
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
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

We can also use Spring Initializr to quickly set up the project with needed dependencies.

## Setting Up the MySQL Database
We will use Mysql localhost database with Spring Boot. This is the property setting on the src/main/resources/application.properties.

```
server.port=8080
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.datasource.url= jdbc:mysql://localhost:3306/zipcode?useSSL=false
spring.datasource.username= YourUserName
spring.datasource.password= YourPassword
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto= update
```

## Frontend
Now that we have our Spring Boot application built up, it's time to move the React part of the project. To do so, we'll first have to install Node.js with NPM.

# Setting Up the React Project
It sets up your development environment so that you can use the latest JavaScript features, provides a nice developer experience, and optimizes your app for production.

```
npx create-react-app FrontEnd-react-client
cd FrontEnd-react-client
```

When you’re ready to deploy to production, running
```
npm start
```

## Components and Models
Before we start creating the components for our application, let's first check out how our app will actually look like:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/HomePage.png" alt="Home Page" width="650"/>

Check-out page:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/CheckOutPage.png" alt="Check out Page" width="650"/>

### Orders
After users successfully purchase their cakes, it will update our inventory and send order information to the backend database.
All the cakes are having 6 counts in inventory.

<img height="200" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/MySQl_Inventory.png" alt="SQL Inventory" width="650"/>

As shown in the example below, the count of the #2 cake was updated to 5 from 6.
The count of #3 cake was update to 3 from 6;

<img height="200" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/MySQL_CheckOut.png" alt="SQL Inventory update" width="650"/>

The order information is stored in the database.

<img height="100" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/MySQL_Orders.png" alt="SQL Orders" width="650"/>

## Conclusion
In this article, we created a simple e-commerce application. We created an API on the backend using Spring Boot and then we consumed it in our frontend application made in React. We demonstrated how to make the components we need, make them communicate with each other and retrieve/send data from/to the API.




