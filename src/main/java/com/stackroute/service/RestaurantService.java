package com.stackroute.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.domain.Restaurant;

@Service
public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant restaurant);

	public String deleteRestaurant(int restaurantId);

	public Restaurant searchById(int restaurantId);

	public List<Restaurant> findAll();

	public List<Restaurant> findByCostOfTwo(BigDecimal costOfTwo);

	public String deleteByCostOfTwo(BigDecimal costOfTwo);

	public String deleteByRestaurantIdAndCostOfTwo(int restaurantId, BigDecimal costOfTwo);

}
