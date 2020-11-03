ims.controller('MoveServiedToolsController',function($scope,$http,FetchService,InsertService,UrlConstants) {

	$scope.enableWareHouse=false;
	$scope.isWareHouseSeelected=function(moveBackTo)
	{
		if(moveBackTo==='WAREHOUSE')
			{
			$scope.warehouseView=true;
			$scope.projectView=false;
			}
		else{
			$scope.projectView=true;
			$scope.warehouseView=false;
		}
	}
	 
		
	
	FetchService.getAllProjectList().then(function(response){
		
		$scope.projectMasterDtoList=response;
		
	});

	FetchService.getAllWareHouseList().then(function(response){
			$scope.activeWareHouseList=response;
		});

	$scope.sendBack = function(serviceTrackerDto) {
        var req = {id : serviceTrackerDto.id};                
        $('<form action="moveBackServiedTools" method="post"><input type="text" name="id" value="'+serviceTrackerDto.id+'"></form>').appendTo('body').submit();
}
	
/*$scope.moveBackFromService = function()
{

InsertService.moveBackFromService($scope.ServiceTrackerDto)


});*/
	$scope.cancel = function()
	{
		location.href="wareHouseAdmin?link=Service";
	}
	
	
	
	/*FOR SAVE THE MOVE BACK FROM SERVICE*/
	$scope.moveBackFromService=function(event, backFromService)
	{
		if ($scope.backFromService.$valid) {
		InsertService.backFromService($scope.serviceTrackerDto).then(function(response)
				{
			       if(response.status=="success")
			    	   {
						 swal(
								 'Move Back From Service Saved Successfully !!!',
			                     '',
			                     'success'
								 ).then(function(isConfirm) {
			                  		if (isConfirm) {
			                  			
			                  		location.href=UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+"Service";
	
			                 		}
			                      });
			    	   
			    	   }
			       else if(angular.isDefined(response.exceptionMessage))
			    	{
			    	 swal(
						      'Not Saved!',
						      response.exceptionMessage,
						      'warning'
						    )
			    	}
				});
	}
	
	};
	
	
});