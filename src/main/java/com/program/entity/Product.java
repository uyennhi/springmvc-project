package com.program.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.program.entity.Brand;
import com.program.utility.JsonDateSerializer;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private Double price;

	@Column(name = "sale_date")
	@Temporal(TemporalType.DATE)
	private Date saleDate;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Brand brandEntity;

	public Product() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getSaleDate() {
		return saleDate;
	}


	@JsonSerialize(using = JsonDateSerializer.class)
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brand getBrandEntity() {
		return brandEntity;
	}

	public void setBrandEntity(Brand brandEntity) {
		this.brandEntity = brandEntity;
	}
}