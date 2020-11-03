ims.controller('DepartmentController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,UrlConstants) {

	$scope.DepartmentMgt = true;
	
	$scope.DepartmentDto = {};
	
	$scope.DepartmentMaster = [];
	
	function getAllDepartment(){
		FetchService.getAllDepartment().then(function(response)
	              {
	      $scope.departmentDtoList=response;
	      console.log(JSON.stringify(response));
	              });	
	}
	getAllDepartment();
	  
	  
	$scope.saveDepartment = function(formValid)
	{
		if(formValid)
			{
			
			InsertService.saveDepartment($scope.DepartmentDto).then(function(response)
					{
				if(response.status == 'success')
				{
					
			    	   if($scope.DepartmentDto.id)
		    		   {
		    		   $scope.SuccessMsg = "Department Updated";
		    		   }
			    	   else
		    		   {
		    		   $scope.SuccessMsg = "Department Saved";
		    		   }
					
					 swal(
					''+$scope.SuccessMsg,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"Department";
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
	
	 $scope.view = function(Department_details) {   	
	    	
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_Department_details = Department_details;    	
	    	
	    	
	    }
	
	
	$scope.edit = function(Department_details)
	{

		$scope.DepartmentMgt = false;
		$scope.editDepartment = true;
		$scope.addnewDepartment = false;
		$scope.DepartmentDto = Department_details;
	}
	$scope.newDepartment = function()
	{

		$scope.DepartmentDto = {};
		$scope.DepartmentMgt = false;
		$scope.editDepartment = false;
		$scope.addnewDepartment = true;
	}
	
	$scope.cancel = function()
	{
		$scope.DepartmentMgt = true;
		$scope.editDepartment = false;
		$scope.addnewDepartment = false;
		getAllDepartment();
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"Department";
	}
	
	
    $scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>').withLanguage({"sEmptyTable":"No Record Found"})
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