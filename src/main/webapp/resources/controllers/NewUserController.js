ims.controller('newUserController',function($scope,$http,InsertService,$filter,FetchService,$location,UrlConstants) {
	
	$scope.projectList=[];
	$scope.roleList=[];
	$scope.wareHouseEntityList=[];
	$scope.employeeDtoList=[];
	$scope.employeeIdDtoList=[];
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
	
	 var absurl = $location.absUrl();
		if(absurl==UrlConstants.REDIRECTOFFICEADMINIMS_URL+"NewUser")
			{
			FetchService.getAllEmployee().then(function(response){
				$scope.employeeDtoList=response;
			});
			
			FetchService.getAllEmployeeId().then(function(response){
				$scope.employeeIdDtoList=response;
			});
			
			
			FetchService.getAllProjectList().then(function(response)
					{
				$scope.projectList=response;
					});
			
			FetchService.getAllActiveWareHouse().then(function(response)
					{
				$scope.wareHouseEntityList=response;
					});
			
			FetchService.getAllRoles().then(function(response)
					{
				angular.forEach(response,function(v,k)
						{
					if(v.roleName!='OFFICE ADMINISTRATOR' && v.roleName!='WAREHOUSE ADMINISTRATOR')
						{
						$scope.roleList.push(v);
						}
						});
				console.log("roleList from db==>"+JSON.stringify($scope.roleList));
					});
			}
	
	$scope.saveUser=function(event,NewUser)
	{
		var count=0;
		console.log("valid==>"+JSON.stringify($scope.NewUser.$valid));
		if ($scope.NewUser.$valid) {
			if($scope.userDto.roleType=='WAREHOUSE ADMINISTRATOR')
			{
			angular.forEach($scope.wareHouseEntityList,function(v,k){
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
			angular.forEach($scope.roleList,function(v,k){
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
			$scope.userDto['Roles'] =$scope.roleList;
			$scope.userDto['Projects'] =$scope.projectList;
			$scope.userDto['wareHouses']=$scope.wareHouseEntityList;
			
			console.log("userRequestDto==>"+JSON.stringify($scope.userDto));
			InsertService.saveUser($scope.userDto).then(function(response)
					{
				 if(response.status=='success')
			    	{
					 swal(
						      'User Saved',
						      '',
						      'success'
						    ).then(function(isConfirm) {
		                  		if (isConfirm) {
		                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"UserManagement";
		                 		}
		                      });
			    	}
				
				 else if(angular.isDefined(response.exceptionMessage))
			    	{
			    	 swal(
						      'Not Saved',
						      response.exceptionMessage,
						      'warning'
						    )
						    return false;
			    	}
					});
		}
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
			angular.forEach($scope.wareHouseEntityList,function(v,k){
				 var warHouse={
				    		id:v.id,
				    		wareHouseName:v.wareHouseName,
				    		selected:false
				    }
				 $scope.wareHouseEntityList[k]=warHouse;
			});
			}
		else if(roleName=='OTHERS')
			{
			angular.forEach($scope.wareHouseEntityList,function(v,k){
				 var warHouse={
				    		id:v.id,
				    		wareHouseName:v.wareHouseName,
				    		selected:false
				    }
				 $scope.wareHouseEntityList[k]=warHouse;
			});
			}
	}
	
	$scope.cancel=function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"UserManagement";
	}
	
	$scope.getEmployeeDetails=function(empid)
	{
		angular.forEach($scope.employeeDtoList,function(value,key)
				{
			    if(angular.equals(value.employeeId,empid))
			    	{
			    	$scope.userDto.name=value.fullName;
			    	}
				});
	}
});