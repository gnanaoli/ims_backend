ims.controller('dispatchLogController',function($scope,$http,TestService,$window,FetchService,InsertService,$location,UrlConstants) {
	
	$scope.dispatchLogDtoList=[];
	$scope.dispatchLogDtoForEachList=[];
	$scope.dispatchLogDtoForEachforAddList=[];
	$scope.viewEachDispatchByProject=false;
	$scope.viewDispatchLogCount=true;
	$scope.viewAssign=false;
	$scope.downloadChallanform=false;
	$scope.challanDto={};
	$scope.transPortMode = ["TWO WHEELER","FOUR WHEELER"];
	$scope.disableButton=true;
	
	/*FetchService.getAllDispatchLog().then(function(response){
		
		$scope.dispatchLogDtoList=response;
		console.log("dispatchlog===>"+JSON.stringify($scope.dispatchLogDtoList));
	});*/
	
	
       FetchService.getDispatchLogByCount().then(function(response){
		$scope.dispatchLogDtoList=response;
		console.log("dispatchlog===>"+JSON.stringify($scope.dispatchLogDtoList));
	});
	
	
       $scope.getDispatchData=function(from,To)
       {
            	   var object={
            			   requestedFrom:from,
            			   requestedTo:To
            	   }
            	   console.log(object);
            	   FetchService.getDispatchLogByRequestedTo(object).then(function(response){
            			$scope.dispatchLogDtoForEachList=response;
            			console.log("alldispatchlog list===>"+JSON.stringify($scope.dispatchLogDtoForEachList));
            		});  
            	   $scope.viewEachDispatchByProject=true;
            	   $scope.viewDispatchLogCount=false;
            	   $scope.challanDto.placeOfSupply=To;
       }
       
       
       $scope.cancelViewEachDispatchByProject=function()
       {
    	   $scope.viewEachDispatchByProject=false;
    	   $scope.viewDispatchLogCount=true;
    	   $scope.viewAssign=false;
       }
       
       $scope.Add=function()
       {
    	   var count=0;
    	   angular.forEach($scope.dispatchLogDtoForEachList,function(value,key){
    		   if(value.allocatableQuantity && value.allocatableQuantity>0)
    			   {
    			    count++;
    			   }
    	   });
    	   if(count==0)
    		   {
    		   swal(
   		    		  '',
   			      'Please Enter Transferable Quantity',
   			      'warning'
   			    )
   			    return false;
    		   }
    	   else{
    		   var counter=0;
        	   angular.forEach($scope.dispatchLogDtoForEachList,function(value,key){
        		   if(value.selected)
        			   {
        			   counter++;
        			   }
        	   });
        	   if(counter==0)
        		   {
        		   swal(
       		    		  '',
       			      'Please Check The Row',
       			      'warning'
       			    )
       			    return false;
        		   }
    		   $scope.viewAssign=true;
        	   $scope.dispatchLogDtoForEachforAddList=[];
        	   angular.forEach($scope.dispatchLogDtoForEachList,function(value,key){
        		   
        		   if(value.selected && value.allocatableQuantity>0)
        			   {
        			   $scope.dispatchLogDtoForEachforAddList.push(value);
        			   }
        		   
        	   });
    	   }
       }
       
       $scope.addToolsForTransfer=function()
       {
    	   console.log("adding tools for transfer"+JSON.stringify($scope.dispatchLogDtoForEachforAddList));
         if($scope.dispatchLogDtoForEachforAddList.length>0)
        	 {
		           $scope.viewEachDispatchByProject=false;
		       	   $scope.viewDispatchLogCount=false;
		       	   $scope.viewAssign=false;
		       	   $scope.viewChallan=true;        	 
        	 }
       }
       
       
       $scope.checkTransferableQuantity=function(id,actualQuantity,allocatableQuantity)
  	 {
  		var remaining=0;
  		if(allocatableQuantity && allocatableQuantity>0)
  			{
  		 if(parseInt(allocatableQuantity)>parseInt(actualQuantity))
  			 {
  			 swal(
  		    		  '',
  			      'Transferable Quantity should be less than Total Quantity',
  			      'warning'
  			    )
  			 angular.forEach($scope.dispatchLogDtoForEachList,function(value,key){
  				 if(id==$scope.dispatchLogDtoForEachList[key].id)
  					 {
  					 $scope.dispatchLogDtoForEachList[key].allocatableQuantity=0;
  					 }
  			 });
  			 
  			 }
  		 else{
  			 angular.forEach($scope.dispatchLogDtoForEachList,function(value,key){
  				 if(id==$scope.dispatchLogDtoForEachList[key].id)
  					 {
  					 remaining=parseInt($scope.dispatchLogDtoForEachList[key].availableQuantity)-parseInt(allocatableQuantity);
  					// $scope.assignInventoryManagementDtoList[key].leftOverQuantity=remaining;
  					 }
  			 });
  		 }
  	 }
  		else{
  			if(angular.isDefined($scope.dispatchLogDtoForEachforAddList))
  				{
  				angular.forEach($scope.dispatchLogDtoForEachforAddList,function(value,key){
  					if(value.allocatableQuantity==='0')
  						{
  						 swal(
  			  		    		  '',
  			  			      'allocatable quantity should not be zero',
  			  			      'warning'
  			  			    )
  						$scope.dispatchLogDtoForEachforAddList.splice(key,1);
  						}
  	  			 });
  				
  				}
  		}
  	 }
       
       
       /*this method is used to remove added assign inventory from page*/
  	 $scope.removeRow=function(index)
  	 {
  		 angular.forEach($scope.dispatchLogDtoForEachforAddList,function(value,key){
  			 
  			 if(value.id==index)
  				 {
  				 $scope.dispatchLogDtoForEachforAddList.splice(key,1);
  				 angular.forEach($scope.dispatchLogDtoForEachList,function(addedValue,addedKey){
  					 if(value.id==addedValue.id)
  						 {
  						 $scope.dispatchLogDtoForEachList[addedKey].selected=false;
  						 $scope.dispatchLogDtoForEachList[addedKey].allocatableQuantity=0;
  						 }
  					/* console.log("previous"+JSON.stringify($scope.assignInventoryManagementDtoList));
  					 console.log("added"+JSON.stringify($scope.addedAssignInventoryManagmentDtoList));*/
  					 
  					
  				 });
  				 }
  			 
  		 });
  	 }
       
  /*this method is used dispatch tools to project by warehouse administrator*/
	 $scope.generateChallanNo=function()
	 {
		 if($scope.deliveryChallan.$valid)
			 {
			  var object={
					  "deliveryChallanDto":$scope.challanDto,
					  "inventoryEntranceItemDto":$scope.dispatchLogDtoForEachforAddList
			  }
			  console.log("generate challan value"+JSON.stringify(object));
			  InsertService.generateChallanNo(object).then(function(response){
				  
				  if(response.status=='success')
					  {
					  swal(
						      'GENERATED!',
						      'The Challan No :'+response.number+' Please Note The Challan Number For Reference',
						      'success'
						    ).then(function(isConfirm) {
		                		if (isConfirm) {
		                			$scope.challanNo=response.number;
		               		}
		                    });	
					  $scope.viewChallan=false;
						$scope.downloadChallanform=true;
					  }
				  $scope.challanNo=response.number;
			  });
			 }
	 }
	$scope.DownloadChalan=function()
	 {
		console.log($scope.challanNo);
			//var req = {id : $scope.challanNo};		
		$('<form action="download" method="post"  target="_blank"><input type="text" name="id" value="'+$scope.challanNo+'"></form>').appendTo('body').submit();
		
		//$('<form action="download" method="post" target="_blank"><input type="text" name="id" value="1015"></form>').appendTo('body').submit();
	 }
       
	$scope.back=function()
	{
		$scope.downloadChallanform=false;
		$scope.viewAssign=true;
		$scope.viewChallan=false;
		$scope.viewEachDispatchByProject=true;
	}
	
	
	$scope.receiveToolsDto = {"challanNo":""};
	
	
	$scope.ReceiveTools=function()
	{
		if($scope.accept_challan.$valid)
			{
			 	FetchService.getInventoryAssignByChallanNo($scope.receiveToolsDto).then(function(response){
					
			    	console.log("receive tools entity list==>"+JSON.stringify(response));
			    		
			    	$scope.receiveToolsList = response;
			    	
			    	if($scope.receiveToolsList.length > 0)
			    		{
			    		$scope.challanNoInvalid = false;
			    	$scope.challan_details = true;
			    	
			    		}
					else
					{
		    			$scope.challanNoInvalid = true;
					}
			    	});
			}
	}
	
	$scope.accept=function(receiveToolsList)
	{
		if($scope.disableButton)
			{
			 $scope.disableButton=false;
		$scope.inventoryManagementDto = receiveToolsList;
		var object={
				"challanNo":$scope.receiveToolsDto.challanNo,
				"inventoryEntranceItemDto":$scope.inventoryManagementDto
		}
					if(angular.isDefined(receiveToolsList))
						{
							    InsertService.acceptInventoryFromWarehouseOrProjectSite(object).then(function(response){
							    	
							    		swal(
											      'Received!',
											      'Tools Successfully Received',
											      'success'
											    ).then(function(isConfirm) {
							                		if (isConfirm) {
							                			 //location.href=getCancelButtonByUrl(absurl);
							                			location.reload();
							               		}
							                    });
							    	});
						}
			}
	}
	
	 var absurl = $location.absUrl();
	 getCancelButtonByUrl(absurl);
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
	
       
});