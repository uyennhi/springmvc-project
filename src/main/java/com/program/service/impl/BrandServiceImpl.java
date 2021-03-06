package com.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.program.service.IBrandService;
import com.program.utility.PageModel;
import com.program.dao.IBrandDAO;
import com.program.entity.Brand;
import com.program.utility.Constrains;
import com.program.utility.ResponseModel;

@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	IBrandDAO brandDao;
	

	/**
	 * Insert Brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel insertBrand(Brand brand) {
		brandDao.insertOrUpdate(brand);
		return new ResponseModel(HttpStatus.OK, Constrains.INSERT_BRAND_SUCCESSFUL);
	}

	/**
	 * Update Brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel updateBrand(Brand brand) {
		brandDao.insertOrUpdate(brand);
		return new ResponseModel(HttpStatus.OK, Constrains.UPDATE_BRAND_SUCCESSFUL);
	}

	/**
	 * Delete Brand
	 * 
	 * @param brand
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel deleteBrand(Brand brand) {
		brandDao.delete(brand);
		return new ResponseModel(HttpStatus.OK, Constrains.DELETE_BRAND_SUCCESSFUL);
	}

	/**
	 * Get Brand name
	 * 
	 * @return List<String>
	 */
	@Override
	public List<String> getAllBrandName() {
		return brandDao.getAllBrandName();
	}
	
	
	
	@Override
	public Brand findBrandByName(String brandName) {
		return brandDao.findByName(brandName);
	}

	@Override
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub
		return brandDao.getBrands();
	}

	@Override
	public List<Brand> getListBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage) {
		return brandDao.getBrandsByPageable(brandName, pageable, currentPage);
	}

}
