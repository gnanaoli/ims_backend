ims.controller('BulkRequestController', function($scope, $http, FetchService,
		InsertService,$filter,$location,UrlConstants,$timeout) {

	$scope.request_tools = [];
	$scope.categoryMasterDtoList=[];
	$scope.subCategoryMasterDtoList=[];
	$scope.getSubCategoryByCategory="";
	
    $scope.selectTools = true;
    $scope.requestDetails = true;
	
	$scope.toolsdetails ={
		"id":"",
		"categoryType" : '',		
		"quantity" : '',
		"exceptDate" : '',
		"projectName" : '',
		"subCategoryitem":[{"id":'',"subCategory":'',"model" : ''}],
		
	};
	
	$scope.alltools = [ {
		"categoryType" : '',
		"subCategory" : '',
		"model" : '',
		"quantity" : '',
		"exceptDate" : '',
		"projectName" : '',
	} ];

	FetchService.getAllTools().then(function(response) {

		$scope.alltools = response.categoryDtoItemDto;
		$scope.allprojects = response.projectItemDto;
		console.log(JSON.stringify(response));

	});

	$scope.add = function(formValid) {
		if($scope.toolsdetails.quantity != '' && $scope.toolsdetails.exceptDate != '' && $scope.toolsdetails.projectName != '')
			{
			
			var add = false;
			
			var object={
					"id":$scope.toolsdetails.id,
					"categoryType" : $scope.toolsdetails.categoryType,
					"quantity" : $scope.toolsdetails.quantity,
					"exceptDate" : $scope.toolsdetails.exceptDate,
					"projectName" : $scope.toolsdetails.projectName,
					"subCategoryitem":[{"id":$scope.toolsdetails.subCategoryid,"subCategory":$scope.toolsdetails.subCategory,"model" : $scope.toolsdetails.model}],
			}
				
			
			//alert(JSON.stringify(object));
			
			
			if($scope.request_tools.length == 0){
				$scope.request_tools.push(object);
//				$scope.bubble1 = false;
//				$scope.bubble = false;
				console.log("Request Tools[1]" + JSON.stringify($scope.request_tools));
				
				$timeout(function() {
					$('#categoryType').val(null).trigger('change');
					$('#subCategory').val(null).trigger('change');
					$('#projectName').val(null).trigger('change');
				}, 1);
				$scope.toolsdetails={};
				$scope.toolsdetails.quantity = '';
			    $timeout(function() {
			        $scope.bulk_request.$setPristine();
			        $scope.bulk_request.$setUntouched();
			      })
				
			}else{
				
				
				for(i=0;i<$scope.request_tools.length;i++)
				{
					
					var req_projectName = $scope.request_tools[i].projectName;
					var req_model = $scope.request_tools[i].subCategoryitem[0].model;
					var obj_projectName = object.projectName;
					var obj_model = object.subCategoryitem[0].model;			
					
					
					console.log("object==>"+JSON.stringify($scope.request_tools[i]));
					
					if((req_projectName == obj_projectName) && (req_model == obj_model))
						{					
				    	   swal(
						 'The Given Tool Already Added In This Project!',
	                     '',
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
				
					$scope.request_tools.push(object);
					$timeout(function() {
						$('#categoryType').val(null).trigger('change');
						$('#subCategory').val(null).trigger('change');
						$('#projectName').val(null).trigger('change');
					}, 1);
					$scope.toolsdetails={};
					$scope.toolsdetails.quantity = '';
				    $timeout(function() {
				        $scope.bulk_request.$setPristine();
				        $scope.bulk_request.$setUntouched();
				      })
					return true;
			
				}
				
				
				
			
//				    var status=checkList(object);
//			       if(status)
//			    	   {
//			    	   swal(
//								 'The Given Tool Already Added In This Project!',
//			                     '',
//			                     'warning'
//						    )
//			    	   }
				
				
			}
			console.log("Request Tools=>[3]" + JSON.stringify($scope.request_tools));
		}
		else
			{			
// 		  		swal(
//					'Fill Empty Fields',
//                    '',
//                    'warning'
//	 		  	  )			 			
			}

		

	}
	
	
	function checkList(object)
	{
		
		var add = false;
		
		for(i=0;i<$scope.request_tools.length;i++)
		{
			
			var req_projectName = $scope.request_tools[i].projectName;
			var req_model = $scope.request_tools[i].subCategoryitem[0].model;
			var obj_projectName = object.projectName;
			var obj_model = object.subCategoryitem[0].model;			
			
			
			console.log("object==>"+JSON.stringify($scope.request_tools[i]));
			
			if((req_projectName == obj_projectName) && (req_model == obj_model))
				{					
					add = false;
					return false;
				}
			else
				{
					add = true;
				}

		}
		
		if(add)
			{
			
				$scope.request_tools.push(object);
				$timeout(function() {
					$('#categoryType').val(null).trigger('change');
					$('#subCategory').val(null).trigger('change');
					$('#projectName').val(null).trigger('change');
				}, 1);
				$scope.toolsdetails={};
				$scope.toolsdetails.quantity = '';
			    $timeout(function() {
			        $scope.bulk_request.$setPristine();
			        $scope.bulk_request.$setUntouched();
			      })
//				$scope.bubble1 = false;
//				$scope.bubble = false;
				return true;
		
			}
		
	}
	
	FetchService.getAllCategoryTypes().then(function(response){
		
		$scope.categoryMasterDtoList=response;
	});
	
	$scope.getSubCategoryByCategory=function(categoryType)
	{
		var category_id= $filter("filter")($scope.categoryMasterDtoList, {categoryType:categoryType});
		//console.log("test==>"+JSON.stringify(test[0].id));
		$scope.toolsdetails.id = category_id[0].id;
		$scope.toolsdetails.subCategory="";
		FetchService.getSubCategoryByCategory(categoryType).then(function(response){
			$scope.subCategoryMasterDtoList=response;
		});
	}
	
	
	$scope.getModelBySubCategoryName=function(subCategoryName)
	{
		   var object= $filter("filter")($scope.subCategoryMasterDtoList, {subCategory:subCategoryName});
		   $scope.toolsdetails.model=object[0].model;
		   $scope.toolsdetails.subCategoryid=object[0].id;
	}
	
	
//	$scope.show = function(){
//		
//		$scope.bubble = true;
//		$scope.bubble1 = true;
//		
//		$scope.toolsdetails.id= "";
//		$scope.toolsdetails.categoryType= "";
//		$scope.toolsdetails.subCategory= "";
//		$scope.toolsdetails.model= "";
//		$scope.toolsdetails.projectName= "";
//		$scope.toolsdetails.quantity= "";
//		$scope.toolsdetails.exceptDate= "";
//
//	}
	
	
	$scope.back = function(){
		
//		$scope.bubble = false;
//		$scope.bubble1 = false;
	}
	

	$scope.BulkRequest = function() {
		
		
		if($scope.request_tools.length != 0){
			
			$scope.submitStatus = false;
			
			 InsertService.saveBulkRequest($scope.request_tools).then(function(response)
			 {
			 if(response.status=='success')
			 {
			 swal(
			 'Ref No :'+ response.number,
			 'Request Sent Successfully',
			 'success'
			 ).then(function(isConfirm) {
			 if (isConfirm) {
				 location.href=UrlConstants.REDIRECTPREFIXIMS_URL+"ToolsRequestView";
			 }
			 });
			 }
			 else if(angular.isDefined(response.exceptionMessage)){
			 swal(
			 'failure!',
			 response.exceptionMessage,
			 'warning'
			 ).then(function(isConfirm) {
			 if (isConfirm) {
			 //location.href="supplier_management";
			 }
			 });
			 }
			
			 });
		}
		else
			{
		  			swal(
						'',
	                    'Add Atleast One Tools',
	                    'warning'
		 		  	  )
			}
		
		
	}
	
	
	$scope.validate = function()
	{
		if($scope.toolsdetails.quantity <= 0)
			{
				$scope.toolsdetails.quantity = "";
			}
	}
	
	
	$scope.removeRow = function (idx) {
		  $scope.request_tools.splice(idx, 1);
		};
	
	

});