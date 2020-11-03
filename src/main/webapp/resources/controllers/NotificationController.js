ims.controller('NotificationController', function($scope, $http, FetchService,
		UrlConstants) {

	$scope.alertMsg = "Loading";

	$scope.notificationDtoList = [];

	FetchService.getAllNotificationDetails().then(function(response) {

		$scope.notificationDtoList = response;

		if ($scope.notificationDtoList.length == 0) {
			$scope.alertMsg = "No Records Found";
		}

	});

});
