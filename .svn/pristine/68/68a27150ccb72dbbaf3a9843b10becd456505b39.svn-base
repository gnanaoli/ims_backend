package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.SubCategoryDto;

public interface CategoryService {
        
        String saveCategory(CategoryDto categoryDto,Principal principal) throws Exception;

        List<CategoryDto> getCategoryList(Principal principal);

        CategoryDto getCategory(String id, Principal principal);

        List<CategoryDto> getAllActiveCategoryList(Principal principal);

        List<SubCategoryDto> getSubCategoryByCategoryList(String categoryType);


        

}
