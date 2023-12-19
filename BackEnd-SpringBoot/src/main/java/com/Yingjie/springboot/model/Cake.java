package com.Yingjie.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "cake")
public class Cake {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name = "title")
		private String title;
		@Column(name = "price")
		private double price;
		@Column(name = "inventory")
		private int inventory;
		@Column(name = "information")
		private String information;

		@Column(name = "imageUrl")
		private String imageUrl;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name ="category")
		private String category;


	public Cake() {

	}

	public Cake(int id, String title, double price, int inventory, String information, String imageUrl, String category) {
		this.id =id;
		this.title = title;
		this.price = price;
		this.inventory = inventory;
		this.information = information;
		this.imageUrl = imageUrl;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}


	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	public String getImageUrl() {return imageUrl;}

	public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
}

