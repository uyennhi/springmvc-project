package com.program.service;

import org.springframework.data.domain.Pageable;

import com.program.entity.Product;
import com.program.utility.PageModel;
import com.program.utility.ResponseModel;
import com.program.utility.SearchModel;


public interface IProductService {

	/**
	 * Insert product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	ResponseModel insertProduct(Product product);

	/**
	 * Update product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	ResponseModel updateProduct(Product product);

	/**
	 * Delete product
	 * 
	 * @param product
	 * @return ResponseModel
	 */
	ResponseModel deleteProduct(Product product);

	/**
	 * Check product already exists
	 * 
	 * @param productName
	 * @return boolean
	 */
	boolean isExistProductName(String productName);

	/**
	 * Get products by pageable
	 * 
	 * @param searchModel
	 * @param pageable
	 * @return PageModel<Product>
	 */
	PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage);
}