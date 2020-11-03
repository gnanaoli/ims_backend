 /* $(document).ready(function () {
    $(document).ready(function () {
        var url = window.location; */
        /* $('ul#sidebarnav a[href="'+ url +'"]').parent().addClass('active'); */
        /* $('ul#sidebarnav a').filter(function() {
             return this.href == url;
        }).parent().addClass('active');
		
		$('ul#sidebarnav > li > ul > li').each(function(){
			var test = $(this).attr('class');
			if(test == "active"){
				$(this).parent().addClass('in')
				$(this).parents('li').addClass('active');
			}
		});
    });
	
 }); */
  $(document).ready(function () {
    
	 setTimeout(function(){ 
		 var url = window.location +'';
		    
	      
	       var test = url.split("=").pop();
	     
	    
	       
	        /* $('ul#sidebarnav a[href="'+ url +'"]').parent().addClass('active'); */
	        $('ul#sidebarnav a').filter(function() {
	        	
	        	
	        	
//	        	setTimeout(() => alert(this.href.split("=").pop()), 1000);
	             return this.href.split("=").pop() == test;
	             
	        }).parent().addClass('active');
			
			$('ul#sidebarnav > li > ul > li').each(function(){
				var root = $(this).attr('class');
				
				if(root == "ng-scope active"){
					$(this).parent().addClass('in')
					$(this).parents('li').addClass('active');
				}
			});
			
	 }, 50);
       
    
	
 });