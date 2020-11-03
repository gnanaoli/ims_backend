ims.controller('EditSupplier', function($scope,$http,UrlConstants) {
	
//	$scope.supplier = $stateParams.myParam;
//	
   
//	
//	var db_data =  JSON.stringify($stateParams.myParam);
//	
//	
	 $scope.myFunction = function() {
	
	
	alert(JSON.stringify($scope.supplier));
	
	$http({
		method : 'POST',
		url :  UrlConstants.REDIRECTPREFIXIMS_URL+UrlConstants.ADDSUPPLIER,
		data : $scope.supplier,
		headers : {
			'Content-Type' : 'application/json'
		}
	})
	.then(
			function successCallback(response) {
				//console.log(response);	
				location.href="common?link=SupplierManagement";
			},
			function errorCallback(response) {
				//console.log(response);				
			});
	
	 }
	
});