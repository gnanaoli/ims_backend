$(document).ready(function(){
	 $('#categoryForm').on('submit' , function(e){
  	   e.preventDefault();
     var categoryDto = {
    		 id: $("#id").val(),  		   
    		 categoryType: $("#categoryType").val(),
  		   categoryCode:$("#categoryCode").val(),
  		    assetTracking:$("#assetTracking").val(),
  		       status:$("#status").val(),
         }
     console.log(JSON.stringify(categoryDto));
     $.ajax({
  	   		type : 'POST',
  	   		url : 'saveCategory.json',
              data : JSON.stringify(categoryDto),
              contentType: "application/json; charset=utf-8",
              success : function(result) {
              if (result.status== 'success') {
                  swal({
                        title:'CATEGORY SAVED!',
                        confirmButtonText: 'Done',
                        imageUrl:'resources/images/success.png',
                        imageWidth:'100px',
                        imageHeight:'100px'
                       }).then(function(isConfirm) {
                   		if (isConfirm) {
                  			window.location.href = 'categoryListView';
                  		}
                       });
                       $( '#categoryForm' ).each(function(){
                      	 this.reset();
                       });        
                   }else{
                          swal("CATEGORY NOT SAVED!",result,"error");
                        }
                   },
                   error : function(jqXHR, textStatus, errorThrown) {
                         alert(textStatus);
                   }
                                  
              });
     });  
    });

