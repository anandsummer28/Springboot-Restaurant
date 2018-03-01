package com.stackroute.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Restaurant;
import com.stackroute.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	RestaurantRepository restaurantRepostory;

	@Autowired
	public void setRestaurantRepostory(RestaurantRepository restaurantRepostory) {
		this.restaurantRepostory = restaurantRepostory;
	}

	public Restaurant addrestaurant(Restaurant restaurant) {
		restaurantRepostory.save(restaurant);
		return restaurant;
	}

	public String deleteRestaurant(int restaurantId) {
		restaurantRepostory.deleteByRestaurantId(restaurantId);

		return "restaurant deleted";

	}

	public Restaurant searchById(int restaurantID) {

		Restaurant restaurant = restaurantRepostory.findByRestaurantId(restaurantID);
		return restaurant;
	}

	public List<Restaurant> findAll() {

		return (List<Restaurant>) restaurantRepostory.findAll();

	}

	@Override
	public List<Restaurant> findByCostOfTwo(BigDecimal costOfTwo) {
		return (List<Restaurant>) restaurantRepostory.findAllByCostOfTwo(costOfTwo);
	}
}
