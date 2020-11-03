ims.controller('ForgotPassword', function($scope,$http,InsertService,FetchService) {   


	$scope.userDto = {};
	
	$scope.passwordRulesDto = {};

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
		 
			InsertService.updateUserPassword($scope.userDto).then(function(response)
	    			{
				
				 //alert(JSON.stringify(response));
				 
				 
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
							'',
		                    ''+response.exceptionMessage+'',
		                    'error'
			 		  	  )
					}
				
	    			
	    			});
			}

	}
	
	$scope.readonlyStatus = false;
	
	$scope.check_user = true;
	
	
	$scope.checkuser = function(event, frgmyform)
	{
		
		$(".err_details").css("display", "block");
		
		if (frgmyform.userId.$valid)
		{
			InsertService.updateUserPassword($scope.userDto).then(function(response)
	    			{
						if(response.exceptionMessage == 'ACTIVE')
						{
							$scope.other_details = true;
							$(".other_details").css("display", "block");
							$scope.check_user = false;
							$scope.readonlyStatus = true;
					        $scope.frgmyform.$setPristine();
					        $scope.frgmyform.$setUntouched();
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


});