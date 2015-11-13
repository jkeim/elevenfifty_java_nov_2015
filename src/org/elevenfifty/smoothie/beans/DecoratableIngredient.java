package org.elevenfifty.smoothie.beans;

public class DecoratableIngredient {

	private final DecoratableIngredient decoratee;
	private final Ingredient ingredient;

	public DecoratableIngredient(Ingredient ingredient) {
		super();
		this.ingredient = ingredient;
		this.decoratee = null;
	}

	public DecoratableIngredient(Ingredient ingredient, DecoratableIngredient decoratee) {
		super();
		this.ingredient = ingredient;
		this.decoratee = decoratee;
	}

	public double calculatePrice() {
		return this.ingredient.getPrice() + (this.decoratee == null ? 0d : this.decoratee.calculatePrice());
	}

	public int calculateWeight() {
		return this.ingredient.getWeight() + (this.decoratee == null ? 0 : this.decoratee.calculateWeight());
	}

	public int calculateCalories() {
		return this.ingredient.getCalories() + (this.decoratee == null ? 0 : this.decoratee.calculateCalories());
	}

	public String toString() {
		return this.ingredient.getName() + (this.decoratee == null ? "" : ", " + this.decoratee.toString());
	}

}
