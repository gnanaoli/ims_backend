ims.controller('dashBoardController1',function($scope,$http,TestService,$window,FetchService,InsertService,DashBoardService,UrlConstants,$location,DTOptionsBuilder) {
	
	
	DashBoardService.getLastOneMonthUserElcbStatus().then(function(response){
		$scope.elcb_Status_Master = response;
		$scope.elcbCount = $scope.elcb_Status_Master.length;
		console.log(JSON.stringify($scope.elcb_Status_Master));
	});
	
	 FetchService.getNotificationData().then(function(response){
		 $scope.notificationDtoList=response;
	 });
	
	
	FetchService.getCurrentUserProjectDropDown().then(function(response) {

		$scope.userProject = response;
		
	});
	
	FetchService.getAllProjectList().then(function(response){
		$scope.projectDtoList=response;
		$scope.projectsCount = $scope.projectDtoList.length;
	});
	
	
	var absurl = $location.absUrl();
	
//	if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+CURRENT_PAGENAME)
//	{
//		DashBoardService.getServiceDueDateWareHouse().then(function(response){		
//			$scope.ServiceDueMaster=response;
//			$scope.serviceDueDateCount = $scope.ServiceDueMaster.length;
//		});
//	}
//	else if(absurl == UrlConstants.REDIRECTPREFIXIMS_URL+CURRENT_PAGENAME)
//	{
//		DashBoardService.getServiceDueDateUser().then(function(response){		
//			$scope.ServiceDueMaster=response;
//			$scope.serviceDueDateCount = $scope.ServiceDueMaster.length;
//		});	
//	}
//	else
//		{
//		DashBoardService.getAllServiceDueDate().then(function(response){		
//			$scope.ServiceDueMaster=response;
//			$scope.serviceDueDateCount = $scope.ServiceDueMaster.length;
//		});	
//		}
	
	DashBoardService.getAllServiceDueDate().then(function(response){		
		$scope.ServiceDueMaster=response;
		$scope.serviceDueDateCount = $scope.ServiceDueMaster.length;
	});		
	
	
	   $scope.view = function(elcb_dto) {   	
		   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.elcb_dto = elcb_dto;    	
	    	
	    }
	   
	    $scope.dtOptions = DTOptionsBuilder.newOptions()
	    .withDOM('<"top"lrf><"bottom"tip>')
	    .withButtons([            
	    	'excel',
	    	'colvis'
    ]);
	    
	    
	 $scope.showWarehouseChart = true;
	 $scope.showOfficeWarehouseChart = true;
	 $scope.showOfficeProjectChart = true;
	 $scope.showUserProjectChart = true;
	 $scope.showEnquiryProjectChart = true;
	 $scope.showEnquiryWarehouseChart = true;
	    
	
	
});