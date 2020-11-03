package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.BulkRequestResponseDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.entity.SubCategory;

public interface SubCategoryService {
	
	List<SubCategoryDto> getAllSubCategoryDtoList();
	
	SubCategoryDto mapSubCategoryDto(SubCategory subCategory);

	BulkRequestResponseDto findAllTools(Principal principal);

	List<SubCategoryDto> getSubCategoryList(Principal principal);

	String saveSubCategory(SubCategoryDto subCategoryDto, Principal principal) throws Exception;
	
	
}
