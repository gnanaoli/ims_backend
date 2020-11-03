ims.controller('UserActiveController',function($scope,$http,InsertService,FetchService) {   


	$scope.userDto = {};

    FetchService.getAllSecretQuestions().then(function(response){
		
    	//console.log("getAllSecretQuestions"+JSON.stringify(response));
    	$scope.secretQuestionList = response;
    		
    });
	
    
    FetchService.getPasswordRules().then(function(response){
		
    	$scope.passwordRulesDto = response;
    	console.log("PasswordRules:"+JSON.stringify($scope.passwordRulesDto));
    	
    	 //$scope.passwordRulesDetails = "UpperCase "+ $scope.passwordRulesDto.upperCaseAlphabets + "<br>" +"LowerCase "+ $scope.passwordRulesDto.lowerCaseAlphabets;
    		
    });
	
	
	$scope.forgetsubmit = function(event, frgmyform) {

		//alert(JSON.stringify($scope.userDto));
		
		if (($scope.frgmyform.$valid) && ($scope.userDto.confirmPassword.toString() == $scope.userDto.newPassword.toString()))
			{	 
		 
			InsertService.updateUserActive($scope.userDto).then(function(response)
	    			{
				if(response.status == 'success')
				{
					 swal(
					 'Password Updated Successfully !!!',
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href="login";
                 		}
                      });
				}
			else
				{
	 		  		swal(
						''+response.exceptionMessage+'',
	                    '',
	                    'error'
		 		  	  )
				}
	    			
	    			});
			}

	}

});