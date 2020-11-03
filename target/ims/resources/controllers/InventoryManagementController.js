ims.controller('inventoryManagementController',function($scope,$http,InsertService,FetchService,$location,$filter,UrlConstants,DTOptionsBuilder,$timeout) {
	
	
	/*
	 * $scope.inventoryManagementDto={"categoryType":"Drums",
	 * "subCategory":"Reversible Drum","modelCode":"VPG",
	 * "supplierName":"TATA","manufacturerName":"samsung",
	 * "quantity":"1","purchaseCost":"1","purchaseDate":"05/06/2018",
	 * "isWarrantyPeriodApplicable":"NO","year":"0","month":"0","site":"chennaiwarehouse",
	 * "wareHouseBlockName":"blockA"};
	 */
	$scope.inventoryManagementDto={};
	$scope.assetTracking='';
	
	$scope.assignInventoryDto={};
	$scope.assignInventoryManagementDtoList=[];
	$scope.addedAssignInventoryManagmentDtoList=[];
	$scope.moveInventoryWareHouseDtoList=[];
	$scope.inventoryRequestDto={};
	$scope.categoryMasterDtoList=[];
	$scope.typeDtoList=[];
	$scope.moveRequestNotificationDtoList=[];
	$scope.projectMasterDtoList=[];
	$scope.subCategoryMasterDtoList=[];
	$scope.wareHouseBlockEntityList=[];
	$scope.enableWarrantyPeriod=false;
	$scope.enableServicePeriod=false;
	$scope.enableProjectSite=false;
	$scope.enableWareHouseSite=false;
	$scope.showMoveScrapToWarehouseOrShopRatio=false;
	$scope.inventoryManagementMaster=[];
	$scope.supplierMaster=[];
	$scope.wareHouseDtoList=[];
	$scope.activeWareHouseList=[];
	$scope.activeManufacturerList=[];
	$scope.inventoryAssignManagementMasterDtoList=[];
	$scope.isDisabled=true;
	$scope.actionList={
		   "MOVE TO WAREHOUSE": "MOVE TO WAREHOUSE",
		  "MOVE TO SCRAP": "MOVE TO SCRAP",
		  "MOVE TO SERVICE": "MOVE TO SERVICE"};
	
	$scope.warehouseActionList={"MOVE TO SCRAP" :"MOVE TO SCRAP", "MOVE TO SERVICE": "MOVE TO SERVICE"};
	
	$scope.workingConditionList=["WORKING","NON-WORKING"];
	$scope.valid=true;
	$scope.wareHouseDto=[{}];
	$scope.projectDto=[{}];
	$scope.viewAssign=false;
	$scope.viewAssignForm=false;
	$scope.viewAssignableTools=true;
	$scope.mandatory=false;
	var cancelButton='';
	$scope.disable=true;
	
	$scope.showInventoryGridPage=true;
	$scope.showEditInventory=false;
	$scope.readOnlyInput=false;
	$scope.readOnlyQuantity=false;
	$scope.showMoveInventory=false;
	 $scope.showWorkingCondition=false;
	 $scope.onlyNumbers = /^[1-9]+[0-9]*$/;
	 $scope.showloader=false;
	 $scope.showMoveInventoryForWarehouse=false;
	 $scope.showVehicleNumber=false;
	 
	 $scope.alertMsg = "Loading";
	
	 $scope.showAddBtn = true;
	 $scope.showSendBtn = true;
	
	
	$scope.isWarrantySelected=function(isWarrantyPeriodApplicable)
	{
		if(isWarrantyPeriodApplicable==='YES')
			{
			$scope.enableWarrantyPeriod=true;
			$scope.inventoryManagementDto.year="";
			$scope.inventoryManagementDto.month="";
			}
		else{
			$scope.enableWarrantyPeriod=false;
			$scope.inventoryManagementDto.year="0";
			$scope.inventoryManagementDto.month="0";
		}
	}
	
	$scope.isServiceSelected=function(isServiceApplicable)
	{
		if(isServiceApplicable==='YES')
			{
			$scope.enableServicePeriod=true;
			$scope.inventoryManagementDto.serviceDueDate="";
		
			}
		else{
			$scope.enableServicePeriod=false;
			$scope.inventoryManagementDto.serviceDueDate="0";
			// $scope.inventoryManagementDto.month="0";
		}
	}
	
	$scope.location=function(location)
	{
		if(location==='PROJECT SITE')
			{
			$scope.enableProjectSite=true;
			$scope.enableWareHouseSite=false;
			}
		else if(location==='WAREHOUSE')
			{
			$scope.enableWareHouseSite=true;
			$scope.enableProjectSite=false;
			}
	}
	
	
	
	$scope.checkQuantityForNewInventory=function(quantity)
	{
		if(parseInt(quantity)<=0)
			{
			swal(
		    		  '',
			      'quantity should be greater than zero',
			      'warning'
			    )
			    $scope.inventoryManagementDto.quantity='';
			}
	}
	
	
	
	$scope.saveInventory=function(event,NewInventory)
	{
		console.log(JSON.stringify($scope.NewInventory.$valid));
		if ($scope.NewInventory.$valid) {
			
			$scope.showAddBtn = false;
			
			$scope.btnDis=true;
			console.log("inside");
			 console.log("inventory Request==>"+JSON.stringify($scope.inventoryManagementDto));
				InsertService.saveNewInventory($scope.inventoryManagementDto).then(function(response)
						{
					
					       if(response.status=="success")
					    	   {
					    	   swal(
									      'Inventory Saved',
									      '',
									      'success'
									    ).then(function(isConfirm) {
					                  		if (isConfirm) {
					                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"InventoryManagement";
					                 		}
					                      });
					    	   }
					       else if(angular.isDefined(response.exceptionMessage))
							  {
					    	   
					    	   $scope.showAddBtn = true;
					    	   
							  swal(
								      'Not saved!',
								      response.exceptionMessage,
								      'warning'
								    )
								    return false;
							  }
						});	
		}
	}
	
	
	
	$scope.editInventoryManagement=function(NewInventory)
	{
		if (NewInventory) {
			$scope.isDisabled=false;
			 console.log(JSON.stringify($scope.inventoryManagementDto));
				InsertService.editInventoryManagement($scope.inventoryManagementDto).then(function(response)
						{
					console.log(JSON.stringify(response));
					       if(response.status=="success")
					    	   {
					    	   swal(
									      'Inventory Updated',
									      '',
									      'success'
									    ).then(function(isConfirm) {
					                  		if (isConfirm) {
					                  			// location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"InventoryManagement";
					                  			location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"InventoryManagement";
					                 		}
					                      });
					    	   }
						});	
		}
	}
	
	
	FetchService.getAllCategoryTypes().then(function(response){
		
		$scope.categoryMasterDtoList=response;
	});
FetchService.getAllTypes().then(function(response){
		
		$scope.typeDtoList=response;
	});
	
	
	$scope.getSubCategoryByCategory=function(categoryType)
	{
		if(categoryType)
			{
		// $scope.inventoryManagementDto.subCategory="";
		// $scope.assignInventoryDto.subCategory="";
			
		FetchService.getSubCategoryByCategory(categoryType).then(function(response){
			$scope.subCategoryMasterDtoList=response;
		});
		
		if(categoryType)
			{
			 var object= $filter("filter")($scope.categoryMasterDtoList, {categoryType:categoryType});
			 $scope.assetTracking=object[0].assetTracking;
			}
		if(categoryType==='VEHICLE')
			{
			$scope.mandatory=true;
			}
		else{
			$scope.inventoryManagementDto.modelName='';
			$scope.inventoryManagementDto.makeName='';
			$scope.inventoryManagementDto.vehicleNumber='';
			$scope.mandatory=false;
		}
			}
	}
	
	
	$scope.getModelBySubCategoryName=function(subCategoryName)
	{
		if(subCategoryName){
		   var object= $filter("filter")($scope.subCategoryMasterDtoList, {subCategory:subCategoryName});
		   $scope.inventoryManagementDto.modelCode=object[0].model;
		}
	}
	
	
FetchService.getAllSupplierDetails().then(function(response){
		
		$scope.supplierMaster=response;
		
	});

FetchService.getAllProjectList().then(function(response){
	
	$scope.projectMasterDtoList=response;
	
});


//


    var abs = $location.absUrl();
	/*
	 * FetchService.getAllWareHouseList().then(function(response){
	 * $scope.moveInventoryWareHouseDtoList=response; });
	 */
	

   
	/* FetchService.getAllWareHouseList().then(function(response) */
    FetchService.getAllActiveWareHouse().then(function(response){
		$scope.wareHouseDtoList=response;
	});
	FetchService.getCurrentUserWareHouseDropDown().then(function(response){
		$scope.activeWareHouseList=response;
	});

FetchService.getAllActiveManufacturer().then(function(response){
//	console.log("manufacturerDtoList"+JSON.stringify(response));
	$scope.activeManufacturerList=response;
});
	
// var absurl = $location.absUrl().split('?')[0];
     var absurl = $location.absUrl();
     getCancelButtonByUrl(absurl);
	if(absurl == UrlConstants.REDIRECTOFFICEADMINIMS_URL+"InventoryManagement" || absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"InventoryManagement")
{
		FetchService.getAllInventoryManagement().then(function(response){
			$scope.inventoryManagementMaster = response;
			
			if($scope.inventoryManagementMaster.length == 0){
				$scope.alertMsg = "No Records Found";
			}	
			
			//console.log("gfdgdfg"+JSON.stringify(response));
			});
//		FetchService.getCurrentUserInventoryAssign().then(function(response){
//			$scope.inventoryAssignManagementMasterDtoList = response;
//			});
		cancelButton=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"InventoryManagement";
}
	else if(absurl == UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement")
		{
		
			FetchService.getAllInventoryManagement().then(function(response){
				$scope.inventoryManagementMaster = response;
				
				
				});
			FetchService.getCurrentUserInventoryAssign().then(function(response){
				$scope.inventoryAssignManagementMasterDtoList = response;
				
				if($scope.inventoryAssignManagementMasterDtoList.length == 0){
					$scope.alertMsg = "No Records Found";
				}	
				
				});
			cancelButton=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement";
		}
	else if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"AssignInventory")
		{
		FetchService.getAllInventoryManagementFromStockForAssign().then(function(response){
			$scope.inventoryManagementMaster = response;
			
			if($scope.inventoryManagementMaster.length == 0){
				$scope.alertMsg = "No Records Found";
			}
			
			});
		cancelButton=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"AssignInventory";
		}

	if(absurl ==  UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"RequestNotification")
		{
		FetchService.getMoveRequestNotifications().then(function(response){
			$scope.moveRequestNotificationDtoList = response;
			});
		cancelButton=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"RequestNotification";
		}
	
	/* this method is used to move the tools to warehouse by Users */
	$scope.RequestInventoryToMoveFromProject=function(moveInventory)
	{
		console.log("value inside the scope"+JSON.stringify(moveInventory));
		console.log("value inside the scope"+JSON.stringify($scope.inventoryManagementDto));
		if (moveInventory) {
			if(parseInt($scope.inventoryManagementDto.quantityToBeMoved)>parseInt($scope.inventoryManagementDto.quantity))
			{
			$scope.valid=false;
			return false;
			}
		else{
			$scope.valid=true;
			swal({
				  title: 'Are you sure?',
				  text: "you want to move this to "+$scope.inventoryManagementDto.action.substring(7),
				  type: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Move'
				}).then((result) => {
				  if (result.value) {
					  var requestDto={
							  "id":$scope.inventoryManagementDto.id,
							  "category":$scope.inventoryManagementDto.categoryType,
							  "subCategory":$scope.inventoryManagementDto.subCategory,
							  "modelCode":$scope.inventoryManagementDto.modelCode,
	                          "quantity":$scope.inventoryManagementDto.quantityToBeMoved,
	                          "requestedTo":$scope.inventoryManagementDto.requestedTo,
	                          "inventoryLocation":$scope.inventoryManagementDto.inventoryLocation,
	                          "action":$scope.inventoryManagementDto.action,
	                          "requestedFrom":$scope.inventoryManagementDto.requestedFrom,
	                          "comments":$scope.inventoryManagementDto.comments,
	                          "challanStatus":$scope.inventoryManagementDto.challanStatus,
	                          "workingCondition":$scope.inventoryManagementDto.workingCondition,
	                          "scrapMoveTo":$scope.inventoryManagementDto.scrapMoveTo
					  }
					  
					  InsertService.moveInventory(requestDto).then(function(response){
						  if(response.status=="success")
							  {
							   
							  if($scope.inventoryManagementDto.action==='MOVE TO WAREHOUSE')
								  {
								  $scope.inventoryManagementDto.challanStatus='';
								  }
							  
							  if($scope.inventoryManagementDto.challanStatus=='YES')
								  {
								  swal(
									      'Moved!',
									      'Your '+$scope.actionList[$scope.inventoryManagementDto.action]+' Request With Reference No :'+response.number+' Has Been Sent to Office Admin',
									      'success'
									    ).then(function(isConfirm) {
					                  		if (isConfirm) {
					                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement";
					                 		}
					                      });
								  }
							  else if($scope.inventoryManagementDto.challanStatus=='NO')
								  {
								  swal(
									      'Moved!',
									      'Your '+$scope.actionList[$scope.inventoryManagementDto.action]+' Request With Reference No :'+response.number+' Has Been Sent to Office Admin',
									      'success'
									    ).then(function(isConfirm) {
					                  		if (isConfirm) {
					                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement";
					                 		}
					                      });
								  }
							  else{
								  swal(
									      'Moved!',
									      'Your '+$scope.actionList[$scope.inventoryManagementDto.action]+' Request With Reference No :'+response.number+',Has Been Moved,Please Check Your Dispatch Log',
									      'success'
									    ).then(function(isConfirm) {
					                  		if (isConfirm) {
					                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement";
					                 		}
					                      });
							  }
							  }
						  else if(angular.isDefined(response.exceptionMessage))
							  {
							  swal(
								      'Not Moved!',
								      response.exceptionMessage,
								      'warning'
								    )
								    return false;
							  }
					  });
				  }
				  else{
				  }
				});
		}
			
		}
		
	}
	
	/*
	 * this method is used to move the inventory to scrap or service by
	 * warehouse admin*
	 */
	$scope.moveInventoryFromWarehouseByWareHouseAdmin=function(moveInventory)
	{
		console.log("value inside the scope"+JSON.stringify(moveInventory));
		console.log("value inside the scope"+JSON.stringify($scope.inventoryManagementDto));
		if (moveInventory) {
			if(parseInt($scope.inventoryManagementDto.quantityToBeMoved)>parseInt($scope.inventoryManagementDto.quantity))
			{
			// $scope.valid=false;
			return false;
			}
			else{
				swal({
					  title: 'Are you sure?',
					  text: "you want to move this to "+$scope.inventoryManagementDto.action.substring(5),
					  type: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Move'
					}).then((result) => {
					  if (result.value) {
						  var requestDto={
								  "id":$scope.inventoryManagementDto.id,
								  "category":$scope.inventoryManagementDto.categoryType,
								  "subCategory":$scope.inventoryManagementDto.subCategory,
								  "modelCode":$scope.inventoryManagementDto.modelCode,
		                          "quantity":$scope.inventoryManagementDto.quantityToBeMoved,
		                          "requestedTo":'',
		                          "inventoryLocation":$scope.inventoryManagementDto.inventoryLocation,
		                          "action":$scope.inventoryManagementDto.action,
		                          "requestedFrom":$scope.inventoryManagementDto.site,
		                          "comments":$scope.inventoryManagementDto.comments,
		                          "challanStatus":$scope.inventoryManagementDto.challanStatus,
		                          "workingCondition":$scope.inventoryManagementDto.workingCondition,
		                          "scrapMoveTo":$scope.inventoryManagementDto.scrapMoveTo
						  }
						  
						  
						  console.log(JSON.stringify(requestDto));
						  
						  InsertService.moveInventoryForWarehouseAdmin(requestDto).then(function(response){
							  if(response.status=="success")
								  {
								// if($scope.inventoryManagementDto.challanStatus=='YES')
									// {
									  swal(
										      'Moved!',
										      'Your '+$scope.actionList[$scope.inventoryManagementDto.action]+' Request With Reference No :'+response.number+' Has Been Sent to Office Admin',
										      'success'
										    ).then(function(isConfirm) {
						                  		if (isConfirm) {
						                  			location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"InventoryManagement";
						                 		}
						                      });
									// }
								 /*
									 * else
									 * if($scope.inventoryManagementDto.challanStatus=='NO') {
									 * swal( 'Moved!', 'Your
									 * '+$scope.actionList[$scope.inventoryManagementDto.action]+'
									 * Request With Reference No
									 * :'+response.number+' Has Been Sent to
									 * Super User', 'success'
									 * ).then(function(isConfirm) { if
									 * (isConfirm) {
									 * location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement"; }
									 * }); }
									 */
								  /*
									 * else{ swal( 'Moved!', 'Your
									 * '+$scope.actionList[$scope.inventoryManagementDto.action]+'
									 * Request With Reference No
									 * :'+response.number+',Has Been
									 * Moved,Please Check Your Dispatch Log',
									 * 'success' ).then(function(isConfirm) { if
									 * (isConfirm) {
									 * location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement"; }
									 * }); }
									 */
								  }
							  else if(angular.isDefined(response.exceptionMessage))
								  {
								  swal(
									      'Not Moved!',
									      response.exceptionMessage,
									      'warning'
									    )
									    return false;
								  }
						  });
					  }
					  else{
					  }
					});
			}
		}
	}
	
	$scope.getVehicleDetails=function(challanStatus)
	{
		if(challanStatus=='YES')
			{
			$scope.showVehicleNumber=true;	
			}
		else{
			$scope.inventoryManagementDto.vehicleNo='';
			$scope.showVehicleNumber=false;	
		}
	}
	
	
	$scope.moveInventoryForWareHouse=function(inventorymanagementDto)
	{
		$scope.showMoveInventoryForWarehouse=true;
		 $scope.showInventoryGridPage=false;
		 if(inventorymanagementDto)
			 {
			 $scope.inventoryManagementDto=inventorymanagementDto;
			 }
	}
	
	
	
	$scope.sample = "Edit"; 
	
	$scope.EDIT = function(inventoryManagementDto) {
		var req = {id : inventoryManagementDto.id};		
		$('<form action="getInventoryById" method="post"><input type="text" name="id" value="'+inventoryManagementDto.id+'"><input type="text" name="page" value="InventoryEditPage"></form>').appendTo('body').submit();
	}
	
	/* this move is used to move the tools to warehouse by siteengineer */
	$scope.move=function(inventoryManagementDto)
	{
		$('<form action="getInventoryAssignById" method="post"><input type="text" name="id" value="'+inventoryManagementDto.id+'"></form>').appendTo('body').submit();
	}
	/*
	 * this confirm is used to move the tools to warehouse by admin after
	 * confirmation by giving id of assigned tools to render next page
	 */
	$scope.confirm=function(inventoryManagementDto)
	{
		$('<form action="confirmInventoryAssignById" method="post"><input type="text" name="id" value="'+inventoryManagementDto.id+'"></form>').appendTo('body').submit();
	}
	
	
	$scope.Assign=function(inventoryManagementDto)
	{
		$('<form action="getInventoryById" method="post"><input type="text" name="id" value="'+inventoryManagementDto.id+'"><input type="text" name="page" value="InventoryAssignPage"></form>').appendTo('body').submit();
	}
	
	
	
	/*
	 * this confirm is used to move the tools to warehouse by admin by clicking
	 * confirmation button
	 */
	$scope.ConfirmMoveInventoryFromProject=function()
	{
	 var alertMessage='';	
		if($scope.inventoryManagementDto.action=='MOVE TO WAREHOUSE REQUESTED')
			{
			alertMessage="WAREHOUSE";
			}
		else if($scope.inventoryManagementDto.action=='MOVE TO SCRAP REQUESTED')
			{
			alertMessage="SCRAP";
			}
		else if($scope.inventoryManagementDto.action=='MOVE TO SERVICE REQUESTED')
			{
			alertMessage="SERVICE";
			}
		
		swal({
			  title: 'Are you sure?',
			  text: "you want to move this to "+alertMessage,
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Move'
			}).then((result) =>{
				 if (result.value) {
					 
					 var requestDto={
							  "id":$scope.inventoryManagementDto.id,
							  "category":$scope.inventoryManagementDto.categoryType,
							  "subCategory":$scope.inventoryManagementDto.subCategory,
							  "modelCode":$scope.inventoryManagementDto.modelCode,
	                          "quantity":$scope.inventoryManagementDto.quantity,
	                          "wareHouseSiteName":$scope.inventoryManagementDto.requestedTo,
	                          "location":$scope.inventoryManagementDto.location,
	                          "action":$scope.inventoryManagementDto.action,
					  }
					 console.log("confirm request Dto===>"+JSON.stringify(requestDto));
					 InsertService.confirmMoveInventory(requestDto).then(function(response)
							 {
						      if(response.status=='success')
						    	  {
						    	  swal(
									      'Moved!',
									      'Successfully moved to '+alertMessage,
									      'success'
									    ).then(function(isConfirm) {
					                  		if (isConfirm) {
					                  			location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"RequestNotification";
					                 		}
					                      });
						    	  }
							 });
				 }
			});
	}
	
	
	
	/*
	 * this method is used to Assign Inventory to Project by WareHouse
	 * Administrator by clicking Assign button
	 */
	$scope.AssignInventoryToProject=function()
	{
		if($scope.AssignInventory.$valid)
			{
			if($scope.inventoryManagementDto.location=='WAREHOUSE')
				{
				$scope.inventoryManagementDto['projectItemDto']=$scope.projectDto;
				$scope.inventoryManagementDto['wareHouseDto']=[];
				}
			/*
			 * else if($scope.inventoryManagementDto.location=='WAREHOUSE') {
			 * $scope.inventoryManagementDto['wareHouseDto']=$scope.wareHouseDto;
			 * $scope.inventoryManagementDto['projectItemDto']=[]; }
			 */
		console.log("Assign Inventory"+JSON.stringify($scope.inventoryManagementDto));
		InsertService.AssignInventory($scope.inventoryManagementDto).then(function(response){
			console.log("response==>"+JSON.stringify(response));
			if(response.status=='success')
				{
				if($scope.inventoryManagementDto.projectName!="")
					{
					swal(
						      'Assigned!',
						      'The Tools From '+$scope.inventoryManagementDto.site+' To '+$scope.inventoryManagementDto.projectName+' Has Been Assigned Successfully',
						      'success'
						    ).then(function(isConfirm) {
		                		if (isConfirm) {
		                			location.href=cancelButton;
		               		}
		                    });	
					}
				else if($scope.inventoryManagementDto.wareHouseName!="")
					{
					swal(
						      'Assigned!',
						      'The Tools From '+$scope.inventoryManagementDto.site+' To '+$scope.inventoryManagementDto.wareHouseName+'Has Been Assigned Successfully',
						      'success'
						    ).then(function(isConfirm) {
		                		if (isConfirm) {
		                			location.href=cancelButton;
		               		}
		                    });	
					}
				
				}
			else if(angular.isDefined(response.exceptionMessage))
				{
				swal(
					      'Not Assigned!',
					      $scope.inventoryManagementDto.site,
					      'warning'
					    )
				}
		});
			}
	}
	
	$scope.checkQuantityLeftOver=function(allocatableQuantity)
	{
		var remaining=$scope.inventoryManagementDto.quantity-allocatableQuantity;
		if(parseInt(remaining)<0)
			{
			      swal(
			    		  '',
				      'Allocatable Quantity Should Not be Greater Than Available Quantity',
				      'warning'
				    )
				    $scope.inventoryManagementDto.allocatableQuantity='';
			}
		else{
			$scope.inventoryManagementDto.leftOverQuantity=remaining;
		}
	}
	
	$scope.checkQuantityMove=function(quantityToBeMoved)
	{
		if(parseInt(quantityToBeMoved)>parseInt($scope.inventoryManagementDto.quantity))
			{
			swal(
		    		  '',
			      'Allocatable Quantity Should not Be Greater Than Available Quantity',
			      'warning'
			    )
			    $scope.inventoryManagementDto.quantityToBeMoved='';
			}
	}
	
	
	$scope.checkQuantityMoveForMovePage=function(quantityToBeMoved)
	{
		if(parseInt(quantityToBeMoved)>parseInt($scope.inventoryManagementDto.quantity))
			{
			swal(
		    		  '',
			      'Quantity To be Moved should Not be Greater Than Available Quantity',
			      'warning'
			    )
			    $scope.inventoryManagementDto.quantityToBeMoved='';
			}
		else if(parseInt(quantityToBeMoved)=='0')
			{
			swal(
		    		  '',
			      'Quantity To be Moved should not be zero',
			      'warning'
			    )
			    $scope.inventoryManagementDto.quantityToBeMoved='';
			}
	}
	
	
	
	$scope.checkQuantityMoveForWareHouseAdminPage=function(quantityToBeMoved)
	{
		if(parseInt(quantityToBeMoved)>parseInt($scope.inventoryManagementDto.availableQuantity))
			{
			swal(
		    		  '',
			      'Quantity To be Moved should Not be Greater Than Available Quantity',
			      'warning'
			    )
			    $scope.inventoryManagementDto.quantityToBeMoved='';
			}
		else if(parseInt(quantityToBeMoved)=='0')
			{
			swal(
		    		  '',
			      'Quantity To be Moved should not be zero',
			      'warning'
			    )
			    $scope.inventoryManagementDto.quantityToBeMoved='';
			}
	}
	
	
	
	
	// this method is used in AssignInventoryToProject page
	$scope.AssignLocation=function(location)
	{
		if(location==='WAREHOUSE')
			{
			console.log("WareHouse site"+JSON.stringify($scope.inventoryManagementDto));
			$scope.inventoryManagementDto.wareHouseName='';
			}
	}
	
	$scope.cancel = function()
	{
		location.href=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"InventoryManagement";
	}
	
	$scope.cancelAssign=function()
	{
		location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"AssignInventory";
	}
	
	$scope.cancelMove=function()
	{
		location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement";
	}
	
	
	$scope.getWareHouseSelection=function(wareHouseName)
	{
		if(angular.equals($scope.inventoryManagementDto.site,wareHouseName))
			{
			swal(
		    		  '',
			      'Cannot Assign to Same WareHouse',
			      'warning'
			    )
			    $scope.inventoryManagementDto.wareHouseName='';
			}
		else if(angular.isDefined(wareHouseName))
			{
			var x= $filter("filter")($scope.activeWareHouseList, {wareHouseName:wareHouseName});
			if(x.length>0)
				{
				$scope.wareHouseDto[0].id=x[0].id;
				$scope.wareHouseDto[0].wareHouseName=x[0].wareHouseName;
				}
			}
	}
	
	
	$scope.getProjectSelection=function(projectName)
	{
		if(angular.isDefined(projectName))
			{
			var x= $filter("filter")($scope.projectMasterDtoList, {name:projectName});
			if(x.length>0)
				{
				$scope.projectDto[0].id=x[0].id;
				$scope.projectDto[0].name=x[0].name;
				}
			console.log("projectDto"+JSON.stringify($scope.projectDto));
			}
	}
	
	
	
	$scope.getWareHouseBlocks=function(wareHouseName)
	{
		FetchService.getAllWareHouseBlocksByWareHouseName(wareHouseName).then(function(response){
			console.log("$scope.wareHouseBlockEntityList---->"+JSON.stringify(response));
			$scope.wareHouseBlockEntityList = response;
			});
	}
	
	if(absurl != UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"AssignInventory")
		{
		$scope.dtOptions = DTOptionsBuilder.newOptions()
	    .withDOM('<"top"lrf><"bottom"tip>').withLanguage({"sEmptyTable":"No Record Found"})
	    .withButtons([            
	    	{extend: 'excel',
	        exportOptions: {
	           columns: ':visible:not(.not-export-col)'
	        }
	    	},
	    	{
	    	extend:'colvis'
	    	}
	]);	
		}
	 
	 $scope.view = function(inventoryManagementDetails) {   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.inventoryManagementDetails = inventoryManagementDetails;    	
	    	
	    	
	    }
	 
	 
	 $scope.editInventoryPage=function(inventorymanagementDto)
	 {
		 if(inventorymanagementDto)
			 {
			 $scope.showEditInventory=true;
			 $scope.showInventoryGridPage=false;
			 $scope.inventoryManagementDto=inventorymanagementDto;
			  console.log(JSON.stringify(inventorymanagementDto));
				 $scope.getSubCategoryByCategory(inventorymanagementDto.categoryType);
			     // $scope.inventoryManagementDto.subCategory=inventorymanagementDto.subCategory;
				 // $scope.getWareHouseBlocks(inventorymanagementDto.site);
				 // $scope.inventoryManagementDto.wareHouseBlockName=inventorymanagementDto.wareHouseBlockName;
			 if($scope.inventoryManagementDto.assetTracking=='INDIVIDUAL TRACKING')
				 {
				 $scope.readOnlyInput=true;
				 $scope.readOnlyQuantity=true;
				 }
			 else{
				 $scope.readOnlyInput=true;
				 $scope.readOnlyQuantity=false;
			 }
			 if(inventorymanagementDto.isWarrantyPeriodApplicable=='YES')
				 {
				 $scope.inventoryManagementDto.year=inventorymanagementDto.year;
				 $scope.inventoryManagementDto.month=inventorymanagementDto.month;	
				 
					$timeout(function() {
						$('#year').val(inventorymanagementDto.year).trigger('change');
						$('#month').val(inventorymanagementDto.month).trigger('change');
					}, 1);
				 
				 }
			 }
		
	 }
	 
	 $scope.moveInventoryPage=function(inventorymanagementDto)
	 {
		 if(inventorymanagementDto)
		 {
		 $scope.showMoveInventory=true;
		 $scope.showInventoryGridPage=false;
		 $scope.inventoryManagementDto=inventorymanagementDto;
		 console.log(inventorymanagementDto);
		 $scope.inventoryManagementDto.quantity=inventorymanagementDto.availableQuantity;
		 $scope.inventoryManagementDto.requestedFrom=inventorymanagementDto.assignedLocation;
		 
		 
		 }
	 }
	 
	 
	 $scope.cancelEditInventoryPage=function()
	 {
		 $scope.showEditInventory=false;
		 $scope.showInventoryGridPage=true;
	 }
	 
	 
	 $scope.cancelMoveInventoryPage=function()
	 {
		 $scope.showMoveInventory=false;
		 $scope.showInventoryGridPage=true;
	 }
	 
	 
	 $scope.cancelWarehouseMoveInventoryPage=function()
	 {
		 $scope.showMoveInventoryForWarehouse=false;
		 $scope.showInventoryGridPage=true;
	 }
	 
	
	 
	 /*
		 * <started------------------------------------------------Assign
		 * inventory
		 * section--------------------------------------------------------------started>
		 */
	 
	 $scope.search=function(assignInventoryManagementDto)
	 {
		 if(angular.isDefined(assignInventoryManagementDto))
			 {
			// $scope.showloader=true;
			 $scope.showMsg = true;
			 
			 $scope.alertMsg = "Loading...";
			 
			 $scope.assignInventoryManagementDtoList=[];
			 angular.forEach($scope.inventoryManagementMaster,function(value,key){
				 
				 if(value.categoryType==assignInventoryManagementDto.categoryType && value.subCategory==assignInventoryManagementDto.subCategory)
					 {
					 $scope.assignInventoryManagementDtoList.push(value);
					 }
			 });
			 
			 if($scope.assignInventoryManagementDtoList.length == 0){
				 $scope.alertMsg = "No Records Found";
			 }
			 
			 // $scope.showloader=true;
			 console.log("search==>"+JSON.stringify($scope.assignInventoryManagementDtoList));
			 }
		// $scope.showloader=false;
	 }
	 
	 $scope.Add=function(){
		 
		 var counter=0;
		 
		 if(parseInt($scope.assignInventoryManagementDtoList.length) == 0){
			  swal(
   		    		  '',
   			      'Please Select Category or Sub Category',
   			      'warning'
   			    )
		 }
		 else{
			 
			 angular.forEach($scope.assignInventoryManagementDtoList,function(value,key){
				 if(value.allocatableQuantity)
					 {
					 counter++;
					 }
			 });
			 if(counter==0)
				 {
				  swal(
	   		    		  '',
	   			      'Please Enter Allocatable Quantity',
	   			      'warning'
	   			    )
	   			    return false;
				 }
			 else{
				 var rowcounter=0;
				 angular.forEach($scope.assignInventoryManagementDtoList,function(value,key){
					 if(value.selected)
						 {
						 rowcounter++;
						 }
				 });
				 if(rowcounter==0)
					 {
					  swal(
		   		    		  '',
		   			      'Please Check The Row',
		   			      'warning'
		   			    )
		   			    return false;
					 }
			 $scope.viewAssign=true;
			 var count=0;
			 console.log("added===>"+JSON.stringify($scope.assignInventoryManagementDtoList));
			 angular.forEach($scope.assignInventoryManagementDtoList,function(value1,key1){
				 
				 if(value1.selected && value1.allocatableQuantity)
					 {
					 if($scope.addedAssignInventoryManagmentDtoList.length==0)
						 {
						 $scope.addedAssignInventoryManagmentDtoList.push(value1);
						 }
					 else{
						 angular.forEach($scope.addedAssignInventoryManagmentDtoList,function(value2,key2)
								 {
							     
							     if(value2.id==value1.id)
							    	 {
							    	 count++;
							    	 }
							     });
						 if(count==0)
							 {
							 
							  $scope.addedAssignInventoryManagmentDtoList.push(value1);
							 }
						 count=0;
						}
					 }
				 
			 });
		        }
			 
			 
		 }
		 

		 }
	 
	 $scope.checkAssignableQuantity=function(id,actualQuantity,allocatableQuantity)
	 {
		var remaining=0;
		var counter=0;
		if(allocatableQuantity && allocatableQuantity>0)
			{
		 if(parseInt(allocatableQuantity)>parseInt(actualQuantity))
			 {
			 swal(
		    		  '',
			      'AllocatableQuantity should be less than Quantity',
			      'warning'
			    )
			 angular.forEach($scope.assignInventoryManagementDtoList,function(value,key){
				 if(id==$scope.assignInventoryManagementDtoList[key].id)
					 {
						 $scope.assignInventoryManagementDtoList[key].allocatableQuantity=0;
						 $scope.assignInventoryManagementDtoList[key].leftOverQuantity="";
					 }
			 });
			 
			 }
		 else{
			 angular.forEach($scope.assignInventoryManagementDtoList,function(value,key){
				 if(id==$scope.assignInventoryManagementDtoList[key].id)
					 {
					 remaining=parseInt($scope.assignInventoryManagementDtoList[key].availableQuantity)-parseInt(allocatableQuantity);
					 $scope.assignInventoryManagementDtoList[key].leftOverQuantity=remaining;
					 }
			 });
		 }
	 }
		else{
			angular.forEach($scope.assignInventoryManagementDtoList,function(value,key){
				 if(id==$scope.assignInventoryManagementDtoList[key].id)
					 {
						 $scope.assignInventoryManagementDtoList[key].allocatableQuantity=0;
					 }
			 });
			if(angular.isDefined($scope.addedAssignInventoryManagmentDtoList))
				{
				angular.forEach($scope.addedAssignInventoryManagmentDtoList,function(value,key){
					
					if(value.allocatableQuantity===0)
						{
						swal(
			  		    		  '',
			  			      'allocatable quantity should not be zero',
			  			      'warning'
			  			    )
						$scope.addedAssignInventoryManagmentDtoList.splice(key,1);
						}
				});
				}
			
		}
	 }
	 
	 /* this method is used to remove added assign inventory from page */
	 $scope.removeRow=function(index)
	 {
		 angular.forEach($scope.addedAssignInventoryManagmentDtoList,function(value,key){
			 
			 if(value.id==index)
				 {
				 $scope.addedAssignInventoryManagmentDtoList.splice(key,1);
				 angular.forEach($scope.assignInventoryManagementDtoList,function(addedValue,addedKey){
					 if(value.id==addedValue.id)
						 {
						 $scope.assignInventoryManagementDtoList[addedKey].selected=false;
						 $scope.assignInventoryManagementDtoList[addedKey].allocatableQuantity=0;
						 }
					/*
					 * console.log("previous"+JSON.stringify($scope.assignInventoryManagementDtoList));
					 * console.log("added"+JSON.stringify($scope.addedAssignInventoryManagmentDtoList));
					 */
					 
					
				 });
				 }
			 
		 });
	 }
	 
/* this method is used dispatch tools to project by warehouse administrator */
	 $scope.addInventoryInDispatch=function()
	 {
		 if($scope.assignInventoryForDispatch.$valid && $scope.disable)
			 {
			 
			 $scope.showSendBtn = false;
			 
			  var object={
					  
					  "projectName":$scope.inventoryManagementDto.projectName,
					  "inventoryEntranceItemDto":$scope.addedAssignInventoryManagmentDtoList
			  }
			  console.log(JSON.stringify(object));
			  InsertService.addInventoryInDispatch(object).then(function(response){
				  
				  if(response.status=='success')
					  {
					  swal(
						      'Dispatched!',
						      'The Tools From '+$scope.addedAssignInventoryManagmentDtoList[0].site+' To '+$scope.inventoryManagementDto.projectName+ ' with Reference No :' +response.number+
						      ' is Waiting For Dispatch '
						      +'please Check Your Dispatch Log Queue',
						      'success'
						    ).then(function(isConfirm) {
		                		if (isConfirm) {
		                			location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"AssignInventory";
		               		}
		                    });	
					  }
			  });
			  $scope.disable=false;
			  $scope.showSendBtn = true;
			 }
	 }
	 
	 // check before assigning the tools
	 $scope.assignTools=function()
	 {
		 if($scope.addedAssignInventoryManagmentDtoList.length>0)
			 {
				     $scope.viewAssign=false;
					 $scope.viewAssignForm=true;
					 $scope.viewAssignableTools=false;
			 }
		 
	 }
	 
	 
	 
	 $scope.cancelAssign1=function()
	 {
		 $scope.viewAssign=true;
		 $scope.viewAssignForm=false;
		 $scope.viewAssignableTools=true;
		 $scope.disable=true;
	 }
	
	 
	 $scope.removeUnchecked=function(selected,id)
	 {
		 if(angular.isDefined($scope.addedAssignInventoryManagmentDtoList))
			 {
			 angular.forEach($scope.addedAssignInventoryManagmentDtoList,function(value,key){
				 if(value.id==id && selected==false)
					 {
					$scope.removeRow(id);
					 }
			 });
			 }
	 }
	 
	 function getCancelButtonByUrl(absurl)
	 {
		 var url='';
		 if(absurl.includes("wareHouseAdmin"))
		 {
			 url=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"InventoryManagement";
		 }
		 	else if(absurl.includes("officeAdmin"))
		 		{
		 		url=UrlConstants.REDIRECTOFFICEADMINIMS_URL+"InventoryManagement";
		 		}
		 	else{
		 		url=UrlConstants.REDIRECTPREFIXIMS_URL+"InventoryManagement";
		 	}
       return url;
	 }
	 
	 $scope.showWarehouseDropDown=false;
	 
	 $scope.showwarehouse=function()
	 {
		
		 $scope.showWarehouseDropDown=true;
	 }

	 $scope.hidewarehouse=function()
	 {
		 $scope.showWarehouseDropDown=false;
	 }
	
	 $scope.showRadio=false;
	 $scope.checkIfvehicle=function(actionValue)
	 {
		 if(actionValue==='MOVE TO SCRAP')
			 {
			 $scope.showRadio=true;
			 $scope.showWorkingCondition=false;
			 $scope.showMoveScrapToWarehouseOrShopRatio=true;
			 $scope.inventoryManagementDto.scrapMoveTo="";
			 $scope.showWarehouseDropDown=false;
			 $scope.showServiceName = false;
			
			 }
		 else if(actionValue=='MOVE TO SERVICE')
			 {
			 $scope.showServiceName = true;
			 $scope.showWorkingCondition=true;
			 $scope.showMoveScrapToWarehouseOrShopRatio=false;
			 $scope.showRadio=true;
			 $scope.showWarehouseDropDown=false;
			 $scope.showMoveScrapToWarehouseOrShopRatio=false
			 }
		 else if(actionValue=='MOVE TO WAREHOUSE')
		 {
			 $scope.showServiceName = false;
			 $scope.showWorkingCondition=false;
			 $scope.showRadio=false;
			 $scope.showMoveScrapToWarehouseOrShopRatio=false
			 $scope.showWarehouseDropDown=true;
			// $scope.showWarehouseDropDown=false;
		 }
	 }
	 /*
		 * <started------------------------------------------------Assign
		 * inventory
		 * section--------------------------------------------------------------ended>
		 */
	
	 
	
	 
});