package org.elevenfifty.smoothie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elevenfifty.smoothie.beans.BaseIngredient;
import org.elevenfifty.smoothie.beans.Ingredient;
import org.elevenfifty.smoothie.beans.Recipe;
import org.elevenfifty.smoothie.beans.RecipeIngredient;
import org.elevenfifty.smoothie.beans.RecipeIngredient.Unit;
import org.elevenfifty.smoothie.beans.Smoothie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

	private static final ObjectMapper jsonMapper = new ObjectMapper();

	public static void main(String[] args) {
		Size size;
		int recipeId;
		if(args.length == 0){
			System.out.println("You did not specify a drink. Would you lik to try a sample of our best seller?");
			size = Size.LARGE;
			recipeId = 2;
		}else{
		size = Size.valueOf(args[0]);
		
		recipeId = Integer.valueOf(args[1]);}

		// Load Ingredients
		Map<Integer, Ingredient> ingredients = getIngredients();
		System.out.println(ingredients.size() + " Ingredients Found");

		// Bring in recipes
		Map<Integer, Recipe> recipes = getRecipes(ingredients);
		System.out.println(recipes.size() + " Recipes Found");

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

	// TODO Convert the ingredients data and parsing to JSON
	private static Map<Integer, Ingredient> getIngredients() {
		// Open the File
		Map<Integer, Ingredient> ingredients = new HashMap<Integer, Ingredient>();

		try {
			// Used BufferedReader, See Files.java in javadoc
			// reader = new BufferedReader(new
			// InputStreamReader(SmoothieMachine.class.getClassLoader().getResourceAsStream("produce.csv")));

			List<Ingredient> listIng = jsonMapper.readValue(SmoothieMachine.class.getClassLoader().getResourceAsStream("ingredients.json"), new TypeReference<List<BaseIngredient>>() {
			});

			for (Ingredient i : listIng) {
				ingredients.put(i.getPluCode(), i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return Ingredients
		return ingredients;
	}

	private static Map<Integer, Recipe> getRecipes(Map<Integer, Ingredient> ingredients) {
		Map<Integer, Recipe> recipes = new HashMap<Integer, Recipe>();

		try {
			JsonNode data = jsonMapper.readTree(SmoothieMachine.class.getClassLoader().getResourceAsStream("recipe.json"));

			ArrayNode allRecipeData = (ArrayNode) data.get("recipes");

			// TODO Error handling within loop!
			for (int i = 0; i < allRecipeData.size(); i++) {
				ObjectNode recipeData = (ObjectNode) allRecipeData.get(i);
				try {

					// Convert into Recipe Object
					Recipe r = new Recipe(recipeData.get("name").asText(), recipeData.get("id").asInt());

					ArrayNode allIngredientData = (ArrayNode) recipeData.get("ingredients");

					for (int j = 0; j < allIngredientData.size(); j++) {
						ObjectNode ingredientData = (ObjectNode) allIngredientData.get(j);

						Ingredient ing = null;
						if (ingredients.containsKey(ingredientData.get("pluCode").asInt())) {
							ing = ingredients.get(ingredientData.get("pluCode").asInt());
						} else {
							throw new IllegalArgumentException("Couldn't find ingredient " + ingredientData.get("pluCode").asInt());
						}
						Unit unit = Unit.valueOf(ingredientData.get("unit").asText());
						int quantity = ingredientData.get("qty").asInt();

						r.addRecipeIngredient(new RecipeIngredient(ing, quantity, unit));
					}

					// Add the recipe to the map!
					recipes.put(r.getId(), r);
				} catch (Exception e) {
					System.out.println("Failed to handle recipe " + recipeData.get("id").asInt());
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return Ingredients
		return recipes;
	}
}
