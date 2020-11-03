ims.controller('ScrapCreationController',function($scope,$http,InsertService,FetchService) {
	
	$scope.isDisabled=true;

	
	FetchService.getAllToolsScrapMove().then(function(response){
		
		console.log("Scrap Tools"+JSON.stringify(response));
		$scope.scrap_master=response.inventoryEntranceItemDto;
		
	});
	

	$scope.view_scrap_details = function(scrap_details)
	{
		//alert(JSON.stringify(scrap_details));
		console.log("request====>"+JSON.stringify(scrap_details));
		
     	$scope.scrap_moveDto = {"quantity" : scrap_details.quantity,"comments":"","move_quantity":"","fromLocation":scrap_details.location,"warehouseSiteName":scrap_details.site}
		
     	$scope.scrap_moveDto.subCategory = {"subCategory":scrap_details.subCategory};
     	
     	$scope.scrap_moveDto.category= {"categoryType" : scrap_details.categoryType};
     	
     	$scope.scrap_moveDto.inventoryEntrance= {"modelCode" : scrap_details.modelCode};
     
     	
//		$scope.scrap_moveDto.categorytype = scrap_details.categoryType;
//		$scope.scrap_moveDto.sub_category = scrap_details.subCategory;
//		$scope.scrap_moveDto.quantity = scrap_details.quantity;
     	
     	
     	//alert(JSON.stringify($scope.scrap_moveDto));
		
	}
	

	$scope.movescrap = function()
	{
		
		if ($scope.move_Scrap.$valid && $scope.isDisabled) {
			$scope.isDisabled=false;			
		
		$scope.isDisabled=false;	
		
		//alert(JSON.stringify($scope.scrap_moveDto));
		
		InsertService.savemoveScrap($scope.scrap_moveDto).then(function(response)
    			{
			if(response.message=='success')
				{
				swal(
						 'Good job!',
	                     'You clicked the button!',
	                     'success'
	                       ).then(function(isConfirm) {
	                   		if (isConfirm) {
	                   			//location.href="common?link=SupplierManagement";
	                   			location.reload();
	                  		}
	                       });
				}

    			});
		}
	}
	
	
});