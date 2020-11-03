<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="dispatchLogController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">Delivery Challan</h3>
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
								<h4 class="form_content_title">Delivery Challan</h4>
								
								


<form class="form-inline" name="accept_challan" novalidate>

<div class="col-md-12 text-center">

<div class="">

 <h4><b>Enter Challan No :</b></h4>
  <input type="text" name=challanNo data-ng-model="receiveToolsDto.challanNo" class="form-control text_box float-none" required>

</div>

					<br><span data-ng-show="accept_challan.$submitted || accept_challan.challanNo.$touched">					
						<span data-ng-show="accept_challan.challanNo.$error.required" class="receive_error_msg">Please Enter Challan No </span>
					</span>
					<span data-ng-if="challanNoInvalid" class="receive_error_msg">Challan No Invalid</span>	

<div class="">  
  <button class="btn btn-primary inline-btn" data-ng-click="ReceiveTools()"><i class="fa fa-search"></i> RECEIVE TOOLS</button>
  
</div>

</div>

	
</form>	
	
								
								
<!-- <table class="table table-bordered delivery_challan"> -->
<!--   <tr> -->
<!--     <th>C'nee Name</th> -->
<!--     <td><input type="text" name="cname" class="form-control"></td> -->
<!--     <th>GSTIN</th> -->
<!--     <th colspan="2">33ABGPS4588J1Z4</th> -->
<!--   </tr> -->
<!--   <tr> -->
<!--     <th rowspan="3">C'nee Add</th> -->
<!--     <td rowspan="3"><textarea name="caddress" rows="5" class="form-control"></textarea></td> -->
<!--     <th>Dely Challan</th> -->
<!--     <td colspan="2"><input type="text" name="delychallan" class="form-control"></td> -->
<!--   </tr> -->
<!--   <tr> -->
<!--      <th>DC Date</th> -->
<!--      <td colspan="2"><div class="input-group date" data-date-format="dd/mm/yyyy" -->
<!-- 								data-date-today-highlight="true" data-date-autoclose="true" -->
<!-- 								data-provide="datepicker"> -->
<!-- 								<div class="input-group-addon inner-addon right-addon "> -->
<!-- 									<i class="fa fa-calendar"></i> <input type="text" -->
<!-- 										class="form-control" placeholder="" name="dcdate" readonly required> -->
<!-- 								</div> -->
<!-- 							</div></td> -->
<!--   </tr> -->
<!--     <tr> -->
<!--      <th>Place of Supply</th> -->
<!--      <td colspan="2"><input type="text" name="placeofsupply" class="form-control"></td> -->
<!--   <tr> -->
<!--     <th>Trans Mode</th> -->
<!--     <td><select name="transmode" class="form-control"> -->
<!--     <option value="Two Wheeler">Two Wheeler</option> -->
<!--     <option value="Four Wheeler">Four Wheeler</option> -->
<!--     </select></td> -->
<!--     <th>Vehicle No</th> -->
<!--     <td colspan="2"><input type="text" name="vehicleno" class="form-control"></td> -->
<!--   </tr> -->
<!--     <tr> -->
<!--     <th>Trans Company</th> -->
<!--     <td><input type="text" name="transcompany" class="form-control"></td> -->
<!--     <th>Dispatch Date</th> -->
<!--     <td colspan="2">							<div class="input-group date" data-date-format="dd/mm/yyyy" -->
<!-- 								data-date-today-highlight="true" data-date-autoclose="true" -->
<!-- 								data-provide="datepicker"> -->
<!-- 								<div class="input-group-addon inner-addon right-addon "> -->
<!-- 									<i class="fa fa-calendar"></i> <input type="text" -->
<!-- 										class="form-control" placeholder="" name="dispathdate" readonly required> -->
<!-- 								</div> -->
<!-- 							</div></td> -->
<!--   </tr> -->
<!-- </table> -->

<div data-ng-show="challan_details">

<br>
<form class="form-inline"  method="post" name="deliveryChallan" novalidate>

<div class="table-responsive">
<table class="table table-bordered">
<thead>
<tr><th>S.No</th><th>Category</th><th>Sub Category</th><th>Model</th><th>Qty</th><th>From</th><th>Ref No</th><th>Asset No</th><th>Asset Tracking</th><th>purpose</th></tr>
</thead>
<tbody>
<tr data-ng-repeat="receivetools in receiveToolsList"> 
<td>{{$index+1}}</td>
<td>{{receivetools.categoryType}}</td>
<td>{{receivetools.subCategory}}</td>
<td>{{receivetools.modelCode}}</td>
<td>{{receivetools.quantity}}</td>
<td>{{receivetools.site}}</td>
<td>{{receivetools.referenceNo}}</td>
<td>{{receivetools.inventoryNumber}}</td>
<td>{{receivetools.assetTracking}}</td>
<td>{{receivetools.reason}}</td>
</tr>
</tbody>
</table>
</div>
								
								
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="accept(receiveToolsList)"><i class="fa fa-check"></i> ACCEPT</button>
										</div>
								</form>
								
								
</div>								
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />