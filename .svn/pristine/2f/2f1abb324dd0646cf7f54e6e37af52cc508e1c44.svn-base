ims.controller('DesignationController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,UrlConstants) {

	$scope.DesignationMgt = true;
	
	$scope.DesignationDto = {};
	
	$scope.DesignationCategoryMaster = [];
	
	function getDesignation(){
		FetchService.getDesignation().then(function(response)
	              {
	      $scope.designationDtoList=response;
	      console.log(JSON.stringify(response));
	              });
	}
	getDesignation();
					  
	
	$scope.saveDesignation = function()
	{
		if($scope.addDesignation.$valid)
			
			{
			
			InsertService.saveDesignation($scope.DesignationDto).then(function(response)
					{
				if(response.status == 'success')
				{
					
			    	   if($scope.DesignationDto.id)
		    		   {
		    		   $scope.SuccessMsg = "Designation Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "Designation Saved";
		    		   }
					
					 swal(
					''+$scope.SuccessMsg,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"Designation";
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
	
	
	   $scope.view = function(Designation_details) {   	
	    	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_Designation_details = Designation_details;    	
	    	
	    	
	    }
	
	
	$scope.edit = function(Designation_details)
	{
		
		$scope.DesignationMgt = false;
		$scope.editDesignationCategory = true;
		$scope.DesignationDto = Designation_details;
	}
	
	$scope.cancel = function()
	{
		$scope.DesignationMgt = true;
		$scope.editDesignationCategory = false;
		getDesignation();
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"Designation";
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