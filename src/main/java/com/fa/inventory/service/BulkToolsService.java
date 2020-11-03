package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.ResponseDto;

public interface BulkToolsService {

	ResponseDto saveBulkRequest(List<CategoryDto> categoryDtoList,Principal principal);
	

}
