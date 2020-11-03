

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
	data-ng-controller="WorksmenManagementController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">WORKSMEN</h3>
		</div>

		<div class="col-md-7 align-self-center">

			<div data-ng-show="WorkmenMgt">

<security:authorize access="hasAuthority('SAFETY ENGINEER')">
				<ol class="breadcrumb">
					<li><a class="btn btn-primary waves-effect waves-light"
						href="common?link=AddWorksMen">Add Worksmen</a></li>
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
	<!-- Row -->


	<div data-ng-show="WorkmenMgt">


		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Search Worksmen</h4>


				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
						<th>Date</th>
							<th>Category Name</th>
							<th>Project</th>
							<th>Resource Count</th>
							<th class="not-export-col">Action</th>

						</tr>
					</thead>
					<tbody>

						<tr data-ng-repeat="worksmen_details in WokrsmenDtoMaster">
						<td>{{worksmen_details.date}}</td>
							<td>{{worksmen_details.worksMenCategoryDto1.category}}</td>
							<td>{{worksmen_details.projectDto1.name}}</td>
							<td>{{worksmen_details.resourceCount}}</td>

							<td class="table_btn_group">
							
<%-- 							<security:authorize access="hasAuthority('SAFETY ENGINEER')"> --%>
<!-- 							<span data-ng-if="(worksmen_details.date == todayDate)"><a -->
<!-- 									href="" data-ng-click="edit(worksmen_details)" -->
<!-- 									class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a></span>  -->
<%-- 							</security:authorize> --%>

								<a href="" data-ng-click="view(worksmen_details)"
								class="btn btn-primary"><i class="fa fa-drivers-license-o"></i>
									View</a></td>
						</tr>

					</tbody>
				</table>

			</div>
		</div>
	</div>






	<div data-ng-show="editWorksmen">


		<div class="form_section">
			<div class="form-content create_form">
				<h4 class="form_content_title">Edit WorksMen Details</h4>
				<form class="form-inline" method="post" name="addWorksmen"
					novalidate>
					<div class="col-md-6 col_md text-center">




						<div class="add_icon_asterisk">
							<label for="email">Date</label>
							<div class="input-group date" data-date-format="dd/mm/yyyy"
								data-date-end-date="0d" data-date-start-date="0d" data-date-today-highlight="true"
								data-date-autoclose="true" data-provide="datepicker">
								<div class="input-group-addon inner-addon right-addon ">
									<i class="fa fa-calendar"></i> <input type="text"
										class="form-control" placeholder="" id="date" name="date"
										data-ng-model="WorksmenDto.date" readonly required  autocomplete="off" tabindex="1">
								</div>
							</div>
							<i class="fa fa-asterisk"></i>
						</div>

						<div
							data-ng-show="addWorksmen.$submitted || addWorksmen.date.$touched"
							class="error_msg">
							<div data-ng-show="addWorksmen.date.$error.required"
								class="error_msg">Please Select Date</div>
						</div>

						<div class="add_icon_asterisk">
							<label for="email">Project Name</label> 
							<div class="new-select-option">
								<select name="name" id="name"
									data-ng-model="WorksmenDto.projectDto1.name"
									required class="select2 form-control"
									style="width: 100%; height: 36px;">
									<option></option>
									<option
										data-ng-repeat="x in projectMasterDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>
								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
							
<!-- 							<input list="project" -->
<!-- 								class="form-control" id="project_List" placeholder="" -->
<!-- 								 required name="name" -->
<!-- 								data-ng-model="WorksmenDto.projectDto.name"  autocomplete="off" tabindex="2"> -->
<!-- 							<i class="fa fa-asterisk"></i> -->
<!-- 							<datalist id="project"> -->
<!-- 								<option -->
<!-- 									data-ng-repeat="x in projectMasterDtoList track by x.name" -->
<!-- 									value="{{x.name}}">{{x.name}}</option> -->
<!-- 							</datalist> -->
						</div>

						<div
							data-ng-show="addWorksmen.$submitted || addWorksmen.name.$touched"
							class="error_msg">
							<div data-ng-show="addWorksmen.name.$error.required"
								class="error_msg">Please Select Project</div>
						</div>


						<div class="add_icon_asterisk">
							<label for="pwd">WorksMen Category:</label> 
							

							<div class="new-select-option">
								<select name="category" id="category"
									data-ng-model="WorksmenDto.worksMenCategoryDto1.category"
									required class="select2 form-control"
									style="width: 100%; height: 36px;">
									<option></option>
									<option
										data-ng-repeat="x in WokrsMenCategoryMaster"
										value="{{x.category}}">{{x.category}}</option>
								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
							
<!-- 							<input -->
<!-- 								list="worksmen_category" class="form-control" id="project_List" -->
<!-- 								placeholder="" data-ng-readonly="datareadonly" required -->
<!-- 								name="category" -->
<!-- 								data-ng-model="WorksmenDto.worksMenCategoryDto.category" -->
<!-- 								 autocomplete="off" tabindex="3"> <i class="fa fa-asterisk"></i> -->
<!-- 							<datalist id="worksmen_category"> -->
<!-- 								<option data-ng-repeat="x in WokrsMenCategoryMaster" -->
<!-- 									value="{{x.category}}">{{x.category}}</option> -->
<!-- 							</datalist> -->

						</div>

						<div
							data-ng-show="addWorksmen.$submitted || addWorksmen.category.$touched"
							class="error_msg">
							<div data-ng-show="addWorksmen.category.$error.required"
								class="error_msg">Please Select Worksmen Category</div>
						</div>

						<div class="">
							<label for="pwd"> Resource Count:</label> <input type="text"
								class="form-control" id="resourceCount" name="resourceCount"
								data-ng-model="WorksmenDto.resourceCount" required numbersonly data-ng-change="validate()"> <input
								type="hidden" class="form-control" id="id" name="id"
								data-ng-model="WorksmenDto.id"  autocomplete="off" tabindex="4">
						</div>

						<div
							data-ng-show="addWorksmen.$submitted || addWorksmen.resourceCount.$touched"
							class="error_msg">
							<div data-ng-show="addWorksmen.resourceCount.$error.required"
								class="error_msg">Please Enter ResourceCount</div>
						</div>

						<div class="">
							<label for="pwd">Comments:</label> <input type="text"
								class="form-control" id="comments" name="comments"
								data-ng-model="WorksmenDto.comments"  autocomplete="off" tabindex="5">
						</div>

						<div
							data-ng-show="addWorksmen.$submitted || addWorksmen.comments.$touched"
							class="error_msg">
							<div data-ng-show="addWorksmen.comments.$error.required"
								class="error_msg">Please Enter Comments</div>
						</div>

					</div>
					<div class="col-12 submit_col text-center">
						<button class="btn btn-primary" data-ng-click="updateSaveWorksmen()">
							<i class="fa fa-check"></i> SAVE
						</button>
						<span class="btn btn-warning" data-ng-click="cancel()">
							<i class="fa fa-close"></i> CANCEL
						</span>
					</div>
				</form>
			</div>
		</div>



	</div>



	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">WorksMenCategory</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered table-striped">
						<tr>
							<th>Category</th>
							<td>{{view_worksmen_details.worksMenCategoryDto1.category}}</td>
						</tr>
						<tr>
							<th>Project</th>
							<td>{{view_worksmen_details.projectDto1.name}}</td>
						</tr>
						<tr>
							<th>Resource Count</th>
							<td>{{view_worksmen_details.resourceCount}}</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>





</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />