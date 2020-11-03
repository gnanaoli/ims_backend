ims.controller('MyRequestController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder) {

	
	$scope.MyRequestDtoList = [];
	

	FetchService.getAllMyRequest().then(function(response){
		$scope.MyRequestDtoList=response;
	});
	
	
	  $scope.dtOptions = DTOptionsBuilder.newOptions()
	    .withDOM('<"top"lrf><"bottom"tip>')
	    .withButtons([            
	    	'excel',
	    	'colvis'
  ]);

});