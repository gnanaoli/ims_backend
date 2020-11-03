ims.controller('ServiceController',function($scope,$http,FetchService,DTOptionsBuilder) {

	FetchService.getAllService().then(function(response){
		
		$scope.serviceTrackerDtoList=response;
	});
	
$scope.sendBack = function(serviceTrackerDto) {
		                var req = {id : serviceTrackerDto.id};                
		                $('<form action="moveBackServiedTools" method="post"><input type="text" name="id" value="'+serviceTrackerDto.id+'"></form>').appendTo('body').submit();
		        }




$scope.view = function(serviceTrackerDto) {   	
   	$("#myModal").modal('show');
   	$scope.serviceTrackerDto = serviceTrackerDto;    	
   	
   	
   }



$scope.dtOptions = DTOptionsBuilder.newOptions()
    .withDOM('<"top"lrf><"bottom"tip>').withLanguage({"sEmptyTable":"No Record Found"})
    .withButtons([            
    	'excel',
    	'colvis'
]);



});
	
