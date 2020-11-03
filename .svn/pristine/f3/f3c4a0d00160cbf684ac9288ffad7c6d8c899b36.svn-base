ims.controller('CityController',function($scope,$http,InsertService,FetchService,DTOptionsBuilder,UrlConstants,$location) {
	
	
	$scope.cityMgt = true;
	
	$scope.addCityDto={};	
	
	$scope.addcity = {};
	
    FetchService.getAllCountryAndStatesAndProject().then(function(response){
		
    	console.log("StateList"+JSON.stringify(response[0].stateItem));
    	$scope.stateDtoList=response[0].stateItem;
    		
   });
    
   
    function getcityList()
    {
        FetchService.getAllCity().then(function(response){
    		
        	console.log("CityList"+JSON.stringify(response));
        	$scope.cityDtoList=response;
        		
       });
    }
    
    getcityList();
	
	
	$scope.addCity = function()
	{
		$scope.addCityForm = true;
		$scope.cityMgt = false;
		$scope.editCity = false;
		$scope.addCityDto={};
	}
	
	
	$scope.cancel = function(state)
	{
		$scope.addCityForm = false;
		$scope.cityMgt = true;
		$scope.editCity = false;
		getcityList();
	}

	
	/*FOR SAVE THE CITY*/
	$scope.saveCity=function(formValid)
	{
		console.log(JSON.stringify($scope.addCityDto));
		
		if(formValid)
			{
			InsertService.saveCity($scope.addCityDto).then(function(response)
					{
				       if(response.status=="success")
				    	   {
				    	   if($scope.addCityDto.id)
				    		   {
				    		   $scope.SuccessMsg = "City Updated";
				    		   }
				    	   else
				    		   {
				    		   $scope.SuccessMsg = "City Saved";
				    		   }
				    	   
				    	   
				    	   swal(
									 ''+$scope.SuccessMsg,
				                     '',
				                     'success'
									 ).then(function(isConfirm) {
				                  		if (isConfirm) {
				                  		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"CityManagement";
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
	
	
	$scope.edit = function(state)
	{
		$scope.addCityForm = false;
		$scope.cityMgt = false;
		$scope.editCity = true;		
		
		$scope.addCityDto = state;
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
    
	   $scope.view = function(city) {   	
	    	
	    	//alert(JSON.stringify(supplier_details));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_city_details = city;    	
	    	
	    	
	    }    
	
	
});