package com.program.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.program.entity.Brand;

@Repository("brandRepository")
public interface BrandRepository extends JpaRepository<Brand, Integer>{

	Brand findByBrandName(String brandName);
	
	@Query("SELECT b.brandName FROM Brand b")
	List<String> getAllBrandName();
}
