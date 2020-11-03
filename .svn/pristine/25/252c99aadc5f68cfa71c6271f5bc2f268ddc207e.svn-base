ims.controller('ScrapInspectionController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,$location,UrlConstants) {

	
	$scope.InspectionMgt = true;
	
	$scope.verifyAction = ["QC VERIFIED","REJECTED"];
	
	$scope.approveAction = ["QC APPROVED","REJECTED"];
	
	
	function getAllScrapInspection()
	{
		FetchService.getAllScrapInspection().then(function(response) {
			
			$scope.InspectionDtoMaster = response;
			
		});
	}
	
	getAllScrapInspection();
	
	
	$scope.readonlyStatus = true;
	
	
	$scope.approveInspectionDetails = function()
	{
		
		if($scope.approveInspection.$valid)
			{
			$scope.readonlyStatus = false;
			
			InsertService.VerifyandApproveScrapInspection($scope.inspectionDto).then(function(response)
					{
				if(response.status == 'success')
				{
					 swal(
					 ''+$scope.inspectionDto.subStatus,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ScrapInspection";
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
			
			InsertService.VerifyandApproveScrapInspection($scope.inspectionDto).then(function(response)
					{
				if(response.status == 'success')
				{
					 swal(
					 ''+$scope.inspectionDto.subStatus,
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ScrapInspection";
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
		
		$scope.inspectionDto.subStatus = "";
	}
	
	$scope.cancel = function()
	{
		getAllScrapInspection();
		$scope.InspectionMgt = true;
		$scope.editInspection = false;
	}
	
	
	
	$scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>')
    .withButtons([            
    	'excel',
    	'colvis'
]);
	

});