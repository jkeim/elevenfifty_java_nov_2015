package org.elevenfifty.smoothie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.elevenfifty.smoothie.beans.AbstractIngredient;
import org.elevenfifty.smoothie.beans.Additive;
import org.elevenfifty.smoothie.beans.Base;
import org.elevenfifty.smoothie.beans.Ingredient;
import org.elevenfifty.smoothie.beans.Produce;
import org.elevenfifty.smoothie.beans.Recipe;

public class SmoothieMachine {

	public static void main(String[] args) {
		// Load Ingredients
		List<Ingredient> ingredients = getIngredients();
		System.out.println(ingredients);

		// Bring in recipes

		// Gather user input for smoothie construction

		// Makes the smoothies from a recipe and parameters

		// Print out smoothie information to enjoy
	}

	private static List<Ingredient> getIngredients() {
		// Open the File
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
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
				ingredients.add(ai);

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

	private static List<Recipe> getRecipes(List<Ingredient> ingredients) {
		// Open the File
		// SmoothieMachine.class.getClassLoader().getResourceAsStream("recipe.csv")

		// Read the file

		// Parse the data

		// Translate parsed data to object with ingredients!

		// Finally close the file

		// Return Recipe
		return null;
	}

}
