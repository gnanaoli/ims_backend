
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
	data-ng-controller="userManagementController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">USER MANAGEMENT</h3>
		</div>


		<div class="col-md-7 align-self-center">
			<div data-ng-show="viewuser">
				<ol class="breadcrumb">
					<a class="btn btn-primary waves-effect waves-light"
						href="officeAdmin?link=NewUser"><i class="fa fa-user-plus"></i> New User</a>
				</ol>
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

	<div data-ng-show="viewuser">

		<div class="form_section">
			<div class="form-content">
				<h4 class="form_content_title">Search User</h4>
				<div class="table-responsive">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered">
						<thead class="">
							<tr>
								<th>User Name</th>
								<th>Designation</th>
								<th>Mobile No</th>
								<th>Email ID</th>
								<th>Role</th>
								<th>ACTION</th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="user in userManagementDtoList">
								<td>{{user.userName}}</td>
								<td>{{user.designation}}</td>
								<td>{{user.mobileNumber}}</td>
								<td>{{user.emailId}}</td>
								<td>{{user.role}}</td>
								<td class="btn-group"><a href="" class="btn btn-primary"
									data-ng-click="editUser(user)"><i class="fa fa-edit"> </i>Edit</a>
									<a href="" data-ng-click="view(user)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>

	</div>

	<div data-ng-show="selected">
		<div class="content_row">
			<div class="col-12 text-center mt-1"></div>
			<div class="form_section">
				<div class="form-content create_form">
					<h4 class="form_content_title">EDIT User</h4>
					<form class="form-inline" method="post" name="NewUser" id="NewUser" novalidate>
						<div class="col-md-6 col_md text-center">
							<div class="">
								<label for="email">User Name:</label> <input type="text"
									class="form-control" id="userName" name="userName"
									data-ng-model="userDto.userName" readonly>
							</div>
							<div>
								<label for="pwd">Role Type</label> <select
									data-ng-model="userDto.roleType" class="form-control"
									data-ng-change="removeProjectAndWareHouseCheck(userDto.roleType)">
									<option data-ng-repeat="x in testRoleList"
										value="{{x.roleName}}">{{x.roleName}}</option>
								</select>
							</div>
						</div>
						<div class="col-md-6 col_md text-center">

							<div class="" data-ng-if="userDto.roleType=='OTHERS'">
								<div class="">
									<label for="pwd">projects:</label>
									<div class="new-check-button">
										<div data-ng-repeat="project in projectList">
											<input type="checkbox" name="projectName"
												id="projectName{{$index}}"
												data-ng-model="projectList[$index].selected"
												data-ng-checked="{{projectList[$index].selected}}"
												class="filled-in"> <label
												for="projectName{{$index}}">{{project.name}}</label>
										</div>
										<div>
											<p style="color: red">{{projectError}}</p>
										</div>
									</div>
								</div>

								<div class="">
									<label for="email">Roles:</label>

									<div class="new-check-button">
										<div data-ng-repeat="role in userEditRoleEntityList">
											<input type="checkbox" id="roleName{{role.id}}"
												data-ng-model="userEditRoleEntityList[$index].selected"
												name="roleName"
												data-ng-checked="{{userEditRoleEntityList[$index].selected}}"
												class="filled-in"> <label for="roleName{{role.id}}">{{role.roleName}}</label>
										</div>
										<div>
											<p style="color: red">{{roleError}}</p>
										</div>
									</div>
								</div>

							</div>

							<div class=""
								data-ng-if="userDto.roleType=='WAREHOUSE ADMINISTRATOR'">
								<label for="pwd">WAREHOUSE:</label>


								<div class="new-check-button">
									<div data-ng-repeat="warehouse in wareHouseDtoList">
										<input type="checkbox" name="wareHouseName"
											id="wareHouseName{{$index}}"
											data-ng-model="wareHouseDtoList[$index].selected"
											class="filled-in"> <label
											for="wareHouseName{{$index}}">{{warehouse.wareHouseName}}</label>
									</div>
									<div>
										<p style="color: red">{{wareHouseError}}</p>
									</div>
								</div>
							</div>
						</div>

						<div class="col-12 submit_col text-center">
                              <button class="btn btn-primary"
								data-ng-click="saveUser($event,NewUser)"><i class="fa fa-check"></i> SAVE</button>
							<button class="btn btn-warning" id="cancelUser"
								data-ng-click="back()"><i class="fa fa-close"></i> CANCEL</button>
						</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	
	  <!-- Modal for view -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">User Details</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>User Name </th><td>{{view_user_details.userName}}</td></tr>
							<tr><th>Role</th><td>{{view_user_details.role}}</td></tr>
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

