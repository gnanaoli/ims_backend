ims.controller('EditUserController',function($scope,$http,InsertService,$filter,FetchService,$location,UrlConstants,DTOptionsBuilder) {
	
	$scope.viewuser = true;
	$scope.viewResetPasword = false;
	
	$scope.roleList = [];
	
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
	     
	     if(absurl==UrlConstants.REDIRECTOFFICEADMINIMS_URL+"UserManagement")
	    	 {
	    	 FetchService.getAllUsers().then(function(response)
	    				{
	    			$scope.userManagementDtoList=response;
	    				});
	    	 }
	     else if(absurl==UrlConstants.REDIRECTPREFIXIMS_URL+"UserManagement")
	    	 {
	    	 FetchService.getAllUsers().then(function(response)
	    				{
	    			$scope.userManagementDtoList=response;
	    				});
	    	 }
	
	$scope.editUser=function(userDto)
	{
		
		$scope.userSelectedRoles=[];
		$scope.userNotSelectedRoles=[];
		$scope.userSelectedProjects=[];
		$scope.userNotSelectedProjects=[];
		$scope.userSelectedWareHouseDtoList=[];
		$scope.userNotSelectedWareHouseDtoList=[];
		$scope.roleList=[];
		$scope.userDto={};
		
		console.log(JSON.stringify(userDto));
		
		$scope.userDto = userDto;
		
		$scope.userSelectedProjects=userDto.Projects;
		$scope.userNotSelectedProjects=userDto.userNotSelectedProjects;
		$scope.projectList=$scope.userSelectedProjects.concat($scope.userNotSelectedProjects);
		
		
		$scope.userSelectedRoles=userDto.Roles;
		$scope.userNotSelectedRoles=userDto.userNotSelectedRoles;
		
		$scope.roleListDataBaseList=$scope.userSelectedRoles.concat($scope.userNotSelectedRoles);
		
		$scope.userSelectedWareHouseDtoList=userDto.wareHouses;
		$scope.userNotSelectedWareHouseDtoList=userDto.userNotSelectedWareHouseDtoList;
		$scope.wareHouseEntityList =$scope.userSelectedWareHouseDtoList.concat($scope.userNotSelectedWareHouseDtoList);
		
		if(angular.isDefined($scope.roleListDataBaseList))
			{
			angular.forEach($scope.roleListDataBaseList,function(v,k)
					{
				    if(v.roleName!='WAREHOUSE ADMINISTRATOR' && v.roleName!='OFFICE ADMINISTRATOR')
				    	{
				    	$scope.roleList.push(v);
				    	}
					});
			}
		
		
		$scope.selected = true;
		$scope.viewuser = false;
	}
	
	
	$scope.saveUser=function(event,NewUser)
	{
		var count=0;
		console.log("valid==>"+JSON.stringify($scope.NewUser.$valid));
		if ($scope.NewUser.$valid) {
			
			if($scope.userDto.resetPassword)
				{
				 if(!($scope.userDto.confirmPassword.toString() == $scope.userDto.newPassword.toString()))
					 {
					 return false;
					 }
				}			
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
					      'User Updated',
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
			angular.forEach($scope.roleList,function(v,k)
					{
				    var role={
				    		id:v.id,
				    		roleName:v.roleName,
				    		selected:false
				    }
				    $scope.roleList[k]=role;
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
	
	
	 $scope.viewUser = function(user) {   	
	    	$("#myModal").modal('show');
	    	$scope.userDetails = user;    	
	    }
	
	
	
	$scope.cancel =function()
	{
		//$scope.selected = false;
		//$scope.viewuser = true;
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
	
    
    $scope.resetPassword=function(reset)
    {
    	console.log(reset);
    	if(reset=='RESET')
    		{
    		$scope.viewResetPasword = true;
    		}
    }
    
    
});