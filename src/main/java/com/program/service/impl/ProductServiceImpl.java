package com.program.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.program.dao.IProductDAO;
import com.program.entity.Product;
import com.program.service.IProductService;
import com.program.utility.Constrains;
import com.program.utility.PageModel;
import com.program.utility.ResponseModel;
import com.program.utility.SearchModel;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDAO productDao;

	/**
	 * Insert Product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel insertProduct(Product product) {
		productDao.insertOrUpdate(product);
		return new ResponseModel(HttpStatus.OK, Constrains.INSERT_PRODUCT_SUCCESSFUL);
	}

	/**
	 * Update Product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel updateProduct(Product product) {
		productDao.insertOrUpdate(product);
		return new ResponseModel(HttpStatus.OK, Constrains.UPDATE_PRODUCT_SUCCESSFUL);
	}

	/**
	 * Delete Product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	@Override
	public ResponseModel deleteProduct(Product product) {
		productDao.delete(product);
		return new ResponseModel(HttpStatus.OK, Constrains.DELETE_PRODUCT_SUCCESSFUL);
	}

	/**
	 * Check exist product name
	 * 
	 * @param productName
	 * @return boolean
	 */
	@Override
	public boolean isExistProductName(String productName) {
		Product product = productDao.findByName(productName);
		return (product != null) ? true : false;
	}

	/**
	 * Get products by pageable
	 * 
	 * @param searchModel
	 * @param pageable
	 * @return PageModel<Product>
	 */
	@Override
	public PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage) {
		return productDao.getProductsByPageable(searchModel, pageable, currentPage);
	}
}