package com.Yingjie.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "bakery")
public class Bakery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
		private Long id;
		@Column(name = "title")
		private String title;
		@Column(name = "price")
		private double price;
		@Column(name = "count")
		private int count;
		@Column(name = "inInterest")
		private boolean inInterest;
		@Column(name = "category")
		private String category;
		@Column(name = "information")
		private String information;


	public Bakery() {

	}

	public Bakery( String title, double price, int count, boolean inInterest, String category, String information) {
		this.title = title;
		this.price = price;
		this.count = count;
		this.inInterest = inInterest;
		this.category = category;
		this.information = information;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isInInterest() {
		return inInterest;
	}

	public void setInInterest(boolean inInterest) {
		this.inInterest = inInterest;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	//public int getItemCount(Long id){ return this.count;}
}

