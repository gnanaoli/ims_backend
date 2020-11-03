//var currentTheme = "";

ims.controller('HeaderController', function($scope, $http, TestService,
		$window, FetchService, InsertService, DTOptionsBuilder) {

	$scope.notificationDtoList = [];

	$scope.notificationDtoOfficeCount = [];

	FetchService.getAllMyRequest().then(
			function(response) {
				$scope.MyRequestDtoList = response;

				$scope.notifiCount = $scope.MyRequestDtoList.length;

			});

	$("*[data-theme]").click(function(e) {
		e.preventDefault();

		var theme = {
			"theme" : $(this).attr('data-theme')
		};

		$('#theme').attr({
			href : 'resources/css1/colors/' + theme.theme + '.css'
		});

		InsertService.saveUserTheme(theme).then(function(response) {

		});

	});

	
	function getNotificationData(){
		
		FetchService.getNotificationData().then(function(response) {
			$scope.notificationDtoList = response;

			
			if($scope.notificationDtoList !=null){
				for (i = 0; i < $scope.notificationDtoList.length; i++) {
					if (($scope.notificationDtoList[i].requestedTo == 'OFFICE')
							&& $scope.notificationDtoList[i].notificationStatus == 'NEW' && $scope.notificationDtoList[i].status == 'QC VERIFIED') {
						$scope.notificationDtoOfficeCount
						.push($scope.notificationDtoList[i]);
					}
				}
			}
			//console.log("fgg " + JSON.stringify($scope.notificationDtoOfficeCount));

		});
		
	}
	
	getNotificationData();
	

	$scope.criteriaMatch = function(criteria) {
		console.log(JSON.stringify(criteria.length));

		for (i = 0; i < criteria.length; i++) {
			if (criteria[i].requestedTo == 'OFFICE')
				 {
				return criteria[i];
			}
		}

	};

	$scope.updateNotificationStatus = function(data) {
		InsertService.updateNotificationStatus(data).then(function(response) {

			$scope.responseDto = response;

			if (response.status == "success") {

//				$window.location.reload();

				getNotificationData();
			}
		});
	}

});
