ims.controller('SafetyStatusController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,UrlConstants,$location) {

	$scope.SafetyStatusMgt = true;
	
	$scope.SafetyStatusDto = {};
	
	$scope.SafetyStatusMaster = [];
	
//	$scope.DesignationDto.status="INACTIVE";
	
	$scope.SafetyStatusDto.status="ACTIVE";
	
//	$scope.DesignationDto.status="INACTIVE";
 function getAllSafetyStatus(){
	 FetchService.getAllSafetyStatus().then(function(response) 
			  {
	      $scope.SafetyStatusDtoList=response;
	      console.log(JSON.stringify(response));
	              });
 }
 
 getAllSafetyStatus();
			  
            
	  
	  
	$scope.saveSafetyStatus = function(formValid)
	{
		if(formValid)
			{
			
			InsertService.saveSafetyStatus($scope.SafetyStatusDto).then(function(response)
					{
				if(response.status == 'success')
				{
			    	   if($scope.SafetyStatusDto.id)
		    		   {
		    		   $scope.SuccessMsg = "SafetyStatus Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "SafetyStatus Saved";
		    		   }
					
					 swal(
					''+$scope.SuccessMsg,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"SafetyStatus";
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
	
	 $scope.view = function(SafetyStatus) {   	
	    	
	    	//alert(JSON.stringify(supplier_details));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_SafetyStatus_details= SafetyStatus;    	
	    	
	    	
	    }
	
	
	$scope.edit = function(SafetyStatus_details)
	{

		$scope.SafetyStatusMgt = false;
		$scope.editSafetyStatus= true;
		$scope.addnewSafetyStatus = false;
		$scope.SafetyStatusDto = SafetyStatus_details;
	}
	$scope.newSafetyStatus = function()
	{

		$scope.SafetyStatusMgt = false;
		$scope.editSafetyStatus = false;
		$scope.addnewSafetyStatus = true;
		//$scope.DepartmentDto = Department_details;
	}
	
	$scope.cancel = function()
	{
		$scope.SafetyStatusMgt = true;
		$scope.editSafetyStatus = false;
		$scope.addnewSafetyStatus = false;
		getAllSafetyStatus();
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"SafetyStatus";
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