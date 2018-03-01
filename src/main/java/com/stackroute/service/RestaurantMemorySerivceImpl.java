package com.stackroute.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.stackroute.domain.Restaurant;

public class RestaurantMemorySerivceImpl implements RestaurantService {

	List<Restaurant> restaurants = new ArrayList<Restaurant>();

	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurants.add(restaurant);
		return restaurant;
	}

	public List<Restaurant> findAll() {
		return restaurants;
	}

	@Override
	public String deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant searchById(int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> findByCostOfTwo(BigDecimal costOfTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByCostOfTwo(BigDecimal costOfTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByRestaurantIdAndCostOfTwo(int restaurantId, BigDecimal costOfTwo) {
		// TODO Auto-generated method stub
		return null;
	}

}
