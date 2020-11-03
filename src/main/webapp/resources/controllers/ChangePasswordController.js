ims.controller('ChangePasswordController',function($scope,$http,InsertService,FetchService,$filter,$location,UrlConstants) {
	
	$scope.pwd_details = {};
	
    var absurl = $location.absUrl();
	
    FetchService.getPasswordRules().then(function(response){
    	$scope.passwordRulesDto = response;
    	console.log("PasswordRules:"+JSON.stringify($scope.passwordRulesDto));
    });
	
	
	$scope.changePwd = function($event,chgpwd){
		
		if($scope.chgpwd.$valid && ($scope.pwd_details.confirmPassword.toString() == $scope.pwd_details.newpassword.toString()))
			{
			InsertService.changePassword($scope.pwd_details).then(function(response)
	    			{
				if(response.status=='success')
					{
					swal(
							 'Password Updated Successfully',
		                     '',
		                     'success'
		                       ).then(function(isConfirm) {
		                   		if (isConfirm) {
		                   			if(absurl == UrlConstants.REDIRECTOFFICEADMINIMS_URL+CURRENT_PAGENAME)
		                   			{
		                   				location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"DashBoard";
		                   			}
		                   			else if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+CURRENT_PAGENAME)
		                   			{
		                   				location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"DashBoard";
		                   			}
		                   			else
		                   			{
		                   				location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"DashBoard";
		                   			}	
		                  		}
		                       });
					}
				else if(angular.isDefined(response.exceptionMessage)){
					swal(
							response.exceptionMessage,
							 '',
		                     'warning'
		                       ).then(function(isConfirm) {
		                   		if (isConfirm) {
		                  		}
		                       });
				}

	    			});
			}
		
	}
	


	
	$scope.cancel=function()
	{
		if(absurl == UrlConstants.REDIRECTOFFICEADMINIMS_URL+CURRENT_PAGENAME)
		{
			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"DashBoard";
		}
		else if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+CURRENT_PAGENAME)
		{
			location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"DashBoard";
		}
		else
		{
			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"DashBoard";
		}		
	}
});