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

	
	@Override
	
	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}
	@Override
	public void insertOrUpdate(Brand entity) {
		brandRepository.save(entity);
	}


	@Override
	public void delete(Brand entity) {
		brandRepository.delete(entity);
	}


	@Override
	public List<String> getAllBrandName() {
		return brandRepository.getAllBrandName();
	}

	@Override
	public Brand findByName(String brandName) {
		return brandRepository.findByBrandName(brandName);
	}
}
