package com.program.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.program.dao.IBrandDAO;
import com.program.dao.repository.BrandRepository;
import com.program.entity.Brand;

@Repository("brandDao")
@Transactional
public class BrandDAOImpl implements IBrandDAO {
	@Autowired
	private BrandRepository brandRepository;

	

	/**
	 * Insert Brand
	 * 
	 * @param BrandEntity
	 */
	@Override
	public void insertOrUpdate(Brand entity) {
		brandRepository.save(entity);
	}

	/**
	 * Delete Brand
	 * 
	 * @param BrandEntity
	 */
	@Override
	public void delete(Brand entity) {
		brandRepository.delete(entity);
	}

	/**
	 * Get All Brand name
	 * 
	 * @return List<String> BrandName
	 */
	@Override
	public List<String> getAllBrandName() {
		return brandRepository.getAllBrandName();
	}

	/**
	 * Find brand by brand name
	 * 
	 * @param brandName
	 * @return Brand
	 */
	@Override
	public Brand findByName(String brandName) {
		return brandRepository.findByBrandName(brandName);
	}
}
