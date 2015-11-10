package org.elevenfifty.smoothie.beans;

public class Produce implements Comparable<Produce> {

	private int calories;
	private String name;
	private String type;
	private double price;
	private int weight;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Produce) {
			Produce pro = (Produce) obj;
			try {
				return this.name.equalsIgnoreCase(pro.getName());
			} catch (NullPointerException npe) {
				npe.printStackTrace();
				// Check to see if the other object has a null value for name.
				// If both null they are equal
				return pro.getName() == null;
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
