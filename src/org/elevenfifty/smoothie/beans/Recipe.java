package org.elevenfifty.smoothie.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {
	
	private List<Object> ingredients = new ArrayList<Object>();
		
	
	public List<Object> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Object> ingredients) {
		this.ingredients = ingredients;
	}
	

}
