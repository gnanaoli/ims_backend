ims.controller('menuController',function($scope,$http,FetchService,$location) {
	
	$scope.MenuDtoList=[];
	FetchService.getCurrentUserPages().then(function(response)
			{
		   console.log("getCurrentUserPagesList"+JSON.stringify(response));
		     $scope.MenuDtoList=response;
			});
	
	
	$scope.reloadPage= function(link){
        console.log(link);
		location.href=link;
	}
	
});
