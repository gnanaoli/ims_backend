ims.controller('projectManagementController',function($scope,$http,InsertService,FetchService,DTOptionsBuilder,$filter,$location,UrlConstants) {
	
	 $scope.projectTable = true;
	$scope.projectDto={};
	$scope.projectDtoList=[];
	$scope.projectTasksDtoList=[];
	$scope.categoryMasterDtoList=[];
	$scope.projectTypeList=[];
	$scope.projectStatusList=[];
	$scope.cityDtoList=[];
	$scope.isDisabled=true;
	$scope.stateEntityList=[];
	$scope.cityEntityList=[];
	$scope.TempCityList =[];
	$scope.projectTaskViewDtoList=[];
	$scope.projectDto.countryName="INDIA";
	$scope.projectsOldTaskDto={};
	$scope.projectOldTaskId ="";
	
	
		FetchService.getAllProjectList().then(function(response){
			console.log("getAllProjectList"+JSON.stringify(response));
			$scope.projectDtoList=response;
		});
		
		/*
		$scope.viewProjectTaskList=function(projectDto)
		 {
			FetchService.viewProjectDtoList(projectTasksDtoList).then(function(respose)){
			$scope.projectTasksDtoList=respose;
		});
		}*/
		
	
		
		
		
     
	
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
	
	
	
	
	
	
	
	
	/*FOR SAVE THE PROJECT*/
	$scope.saveProject=function(formValid)
	{
		/*if ($scope.new_project.$valid)*/
		if(formValid)
		{
		InsertService.saveNewProject($scope.projectDto).then(function(response)
				{
			       if(response.status=="success")
			    	   {
			    	   
			    	   
			    	   if($scope.projectDto.id)
		    		   {
		    		   $scope.SuccessMsg = "Project Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "Project Saved";
		    		   }
			    	   
			    	   
			    	   swal(
			    			      ''+$scope.SuccessMsg,
							      '',
							      'success'
							    ).then(function(isConfirm) {
			                  		if (isConfirm) {
			                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectManagement";
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
	
	};
	
	
	/*FOR SAVE THE PROJECT WITH NEW TASK*/
	$scope.saveProjectWithNewTask=function(formValid,projectsTaskDto)
	{// alert("hfdgh");
	console.log($scope.projectDto);
		if(formValid)
		{ 
		console.log($scope.projectDto);
		projectsTaskDto.isActive="YES";
		projectsTaskDto.isNew="YES";
	 if($scope.projectDto.projectTasksDtoList==null){
		 $scope.projectDto.projectTasksDtoList=[];
		 $scope.projectDto.projectTasksDtoList.push(projectsTaskDto); 
	 }
	 else{
		// $scope.projectDto.projectTasksDtoList=[];
		
		 $scope.projectDto.projectTasksDtoList.push(projectsTaskDto); 
	 }
		
		console.log(JSON.stringify($scope.projectDto));
		
		InsertService.saveNewProject($scope.projectDto).then(function(response)
				{
			       if(response.status=="success")
			    	   {
			    	   
			    	   
			    	  
		    		   $scope.SuccessMsg = " New Task Added To Project";
		    		 
			    	   
			    	   
			    	   swal(
			    			      ''+$scope.SuccessMsg,
							      '',
							      'success'
							    ).then(function(isConfirm) {
			                  		if (isConfirm) {
			                  			//location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectsTasks";
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
	
	};
	
	
	/*FOR SAVE THE PROJECT WITH EDITED TASK*/
	$scope.saveProjectWithEditedTask=function(formValid,projectsTaskDto)
	{
		if(formValid){
			
			projectsTaskDto.id="";
			projectsTaskDto.isNew="YES";
			angular.forEach($scope.reference.projectTasksDtoList,(value,index)=>{
				if(value.id==$scope.taskOriginal.id){
					$scope.reference.projectTasksDtoList.splice(index,1);
				}
			});
			$scope.reference.projectTasksDtoList.push($scope.taskOriginal);
			console.log($scope.reference.projectTasksDtoList);
			InsertService.saveNewProject($scope.reference).then(function(response)
					{
				       if(response.status=="success")
				    	   {
				    	   
				    	   
				    	  
			    		   $scope.SuccessMsg = " Edited Task Added To Project";
			    		 
				    	   
				    	   
				    	   swal(
				    			      ''+$scope.SuccessMsg,
								      '',
								      'success'
								    ).then(function(isConfirm) {
				                  		if (isConfirm) {
				                  			//location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectsTasks";
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
	
	/*SAVE THE PROJECT WITH DELETED TASK*/
	  $scope.deleteProjectTask = function(projectsTaskDto)
		{
		
		
		
		projectsTaskDto.isActive="DELETED";
		//$scope.reference.projectTasksDtoList.push(projectsTaskDto);	
		console.log("in deleted save task"+JSON.stringify($scope.reference));
		InsertService.saveNewProject($scope.reference).then(function(response)
				{
			       if(response.status=="success")
			    	   {
			    	   
			    	   
			    	  
		    		   $scope.SuccessMsg = " Task Deleted From Project";
		    		 
			    	   
			    	   
			    	   swal(
			    			      ''+$scope.SuccessMsg,
							      '',
							      'success'
							    ).then(function(isConfirm) {
			                  		if (isConfirm) {
			                  			//location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectsTasks";
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
	
	
	
	
	$scope.cancel = function()
	{
		location.reload();
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
	  
	  $scope.validateEndDateOfTasks = function()
		{
		
			
		  var dateAr = $scope.projectsTaskDto.startDate.split('/');
			var startDate = dateAr[2] + '-' + dateAr[1] + '-' + dateAr[0].slice(-2);
			
			var dateAr1 = $scope.projectsTaskDto.endDate.split('/');
			var endDate = dateAr1[2] + '-' + dateAr1[1] + '-' + dateAr1[0].slice(-2);
			
			if(startDate > endDate)
				{
				$scope.projectsTaskDto.endDate="";
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
	  
	   $scope.viewProjectTaskList = function(project)
		{
		  // alert("project Task List"+JSON.stringify(project));
		   $scope.reference=project;
		   if(project.projectTasksDtoList!=null){
			   /*alert("TEST");*/
			   $scope.projectTaskViewDtoList=project.projectTasksDtoList;
			   console.log("projectTaskViewDtoList"+JSON.stringify($scope.projectTaskViewDtoList));
			   
		   }
		   
	 		$scope.projectDto = {};
			$scope.projectTable = false;
			$scope.taskTable = true;
			$scope.editTask = false;
			$scope.newProjectTask = false;
			$scope.taskHistoryTable = false;
			
			
		}
	  
	   
	   
		  $scope.addProjectTask = function(project)
			{
		 		$scope.projectDto = {};
		 		$scope.projectTable = false;
				$scope.taskTable = false;
				$scope.editTask = false;
				$scope.taskHistoryTable = false;
				$scope.newProjectTask = true;
				$scope.projectDto=project;
				
			}
	   
	   $scope.editProjectTask = function(taskDto)
		{ 
		    console.log(taskDto);
		    
		    $scope.projectTable = false;
			$scope.taskTable = false;
			$scope.editTask = true;
			$scope.taskHistoryTable = false;
			$scope.newProjectTask = false;
			
			var data=Object.assign({},taskDto);
			data.isNew="NO";
			
			//$scope.taskEdited=taskDto;
			$scope.taskOriginal=data;
			$scope.projectsTaskDto=taskDto;
		}
	   
	   
	   $scope.ViewTaskHistory = function(projectsTaskDto)
		{ 
		  
		   FetchService.getAllHistoryOfTask(projectsTaskDto).then(function(response){
				console.log("getAllHistoryOfTask"+JSON.stringify(response));
				$scope.TaskHistoryDtoList=response;
			});
		 //  $scope.TaskHistoryDtoList = projectsTaskDto;
	 		$scope.projectTable = false;
			$scope.taskTable = false;
			$scope.editTask = false;
			$scope.taskHistoryTable = true;
			$scope.newProjectTask = false;
			
			
			
			
			
		}
	   
	   
		
	   

});