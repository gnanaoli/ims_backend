ims.controller('ProjectTypeController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,UrlConstants,$location) {

	$scope.ProjectTypeTable = true;
	$scope.editProjectType = false;
	$scope.addProjectTypeDiv = false;
	
	$scope.ProjectDto = {};
	
	$scope.ProjectTypeList = [];
	 
	function getAllProjectType() {
		FetchService.getAllProjectType().then(function(response) {
			
			$scope.ProjectTypeList = response.responseDtoList;
			console.log(JSON.stringify(response));
			
		});
	}
	
	
	getAllProjectType();
	
	$scope.saveProjectType = function(formValid)
	{
		if(formValid)
			{
			InsertService.saveProjectType($scope.ProjectDto).then(function(response)
					{
				if(response.status == 'success')
				{
					
			    	   if($scope.ProjectDto.id)
		    		   {
		    		   $scope.SuccessMsg = "Project Type Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "Project Type Saved";
		    		   }
					
					 swal(
					 ''+$scope.SuccessMsg,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectType";
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
	
	   $scope.view = function(projectType_details) {   	
	    	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_projectType_details = projectType_details;    	
	    	
	    	
	    }
	   
	   $scope.newProjectType = function()
		{
		   $scope.ProjectDto={};
		   $scope.ProjectDto.status="ACTIVE";
			$scope.ProjectTypeTable = false;
			$scope.editProjectType = false;
			$scope.addProjectTypeDiv = true;
		}
	
	
	$scope.edit = function(projectType_details)
	{
		
		$scope.ProjectTypeTable = false;
		$scope.editProjectType = true;
		$scope.addProjectTypeDiv = false;
		$scope.ProjectDto = projectType_details;
	}
	
	$scope.cancel = function()
	{
		$scope.ProjectTypeTable = true;
		$scope.editProjectType = false;
		$scope.addProjectTypeDiv = false;
		getAllProjectType();
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectType";
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