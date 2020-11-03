ims.controller('StateController',function($scope,$http,InsertService,FetchService,DTOptionsBuilder,UrlConstants) {
	
	
	$scope.stateMgt = true;
	
	$scope.stateDto={};
	$scope.editStateDto={};
	$scope.countryDtoList=[];
	$scope.stateDtoList = [];
	$scope.stateDto.status = "ACTIVE";
	
	
	
    FetchService.getAllCountryAndStatesAndProject().then(function(response){
		
    	console.log("getAllCountryAndStatesAndProject"+JSON.stringify(response[0].stateItem));
    	$scope.countryDtoList=response[0].stateItem;
    		
   });
	
	
	
	
	
	$scope.edit = function(state)
	{
		
		console.log("state"+JSON.stringify(state));
		
		$scope.stateMgt = false;
		$scope.editState = true;
		$scope.stateDto = state;
	}
	
	
	/*FOR SAVE THE CATEGORY*/
	$scope.saveState=function()
	{
		console.log(JSON.stringify($scope.stateDto));
		
		if($scope.addstate.$valid)
			{
			InsertService.saveState($scope.stateDto).then(function(response)
					{
				       if(response.status=="success")
				    	   {
				    	   
				    	   if($scope.stateDto.id)
			    		   {
			    		   $scope.SuccessMsg = "State Updated";
			    		   }
			    	   else
			    		   {
			    		   $scope.SuccessMsg = "State Saved";
			    		   }
				    	   
				    	   
				    	   swal(
				    			     ''+$scope.SuccessMsg,
				                     '',
				                     'success'
									 ).then(function(isConfirm) {
				                  		if (isConfirm) {
				                  		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"StateManagement";
				                 		}
				                      });
				    	   
				    	   }else if(angular.isDefined(response.exceptionMessage))
				    	   {
						    	 swal(
									      'Not Saved!',
									      response.exceptionMessage,
									      'warning'
									    )
						    	}
					});									
			}

	}
	
	$scope.cancel=function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"StateManagement";
	}
	
	$scope.back=function()
	{
		$scope.stateMgt = true;
		$scope.editState = false;
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
    
	   $scope.view = function(state) {   	
	    	
	    	//alert(JSON.stringify(supplier_details));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_state_details = state;    	
	    	
	    	
	    }    
	
	
});