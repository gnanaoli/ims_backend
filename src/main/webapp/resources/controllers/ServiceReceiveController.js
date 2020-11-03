ims.controller('ServiceReceiveController', function($scope, $http,
		InsertService, FetchService, $filter, DTOptionsBuilder, $q, $location,
		UrlConstants, $timeout) {

	$scope.ShowServiceTracker = true;

	function getAllServiceTracker() {
		FetchService.getAllServiceTracker().then(function(response) {

			$scope.serviceTrackerList = response.responseDtoList;
			// console.log(JSON.stringify(response.responseDtoList));
		});
	}
	getAllServiceTracker();

	$scope.receive = function(data) {

		$scope.serviceDto = data;

		$scope.ShowServiceTracker = false;
		$scope.editServiceTracker = true;
	}
	
	   /*THIS IS DONE BY IBUNU MASUTH*/
	
	  $scope.availableQuantityCheck = function(){
		

		  }
		


	/*============================---------------------------------------------------------*/     
	
	
	
	
	  $scope.requiredavailableQuantity = true;
	$scope.receiveTools = function(formVaild) {

		if (formVaild) {
			
			
			  if(($scope.serviceDto.quantity!=null && $scope.serviceDto.quantity.length>0) && ($scope.serviceDto.availableQty!=null && $scope.serviceDto.availableQty.length>0)){
				  $scope.quantity = parseInt($scope.serviceDto.quantity); 
				  $scope.availableQuantity = parseInt($scope.serviceDto.availableQty);
				  
				  if($scope.serviceDto.quantity >= $scope.availableQuantity && $scope.availableQuantity!=0){
		              
					  $scope.requiredavailableQuantity = true;
						
						InsertService.receiveServiceTools($scope.serviceDto).then(
								function(response) {
									console.log(JSON.stringify(response));

									if (response.status == "success") {
										swal('Tools Received', '', 'success').then(
												function(isConfirm) {
													if (isConfirm) {
														getAllServiceTracker();
														$scope.ShowServiceTracker = true;
														$scope.editServiceTracker = false;
													}
												});

									} else {
										swal('', response.exceptionMessage, 'warning');
									}

								});
		         
				  }
		           else
		        	   //alert("incorrect");
		        	   swal('','Please Enter Quantity Less than  Available Quantity','warning');
		                 $scope.requiredavailableQuantity= false;
		           }
			
			
			
			
			

		}

	}

	$scope.cancel = function() {
		getAllServiceTracker();
		$scope.ShowServiceTracker = true;
		$scope.editServiceTracker = false;
	}

});