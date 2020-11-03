ims.controller('ReportsController', function($scope,$http,InsertService,FetchService,DTOptionsBuilder,$filter) {

      
	$scope.alertMsg = "Loading";

       $scope.stock_report_view = false;

       $scope.scrap_view = false; 

       $scope.tools_Request_view = false;

       $scope.Inventory_Service = false;

       $scope.ELCB = false;

       $scope.Workmen_details = false;

       $scope.inventory_inwords_view= false;

       $scope.inventory_outwords_view= false;

      

       $scope.reportDto ={}; 

       $scope.searchStatus = false;

       $scope.reportDtoList=[];

       $scope.projectList=[];

       $scope.Temp_ProjectList=[];

       $scope.wareHouseEntityList=[];

       $scope.Temp_WareHouseList=[];

       $scope.listfinal=[];

       $scope.checkall_pro = function(val){

              if(val){

                     angular.forEach($scope.projectList, function(itm){ itm.selected = val; });

                     angular.copy($scope.projectList,$scope.Temp_ProjectList);

              }

              else{
            	  	angular.forEach($scope.projectList, function(itm){ itm.selected = val; });
                     $scope.Temp_ProjectList = [];

              }

       }

      

       $scope.add_pro = function(data,value){

              if(value){

                           $scope.Temp_ProjectList.push(data);
                           
                           if($scope.Temp_ProjectList.length == $scope.projectList.length){
                        	   $scope.checkall_project = true;
                           }
                           
              }

              else{
            	  
                     if($scope.Temp_ProjectList.length > 0){

                           for(i=0;i<$scope.Temp_ProjectList.length;i++){

                                  if($scope.Temp_ProjectList[i].id == data.id){

                                         let pro_index = i;

                                         $scope.Temp_ProjectList.splice(pro_index,1);

                                  }

                           }

                     }
                     if($scope.Temp_ProjectList.length != $scope.projectList.length){
                  	   $scope.checkall_project = false;
                     }

              }

       }

      

       $scope.checkall_war = function(val){

              if(val){

                     angular.forEach($scope.wareHouseEntityList, function(itm){ itm.selected = val; });

                     angular.copy($scope.wareHouseEntityList,$scope.Temp_WareHouseList);

              }

              else{
            	  angular.forEach($scope.wareHouseEntityList, function(itm){ itm.selected = val; });
                     $scope.Temp_WareHouseList = [];

              }

       }

      

       $scope.add_war = function(data,value){

              if(value){

                           $scope.Temp_WareHouseList.push(data);
                           
                           if($scope.Temp_WareHouseList.length == $scope.wareHouseEntityList.length){
                        	   $scope.checkall_warehouse = true;
                           }

              }
              

              else{
                  
                     if($scope.Temp_WareHouseList.length > 0){

                           for(i=0;i<$scope.Temp_WareHouseList.length;i++){

                                  if($scope.Temp_WareHouseList[i].id == data.id){

                                         let war_index = i;

                                         $scope.Temp_WareHouseList.splice(war_index,1);

                                  }

                           }

                     }
                     if($scope.Temp_WareHouseList.length != $scope.wareHouseEntityList.length){
                  	   $scope.checkall_warehouse = false;
                     }

              }

       }

       

       FetchService.getAllProjectList().then(function(response)

                     {

              $scope.projectList=response;

                     });

      

       FetchService.getAllActiveWareHouse().then(function(response)

                     {

              $scope.wareHouseEntityList=response;

                     });

      
      /*$scope.dtInstance = {};*/

      

       $scope.search = function()

       {  var count=0;

       //$scope.reportDtoList=[];

              if ($scope.reportForm.$valid)

              {

//                  $scope.listfinal=$scope.projectList.concat($scope.wareHouseEntityList);
            	  
            	  $scope.listfinal = [];
                     
            	  $scope.listfinal=$scope.Temp_ProjectList.concat($scope.Temp_WareHouseList);

                    

                     if($scope.reportDto.reportMenu  =='INVENTORY DETAILS' || $scope.reportDto.reportMenu == 'INVENTORY SCRAP' || $scope.reportDto.reportMenu == 'INVENTORY REQUESTS' || $scope.reportDto.reportMenu == 'INVENTORY SERVICE' || $scope.reportDto.reportMenu == 'INVENTORY INWARDS' || $scope.reportDto.reportMenu == 'INVENTORY OUTWARDS')

                           

                     {

                     angular.forEach($scope.listfinal,function(v,k){

                           if(v.selected)

                                  {

                                  count++;

                                  }

                     });

                     if(count==0)

                           {

                           /*$scope.listfinal="please choose Project or wareHouse";

                           return false;*/

                           swal(

                                     '',

                                 'Please Choose Project or WareHouse',

                                 'warning'

                               )

                               return false;

                           }

                     $scope.listfinal='';

                     count=0;

                     }

                     else if($scope.reportDto.reportMenu =='ELCB' || $scope.reportDto.reportMenu =='WORKMEN DETAILS' )

                     {

                           //alert(JSON.stringify($scope.listfinal));

                     angular.forEach($scope.listfinal,function(v,k){

                           if(v.selected)

                                  {

                                  count++;

                                  }

                     });

                     if(count==0)

                           {

                           /*$scope.listfinalError="please choose Projects";

                           return false;*/

                           swal(

                                     '',

                                 'Please Choose Project',

                                 'warning'

                               )

                               return false;

                           }

                     $scope.listfinalError='';

                     count=0;

                     }


                     
                     $scope.reportDto['projectItemDto'] =$scope.Temp_ProjectList;

                     $scope.reportDto['wareHouseDto']=$scope.Temp_WareHouseList;
                     

                     FetchService.getReport($scope.reportDto).then(function(response){
                    	 
                    	 $scope.searchStatus = true;
                          
                           if($scope.reportDto.reportMenu == "INVENTORY DETAILS")

                                  {

                              
                                           	   
                                  $scope.scrap_view = false; 

                                  $scope.tools_Request_view = false;

                                  $scope.Inventory_Service = false;

                                  $scope.ELCB = false;

                                  $scope.Workmen_details = false;

                                  $scope.stock_report_view= true;

                                  $scope.inventory_inwords_view= false;

                                  $scope.inventory_outwords_view= false;

                                  }

                           if($scope.reportDto.reportMenu == "INVENTORY SCRAP")

                           {

                                  $scope.stock_report_view = false;

                                 

                                  $scope.tools_Request_view = false;

                                  $scope.Inventory_Service = false;

                                  $scope.ELCB = false;

                                  $scope.Workmen_details = false;

                           $scope.scrap_view = true;

                           $scope.inventory_inwords_view= false;

                           $scope.inventory_outwords_view= false;

                           }

                           if($scope.reportDto.reportMenu == "INVENTORY REQUESTS")

                           {

                                  $scope.stock_report_view = false;

                                  $scope.scrap_view = false; 

                                 

                                  $scope.Inventory_Service = false;

                                  $scope.ELCB = false;

                                  $scope.Workmen_details = false;

                           $scope.tools_Request_view = true;

                           $scope.inventory_inwords_view= false;

                           $scope.inventory_outwords_view= false;

                           }

                           if($scope.reportDto.reportMenu == "INVENTORY SERVICE")

                           {

                                  $scope.stock_report_view = false;

                                  $scope.scrap_view = false; 

                                  $scope.tools_Request_view = false;

                                 

                                  $scope.ELCB = false;

                                  $scope.Workmen_details = false;

                           $scope.Inventory_Service = true;

                           $scope.inventory_inwords_view= false;

                           $scope.inventory_outwords_view= false;

                           }

                           if($scope.reportDto.reportMenu == "ELCB")

                           {

                                  $scope.stock_report_view = false;

                                  $scope.scrap_view = false; 

                                  $scope.tools_Request_view = false;

                                  $scope.Inventory_Service = false;

                                 

                                  $scope.Workmen_details = false;

                           $scope.ELCB = true;

                           $scope.inventory_inwords_view= false;

                           $scope.inventory_outwords_view= false;

                           }

                           if($scope.reportDto.reportMenu == "WORKMEN DETAILS")

                           {

                                  $scope.stock_report_view = false;

                                  $scope.scrap_view = false; 

                                  $scope.tools_Request_view = false;

                                  $scope.Inventory_Service = false;

                                  $scope.ELCB = false;

                                 

                           $scope.Workmen_details = true;

                           $scope.inventory_inwords_view= false;

                           $scope.inventory_outwords_view= false;

                           }

                           if($scope.reportDto.reportMenu == "INVENTORY INWARDS")

                           {

                                 

                                  $scope.stock_report_view = false;

                                  $scope.scrap_view = false; 

                                  $scope.tools_Request_view = false;

                                  $scope.Inventory_Service = false;

                                  $scope.ELCB = false;

                                 

                           $scope.Workmen_details = false;

                           $scope.inventory_inwords_view= true;

                           $scope.inventory_outwords_view= false;

                           }

                           if($scope.reportDto.reportMenu == "INVENTORY OUTWARDS")

                           {     

                                  $scope.stock_report_view = false;

                                  $scope.scrap_view = false; 

                                  $scope.tools_Request_view = false;

                                  $scope.Inventory_Service = false;

                                  $scope.ELCB = false;

                                 

                           $scope.Workmen_details = false;

                           $scope.inventory_inwords_view= false;

                           $scope.inventory_outwords_view= true;

                           }

                           $scope.reportDtoList=response;
                           
                           if($scope.reportDtoList.length == 0){
                        	   $scope.searchStatus = true;
                        	   $scope.alertMsg = "No Records Found";
                           }
     
                    
              });

       }

       }

           
          


 

    $scope.validateToDate = function()

       {

      

       var dateAr = $scope.reportDto.fromDate.split('-');

       var startDate = dateAr[2] + '-' + dateAr[1] + '-' + dateAr[0].slice(-2);

      

       var dateAr1 = $scope.reportDto.toDate.split('-');

       var endDate = dateAr1[2] + '-' + dateAr1[1] + '-' + dateAr1[0].slice(-2);

           

              if(startDate > endDate)

                     {

                     $scope.reportDto.toDate="";

              }

      

       }

   

    $scope.dtOptions = DTOptionsBuilder.newOptions()

    .withDOM('<"top"lrf><"bottom"tip>').withLanguage({"sEmptyTable":"No Record Found"})

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

 

 

 

   

      

});