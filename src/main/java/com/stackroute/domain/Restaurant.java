package com.stackroute.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Document
public class Restaurant {

	//
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	private int restaurantId;
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String restaurantName;
	private String restaurantLocation;
	private BigDecimal costOfTwo;

	public String getRestuarantName() {
		return restaurantName;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restuarantId) {
		this.restaurantId = restuarantId;
	}

	public void setRestaurantName(String restuarantName) {
		this.restaurantName = restuarantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocaton(String restaurantLocation) {
		this.restaurantLocation = getRestaurantLocation();
	}

	public BigDecimal getCostOfTwo() {
		return costOfTwo;
	}

	public void setCostOfTwo(BigDecimal costOfTwo) {
		this.costOfTwo = costOfTwo;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", id=" + id + ", restaurantName=" + restaurantName
				+ ", restaurantLocation=" + restaurantLocation + ", costOfTwo=" + costOfTwo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costOfTwo == null) ? 0 : costOfTwo.hashCode());
		result = prime * result + restaurantId;
		result = prime * result + ((restaurantLocation == null) ? 0 : restaurantLocation.hashCode());
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
		if (restaurantLocation == null) {
			if (other.restaurantLocation != null)
				return false;
		} else if (!restaurantLocation.equals(other.restaurantLocation))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}

}
