package org.elevenfifty.smoothie.beans;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Additive extends AbstractIngredient {
	public static enum Category {
		PROTEIN, NUTRIENT, ENERGY, ANTIOXIDANT
	};

	private Category category;
	private boolean organic = false;
	private boolean fdaApproved = false;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Additive) {
			Additive add = (Additive) obj;
			try {
				return this.name.equalsIgnoreCase(add.getName());
			} catch (NullPointerException npe) {
				npe.printStackTrace();
				// Check to see if the other object has a null value for name.
				// If both null they are equal
				return add.getName() == null;
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).toHashCode();
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
