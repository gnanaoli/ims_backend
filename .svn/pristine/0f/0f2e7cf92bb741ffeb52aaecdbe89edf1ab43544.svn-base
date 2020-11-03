ims.controller('InspectionController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,$location,UrlConstants) {


	
	
	$scope.InspectionMgt = true;
	
	$scope.verifyAction = ["QC VERIFIED","REJECTED"];
	
	$scope.approveAction = ["QC APPROVED","REJECTED"];
	
	
	function getAllInspectionDetails()
	{
		FetchService.getAllInspectionDetails().then(function(response) {
			
			$scope.InspectionDtoMaster = response.responseDtoList;
			
		});
	}
	
	getAllInspectionDetails();
	
	
	
	
	$scope.approveInspectionDetails = function()
	{
		
		if($scope.approveInspection.$valid)
			{
			
			InsertService.approveInspection($scope.inspectionDto).then(function(response)
					{
				if(response.status == 'success')
				{
					 swal(
					 ''+$scope.inspectionDto.subStatus,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"InspectionDetails";
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
	
	
	$scope.verifyInspection = function()
	{
		
		if($scope.approveInspection.$valid)
			{
			
			InsertService.verifyInspection($scope.inspectionDto).then(function(response)
					{
				if(response.status == 'success')
				{
					 swal(
					 ''+$scope.inspectionDto.subStatus,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"VerifyInspection";
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
	
	
	$scope.edit = function(inspectionDto)
	{
		
		$scope.InspectionMgt = false;
		$scope.editInspection = true;
		$scope.inspectionDto = inspectionDto;
	}
	
	$scope.cancel = function()
	{
		getAllInspectionDetails();
		$scope.InspectionMgt = true;
		$scope.editInspection = false;
	}
	
	
	 $scope.view = function(inspectionDto) {   	
	    	$("#myModal").modal('show');
	    	$scope.viewInspection = inspectionDto;
	    }
	
	
	$scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>')
    .withButtons([            
    	'excel',
    	'colvis'
]);
	

});