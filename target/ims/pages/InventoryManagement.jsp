
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
	data-ng-controller="inventoryManagementController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">INVENTORY</h3>
		</div>
		<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
			<div class="col-md-7 align-self-center"
				data-ng-show="showInventoryGridPage">
				<ol class="breadcrumb">
					<a class="btn btn-primary waves-effect waves-light"
						href="officeAdmin?link=NewInventory">Add Inventory</a>
				</ol>
			</div>
		</security:authorize>
	</div>
	<!-- ============================================================== -->
	<!-- End Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Start Page Content -->
	<!-- ============================================================== -->
	<!-- Row -->
	<div class="form_section">
		<div data-ng-show="showInventoryGridPage">
			<div class="form-content">
				<h4 class="form_content_title">Search Inventory</h4>


				<div class="table-responsive"
					data-ng-if="inventoryManagementMaster.length > 0 || inventoryAssignManagementMasterDtoList.length > 0">

					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Category Type</th>
								<th>Category Code</th>
								<th>Sub Category</th>
								<th>Total Quantity</th>
								<th>Available Quantity</th>
								<th>Model</th>
								<th>Asset Tracking</th>
								<th>Asset No</th>
								<th>Site</th>
								<th>Arrival Date</th>
								<th class="not-export-col">Action</th>
							</tr>
						</thead>
						<tbody>

							<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
								<tr
									data-ng-repeat="inventoryManagementDto in inventoryManagementMaster">
									<td>{{inventoryManagementDto.categoryType}}</td>
									<td>{{inventoryManagementDto.categoryCode}}</td>
									<td>{{inventoryManagementDto.subCategory}}</td>
									<td>{{inventoryManagementDto.quantity}}</td>
									<td>{{inventoryManagementDto.availableQuantity}}</td>
									<td>{{inventoryManagementDto.modelCode}}</td>
									<td>{{inventoryManagementDto.assetTracking}}</td>
									<td>{{inventoryManagementDto.inventoryNumber}}</td>
									<td>{{inventoryManagementDto.site}}</td>
									<td>{{inventoryManagementDto.creationDate}}</td>
									<td class="table_btn_group">
										<div data-ng-if="inventoryManagementDto.button=='EDIT'">
											<a href=""
												data-ng-click="editInventoryPage(inventoryManagementDto)"
												class="btn btn-primary"><i class="fa fa-edit"></i>
												{{inventoryManagementDto.button}}</a>
										</div>
										<div data-ng-if="inventoryManagementDto.button=='EDIT'">
											<a href="" class="btn btn-primary"
												data-ng-click="view(inventoryManagementDto)"><i
												class="fa fa-drivers-license-o"></i> VIEW</a>

										</div>
										<div data-ng-if="inventoryManagementDto.button=='VIEW'">
											<a href="" data-ng-click="view(inventoryManagementDto)"
												class="btn btn-primary"><i
												class="fa fa-drivers-license-o"></i>
												{{inventoryManagementDto.button}}</a>
										</div> <!-- <a href="" class="btn btn-primary" data-ng-click="moveInventoryForWareHouse(inventoryManagementDto)"><i class="fa fa-drivers-license-o"></i> MOVE</a> -->
									</td>
								</tr>
							</security:authorize>
							<security:authorize
								access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
								<tr
									data-ng-repeat="inventoryManagementDto in inventoryManagementMaster">
									<td>{{inventoryManagementDto.categoryType}}</td>
									<td>{{inventoryManagementDto.categoryCode}}</td>
									<td>{{inventoryManagementDto.subCategory}}</td>
									<td>{{inventoryManagementDto.quantity}}</td>
									<td>{{inventoryManagementDto.availableQuantity}}</td>
									<td>{{inventoryManagementDto.modelCode}}</td>
									<td>{{inventoryManagementDto.assetTracking}}</td>
									<td>{{inventoryManagementDto.inventoryNumber}}</td>
									<td>{{inventoryManagementDto.site}}</td>
									<td>{{inventoryManagementDto.creationDate}}</td>
									<td class="table_btn_group">
										<!-- <div data-ng-if="inventoryManagementDto.button=='EDIT'"><a href="" data-ng-click="editInventoryPage(inventoryManagementDto)" class="btn btn-primary"><i class="fa fa-edit"></i> {{inventoryManagementDto.button}}</a></div>
							<div data-ng-if="inventoryManagementDto.button=='EDIT'"><a href="" class="btn btn-primary" data-ng-click="view(inventoryManagementDto)"><i class="fa fa-drivers-license-o"></i> VIEW</a>
							
							</div> -->
										<div data-ng-if="inventoryManagementDto.button=='VIEW'">
											<a href="" data-ng-click="view(inventoryManagementDto)"
												class="btn btn-primary"><i
												class="fa fa-drivers-license-o"></i>
												{{inventoryManagementDto.button}}</a>
										</div> <a href="" class="btn btn-primary"
										data-ng-click="moveInventoryForWareHouse(inventoryManagementDto)"><i
											class="fa fa-drivers-license-o"></i> MOVE</a>
									</td>
								</tr>
							</security:authorize>
							<security:authorize
								access="hasAuthority('USER') or hasAuthority('ENQUIRY') or hasAuthority('SUPER USER')">
								<tr
									data-ng-repeat="inventoryManagementDto in inventoryAssignManagementMasterDtoList">
									<td>{{inventoryManagementDto.categoryType}}</td>
									<td>{{inventoryManagementDto.categoryCode}}</td>
									<td>{{inventoryManagementDto.subCategory}}</td>
									<td>{{inventoryManagementDto.quantity}}</td>
									<td>{{inventoryManagementDto.availableQuantity}}</td>
									<td>{{inventoryManagementDto.modelCode}}</td>
									<td>{{inventoryManagementDto.assetTracking}}</td>
									<td>{{inventoryManagementDto.inventoryNumber}}</td>
									<td>{{inventoryManagementDto.site}}</td>
									<td>{{inventoryManagementDto.creationDate}}</td>
									<td class="table_btn_group"><a href=""
										class="btn btn-primary"
										data-ng-click="view(inventoryManagementDto)"><i
											class="fa fa-drivers-license-o"></i> VIEW</a> <security:authorize
											access="hasAuthority('USER') or hasAuthority('SUPER USER')">
											<a href="" class="btn btn-primary"
												data-ng-click="moveInventoryPage(inventoryManagementDto)"><i
												class="fa fa-arrow-right"></i> MOVE</a>
										</security:authorize></td>
								</tr>
							</security:authorize>
							<%-- <security:authorize access="hasAuthority('ENQUIRY')">
						<tr data-ng-repeat="inventoryManagementDto in inventoryAssignManagementMasterDtoList">
							<td>{{inventoryManagementDto.categoryType}}</td>
							<td>{{inventoryManagementDto.categoryCode}}</td>
							 <td>{{inventoryManagementDto.subCategory}}</td>
							<td>{{inventoryManagementDto.quantity}}</td>
							<td>{{inventoryManagementDto.modelCode}}</td>
							<td>{{inventoryManagementDto.assetTracking}}</td>
							<td>{{inventoryManagementDto.inventoryNumber}}</td>
							<td>{{inventoryManagementDto.site}}</td>
							
							<td class="table_btn_group"><!-- <a href="" class="btn btn-primary" data-ng-click="moveInventoryPage(inventoryManagementDto)"><i class="fa fa-arrow-right"></i> MOVE</a> -->
							<a href="" class="btn btn-primary" data-ng-click="view(inventoryManagementDto)"><i class="fa fa-drivers-license-o"></i> VIEW</a>
							</td> 
						</tr>
						</security:authorize> --%>
						</tbody>
					</table>
				</div>


				<br>


				<security:authorize
					access="hasAuthority('USER') or hasAuthority('ENQUIRY') or hasAuthority('SUPER USER')">

					<div class="text-center"
						data-ng-if="inventoryAssignManagementMasterDtoList.length == 0">
						<strong><b>{{alertMsg}}</b></strong>
					</div>

				</security:authorize>


				<security:authorize
					access="hasAuthority('OFFICE ADMINISTRATOR') or hasAuthority('WAREHOUSE ADMINISTRATOR')">

					<div class="text-center"
						data-ng-if="inventoryManagementMaster.length == 0">
						<strong><b>{{alertMsg}}</b></strong>
					</div>

				</security:authorize>

			</div>
		</div>

		<!-- general view -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Inventory Details</h4>
					</div>
					<div class="modal-body">
						<table class="table table-bordered table-striped">
							<tr>
								<th>Category Type</th>
								<td>{{inventoryManagementDetails.categoryType}}</td>
							</tr>
							<tr>
								<th>Category Code</th>
								<td>{{inventoryManagementDetails.categoryCode}}</td>
							</tr>
							<tr>
								<th>SubCategory</th>
								<td>{{inventoryManagementDetails.subCategory}}</td>
							</tr>
							<tr>
								<th>Quantity</th>
								<td>{{inventoryManagementDetails.availableQuantity}}</td>
							</tr>
							<tr>
								<th>Model Code</th>
								<td>{{inventoryManagementDetails.modelCode}}</td>
							</tr>
							<tr>
								<th>Asset Tracking</th>
								<td>{{inventoryManagementDetails.assetTracking}}</td>
							</tr>
							<tr>
								<th>Inventory Number</th>
								<td>{{inventoryManagementDetails.inventoryNumber}}</td>
							</tr>
							<tr>
								<th>site</th>
								<td>{{inventoryManagementDetails.site}}</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>



		<!-- -here write edit inventory page -->


		<div data-ng-if="showEditInventory">
			<div class="form_section">
				<div class="form-content create_form">
					<h4 class="form_content_title">Edit Inventory</h4>
					<form class="form-inline" name="NewInventory" id="NewInventory"
						data-ng-submit="editInventoryManagement(NewInventory.$valid)"
						novalidate>
						<div class="col-md-6 col_md text-center">
							<input type="hidden" class="form-control" id="address1"
								name="address1" data-ng-model="inventoryManagementDto.id">
							<input type="hidden" class="form-control" id="inventoryNumber"
								name="inventoryNumber"
								data-ng-model="inventoryManagementDto.inventoryNumber">
							<div class="">
								<label for="email">CategoryType</label>

								<div class="new-select-option">
									<select name="categoryType" id="categoryType" wb-select2
										data-ng-model="inventoryManagementDto.categoryType"
										data-ng-change="getSubCategoryByCategory(inventoryManagementDto.categoryType)"
										required class="form-control"
										style="width: 100%; height: 36px;"
										data-ng-disabled="readOnlyInput">
										<option value="" selected></option>
										<option
											data-ng-repeat="x in categoryMasterDtoList track by x.categoryType"
											data-ng-if="x.status=='ACTIVE'" value="{{x.categoryType}}">{{x.categoryType}}</option>
									</select>
								</div>



							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.categoryType.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.categoryType.$error.required"
									class="error_msg">Please choose CategoryType</div>
							</div>



							<div class="">
								<label for="email">Type</label>

								<div class="new-select-option">
									<select name="type" id="type" wb-select2
										data-ng-model="inventoryManagementDto.type" required
										class="form-control" style="width: 100%; height: 36px;"
										data-ng-disabled="readOnlyInput">
										<option value="" selected></option>
										<option data-ng-repeat="x in typeDtoList track by x.type"
											value="{{x.type}}">{{x.type}}</option>
									</select>
								</div>
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.type.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.type.$error.required"
									class="error_msg">Please choose Type</div>
							</div>
							<div class="">
								<label for="pwd">Sub Category</label>

								<!-- <div class="new-select-option">
								             <select name="subCategory" id="subCategory" wb-select2
									data-ng-model="inventoryManagementDto.subCategory"
									data-ng-change="getModelBySubCategoryName(inventoryManagementDto.subCategory)"
									required class="form-control"
									style="width: 100%; height: 36px;" data-ng-disabled="">
									 <option></option> 
									<option
										data-ng-repeat="x in subCategoryMasterDtoList track by x.subCategory"
										value="{{x.subCategory}}">{{x.subCategory}}</option>
								</select>
							</div> -->

								<input type="text" class="form-control" id="subCategory"
									name="subCategory"
									data-ng-model="inventoryManagementDto.subCategory"
									autocomplete="off" required="mandatory" readonly="true">
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.subCategory.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.subCategory.$error.required"
									class="error_msg">Please choose subCategoryType</div>
							</div>

							<span class=""
								data-ng-if="inventoryManagementDto.categoryType==='VEHICLE'">
								<div class="add_icon_asterisk">
									<label for="pwd">Make Name </label> <input type="text"
										class="form-control" id="makeName" name="makeName"
										data-ng-model="inventoryManagementDto.makeName"
										autocomplete="off" required="mandatory"> <i
										class="fa fa-asterisk"></i>
								</div>
								<div
									data-ng-show="NewInventory.$submitted || NewInventory.makeName.$touched"
									class="error_msg">
									<div data-ng-show="NewInventory.makeName.$error.required"
										class="error_msg">Please enter makeName</div>
								</div>

								<div class="add_icon_asterisk">
									<label for="pwd">model Name </label> <input type="text"
										class="form-control" id="modelName" name="modelName"
										data-ng-model="inventoryManagementDto.modelName"
										autocomplete="off" required="mandatory"> <i
										class="fa fa-asterisk"></i>
								</div>
								<div
									data-ng-show="NewInventory.$submitted || NewInventory.modelName.$touched"
									class="error_msg">
									<div data-ng-show="NewInventory.modelName.$error.required"
										class="error_msg">Please enter model Name</div>
								</div>

								<div class="add_icon_asterisk">
									<label for="pwd">vehicle Number </label> <input type="text"
										class="form-control" id="vehicleNumber" vehiclenoregx
										name="vehicleNumber"
										data-ng-model="inventoryManagementDto.vehicleNumber"
										autocomplete="off" required="mandatory"> <i
										class="fa fa-asterisk"></i>
								</div>
								<div
									data-ng-show="NewInventory.$submitted || NewInventory.vehicleNumber.$touched"
									class="error_msg">
									<div data-ng-show="NewInventory.vehicleNumber.$error.required"
										class="error_msg">Please enter vehicle Number</div>
								</div>

							</span>


							<div class="">
								<label for="pwd">Model Code </label> <input type="text"
									class="form-control" id="address1" name="modelCode"
									data-ng-model="inventoryManagementDto.modelCode"
									name="modelCode" required readOnly>
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.modelCode.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.modelCode.$error.required"
									class="error_msg">Please enter modelCode</div>
							</div>
							<div class="add_icon_asterisk">
								<label for="pwd">Asset Tracking</label> <input type="text"
									class="form-control" id="assetTracking" name="assetTracking"
									data-ng-model="inventoryManagementDto.assetTracking" readonly>
								<i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.assetTracking.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.assetTracking.$error.required"
									class="error_msg">Please enter asset Tracking</div>
							</div>
							<div class="">
								<label for="pwd">supplier Name</label>


								<div class="new-select-option">
									<select name="supplierName" id="supplierName"
										data-ng-model="inventoryManagementDto.supplierName" wb-select2
										required class="form-control"
										style="width: 100%; height: 36px;">
										<option value="" selected></option>
										<option data-ng-repeat="x in supplierMaster" value="{{x.id}}">{{x.supplierName}}</option>
									</select>
								</div>



								<!-- <input
											list="supplier" class="form-control" 
											id="supplier_list" data-ng-readonly="datareadonly" name="supplierName" required 
											data-ng-model="inventoryManagementDto.supplierName">
										<datalist id="supplier">
											<option
												data-ng-repeat="x in supplierMaster track by x.supplierName"
												value="{{x.supplierName}}">{{x.supplierName}}</option>
										</datalist> -->
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.supplierName.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.supplierName.$error.required"
									class="error_msg">Please choose supplierName</div>
							</div>

							<div class="">
								<label for="">Supplier ID</label> <input type="text"
									class="form-control" id="supplierid" name="supplierid"
									data-ng-model="inventoryManagementDto.supplierName" readonly>

							</div>

							<div class="">
								<label for="pwd">Manufacturer Name</label>

								<div class="new-select-option">
									<select name="manufacturerName" id="manufacturerName"
										wb-select2
										data-ng-model="inventoryManagementDto.manufacturerName"
										required class="form-control"
										style="width: 100%; height: 36px;">
										<option value="" selected></option>
										<option
											data-ng-repeat="x in activeManufacturerList track by x.name"
											value="{{x.name}}">{{x.name}}</option>
									</select>
								</div>


								<!-- <input
											list="manufacturer" class="form-control" 
											id="manufacturer_list" data-ng-readonly="datareadonly" name="manufacturerName" required 
											data-ng-model="inventoryManagementDto.manufacturerName" name="manufacturerName">
										<datalist id="manufacturer">
											<option
												data-ng-repeat="x in activeManufacturerList track by x.name"
												value="{{x.name}}">{{x.name}}</option>
										</datalist> -->
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.manufacturerName.$touched"
								class="error_msg">
								<div
									data-ng-show="NewInventory.manufacturerName.$error.required"
									class="error_msg">Please choose manufacturerName</div>
							</div>

						</div>
						<div class="col-md-6 col_md text-center">
							<div class="">
								<label for="pwd"> Quantity</label> <input type="text"
									class="form-control" id="address2"
									data-ng-model="inventoryManagementDto.quantity"
									autocomplete="off" numbersonly name="quantity" required
									data-ng-readonly="readOnlyQuantity">
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.quantity.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.quantity.$error.required"
									class="error_msg">Please enter quantity</div>
							</div>
							<div class="">
								<label for="pwd"> purchase Cost INR:</label> <input type="text"
									class="form-control"
									data-ng-model="inventoryManagementDto.purchaseCost"
									autocomplete="off" numbersonly name="purchaseCost" required>
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.purchaseCost.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.purchaseCost.$error.required"
									class="error_msg">Please enter purchaseCost</div>
							</div>

							<div class="">
								<label for="email">purchase Date:</label>

								<div class="input-group date" data-date-format="mm/dd/yyyy"
									data-date-today-highlight="true" data-date-autoclose="true"
									data-provide="datepicker">
									<div class="input-group-addon inner-addon right-addon ">
										<i class="fa fa-calendar"></i> <input type="text"
											class="form-control" placeholder="" id="purchaseDate"
											name="purchaseDate" required
											data-ng-model="inventoryManagementDto.purchaseDate" readonly
											required>
									</div>
								</div>
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.purchaseDate.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.purchaseDate.$error.required"
									class="error_msg">Please Select purchase Date</div>
							</div>

							<div class="add_icon_asterisk">
								<label for="email">Is Service applicable</label>


								<div class="new-radio-button-inline">
									<input type="radio"
										data-ng-model="inventoryManagementDto.isServicePeriodApplicable"
										data-ng-change="isServiceSelected(inventoryManagementDto.isServicePeriodApplicable)"
										required class="with-gap" autocomplete="off"
										name="isServicePeriodApplicable" id="YES1" value="YES">
									<label for="YES1">YES</label> <input type="radio"
										data-ng-model="inventoryManagementDto.isServicePeriodApplicable"
										data-ng-change="isServiceSelected(inventoryManagementDto.isServicePeriodApplicable)"
										required class="with-gap" autocomplete="off"
										name="isServicePeriodApplicable" id="NO1" value="NO">
									<label for="NO1">NO</label>
								</div>

								<i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.isServicePeriodApplicable.$touched"
								class="error_msg">
								<div
									data-ng-show="NewInventory.isServicePeriodApplicable.$error.required"
									class="error_msg">Please choose isService Applicable</div>
							</div>


							<!--    <div class="add_icon_asterisk"> -->
							<div class="single_select_box "
								data-ng-if="inventoryManagementDto.isServicePeriodApplicable=='YES'">
								<label for="email">service Due Date</label>

								<div class="new-select-option">
									<select name="serviceDueDate" id="serviceDueDate"
										data-ng-model="inventoryManagementDto.serviceDueDate" required
										class="wbSelect2 form-control"
										style="width: 100%; height: 36px;">
										<option value="" selected></option>
										<!-- <option value="0">0</option> -->
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select>

								</div>

							</div>

							<div
								data-ng-show="NewInventory.$submitted || NewInventory.serviceDueDate.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.serviceDueDate.$error.required"
									class="error_msg">Please enter serviceDueDate</div>
							</div>




							<div class="">
								<label for="email">Warranty Period:</label>


								<div class="new-radio-button-inline">
									<input type="radio"
										data-ng-model="inventoryManagementDto.isWarrantyPeriodApplicable"
										data-ng-change="isWarrantySelected(inventoryManagementDto.isWarrantyPeriodApplicable)"
										required class="with-gap" name="isWarrantyPeriodApplicable"
										id="YES" value="YES"> <label for="YES">YES</label> <input
										type="radio"
										data-ng-model="inventoryManagementDto.isWarrantyPeriodApplicable"
										data-ng-change="isWarrantySelected(inventoryManagementDto.isWarrantyPeriodApplicable)"
										required class="with-gap" name="isWarrantyPeriodApplicable"
										id="NO" value="NO"> <label for="NO">NO</label>
								</div>
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.isWarrantyPeriodApplicable.$touched"
								class="error_msg">
								<div
									data-ng-show="NewInventory.isWarrantyPeriodApplicable.$error.required"
									class="error_msg">Please choose isWarranty Applicable</div>
							</div>
							<div class="single_select_box"
								data-ng-if="inventoryManagementDto.isWarrantyPeriodApplicable=='YES'">
								<label for="email">Warranty period :</label>


								<!-- <div class="input-group date" data-date-format="mm/dd/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" name="warrantyPeriod" data-ng-model="inventoryManagementDto.warrantyPeriod" id="warrantyPeriod"  readonly required>
                                            </div>
                                        </div>	 -->

								<div class="select_box_two">

									<select class="selectpicker1" data-style="form-control"
										id="year" name="year"
										data-ng-model="inventoryManagementDto.year" required
										style="padding: 7px; width: 85%; margin-right: 12px;">
										<option value="">Year</option>
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select><b>YY</b> <span
										data-ng-show="inventoryManagementDto.isWarrantyPeriodApplicable=='YES'">
										<span
										data-ng-show="NewInventory.$submitted || NewInventory.year.$touched"
										class="error_msg"> <span
											data-ng-show="NewInventory.year.$error.required"
											class="error_msg">Please choose year</span>
									</span>
									</span> <select class="selectpicker1" data-style="form-control"
										id="month" name="month"
										data-ng-model="inventoryManagementDto.month" required
										style="padding: 7px; width: 85%; margin-right: 5px;">
										<option value="">Month</option>
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select><b>MM</b> <span
										data-ng-show="inventoryManagementDto.isWarrantyPeriodApplicable=='YES'">
										<span
										data-ng-show="NewInventory.$submitted || NewInventory.month.$touched"
										class="error_msg"> <span
											data-ng-show="NewInventory.month.$error.required"
											class="error_msg">Please choose month</span>
									</span>
									</span>
								</div>

							</div>
							<div class="new-radio-button-inline">
								<input type="hidden"
									data-ng-model="inventoryManagementDto.location" name="location"
									required value="WAREHOUSE"
									data-ng-change="location(inventoryManagementDto.location)"
									id="WAREHOUSE" class="with-gap">
							</div>
							<div class=""
								data-ng-if="inventoryManagementDto.location=='WAREHOUSE'">
								<label for="email">if wareHouse Site</label>

								<div class="new-select-option">
									<select name="site" id="site"
										data-ng-model="inventoryManagementDto.site" wb-select2
										data-ng-change="getWareHouseBlocks(inventoryManagementDto.site)"
										required class="form-control"
										style="width: 100%; height: 36px;" data-ng-disabled="true">
										<option value="" selected></option>
										<option
											data-ng-repeat="x in wareHouseDtoList track by x.wareHouseName"
											value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>
									</select>
								</div>


								<!-- <input
											list="wareHouse" class="form-control" 
											id="wareHouse_List" placeholder="wareHouse" data-ng-readonly="datareadonly" name="site" required
											data-ng-model="inventoryManagementDto.site" data-ng-blur="getWareHouseBlocks(inventoryManagementDto.site)">
										<datalist id="wareHouse">
											<option
												data-ng-repeat="x in activeWareHouseList track by x.wareHouseName"
												value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>
										</datalist> -->
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.site.$touched">
								<div data-ng-show="NewInventory.site.$error.required"
									class="error_msg">Please choose project</div>
							</div>
							<div class="add_icon_asterisk">
								<label for="email">Blocks</label> <input type="text"
									class="form-control"
									data-ng-model="inventoryManagementDto.wareHouseBlockName"
									name="blockName" required readonly="true">
								<!-- <div class="new-select-option">
								             <select name="blockName" id="blockName"
									data-ng-model="inventoryManagementDto.wareHouseBlockName" wb-select2
									required class="form-control"
									style="width: 100%; height: 36px;" data-ng-disabled="true">
									<option value="" selected></option>
									<option
										data-ng-repeat="x in wareHouseBlockEntityList track by x.blocksNames"
										value="{{x.blocksNames}}">{{x.blocksNames}}</option>
								</select>
							</div> -->
							</div>
							<div
								data-ng-show="NewInventory.$submitted || NewInventory.blockName.$touched"
								class="error_msg">
								<div data-ng-show="NewInventory.blockName.$error.required"
									class="error_msg">Please choose Block</div>
							</div>


						</div>
						<div class="col-12 submit_col text-center">
							<button class="btn btn-primary" type="submit">
								<i class="fa fa-check"></i> SAVE
							</button>
							<button class="btn btn-warning"
								data-ng-click="cancelEditInventoryPage()">
								<i class="fa fa-close"></i> CANCEL
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>


		<!-- -here write move inventory page -->

		<div data-ng-if="showMoveInventory">
			<div class="form_section">
				<div class="form-content create_form">
					<h4 class="form_content_title">Move Inventory from User</h4>
					<form class="form-inline" name="moveInventory"
						data-ng-submit="RequestInventoryToMoveFromProject(moveInventory.$valid)"
						id="moveInventory" novalidate>
						<div class="col-md-2"></div>
						<div class="col-md-8 col_md text-center">
							<input type="hidden" class="form-control" id="address1"
								name="address1" data-ng-model="inventoryManagementDto.id">
							<div class="">
								<label for="pwd">Category Type</label> <input type="text"
									class="form-control" id="address2" name="categoryType"
									data-ng-model="inventoryManagementDto.categoryType" required
									readOnly>
							</div>
							<!-- <div class="">
												<label for="pwd"> Type</label>
												<input type="text" class="form-control" id="address5" name="type" data-ng-model="inventoryManagementDto.type"  required  readOnly>
										</div> -->
							<div class="">
								<label for="pwd">SubCategory</label> <input type="text"
									class="form-control" id="subCategory" name="subCategory"
									data-ng-model="inventoryManagementDto.subCategory" required
									readOnly>
							</div>
							<div class="">
								<label for="pwd">Model Code </label> <input type="text"
									class="form-control" id="address1" name="modelCode"
									data-ng-model="inventoryManagementDto.modelCode"
									name="modelCode" required readOnly>
							</div>
							<div class="">
								<label for="pwd">Available Quantity</label> <input type="text"
									class="form-control" id="address2" name="quantity"
									data-ng-model="inventoryManagementDto.quantity" name="quantity"
									required readOnly>
							</div>
							<div class="add_icon_asterisk">
								<label for="pwd">Quantity to be moved:</label> <input
									type="text" class="form-control" id="quantityToBeMoved"
									name="quantityToBeMoved" numbersonly
									data-ng-model="inventoryManagementDto.quantityToBeMoved"
									name="quantityToBeMoved"
									data-ng-blur="checkQuantityMoveForMovePage(inventoryManagementDto.quantityToBeMoved)"
									required> <i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="moveInventory.$submitted || moveInventory.quantityToBeMoved.$touched"
								class="error_msg">
								<div
									data-ng-show="moveInventory.quantityToBeMoved.$error.required"
									class="error_msg">Please enter Quantity to be moved</div>
								<!--  <div data-ng-show="moveInventory.quantityToBeMoved.$error.pattern" class="error_msg1">Quantity to be moved should be greater than zero</div> -->
							</div>
							<div class="">

								<label for="pwd">From Project Site</label> <input type="text"
									class="form-control" id="site" name="site"
									data-ng-model="inventoryManagementDto.requestedFrom" readOnly>
							</div>
							<div class="add_icon_asterisk">
								<label for="pwd">ACTION</label> <select name="action"
									class="form-control"
									data-ng-model="inventoryManagementDto.action"
									data-ng-options="key as value for (key , value)  in actionList"
									data-ng-change="checkIfvehicle(inventoryManagementDto.action)"
									required>
									<option value="">--select--</option>
								</select> <i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="moveInventory.$submitted || moveInventory.action.$touched"
								class="error_msg">
								<div data-ng-show="moveInventory.action.$error.required"
									class="error_msg">Please select action</div>
							</div>

							<div class="add_icon_asterisk" data-ng-if="showWorkingCondition">
								<label for="pwd">WORKING CONDITION</label> <select
									name="working" class="form-control"
									data-ng-model="inventoryManagementDto.workingCondition"
									data-ng-options="item for item in workingConditionList"
									required>
									<option value="">--select--</option>
								</select> <i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="moveInventory.$submitted || moveInventory.working.$touched"
								class="error_msg">
								<div data-ng-show="moveInventory.working.$error.required"
									class="error_msg">Please select action</div>
							</div>


							<%-- <div class="">
											<label for="email">To WareHouse</label>
											<input type="text" class="form-control" id="site" name="site" data-ng-model="inventoryManagementDto.requestedTo"  data-ng-init="inventoryManagementDto.requestedTo='${inventoryAssignDto.warehouseOrSitename}'" readOnly>
										</div>  --%>

							<span class="" data-ng-if="showServiceName"> <input
								type="hidden" name="service"
								data-ng-model="inventoryManagementDto.requestedTo"
								data-ng-init="inventoryManagementDto.requestedTo='SERVICE'">
							</span>


							<div class="" data-ng-if="showMoveScrapToWarehouseOrShopRatio">
								<label for="email">Scrap move To?</label>


								<div class="new-radio-button-inline">

									<security:authorize
										access="hasAuthority('USER') or hasAuthority('SUPER USER')">
										<input type="radio"
											data-ng-model="inventoryManagementDto.scrapMoveTo" required
											class="with-gap" autocomplete="off" name="scrapMoveTo"
											id="WAREHOUSE" value="WAREHOUSE"
											data-ng-change="showwarehouse()">
										<label for="WAREHOUSE">WAREHOUSE</label>
									</security:authorize>
									<input type="radio"
										data-ng-model="inventoryManagementDto.scrapMoveTo" required
										class="with-gap" autocomplete="off" name="scrapMoveTo"
										id="SHOP" value="SHOP" data-ng-change="hidewarehouse()">
									<label for="SHOP">SHOP</label>
								</div>

								<div
									data-ng-show="moveInventory.$submitted || moveInventory.scrapMoveTo.$touched"
									class="error_msg">
									<div data-ng-show="moveInventory.scrapMoveTo.$error.required"
										class="error_msg">Please choose warehouse or shop</div>
								</div>
							</div>
							<span class="" data-ng-if="showWarehouseDropDown">
								<div class="add_icon_asterisk">
									<label for="email">WareHouse</label>
									<div class="new-select-option">
										<select name="requestedTo" id="requestedTo"
											data-ng-model="inventoryManagementDto.requestedTo" required
											class="form-control" wb-select2
											style="width: 100%; height: 36px;">
											<option value="" selected></option>
											<option
												data-ng-repeat="x in wareHouseDtoList track by x.wareHouseName"
												value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>
										</select>
									</div>
									<i class="fa fa-asterisk"></i>
								</div>



								<div
									data-ng-show="moveInventory.$submitted || moveInventory.requestedTo.$touched"
									class="error_msg">
									<div data-ng-show="moveInventory.requestedTo.$error.required"
										class="error_msg">Please choose wareHouse</div>
								</div>
							</span>



							<div class="">
								<label for="pwd">Comments </label> <input type="text"
									class="form-control" id="comments" name="comments" alphamumeric
									data-ng-model="inventoryManagementDto.comments" maxlength="50">
							</div>
							<div class="">
								<input type="hidden" class="form-control"
									data-ng-model="inventoryManagementDto.inventoryLocation">
							</div>


							<div class="add_icon_asterisk" data-ng-if="showRadio">

								<label for="email">are you moving this through vehicle ?</label>


								<div class="new-radio-button-inline">
									<input type="radio"
										data-ng-model="inventoryManagementDto.challanStatus" required
										class="with-gap" autocomplete="off" name="challanStatus"
										id="YES" value="YES"> <label for="YES">YES</label> <input
										type="radio"
										data-ng-model="inventoryManagementDto.challanStatus" required
										class="with-gap" autocomplete="off" name="challanStatus"
										id="NO" value="NO"> <label for="NO">NO</label> <i
										class="fa fa-asterisk"></i>
								</div>

								<div
									data-ng-show="moveInventory.$submitted || moveInventory.challanStatus.$touched"
									class="error_msg">
									<div data-ng-show="moveInventory.challanStatus.$error.required"
										class="error_msg">Please choose yes or no</div>
								</div>
							</div>
						</div>


						<div class="col-md-2"></div>

						<div class="col-md-12 submit_col text-center">
							<button class="btn btn-primary" type="submit">
								<i class="fa fa-arrow-right"></i> MOVE
							</button>
							<button class="btn btn-warning"
								data-ng-click="cancelMoveInventoryPage()">
								<i class="fa fa-close"></i> CANCEL
							</button>
						</div>
				</div>

				</form>
			</div>
		</div>



		<!-- ---------------show move inventory for warehouse admin -->


		<div data-ng-if="showMoveInventoryForWarehouse">
			<div class="form_section">
				<div class="form-content create_form">
					<h4 class="form_content_title">Move Inventory from WareHouse</h4>
					<form class="form-inline" name="moveInventory"
						data-ng-submit="moveInventoryFromWarehouseByWareHouseAdmin(moveInventory.$valid)"
						id="moveInventory" novalidate>
						<div class="col-md-2"></div>
						<div class="col-md-8 col_md text-center">
							<input type="hidden" class="form-control" id="address1"
								name="address1" data-ng-model="inventoryManagementDto.id">
							<div class="">
								<label for="pwd">Category Type</label> <input type="text"
									class="form-control" id="address2" name="categoryType"
									data-ng-model="inventoryManagementDto.categoryType" required
									readOnly>
							</div>
							<!-- <div class="">
												<label for="pwd">Type</label>
												<input type="text" class="form-control" id="type" name="type" data-ng-model="inventoryManagementDto.type"  required  readOnly>
										</div> -->
							<div class="">
								<label for="pwd">SubCategory</label> <input type="text"
									class="form-control" id="subCategory" name="subCategory"
									data-ng-model="inventoryManagementDto.subCategory" required
									readOnly>
							</div>
							<div class="">
								<label for="pwd">Model Code </label> <input type="text"
									class="form-control" id="address1" name="modelCode"
									data-ng-model="inventoryManagementDto.modelCode"
									name="modelCode" required readOnly>
							</div>
							<div class="">
								<label for="pwd">Available Quantity</label> <input type="text"
									class="form-control" id="address2" name="quantity"
									data-ng-model="inventoryManagementDto.availableQuantity"
									name="quantity" required readOnly>
							</div>
							<div class="add_icon_asterisk">
								<label for="pwd">Quantity to be moved</label> <input type="text"
									class="form-control" id="quantityToBeMoved"
									name="quantityToBeMoved" numbersonly
									data-ng-model="inventoryManagementDto.quantityToBeMoved"
									name="quantityToBeMoved"
									data-ng-blur="checkQuantityMoveForWareHouseAdminPage(inventoryManagementDto.quantityToBeMoved)"
									required> <i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="moveInventory.$submitted || moveInventory.quantityToBeMoved.$touched"
								class="error_msg">
								<div
									data-ng-show="moveInventory.quantityToBeMoved.$error.required"
									class="error_msg">Please enter Quantity to be moved</div>
								<!--  <div data-ng-show="moveInventory.quantityToBeMoved.$error.pattern" class="error_msg1">Quantity to be moved should be greater than zero</div> -->
							</div>
							<!--  <div class="">
										 
												<label for="pwd">From Project Site</label>
												<input type="text" class="form-control" id="site" name="site" data-ng-model="inventoryManagementDto.requestedFrom" readOnly>
										</div> -->
							<div class="add_icon_asterisk">
								<label for="pwd">ACTION</label> <select name="action"
									class="form-control"
									data-ng-model="inventoryManagementDto.action"
									data-ng-options="key as value for (key , value)  in warehouseActionList"
									data-ng-change="checkIfvehicle(inventoryManagementDto.action)"
									required>
									<option value="">--select--</option>
								</select> <i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="moveInventory.$submitted || moveInventory.action.$touched"
								class="error_msg">
								<div data-ng-show="moveInventory.action.$error.required"
									class="error_msg">Please select action</div>
							</div>

							<div class="add_icon_asterisk" data-ng-if="showWorkingCondition">
								<label for="pwd">WORKING CONDITION</label> <select
									name="working" class="form-control"
									data-ng-model="inventoryManagementDto.workingCondition"
									data-ng-options="item for item in workingConditionList"
									required>
									<option value="">--select--</option>
								</select> <i class="fa fa-asterisk"></i>
							</div>
							<div
								data-ng-show="moveInventory.$submitted || moveInventory.working.$touched"
								class="error_msg">
								<div data-ng-show="moveInventory.working.$error.required"
									class="error_msg">Please select action</div>
							</div>
							<div class="add_icon_asterisk"
								data-ng-if="showMoveScrapToWarehouseOrShopRatio">
								<label for="email">Scrap move To ?</label>


								<div class="new-radio-button-inline">
									<input type="radio"
										data-ng-model="inventoryManagementDto.scrapMoveTo" required
										class="with-gap" autocomplete="off" name="scrapMoveTo"
										id="BYOWN" value="BYOWN"> <label for="BYOWN">BY
										OWN</label> <input type="radio"
										data-ng-model="inventoryManagementDto.scrapMoveTo" required
										class="with-gap" autocomplete="off" name="scrapMoveTo"
										id="SHOP" value="SHOP"> <label for="SHOP">SHOP</label>
									<i class="fa fa-asterisk"></i>
								</div>
								<div
									data-ng-show="moveInventory.$submitted || moveInventory.scrapMoveTo.$touched"
									class="error_msg">
									<div data-ng-show="moveInventory.scrapMoveTo.$error.required"
										class="error_msg">Please choose By OWN or shop</div>
								</div>
							</div>

							<div class="">
								<label for="pwd">Comments </label> <input type="text"
									class="form-control" id="comments" name="comments" alphamumeric
									data-ng-model="inventoryManagementDto.comments" maxlength="50">
							</div>
							<div class="">
								<input type="hidden" class="form-control"
									data-ng-model="inventoryManagementDto.inventoryLocation">
							</div>


							<div class="add_icon_asterisk">
								<label for="email">are you moving this through vehicle ?</label>
								<div class="new-radio-button-inline">
									<input type="radio"
										data-ng-model="inventoryManagementDto.challanStatus" required
										class="with-gap" autocomplete="off" name="challanStatus"
										id="YES"
										data-ng-change="getVehicleDetails(inventoryManagementDto.challanStatus)"
										value="YES"> <label for="YES">YES</label> <input
										type="radio"
										data-ng-model="inventoryManagementDto.challanStatus" required
										class="with-gap" autocomplete="off" name="challanStatus"
										id="NO"
										data-ng-change="getVehicleDetails(inventoryManagementDto.challanStatus)"
										value="NO"> <label for="NO">NO</label> <i
										class="fa fa-asterisk"></i>
								</div>
								<div
									data-ng-show="moveInventory.$submitted || moveInventory.challanStatus.$touched"
									class="error_msg">
									<div data-ng-show="moveInventory.challanStatus.$error.required"
										class="error_msg">Please choose yes or no</div>
								</div>
							</div>



							<div class="add_icon_asterisk" data-ng-show="showVehicleNumber">
								<label for="email">Vehicle Number</label> <input type="text"
									class="form-control" id="vehicleNo" name="vehicleNo"
									placeholder="TN44FF1249" vehiclenoregx autocomplete="off"
									data-ng-model="inventoryManagementDto.vehicleNo"
									data-ng-pattern="/^[A-Z]{2}[0-9]{2}[A-Z]{1,3}[0-9]{4}$/"
									maxlength="11" data-ng-required="showVehicleNumber"> <i
									class="fa fa-asterisk"></i>
								<div
									data-ng-show="moveInventory.$submitted || moveInventory.vehicleNo.$touched"
									class="error_msg">
									<div data-ng-show="moveInventory.vehicleNo.$error.required"
										class="error_msg">please enter vehicle Number</div>
									<div data-ng-show="moveInventory.vehicleNo.$error.pattern"
										class="error_msg">please enter valid vehicle Number</div>
								</div>
							</div>
						</div>
						<div class="col-md-2"></div>

						<div class="col-md-12 submit_col text-center">
							<button class="btn btn-primary" type="submit">
								<i class="fa fa-arrow-right"></i> MOVE
							</button>
							<button class="btn btn-warning"
								data-ng-click="cancelWarehouseMoveInventoryPage()">
								<i class="fa fa-close"></i> CANCEL
							</button>
						</div>
				</div>

				</form>
			</div>
		</div>













	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />
