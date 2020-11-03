ims.controller('FindToolController',function($scope,$http,FetchService,$filter,InsertService) {
	$scope.toolsDtoList=[];
	$scope.inventoryEntranceDtoList=[];
	
	
	$scope.findToolsRequestDto = {
		  "searchKeyword":""
		}
	
	
	$scope.getSubCategoryByCategory=function(categoryType)
	{
		
		FetchService.getSubCategoryByCategory(categoryType).then(function(response){
			
			$scope.subCategoryMasterDtoList=response;
		});
	}
	
	
	$scope.ValidateCategoryType=function(categoryType)
	{
		var newTemp= $filter("filter")($scope.categoryMasterDtoList, {categoryType:categoryType});	
		if(!newTemp.length>0)
			{
			console.log("error not found");		
			}
		else{
			$scope.getSubCategoryByCategory(newTemp[0].categoryType);	
			
		}
	}
	
	
	$scope.ValidateSubCategoryType=function(subcategory)
	{

     	
     	var subCategoryy = $filter("filter")($scope.subCategoryMasterDtoList, {subCategory:subcategory});
		
		if(!subCategoryy.length>0)
			{			
			console.log("sub error not found");
 			}
	}
	
	
	$scope.Search = function(){
		if ($scope.findTools.$valid) {
			//alert($scope.findTools.$valid);
		console.log("findToolsRequestDto"+JSON.stringify($scope.findToolsRequestDto));
		
		FetchService.findTools($scope.findToolsRequestDto).then(function(response)
				{
					   
			    	   $scope.inventoryEntranceDtoList=response;
			    	   
			    	   if($scope.inventoryEntranceDtoList.length > 0)
			    		   {
			    		   $scope.searchtools = true;
			    		   }
			    	   
				});
	}
	}
	
	
	
	
	
	FetchService.getAllCategoryTypes().then(function(response){
		
		//console.log(response);
		
		$scope.categoryMasterDtoList=response;
	});
	$scope.requestTools = function(inventoryManagementDto) {
				$('<form method="POST" action="RequestTools" id="test"><input type="hidden" name="id" value="'+inventoryManagementDto.id+'"><input type="hidden" name="location" value="'+inventoryManagementDto.location+'"><input type="hidden" name="categoryType" value="'+inventoryManagementDto.categoryType+'"><input type="hidden" name="subCategory" value="'+inventoryManagementDto.subCategory+'"> <input type="hidden" name="modelCode" value="'+inventoryManagementDto.modelCode+'"> <input type="hidden" name="quantity" value="'+inventoryManagementDto.quantity+'"><input type="hidden" name="site" value="'+inventoryManagementDto.site+'"></form>').appendTo('body').submit();
	}
	
	
	
	
});