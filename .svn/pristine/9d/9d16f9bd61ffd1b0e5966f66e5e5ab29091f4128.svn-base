ims.controller('viewMyProfileController', function($scope, $http, FetchService,
		InsertService, $window,$location,UrlConstants) {
	
	
	 var cancelButton='';
	 
	 
	FetchService.getProfileDetails().then(function(response) {

		$scope.userDto = response;
		
		userSe = response.secretQuestion;
		
		userAns = response.secretAnswer;
		
		$scope.userDto.secretQuestion = "";
		
		$scope.wareHouseProject = response.wareHouses;

		console.log("UserDto"+JSON.stringify(response));

	});

	FetchService.getAllSecretQuestions().then(function(response) {

		// console.log("getAllSecretQuestions"+JSON.stringify(response));
		$scope.secretQuestionList = response;

	});

	FetchService.getCurrentUserProjectDropDown().then(function(response) {

		$scope.userProject = response;

		// console.log(JSON.stringify(response));

	});

	$scope.EditProfile = function(userDto) {

		// var req = {id : $scope.userDto.id};
		// $('<form action="Edituser" method="post"><input type="text" name="id"
		// value="'+userDto.id+'"></form>').appendTo('body').submit();

		if ($scope.editProfile.$valid && $scope.userDto.mobileNumber.toString().length==10) {

			InsertService.updateUserProfile($scope.userDto).then(
					function(response) {
						
						
						
						if(response.status == 'success')
						{
							 swal(
							 'Profile Updated',
		                     '',
		                     'success'
							 ).then(function(isConfirm) {
		                  		if (isConfirm) {
		                  			location.href = cancelButton;
		                 		}
		                      });
						}
					else
						{
			 		  		swal(
								'',
			                    ''+response.exceptionMessage+'',
			                    'error'
				 		  	  )
						}						

					});

		}
	}
	
	
    var absurl = $location.absUrl();
	if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"ViewMyProfile")
		{
		cancelButton="wareHouseAdmin?link=DashBoard";
		}
	else if(absurl == UrlConstants.REDIRECTOFFICEADMINIMS_URL+"ViewMyProfile")
		{
		cancelButton="officeAdmin?link=DashBoard";
		}
	else {
		cancelButton="common?link=DashBoard";
	}
	
	
	
	$scope.cancel = function() {
		location.href = cancelButton;
	}
	
	$scope.readOnlyStatus = true;
	
	$scope.MakeEditable = function() {
		$scope.readOnlyStatus = false;
	}
	
	
	$scope.showans = function(value) {		

			if(angular.isDefined(value))
			{
			   if(userSe == value)
				   {
				   		$scope.secretans = true;
				   		$scope.userDto.secretAnswer = userAns;
				   }
			   else
				   {
				        $scope.secretans = true;
				   		$scope.userDto.secretAnswer = "";
				   }
			}
			else
				{
				$scope.secretans = false;
				}
		
	}

});