ims.controller('ELCBManagementController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,UrlConstants) {

	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!

	var yyyy = today.getFullYear();
	if(dd<10){
	    dd='0'+dd;
	} 
	if(mm<10){
	    mm='0'+mm;
	} 
	$scope.todayDate = dd+'/'+mm+'/'+yyyy;
	
	
	$scope.ELCBMgt = true;
	
	$scope.elcbDto = {};
	
	$scope.SafetyStatusMasterDtoList = [];
	
	
	$scope.elcpMasterDtoList = [];
	
	FetchService.getCurrentUserProjectDropDown().then(function(response){
		
		$scope.projectMasterDtoList=response;
		
	});
	
	FetchService.getAllELCB().then(function(response){
		
		$scope.elcpMasterDtoList=response;
		console.log(JSON.stringify(response));
	});
	
	FetchService.getAllSafetyStatus().then(function(response){
		
		$scope.SafetyStatusMasterDtoList=response;
		
	});
	
	
	$scope.saveelcb = function(addelcb)
	{
		if(addelcb)
			{
			console.log(JSON.stringify($scope.elcbDto));
			
			InsertService.saveELCB($scope.elcbDto).then(function(response)
					{
				if(response.status == 'success')
				{
					
			    	   if($scope.elcbDto.id)
		    		   {
		    		   $scope.SuccessMsg = "ELCB Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "ELCB Saved";
		    		   }
					
					 swal(
					 ''+$scope.SuccessMsg,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ELCBManagement";
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
	
	
	$scope.edit = function(elcp_details)
	{
		
		
		$scope.ELCBMgt = false;
		$scope.editELCB = true;
		$scope.elcbDto = elcp_details;
		
		
	}
	
	$scope.cancel = function()
	{
		$scope.ELCBMgt = true;
		$scope.editELCB = false;
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ELCBManagement";
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
	   
	   $scope.view = function(ELCBManagementDto) {   	
	    	$("#myModal").modal('show');
	    	$scope.ELCBManagementDetails = ELCBManagementDto;    	
	    	
	    	
	    }
	   
	
	   $scope.ischecked = function(val)
	   {
		   if(val == "CHECKED")
			   {
			      $scope.showWorkingStatus = true;
			   }
		   else
			   {
			   	$scope.showWorkingStatus = false;
			   }
	   }
	

});