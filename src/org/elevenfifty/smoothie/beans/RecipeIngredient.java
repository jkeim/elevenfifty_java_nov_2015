package org.elevenfifty.smoothie.beans;

public class RecipeIngredient {
	public static enum Unit {
		TEASPOON, TABLESPOON, CUP, HALF, WHOLE
	};

	// TODO Variable for Unit type
	private Ingredient ingredient;
	private int quantity;

	// TODO Add a Constructor

	// TODO Remove Setters

	// HashCode, Equals

	// TODO toString

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
