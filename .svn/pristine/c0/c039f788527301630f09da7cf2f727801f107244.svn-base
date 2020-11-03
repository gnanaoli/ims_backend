ims.controller('WorksMenCategoryManagementController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,$location,UrlConstants) {

	$scope.WorksMenCategoryMgt = true;
	
	$scope.WorksMenDto = {};
	
	$scope.WokrsMenCategoryMaster = [];

	function getAllWorksMenCategory()
	{
		FetchService.getAllWorksMenCategory().then(function(response) {
			
			$scope.WokrsMenCategoryMaster = response;
			console.log(JSON.stringify(response));
			
		});
	}
	
	getAllWorksMenCategory();
	
	$scope.saveWorksMenCategory = function()
	{
		if($scope.addWorksMenCategory.$valid)
			{
			
			InsertService.saveWorksMenCategory($scope.WorksMenDto).then(function(response)
					{
				if(response.status == 'success')
				{
					
			    	   if($scope.WorksMenDto.id)
		    		   {
		    		   $scope.SuccessMsg = "WorksMen Category Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "WorksMen Category Saved";
		    		   }
					
					 swal(
					''+$scope.SuccessMsg,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"WorksMenCategory";
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
	
	   $scope.view = function(worksmenCategory_details) {   	
	    	
	    	//alert(JSON.stringify(supplier_details));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_worksmencategory_details = worksmenCategory_details;    	
	    	
	    	
	    }
	
	
	$scope.edit = function(worksmenCategory_details)
	{
		
		$scope.WorksMenCategoryMgt = false;
		$scope.editWorksMenCategory = true;
		$scope.WorksMenDto = worksmenCategory_details;
	}
	
	$scope.cancel = function()
	{
		getAllWorksMenCategory();
		$scope.WorksMenCategoryMgt = true;
		$scope.editWorksMenCategory = false;
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"WorksMenCategory";
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
	

});