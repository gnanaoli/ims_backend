ims.controller('AddSupplier',function($scope,$http,TestService,$window) {
	
	$scope.isDisabled=true;
	//$scope.supplier = {"name":"John","country":"India","address1":"Anna Nagar","address2":"20th Syt","area":"thirumm","city":"chennao","state":"tamilnadu","pincode":"60566","contact_person":"FAS","telephoneno":"8484578","mobileno":"8723847","fax":"8234","emailid":"test@gmail.com","gst":"8437432"};		
	
	if($stateParams.myParam == null){		
		$scope.supplier = {"name":"","country":"USA","address1":"Anna Nagar","address2":"20th Syt","area":"thirumm","city":"Chennai","state":"tamilnadu","pincode":"60566","contact_person":"FAS","telephoneno":"8484578","mobileno":"8723847","fax":"8234","emailid":"test@gmail.com","gst":"8437432"};		
	}else{
		$scope.supplier = $stateParams.myParam;	
	}	
	
	$scope.addsupplier = function(event, add_supplier) {
		
		if ($scope.add_supplier.$valid && $scope.isDisabled) {
			$scope.isDisabled=false;			
		};
	}
	
	
    $scope.myFunction = function() {
    	
    	//console.log(JSON.stringify($scope.supplier));
    	
    	TestService.getSupplierValues($scope.supplier).then(function(response)
    			{
    		    alert(JSON.stringify(response));
    		 location.href="common?link=SupplierManagement";
    			});
    	
    }
	
});