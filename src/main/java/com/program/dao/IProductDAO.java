package com.program.dao;

import org.springframework.data.domain.Pageable;

import com.program.entity.Product;
import com.program.utility.PageModel;
import com.program.utility.SearchModel;


public interface IProductDAO extends GenericDAO<Product, Integer> {


	PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage);
}