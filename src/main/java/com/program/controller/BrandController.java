package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.entity.Brand;
import com.program.service.IBrandService;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	IBrandService brandService;
	
	@GetMapping(value = "/general/get-all-brand-name")
	public List<String> getAllBrandName() {
		return brandService.getAllBrandName();
	}

}
