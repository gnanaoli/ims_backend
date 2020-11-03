
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<jsp:include page="header.jsp" />



<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid user-top"
	data-ng-controller="dispatchLogController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- End Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Start Page Content -->
	<!-- ============================================================== -->
	<!-- Row -->
	<div class="form_section">
		<div class="form-content create_form">
			<h4 class="form_content_title">DISPATCH LOG QUEUE</h4>
			<!--  <button data-ng-click="DownloadChalan()" download>test download</button> -->
			<div>

				<div class="table-responsive" data-ng-show="viewDispatchLogCount">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Quantity</th>
								<th>From</th>
								<th>To</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<security:authorize
								access="hasAuthority('WAREHOUSE ADMINISTRATOR') or hasAuthority('USER') or hasAuthority('SUPER USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('ENQUIRY')">
								<tr
									data-ng-repeat="dispatchLogManagementDto in dispatchLogDtoList">
									<td>{{dispatchLogManagementDto.availableQuantity}}</td>
									<td>{{dispatchLogManagementDto.requestedFrom}}</td>
									<td>{{dispatchLogManagementDto.requestedTo}}</td>
									<td><div class="col-12 submit_col text-center">
											<button class="btn btn-primary"
												data-ng-click="getDispatchData(dispatchLogManagementDto.requestedFrom,dispatchLogManagementDto.requestedTo)">
												<i class="fa fa-check"></i> DISPATCH
											</button>
										</div></td>
								</tr>
							</security:authorize>
						</tbody>

						<%-- <security:authorize access="hasAuthority('USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('ENQUIRY') or hasAuthority('SUPER USER')">
					<tbody>
						<tr data-ng-repeat="dispatchLogManagementDto in dispatchLogDtoList">
							<td>{{dispatchLogManagementDto.availableQuantity}}</td>
							<td>{{dispatchLogManagementDto.requestedFrom}}</td>
							<td><div class="col-12 submit_col text-center">
					<button class="btn btn-primary"
						data-ng-click="getDispatchData(dispatchLogManagementDto.requestedFrom)"><i class="fa fa-check"></i> DISPATCH</button>
				   </div></td>
						</tr>
					</tbody>
					</security:authorize> --%>




					</table>
				</div>
				<!-- --this is show to each value from project selection -->
				<div class="table-responsive"
					data-ng-show="viewEachDispatchByProject">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Check</th>
								<th>Category</th>
								<th>Sub Category</th>
								<th>Qty InTransfer Process</th>
								<th>Asset Tracking</th>
								<th>Reference No</th>
								<th>To</th>
								<th>purpose</th>
								<th>Total Quantity</th>

								<th>Transferable Quantity</th>
							</tr>
						</thead>
						<tbody>
							<security:authorize
								access="hasAuthority('WAREHOUSE ADMINISTRATOR') or hasAuthority('USER') or hasAuthority('SUPER USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('ENQUIRY')">
								<tr
									data-ng-repeat="dispatchLogManagementDto in dispatchLogDtoForEachList">
									<td>
										<div class="new-check-button">
											<input type="checkbox" name="projectName"
												id="{{dispatchLogManagementDto.id}}"
												data-ng-model="dispatchLogManagementDto.selected"
												class="filled-in"
												data-ng-change="removeUnchecked(dispatchLogManagementDto.selected,dispatchLogManagementDto.id)" />
											<label for="{{dispatchLogManagementDto.id}}"></label>
										</div>
									</td>
									<td>{{dispatchLogManagementDto.categoryType}}</td>
									<td>{{dispatchLogManagementDto.subCategory}}</td>
									<td>{{dispatchLogManagementDto.quantityInTransferProcess}}</td>
									<td>{{dispatchLogManagementDto.assetTracking}}</td>
									<td>{{dispatchLogManagementDto.referenceNo}}</td>
									<td>{{dispatchLogManagementDto.requestedTo}}</td>
									<td>{{dispatchLogManagementDto.reason}}</td>
									<td>{{dispatchLogManagementDto.availableQuantity}}</td>

									<td><input type="text" value=""
										data-ng-model="dispatchLogManagementDto.allocatableQuantity"
										data-ng-init="dispatchLogManagementDto.allocatableQuantity=dispatchLogManagementDto.availableQuantity"
										size="5" numbersonly maxlength="10"
										data-ng-blur="checkTransferableQuantity(dispatchLogManagementDto.id,dispatchLogManagementDto.availableQuantity,dispatchLogManagementDto.allocatableQuantity)" /></td>
								</tr>
							</security:authorize>
						</tbody>
					</table>

					<div class="col-12 submit_col text-center">
						<button class="btn btn-primary" data-ng-click="Add()">
							<i class="fa fa-check"></i> ADD
						</button>
						<button class="btn btn-primary"
							data-ng-click="cancelViewEachDispatchByProject()">
							<i class="fa fa-check"></i> CANCEL
						</button>
					</div>
				</div>

				<!-- this is for adding the transferable inventory before generating challen -->

				<div class="col-md-12" data-ng-show="viewAssign">
					<div class="table-responsive">
						<br>
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>S.No</th>
									<th>Category Type</th>
									<th>Sub Category</th>
									<th>Model</th>
									<th>Asset Tracking</th>
									<th>Reference No</th>
									<th>Site</th>
									<th>purpose</th>
									<th>allocated quantity</th>
									<th>Price</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<tr data-ng-repeat="x in dispatchLogDtoForEachforAddList">
									<td>{{$index + 1}}</td>
									<td>{{x.categoryType}}</td>
									<td>{{x.subCategory}}</td>
									<td>{{x.modelCode}}</td>
									<td>{{x.assetTracking}}</td>
									<td>{{x.referenceNo}}</td>
									<td>{{x.requestedTo}}</td>
									<td>{{x.reason}}</td>
									<td>{{x.allocatableQuantity}}</td>
									<security:authorize
										access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
										<td><input type="text" data-ng-init="x.price = ''"
											data-ng-model="x.price" size="10" numbersonly required
											maxlength="10" />
									</security:authorize>
									<security:authorize
										access="hasAuthority('USER') or hasAuthority('SUPER USER')">
										<!-- 									<td><input type="text" data-ng-init="x.price = '-'" data-ng-model="x.price" size="5" numbersonly readonly required maxlength="10"/> -->
										<td><input type="text" data-ng-init="x.price = ''"
											data-ng-model="x.price" size="10" numbersonly required
											maxlength="10" />
									</security:authorize>
									</td>
									<td><button class="btn btn-danger"
											data-ng-click="removeRow(x.id)">
											<i class="fa fa-close"></i>
										</button></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-12 submit_col text-center">
						<button class="btn btn-primary"
							data-ng-click="addToolsForTransfer()">
							<i class="fa fa-check"></i> TRANSFER
						</button>
					</div>
				</div>



				<!-- this is  challan -->


				<div data-ng-show="viewChallan">

					<form class="form-inline" method="post" name="deliveryChallan"
						id="deliveryChallan" novalidate>

						<div class="table-responsive">
							<table class="table table-bordered delivery_challan">
								<tr>
									<th width="20%">Consignee Name</th>
									<td width="30%"><input type="text" name="cname"
										namefieldwithspchar data-ng-model="challanDto.consigneeName"
										class="form-control" autocomplete="off" required="required">
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.cname.$touched"
											class="error_msg1">
											<div data-ng-show="deliveryChallan.cname.$error.required"
												class="error_msg1">please Enter Consignee Name</div>
										</div></td>
									<th width="20%">GSTIN</th>
									<td colspan="2" width="30%"><input type="text"
										name="gstIn" alphamumeric data-ng-model="challanDto.gstIn"
										class="form-control"
										data-ng-pattern="/^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[0-9]{1}[A-Z]{1}[0-9A-Z]{1}$/"
										autocomplete="off" gstinvalid
										data-ng-init="challanDto.gstIn=''" required="required">
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.gstIn.$touched"
											class="error_msg1">
											<div data-ng-show="deliveryChallan.gstIn.$error.required"
												class="error_msg1">please Enter GST Number</div>
											<div data-ng-show="deliveryChallan.gstIn.$error.pattern"
												class="error_msg1">please enter valid GST No</div>
										</div></td>
								</tr>
								<tr>
									<th rowspan="3">Consignee Add</th>
									<td rowspan="3"><textarea name="caddress" rows="5"
											addressvalid data-ng-model="challanDto.consigneeAddress"
											autocomplete="off" maxlenth="50" class="form-control"
											required="required"></textarea>
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.caddress.$touched"
											class="error_msg1">
											<div data-ng-show="deliveryChallan.caddress.$error.required"
												class="error_msg1">please Enter Consignee Address</div>
										</div></td>
									<th>Is Your Own Vehicle</th>
									<td colspan="2"><input type="radio"
										data-ng-model="challanDto.isOwnVehicle" class="with-gap"
										autocomplete="off" name="ownVehicle" id="YES" value="YES"
										required="required"> <label for="YES">YES</label> <input
										type="radio" data-ng-model="challanDto.isOwnVehicle"
										class="with-gap" autocomplete="off" name="ownVehicle" id="NO"
										value="NO" required="required"> <label for="NO">NO</label>
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.ownVehicle.$touched"
											class="error_msg1">
											<div
												data-ng-show="deliveryChallan.ownVehicle.$error.required"
												class="error_msg1">Select Is Your Own Vehicle</div>
										</div></td>
								</tr>
								<tr>
									<th>Delivery Challan Date</th>
									<td colspan="2"><div class="input-group date"
											data-date-format="dd/mm/yyyy"
											data-date-today-highlight="true" data-date-end-date="0d"
											data-date-start-date="0d" data-date-autoclose="true"
											data-provide="datepicker">
											<div class="input-group-addon inner-addon right-addon ">
												<i class="fa fa-calendar"></i> <input type="text"
													required="required" class="form-control" placeholder=""
													data-ng-model="challanDto.dcDate" name="dcdate" readonly>
											</div>
										</div>
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.dcdate.$touched"
											class="error_msg1">
											<div data-ng-show="deliveryChallan.dcdate.$error.required"
												class="error_msg1">Select Delivery Challan Date</div>
										</div></td>
								</tr>
								<tr>
									<th>Place of Supply</th>
									<td colspan="2"><input type="text"
										data-ng-model="challanDto.placeOfSupply" autocomplete="off" maxlength="30"
										alphanumericwithsplchar name="placeofsupply" class="form-control" ></td>
								<tr>
									<th>Trans Mode</th>
									<td><select name="transMode" class="form-control"
										data-ng-model="challanDto.transMode" required
										data-ng-options="x for x in transPortMode">
											<option value="">-- SELECT --</option>
									</select>
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.transMode.$touched"
											class="error_msg1">
											<div data-ng-show="deliveryChallan.transMode.$error.required"
												class="error_msg1">please select trans mode</div>
										</div></td>


									<!-- 												<th>Is Your Own Vehicle</th> -->
									<!-- 										<td> -->
									<!-- 										<input type="radio" data-ng-model="challanDto.isOwnVehicle" required class="with-gap" autocomplete="off" name="ownVehicle" id="YES" value="YES" > -->
									<!-- 										<label for="YES" >YES</label> -->
									<!-- 										<input type="radio" data-ng-model="challanDto.isOwnVehicle" required class="with-gap" autocomplete="off" name="ownVehicle" id="NO" value="NO" > -->
									<!-- 										<label for="NO">NO</label> -->
									<!-- 									</td> -->
									<!-- 											<div data-ng-show="deliveryChallan.$submitted || deliveryChallan.ownVehicle.$touched" class="error_msg"> -->
									<!-- 						                    <div data-ng-show="deliveryChallan.ownVehicle.$error.required" class="error_msg">Please choose Is Your Own Vehicle</div> -->
									<!-- 					                        </div> -->

									<!-- data-ng-pattern="/^[A-Z]{2}-[0-9]{2}-[A-Z]{1,2}-[0-9]{4}$/" -->

                                   
									<th>Vehicle No</th>
									<td colspan="2">
									<div class="cutom" id="vehicleCheckBox">
									<input type="text" name="vehicleNo"
										id="vehicleNo" onlystring maxlength="2" required move-Next-On-Maxlength placeholder="TN" disallow-spaces
										data-ng-model="challanDto.vehicleNo" width="25" autocomplete="off"
										class="form-control" /> 
										<input type="text" name="vehicleNo1"
										id="vehicleNo1" numbersonly maxlength="2" width="25" move-Next-On-Maxlength disallow-spaces placeholder="00" maxlength="10"
										required data-ng-model="challanDto.vehicleNo1"
										autocomplete="off" class="form-control" /> 
										<input type="text"
										name="vehicleNo2" id="vehicleNo2" onlystring width="%25" move-Next-On-Maxlength  disallow-spaces placeholder="AA" maxlength="2"
										maxlength="10" required data-ng-model="challanDto.vehicleNo2"
										autocomplete="off" class="form-control" />
										 <input type="text"
										name="vehicleNo3" id="vehicleNo3" numbersonly width="25" move-Next-On-Maxlength disallow-spaces maxlength="4" placeholder="0000"
										maxlength="10" required data-ng-model="challanDto.vehicleNo3"
										autocomplete="off" class="form-control" />
										
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.vehicleNo.$touched || deliveryChallan.vehicleNo1.$touched || deliveryChallan.vehicleNo2.$touched || deliveryChallan.vehicleNo3.$touched"
											class="error_msg1">
											<div data-ng-show="deliveryChallan.vehicleNo.$error.required || deliveryChallan.vehicleNo1.$error.required || deliveryChallan.vehicleNo2.$error.required ||deliveryChallan.vehicleNo3.$error.required"
												class="error_msg1">please enter vehicle no</div>
											<!-- <div data-ng-show="deliveryChallan.vehicleNo.$error.pattern 
												class="error_msg1">please enter valid vehicle no</div> -->
										</div>

</div>										
										</td>


								</tr>


								<tr>
									<th>Transport Company</th>
									<td><input type="text" name="transcompany"
										namefieldwithspchar data-ng-model="challanDto.transCompany"
										autocomplete="off" class="form-control" required="required">
										<div
											data-ng-show="deliveryChallan.$submitted || deliveryChallan.transcompany.$touched"
											class="error_msg1">
											<div
												data-ng-show="deliveryChallan.transcompany.$error.required"
												class="error_msg1">please Enter transport company</div>
										</div></td>
									<!-- 									<th>Dispatch Date</th> -->
									<!-- 									<td colspan="2"> -->
									<!-- 										<div class="input-group date" data-date-format="dd/mm/yyyy" -->
									<!-- 											data-date-today-highlight="true" data-date-autoclose="true" -->
									<!-- 											data-date-end-date="0d" data-date-start-date="0d" -->
									<!-- 											data-provide="datepicker"> -->
									<!-- 											<div class="input-group-addon inner-addon right-addon "> -->
									<!-- 												<i class="fa fa-calendar"></i> <input type="text" -->
									<!-- 													class="form-control" placeholder="" -->
									<!-- 													data-ng-model="challanDto.dispatchDate" name="dispatchdate" -->
									<!-- 													readonly required> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 									 <div data-ng-show="deliveryChallan.$submitted || deliveryChallan.dispatchdate.$touched" class="error_msg1"> -->
									<!-- 						             <div data-ng-show="deliveryChallan.dispatchdate.$error.required" class="error_msg1"> please choose dispatch date</div> -->
									<!-- 						             </div> -->
									<!-- 									</td> -->
								</tr>
							</table>

						</div>

						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>S.No</th>
										<th>Product Description</th>
										<th>Code</th>
										<th>Qty</th>
										<th>Unit</th>
										<th>Price</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>
									<tr
										data-ng-repeat="dispatchLogManagementDto in dispatchLogDtoForEachforAddList">
										<td>{{$index+1}}</td>
										<td>{{dispatchLogManagementDto.categoryType}} -
											{{dispatchLogManagementDto.subCategory}}</td>
										<td>{{dispatchLogManagementDto.modelCode}}</td>
										<td>{{dispatchLogManagementDto.allocatableQuantity}}</td>
										<td></td>
										<td>{{dispatchLogManagementDto.price}}</td>
										<security:authorize
											access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
											<td>{{dispatchLogManagementDto.price}}</td>
										</security:authorize>
										<security:authorize
											access="hasAuthority('USER') or hasAuthority('SUPER USER')">
											<!-- 										<td>{{dispatchLogManagementDto.allocatableQuantity}}</td> -->
											<td>{{dispatchLogManagementDto.price}}</td>
										</security:authorize>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-12 submit_col text-center">
							<button class="btn btn-primary"
								data-ng-click="generateChallanNo(deliveryChallan.$valid)">
								<i class="fa fa-check"></i>GENERATE CHALLAN
							</button>
							<span class="btn btn-warning" data-ng-click="back()"> <i
								class="fa fa-close"></i> CANCEL
							</span>
						</div>
					</form>

				</div>

				<div data-ng-show="downloadChallanform">


					<br> <br> <br>

					<div class="row">


						<div class="col-md-4"></div>

						<div class="col-md-4">

							<div class="alert alert-success">
								<h2 class="text-center">
									<b>Challan No :{{challanNo}} 
								</h2>
								<br>
								<button name="download" class="btn btn-primary btn-block"
									data-ng-click="DownloadChalan()">Download</button>
							</div>
						</div>
						<div class="col-md-4"></div>
					</div>

				</div>



			</div>
		</div>
	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->

<jsp:include page="footer.jsp" />
