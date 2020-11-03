ims.controller('ProjectStatusController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,$location,UrlConstants) {

	$scope.ProjectStatusTable = true;
	$scope.editProjectStatus = false;
	$scope.addProjectStatusDiv = false;
	
	$scope.ProjectDto = {};
	
	$scope.ProjectStatusList = [];

	function getAllProjectStatus() {
		FetchService.getAllProjectStatus().then(function(response) {
			
			$scope.ProjectStatusList = response.responseDtoList;
			console.log(JSON.stringify(response));
			
		});
	}
	getAllProjectStatus();
	
	
	$scope.saveProjectStatus = function(formValid)
	{
		if(formValid)
			{
			
			console.log("dsdsd"+JSON.stringify($scope.ProjectDto));
			
			InsertService.saveProjectStatus($scope.ProjectDto).then(function(response)
					{
				if(response.status == 'success')
				{
					
			    	   if($scope.ProjectDto.id)
		    		   {
		    		   $scope.SuccessMsg = "Project Status Updated";
		    		   }
		    	   else
		    		   {
		    		   $scope.SuccessMsg = "Project Status Saved";
		    		   }
					
					 swal(
					 ''+$scope.SuccessMsg,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectStatus";
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
	
	   $scope.view = function(projectStatus_details) {   	
	    	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_projectStatus_details = projectStatus_details;    	
	    	
	    	
	    }
	   
	   $scope.newProjectStatus = function()
		{
		   
			$scope.ProjectStatusTable = false;
			$scope.editProjectStatus = false;
			$scope.addProjectStatusDiv = true;
			$scope.ProjectDto = {};
			$scope.ProjectDto.status="ACTIVE";
		}
	
	
	$scope.edit = function(projectStatus_details)
	{
		
		$scope.ProjectStatusTable = false;
		$scope.editProjectStatus = true;
		$scope.addProjectStatusDiv = false;
		$scope.ProjectDto = projectStatus_details;
	}
	
	$scope.cancel = function()
	{
		$scope.ProjectStatusTable = true;
		$scope.editProjectStatus = false;
		$scope.addProjectStatusDiv = false;
		getAllProjectStatus();
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ProjectStatus";
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