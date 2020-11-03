ims.controller('ScrapController',function($scope, $http,$location,FetchService,InsertService,DTOptionsBuilder,$location,UrlConstants) {
	
	$scope.ScarpMaster=[];
	
	$scope.isDisabled=true;
	
	var absurl = $location.absUrl();
	
	
	if(absurl == UrlConstants.REDIRECTWAREHOUSEADMINIMS_URL+CURRENT_PAGENAME)
	{
		FetchService.getAllWareHouseScrap().then(function(response){		
			$scope.ScrapMaster=response;
		});
	}
	if(absurl == UrlConstants.REDIRECTPREFIXIMS_URL+CURRENT_PAGENAME)
	{
		FetchService.getAllScrapDetails().then(function(response){		
			$scope.ScrapMaster=response;
		});	
	}
	
	$scope.newinventory = {};
	
	$scope.updatescrap = function(event, edit_Scrap) {		
		
		
		if ($scope.edit_Scrap.$valid && $scope.isDisabled) {
			$scope.isDisabled=false;			
			
			InsertService.update_Scrap($scope.newinventory).then(function(response)
	    			{
				
				        swal(
						 'Good job!',
	                     'You clicked the button!',
	                     'success'
	                       ).then(function(isConfirm) {
	                   		if (isConfirm) {
	                   			location.href="common?link=Scrap";
	                  		}
	                       });				

	    			});		
		};
	}
	
	
	
	
	$scope.edit = function(ScarpDto) {	
		
		//var dd = {(JSON.Stringify(ScarpDto}; 
		
		$('<form action="edit_scrap" method="post"><input type="text" name="idd" value="'+ScarpDto.id+'"></form>').appendTo('body').submit();
		
	}
	
	
	
    $scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>')
    .withButtons([            
    	'excel',
    	'colvis'
]);
    
	   $scope.view = function(ScrapDto) {   	
	    	
	    	//alert(JSON.stringify(supplier_details));
	   	
	    	$("#myModal").modal('show');
	    	
	    	$scope.view_scrap_details = ScrapDto;    	
	    	
	    	
	    }
	
	
});