ims.factory('FetchService',function($http,$q,UrlConstants) {
	
	
	return {
		getAllCategoryTypes:getAllCategoryTypes,
		getAllTypes:getAllTypes,
		getAllProjectName:getAllProjectName,
		getSubCategoryByCategory:getSubCategoryByCategory,
		getAllInventoryManagement,getAllInventoryManagement,
		getAllSupplierDetails:getAllSupplierDetails,
		getAllProjectList:getAllProjectList,
		getAllHistoryOfTask:getAllHistoryOfTask,
		getAllWareHouseList:getAllWareHouseList,
		getAllActiveWareHouse:getAllActiveWareHouse,
		getAllScrapDetails:getAllScrapDetails,
		getAllManufacturerList:getAllManufacturerList,
		getAllActiveManufacturer:getAllActiveManufacturer,
		getAllCategoryList:getAllCategoryList, 
		getAllTools:getAllTools, 
		getAllToolsScrapMove:getAllToolsScrapMove,
		getAllUsers:getAllUsers,
		getAllRoles:getAllRoles,
		getAllCountryAndStatesAndProject:getAllCountryAndStatesAndProject,
		getAllCity:getAllCity,
		getAllCountry:getAllCountry,
		getAllState:getAllState,
		findTools:findTools,
		getCurrentUserProjectDropDown:getCurrentUserProjectDropDown,
		getCurrentUserWareHouseDropDown:getCurrentUserWareHouseDropDown,
		getUserToolsRequest:getUserToolsRequest,
		getCurrentUserInventoryAssign,getCurrentUserInventoryAssign,
		getMoveRequestNotifications:getMoveRequestNotifications,
		getCurrentUserPages:getCurrentUserPages,
		getDesignation:getDesignation,
		getAllSecretQuestions:getAllSecretQuestions,
		getProfileDetails:getProfileDetails,
		getAllActiveProjectTypes:getAllActiveProjectTypes,
		getAllActiveProjectStatus:getAllActiveProjectStatus,
		getAllSubCategory:getAllSubCategory,
		getAllInventoryManagementFromStockForAssign:getAllInventoryManagementFromStockForAssign,
		getAllWareHouseBlocks:getAllWareHouseBlocks,
		getAllWorksmen:getAllWorksmen,
		getAllWorksMenCategory:getAllWorksMenCategory,
		getAllELCB:getAllELCB,
		getAllSafetyStatus:getAllSafetyStatus,
		getAllWareHouseBlocksByWareHouseName:getAllWareHouseBlocksByWareHouseName,
		getReport:getReport,
		getAllMyRequest:getAllMyRequest,
		getAllProjectType:getAllProjectType,
		getAllProjectStatus:getAllProjectStatus,
		getPasswordRules:getPasswordRules,
        getAllEmployee:getAllEmployee,
        getAllDepartment:getAllDepartment,
        getAllIdProofList:getAllIdProofList,
        getAllDispatchLog:getAllDispatchLog,
        getDispatchLogByCount:getDispatchLogByCount,
        getDispatchLogBySiteName: getDispatchLogBySiteName,
        getDispatchLogByRequestedTo:getDispatchLogByRequestedTo,
        getInventoryAssignByChallanNo:getInventoryAssignByChallanNo,
        getAllInspectionDetails:getAllInspectionDetails,
        getAllDeliveryChallan:getAllDeliveryChallan,
        getAllUserWareHouseBlock:getAllUserWareHouseBlock,
        getAllService:getAllService,
        getAllEmployeeId:getAllEmployeeId,
        getAllScrapInspection:getAllScrapInspection,
        getAllServiceInspection:getAllServiceInspection,
        getNotificationData:getNotificationData,
        getAllUserScrap:getAllUserScrap,
        getAllWareHouseScrap:getAllWareHouseScrap,
        getCurrentUserNonClosedProjectDropDown:getCurrentUserNonClosedProjectDropDown,
        
	}
	
	
	function getAllSupplierDetails() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSUPPLIERS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("SupplierList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllInventoryManagement() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLINVENTORY,		
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
				});
		return deferred.promise;
	}
	
	
	
	function getAllCategoryTypes() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLCATEGORYTYPE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("categoryList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllTypes() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLTYPE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("typeList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getSubCategoryByCategory(categoryType) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.GETSUBCATEGORYBYCATEGOTY+categoryType,
			data : categoryType,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("subCategoryDtoList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}

	function getAllProjectName() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLPROJECT,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("projectDtoList=>"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllProjectList() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLPROJECTDTOLIST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	/*WARE HOUSE*/
	
	/*FOR GET ALL VALUES FOR WARE HOUSE TABLE*/
	
	function getAllWareHouseList() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLWAREHOUSEDTOLIST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("wareHouseList"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					alert(response);
				});
		return deferred.promise;
	}
	
	/*FOR WARE HOUSE NAME DROP DOWN*/
	function getAllActiveWareHouse() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLACTIVEWAREHOUSE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("Active Ware HouseList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	/*FOR MANUFACTURER NAME DROP DOWN*/
	function getAllActiveManufacturer() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLACTIVEMANUFACTURER,
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
	/*FOR PROJECT TYPE  DROP DOWN*/
	function getAllActiveProjectTypes() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLACTIVEPROJECTTYPES,
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
	/*FOR PROJECT STATUS  DROP DOWN*/
	function getAllActiveProjectStatus() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETACTIVEPROJECT_STATUS,
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

	function getAllScrapDetails() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSCRAP,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("ScrapDetails"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
/*MANUFACTURER */
	
	/*FOR GET ALL VALUES FOR MANUFACTURER  TABLE*/
	
	function getAllManufacturerList() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLMANUFACTURERDTOLIST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("All Category List"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	/*FOR GET ALL VALUES TO CATEGORY TABLE*/
	
	function getAllCategoryList() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLCATEGORYDTOLIST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("categoryList"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	
	function getAllTools() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLTOOLS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("All Tools List"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllToolsScrapMove() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLTOOLSFORSCRAP,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("ScrapList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	/*FOR country,state and project dropdown*/
	function getAllCountryAndStatesAndProject() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLCOUNTRYANDSTATEANDPROJECT,
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
	
	function getAllRoles() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLROLES,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllUsers() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url :  UrlConstants.GETALLUSERS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("UsersDtoList"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllCity() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLCITY,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllCityList"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllCountry() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLCOUNTRY,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllCityList"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllState() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSTATE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllCityList"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
function findTools(findTools) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url :  UrlConstants.GETALLTOOLSLIST,
			data : findTools,
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


/*FOR THE PROJECT WHICH ARE MAPPED TO THE PARTICULAR LOGED USER*/
	function getCurrentUserProjectDropDown() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETCURRENTUSERPROJECTDROPDOWN,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	/*FOR THE PROJECT WHICH ARE MAPPED TO THE PARTICULAR LOGED USER AND THE PROJECT NOT BE CLOSED*/
	function getCurrentUserNonClosedProjectDropDown() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETCURRENTUSERNONCLOSEDPROJECTDROPDOWN,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	/*FOR THE WAREHOUSE WHICH ARE MAPPED TO THE PARTICULAR LOGED USER*/
	function getCurrentUserWareHouseDropDown() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETCURRENTUSERWAREHOUSEDROPDOWN,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	/*FOR FIND THE TOOLS REQUESTS FOR USER FROM INVENTORY REQUEST TABLE*/
	
	function getUserToolsRequest() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETUSERTOOLSREQUEST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getUserToolsRequest"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}	
	
	function getCurrentUserInventoryAssign() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETCURRENTUSERINVENTORYASSIGN,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getCurrentUserInventoryAssignList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getMoveRequestNotifications() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETMOVEREQUESTNOTIFICATIONS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getMoveRequestNotificationsList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllSecretQuestions() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSECRETQUESTIONS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("getAllSecretQuestionsList==>"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getCurrentUserPages() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETCURRENTUSERPAGES,
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
	
	function getDesignation() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETDESIGNATION,
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
	
	function getProfileDetails() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETPROFILEDETAILS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("ProfileDetails"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllSubCategory() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSUBCATEGORY,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("getAllSubCategoryDtoList===>"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}

	
	function getAllInventoryManagementFromStockForAssign() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLINVENTORYMGMTFROMSTOCKFORASSIGN,		
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
				});
		return deferred.promise;
	}
	
	
	
	function getAllWareHouseBlocks() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLWAREHOUSEBLOCK,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("WareHouseBlock"+JSON.stringify(response.data.responseDtoList));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllWorksmen() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLWORKSMENDETAILS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("GETALLWORKSMENDETAILS"+JSON.stringify(response.data.responseDtoList));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllWorksMenCategory() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLWORKSMENCATEGORY,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("GETALLWORKSMENDETAILS"+JSON.stringify(response.data.responseDtoList));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllELCB() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLELCB,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("GETALLELCBDETAILS"+JSON.stringify(response.data.responseDtoList));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	
	function getAllSafetyStatus() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSAFETYSTATUS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("SafetyStatus"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllWareHouseBlocksByWareHouseName(wareHouseName) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url :  UrlConstants.GETWAREHOUSEBLOCKSBYWAREHOUSENAME+"?wareHouseName="+wareHouseName,
			data : wareHouseName,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}	
	
	function getReport(reportDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.GETREPORT,
			data : reportDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("getReport"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	 /*FOR GET THE TASK HISTORY*/
	function getAllHistoryOfTask(projectsTaskDto) {
		//alert(JSON.stringify(projectsTaskDto));
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.GETALLHISTORYOFTASK,
			data : projectsTaskDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("getReport"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllMyRequest() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLMYREQUEST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("getAllMyRequest"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllProjectType() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLPROJECTTYPELIST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("PasswordRules"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
		function getAllEmployee() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLEMPLOYEE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllEmployee"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllProjectStatus() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLPROJECTSTATUSLIST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("projectStatusList"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getPasswordRules() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETPASSWORDRULES,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("PasswordRules"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllEmployee() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLEMPLOYEE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllEmployee"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllDepartment() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLDEPARTMENT,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("GETALLDEPARTMENT"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllIdProofList() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLIDPROOFLIST,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllIdProofList"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllDispatchLog() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLDISPATCHLOG,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllDispatchLog"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	
	
	function getDispatchLogByCount() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLDISPATCHLOGBYCOUNT,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllDispatchLog"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getDispatchLogBySiteName(dispatchLogDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.GETDISPATCHLOGBYSITENAME,
			data:dispatchLogDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getDispatchLogBySiteName"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	
	function getDispatchLogByRequestedTo(dispatchLogDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.GETDISPATCHLOGBYREQUESTEDTO,
			data:dispatchLogDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("GETDISPATCHLOGBYREQUESTEDTO"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getInventoryAssignByChallanNo(receiveToolsDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.GETINVENTORYASSIGNBYCHALLANNO,
			data:receiveToolsDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllInspectionDetails() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLINSPECTIONDETAILS,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("GETALLINSPECTIONDETAILS"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	function getAllDeliveryChallan(reportDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.GETALLDELIVERYCHALLAN,
			data : reportDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("getReport"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}

	
	function getAllUserWareHouseBlock() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLUSERWAREHOUSEBLOCK,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					//console.log("WareHouseBlock"+JSON.stringify(response.data.responseDtoList));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
/*FOR FIND THE TOOLS REQUESTS FOR USER FROM  REQUEST TABLE*/
	
	function getAllService() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSERVICE,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllService"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}	

	function getAllEmployeeId() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLEMPLOYEEID,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllAvaiableEmployee"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllScrapInspection() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSCRAPINSPECTION,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllScrapInspection"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	function getAllServiceInspection() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLSERVICEINSPECTION,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("getAllServiceInspection"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}

	
	function getNotificationData() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETNOTIFICATIONDATA,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("notification data==>"+JSON.stringify(response.data));
					deferred.resolve(response.data.responseDtoList);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	
	function getAllUserScrap() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLUSERSCRAP,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("GETALLUSERSCRAP"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
	function getAllWareHouseScrap() {
		var deferred = $q.defer();
		$http({
			method : 'GET',
			url : UrlConstants.GETALLWAREHOUSESCRAP,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("GETALLWAREHOUSESCRAP"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					//alert(response);
				});
		return deferred.promise;
	}
	
	
});
