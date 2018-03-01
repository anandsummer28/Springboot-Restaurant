package com.stackroute.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.domain.Restaurant;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {

	public List<Restaurant> findByCostOfTwo(BigDecimal costOfTwo);

	public void deleteByCostOfTwo(BigDecimal costOfTwo);

	public void deleteByRestaurantIdAndCostOfTwo(int restaurantId, BigDecimal costOfTwo);
}
