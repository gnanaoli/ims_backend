ims.controller('ServiceDueDateController',function($scope, $http,$location,DashBoardService,FetchService,InsertService,DTOptionsBuilder,$location,UrlConstants) {
	
	
	var absurl = $location.absUrl();
//	
//	if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+CURRENT_PAGENAME)
//	{
//		DashBoardService.getServiceDueDateWareHouse().then(function(response){		
//			$scope.ServiceDueMaster=response;
//		});
//	}
//	else if(absurl == UrlConstants.REDIRECTPREFIXIMS_URL+CURRENT_PAGENAME)
//	{
//		DashBoardService.getServiceDueDateUser().then(function(response){		
//			$scope.ServiceDueMaster=response;
//		});	
//	}
//	else
//		{
//		DashBoardService.getAllServiceDueDate().then(function(response){		
//			$scope.ServiceDueMaster=response;
//			console.log(JSON.stringify($scope.ServiceDueMaster));
//		});	
//		}
	
	DashBoardService.getAllServiceDueDate().then(function(response){		
		$scope.ServiceDueMaster=response;
		console.log(JSON.stringify($scope.ServiceDueMaster));
	});
	
	
	
	   $scope.view = function(ServiceDueDto) {   	
	    	
		   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.ServiceDueDto = ServiceDueDto;    	
	    	
	    	
	    }
	
});
