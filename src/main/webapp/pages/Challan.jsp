<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="DeliveryChallanController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor"> SEARCH CHALLAN</h3>
                    </div>
                    
                 
                
 
                        

                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title"> SEARCH CHALLAN</h4>
								<form class="form-inline"  method="post" name="Challan" novalidate>
														

   
   
 
 <div class="col-md-6 col_md text-center">
 				<div class="add_icon_asterisk">
						<label for="pwd"> From Date :</label>
						<div class="input-group date" data-date-format="dd/mm/yyyy"
							data-date-today-highlight="true" data-date-end-date="0d"
							data-date-autoclose="true" data-provide="datepicker">
							<div class="input-group-addon inner-addon right-addon ">
								<i class="fa fa-calendar"></i> <input type="text"
									class="form-control" placeholder=""
									name="fromDate" id="fromDate"
									data-ng-model="reportDto.fromDate" readonly required>
									
							</div>
						</div>			


<!-- <div class="input-group date" data-date-format="dd/mm/yyyy"
							data-date-today-highlight="true" data-date-autoclose="true"
							 data-provide="datepicker">
							<div class="input-group-addon inner-addon right-addon ">
								<i class="fa fa-calendar"></i> <input type="text"
									class="form-control" placeholder=""
									name="toDate" id="toDate" data-ng-model="reportDto.toDate" data-ng-change="validateToDate()"
									readonly required>
							</div>
						</div> -->
						<i class="fa fa-asterisk" ></i>
					</div>
					
				

					<div
						data-ng-show="Challan.$submitted || Challan.fromDate.$touched" class="error_msg">
						<div data-ng-show="Challan.fromDate.$error.required" class="error_msg">Select From Date
						</div>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd"> To Date :</label>
						<div class="input-group date" data-date-format="dd/mm/yyyy"
							data-date-today-highlight="true" data-date-autoclose="true"
							 data-provide="datepicker" >
							<div class="input-group-addon inner-addon right-addon ">
								<i class="fa fa-calendar"></i> <input type="text"
									class="form-control" placeholder=""
									name="toDate" id="toDate" data-ng-model="reportDto.toDate" data-ng-change="validateToDate()"
									readonly required>
							</div>
						</div>
						<i class="fa fa-asterisk" ></i>
					</div>


					<div
						data-ng-show="Challan.$submitted || Challan.toDate.$touched" class="error_msg">
						<div data-ng-show="Challan.toDate.$error.required" class="error_msg"> Select To Date					</div>
					</div>

				</div>
				<div class="col-md-6"></div>
				<div class="col-md-8 submit_col text-center">
					<button class="btn btn-primary" data-ng-click="search()">Search</button>
				</div>


<!-- <table class="table table-bordered">
<thead>
<tr><th>S.No</th><th>Consignee Address</th><th>Consignee Name</th><th>Place Of Supply</th><th>Trans Company</th><th>Trans Mode</th></tr>
</thead>
<tbody>
<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
</tbody>
</table> -->

								
								
								</form>
								
								
								
<br>								
<div data-ng-if="SearchDetails">							
								
<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
					<tr>
					    <th>Id</th>
						<th>Consignee Name</th>
						<th>Consignee Address </th>
						<th>Challan No </th>
						<th>Vechicle No </th>
						<th>Transport Company </th>
						<th>Dispatch Date </th>
						<th>Action </th>
						
					</tr>
					</thead>
					<tbody>
					
						<tr data-ng-repeat="DeliveryChallanDto in DeliveryChallanList">
						<td>{{DeliveryChallanDto.id}}</td>
							<td>{{DeliveryChallanDto.consigneeName}}</td>
							<td>{{DeliveryChallanDto.consigneeAddress}}</td>	
							<td>{{DeliveryChallanDto.challanNo}}</td>	
							<td>{{DeliveryChallanDto.vehicleNo}}</td>	
							<td>{{DeliveryChallanDto.transCompany}}</td>	
							<td>{{DeliveryChallanDto.dispatchDate}}</td>	
							
							
								<td class="table_btn_group">
							
							<a href="" data-ng-click="DownloadChalan(DeliveryChallanDto.challanNo)" class="btn btn-primary"><i class="fa fa-edit"></i> DownLoad Challan</a>
							
						</tr>

					</tbody>
				</table>
		</div>								
								
</div>									
								
								
								
								
							</div>
					</div>
					
					
					
<!-- 	 <div data-ng-show="challanTable"> -->
                
                
<!-- <br>		<div class="form_section"> -->

<!-- 			<div class="form-content"> -->
<!-- 				<h4 class="form_content_title">Search Challan</h4> -->

<!-- <div class="table-responsive"> -->
<!-- 				<table datatable="ng" dt-options="dtOptions" -->
<!-- 					class="table table-striped table-bordered"> -->
<!-- 					<thead> -->
<!-- 					<tr> -->
<!-- 					    <th>Id</th> -->
<!-- 						<th>Consignee Name</th> -->
<!-- 						<th>Consignee Address </th> -->
<!-- 						<th>Challan No </th> -->
<!-- 						<th>Vechicle No </th> -->
<!-- 						<th>Transport Company </th> -->
<!-- 						<th>Dispatch Date </th> -->
<!-- 						<th>Action </th> -->
						
<!-- 					</tr> -->
<!-- 					</thead> -->
<!-- 					<tbody> -->
					
<!-- 						<tr data-ng-repeat="DeliveryChallanDto in DeliveryChallanList"> -->
<!-- 						<td>{{DeliveryChallanDto.id}}</td> -->
<!-- 							<td>{{DeliveryChallanDto.consigneeName}}</td> -->
<!-- 							<td>{{DeliveryChallanDto.consigneeAddress}}</td>	 -->
<!-- 							<td>{{DeliveryChallanDto.challanNo}}</td>	 -->
<!-- 							<td>{{DeliveryChallanDto.vehicleNo}}</td>	 -->
<!-- 							<td>{{DeliveryChallanDto.transCompany}}</td>	 -->
<!-- 							<td>{{DeliveryChallanDto.dispatchDate}}</td>	 -->
							
							
<!-- 								<td class="table_btn_group"> -->
							
<!-- 							<a href="" data-ng-click="DownloadChalan(DeliveryChallanDto.challanNo)" class="btn btn-primary"><i class="fa fa-edit"></i> DownLoad Challan</a> -->
							
<!-- 						</tr> -->

<!-- 					</tbody> -->
<!-- 				</table> -->
<!-- 		</div> -->



<!-- 			</div> -->
<!-- 		</div> -->
		</div>
					
          <!--   </div> -->

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />