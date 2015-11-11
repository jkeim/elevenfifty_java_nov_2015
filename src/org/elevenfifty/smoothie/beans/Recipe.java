package org.elevenfifty.smoothie.beans;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

	private List<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
	private String name;
	private int id;

	public Recipe(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: ");
		builder.append(id);
		builder.append(", Name: ");
		builder.append(this.name);
		builder.append(", Ingredients: ");
		builder.append(ingredients);

		return builder.toString();
	}

	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public void addRecipeIngredient(RecipeIngredient ri) {
		this.ingredients.add(ri);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
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
