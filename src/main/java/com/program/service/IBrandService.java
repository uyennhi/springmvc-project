package com.program.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.program.utility.PageModel;
import com.program.entity.Brand;
import com.program.utility.ResponseModel;

public interface IBrandService {
	
	List<Brand> getListBrand();

	ResponseModel insertBrand(Brand brand);

	ResponseModel updateBrand(Brand brand);

	ResponseModel deleteBrand(Brand brand);

	Brand findBrandByName(String brandName);

	List<String> getAllBrandName();
	
	List<Brand> getBrands();
	
	PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage);
}
