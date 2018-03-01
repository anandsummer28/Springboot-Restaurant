package com.stackroute.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.domain.Restaurant;
import com.stackroute.properties.ApplicationProperties;
import com.stackroute.service.RestaurantService;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {

	ApplicationProperties applicationProperties;

	@Autowired
	public void setApplicationProperties(ApplicationProperties applicationProperties) {
		this.applicationProperties = applicationProperties;
	}

	RestaurantService restaurantService;

	@Autowired
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {

		// System.out.println(applicationProperties.getHost() + " " +
		// applicationProperties.getPort() + " "
		// + applicationProperties.getDatabase());

		applicationProperties.method();

		Restaurant addedRestaurant = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(addedRestaurant, HttpStatus.CREATED);
	}

	@DeleteMapping("/restaurant/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") int restaurantId) {
		String message = restaurantService.deleteRestaurant(restaurantId);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<Restaurant> searchById(@PathVariable int restaurantId) {
		Restaurant addedRestaurant = restaurantService.searchById(restaurantId);
		return new ResponseEntity<Restaurant>(addedRestaurant, HttpStatus.OK);

	}

	@RequestMapping(value = "/restaurant")
	public ResponseEntity<List<Restaurant>> findAll() {
		List<Restaurant> restaurants = restaurantService.findAll();
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
	}

	@RequestMapping(value = "/restaurant/costOfTwo/{costOfTwo}")
	public ResponseEntity<List<Restaurant>> findByCostOfTwo(@PathVariable BigDecimal costOfTwo) {
		List<Restaurant> restaurants = restaurantService.findByCostOfTwo(costOfTwo);
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
	}

	@DeleteMapping(value = "/restaurant/cot/{costOfTwo}")
	public ResponseEntity<String> deleteByCostOfTwo(@PathVariable BigDecimal costOfTwo) {
		String message = restaurantService.deleteByCostOfTwo(costOfTwo);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@DeleteMapping(value = "/restaurant/idcot/{restaurantId}&{costOfTwo}") // ,
																			// params
																			// =
																			// "restaurantId",
																			// params
																			// =
																			// "costOfTwo")
	public ResponseEntity<String> deleteByRestaurantIdAndCostOfTwo(@RequestParam int restaurantId,
			@RequestParam BigDecimal costOfTwo) {
		String message = restaurantService.deleteByRestaurantIdAndCostOfTwo(restaurantId, costOfTwo);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
