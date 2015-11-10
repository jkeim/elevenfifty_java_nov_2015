package org.elevenfifty.smoothie.beans;

public class RecipeIngredient {
	public static enum Unit {
		TEASPOON, TABLESPOON, CUP, HALF, WHOLE
	};
	
	private Ingredient ingredient;
	private int quantity;
	
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
