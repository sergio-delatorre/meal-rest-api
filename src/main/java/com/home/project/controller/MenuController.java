package com.home.project.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.project.exception.ResourceNotFoundException;
import com.home.project.service.menu.MenuService;

/**
 * Receive requests related to Menu operations
 * <p>
 * Includes the following operations
 * <ul>
 * 	<li>Search of menu of meals available for specific date and type
 * </ul>
 * 
 * @author Sergio de la Torre
 * @version 1.0
 * @since 2022-07-01
 */
@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	/**
	 * Returns a list of meal names searched by: 
	 * @param date
	 * 			specific date
	 * @param type
	 * 			type of meal
	 * @return	list of meal names
	 * 			{@link List<String>}
	 */
	@GetMapping("/{date}/{type}")
	public List<String> getMenuOfMealsAvailable(
			@Valid @PathVariable @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", 
				message = "Date should be on format yyyy-MM-dd") String date,
			@Valid @PathVariable @Size(min = 2, max = 32) String type) {

		List<String> availableMeals = menuService.searchByDateAndType(date, type);

		if (availableMeals.isEmpty())
			throw new ResourceNotFoundException("No meals available");

		return availableMeals;
	}

}
