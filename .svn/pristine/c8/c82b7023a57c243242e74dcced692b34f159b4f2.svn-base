ims.controller('projectTasksController',function($scope,$http,InsertService,FetchService,DTOptionsBuilder,$filter,$location,UrlConstants) {
	
	 $scope.projectTable = true;
	$scope.projectDto={};
	$scope.projectDtoList=[];
	$scope.categoryMasterDtoList=[];
	$scope.projectTypeList=[];
	$scope.projectStatusList=[];
	$scope.cityDtoList=[];
	$scope.isDisabled=true;
	$scope.stateEntityList=[];
	$scope.cityEntityList=[];
	$scope.TempCityList =[];
	$scope.projectDto.countryName="INDIA";
	
	
		FetchService.getAllProjectList().then(function(response){
			
			$scope.projectDtoList=response;
		});
	
		
		
		
     
	
	FetchService.getAllActiveProjectTypes().then(function(response){
		
		$scope.projectTypeDtoList=response;
	});
	
	FetchService.getAllActiveProjectStatus().then(function(response){
		
		$scope.projectStatusDtoList=response;
		//console.log("Statatat"+JSON.stringify(response));
		
	});
	getAllStates();
     
    FetchService.getAllCountryAndStatesAndProject().then(function(response){
  		
      	console.log("getAllCountryAndStatesAndProject"+JSON.stringify(response));
      	$scope.countryDtoList=response;
      	getAllStates();
      		
     });
 	
      
    /*  $scope.isInValidCountry=false;
  	$scope.getStates = function(country){
  		$scope.loop=true;
  		angular.forEach($scope.countryDtoList,function(value,key)
  				{
  			if($scope.loop)
  				{
  				if(value.countryName=="INDIA")
  		    	 {
  		    	  $scope.stateEntityList=$scope.countryDtoList[key].stateItem;
  		    	  $scope.isInValidCountry=false;
  		    	  $scope.loop=false;
  		    	 }
  				}
  			 else
  	    	 {
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
  	
  	/*$scope.getCity = function(state,country){
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
	
	
	
	
	
//	$scope.edit = function(projectDto) {
//		var req = {id : projectDto.id};		
//		$('<form action="editProject" method="post"><input type="text" name="id" value="'+projectDto.id+'"></form>').appendTo('body').submit();
//	}
	
	
	
	/*FOR SAVE THE PROJECT TASKS*/
	$scope.saveProjectTasks=function(formValid)
	{
};
	
	
	
	$scope.cancel = function()
	{
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
	  
	  
	  
	  
	  $scope.view = function(projectDto) {   	
	    	$("#myModal").modal('show');
	    	$scope.projectDetails = projectDto;    	
	    	
	    	
	    }
	  
	  $scope.validateEndDate = function()
		{
		
			/*var startDate =   $filter('date')($scope.projectDto.startDate, "yyyy-mm-dd");
			var endDate =   $filter('date')($scope.projectDto.endDate, "yyyy-mm-dd");*/
		  var dateAr = $scope.projectDto.startDate.split('/');
			var startDate = dateAr[2] + '-' + dateAr[1] + '-' + dateAr[0].slice(-2);
			
			var dateAr1 = $scope.projectDto.endDate.split('/');
			var endDate = dateAr1[2] + '-' + dateAr1[1] + '-' + dateAr1[0].slice(-2);
			
			if(startDate > endDate)
				{
				$scope.projectDto.endDate="";
			}
		
		}
	  
	  
	  $scope.addProject = function()
		{
	 		$scope.projectDto = {};
			$scope.projectTable = false;
			$scope.editProject = false;
			$scope.newProject = true;
			$scope.projectDto.countryName="INDIA";
			
		}
	   
	   $scope.edit = function(project_Details)
		{

		   $scope.projectDto.countryName="INDIA";
	 		$scope.projectTable = false;
			$scope.editProject= true;
			$scope.newProject = false;
			$scope.projectDto = project_Details;
		
			if(project_Details.countryName != null)
			{
				
				
				/*$scope.getStates(project_Details.countryName=="INDIA");*/
				getAllStates();
				
				$scope.getCity(project_Details.state,project_Details.countryName);
				
				$scope.projectDto.state = project_Details.state;
				
				$scope.projectDto.city = project_Details.city;
				
				$scope.projectDto.projectType = project_Details.projectType;
				
			}
			
		}
	  
	  
	  

});