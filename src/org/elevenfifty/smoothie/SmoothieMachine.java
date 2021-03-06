package org.elevenfifty.smoothie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.elevenfifty.smoothie.beans.AbstractIngredient;
import org.elevenfifty.smoothie.beans.Additive;
import org.elevenfifty.smoothie.beans.Base;
import org.elevenfifty.smoothie.beans.Ingredient;
import org.elevenfifty.smoothie.beans.Produce;
import org.elevenfifty.smoothie.beans.Recipe;
import org.elevenfifty.smoothie.beans.RecipeIngredient;
import org.elevenfifty.smoothie.beans.RecipeIngredient.Unit;
import org.elevenfifty.smoothie.beans.Smoothie;

public class SmoothieMachine {
	public static enum Size {
		SMALL(1), MEDIUM(1.5), LARGE(2);

		double scale = 0;

		Size(double scale) {
			this.scale = scale;
		}

		public double getScale() {
			return scale;
		}
	};

	public static void main(String[] args) {
		// Gather user input for smoothie construction
		// TODO VALIDATE USER INPUT PROPERLY
		Size size = Size.valueOf(args[0]);
		int recipeId = Integer.valueOf(args[1]);

		// Load Ingredients
		Map<Integer, Ingredient> ingredients = getIngredients();
		System.out.println(ingredients);

		// Bring in recipes
		Map<Integer, Recipe> recipes = getRecipes(ingredients);
		System.out.println(recipes);

		// does recipe id exist in map?
		if (!recipes.containsKey(recipeId)) {
			// If not return fancy English error message
			throw new IllegalArgumentException("Recipe " + recipeId + " not found!");
		}

		// Makes the smoothies from a recipe and parameters
		Recipe r = recipes.get(recipeId);

		Smoothie smoothie = new Smoothie();
		smoothie.setCalories((int) Math.ceil(size.getScale() * r.calculateCalories()));
		smoothie.setWeight((int) Math.ceil(size.getScale() * r.calculateWeight()));
		smoothie.setPrice(size.getScale() * r.calculatePrice());
		smoothie.setSize(size);
		smoothie.setName(r.getName());

		// Print out smoothie information to enjoy

		System.out.println(smoothie);
	}

	private static Map<Integer, Ingredient> getIngredients() {
		// Open the File
		Map<Integer, Ingredient> ingredients = new HashMap<Integer, Ingredient>();
		BufferedReader reader = null;

		try {
			// Used BufferedReader, See Files.java in javadoc
			reader = new BufferedReader(new InputStreamReader(SmoothieMachine.class.getClassLoader().getResourceAsStream("produce.csv")));

			// Read the file
			String line = null;
			boolean firstLine = true;
			while ((line = reader.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
					// Skip the header row
					continue;
				}

				System.out.println(line);
				// Parse the data
				String[] columns = line.split(",");

				int pluCode = Integer.parseInt(columns[1]);
				int weight = Integer.parseInt(columns[4]);
				int calories = Integer.parseInt(columns[5]);
				double price = Double.parseDouble(columns[3].trim().substring(1));

				// Translate parsed data to object
				AbstractIngredient ai;

				if ("Produce".equalsIgnoreCase(columns[0])) {
					ai = new Produce();

				} else if ("Base".equalsIgnoreCase(columns[0])) {
					ai = new Base();

				} else if ("Additive".equalsIgnoreCase(columns[0])) {
					ai = new Additive();

				} else {
					// Ignore unknown types
					System.out.println("Unknown Ingredient [" + columns[0] + "]");
					continue;
				}

				ai.setPluCode(pluCode);
				ai.setPrice(price);
				ai.setName(columns[2]);
				ai.setWeight(weight);
				ai.setCalories(calories);
				ingredients.put(pluCode, ai);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Finally close the file
			IOUtils.closeQuietly(reader);
		}

		// Return Ingredients
		return ingredients;
	}

	private static Map<Integer, Recipe> getRecipes(Map<Integer, Ingredient> ingredients) {
		// Open the File
		Map<Integer, Recipe> recipes = new HashMap<Integer, Recipe>();
		BufferedReader reader = null;

		try {
			// Used BufferedReader, See Files.java in javadoc
			reader = new BufferedReader(new InputStreamReader(SmoothieMachine.class.getClassLoader().getResourceAsStream("recipe.csv")));

			// Read the file
			String line = null;
			Recipe r = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

				// Parse the data
				String[] columns = line.split(",");
				int numColumns = columns.length;

				if (numColumns == 2) {
					r = new Recipe(columns[1], Integer.valueOf(columns[0]));

				} else if (numColumns == 3) {
					int pluCode = Integer.parseInt(columns[2]);

					Ingredient ing = ingredients.get(pluCode);

					r.addRecipeIngredient(new RecipeIngredient(ing, Integer.valueOf(columns[0]), Unit.valueOf(columns[1])));

				} else if (numColumns <= 1) {

					recipes.put(r.getId(), r);

				}
			}

			if (r != null && !recipes.containsKey(r.getId())) {
				recipes.put(r.getId(), r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Finally close the file
			IOUtils.closeQuietly(reader);
		}

		// Return Ingredients
		return recipes;
	}
}
