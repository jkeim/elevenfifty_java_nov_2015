package org.elevenfifty.smoothie.beans;

public abstract class AbstractIngredient implements Ingredient {

	protected String name;
	protected int weight; // grams
	protected int calories;
	protected double price;

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " + this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
