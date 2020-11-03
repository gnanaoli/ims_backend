ims.controller('WorksmenManagementController', function($scope, $http, TestService, $window, FetchService,InsertService,DTOptionsBuilder,$location,UrlConstants,$timeout, $compile) {
	'use strict';
	
	$scope.WorkmenMgt = true;
	
	$scope.WorksmenDto = {};
	
	$scope.blockDtoMaster = [];
	
	$scope.projectMasterDtoList = [];
	
	$scope.view_worksmen_details={};
	
	$scope.request_worksmen = [];
	
	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!

	var yyyy = today.getFullYear();
	if(dd<10){
	    dd='0'+dd;
	} 
	if(mm<10){
	    mm='0'+mm;
	} 
	$scope.todayDate = dd+'/'+mm+'/'+yyyy;
	
	
	
	$scope.addrequestWorksmen = function(formValid)
	{
		if(formValid)
			{
			
			var add = false;
			
			var object = {
					"date":$scope.WorksmenDto.date,
					"comments":$scope.WorksmenDto.comments,
					"resourceCount":$scope.WorksmenDto.resourceCount,
					"worksMenCategoryDto":[{"category":$scope.WorksmenDto.worksMenCategoryDto.category}],
					"projectDto":[{"name":$scope.WorksmenDto.projectDto.name}],
			}
			
			if($scope.request_worksmen.length == 0){
				$scope.showDetails = true;
				
				$timeout(function() {
					$('#category').val(null).trigger('change');
					$('#name').val(null).trigger('change');
				}, 1);
				$scope.request_worksmen.push(object);
				$scope.WorksmenDto = {};
				
			    $timeout(function() {
			        $scope.addWorksmen.$setPristine();
			        $scope.addWorksmen.$setUntouched();
			      })
			}
			else
				{
					for(i=0;i<$scope.request_worksmen.length;i++)
					{
						if(($scope.request_worksmen[i].projectDto[0].name == object.projectDto[0].name) && ($scope.request_worksmen[i].worksMenCategoryDto[0].category == object.worksMenCategoryDto[0].category))
						{	
			 		  			swal(
									'',
				                    'Already Added',
				                    'warning'
					 		  	  )
							return false;
						}
						else
							{
								add = true;		
							}
					}
					
					
					if(add)
					{
						$scope.request_worksmen.push(object);
						$timeout(function() {
							$('#category').val(null).trigger('change');
							$('#name').val(null).trigger('change');
						}, 1);
						
						$scope.WorksmenDto={};
					    $timeout(function() {
					        $scope.addWorksmen.$setPristine();
					        $scope.addWorksmen.$setUntouched();
					      })
						return true;
					}
					
				}
			
			}
	}
	
	$scope.removeRow = function (idx) {
		  $scope.request_worksmen.splice(idx, 1);
		};

	
	FetchService.getAllWorksmen().then(function(response) {
		
		$scope.WokrsmenDtoMaster = response;
		console.log(JSON.stringify(response));
		
	});
	
	
	FetchService.getAllWorksMenCategory().then(function(response) {
		
		$scope.WokrsMenCategoryMaster = response;
		//console.log(JSON.stringify(response));
		
	});
	
	FetchService.getCurrentUserProjectDropDown().then(function(response){
		
		$scope.projectMasterDtoList=response;
		
	});
	
	
	$scope.saveWorksmen = function()
	{
		if($scope.request_worksmen.length != 0)
			{
			
			console.log(JSON.stringify($scope.request_worksmen));
			
			InsertService.saveWorksMen($scope.request_worksmen).then(function(response)
					{
				if(response.status == 'success')
				{
					 swal(
					 'WorksMen Saved',
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"WorksmenManagement";
                 		}
                      });
				}
			else
				{
	 		  		swal(
						''+response.exceptionMessage+'',
	                    '',
	                    'warning'
		 		  	  )
				}
					});
			
			}
		else
			{
		  		swal(
						'',
	                    'Add Worksmen',
	                    'warning'
		 		  	  )
			}
	}
	
	
	$scope.updateSaveWorksmen = function()
	{
		
		var object = {
				"id":$scope.WorksmenDto.id,
				"date":$scope.WorksmenDto.date,
				"comments":$scope.WorksmenDto.comments,
				"resourceCount":$scope.WorksmenDto.resourceCount,
				"worksMenCategoryDto":[{"category":$scope.WorksmenDto.worksMenCategoryDto1.category}],
				"projectDto":[{"name":$scope.WorksmenDto.projectDto1.name}],
		}
		
		
		if($scope.addWorksmen.$valid)
		{
			
			$scope.request_worksmen.push(object);
			InsertService.saveWorksMen($scope.request_worksmen).then(function(response)
					{
				if(response.status == 'success')
				{
					 swal(
					 'WorksMen Updated',
                     '',
                     'success'
					 ).then(function(isConfirm) {
                  		if (isConfirm) {
                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"WorksmenManagement";
                 		}
                      });
				}
			else
				{
	 		  		swal(
						''+response.exceptionMessage+'',
	                    '',
	                    'warning'
		 		  	  )
				}
					});
		}
	}
	

	
	
	$scope.edit = function(worksmen_details)
	{
		console.log(JSON.stringify(worksmen_details));
		$scope.WorkmenMgt = false;
		$scope.editWorksmen = true;
		
//		var CategoryName = worksmen_details.worksMenCategoryDto1.category;
//		
//		$scope.WorksmenDto = {
//				"id":worksmen_details.id,
//				"date":worksmen_details.date,
//				"comments":worksmen_details.comments,
//				"resourceCount":worksmen_details.resourceCount,
//				"worksMenCategoryDto":{"category":CategoryName},
//				"projectDto":{"name":worksmen_details.projectDto1.name},
//		}
		$scope.WorksmenDto = worksmen_details;
		$timeout(function() {
			$('#name').val(worksmen_details.projectDto1.name).trigger('change');
			$('#category').val(worksmen_details.worksMenCategoryDto1.category).trigger('change');
		}, 1);
		
	}
	
	$scope.cancel = function()
	{
		$scope.WorkmenMgt = true;
		$scope.editWorksmen = false;
	}
	
	$scope.back = function()
	{
		location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"WorksmenManagement";
	}
	
	$scope.validate = function()
	{
		if($scope.WorksmenDto.resourceCount <= 0)
			{
				$scope.WorksmenDto.resourceCount = "";
			}
	}
	
	$scope.validate_check = function(val,id)
	{
		if(val <= 0)
		{
			 angular.forEach($scope.WokrsMenCategoryMaster,function(value,key){
  				 if(id==$scope.WokrsMenCategoryMaster[key].id)
  					 {
  					 $scope.WokrsMenCategoryMaster[key].resourceCount="";
  					 }
  			 });
		}
		

	}

	 $scope.dtOptions = DTOptionsBuilder.newOptions()
	    .withDOM('<"top"lrf><"bottom"tip>')
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
	
	   $scope.view = function(worksmen_details) {   	
	    	$("#myModal").modal('show');
	    	$scope.view_worksmen_details = worksmen_details;
	    }
	   
	   
	   
		$scope.addWorksMenNew = function()
		{
			if($scope.addWorksmen.name.$valid && $scope.addWorksmen.date.$valid )
				{
		    	   var count=0;
		    	   angular.forEach($scope.WokrsMenCategoryMaster,function(value,key){
		    		   if(value.resourceCount && value.resourceCount>0)
		    			   {
		    			    count++;
		    			   }
		    	   });
		    	   if(count==0)
		    		   {
		    		   swal(
		   		    		  '',
		   			      'Please Enter Resource Count',
		   			      'warning'
		   			    )
		   			    return false;
		    		   }
		    	   else{
		    		   var counter=0;
		        	   angular.forEach($scope.WokrsMenCategoryMaster,function(value,key){
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
		        	   $scope.WorksMenDetailsAddList=[];
		        	   angular.forEach($scope.WokrsMenCategoryMaster,function(value,key){
		        		   
		        		   if(value.selected && value.resourceCount>0)
		        			   {
		        			   value.id = "";
		        			   value.projectDto=[{"name":$scope.WorksmenDto.projectDto.name}];
		        			   value.date=$scope.WorksmenDto.date;
		        			   value.worksMenCategoryDto=[{"category":value.category}];
		        			   $scope.WorksMenDetailsAddList.push(value);
		        			   }
		        		   
		        	   });
		    	   }
		    	   
		    	   
		    	   if($scope.WorksMenDetailsAddList)
		    		   {
		    		   
		    		   console.log(JSON.stringify($scope.WorksMenDetailsAddList));
		    		   
						InsertService.saveWorksMen($scope.WorksMenDetailsAddList).then(function(response)
								{
							if(response.status == 'success')
							{
								 swal(
								 'WorksMen Saved',
			                     '',
			                     'success'
								 ).then(function(isConfirm) {
			                  		if (isConfirm) {
			                  			location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"WorksmenManagement";
			                 		}
			                      });
							}
						else
							{
				 		  		swal(
									''+response.exceptionMessage+'',
				                    '',
				                    'warning'
					 		  	  )
							}
								});
		    		   }
				}
		}	
});