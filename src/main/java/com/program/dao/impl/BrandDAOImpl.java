package com.program.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.program.utility.PageModel;
import com.program.dao.IBrandDAO;
import com.program.dao.repository.BrandRepository;
import com.program.entity.Brand;

@Repository("brandDao")
@Transactional
public class BrandDAOImpl implements IBrandDAO {
	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private EntityManager em;
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
	
	@Override
	public PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Brand> cq = cb.createQuery(Brand.class);
		Root<Brand> brand = cq.from(Brand.class);
		cq.select(brand);

		// Condition if searching by brand name
		if (brandName != "") {
			Predicate name = cb.like(brand.get("brandName"), "%" + brandName + "%");
			cq.where(name);
		}

		TypedQuery<Brand> query = em.createQuery(cq);

		// Set pageable
		int totalPage = (query.getResultList().size() - 1) / pageable.getPageSize() + 1;
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());

		PageModel<Brand> result = new PageModel<Brand>(query.getResultList(), pageable, totalPage, currentPage);

		return result;
	}
}
