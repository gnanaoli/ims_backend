ims.factory('DashBoardService',function($http,$q,UrlConstants) {
	
	
	return {
		getInventoryFromSpecificUserProject:getInventoryFromSpecificUserProject,
		getInventoryCountForSpecificWareHouseAdministrator:getInventoryCountForSpecificWareHouseAdministrator,
		getInventoryCountForOfficeAdministratorFromStock:getInventoryCountForOfficeAdministratorFromStock,
		getInventoryCountForOfficeAdministratorFromAssign:getInventoryCountForOfficeAdministratorFromAssign,
		getLastOneMonthUserElcbStatus:getLastOneMonthUserElcbStatus,
		getLastOneMonthOfficeElcbStatus:getLastOneMonthOfficeElcbStatus,
		getServiceDueDateUser:getServiceDueDateUser,
		getServiceDueDateWareHouse:getServiceDueDateWareHouse,
		getAllServiceDueDate:getAllServiceDueDate,
	}
	
	function getInventoryFromSpecificUserProject() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETINVENTORYCOUNTFROMSPECIFICUSERPROJECT,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	
	function getInventoryCountForSpecificWareHouseAdministrator() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETINVENTORYCOUNTFORWAREHOUSEADMINISTRATOR,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getInventoryCountForOfficeAdministratorFromStock() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETINVENTORYCOUNTFOROFFICEADMINISTRATORFROMSTOCK,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getInventoryCountForOfficeAdministratorFromAssign() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETINVENTORYCOUNTFOROFFICEADMINISTRATORFROMASSIGN,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getLastOneMonthUserElcbStatus() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETLASTONEMONTHUSERELCBSTATUS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
				});
		return deferred.promise;
	}
	
	function getLastOneMonthOfficeElcbStatus() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETLASTONEMONTHOFFICEELCBSTATUS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
				});
		return deferred.promise;
	}
	
	function getServiceDueDateUser() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETSERVICEDUEDATEUSER,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
				});
		return deferred.promise;
	}
	
	function getServiceDueDateWareHouse() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETSERVICEDUEDATEWAREHOUSE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
				});
		return deferred.promise;
	}
	
	function getAllServiceDueDate() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSERVICEDUEDATE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
				});
		return deferred.promise;
	}
	
});