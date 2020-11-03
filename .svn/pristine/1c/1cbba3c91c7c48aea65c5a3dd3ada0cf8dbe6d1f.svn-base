ims.controller('userManagementController',function($scope,$http,InsertService,$filter,FetchService,DTOptionsBuilder) {
	$scope.usercreation={'country':{'name':'',"state":{'name':'',"city":[]}}};
	$scope.isDisabled=true;
	$scope.emailregEx = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,3}(?:\.[a-z]{2})?)$/i;
	$scope.designationDtoList=[];
	$scope.cityEntityList=[];
	$scope.wareHouseDtoList=[];
	$scope.enableWareHouse='';
	$scope.userManagementDtoList=[];
	$scope.user={};
	$scope.projectList=[];
	$scope.roleEntityList=[];
	$scope.testRoleList=[{
		roleName:'OFFICE ADMINISTRATOR',
	},
	{
		roleName:'WAREHOUSE ADMINISTRATOR',
	},
	{
		roleName:'OTHERS',
	}
	];
	$scope.projectDtoList=[{
		
			id:'',
			name:'',
			selected:false
		
	}];
	$scope.userDto={};
	$scope.selected=false;
	$scope.roleList=[
		{
			id:'',
			roleName:'',
			selected:false
		}
		];
	
	FetchService.getAllProjectList().then(function(response)
			{
		$scope.projectDtoList=response;
			});
	
	FetchService.getAllActiveWareHouse().then(function(response)
			{
		$scope.wareHouseDtoList=response;
			});
	FetchService.getDesignation().then(function(response)
			{
		$scope.designationDtoList=response;
			});
	
	FetchService.getAllUsers().then(function(response)
			{
		$scope.userManagementDtoList=response;
			});
	
	
	FetchService.getAllRoles().then(function(response)
			{
		$scope.roleList=response;
			});
	
	FetchService.getAllCountryAndStatesAndProject().then(function(response)
			{
		$scope.getAllCountryAndStatesAndProjectDtoList=response;
			});
	
	
	var projectCount=0;
	
	$scope.checkvaliddateproject = function()
	{
		  angular.forEach($scope.projectList,function(v,k)
				  {
			       if(v.selected)
			    	   {
			    	   projectCount++;
			    	   }
				  });
		  
		  if(projectCount == 0)
			  {
			  $scope.projecterror="please choose project";
			  }
		  else
			  {
			  $scope.projecterror="";
			  }
		  
		  
		  return projectCount;
	}
	
	
	$scope.checkvalidateRoles=function()
	{
		 angular.forEach($scope.userEditRoleEntityList,function(v,k)
				  {
			       if(v.selected)
			    	   {
			    	   projectCount++;
			    	   }
				  });
		  
		  if(projectCount == 0)
			  {
			  $scope.roleError="please choose Roles";
			  }
		  else
			  {
			  $scope.roleError="";
			  }
		  return projectCount;
	}
	
	$scope.cancel = function(event){
		alert("calcel");
		event.preventDefault();
	}
	
	$scope.saveUser=function(event,NewUser)
	{	
		var count=0;
		console.log(JSON.stringify($scope.NewUser.$valid));
		if ($scope.NewUser.$valid && $scope.userDto.mobileNumber.toString().length == 10) {
			
			if($scope.userDto.roleType=='WAREHOUSE ADMINISTRATOR')
				{
				angular.forEach($scope.wareHouseDtoList,function(v,k){
					if(v.selected)
						{
						count++;
						}
				});
				if(count==0)
					{
					$scope.wareHouseError="please choose wareHouse";
					return false;
					}
				$scope.wareHouseError='';
				count=0;
				}
			else if($scope.userDto.roleType=='OTHERS')
				{
				angular.forEach($scope.roleEntityList,function(v,k){
					if(v.selected)
						{
						count++;
						}
				});
				if(count==0)
					{
					$scope.roleError="please choose role";
					return false;
					}
				$scope.roleError='';
				count=0;
				angular.forEach($scope.projectList,function(v,k){
					if(v.selected)
						{
						count++;
						}
				});
				if(count==0)
					{
					$scope.projectError="please choose project";
					return false;
					}
				$scope.projectError='';
				count=0;
				}
			$scope.isDisabled=false;
			$scope.userDto['Roles'] =$scope.roleEntityList;
			$scope.userDto['Projects'] =$scope.projectList;
			$scope.userDto['wareHouses']=$scope.wareHouseDtoList;
			console.log("userRequestDto"+JSON.stringify($scope.userDto));
			InsertService.saveUser($scope.userDto).then(function(response)
					{
				 if(response.status=='success')
			    	{
					 swal(
						      'saved!',
						      'successfully saved',
						      'success'
						    ).then(function(isConfirm) {
		                  		if (isConfirm) {
		                  			location.href="officeAdmin?link=UserManagement";
		                 		}
		                      });
			    	}
				 else if(angular.isDefined(response.exceptionMessage))
			    	{
			    	 swal(
						      'not saved!',
						      response.exceptionMessage,
						      'warning'
						    )
						    return false;
			    	}
					});
		}
	}
	
	$scope.edit = function(userDto) {
		var req = {id : userDto.id};		
		$('<form action="Edituser" method="post"><input type="text" name="id" value="'+userDto.id+'"></form>').appendTo('body').submit();
	}
	
	$scope.viewuser = true;
	$scope.editUser=function(userDto)
	{
		//console.log("EDIT USER==>"+JSON.stringify(userDto));
		$scope.userSelectedRoles=[];
		$scope.userNotSelectedRoles=[];
		$scope.userSelectedProjects=[];
		$scope.userNotSelectedProjects=[];
		$scope.userSelectedWareHouseDtoList=[];
		$scope.userNotSelectedWareHouseDtoList=[];
		$scope.userEditRoleEntityList=[];
		if(angular.isDefined(userDto))
			{
		$scope.userDto = userDto;
		$scope.user.Projects=userDto.Projects;
		console.log("projects=====>"+JSON.stringify(userDto.Projects));
		$scope.user.userNotSelectedProjects=userDto.userNotSelectedProjects;
		$scope.userSelectedRoles=userDto.Roles;
		$scope.userNotSelectedRoles=userDto.userNotSelectedRoles;
		$scope.userSelectedProjects=userDto.Projects;
		$scope.userNotSelectedProjects=userDto.userNotSelectedProjects;
		$scope.user.Projects=$scope.userSelectedProjects.concat($scope.userNotSelectedProjects);
		$scope.roleEntityList=$scope.userSelectedRoles.concat($scope.userNotSelectedRoles);
		
		if(angular.isDefined($scope.roleEntityList))
			{
			angular.forEach($scope.roleEntityList,function(v,k)
					{
				    if(v.roleName!='WAREHOUSE ADMINISTRATOR' && v.roleName!='OFFICE ADMINISTRATOR')
				    	{
				    	$scope.userEditRoleEntityList.push(v);
				    	}
					});
			}
		
		$scope.projectList=$scope.user.Projects;
		$scope.userSelectedWareHouseDtoList=userDto.wareHouses;
		$scope.userNotSelectedWareHouseDtoList=userDto.userNotSelectedWareHouseDtoList;
		$scope.wareHouseDtoList=$scope.userSelectedWareHouseDtoList.concat($scope.userNotSelectedWareHouseDtoList);
		$scope.selected = true;
		$scope.viewuser = false;
		$scope.enableWareHouse=true;
			}
		
	}
	
	$scope.back=function()
	{
		$scope.selected = false;
		$scope.viewuser = true;
	}
	
	$scope.removeProjectAndWareHouseCheck=function(roleName)
	{
		if(roleName=='WAREHOUSE ADMINISTRATOR'|| roleName=='OFFICE ADMINISTRATOR')
			{
			angular.forEach($scope.userEditRoleEntityList,function(v,k)
					{
				    var role={
				    		id:v.id,
				    		roleName:v.roleName,
				    		selected:false
				    }
				    $scope.userEditRoleEntityList[k]=role;
				    });
			angular.forEach($scope.projectList,function(v,k)
					{
				    var project={
				    		id:v.id,
				    		name:v.name,
				    		selected:false,
				    }
				    $scope.projectList[k]=project;
					});
			angular.forEach($scope.wareHouseDtoList,function(v,k){
				 var warHouse={
				    		id:v.id,
				    		wareHouseName:v.wareHouseName,
				    		selected:false
				    }
				 $scope.wareHouseDtoList[k]=warHouse;
			});
			}
		else if(roleName=='OTHERS')
			{
			angular.forEach($scope.wareHouseDtoList,function(v,k){
				 var warHouse={
				    		id:v.id,
				    		wareHouseName:v.wareHouseName,
				    		selected:false
				    }
				 $scope.wareHouseDtoList[k]=warHouse;
			});
			}
	}
	
	
    $scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>')
    .withButtons([            
    	'excel',
    	'colvis'
]);	
    
	   $scope.view = function(user) {   	
	    	
	    	//alert(JSON.stringify(supplier_details));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_user_details = user;    	
	    	
	    	
	    }
	
	
});