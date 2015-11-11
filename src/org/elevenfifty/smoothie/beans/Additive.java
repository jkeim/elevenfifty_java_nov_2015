package org.elevenfifty.smoothie.beans;

public class Additive extends AbstractIngredient {
	public static enum Category {
		PROTEIN, NUTRIENT, ENERGY, ANTIOXIDANT, FILLER
	};

	private Category category;
	private boolean organic = false;
	private boolean fdaApproved = false;

	// @Override
	// public String toString() {
	// return "Additive [toString()=" + super.toString() + "]";
	// }

	@Override
	public String toString() {
		return super.toString() + ""; // fdaApproved?
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isOrganic() {
		return organic;
	}

	public void setOrganic(boolean organic) {
		this.organic = organic;
	}

	public boolean isFdaApproved() {
		return fdaApproved;
	}

	public void setFdaApproved(boolean fdaApproved) {
		this.fdaApproved = fdaApproved;
	}

}
