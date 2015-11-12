package org.elevenfifty.smoothie.beans;

import org.elevenfifty.smoothie.SmoothieMachine.Size;

public class Smoothie {
	private String name;
	private Size size;
	private int calories;
	private int weight;
	private double price;

	@Override
	public String toString() {
		return size.name() + " " + this.name + " [" + this.calories + ", " + this.weight + "] for $" + this.price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Size getSize() {
		return size;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSize(Size size) {
		this.size = size;
	}
}
