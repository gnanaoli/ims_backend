ims.factory('InsertService',function($http,$q,UrlConstants) {

	return {
		saveNewInventory:saveNewInventory,
		saveNewProject:saveNewProject,
		saveWareHouse:saveWareHouse , 
		saveNewSupplier:saveNewSupplier,
		update_Scrap:update_Scrap,
		updateUserPassword:updateUserPassword,
		saveCategory:saveCategory,
		saveManufacturer:saveManufacturer,
		saveToolsRequest:saveToolsRequest,
		saveBulkRequest:saveBulkRequest,
		savemoveScrap:savemoveScrap,
		saveUser:saveUser,
		saveAcceptToolsRequest:saveAcceptToolsRequest,
		moveInventory:moveInventory,
		confirmMoveInventory:confirmMoveInventory,
		changePassword:changePassword,
		updateUserProfile,updateUserProfile,
		editInventoryManagement:editInventoryManagement,
		saveSubCategory:saveSubCategory,
		AssignInventory:AssignInventory,
		saveWorksMen:saveWorksMen,
		saveELCB:saveELCB,
		saveWorksMenCategory:saveWorksMenCategory,
		saveBlock:saveBlock,
		saveState:saveState,
		saveCity:saveCity,
		saveNewEmployee:saveNewEmployee,
		addInventoryInDispatch:addInventoryInDispatch,
		generateChallanNo:generateChallanNo,
		saveProjectStatus:saveProjectStatus,
		editEmployee:editEmployee,
		saveProjectType:saveProjectType,
		acceptInventoryFromWarehouseOrProjectSite:acceptInventoryFromWarehouseOrProjectSite,
		approveInspection:approveInspection,
		verifyInspection:verifyInspection,
		saveDesignation:saveDesignation,
		saveDepartment:saveDepartment,
		saveSafetyStatus:saveSafetyStatus,
		saveUserTheme:saveUserTheme,
		VerifyandApproveScrapInspection:VerifyandApproveScrapInspection,
		VerifyandApproveServiceInspection:VerifyandApproveServiceInspection,
		updateNotificationStatus:updateNotificationStatus,
		updateUserActive:updateUserActive,
		moveInventoryForWarehouseAdmin:moveInventoryForWarehouseAdmin
	}
	
	function saveNewInventory(inventoryManagementDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.SAVEINVENTORYMANAGEMENT,
			data : inventoryManagementDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
	
	function editInventoryManagement(inventoryManagementDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.EDITINVENTORYMANAGEMENT,
			data : inventoryManagementDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
	
	function saveNewProject(projectDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.SAVEPROJECT,
			data : projectDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
	/* SAVE WARE HOUSE */
	
	function saveWareHouse(wareHouseDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.SAVEWAREHOUSE,
			data : wareHouseDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
		
	function saveNewSupplier(supplierDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.ADDSUPPLIER,
			data : supplierDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {					
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					
				});
		return deferred.promise;
	}
	
	
	
	function update_Scrap(newinventory) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.EDITSCRAP,
			data : newinventory,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {					
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					
				});
		return deferred.promise;
	}
	
	
	function updateUserPassword(userDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.FORGOTPASSWORDDETAILS,
			data : userDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {					
					deferred.resolve(response.data);
					// console.log("Success"+response.data);
				},
				function errorCallback(response) {
					deferred.resolve(response.data);
					// console.log("Error"+response.data);
				});
		return deferred.promise;
	}
	
	
	function updateUserActive(userDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.USERACTIVE,
			data : userDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {					
					deferred.resolve(response.data);
					// console.log("Success"+response.data);
				},
				function errorCallback(response) {
					deferred.resolve(response.data);
					// console.log("Error"+response.data);
				});
		return deferred.promise;
	}
	
	/* save manufacturer */
	function saveManufacturer(manufacturerDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url :  UrlConstants.SAVEMANUFACTURER,
			data : manufacturerDto,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					// console.log(response);
				});
		return deferred.promise;
	}
	

	/* SAVE CATEGORY */
	
	function saveCategory(categoryDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.SAVECATEGORY,
			data : categoryDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
/* SAVE INVENTORY REQUEST */
	
	function saveToolsRequest(inventoryRequestDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.SAVETOOLSREQUEST,
			data : inventoryRequestDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
/* SAVE (saveAcceptToolsRequest)INVENTORY REQUEST */

function saveAcceptToolsRequest(inventoryRequestDto) {
	var deferred = $q.defer();
	$http({
		method : 'POST',
		url : UrlConstants.SAVEACCEPTTOOLSREQUEST,
		data : inventoryRequestDto,
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
				// alert(response);
			});
	return deferred.promise;
}
	function saveBulkRequest(seleval) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url :  UrlConstants.SAVEBULKREQUEST,
			data : seleval,
			headers : {
				'Content-Type' : 'application/json'
			}
		})
		.then(
				function successCallback(response) {
					console.log("bulk request====>"+JSON.stringify(response.data));
					deferred.resolve(response.data);
				},
				function errorCallback(response) {
					console.log(response);
					// alert(response);
				});
		return deferred.promise;
	}
	
	
	function savemoveScrap(scrap_moveDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.SAVEMOVESCRAP,
			data : scrap_moveDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
		function saveUser(userDto) {
		var deferred = $q.defer();
		$http({
			method : 'POST',
			url : UrlConstants.SAVEUSER,
			data : userDto,
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
					// alert(response);
				});
		return deferred.promise;
	}
	
		/* this service is used to give request to move the tools to warehouse */
		function moveInventory(inventoryRequestDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.MOVEINVENTORY,
				data : inventoryRequestDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		/*
		 * this service is used to confirmly move the tools to warehouse by
		 * admin
		 */
		function confirmMoveInventory(inventoryRequestDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.CONFIRMMOVEINVENTORY,
				data : inventoryRequestDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function changePassword(pwd_details) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.CHANGEPASSWORD,
				data : pwd_details,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function updateUserProfile(userDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.UPDATEUSERPROFILE,
				data : userDto,
				headers : {
					'Content-Type' : 'application/json'
				}
			})
			.then(
					function successCallback(response) {					
						deferred.resolve(response.data);
					},
					function errorCallback(response) {
						
					});
			return deferred.promise;
		}
		
		
		function saveSubCategory(subCategoryDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVESUBCATEGORY,
				data : subCategoryDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		function AssignInventory(inventoryManagementDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.ASSIGNINVENTORY,
				data : inventoryManagementDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function saveWorksMen(request_worksmen) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEWORKSMEN,
				data : request_worksmen,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function saveELCB(elcbDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEELCB,
				data : elcbDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function saveWorksMenCategory(WorksMenDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEWORKSMENCATEGORY,
				data : WorksMenDto,
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
						// alert(response);
					});
			return deferred.promise;
		}

		function saveBlock(blockDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEBLOCK,
				data : blockDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function saveState(stateDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVESTATE,
				data : stateDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function saveCity(addCityDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVECITY,
				data : addCityDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
				function saveNewEmployee(employeeDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVENEWEMPLOYEE,
				data : employeeDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function editEmployee(employeeDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.EDITEMPLOYEE,
				data : employeeDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
			
		function saveProjectType(ProjectDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEPROJECTTYPE,
				data : ProjectDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		function addInventoryInDispatch(inventoryManagementDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.ADDINVENTORYINDISPATCH,
				data : inventoryManagementDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		

   function generateChallanNo(inventoryManagementDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.GENERATECHALLENNO,
				data : inventoryManagementDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		function saveProjectStatus(ProjectDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEPROJECTSTATUS,
				data : ProjectDto,
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
						// alert(response);
					});
			return deferred.promise;
		}

		
		function acceptInventoryFromWarehouseOrProjectSite(inventoryManagementDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.ACCEPTINVENTORYFROMWAREHOUSEORPROJECTSITE,
				data : inventoryManagementDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function approveInspection(inspectionDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.APPROVEINSPECTION,
				data : inspectionDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		function verifyInspection(inspectionDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.VERIFYINSPECTION,
				data : inspectionDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function saveDesignation(DesignationDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEDESIGNATION,
				data : DesignationDto,
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
						// alert(response);
					});
			return deferred.promise;
		}


		function saveDepartment(DepartmentDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEDEPARTMENT,
				data : DepartmentDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		function saveSafetyStatus(SafetyStatusDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVESAFETYSTATUS,
				data : SafetyStatusDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function saveUserTheme(theme) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.SAVEUSERTHEME,
				data : theme,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		function VerifyandApproveScrapInspection(inspectionDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.VERIFYANDAPPROVESCRAPINSPECTION,
				data : inspectionDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function VerifyandApproveServiceInspection(inspectionDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.VERIFYANDAPPROVESERVICEINSPECTION,
				data : inspectionDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		function updateNotificationStatus(notificationObject) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.UPDATENOTFICATIONSTATUS,
				data : notificationObject,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
		function moveInventoryForWarehouseAdmin(inventoryManagementDto) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : UrlConstants.MOVEINVENTORYFORWAREHOUSEADMIN,
				data : inventoryManagementDto,
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
						// alert(response);
					});
			return deferred.promise;
		}
		
		
});
