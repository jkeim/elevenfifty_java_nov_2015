package org.elevenfifty.smoothie.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class RecipeIngredient {
	public static enum Unit {
		TEASPOON, TABLESPOON, CUP, HALF, WHOLE
	};

	private Ingredient ingredient;
	private int quantity;
	private Unit unit;

	public RecipeIngredient(Ingredient ingredient, int quantity, Unit unit) {
		if (ingredient == null) {
			throw new IllegalArgumentException("Cannot have a null ingredient");
		}

		
		if (quantity <= 0) {
			throw new IllegalArgumentException("Cannot have a quantity of 0 or less");
		}
		
		if (unit == null) {
	    	throw new IllegalArgumentException("Cannot have a null unit");
	    }
		
		
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.unit = unit;
	}

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

	@Override
	public int hashCode() {
		return this.ingredient.hashCode();
	}

	@Override
	public String toString() {
		return quantity + " " + unit + " of " + ingredient;
	}

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
