
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
	data-ng-controller="EditUserController">
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
					<li><a class="btn btn-primary waves-effect waves-light"
						href="officeAdmin?link=NewUser"><i class="fa fa-user-plus"></i> New User</a></li>
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
								<th>Employee Id</th>
								<th class="not-export-col">ACTION</th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="user in userManagementDtoList">
								<td>{{user.userName}}</td>
								<td>{{user.designation}}</td>
								<td>{{user.mobileNumber}}</td>
								<td>{{user.emailId}}</td>
								<td>{{user.role}}</td>
								<td>{{user.empid}}</td>
								<td class="table_btn_group"><a href="" class="btn btn-primary"
									data-ng-click="editUser(user)"><i class="fa fa-edit"> </i> Edit</a>
									<a href="" data-ng-click="viewUser(user)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
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
			<form class="form-inline" name="NewUser" id="NewUser" novalidate>
			
			
			<div class="row">
			
				<div class="col-md-6 col_md text-center">
					<div class="">
						<label for="email">User Name</label> <input type="text"
							class="form-control" id="userName" name="userName"
							data-ng-model="userDto.userName" readonly required>
					</div>
					<div
						data-ng-show="NewUser.$submitted || NewUser.userName.$touched" class="error_msg">
						<div data-ng-show="NewUser.userName.$error.required" class="error_msg">Please
							Enter UserName</div>
					</div>
					<div class="">
						<label for="pwd">Role Type</label> <select
							data-ng-model="userDto.roleType" name="roleType"
							class="form-control"
							data-ng-change="removeProjectAndWareHouseCheck(userDto.roleType)"
							required>
							<option value="">--select--</option>
							<option data-ng-repeat="x in testRoleList" value="{{x.roleName}}">{{x.roleName}}</option>
						</select>
					</div>
					<div data-ng-show="NewUser.$submitted || NewUser.roleType.$touched" class="error_msg">
						<div data-ng-show="NewUser.roleType.$error.required" class="error_msg">Please
							choose roleType</div>
					</div>
					
					
					        <div class="">
                                    <label>reset password</label>
                                   <div class="new-radio-button-inline">
                                   <table style="border:none">
                                   <tr style="border:none">
										<td style="border:none"><input type="radio" data-ng-model="userDto.resetPassword" class="with-gap" name="RESET" id="RESET" value="RESET" data-ng-change="resetPassword(userDto.resetPassword)" >
										<label for="RESET" >RESET</label></td>
										</tr>
										</table>
			                      </div>
                                </div>
                    <span data-ng-show="viewResetPasword">
					<div class="">
					<label for="email">New Password text_tranform</label> <input type="text"
							class="normalstring" id="newPassword" name="newPassword"
							data-ng-model="userDto.newPassword"  data-ng-required="viewResetPasword">
					</div>
					<div
						data-ng-show="NewUser.$submitted || NewUser.newPassword.$touched" class="error_msg">
						<div data-ng-show="NewUser.newPassword.$error.required" class="error_msg">Please
							Enter new Password</div>
					</div>
					
					<div class="">
					<label for="email">Confirm Password </label> <input type="text"
							class="normalstring" id="confirmPassword" name="confirmPassword"
							data-ng-model="userDto.confirmPassword"  data-ng-required="viewResetPasword">
					</div>
					<div
						data-ng-show="NewUser.$submitted || NewUser.confirmPassword.$touched" class="error_msg">
						<div data-ng-show="NewUser.confirmPassword.$error.required" class="error_msg">Please
							Enter confirm Password</div>
						<div data-ng-show="userDto.newPassword.toString() != userDto.confirmPassword.toString()" class="error_msg">Password 
							Does not Match</div>	
					</div>
					</span>
					
					
				</div>

				<div class="col-md-6">
					<div class="" data-ng-if="userDto.roleType=='OTHERS'">
						<label for="pwd">Projects:</label>
						<div class="new-check-button">
							<div data-ng-repeat="project in projectList">
								<input type="checkbox" name="projectName"
									id="projectName{{$index}}"
									data-ng-model="projectList[$index].selected" class="filled-in">
								<label for="projectName{{$index}}">{{project.name}}</label>
							</div>
							 <div>
								<p style="color: red">{{projectError}}</p>
							</div> 
						</div>
					</div>
					<div class="" data-ng-if="userDto.roleType=='OTHERS'">
						<label for="pwd">Roles:</label>
						<div class="new-check-button">
							<div data-ng-repeat="role in roleList">
								<input type="checkbox" name="roleName" id="roleName{{$index}}"
									data-ng-model="roleList[$index].selected" class="filled-in">
								<label for="roleName{{$index}}">{{role.roleName}}</label>
							</div>
							<div>
								<p style="color: red">{{roleError}}</p>
							</div>
						</div>
					</div>
					<div class=""
						data-ng-if="userDto.roleType=='WAREHOUSE ADMINISTRATOR'">
						<label for="pwd">WAREHOUSE:</label>

						<div class="new-check-button">
							<div data-ng-repeat="warehouse in wareHouseEntityList">
								<input type="checkbox" name="wareHouseName"
									id="wareHouseName{{$index}}"
									data-ng-model="wareHouseEntityList[$index].selected"
									class="filled-in"> <label for="wareHouseName{{$index}}">{{warehouse.wareHouseName}}</label>
							</div>
							<div>
								<p style="color: red">{{wareHouseError}}</p>
							</div>
						</div>
					</div>
				</div>
				</div>
				<div class="col-12 submit_col text-center">
					<button class="btn btn-primary"
						data-ng-click="saveUser($event,NewUser)"><i class="fa fa-check"></i> SAVE</button>
					<button class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</button>
				</div>
			</form>
			</div>
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
         					<tr><th>User Name </th><td>{{userDetails.userName}}</td></tr>
							<tr><th>Role</th><td>{{userDetails.role}}</td></tr>
							<tr><th>Employee Id</th><td>{{userDetails.empid}}</td></tr>
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

