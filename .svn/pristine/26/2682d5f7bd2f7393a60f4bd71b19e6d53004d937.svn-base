ims.controller('DeliveryChallanController', function($scope,$http,InsertService,FetchService,DTOptionsBuilder,$filter) { 
	
	/*$scope.stock_report_view = false;
	$scope.scrap_view = false;  
	$scope.tools_Request_view = false;
	$scope.Inventory_Service = false;
	$scope.ELCB = false;
	$scope.Workmen_details = false;*/
	
	$scope.reportDto ={};  
	
	$scope.reportDtoList=[];
	
	$scope.validateToDate = function()
	{
		var dateAr = $scope.reportDto.fromDate.split('/');
    	var startDate = dateAr[2] + '/' + dateAr[1] + '/' + dateAr[0].slice(-2);
    	
    	var dateAr1 = $scope.reportDto.toDate.split('/');
    	var endDate = dateAr1[2] + '/' + dateAr1[1] + '/' + dateAr1[0].slice(-2);
	
		/*var startDate =   $filter('date')($scope.reportDto.fromDate, "yyyy-mm-dd");
		var endDate =   $filter('date')($scope.reportDto.toDate, "yyyy-mm-dd");*/
		
		
		if(startDate > endDate)
			{
			$scope.reportDto.toDate="";
		}
	
	}
	
	
	$scope.search = function(reportsDto)
	{
		if ($scope.Challan.$valid) {
		
		//alert($scope.Challan.$valid);
		console.log("DeliveryChallan"+JSON.stringify($scope.reportDto));
		
			FetchService.getAllDeliveryChallan($scope.reportDto).then(function(response){
			/*console.log("DeliveryChallanList"+JSON.stringify(response));*/
	    		$scope.DeliveryChallanList=response;
	    		
	    		if($scope.DeliveryChallanList.length > 0)
	    		
	    			{
	    			
	    				$scope.SearchDetails = true;
	    			}
	    		
	    		
	    	
		});
	}
	
	}
	
	
	
	
	 $scope.DownloadChalan=function(ChallanNo)
     {
		 $scope.challanNo=ChallanNo;

            console.log($scope.challanNo);
                    //var req = {id : $scope.challanNo};                
            $('<form action="download" method="post"  target="_blank"><input type="text" name="id" value="'+$scope.challanNo+'"></form>').appendTo('body').submit();
//            $('<form action="download" method="post"  target="_blank"><input type="text" name="id" value="1048"></form>').appendTo('body').submit();
            
            
     }
		
		
		
    $scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>')
    .withButtons([            
    	{extend:'excel',text:'Download excel'}
]);	
    	
	

	
});