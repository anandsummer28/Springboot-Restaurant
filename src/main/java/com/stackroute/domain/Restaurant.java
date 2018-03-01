package com.stackroute.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Document(collection = "Restaurant")
public class Restaurant {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurantId;
	private String restaurantName;
	private String restaurantLoc;
	private BigDecimal costOfTwo;

	public BigDecimal getCostOfTwo() {
		return costOfTwo;
	}

	public void setCostOfTwo(BigDecimal costOfTwo) {
		this.costOfTwo = costOfTwo;
	}

	public String getRestaurantLoc() {
		return restaurantLoc;
	}

	public void setRestaurantLoc(String restaurantLoc) {
		this.restaurantLoc = restaurantLoc;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", restaurantLoc="
				+ restaurantLoc + ", costOfTwo=" + costOfTwo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costOfTwo == null) ? 0 : costOfTwo.hashCode());
		result = prime * result + restaurantId;
		result = prime * result + ((restaurantLoc == null) ? 0 : restaurantLoc.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (costOfTwo == null) {
			if (other.costOfTwo != null)
				return false;
		} else if (!costOfTwo.equals(other.costOfTwo))
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		if (restaurantLoc == null) {
			if (other.restaurantLoc != null)
				return false;
		} else if (!restaurantLoc.equals(other.restaurantLoc))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}

}
