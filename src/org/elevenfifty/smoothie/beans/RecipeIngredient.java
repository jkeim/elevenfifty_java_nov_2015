package org.elevenfifty.smoothie.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class RecipeIngredient {
	public static enum Unit {
		TEASPOON, TABLESPOON, CUP, HALF, WHOLE
	};

	// TODO Variable for Unit type
	private Ingredient ingredient;
	private int quantity;
	private Unit unit;

	// TODO Add a Constructor

	// TODO Remove Setters 

	// HashCode, Equals

	// TODO toString

// Constructor	
	public RecipeIngredient(Ingredient ingredient, int quantity, Unit unit) {
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.unit = unit;
	}

// Equals	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		RecipeIngredient rhs = (RecipeIngredient) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.ingredient, rhs.ingredient).isEquals();
	}
	
// hashCode	
	@Override
	public int hashCode() {
		return this.ingredient.hashCode();
	}

// toString
	@Override
	public String toString() {
		return "This recipe requires" + quantity + unit + "of" + ingredient;
		
	}

// getters
	public Ingredient getIngredient() {
		return ingredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public Unit getUnit() {
		return unit;
	}

}
