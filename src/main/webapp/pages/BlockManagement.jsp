
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
	data-ng-controller="BlockManagementController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">WAREHOUSE BLOCK</h3>
		</div>

		<div class="col-md-7 align-self-center">

			<div data-ng-show="BlockMgt">
				<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
					<ol class="breadcrumb">
						<li><a class="btn btn-primary waves-effect waves-light"
							href="officeAdmin?link=AddBlock">ADD WAREHOUSE BLOCK</a></li>
					</ol>
				</security:authorize>
			</div>


		</div>

	</div>
	<!-- ============================================================== -->
	<!-- End Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Start Page Content -->
	<!-- ============================================================== -->


	<div data-ng-if="BlockMgt">


		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">SEARCH WAREHOUSE BLOCK</h4>

				<div class="table-responsive">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered ">
						<thead>
							<tr>
								<th>WareHouse</th>
								<th>Block</th>
								<th>model</th>
								<th>Status</th>
								<th class="not-export-col">Action</th>

							</tr>
						</thead>
						<tbody>


<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
							<tr data-ng-repeat="block_details in test">
								<td>{{block_details.wareHouseName}}</td>
								
								<td>{{block_details.blockNames}}</td>
								<td>{{block_details.code}}</td>
								<td>{{block_details.status}}</td>
								<!-- 
								<td>{{block_details.wareHouseBlocksDto[0].blocksNames}}</td>
								<td>{{block_details.wareHouseBlocksDto[0].code}}</td>
								<td>{{block_details.wareHouseBlocksDto[0].status}}</td> -->

								<td class="table_btn_group"><security:authorize
										access="hasAuthority('OFFICE ADMINISTRATOR')">
										<a href="" data-ng-click="edit(block_details)"
											class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a>
									</security:authorize> <a href="" data-ng-click="view(block_details)"
									class="btn btn-primary"><i class="fa fa-drivers-license-o"></i>
										View</a></td>

							</tr>
</security:authorize>	


	<security:authorize access="hasAuthority('ENQUIRY')">
							<tr data-ng-repeat="block_details in test"								>
								<td>{{block_details.wareHouseName}}</td>
								<td>{{block_details.blockNames}}</td>
								<td>{{block_details.code}}</td>
								<td>{{block_details.status}}</td>

								<td class="table_btn_group"><security:authorize
										access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
										<a href="" data-ng-click="edit(block_details)"
											class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a>
									</security:authorize> <a href="" data-ng-click="view1(block_details)"
									class="btn btn-primary"><i class="fa fa-drivers-license-o"></i>
										View</a></td>

							</tr>
</security:authorize>							

						</tbody>
					</table>
				</div>

				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Block Details</h4>
							</div>
							<div class="modal-body">
								<table class="table table-bordered table-striped">
									<tr>
										<th>Block Name</th>
										<td>{{blockManagementDetails.blockNames}}</td>
									</tr>
									<tr>
										<th>model</th>
										<td>{{blockManagementDetails.code}}</td>
									</tr>
									<tr>
										<th>status</th>
										<td>{{blockManagementDetails.status}}</td>
									</tr>
								</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				
				
				
				
								<!-- Modal -->
				<div class="modal fade" id="myModal1" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Block Details</h4>
							</div>
							<div class="modal-body">
								<table class="table table-bordered table-striped">
									<tr>
										<th>Block Name</th>
										<td>{{blockManagementDetails.blockNames}}</td>
									</tr>
									<tr>
										<th>model</th>
										<td>{{blockManagementDetails.code}}</td>
									</tr>
									<tr>
										<th>status</th>
										<td>{{blockManagementDetails.status}}</td>
									</tr>
								</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>






	<div data-ng-show="editBlock">


		<div class="form_section">
			<div class="form-content create_form">
				<h4 class="form_content_title">Edit Block Management</h4>
				<form class="form-inline" method="post" name="addBlock" novalidate>
					<div class="col-md-6 col_md text-center">
						<div class="add_icon_asterisk">
							<label for="email">WareHouse</label>


							<div class="new-select-option">
								<select name="wareHouseName" id="wareHouseName"
									data-ng-model="blockDto.wareHouseDto.wareHouseName" required
									class="select2 form-control" tabindex="1"
									style="width: 100%; height: 36px;">
									<option></option>
									<option
										data-ng-repeat="x in wareHouseDtoList track by x.wareHouseName"
										value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>

								</select> <i class="fa fa-asterisk"></i>
							</div>


							<!-- 																						<input -->
							<!-- 											list="wareHouse" class="form-control"  -->
							<!-- 											id="wareHouse_List" placeholder="" data-ng-readonly="datareadonly" name="wareHouseName" required -->
							<!-- 											data-ng-model="blockDto.wareHouseDto.wareHouseName" autocomplete="off" tabindex="1"> -->
							<!-- 											<i class="fa fa-asterisk" ></i> -->
							<!-- 										<datalist id="wareHouse"> -->
							<!-- 											<option -->
							<!-- 												data-ng-repeat="x in activeWareHouseList track by x.wareHouseName" -->
							<!-- 												value="{{x.wareHouseName}}">{{x.wareHouseName}}</option> -->
							<!-- 										</datalist> -->


						</div>

						<div
							data-ng-show="addBlock.$submitted || addBlock.wareHouseName.$touched"
							class="error_msg">
							<div data-ng-show="addBlock.wareHouseName.$error.required"
								class="error_msg">Please Select WareHouse</div>
						</div>


						<div class="add_icon_asterisk">
							<label for="pwd"> Block Name:</label> <input type="text"
								class="form-control" id="blocksNames" name="blocksNames" allowspacealphanum
								data-ng-model="blockDto.blocksNames" required autocomplete="off"
								tabindex="2"> <i class="fa fa-asterisk"></i> <input
								type="hidden" class="form-control" id="id" name="id"
								data-ng-model="blockDto.id" required>
						</div>

						<div
							data-ng-show="addBlock.$submitted || addBlock.blocksNames.$touched"
							class="error_msg">
							<div data-ng-show="addBlock.blocksNames.$error.required"
								class="error_msg">Enter Block Name</div>
						</div>

						<div class="add_icon_asterisk">
							<label for="pwd"> Block Code:</label> <input type="text"
								class="form-control" id="code" name="code" alphamumeric
								data-ng-model="blockDto.code" required autocomplete="off"
								tabindex="3" maxlength="3"> <i class="fa fa-asterisk"></i>
						</div>

						<div data-ng-show="addBlock.$submitted || addBlock.code.$touched"
							class="error_msg">
							<div data-ng-show="addBlock.code.$error.required"
								class="error_msg">Enter Block Code</div>
						</div>

						<div class="add_icon_asterisk">
							<label for="">Status:</label>


							<div class="new-radio-button-inline">
								<input type="radio" name="status" id="ACTIVE" value="ACTIVE"
									required data-ng-model="blockDto.status" class="with-gap"
									autocomplete="off" tabindex="4"> <label for="ACTIVE">ACTIVE</label>
								<input type="radio" name="status" id="INACTIVE" value="INACTIVE"
									required data-ng-model="blockDto.status" class="with-gap"
									autocomplete="off" tabindex="5"> <label for="INACTIVE">INACTIVE</label>
							</div>
						<i class="fa fa-asterisk" ></i>

						</div>

						<div
							data-ng-show="addBlock.$submitted || addBlock.status.$touched"
							class="error_msg">
							<div data-ng-show="addBlock.status.$error.required"
								class="error_msg">Please Select Status</div>
						</div>

					</div>
					<div class="col-12 submit_col text-center">
						<button class="btn btn-primary" data-ng-click="saveBlock()">
							<i class="fa fa-check"></i> SAVE
						</button>
						<button class="btn btn-warning" data-ng-click="cancel()">
							<i class="fa fa-close"></i> CANCEL
						</button>
					</div>
				</form>
			</div>
		</div>



	</div>









</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />