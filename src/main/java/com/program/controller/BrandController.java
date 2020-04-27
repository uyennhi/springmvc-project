package com.program.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.program.utility.Constrains;
import com.program.utility.PageModel;
import com.program.utility.ResponseModel;
import com.program.entity.Brand;
import com.program.service.IBrandService;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	IBrandService brandService;
	
	@GetMapping(value = "/general/get-brands", params = { "page", "name" })
	public PageModel<Brand> getBrandsByPageable(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "name") String name) {
		return brandService.getBrandsByPageable(name, PageRequest.of(page, Constrains.PAGE_SIZE), page);
	}

	/**
	 * Find Brand by brand name
	 * 
	 * @param brandName
	 * @return Brand
	 */
	@GetMapping(value = "/general/find-brand-by-name/{brandName}")
	public Brand findBrandByBrandName(@PathVariable("brandName") String brandName) {
		return brandService.findBrandByName(brandName);
	}

	/**
	 * Get all brand name
	 * 
	 * @return List<String>
	 */
	@GetMapping(value = "/general/get-all-brand-name")
	public List<String> getAllBrandName() {
		return brandService.getAllBrandName();
	}

	/**
	 * Insert Brand
	 * 
	 * @param Brand
	 * @return ResponseModel
	 */
	@PostMapping(value = "/admin/insert-brand")
	public ResponseModel insertBrand(@RequestBody Brand brand) {
		return brandService.insertBrand(brand);
	}

	/**
	 * Update Brand
	 * 
	 * @param Brand
	 * @return ResponseModel
	 */
	@PutMapping(value = "/admin/update-brand")
	public ResponseModel updateBrand(@RequestBody Brand brand) {
		return brandService.updateBrand(brand);
	}

	/**
	 * Delete Brand
	 * 
	 * @param Brand
	 * @return ResponseModel
	 */
	@PostMapping(value = "/admin/delete-brand")
	public ResponseModel deleteBrand(@RequestBody Brand brand) {
		return brandService.deleteBrand(brand);
	}
	
	
	
	
	
	
	
	@GetMapping(value = "/general/get-all-brand")
	public List<Brand> getBrands() {
		return brandService.getBrands();
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam(name = "logoName") String logoName) {
		String originalFileName = file.getOriginalFilename();
		File destinationFile = new File("D:\\opt\\pilot\\images/"+ logoName);
		
		try {
			file.transferTo(destinationFile);
			System.out.println("File name:" + originalFileName);
			System.out.println("File path:" + destinationFile.getPath());
			System.out.println("File size:" + file.getSize());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ResponseEntity(destinationFile.getPath(), HttpStatus.CREATED);
	}
	

}
