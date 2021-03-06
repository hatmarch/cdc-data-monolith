package org.mhildenb.cdcdemo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product  {

	private String itemId;
	private String name;
	private String desc;
	private double price;

	public Product() {

	}

	public Product(String itemId, String name, String desc, double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

    @Override
	public String toString() {
		return "Product [itemId=" + itemId + ", name=" + name + ", desc="
				+ desc + ", price=" + price + "]";
	}

	public static Product createFromCdc(RowData cdcRowData) {

		var retProd = new Product ();
		retProd.itemId = cdcRowData.getItemId().toString();
		retProd.desc = cdcRowData.getDescription();
		retProd.name = cdcRowData.getItemName();
		retProd.price = Double.parseDouble(cdcRowData.getPrice());

		return retProd;
	}



}
