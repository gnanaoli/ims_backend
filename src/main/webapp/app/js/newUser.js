 $(document).ready(function(){
	 var roleArray=[];
	 $('.ch').click('change', function() {
		  roleArray=[];
	        $(':checkbox:checked').each(function(i){
	        	console.log($(this).attr('id'));
	        	var Role={
	        		roleName:$(this).val()
	        	}
	        	roleArray.push(Role);
	        });
	        console.log(JSON.stringify(roleArray));
		    
		});
	 
	 $('#userForm').on('submit' , function(e){
  	   e.preventDefault();
     var userDto = {
    		 userName: $("#userName").val(),
  		   designation:$("#designation").val(),
  		    mobileNumber:$("#mobileNumber").val(),
  		       emailId:$("#emailId").val(),
  		     password:$("#password").val(),
  		     Roles:roleArray
         }
     
     console.log(JSON.stringify(userDto));
     $.ajax({
  	   		type : 'POST',
  	   		url : 'saveUser.json',
              data : JSON.stringify(userDto),
              contentType: "application/json; charset=utf-8",
              success : function(result) {
              if (result.status== 'success') {
                  swal(
                      /*  title:'USER SAVED!',
                        confirmButtonText: 'Done',
                        imageUrl:'resources/images/success.png',
                        imageWidth:'100px',
                        imageHeight:'100px'*/
                		  'Good job!',
                    	  'You clicked the button!',
                    	  'success'
                       ).then(function(isConfirm) {
                   		if (isConfirm) {
                  			window.location.href = 'UserManagement';
                  		}
                       });
                       $( '#userForm' ).each(function(){
                      	 this.reset();
                       });        
                   }else{
                          swal("USER NOT SAVED!",result,"error");
                        }
                   },
                   error : function(jqXHR, textStatus, errorThrown) {
                         alert(textStatus);
                   }
                                  
              });
     });  
    });
 
