package com.Yingjie.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "cake")
public class   Cake {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name = "title")
		private String title;
		@Column(name = "price")
		private double price;
		@Column(name = "limitedNum")
		private int limitedNum;
		@Column(name = "information")
		private String information;

		@Column(name = "imageUrl")
		private String imageUrl;

	public Cake() {

	}

	public Cake(int id, String title, double price, int limitedNum, String information, String imageUrl) {
		this.id =id;
		this.title = title;
		this.price = price;
		this.limitedNum = limitedNum;
		this.information = information;
		this.imageUrl = imageUrl;
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

	public int getLimitedNum() {
		return limitedNum;
	}

	public void setLimitedNum(int count) {
		this.limitedNum = count;
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

