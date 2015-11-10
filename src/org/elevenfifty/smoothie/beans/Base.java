package org.elevenfifty.smoothie.beans;

public class Base {

	private String name;
	private int weight; // grams
	private int calories;
	private double price;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Base) {
			Base base = (Base) obj;
			try {
				return this.name.equalsIgnoreCase(base.getName());
			} catch (NullPointerException npe) {
				npe.printStackTrace();
				// Check to see if the other object has a null value for name.
				// If both null they are equal
				return base.getName() == null;
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.name.toLowerCase().hashCode();
	}

	@Override
	public String toString() {
		return this.name;
	}

	public int compareTo(Base base) {
		// return (int) this.price - (int) base.getPrice();
		return this.name.compareToIgnoreCase(base.getName());
	}

	public static void main(String args[]) {
		Integer x = 5;

		System.out.println(x.toString());
		System.out.println(Integer.toString(12));
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
