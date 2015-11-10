package org.elevenfifty.smoothie.beans;

import java.util.List;

public class Recipe {

	private final List<RecipeIngredient> ingredients;

	public Recipe(List<RecipeIngredient> ingredients) {
		super();
		this.ingredients = ingredients;
	}

	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public double calculatePrice() {
		double total = 0d;

		for (RecipeIngredient i : ingredients) {
			total += i.getQuantity() * i.getIngredient().getPrice();
		}

		return total;
	}

	public int calculateCalories() {
		int total = 0;

		for (RecipeIngredient i : ingredients) {
			total += i.getQuantity() * i.getIngredient().getCalories();
		}

		return total;
	}

	public int calculateWeight() {
		int total = 0;

		for (RecipeIngredient i : ingredients) {
			total += i.getQuantity() * i.getIngredient().getWeight();
		}

		return total;
	}
}
