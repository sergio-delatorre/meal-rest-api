package com.home.project.service.menu;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.project.mapper.MenuMapper;

/**
 * Executes the logic associated with the Menu operations
 *
 * @author Sergio de la Torre
 * @version 1.0
 * @since 2022-07-01
 */
@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired 
	MenuMapper menuMapper;

	@Override
	public List<String> searchByDateAndType(String date, String type) {
		return menuMapper.searchByDateAndType(date, type)
				.stream()
				.map(meal->meal.getName())
				.collect(Collectors.toList());
	}

}
