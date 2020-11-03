ims.controller('Scarp',function($scope, $http, DTOptionsBuilder,$location) {
	
//	$http({
//		method : 'GET',
//		url : "http://localhost:8080/inventory-kart/GetAllScarp.json",		
//		headers : {
//			'Content-Type' : 'application/json'
//		}
//	})
//	.then(
//			function successCallback(response) {				
//				$scope.supplier_master = response.data;
//			},
//			function errorCallback(response) {
//				//console.log(response);				
//			});
	
    $scope.Customers = [
        { category_type: "DRILLS", category_code: "CTD001", category_name: "Cordless 1/2 18v" ,model:"DRC12",date_of_scarp:"31/02/2018",status:"SCARP" },
        { category_type: "VEHICLES", category_code: "CTD001", category_name: "Cordless 1/2 18v" ,model:"DRC12",date_of_scarp:"31/02/2018",status:"SCARP" },
        { category_type: "PIPE TOOLS", category_code: "CTD001", category_name: "Cordless 1/2 18v" ,model:"DRC12",date_of_scarp:"31/02/2018",status:"INSPECTION required" },
        {category_type: "GENERATORS", category_code: "CTD001", category_name: "Cordless 1/2“ 18v" ,model:"DRC12",date_of_scarp:"31/02/2018",status:"SCARP" }
       ];
	
	
});