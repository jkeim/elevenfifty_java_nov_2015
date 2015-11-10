package org.elevenfifty.smoothie.beans;


public class Additive {
	public static enum Category {PROTEIN, NUTRIENT, ENERGY, ANTIOXIDANT};
	private String name;
	private Category category;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
