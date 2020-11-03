ims.factory('TestService',function($http,$q) {

	return {
		getSupplierValues:getSupplierValues,
		
	}
	
	function getSupplierValues(supplier) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : "http://localhost:8080/inventory-kart/AddSupplier.json",
			data : supplier,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					alert(JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					//console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	/*function getSupplierValues(supplier) {
		var deferred = $q.defer();
		var url = "http://localhost:8080/inventory-kart/AddSupplier.json";
		var method = "POST";
			$http.post(url).then(function (response) {
				alert(response);
				deferred.resolve(response);
			},function error(response){
				deferred.reject(response);
				console.log("error in getting response");
			});
		
		return deferred.promise;
	}*/
	
});
