package com.program.dao;

import java.io.Serializable;
import java.util.List;

import com.program.entity.Brand;

public interface GenericDAO <T, K extends Serializable> {
	
	void insertOrUpdate (T entity);
	
	void delete (T entity);
	
	T findByName(String name);

	

}
