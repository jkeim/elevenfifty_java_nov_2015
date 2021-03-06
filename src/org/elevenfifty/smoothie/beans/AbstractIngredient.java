package org.elevenfifty.smoothie.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class AbstractIngredient implements Ingredient {

	protected int pluCode;
	protected String name;
	protected int weight; // grams
	protected int calories;
	protected double price;

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
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.pluCode, rhs.pluCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.pluCode).toHashCode();
	}

	//Updated by Jeff Roberg added Calories, price and Weight on 11/12/2015
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " : " + this.name + " (" + this.pluCode + ")" + "Calories " + this.calories + " Price " + this.price + " Weight " + this.weight;
	}
	
	public int getPluCode() {
		return pluCode;
	}

	public void setPluCode(int pluCode) {
		this.pluCode = pluCode;
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
