package org.elevenfifty.smoothie.beans;

public class Additive {
	public static enum Category {
		PROTEIN, NUTRIENT, ENERGY, ANTIOXIDANT
	};

	private String name;
	private Category category;
	private double price;
	private int weight;
	private boolean organic = false;
	private int calories;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Additive) {
			Additive add = (Additive) obj;
			try {
				return this.name.equalsIgnoreCase(add.getName());
			} catch (NullPointerException npe) {
				npe.printStackTrace();
				// Check to see if the other object has a null value for name.
				// If both null they are equal
				return add.getName() == null;
			}
		} else {
			return false;
		}
	}
	

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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isOrganic() {
		return organic;
	}

	public void setOrganic(boolean organic) {
		this.organic = organic;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
}
