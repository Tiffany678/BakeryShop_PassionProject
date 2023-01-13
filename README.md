
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

And finallly - the Jackson library:

```
<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>2.9.6</version>
</dependency>
```
We've used Spring Initializr to quickly set up the project with needed dependencies.



# Welcome to my passion project, A Sweet Bakery Web application
This web app is user-friendly that it is simple and easy to navigate. 
The following are user features:    <br />
    > Search for cakes              <br />
    > Add to favorite               <br />
    > View Cake details             <br />
    > Check-out                     <br />


#Demo
Home page:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/HomePage.png" alt="Home Page" width="650"/>

Check-out page:

<img height="500" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/CheckOutPage.png" alt="Check out Page" width="650"/>

# Business Layer

After users successfully purchase their cakes, it will update our inventory and send order information to the backend database.
All the cakes are having 6 counts in inventory.

<img height="200" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/MySQl_Inventory.png" alt="SQL Inventory" width="650"/>

As shown in the example below, the count of the #2 cake was updated to 5 from 6.
The count of #3 cake was update to 3 from 6;

<img height="200" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/MySQL_CheckOut.png" alt="SQL Inventory update" width="650"/>

The order information is stored in the database.

<img height="100" src="https://github.com/Tiffany678/BakeryShop_PassionProject/blob/main/Images/MySQL_Orders.png" alt="SQL Orders" width="650"/>
