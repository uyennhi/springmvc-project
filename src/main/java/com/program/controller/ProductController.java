package com.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.program.entity.Product;
import com.program.service.IProductService;
import com.program.utility.Constrains;
import com.program.utility.PageModel;
import com.program.utility.ResponseModel;
import com.program.utility.SearchModel;


@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService productService;

	/**
	 * Get products by pageable
	 * 
	 * @param page
	 * @param searchModel
	 * @return PageModel<Product>
	 */
	@PostMapping(value = "/general/get-products", params = { "page" })
	public PageModel<Product> getProductsByPageable(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestBody SearchModel searchModel) {
		return productService.getProductsByPageable(searchModel, PageRequest.of(page, Constrains.PAGE_SIZE), page);
	}

	/**
	 * Check if the product already exists
	 * 
	 * @param productName
	 * @return boolean
	 */
	@GetMapping(value = "/general/is-exist-product-name/{productName}")
	public boolean isExistProductName(@PathVariable("productName") String productName) {
		return productService.isExistProductName(productName);
	}

	/**
	 * Insert Product
	 * 
	 * @param Product
	 * @return ResponseModel
	 */
	@PostMapping(value = "/admin/insert-product")
	public ResponseModel insertProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}

	/**
	 * Update Product
	 * 
	 * @param Product
	 * @return ResponseModel
	 */
	@PutMapping(value = "/admin/update-product")
	public ResponseModel updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	/**
	 * Delete Product
	 * 
	 * @param Product
	 * @return ResponseModel
	 */
	@PostMapping(value = "/admin/delete-product")
	public ResponseModel deleteProduct(@RequestBody Product product) {
		return productService.deleteProduct(product);
	}
}