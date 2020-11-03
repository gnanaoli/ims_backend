ims.controller('wareHouseManagementController',function($scope,$http,InsertService,FetchService,$location,UrlConstants,DTOptionsBuilder,$filter,$timeout) {
	
    var absurl = $location.absUrl();
    
    $scope.wareHouseTable = true;
	$scope.wareHouseDto={};
	$scope.wareHouseDtoList=[];
	$scope.activeWareHouseList=[];
	$scope.cityDtoList=[];
	$scope.isDisabled=true;
	$scope.stateEntityList=[];
	$scope.cityEntityList=[];
	$scope.TempCityList =[];
	
	/*$scope.categoryMasterDtoList=[];
	
	$scope.projectStatusList=[];*/
	
	var absurl = $location.absUrl();
	
	$scope.getParentCode= function()
	{
		$scope.wareHouseDto.parentCode = $scope.wareHouseDto.code;
	}
	
	
	$scope.validateToDate = function()
	{
		var dateAr = $scope.wareHouseDto.effectiveStartDate.split('/');
		var startDate = dateAr[2] + '-' + dateAr[1] + '-' + dateAr[0].slice(-2);
		
		var dateAr1 = $scope.wareHouseDto.effectiveEndDate.split('/');
		var endDate = dateAr1[2] + '-' + dateAr1[1] + '-' + dateAr1[0].slice(-2);
	
//		var startDate =   $filter('date')($scope.wareHouseDto.effectiveStartDate, "yyyy-mm-dd");
//		var endDate =   $filter('date')($scope.wareHouseDto.effectiveEndDate, "yyyy-mm-dd");
		
		if(startDate > endDate)
			{
			$scope.wareHouseDto.effectiveEndDate="";
		}
	
	}
	
	if(absurl == UrlConstants.REDIRECTOFFICEADMINIMS_URL+"WareHouse")
		{
		  FetchService.getAllWareHouseList().then(function(response){
				$scope.wareHouseDtoList=response;
			});
		}
	else if(absurl == UrlConstants.REDIRECTPREFIXIMS_URL+"WareHouse")
		{
		  FetchService.getAllWareHouseList().then(function(response){
				$scope.wareHouseDtoList=response;
			});
		}
   
     FetchService.getAllActiveWareHouse().then(function(response){
		
		$scope.activeWareHouseList=response;
	});
	
     
     FetchService.getAllCountryAndStatesAndProject().then(function(response){
   		
       	console.log("getAllCountryAndStatesAndProject"+JSON.stringify(response));
       	$scope.countryDtoList=response;
       	getAllStates()
       		
      });
     
   /*  $scope.isInValidCountry=false;
   	$scope.getStates = function(country){
   		$scope.wareHouseDto.state = '';
   		$scope.stateEntityList = '';
   		$scope.loop=true;
   		angular.forEach($scope.countryDtoList,function(value,key)
   				{
   			if($scope.loop)
   				{
   				if(value.countryName==country)
   		    	 {
   		    	  $scope.stateEntityList=$scope.countryDtoList[key].stateItem;
   		    	  $scope.isInValidCountry=false;
   		    	  $scope.loop=false;
   		    	 }
   				}
   			 else
   	    	 {
   	    	// $scope.manufacturerDto.country='';
   	    	  //$scope.isInValidCountry=true;
   	    	 }
   			     
   				});
   	}*/
     
     function getAllStates()
 	{
 		console.log("getAllCountryAndStatesAndProject"+JSON.stringify($scope.countryDtoList));
 		angular.forEach($scope.countryDtoList,function(value,key)
 				{
 				if(value.countryName=='INDIA')
 		    	 {
 		    	  $scope.stateEntityList=$scope.countryDtoList[key].stateItem;
 		    	 }
 				});
 	}
  	
   	
   /*	$scope.getCity = function(state,country){
  		$scope.wareHouseDto.city = '';
  		$scope.cityEntityList = '';
  		angular.forEach($scope.countryDtoList,function(value,key)
  				{
  			     if(value.countryName==country)
  			    	 {
  			    	  $scope.TempCityList=$scope.countryDtoList[key].stateItem;
  			    	  angular.forEach($scope.TempCityList,function(value,key){
  			    		  if(value.stateName==state)
  			    			  {
  			    			  $scope.cityEntityList=$scope.TempCityList[key].cityItem;
  			    			  }
  			    	  });
  			    	 }
  				});		
  	}*/
     
     $scope.getCity=function(stateName)
 	{
 		console.log(stateName);
 		//$scope.employeeDto.tcity="";
 		//$scope.employeeDto.pcity="";
 		//console.log($scope.countryDtoList);
 		angular.forEach($scope.countryDtoList,function(value,key)
 				{
 			     if(value.countryName=='INDIA')
 			    	 {
 			    	  $scope.TempCityList=$scope.countryDtoList[key].stateItem;
 			    	  angular.forEach($scope.TempCityList,function(value,key){
 			    		  if(value.stateName==stateName)
 			    			  {
 			    			  $scope.cityEntityList=$scope.TempCityList[key].cityItem;
 			    			  }
 			    	  });
 			    	 }
 				});		
 		console.log("cityList==>"+JSON.stringify($scope.cityEntityList));
 	}
 	
 	
 	
	
	
	
	
	
	$scope.edit = function(wareHouseDto) {
		var req = {id : wareHouseDto.id};		
		$('<form action="editWareHouse" method="post"><input type="text" name="id" value="'+wareHouseDto.id+'"></form>').appendTo('body').submit();
	}
	
	
	/*
	 $scope.saveProject = function() {
			
			
			alert(JSON.stringify($scope.project));
			
			$http({
				method : 'POST',
				url : "http://localhost:8080/inventory-kart/AddProject.json",
				data : $scope.supplier,
				headers : {
					'Content-Type' : 'application/json'
				}
			})
			.then(
					function successCallback(response) {
						//console.log(response);	
						location.href="projectListView";
					},
					function errorCallback(response) {
						//console.log(response);				
					});
			
			 }*/
	
	/*FOR SAVE THE WARE HOUSE*/
	$scope.saveWareHouse = function(formValid)
	{
		/*if ($scope.new_wareHouse.$valid ||$scope.edit_wareHouse.$valid )*/
		if(formValid){
		console.log(JSON.stringify($scope.wareHouseDto));
		InsertService.saveWareHouse($scope.wareHouseDto).then(function(response)
				{
			       if(response.status=="success")
			    	   {
			    	   
			    	   if($scope.wareHouseDto.id)
		    		   {
		    		   $scope.SuccessMsg = "WareHouse Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "WareHouse Saved";
		    		   }
			    	   
			    	   
			    	   swal(
			    			   	  ''+$scope.SuccessMsg,
							      '',
							      'success'
							    ).then(function(isConfirm) {
			                  		if (isConfirm) {
				                   			/*if(val == 'office')
				                   			{
				                   				location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"WareHouse";
				                   			}
				                   			else if(val == 'warehouse')
				                   			{
				                   				location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"WareHouse";
				                   			}*/
			                  			location.reload();
			                 		}
			                      });
			    	   }
			       else if(angular.isDefined(response.exceptionMessage)) 
			    	   {
			    	   swal(
							      'Not Saved!',
							      response.exceptionMessage,
							      'warning'
							    )
			    	   }
				});
	}
	
	};
	
	$scope.cancel=function()
	{
   		/*location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"WareHouse";*/
		location.reload();
	}
	
	/*$scope.cancelOffice=function()
	{
   		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"WareHouse";
	}*/
	
	
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
    
    
	   $scope.view = function(wareHouseDto) {   	
	    	
	    	//alert(JSON.stringify(supplier_details));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_warehouse_details = wareHouseDto;    	
	    	
	    	
	    }
	   
	   $scope.newWareHouse = function()
		{

	 		$scope.wareHouseDto = {};
			$scope.wareHouseTable = false;
			$scope.editWareHouse = false;
			$scope.addWareHouse = true;
			$scope.wareHouseDto.country="INDIA";
			
		}
	   
	   $scope.edit = function(WareHouse_Details)
		{
		  
		  
	 		$scope.wareHouseTable = false;
			$scope.editWareHouse= true;
			$scope.addWareHouse = false;
			$scope.wareHouseDto = WareHouse_Details;
			$scope.wareHouseDto.country="INDIA";
		
			if($scope.wareHouseDto.country != null)
			{
				
				/*$timeout(function() {
					$('#country1').val(WareHouse_Details.country).trigger('change');
				}, 1);*/
				getAllStates();
				
				var stateName = WareHouse_Details.state;
				
				var cityName = WareHouse_Details.city;
				
				//$scope.getStates(WareHouse_Details.country);
				
				$scope.getCity(stateName,WareHouse_Details.country);
				
				$scope.wareHouseDto.state = stateName;
				
				$scope.wareHouseDto.city = cityName;
				
			}
			
		}
	
	
});