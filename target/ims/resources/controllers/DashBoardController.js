ims.controller('dashBoardController',function($scope,$http,TestService,$window,FetchService,InsertService,DashBoardService) {
	
	$scope.inventoryCountForUserProjectDtoList=[];
	var inventoryCountUserProjectList=[];
	
	
	$scope.inventoryCountForSpecificOfficeAdministratorFromStockDtoList=[];
	var inventoryCountOfficeAdministratorStockDtoList=[];
	
	$scope.inventoryCountForSpecificOfficeAdministratorFromAssignDtoList=[];
	var inventoryCountOfficeAdministratorAssignDtoList=[];
	
	$scope.inventoryCountForSpecificWareHouseAdministratorDtoList=[];
	var inventoryCountOfficeWareHouseAdministratorDtoList=[];
	
	
	
	
/* <started------------------------------------------------this dashboard for role type USER--------------------------------------------------------------started>*/	
	
	/*inventorycount from specific user project*/
	DashBoardService.getInventoryFromSpecificUserProject().then(function(response)
			{
		$scope.inventoryCountForUserProjectDtoList=response;
		InventoryCount3DBarChartForUser($scope.inventoryCountForUserProjectDtoList);
		inventoryCountforRoundgraphforUser($scope.inventoryCountForUserProjectDtoList);
			});
	
    /*this function is for inventorycount with bar chart for role USER with 3D animation*/
	function InventoryCount3DBarChartForUser(InventoryCount3DBarChartForUser)
	{
		angular.forEach(InventoryCount3DBarChartForUser,function(value,key)
				{
			inventoryCountUserProjectList.push({
				country: value.site,
				visits: value.quantity
			});
		});
		var inventoryCount3DBarChartForUser = AmCharts.makeChart( "inventoryCount3DBarChartForUser", {
		    "theme": "light",
		    "type": "serial",
		    "startDuration": 2,
		    "dataProvider":inventoryCountUserProjectList,
		    "valueAxes": [{
		        "position": "left",
		        "axisAlpha":0,
		        "gridAlpha":0
		    }],
		    "graphs": [{
		        "balloonText": "[[category]]: <b>[[value]]</b>",
		        "colorField": "color",
		        "fillAlphas": 0.85,
		        "lineAlpha": 0.1,
		        "type": "column",
		        "fixedColumnWidth":30,
		        "topRadius":1,
		        "valueField": "visits",
		        "autoColor": true
		    }],
		    "depth3D": 40,
			"angle": 30,
		    "chartCursor": {
		        "categoryBalloonEnabled": false,
		        "cursorAlpha": 0,
		        "zoomable": false
		    },
		    "categoryField": "country",
		    "categoryAxis": {
		        "gridPosition": "start",
		        "axisAlpha":0,
		        "gridAlpha":0,
		        "labelRotation": 45,
		        "minHorizontalGap": 0

		    },
		    "export": {
		    	"enabled": true
		     }

		}, 0  );
	}
	
	
	/*this function is for round graph for USER*/
	function inventoryCountforRoundgraphforUser(inventoryCountDtoList)
	{
		roundGraphInventoryAndProjectCount=[];
		
		$scope.totaluserProject = 0;
		
		angular.forEach(inventoryCountDtoList,function(value,key)
				{
			
			$scope.totaluserProject = $scope.totaluserProject + value.quantity;
			
			roundGraphInventoryAndProjectCount.push({
				inventoryCount: value.quantity,
				projectName: value.site
			});
		});
		var chart = AmCharts.makeChart( "RoundChartForSpecificUserProject", {
			  "type": "pie",
			  "theme": "black",
			  "titles": [ {
				  "text": "",
			    "size": 16
			  } ],
			  "valueField": "inventoryCount",
			  "titleField": "projectName",
			  "dataProvider":roundGraphInventoryAndProjectCount,
			  "startEffect": "elastic",
			  "startDuration": 2,
			  "labelRadius": 15,
			  "innerRadius": "30%",
			  "depth3D": 10,
//			  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
			  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b></span>",
			  "angle": 15,
			  "export": {
			    "enabled": false
			  }
			} );
		console.log("inside====>"+JSON.stringify($scope.totaluserProject));
	}
	
	
	
	
	
	
	/*FOR FETCH THE TOOLS REQUEST TO THE CURRENT USER's ASSIGNED PROJECT
    FetchService.getUserToolsRequest().then(function(response){
            
            $scope.inventoryRequestDtoList=response;
            console.log("userToolsRequest===>"+JSON.stringify($scope.inventoryRequestDtoList));
    });*/
    
    
    /*FOR VIEW AND ACCEPT THE TOOLS REQUEST*/ 
    $scope.viewAccept = function(inventoryRequestDto) {
    	var req = {id : inventoryRequestDto.id};		
    	$('<form action="getToolsRequestById" method="post"><input type="text" name="id" value="'+inventoryRequestDto.id+'"></form>').appendTo('body').submit();
    }
    /* <ended------------------------------------------------this dashboard for role type USER--------------------------------------------------------------ended>*/
		
    
    /* <started------------------------------------------------this dashboard for role type OFFICE ADMINISTRATOR--------------------------------------------------------------started>*/
    
    
        DashBoardService.getInventoryCountForOfficeAdministratorFromStock().then(function(response){
		$scope.inventoryCountForSpecificOfficeAdministratorFromStockDtoList=response;
		addInventoryCountForSpecificOfficeAdministratorFromStock($scope.inventoryCountForSpecificOfficeAdministratorFromStockDtoList);
		
	});
        
           
            DashBoardService.getInventoryCountForOfficeAdministratorFromAssign().then(function(response){
    		$scope.inventoryCountForSpecificOfficeAdministratorFromAssignDtoList=response;
    		inventoryCountforRoundgraphforOfficeAdministrator($scope.inventoryCountForSpecificOfficeAdministratorFromAssignDtoList);
    	});
        
        
    
        /*this function is for inventorycount with bar chart for OFFICE ADMINISTRATOR FROM  stock*/
    	function addInventoryCountForSpecificOfficeAdministratorFromStock(inventoryCountForSpecificOfficeAdministratorFromStockDtoList)
    	{
    		
    		$scope.totalWareHouseOffice = 0;
    		angular.forEach(inventoryCountForSpecificOfficeAdministratorFromStockDtoList,function(value,key)
    				{
    			
    			$scope.totalWareHouseOffice =  $scope.totalWareHouseOffice + value.quantity;
    			
    			inventoryCountOfficeAdministratorStockDtoList.push({
    				country: value.site,
    				visits: value.quantity
    			});
    		});
    		var inventoryCount3DBarChartForOfficeAdministrator = AmCharts.makeChart( "inventoryCount3DBarChartForOfficeAdministrator", {
    		    "theme": "light",
    		    "type": "serial",
    		    "startDuration": 2,
    		    "dataProvider":inventoryCountOfficeAdministratorStockDtoList,
    		    "valueAxes": [{
    		        "position": "left",
    		        "axisAlpha":0,
    		        "gridAlpha":0
    		    }],
    		    "graphs": [{
    		        "balloonText": "[[category]]: <b>[[value]]</b>",
    		        "colorField": "color",
    		        "fillAlphas": 0.85,
    		        "lineAlpha": 0.1,
    		        "type": "column",
    		        "fixedColumnWidth":30,
    		        "topRadius":1,
    		        "valueField": "visits",
    		        "autoColor": true
    		    }],
    		    "depth3D": 40,
    			"angle": 30,
    		    "chartCursor": {
    		        "categoryBalloonEnabled": false,
    		        "cursorAlpha": 0,
    		        "zoomable": false
    		    },
    		    "categoryField": "country",
    		    "categoryAxis": {
    		        "gridPosition": "start",
    		        "axisAlpha":0,
    		        "gridAlpha":0,
    		        "labelRotation": 45,
    		        "minHorizontalGap": 0

    		    },
    		    "export": {
    		    	"enabled": true
    		     }
    		    

    		}, 0);
    	}
    	
    	
    	/*to fill auto color to bar chart*/
    	AmCharts.addInitHandler(function(chart) {
    		  // check if there are graphs with autoColor: true set
    		  for(var i = 0; i < chart.graphs.length; i++) {
    		    var graph = chart.graphs[i];
    		    if (graph.autoColor !== true)
    		      continue;
    		    var colorKey = "autoColor-"+i;
    		    graph.lineColorField = colorKey;
    		    graph.fillColorsField = colorKey;
    		    for(var x = 0; x < chart.dataProvider.length; x++) {
    		      var color = chart.colors[x]
    		      chart.dataProvider[x][colorKey] = color;
    		    }
    		  }
    		  
    		}, ["serial"]);
    	
    	
    	/*this function is for round graph for OFFICE ADMINISTRATOR*/
    	function inventoryCountforRoundgraphforOfficeAdministrator(inventoryCountDtoList)
    	{
    		roundGraphInventoryAndProjectCount=[];
    		
    		$scope.totalProjects = 0;
    		
    		angular.forEach(inventoryCountDtoList,function(value,key)
    				{
    			
    			$scope.totalProjects =  $scope.totalProjects + value.quantity;
    			
    			roundGraphInventoryAndProjectCount.push({
    				inventoryCount: value.quantity,
    				projectName: value.site
    			});
    		});
    		var RoundChartForOfficeAdministrator = AmCharts.makeChart( "RoundChartForOfficeAdministrator", {
    			  "type": "pie",
    			  "theme": "black",
    			  "titles": [ {
    			    "text": "",
    			    "size": 16
    			  } ],
    			  "valueField": "inventoryCount",
    			  "titleField": "projectName",
    			  "dataProvider":roundGraphInventoryAndProjectCount,
    			  "startEffect": "elastic",
    			  "startDuration": 2,
    			  "labelRadius": 15,
    			  "innerRadius": "30%",
    			  "depth3D": 10,
//    			  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
    			  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b></span>",
    			  "angle": 15,
    			  "export": {
    			    "enabled": false
    			  }
    			} );
    		console.log("inside====>"+JSON.stringify($scope.totalProjects));
    	}
        
        
    
    
    /* <started------------------------------------------------this dashboard for role type  OFFICE ADMINISTRATOR--------------------------------------------------------ended>*/
    	
    	
    	/* <started------------------------------------------------this dashboard for role type  WAREHOUSE ADMINISTRATOR--------------------------------------------------------started>*/
    	
    	
    	   /*this function is to get inventory count for role WAREHOUSE ADMINISTRATOR*/
    	   DashBoardService.getInventoryCountForSpecificWareHouseAdministrator().then(function(response)
    			{
    		   $scope.inventoryCountForSpecificWareHouseAdministratorDtoList=response;
    		   InventoryCount3DBarChartForWarehouseAdministrator($scope.inventoryCountForSpecificWareHouseAdministratorDtoList);
    		   inventoryCountforRoundgraphforWareHouseAdministrator($scope.inventoryCountForSpecificWareHouseAdministratorDtoList);
    			});
    	
    	   
    	   
    	   
    	   
    	   /*this function is for inventorycount with bar chart for role WAREHOUSE ADMINISTRATOR with 3D animation*/
    		function InventoryCount3DBarChartForWarehouseAdministrator(inventoryCountForSpecificWareHouseAdministratorDtoList)
    		{
    			$scope.totalWarehouse = 0;
    			angular.forEach(inventoryCountForSpecificWareHouseAdministratorDtoList,function(value,key)
    					{
    				
    				$scope.totalWarehouse =  $scope.totalWarehouse + value.quantity;
    				
    				inventoryCountOfficeWareHouseAdministratorDtoList.push({
    					country: value.site,
    					visits: value.quantity
    				});
    			});
    			var inventoryCount3DBarChartForWareHouseAdministrator = AmCharts.makeChart( "inventoryCount3DBarChartForWareHouseAdministrator", {
        		    "theme": "light",
        		    "type": "serial",
        		    "startDuration": 2,
        		    "dataProvider":inventoryCountOfficeWareHouseAdministratorDtoList,
        		    "valueAxes": [{
        		        "position": "left",
        		        "axisAlpha":0,
        		        "gridAlpha":0
        		    }],
        		    "graphs": [{
        		        "balloonText": "[[category]]: <b>[[value]]</b>",
        		        "colorField": "color",
        		        "fillAlphas": 0.85,
        		        "lineAlpha": 0.1,
        		        "type": "column",
        		        "fixedColumnWidth":30,
        		        "topRadius":1,
        		        "valueField": "visits",
        		        "autoColor": true
        		    }],
        		    "depth3D": 40,
        			"angle": 30,
        		    "chartCursor": {
        		        "categoryBalloonEnabled": false,
        		        "cursorAlpha": 0,
        		        "zoomable": false
        		    },
        		    "categoryField": "country",
        		    "categoryAxis": {
        		        "gridPosition": "start",
        		        "axisAlpha":0,
        		        "gridAlpha":0,
        		        "labelRotation": 45,
        		        "minHorizontalGap": 0

        		    },
        		    "export": {
        		    	"enabled": true
        		     }

        		}, 0 );
    		}
    		
    		
    		/*this function is for round graph for WAREHOUSE ADMINISTRATOR*/
    		function inventoryCountforRoundgraphforWareHouseAdministrator(inventoryCountForSpecificWareHouseAdminDtoList)
    		{
    			roundGraphInventoryAndProjectCount=[];
    			
    			angular.forEach(inventoryCountForSpecificWareHouseAdminDtoList,function(value,key)
    					{
    				roundGraphInventoryAndProjectCount.push({
    					inventoryCount: value.quantity,
    					projectName: value.site
    				});
    			});
    			
    			
    			var RoundChartForSpecificWareHouseAdministrator = AmCharts.makeChart( "RoundChartForSpecificWareHouseAdministrator", {
    				  "type": "pie",
    				  "theme": "black",
    				  "titles": [ {
    				    "text": "",
    				    "size": 16
    				  } ],
    				  "valueField": "inventoryCount",
    				  "titleField": "projectName",
    				  "dataProvider":roundGraphInventoryAndProjectCount,
    				  "startEffect": "elastic",
    				  "startDuration": 2,
    				  "labelRadius": 15,
    				  "innerRadius": "30%",
    				  "depth3D": 10,
//    				  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
    				  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b></span>",
    				  "angle": 15,
    				  "export": {
    				    "enabled": false
    				  }
    				} );
    			console.log("inside====>"+JSON.stringify(roundGraphInventoryAndProjectCount));
    		}
    	
    	/* <started------------------------------------------------this dashboard for role type  WAREHOUSE ADMINISTRATOR--------------------------------------------------------ended>*/
    
    
});


