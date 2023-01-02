package com.Yingjie.springboot.model;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.Yingjie.springboot.model.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid")
    private Long id;
    @Column(name = "orderdate")
    private Date date;
    @Column(name = "description")
    private String description;
    @Column(name = "shipping")
    private double shipping;
    @Column(name = "subtotal")
    private double subtotal;
    @Column(name = "total")
    private double total;


    public Order (){}

    public Order(String description, double shipping, double subtotal, double total) {
        this.date = new Date();
        this.description = description;
        this.shipping = shipping;
        this.subtotal = subtotal;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", shoppingCost=" + shipping +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }
}
