//var currentTheme = "";

ims.controller('HeaderController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder) {


	$scope.notificationDtoList=[];
	
	FetchService.getAllMyRequest().then(function(response){
		$scope.MyRequestDtoList=response;
		
		$scope.notifiCount = $scope.MyRequestDtoList.length;
		
	});
	
	
	 $("*[data-theme]").click(function(e){
	      e.preventDefault();
	        
	        var theme = {"theme":$(this).attr('data-theme')};
	        
	        $('#theme').attr({href: 'resources/css1/colors/'+theme.theme+'.css'});
	        
	        
			InsertService.saveUserTheme(theme).then(function(response)
	    			{

	    			});
	        
	    });
	 
	 
	 FetchService.getNotificationData().then(function(response){
		 $scope.notificationDtoList=response;
	 });
	
	 
	 $scope.updateNotificationStatus=function(notificationObject,url)
	 {
		 InsertService.updateNotificationStatus(notificationObject).then(function(response){
			location.href=url; 
		 });
	 }
	 
});


