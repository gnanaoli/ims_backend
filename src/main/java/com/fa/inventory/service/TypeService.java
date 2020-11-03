package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.TypeDto;

public interface TypeService {

	List<TypeDto> getTypeList(Principal principal);

}
