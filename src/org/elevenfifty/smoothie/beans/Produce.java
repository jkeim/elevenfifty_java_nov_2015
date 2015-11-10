package org.elevenfifty.smoothie.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Produce implements Ingredient, Comparable<Produce> {

	public static void main(String[] arg) {
		Produce tomato = new Produce();
		tomato.setCalories(2);
		tomato.name = "tomato";
		tomato.type = "Vegetable";
		tomato.price = 0.11;
		tomato.weight = 1;

		Produce kale = new Produce();
		kale.calories = 3;
		kale.name = "kale";
		kale.type = "Vegetable";
		kale.price = .12;
		kale.weight = 1;

		Produce apple = new Produce();
		apple.calories = 4;
		apple.name = "apple";
		apple.type = "Fruit";
		apple.price = .10;
		apple.weight = 1;

		// System.out.println(apple.calories + "equals the calories count for
		// apple");
	}

	private int calories;
	private String name;
	private String type;
	private double price;
	private int weight;

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		Produce rhs = (Produce) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.name, rhs.name).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).toHashCode();
	}

	@Override
	public int compareTo(Produce produce) {
		// return (int) this.price - (int) produce.getPrice();
		return this.name.compareToIgnoreCase(produce.getName());
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
