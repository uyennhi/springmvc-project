package com.program.dao;

import java.util.List;

import com.program.dao.GenericDAO;
import com.program.entity.Brand;

public interface IBrandDAO extends GenericDAO<Brand, Integer>{

	List<String> getAllBrandName();

}
