package com.stackroute.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.stackroute.configuration.RepositoryConfiguration;
import com.stackroute.domain.Restaurant;
import com.stackroute.repository.RestaurantRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { RepositoryConfiguration.class })
public class RestaurantRepositoryTests {

	RestaurantRepository restaurantRepository;

	@Autowired
	public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	List<Restaurant> restaurants = new ArrayList<Restaurant>();

	@Before
	public void setUp() {
		if (restaurantRepository.count() == 0) {
			Restaurant restaurant = new Restaurant();
			String jsonStr = "{\"restaurantName\":\"The Black Pearl\",\"restaurantLoc\":\"Kormangala\",\"costOfTwo\":\"1200.00\"}";

			Gson gson = new Gson();
			restaurant = gson.fromJson(jsonStr, Restaurant.class);
			restaurants.add(restaurant);

			jsonStr = "{\"restaurantName\":\"Echoes\",\"restaurantLoc\":\"Kormangala\",\"costOfTwo\":\"2400.00\"}";

			restaurant = gson.fromJson(jsonStr, Restaurant.class);
			restaurants.add(restaurant);
			restaurantRepository.save(restaurants.get(0));
			restaurantRepository.save(restaurants.get(1));
			System.out.println("before " + restaurants);
		}
		// System.out.println(restaurants);
	}

	@Test
	public final void testFindByCostOfTwo() {

		List<Restaurant> restaurantsCopyForCostOfTwo = new ArrayList<Restaurant>();

		for (Restaurant restaurant : restaurants) {
			if (restaurant.getCostOfTwo().compareTo(new BigDecimal(1200.00)) == 0) {
				restaurantsCopyForCostOfTwo.add(restaurant);
			}
		}

		System.out.println("find costoftwo" + restaurants);

		assertEquals(restaurantsCopyForCostOfTwo, restaurantRepository.findByCostOfTwo(new BigDecimal(1200.00)));

	}

	@Test
	public final void testAddNewRestaurantSaveS() {

		// Arrange
		Restaurant restaurant;
		String jsonStr = "{\"restaurantName\":\"The Black Pearl\",\"restaurantLoc\":\"Kormangala\",\"costOfTwo\":\"1200.00\"}";
		Gson gson = new Gson();
		restaurant = gson.fromJson(jsonStr, Restaurant.class);

		// Act
		long rowCount = restaurantRepository.count();
		restaurantRepository.save(restaurant);

		long newRowCount = restaurantRepository.count();
		restaurants.add(restaurant);

		System.out.println("add " + restaurants);

		// Assert
		assertEquals("New Restaurant Added!", newRowCount, rowCount + 1);

	}

	@Test
	public final void testFindOne() {

		// Arrange
		Restaurant restaurant;
		String jsonStr = "{\"restaurantId\":\"1\",\"restaurantName\":\"The Black Pearl\",\"restaurantLoc\":\"Kormangala\",\"costOfTwo\":\"1200.00\"}";
		Gson gson = new Gson();
		restaurant = gson.fromJson(jsonStr, Restaurant.class);
		restaurant.setRestaurantId(1);
		restaurantRepository.save(restaurant);
		System.out.println("find one" + restaurants);
		// System.out.println(restaurantRepository.findAll());
		assertEquals("Restaurant Not Found", restaurant, restaurantRepository.findOne(1));

	}

	@Test
	public final void testFindAll() {
		System.out.println("find all" + restaurants);
		assertEquals(restaurants, restaurantRepository.findAll());

	}

	@Test
	public final void testDeleteID() {

		// Arrange

		// Act
		long rowCount = restaurantRepository.count();
		restaurants.remove(restaurantRepository.findOne(0));
		restaurantRepository.delete(0);
		long newRowCount = restaurantRepository.count();

		System.out.println("add " + restaurants);

		// Assert
		assertEquals("Restaurant Deleted!", newRowCount, rowCount - 1);

		System.out.println("delete " + restaurants);
		//

	}

}
