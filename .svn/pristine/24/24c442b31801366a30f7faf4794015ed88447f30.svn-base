
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
	data-ng-controller="viewMyProfileController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center"></div>


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
			<h4 class="form_content_title">My Profile</h4>
			<form class="form-inline" method="post" name="editProfile"
				id="editProfile" novalidate>



				<div class="col-md-12 col_md">

					<table class="table table-bordered">
						<tr>
							<th width="20%">UserName</th>
							<td><input type="text" data-ng-model="userDto.userName"
								class="form-control" readonly></td>
						</tr>
						<tr>
							<th>Designation</th>
							<td><input type="text" data-ng-model="userDto.designation"
								class="form-control" readonly></td>
						</tr>
						<tr>
							<th>Mobile Number</th>
							<td><input type="text" data-ng-model="userDto.mobileNumber"
								name="mobileno" class="form-control" mobileno maxlength="10"
								required data-ng-readonly="true">

								<div style="font-size: 16px; font-weight: normal;"
									data-ng-show="editProfile.$submitted || editProfile.mobileno.$touched"
									class="error_msg">
									<span data-ng-show="editProfile.mobileno.$error.required"
										class="error_msg">Please Enter Mobile Number</span>
									<div data-ng-show="userDto.mobileNumber.toString().length<10">Please
										enter Valid 10 digit Mobile Number</div>
								</div></td>
						</tr>
						<tr>
							<th>E-Mail Id</th>
							<td><input type="email" data-ng-model="userDto.emailId"
								name="emailId" class="form-control" required
								data-ng-readonly="true">


								<div
									data-ng-show="editProfile.$submitted || editProfile.emailId.$touched"
									class="error_msg">
									<div data-ng-show="editProfile.emailId.$error.required"
										class="error_msg">Please enter E-mailid</div>
									<span class="err"
										data-ng-show="editProfile.emailId.$error.email"> Not a
										valid Email </span>

								</div></td>
						</tr>
						<tr>
							<th>Roles</th>
							<td style="font-size: 16px; font-weight: normal;"><ul>
									<li data-ng-repeat="role in userDto.Roles">{{role.roleName}}</li>
								</ul></td>
						</tr>

						<security:authorize
							access="hasAuthority('USER') OR hasAuthority('SUPER USER') OR hasAuthority('SAFETY ENGINEER') OR hasAuthority('ENQUIRY')">

							<tr>
								<th>Projects</th>
								<td style="font-size: 16px; font-weight: normal;"><ul>
										<li data-ng-repeat="project in userProject">{{project.name}}</li>
									</ul></td>
							</tr>

						</security:authorize>

						<security:authorize
							access="hasAuthority('WAREHOUSE ADMINISTRATOR')">

							<tr>
								<th>WareHouse</th>
								<td style="font-size: 16px; font-weight: normal;"><ul>
										<li data-ng-repeat="project in wareHouseProject">{{project.wareHouseName}}</li>
									</ul></td>
							</tr>

						</security:authorize>

						<tr>
							<th>Secret Question</th>
							<td>
								<!-- 					 <select class="selectpicker" data-style="form-control "> -->
								<!-- 									<option ng-repeat="x in secretQuestionList" value="{{x.secretQuestion}}">{{x.secretQuestion}}</option> -->
								<!--                      </select> --> <select
								name="secretquestion" class="form-control"
								data-ng-model="userDto.secretQuestion" required
								data-ng-disabled="readOnlyStatus"
								data-ng-change="showans(userDto.secretQuestion)">

									<option value="">-- Select Secret Question ---</option>
									<option data-ng-repeat="x in secretQuestionList"
										value="{{x.secretQuestion}}">{{x.secretQuestion}}</option>

							</select>
								<div style="color: red"
									data-ng-show="editProfile.$submitted || editProfile.secretquestion.$touched"
									class="error_msg">
									<span data-ng-show="editProfile.secretquestion.$error.required"
										class="error_msg">Please Select Secret Question</span>
								</div>

							</td>
						</tr>


						<tr data-ng-show="secretans==true">
							<th>Secret Answer</th>
							<td><input type="text" class="normalstring"
								name="secretanswer" data-ng-model="userDto.secretAnswer"
								required data-ng-readonly="readOnlyStatus"
								style="font-size: 1rem;">


								<div style="color: red"
									data-ng-show="editProfile.$submitted || editProfile.secretanswer.$touched"
									class="error_msg">
									<span data-ng-show="editProfile.secretanswer.$error.required"
										class="error_msg">Please Enter Secret Answer</span>
								</div></td>
						</tr>


					</table>

				</div>

				<div class="col-12 submit_col text-center">
					<span class="btn btn-primary" data-ng-click="MakeEditable()"><i
						class="fa fa-pencil-square-o"></i> Update Profile</span>
					<button class="btn btn-primary"
						data-ng-click="EditProfile(userDto)">
						<i class="fa fa-pencil-square-o"></i>Save
					</button>
					<span class="btn btn-warning" id="cancelUser"
						data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
				</div>
			</form>
		</div>




	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />