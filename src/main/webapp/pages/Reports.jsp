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
	data-ng-controller="ReportsController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">REPORT</h3>
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
			<h4 class="form_content_title">Reports</h4>
			<form class="form-inline" method="post" name="reportForm"
				id="reportForm" novalidate>
				<!-- data-ng-submit="searchReport(reportForm.$valid)" -->


				<div class="col-md-12 reports">
					<div class="row">

						<div class="col-md-5">

							<div class="col_md text-center">
								<div class="add_icon_asterisk">
									<label for="email">Select List :</label> <select
										class="form-control" id="reportMenu" name="reportMenu"
										data-ng-init="reportDto.reportMenu=''"
										data-ng-model="reportDto.reportMenu" required tabindex="1">
										<option value="" selected>---select---</option>
										<option value="INVENTORY DETAILS">INVENTORY DETAILS
										<option value="INVENTORY SCRAP">INVENTORY SCRAP
										<option value="INVENTORY REQUESTS">INVENTORY REQUESTS





										
										<option value="INVENTORY SERVICE">INVENTORY SERVICE
										<option value="ELCB">ELCB
										<option value="WORKMEN DETAILS">WORKMEN DETAILS
										<option value="INVENTORY INWARDS">INVENTORY INWARDS
										<option value="INVENTORY OUTWARDS">INVENTORY OUTWARDS





										
									</select> <i class="fa fa-asterisk"></i>
								</div>

								<div
									data-ng-show="reportForm.$submitted || reportForm.reportMenu.$touched"
									class="error_msg">
									<div data-ng-show="reportForm.reportMenu.$error.required"
										class="error_msg">Please Select Option</div>
								</div>

								<div class="add_icon_asterisk">
									<label for="email">Report category</label>


									<div class="new-radio-button-inline datewiseSec">
										<input type="radio" data-ng-model="reportDto.reportCategory"
											required class="with-gap" autocomplete="off" tabindex="2"
											name="reportCategory" id="DateWise" value="DateWise">
										<label for="DateWise">DATEWISE</label> <input type="radio"
											data-ng-model="reportDto.reportCategory" required
											tabindex="3" class="with-gap" autocomplete="off"
											name="reportCategory" id="All" value="All"> <label
											for="All">ALL</label>
									</div>

									<i class="fa fa-asterisk"></i>
								</div>
								<div
									data-ng-show="reportForm.$submitted || reportForm.reportCategory.$touched"
									class="error_msg">
									<div data-ng-show="reportForm.reportCategory.$error.required"
										class="error_msg">Please choose Report category</div>
								</div>

								<span data-ng-if="reportDto.reportCategory=='DateWise'">
									<div class="add_icon_asterisk">
										<label for="pwd"> From Date :</label>
										<div class="input-group date" data-date-format="dd-mm-yyyy"
											data-date-today-highlight="true" data-date-end-date="0d"
											data-date-autoclose="true" data-provide="datepicker">
											<div class="input-group-addon inner-addon right-addon ">
												<i class="fa fa-calendar"></i> <input type="text"
													class="form-control" placeholder="" name="fromDate"
													id="fromDate" data-ng-model="reportDto.fromDate" readonly
													required>
											</div>

										</div>
										<i class="fa fa-asterisk"></i>

									</div>


									<div
										data-ng-show="reportForm.$submitted || reportForm.fromDate.$touched"
										class="error_msg">
										<div data-ng-show="reportForm.fromDate.$error.required"
											class="error_msg">Please Select From Date</div>
									</div>

									<div class="add_icon_asterisk">
										<label for="pwd"> To Date :</label>
										<div class="input-group date" data-date-format="dd-mm-yyyy"
											data-date-today-highlight="true" data-date-autoclose="true"
											data-provide="datepicker">
											<div class="input-group-addon inner-addon right-addon ">
												<i class="fa fa-calendar"></i> <input type="text"
													class="form-control" placeholder="" name="toDate"
													id="toDate" data-ng-model="reportDto.toDate"
													data-ng-change="validateToDate()" readonly required>
											</div>
										</div>
										<i class="fa fa-asterisk"></i>
									</div>

									<div
										data-ng-show="reportForm.$submitted || reportForm.toDate.$touched"
										class="error_msg">
										<div data-ng-show="reportForm.toDate.$error.required"
											class="error_msg">Please Select To Date</div>
									</div>
								</span>

							</div>
							<div class="col-md-15 submit_col text-center">
								<button class="btn btn-primary" data-ng-click="search()">Search</button>
							</div>

						</div>


						<div class="col-md-4" data-ng-show="reportDto.reportMenu !=''">


							<!-- <div class=""
								data-ng-show="reportDto.reportMenu =='INVENTORY DETAILS' ">

								<label for="pwd">Projects:</label>

								<div class="new-check-button1">

									<input type="checkbox" id="chekallpro" class="filled-in"
										data-ng-click="toggleAll_pro()"
										data-ng-model="isAllSelected_pro"><label
										for="chekallpro">Select all</label>



									<div data-ng-repeat="project in projectList">
										<input type="checkbox" name="projectName"
											id="projectName{{$index}}"
											data-ng-model="projectList[$index].selected"
											data-ng-change="optionToggled_pro()" class="filled-in">
										<label for="projectName{{$index}}">{{project.name}}</label>
									</div>
									<div>
										<p style="color: red">{{projectError}}</p>
									</div>
								</div>
							</div> -->



							<div class="" id="details_inventory">

								<label for="pwd">Projects:</label> <br>

								<div class="new-check-button1">
									<input type="checkbox" id="chekallpro" class="filled-in"
										data-ng-click="checkall_pro(checkall_project)"
										data-ng-model="checkall_project"><label
										for="chekallpro">Select all</label>

									<div data-ng-repeat="project in projectList">


										<input type="checkbox" name="projectName"
											id="projectName{{$index}}"
											data-ng-model="projectList[$index].selected"
											data-ng-change="add_pro(project,projectList[$index].selected)"
											class="filled-in"> <label for="projectName{{$index}}">{{project.name}}</label>

									</div>

									<div>

										<p style="color: red">{{projectError}}</p>

									</div>

								</div>

							</div>

						</div>

						<div class="col-md-3" id="details_inventory_warehouse"
							data-ng-show="reportDto.reportMenu =='INVENTORY DETAILS' || reportDto.reportMenu == 'INVENTORY SCRAP' || reportDto.reportMenu == 'INVENTORY REQUESTS' || reportDto.reportMenu == 'INVENTORY SERVICE' || reportDto.reportMenu == 'INVENTORY INWARDS' || reportDto.reportMenu == 'INVENTORY OUTWARDS'">



							<!-- <div class=""
								data-ng-show="reportDto.reportMenu =='INVENTORY DETAILS' || reportDto.reportMenu == 'INVENTORY SCRAP' || reportDto.reportMenu == 'INVENTORY REQUESTS' || reportDto.reportMenu == 'INVENTORY SERVICE' || reportDto.reportMenu == 'INVENTORY INWORDS' || reportDto.reportMenu == 'INVENTORY OUTWORDS'">
								<label for="pwd">WAREHOUSE:</label>

								<div class="new-check-button1">

									<input type="checkbox" id="chekallwar" class="filled-in"
										data-ng-click="toggleAll_war()"
										data-ng-model="isAllSelected_war"><label
										for="chekallwar">Select all</label>


									<div data-ng-repeat="warehouse in wareHouseEntityList">
										<input type="checkbox" name="wareHouseName"
											id="wareHouseName{{$index}}"
											data-ng-model="wareHouseEntityList[$index].selected"
											data-ng-change="optionToggled_war()" class="filled-in">
										<label for="wareHouseName{{$index}}">{{warehouse.wareHouseName}}</label>
									</div>
									<div>
										<p style="color: red">{{wareHouseError}}</p>
									</div>
								</div>
							</div> -->

							<div class="">

								<label for="pwd">WAREHOUSE:</label>


								<div class="new-check-button1">
									<input type="checkbox" id="chekallwar" class="filled-in"
										data-ng-click="checkall_war(checkall_warehouse)"
										data-ng-model="checkall_warehouse"><label
										for="chekallwar">Select all</label>

									<div data-ng-repeat="warehouse in wareHouseEntityList">


										<input type="checkbox" name="wareHouseName"
											id="wareHouseName{{$index}}"
											data-ng-model="wareHouseEntityList[$index].selected"
											data-ng-change="add_war(warehouse,wareHouseEntityList[$index].selected)"
											class="filled-in"> <label
											for="wareHouseName{{$index}}">{{warehouse.wareHouseName}}</label>

									</div>



									<div>

										<p style="color: red">{{wareHouseError}}</p>

									</div>

								</div>

							</div>


						</div>

					</div>
				</div>




			</form>





			<div data-ng-if="stock_report_view">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions"
						id="InventoryEntrance_test"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Category Type</th>
								<th>Sub Category</th>
								<th>Quantity</th>
								<th>Model</th>
								<th>Asset No</th>
								<th>Site</th>
							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="inventoryManagementDto in reportDtoList">
								<td>{{inventoryManagementDto.categoryType}}</td>
								<td>{{inventoryManagementDto.subCategory}}</td>
								<td>{{inventoryManagementDto.availableQuantity}}</td>
								<td>{{inventoryManagementDto.modelCode}}</td>
								<td>{{inventoryManagementDto.inventoryNumber}}</td>
								<td>{{inventoryManagementDto.assignedLocation}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>

			<!-------------- TABLE FOR SCRAP REPORT ------------------>

			<div data-ng-if="scrap_view">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions" id="scrappp"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Category Type</th>
								<th>Category Code</th>
								<th>Sub Category Name</th>
								<th>Quantity</th>
								<th>Model</th>
								<th>Move from</th>
								<th>Asset no</th>
								<th>Date Of Scrapping</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="ScrapDto in reportDtoList">
								<td>{{ScrapDto.category.categoryType}}</td>
								<td>{{ScrapDto.category.categoryCode}}</td>
								<td>{{ScrapDto.subCategory.subCategory}}</td>
								<td>{{ScrapDto.quantity}}</td>
								<td>{{ScrapDto.subCategory.model}}</td>
								<td>{{ScrapDto.fromLocation}}</td>
								<td>{{ScrapDto.inventoryNumber}}</td>
								<td>{{ScrapDto.lastModifiedDate}}</td>
								<td>{{ScrapDto.status}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>


			<div data-ng-if="tools_Request_view">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Category Type</th>
								<th>Sub Category</th>
								<th>Model</th>
								<th>Request From</th>
								<th>Request To</th>
								<th>Quantity</th>
								<th>Status</th>
								<th>Requested By</th>
								<th>Responsed By</th>


							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="inventoryRequestDto in reportDtoList">
								<td>{{inventoryRequestDto.category}}</td>
								<td>{{inventoryRequestDto.subCategory}}</td>
								<td>{{inventoryRequestDto.modelCode}}</td>
								<td>{{inventoryRequestDto.requestedFrom}}</td>
								<td>{{inventoryRequestDto.requestedTo}}</td>
								<td>{{inventoryRequestDto.quantity}}</td>
								<td>{{inventoryRequestDto.status}}</td>
								<td>{{inventoryRequestDto.raisedBy}}</td>
								<td>{{inventoryRequestDto.actionBy}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>



			<!----------- TABLE FOR SERVICE REPORT ------------->

			<div data-ng-show="Inventory_Service">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Category Type</th>
								<th>Sub Category</th>
								<th>Model</th>
								<th>Requested By</th>
								<th>Move from</th>
								<th>Asset no</th>
								<th>Inspected By</th>
								<th>Quantity</th>
								<th>Request Date</th>
								<th>Received Date</th>
							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="inventoryRequestDto in reportDtoList">
								<td>{{inventoryRequestDto.category}}</td>
								<td>{{inventoryRequestDto.subCategory}}</td>
								<td>{{inventoryRequestDto.modelCode}}</td>
								<td>{{inventoryRequestDto.createdBy}}</td>
								<td>{{inventoryRequestDto.fromLocation}}</td>
								<td>{{inventoryRequestDto.inventoryNumber}}</td>
								<td>{{inventoryRequestDto.lastModified}}</td>
								<td>{{inventoryRequestDto.quantity}}</td>
								<td>{{inventoryRequestDto.creationDate}}</td>
								<td>{{inventoryRequestDto.lastModifiedDate}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>

			<!---------- ELCB MANAGEMENT REPORT-------->



			<div data-ng-if="ELCB">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Date</th>
								<th>Project Name</th>
								<th>UpDated By</th>
								<th>UpDated Time</th>



							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="elcp_details in reportDtoList">
								<td>{{elcp_details.date}}</td>
								<td>{{elcp_details.projectName}}</td>
								<td>{{elcp_details.upDatedBy}}</td>
								<td>{{elcp_details.upDatedTime}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>
			<!-- WORKS MEN DETALIS REPORT -->

			<div data-ng-if="Workmen_details">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Category Name</th>
								<th>Project</th>
								<th>Resource Count</th>
								<th>Creation Date</th>



							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="worksmen_details in reportDtoList">
								<td>{{worksmen_details.worksMenCategory}}</td>
								<td>{{worksmen_details.projectName}}</td>
								<td>{{worksmen_details.resourceCount}}</td>
								<td>{{worksmen_details.creationDate}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>





			<!-- Row -->

			<!-- ======================for invetory inwords======================================== -->


			<div data-ng-if="inventory_inwords_view">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Category</th>
								<th>Sub Category</th>
								<th>Quantity</th>
								<th>Model</th>
								<th>Reference No</th>
								<th>Send</th>
								<th>Received</th>

								<th>Purpose</th>

							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="inventoryManagementDto in reportDtoList">
								<td>{{inventoryManagementDto.categoryType}}</td>
								<td>{{inventoryManagementDto.subCategory}}</td>
								<td>{{inventoryManagementDto.quantity}}</td>
								<td>{{inventoryManagementDto.modelCode}}</td>
								<td>{{inventoryManagementDto.referenceNo}}</td>
								<td>{{inventoryManagementDto.requestedFrom}}</td>
								<td>{{inventoryManagementDto.requestedTo}}</td>
								<td>{{inventoryManagementDto.purpose}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>

			<!-- ======================for invetory outwords======================================== -->


			<div data-ng-if="inventory_outwords_view">

				<div class="table-responsive" data-ng-if="reportDtoList.length > 0">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>CategoryType</th>
								<th>Sub category</th>
								<th>Quantity</th>
								<th>Model</th>
								<th>Reference No</th>
								<th>Send</th>
								<th>Received</th>
								<th>Purpose</th>

							</tr>
						</thead>
						<tbody>

							<tr data-ng-repeat="inventoryManagementDto in reportDtoList">
								<td>{{inventoryManagementDto.categoryType}}</td>
								<td>{{inventoryManagementDto.subCategory}}</td>
								<td>{{inventoryManagementDto.quantity}}</td>
								<td>{{inventoryManagementDto.modelCode}}</td>
								<td>{{inventoryManagementDto.referenceNo}}</td>
								<td>{{inventoryManagementDto.requestedFrom}}</td>
								<td>{{inventoryManagementDto.requestedTo}}</td>
								<td>{{inventoryManagementDto.purpose}}</td>
							</tr>



						</tbody>
					</table>
				</div>


			</div>


			<div class="text-center" data-ng-if="reportDtoList.length == 0 && searchStatus">
				<br> <br> <strong><b>{{alertMsg}}</b></strong>
			</div>
			<!-- ============================================================== -->


		</div>
	</div>
</div>


<jsp:include page="footer.jsp" />

