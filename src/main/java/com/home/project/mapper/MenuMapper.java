package com.home.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.home.project.model.response.MealResponse;

@Mapper
public interface MenuMapper {
	
	public List<MealResponse> searchByDateAndType(String date, String type);
	
}
