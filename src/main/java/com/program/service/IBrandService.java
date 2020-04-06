package com.program.service;

import java.util.List;

import com.program.entity.Brand;
import com.program.utility.ResponseModel;

public interface IBrandService {

	ResponseModel insertBrand(Brand brand);

	ResponseModel updateBrand(Brand brand);

	ResponseModel deleteBrand(Brand brand);

	Brand findBrandByName(String brandName);

	List<String> getAllBrandName();
}
