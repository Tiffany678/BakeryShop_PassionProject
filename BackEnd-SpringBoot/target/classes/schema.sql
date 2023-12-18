CREATE SCHEMA IF NOT EXISTS spring6jdbc3;

SET SCHEMA spring6jdbc3;

drop table cake;
drop table orders;

Create Table IF NOT EXISTS cake(
                       id long not null auto_increment,
                       Title Varchar(100) not null,
                       Price double,
                       inventory int,
                       information varchar(255),
                       imageUrl varchar(255),
                       category varchar (100),
                       PRIMARY	KEY (id)
);

Create Table IF NOT EXISTS orders(
                       orderId long not null AUTO_INCREMENT,
                       orderdate DATE,
                       description varchar(255),
                       shipping double,
                       subtotal double,
                       total double,
                       Primary key(orderId)
);