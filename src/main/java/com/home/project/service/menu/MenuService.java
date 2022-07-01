package com.home.project.service.menu;

import java.util.List;
/**
 * Defines the methods associated with the Menu operations 
 * (relation of meals and week)
 * 
 * @author Sergio de la Torre
 * @version 1.0
 * @since 2022-07-01
 */
public interface MenuService {
	
	/**
	 * Returns a list of meal names of the type that are available on an specific date
	 * @param date
	 * 			specific date
	 * @param type
	 * 			type of meal	
	 */
	public List<String> searchByDateAndType(String date, String type);

}
