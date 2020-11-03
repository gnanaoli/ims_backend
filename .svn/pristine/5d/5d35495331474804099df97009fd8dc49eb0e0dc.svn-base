package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.TypeDto;
import com.fa.inventory.entity.Category;
import com.fa.inventory.entity.Type;
import com.fa.inventory.repository.TypeRepository;
import com.fa.inventory.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

private Logger logger = Logger.getLogger(getClass());

@Resource
TypeRepository TypeRepository;

@Resource
TypeService TypeService;

/*FOR CATEGORY DROPDOWN*/

@Override
public List<TypeDto> getTypeList(Principal principal) {
        List<TypeDto> typeDtoList = null;
        logger.info("<--CategoryServiceImpl-------------getcategoryList--------------------started-->");
        try {
                List<Type> typeList=TypeRepository.findAll();
                
                if(typeList!=null && !typeList.isEmpty())
                {
                	typeDtoList=new ArrayList<>();
                        for(int i=0;i<typeList.size();i++)
                        {
                                Type type=typeList.get(i);
                                TypeDto typeDto=new TypeDto();
                                if(type!=null)
                                {
                                	typeDto.setId(type.getId());
                                	typeDto.setType(type.getType());
                                	//typeDtoList.add(MapCategoryDto(category,principal));
                                	typeDtoList.add(typeDto);
                                }
                        }
                }
                
        } catch (Exception e) {
                e.printStackTrace();
        }
        logger.info("<--CategoryServiceImpl-------------getcategoryList--------------------Ended-->");
        return typeDtoList;
}

}
