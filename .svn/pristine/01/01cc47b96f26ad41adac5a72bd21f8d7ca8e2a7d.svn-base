ims.controller('SupplierManagement',function($scope, $http, DTOptionsBuilder,$location,UrlConstants) {
	
		
	$http({
		method : 'GET',
		url : UrlConstants.GETALLSUPPLIERS,		
		headers : {
			'Content-Type' : 'application/json'
		}
	})
	.then(
			function successCallback(response) {
				
				$scope.supplier_master = response.data;
				
//				console.log(response);
//				console.log(JSON.stringify(response.data));
				//alert(JSON.stringify(response.data));
				//$state.go('login');
				//$window.location.href = 'Login';
				//location.href = "Login";
			},
			function errorCallback(response) {
				//console.log(response);
				//alert(response);
			});
	
	
	
	
	$scope.edit = function(supplier_details) {
		

		var req = {id : supplier_details.id};		
		
		
		
		
//		var form = $('<form></form>').attr("id",'hiddenForm' ).attr("name", 'hiddenForm').attr("action", 'edit_supplier').attr("method", 'post');
//		$("<input type='hidden' value='"+supplier_details.id+"' >").attr("id", "idd").attr("name", "idd").appendTo("form");
//		$("#hiddenForm").submit();
		
		
//		 $('#share').append("<form action='edit_supplier' method='POST' id='hiddenForm'>");
//		 $('#share form').append("<input type='hidden' placeholder='Name' name='idd' id='idd'/>");
//		 $("#hiddenForm").submit();
		
		
		$('<form action="edit_supplier" method="post"><input type="text" name="idd" value="'+supplier_details.id+'"></form>').appendTo('body').submit();
		

		
		

		
		
		
		
	}
	
	
	
});