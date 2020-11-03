ims.controller('subCategoryManagementController',function($scope,$http,FetchService,$filter,InsertService,DTOptionsBuilder,$location,UrlConstants,$timeout) {
	$scope.subCategoryDtoList=[];
	
	$scope.subCategoryDto={};
	
	$scope.subCategoryMgt = true;
	
	
	$scope.saveSubCategory = function()
	{
		if($scope.new_subcategory.$valid||$scope.addsubcategory.$valid)
		{
		InsertService.saveSubCategory($scope.subCategoryDto).then(function(response)
    			{
			
			if(response.status == 'success')
			{
				
		    	   if($scope.subCategoryDto.id)
	    		   {
	    		   $scope.SuccessMsg = "SubCategory Updated";
	    		   }
	    	   else
	    		   {
	    		   $scope.SuccessMsg = "SubCategory Saved";
	    		   }
				
				 swal(
				 ''+$scope.SuccessMsg,
                 '',
                 'success'
				 ).then(function(isConfirm) {
              		if (isConfirm) {
              			//location.href="wareHouseAdmin?link=SubCategory";
              			location.reload();
             		}
                  });
			}
		else
			{
 		  		swal(
					''+response.exceptionMessage+'',
                    '',
                    'warning'
	 		  	  )
			}
			
    			});
	}
	}
	
	
	getAllSubCategory();
	FetchService.getAllCategoryTypes().then(function(response){
		
		$scope.categoryMasterDtoList=response;
	});
	
	
	function getAllSubCategory(){
	FetchService.getAllSubCategory().then(function(response)
			{
		$scope.subCategoryDtoList=response;
			});
	}
	
	$scope.edit = function(subCategoryDto) {
        
       $scope.subCategoryMgt = false;
       $scope.editSubCategory = true;
       
       $scope.subCategoryDto = subCategoryDto;
       
		$timeout(function() {
			$('#categoryType').val(subCategoryDto.categoryDto.categoryType).trigger('change');
		}, 1);
        
		}
	
	
	$scope.newSubCategory= function()
	{

 		$scope.subCategoryDto= {};
		$scope.subCategoryMgt= false;
		$scope.editSubCategory = false;
		$scope.addnewSubcategory = true;
		
	}

	
	$scope.back = function()
	{
		
	     /* $scope.subCategoryMgt = true;
	       $scope.editSubCategory = false;*/
	       getAllSubCategory();
			location.reload();
	}
	
var absurl = $location.absUrl();

	
	$scope.cancel=function()
	{
		
		/*if(absurl == UrlConstants.REDIRECTOFFICEADMINIMS_URL+CURRENT_PAGENAME)
		{
			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"SubCategory";
		}
		else if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+CURRENT_PAGENAME)
		{
			location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"SubCategory";
		}
		else
		{
			location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"SubCategory";
		}*/	
		getAllSubCategory();
		location.reload();
		
	}
	
	
    $scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>')
    .withButtons([            
    	{extend: 'excel',
        exportOptions: {
           columns: ':visible:not(.not-export-col)'
        }
    	},
    	{
    	extend:'colvis'
    	}
]);	
    
	   $scope.view = function(subCategoryDto) {   	
	    	
	    	//alert(JSON.stringify(subCategoryDto));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_subcategory_details = subCategoryDto;    	
	    	
	    	
	    }
	
	
});