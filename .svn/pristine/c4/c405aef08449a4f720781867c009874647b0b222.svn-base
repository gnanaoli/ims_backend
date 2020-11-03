ims.controller('requestToolsController',function($scope,$http,FetchService,$filter,InsertService,$location,UrlConstants) {
	$scope.inventoryRequestDto={};
	//$scope.catgoryDtoList=[];
	//$scope.inventoryRequestDto.status = "Requested";
	$scope.currentUserProjectDtoList=[];
	$scope.submitButton=false;
	
	/*FOR SAVE THE REQUEST TOLL*/
	$scope.saveToolsRequest=function()
	{
		console.log(JSON.stringify($scope.inventoryRequestDto));
		
		if($scope.requestTools.$valid)
			{
			$scope.submitButton=true;
			InsertService.saveToolsRequest($scope.inventoryRequestDto).then(function(response)
					{
				       if(response.status=="success")
				    	   {
				    	   swal(
									 'Tools Requested',
				                     '',
				                     'success'
									 ).then(function(isConfirm) {
				                  		if (isConfirm) {
//				                  		  location.href="common?link=ToolsRequestView";
				                  		location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"FindTool";
				                 		}
				                      });
				    	   }
					});	
			}
	}
	
	
	$scope.checkAcceptLocation = function(location){		
		
		if($scope.inventoryRequestDto.requestedTo == $scope.inventoryRequestDto.requestedFrom )
			{
			   swal(
						 'Can not accept from same Project',
	                     '',
	                     'warning'
						 )
			   $scope.inventoryRequestDto.requestedTo ='';
			}
	}
	
	
$scope.checkrequest= function(location){		
		
		if($scope.inventoryRequestDto.requestedTo == location )
			{
			   swal(
						 'Can not request to same Project',
	                     '',
	                     'warning'
						 )
			   $scope.inventoryRequestDto.requestedFrom ='';
			}
	}
	
	
	/*FOR SAVE THE  ACCEPTED REQUEST TOLL*/
	$scope.saveAcceptToolsRequest=function(val)
	{
		console.log(JSON.stringify($scope.acceptTools.$valid));
		if($scope.acceptTools.$valid)
			{
			
			if($scope.inventoryRequestDto.requestedQuantity < $scope.inventoryRequestDto.quantity)
				{
	  				swal(
						'Can not Accept more than Requested Quantity',
	                    '',
	                    'warning'
		 		  	  )
		 		  	$scope.inventoryRequestDto.quantity ='';
				}
			else
				{
				
				if($scope.inventoryRequestDto.status == "REJECTED")
					{
						$scope.inventoryRequestDto.quantity = $scope.inventoryRequestDto.requestedQuantity;
					}
				else
					{
						if($scope.inventoryRequestDto.requestedQuantity == $scope.inventoryRequestDto.quantity)
						{
							$scope.inventoryRequestDto.status = "ACCEPTED";
							$scope.readOnly = true;
						}
						
						if($scope.inventoryRequestDto.requestedQuantity < $scope.inventoryRequestDto.quantity && $scope.inventoryRequestDto.quantity != 0)
						{
							$scope.inventoryRequestDto.status = "PARTIALLY ACCEPTED";
							$scope.readOnly = true;
						}
						
						if($scope.inventoryRequestDto.quantity == 0)
						{
						$scope.inventoryRequestDto.status = "REJECTED";
						$scope.readOnly = true;
						}
					}
				

					
					console.log(JSON.stringify($scope.inventoryRequestDto));
					InsertService.saveAcceptToolsRequest($scope.inventoryRequestDto).then(function(response)
							{
						       if(response.status=="success")
						    	   {
						    	   swal( 'Tools Accepted','', 'success').then(function(isConfirm) {
						                  		if (isConfirm) {
						                  			
						                  			if(val == "warehouse")
						                  			{
						                  				location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"ToolsRequestView";
						                  			}
						                  			else if(val == "user")
						                  			{
						                  				location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ToolsRequestView";
						                  			}	
						                 		}
						                      });
						    	   }
						       else if(response.status=="REJECTED")
					    	   {
					    	   
					    	   swal(
										 'Tools Rejected','', 'warning').then(function(isConfirm) {
					                  		if (isConfirm) {
					                  			if(val == "warehouse")
					                  			{
					                  				location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"ToolsRequestView";
					                  			}
					                  			else if(val == "user")
					                  			{
					                  				location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ToolsRequestView";
					                  			}	
					                 		}
					                      });
					    	   }
						       else if(angular.isDefined(response.exceptionMessage))
						    	   {
						    	   swal(
											 response.exceptionMessage,
						                     '',
						                     'warning'
											 )
						    	   }
							});
				}

			}
	}
	
	/*FOR FETCH THE PROJECTS ASSIGNED TO THE CURRENT USER*/
FetchService.getCurrentUserProjectDropDown().then(function(response){
	console.log("==================="+JSON.stringify(response));
		$scope.currentUserProjectDtoList=response;
	});

/*FOR FETCH THE PROJECTS ASSIGNED TO THE CURRENT USER AND THE PROJECT NOT TO BE CLOSED*/
FetchService.getCurrentUserNonClosedProjectDropDown().then(function(response){
	console.log("==================="+JSON.stringify(response));
		$scope.currentUserNonClosedProjectDtoList=response;
	});

/*FOR FETCH THE WAREHOUSE ASSIGNED TO THE CURRENT USER*/
FetchService.getCurrentUserWareHouseDropDown().then(function(response){
		$scope.currentUserWareHouseDtoList=response;
	});

/*FOR FETCH THE TOOLS REQUEST TO THE CURRENT USER's ASSIGNED PROJECT*/
FetchService.getUserToolsRequest().then(function(response){
	
	$scope.inventoryRequestDtoList=response;
});
	
/*FOR VIEW AND ACCEPT THE TOOLS REQUEST*/ 
$scope.viewAccept = function(inventoryRequestDto) {
	var req = {id : inventoryRequestDto.id};		
	$('<form action="getToolsRequestById" method="post"><input type="text" name="id" value="'+inventoryRequestDto.id+'"></form>').appendTo('body').submit();
}



$scope.cancel = function(val)
{
		if(val == "warehouse")
			{
				location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"ToolsRequestView";
			}
			else if(val == "user")
			{
				location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ToolsRequestView";
			}
}

$scope.cancel_req = function(val)
{
	if(val == "warehouse")
	{
		location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"FindTool";
	}
	else if(val == "user")
	{
		location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"FindTool";
	}
}

/*var absurl = $location.absUrl();


$scope.cancel=function(val)
{
	if(val == "warehouse")
	{
		location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"ToolsRequestView";
	}
	else if(val == "user")
	{
		location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ToolsRequestView";
	}
}*/



$scope.readOnly = false;

$scope.validateQty = function(qty)
{
	if($scope.inventoryRequestDto.requestedQuantity < qty)
		{
	  			swal(
					'Can not Accept more than Requested Quantity',
                    '',
                    'warning'
	 		  	  )
		}
	
	if($scope.inventoryRequestDto.requestedQuantity == qty)
	{
	$scope.inventoryRequestDto.status = "ACCEPTED";
	$scope.readOnly = true;
	}
	if($scope.inventoryRequestDto.requestedQuantity > qty && qty != 0)
	{
	$scope.inventoryRequestDto.status = "PARTIALLY ACCEPTED";
	$scope.readOnly = true;
	}
	if(qty == 0)
	{
	$scope.inventoryRequestDto.status = "REJECTED";
	$scope.readOnly = true;
	}
}



$scope.validateRequiredQty = function(qty)
{
	if(parseInt($scope.inventoryRequestDto.avilableQuantity) < parseInt(qty))
		{
	  			swal(
					' Required Quantity Should Not be Greater Than  Available Quantity',
                    '',
                    'warning'
	 		  	  )
	 		  	$scope.inventoryRequestDto.quantity="";
		}
	else if(parseInt(qty)==0){
		swal(
				'Quantity should not be zero',
                '',
                'warning'
 		  	  )
 		 	$scope.inventoryRequestDto.quantity="";
	}
}
	
$scope.view = function(inventoryRequestDto) {   	
	$("#myModal").modal('show');
	$scope.inventoryRequestDto = inventoryRequestDto;    	
}


});