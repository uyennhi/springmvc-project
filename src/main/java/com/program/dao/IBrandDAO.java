package com.program.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.program.utility.PageModel;
import com.program.dao.GenericDAO;
import com.program.entity.Brand;

public interface IBrandDAO extends GenericDAO<Brand, Integer>{

	List<String> getAllBrandName();
	
	List<Brand> getBrands();
	
	PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage);

}
