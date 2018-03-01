package com.stackroute.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.domain.Restaurant;
import com.stackroute.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	RestaurantRepository restaurantRepository;

	@Autowired
	public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {

		// try {
		restaurantRepository.save(restaurant);
		return restaurant;
		// } catch (RestaurantException rex) {
		// throw new RestaurantException("Restaurant already exist");// , rex,
		// ErrorCode.)
		// }
	}

	public String deleteRestaurant(int restaurantId) {
		restaurantRepository.delete(restaurantId);
		return "Restaurant deleted";
	}

	public Restaurant searchById(int restaurantId) {
		return restaurantRepository.findOne(restaurantId);

	}

	public List<Restaurant> findAll() {
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	public List<Restaurant> findByCostOfTwo(BigDecimal costOfTwo) {
		return (List<Restaurant>) restaurantRepository.findByCostOfTwo(costOfTwo);
	}

	public String deleteByCostOfTwo(BigDecimal costOfTwo) {
		restaurantRepository.deleteByCostOfTwo(costOfTwo);
		return "Restauruants deleted";
	}

	@Override
	public String deleteByRestaurantIdAndCostOfTwo(int restaurantId, BigDecimal costOfTwo) {
		restaurantRepository.deleteByRestaurantIdAndCostOfTwo(restaurantId, costOfTwo);
		return "Restauruants deleted";
	}

}
