package org.elevenfifty.smoothie.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Produce extends AbstractIngredient implements Ingredient, Comparable<Produce> {

	public Produce() {

	}

	public Produce(int pluCode, String name, int calories, double price, int weight) {
		this.pluCode = pluCode;
		this.calories = calories;
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString() + " = " + "Calories " + calories + "; Price " + price + "; Weight " + weight + ";";

	}

	// public static void main(String[] arg) {
	// Produce proObject = new Produce(1, "tomato", "vegetable", .11, 1);
	// Produce proObject2 = new Produce(1, "kale", "veggie", .10, 2);
	//
	// System.out.println(proObject.toString());
	// System.out.println(proObject2.toString());
	// }

	// Could be type enum with fruit and vegetable?
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
