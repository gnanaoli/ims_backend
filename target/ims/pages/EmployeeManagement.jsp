
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
	data-ng-controller="employeeManagementController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">EMPLOYEE</h3>
		</div>


		<div class="col-md-7 align-self-center">
			<div data-ng-show="EmployeeListView">
				<ol class="breadcrumb">
				<li>
					<a class="btn btn-primary waves-effect waves-light"
						href="officeAdmin?link=NewEmployee"><i class="fa fa-user-plus"></i> New Employee</a>
				</li>
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

	<div>

		<div class="form_section" data-ng-show="EmployeeListView">
			<div class="form-content">
				<h4 class="form_content_title">Search Employee</h4>
				<div class="table-responsive">
					<table datatable="ng" dt-options="dtOptions"
						class="table table-striped table-bordered">
						<thead class="">
							<tr>
								<th>Name</th>
								<th>Designation</th>
								<th>Mobile No</th>
								<th>Email ID</th>
								<th>Employee ID</th>
								<th class="not-export-col">ACTION</th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="employee in employeeDtoList">
								<td>{{employee.firstName}}</td>
								<td>{{employee.designation}}</td>
								<td>{{employee.mobileNumber}}</td>
								<td>{{employee.emailId}}</td>
								<td>{{employee.employeeId}}</td>
								<td class="table_btn_group"><a href="" class="btn btn-primary"
									data-ng-click="editEmployee(employee)"><i class="fa fa-edit"> </i> Edit</a>
									<a href="" data-ng-click="viewEmployee(employee)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>



<div data-ng-if="EditView">
<div class="form_section">
                    <div class="form-content create_form">
                        <h4 class="form_content_title">Edit Employee</h4>
                        <form class="form-inline three_column_form" name="Employee" id="Employee" data-ng-submit="saveEmployee(Employee.$valid)" novalidate="novalidate">
                            <!-- form 1 -->
                            <div class="row">
                            <input type="hidden" class="form-control" id="id" name="id" data-ng-model="employeeDto.id"> 
                                <h3>Personal Information</h3>
                                <div class="three_column_form_column">
                                    <label>First Name</label>
                                   <input type="text"
							class="form-control" id="firstName" name="firstName" namespacewithdot
							data-ng-model="employeeDto.firstName" data-ng-readonly="empreadonly" required maxlength="20" tabindex="1"> 
							<i class="fa fa-asterisk" ></i>
                                <div
						data-ng-show="Employee.$submitted || Employee.firstName.$touched" class="error_msg1">
						<div data-ng-show="Employee.firstName.$error.required" class="error_msg1">Please
							Enter first Name</div>
					      </div>							                   
                                </div>

                                <div class="three_column_form_column">
                                    <label>Last Name</label>
                                    <input type="text"  class="form-control" id="lastName" name="lastName" data-ng-readonly="empreadonly" namespacewithdot
							data-ng-model="employeeDto.lastName" required maxlength="20" tabindex="2">
							<i class="fa fa-asterisk" ></i>
							<div data-ng-show="Employee.$submitted || Employee.lastName.$touched" class="error_msg1">
						<div data-ng-show="Employee.lastName.$error.required" class="error_msg1">Please
							Enter Last Name</div>
					    </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>gender</label>
                                   <div class="new-radio-button-inline">
                                   <table style="border:none">
                                   <tr style="border:none">
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.gender" data-ng-disabled="empreadonly" required class="with-gap" name="gender" id="MALE" value="MALE" tabindex="3">
										<label for="MALE" >MALE</label></td>
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.gender" data-ng-disabled="empreadonly"  required class="with-gap" name="gender" id="FEMALE" value="FEMALE" tabindex="4" >
										<label for="FEMALE">FEMALE</label></td>
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.gender"  data-ng-disabled="empreadonly" required class="with-gap" name="gender" id="TRANSGENDER" value="TRANSGENDER" tabindex="5">
										<label for="TRANSGENDER">TRANSGENDER</label></td>
										<td style="border:none"><i class="fa fa-asterisk" ></i> </td>
										</tr>
										</table>
										<div data-ng-show="Employee.$submitted || Employee.gender.$touched" class="error_msg_edit_emp">
						           <div data-ng-show="Employee.gender.$error.required" class="error_msg_edit_emp">Please choose gender</div>
					              </div>
			                      </div>
                                </div>
                                <div class="three_column_form_column">
                                   <label for="email">date Of Birth:</label>
					              <div class="input-group date" data-date-format="dd/mm/yyyy"  data-date-autoclose="true" data-provide="datepicker">
                                   <div class="input-group-addon inner-addon right-addon ">
                                   <i class="fa fa-calendar"></i>
                                   <input type="text" class="form-control" placeholder="" name="dateOfBirth" data-ng-readonly="empreadonly" data-ng-model="employeeDto.dateOfBirth" id="dateOfBirth"  data-ng-change="checkAge(employeeDto.dateOfBirth)"  readonly tabindex="6">
                                    </div>
                                  </div>
                                   <i class="fa fa-asterisk" ></i> 
                                </div>
                                 <div class="three_column_form_column">
                                    <label>Care Of</label>
                                   <div class="new-radio-button-inline">
                                   <table style="border:none">
                                   <tr style="border:none">
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.guardianName" data-ng-disabled="empreadonly"  required class="with-gap" name="guardianName" id="FATHER" value="FATHER"  data-ng-change="getGuardian(employeeDto.guardianName)"tabindex="7">
										<label for="FATHER" >FATHER</label></td>
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.guardianName" data-ng-disabled="empreadonly"   required class="with-gap" name="guardianName" id="HUSBAND" value="HUSBAND"  data-ng-change="getGuardian(employeeDto.guardianName)" tabindex="8">
										<label for="HUSBAND">HUSBAND</label></td>
										<td style="border:none">
										<i class="fa fa-asterisk" ></i> </td>
										</tr>
										</table>
										<div data-ng-show="Employee.$submitted || Employee.gender.$touched" class="error_msg1">
						           <div data-ng-show="Employee.gender.$error.required" class="error_msg1">Please choose guardian</div>
					              </div>
			                      </div>
                                </div>
                                <div class="three_column_form_column" data-ng-if="showFather">
                                    <label>Father Name</label>
                                     <input type="text" class="form-control" id="fatherName" name="fatherName"  data-ng-readonly="empreadonly" contactman data-ng-model="employeeDto.fatherName"    required maxlength="20" autocomplete="off" tabindex="9">
                                     <i class="fa fa-asterisk" ></i>
                                     <div data-ng-show="Employee.$submitted || Employee.fatherName.$touched" class="error_msg1">
						             <div data-ng-show="Employee.fatherName.$error.required" class="error_msg1">Please
							         Enter Father Name</div>
					                 </div>
                                </div>
                                
                                <div class="three_column_form_column" data-ng-if="showHusband">
                                    <label>Husband Name</label>
                                     <input type="text" class="form-control" id="husbandName" name="husbandName" data-ng-readonly="empreadonly" contactman data-ng-model="employeeDto.husbandName"   required maxlength="20" autocomplete="off">
                                     <i class="fa fa-asterisk" ></i>
                                     <div data-ng-show="Employee.$submitted || Employee.husbandName.$touched" class="error_msg1">
						             <div data-ng-show="Employee.husbandName.$error.required" class="error_msg1">Please
							         Enter Husband Name</div>
					                 </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label> Nationality</label>
                                    <input type="text" class="form-control" id="nationality" data-ng-readonly="empreadonly" name="nationality" data-ng-model="employeeDto.nationality" required data-ng-init="employeeDto.nationality='INDIAN'" readOnly="true">
                                </div>
                                
                                <div class="three_column_form_column">
                                    <label> Religion</label>
                                     <div class="new-select-option">
								<select name="religion" id="religion"
									data-ng-model="employeeDto.religion"
									required class="form-control" wb-select2
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">
							<option value="" selected></option> 
									<option
										data-ng-repeat="x in religionDtoList"
										value="{{x}}">{{x}}</option>
								</select>
							</div>
                                    <i class="fa fa-asterisk" ></i>
                                     <div data-ng-show="Employee.$submitted || Employee.religion.$touched" class="error_msg1">
						             <div data-ng-show="Employee.religion.$error.required" class="error_msg1">Please
							         choose Religion Name</div>
					                 </div>
                                </div>

                               <!--  <div class="three_column_form_column">
                                    <label> Marital Status</label>
                                    <div class="new-radio-button-inline">
                                   <table style="border:none">
                                   <tr style="border:none">
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.maritalStatus" required class="with-gap" name="maritalStatus" id="MARRIED" value="MARRIED" >
										<label for="MARRIED" >MARRIED</label></td>
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.maritalStatus"  required class="with-gap" name="maritalStatus" id="UNMARRIED" value="UNMARRIED" >
										<label for="UNMARRIED">UNMARRIED</label></td>
										<td style="border:none"><i class="fa fa-asterisk" ></i> </td>
										</tr>
										</table>
										<div data-ng-show="Employee.$submitted || Employee.maritalStatus.$touched" class="error_msg_edit_emp">
						           <div data-ng-show="Employee.maritalStatus.$error.required" class="error_msg_edit_emp">Please choose maritalStatus</div>
					              </div>
			                      </div>
                                </div> -->
                                
                                <div class="three_column_form_column">
                                    <label> Marital Status</label>
                                     <div class="new-select-option">
								<select name="maritalStatus" id="maritalStatus"
									data-ng-model="employeeDto.maritalStatus"
									required class="form-control" wb-select2
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">
							<option value="" selected></option> 
									<option
										data-ng-repeat="x in maritalStatusList"
										value="{{x}}">{{x}}</option>
								</select>
							</div>
                                    <i class="fa fa-asterisk" ></i>
                                     <div data-ng-show="Employee.$submitted || Employee.maritalStatus.$touched" class="error_msg1">
						             <div data-ng-show="Employee.maritalStatus.$error.required" class="error_msg1">Please
							         choose marital Status</div>
					                 </div>
                                </div>
                                
                                <!-- <div class="three_column_form_column">
                                    <label> Blood group</label>
                                   <input type="text" class="form-control" id="bloodGroup" name="bloodGroup" data-ng-pattern="regex" data-ng-model="employeeDto.bloodGroup" capitalize  maxlength="5">
                                    <i class="fa fa-asterisk" ></i>
                                   <div data-ng-show="Employee.$submitted || Employee.bloodGroup.$touched" class="error_msg_edit_emp">
						           <div data-ng-show="Employee.bloodGroup.$error.pattern" class="error_msg_edit_emp">Please Enter correct blood group</div>
					              </div>
                                </div> -->

                                  <div class="three_column_form_column">
                                    <label>Blood Group</label>
                                    
                                    <div class="new-select-option">
								<select name="bloodGroup" id="bloodGroup"
									data-ng-model="employeeDto.bloodGroup" wb-select2
									required class="form-control" 
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">
									<option value="" selected></option> 
									<option
										data-ng-repeat="x in bloodGroupDtoList"
										value="{{x}}">{{x}}</option>

								</select>
							</div>
							<i class="fa fa-asterisk" ></i>
										<div data-ng-show="Employee.$submitted ||Employee.bloodGroup.$touched" class="error_msg1">
						                <div data-ng-show="Employee.bloodGroup.$error.required" class="error_msg1">Please Select blood Group</div>
						                </div>
                                </div>


                            </div>
                            
                            <!-- form 3 -->
                            <div class="row">
                                <h3>Employment Information</h3>
                                <div class="three_column_form_column">
                                    <label>Department</label>
                                    
                                      <div class="new-select-option">
								<select name="department" id="department" wb-select2
									data-ng-model="employeeDto.department"
									required class="form-control"
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">
								 	<option value="" selected></option> 
									<option
										data-ng-repeat="x in departmentDtoList track by x.name" data-ng-if="x.status=='ACTIVE'"
										value="{{x.name}}">{{x.name}}</option>

								</select>
							</div>
						<div data-ng-show="Employee.$submitted || Employee.department.$touched" class="error_msg_edit_emp">
						<div data-ng-show="Employee.department.$error.required" class="error_msg_edit_emp">Please Enter Department</div>
					    </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Designation</label>
                                    
                                    <div class="new-select-option">
								<select name="designation" id="designation" wb-select2
									data-ng-model="employeeDto.designation"
									required class="form-control"
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">
									<option value="" selected></option> 
									<option
										data-ng-repeat="x in designationDtoList track by x.designation" data-ng-if="x.status=='ACTIVE'"
										value="{{x.designation}}">{{x.designation}}</option>

								</select>
							</div>
						<div data-ng-show="Employee.$submitted || Employee.designation.$touched" class="error_msg_edit_emp">
						<div data-ng-show="Employee.designation.$error.required" class="error_msg_edit_emp">Please Enter Designation</div>
					    </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label> Date of Join </label>
                                   <div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-date-end-date="0d" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" name="dateOfJoin" data-ng-readonly="empreadonly" data-ng-model="employeeDto.dateOfJoin" id="dateOfJoin"  readonly>
                                            </div>
                                             <div data-ng-show="Employee.$submitted || Employee.dateOfJoin.$touched" class="error_msg1">
						                    <div data-ng-show="Employee.dateOfJoin.$error.required" class="error_msg1">Please select Date of Join</div>
					                        </div>
                                        </div>
                                         <i class="fa fa-asterisk" ></i> 
                                </div>
                                <div class="three_column_form_column">
                                    <label> Confirmation Date </label>
                                   <div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-date-end-date="0d" data-provide="datepicker" >
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder=""  data-ng-readonly="empreadonly" name="confirmationDate" data-ng-model="employeeDto.confirmationDate" id="confirmationDate" data-ng-change="validateConfirmationDate()" readonly>
                                            </div>
                                        </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Company Mail Id</label>
                                   <input type="email" class="form-control" id="companyEmailId"  data-ng-readonly="empreadonly" name="companyEmailId"  maxlength="50"  data-ng-model="employeeDto.companyEmailId" required>
                                   <i class="fa fa-asterisk" ></i>
                                   <div data-ng-show="Employee.$submitted || Employee.companyEmailId.$touched" class="error_msg_edit_emp">
						           <div data-ng-show="Employee.companyEmailId.$error.required" class="error_msg_edit_emp">Please Enter Company Email Id</div>
						           <div data-ng-show="Employee.companyEmailId.$error.email" class="error_msg_edit_emp">Not a valid email</div>
					           </div>
                                </div>
                                <div class="three_column_form_column">
						         <label for="email">Employee Id:</label> 
						         <input type="text" class="form-control" id="employeeId" data-ng-readonly="empreadonly" alphamumeric name="employeeId" data-ng-model="employeeDto.employeeId" required>
						         <i class="fa fa-asterisk" ></i>
						         <div data-ng-show="Employee.$submitted || Employee.employeeId.$touched" class="error_msg_edit_emp">
						         <div data-ng-show="Employee.employeeId.$error.required" class="error_msg_edit_emp">Please Enter employee Id</div>
					             </div>
					          </div>
					          <div class="three_column_form_column">
                                    <label>Employee Status</label>
                                   <select data-ng-model="employeeDto.subStatus" data-ng-readonly="empreadonly" name="subStatus" class="form-control" required>
							        <option value="">--select--</option>
							        <option data-ng-repeat="x in employeeStatusList" value="{{x}}">{{x}}</option>
						           </select>
						           <i class="fa fa-asterisk" ></i>
						           <div data-ng-show="Employee.$submitted || Employee.subStatus.$touched" class="error_msg_edit_emp">
						           <div data-ng-show="Employee.subStatus.$error.required" class="error_msg_edit_emp">Please choose employee Status</div>
					               </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Employee Type</label>
                                   <div class="new-radio-button-inline">
                                   <table style="border:none">
                                   <tr style="border:none">
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.employeeType" data-ng-disabled="empreadonly" required class="with-gap" name="employeeType" id="ONROLL" value="ONROLL" >
										<label for="ONROLL" >ONROLL</label></td>
										<td style="border:none"><input type="radio" data-ng-model="employeeDto.employeeType" data-ng-disabled="empreadonly" required class="with-gap" name="employeeType" id="OFFROLL" value="OFFROLL">
										<label for="OFFROLL">OFFROLL</label></td>
										<td style="border:none"><i class="fa fa-asterisk" ></i> </td>
										</tr>
										</table>
										<div data-ng-show="Employee.$submitted || Employee.gender.$touched" class="error_msg1">
						           <div data-ng-show="Employee.employeeType.$error.required" class="error_msg1">Please choose Employee Type</div>
					              </div>
			                      </div>
                                </div>
                             </div>
                             
                             <!-- form 2 -->
                            <div class="row">
                                <h3>Proof Details</h3>
                                
                                
                                <div class="three_column_form_column">
                                <label>Proof</label>
                                                       <div class="new-select-option">
								<select name="proof" id="proof"
									data-ng-model="employeeDto.proof"  wb-select2
									data-ng-change="applyProofCondition(employeeDto.proof)"
									class="form-control"
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">

							<option value="" selected></option> 

									<option
										data-ng-repeat="x in idProofDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>
								</select>
								
							</div>
                                    <i class="fa fa-asterisk" ></i>
                                 
                         <div data-ng-show="Employee.$submitted || Employee.proof.$touched" class="error_msg1">
						<div data-ng-show="Employee.proof.$error.required" class="error_msg1">Please choose proof</div>
					    </div>
                                
                                
                                
                                </div>
                                
                                <div class="three_column_form_column">
                                
                                
                                
                                 <span data-ng-if="showaadhaar">
                                  <label>Aadhaar Number</label>
                                 <input type="text" name="aadhaarNumber" id="aadhaarNumber" data-ng-disabled="empreadonly"  data-ng-model="employeeDto.aadhaarNumber" data-ng-required="showaadhaar" nospecialchar numbersonly data-ng-minlength="12"  maxlength="12"  class="form-control">
                                 <i class="fa fa-asterisk" ></i>
                                  <div data-ng-if="Employee.$submitted || Employee.aadhaarNumber.$touched" class="error_msg1">
					                <div data-ng-if="Employee.aadhaarNumber.$error.minlength || !Employee.aadhaarNumber.$valid" class="error_msg1">Please Enter valid 12 digit Aadhaar Number</div>
					               </div>
                                 </span>
                                  <span data-ng-if="showdrivingLicense">
                                  <label>driving License Number</label>
                                 <input type="text" name="aadhaarNumber" id="drivingLicenseNumber" data-ng-disabled="empreadonly" data-ng-model="employeeDto.drivingLicenseNumber" data-ng-minlength="16" alphamumeric data-ng-required="showdrivingLicense" maxlength="16"   class="form-control">
                                 <i class="fa fa-asterisk" ></i>
                                   <div data-ng-if="Employee.$submitted || Employee.aadhaarNumber.$touched" class="error_msg1">
					               <div data-ng-if="Employee.aadhaarNumber.$error.minlength || !Employee.aadhaarNumber.$valid" class="error_msg1">Please Enter valid 16 digit driving License Number</div>
					               </div>
                                 </span>
                                  <span data-ng-if="showvoterId">
                                  <label>Voter Id</label>
                                 <input type="text" name="aadhaarNumber" id="voterIdNumber" data-ng-disabled="empreadonly" data-ng-model="employeeDto.voterIdNumber"  data-ng-required="showvoterId"  alphamumeric data-ng-minlength="10" maxlength="10"   class="form-control">
                                 <i class="fa fa-asterisk" ></i>
                                  <div data-ng-if="Employee.$submitted || Employee.aadhaarNumber.$touched" class="error_msg1">
					              <div data-ng-if="Employee.aadhaarNumber.$error.minlength || !Employee.aadhaarNumber.$valid" class="error_msg1">Please Enter valid 10 digit Voter Id Number</div>
					              </div>
                                 </span>
                                  <span data-ng-if="showpassportNumber">
                                  <label>Passport</label>
                                 <input type="text" name="aadhaarNumber" id="passportNumber" data-ng-disabled="empreadonly" data-ng-model="employeeDto.passportNumber" data-ng-required="showpassportNumber" alphamumeric data-ng-minlength="8" maxlength="8"  class="form-control">
                                 <i class="fa fa-asterisk" ></i>
                                  <div data-ng-if="Employee.$submitted || Employee.aadhaarNumber.$touched" class="error_msg1">
					              <div data-ng-if="Employee.aadhaarNumber.$error.minlength || !Employee.aadhaarNumber.$valid" class="error_msg1">Please Enter valid 8 digit passport Number</div>
					              </div>
                                 </span>
                                
                                
                                
                                
                                </div>
                                
                                <div class="three_column_form_column text-center">
                                <label>&nbsp;</label>
                                <span class="btn btn-primary" data-ng-if="Employee.aadhaarNumber.$valid" data-ng-disabled="empreadonly" data-ng-click="AddProofEdit(employeeDto.proof,Employee.aadhaarNumber.$valid)"><i class="fa fa-address-book-o"></i> ADD PROOF</span>
                                
                                </div>
                                
                                <div class="table-responsive">
                                <br>
                               <table class="table" width="100%">
                               <tr><th>Proof Details</th><th>Numbers</th><th>Action</th></tr>
                                <tr data-ng-repeat="x in addedProofList">
                                <td>{{x.name}}</td>
                                <td>{{x.number}}</td>
                                <td><span class="btn btn-primary" data-ng-click="removeRow(x.id)">
                                <i class="fa fa-close"></i> </span></td>
                                </tr>
                                </table>
                                
                                
                                </div>
                                
                                
                               
                                <div class="three_column_form_column">
                                <div data-ng-if="employeeDto.employeeType=='ONROLL'">
                                    <label>PAN Card Number</label>
                                    <input type="text" class="form-control" id="panCardNumber"  data-ng-readonly="empreadonly" name="panCardNumber" data-ng-model="employeeDto.panCardNumber" panvalid required data-ng-minlength="10"  maxlength="10" capitalize nospecialchar>
                                    <i class="fa fa-asterisk" ></i>
                                    <div data-ng-show="Employee.$submitted || Employee.panCardNumber.$touched" class="error_msg_edit_emp">
					                <div data-ng-if="Employee.panCardNumber.$error.minlength || !Employee.panCardNumber.$valid" class="error_msg_edit_emp">Please Enter valid 10 digit pan card number</div>
					               </div>
					               </div>
                                </div>
                                
                                
                                <!-- <div class="three_column_form_column">
                                    <label>Proof</label>
                                    <div class="new-select-option">
								<select name="proof" id="proof" wb-select2
									data-ng-model="employeeDto.proof"
									data-ng-change="getProofNumber(employeeDto.proof)"
									required class="form-control"
									style="width: 100%; height: 36px;">

							<option value="" selected></option> 

									<option
										data-ng-repeat="x in idProofDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>
								</select>
							</div>
						<div data-ng-show="Employee.$submitted || Employee.proof.$touched" class="error_msg_edit_emp">
						<div data-ng-show="Employee.proof.$error.required" class="error_msg_edit_emp">Please choose proof</div>
					    </div>
                                </div> -->
<!--                                 <div class="three_column_form_column"> -->
<!--                                     <label>Proof Number </label> -->
<!--                                     <input type="text" class="form-control" id="proofNumber" name="proofNumber" data-ng-model="employeeDto.proofNumber"  required nospecialchar maxlength='{{length}}' data-ng-maxlength="length"  data-ng-minlength="length"> -->
<!--                                     <i class="fa fa-asterisk" ></i> -->
<!--                                     <div data-ng-show="Employee.$submitted || Employee.proofNumber.$touched" class="error_msg_edit_emp"> -->
<!-- 						            <div data-ng-if="!Employee.proofNumber.$valid" class="error_msg_edit_emp">Please enter {{length}} digit {{employeeDto.proof}} number</div> -->
<!-- 					                </div> -->
<!--                                 </div> -->
                            </div>
                             
                            <!-- form 4 -->
                            <div class="row">
                                <h3>Contact Details</h3>
                                <div class="three_column_form_column">
                                    <label>Mobile Number</label>
                                    <input type="text" class="form-control" id="mobileNumber" data-ng-readonly="empreadonly" name="mobileNumber" data-ng-model="employeeDto.mobileNumber" ng-minlength="10" mobileno maxlength="10" required>
                                    <i class="fa fa-asterisk" ></i>
                                    <div data-ng-show="Employee.$submitted || Employee.mobileNumber.$touched" class="error_msg_edit_emp">
						            <div data-ng-show="Employee.mobileNumber.$error.required || !Employee.mobileNumber.$valid" class="error_msg_edit_emp">Please Enter Valid 10 digit Mobile Number</div>
					                </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Alternative Mobile Number</label>
                                    <input type="text" class="form-control" id="alternateMobileNumber" data-ng-readonly="empreadonly" name="alternateMobileNumber" data-ng-model="employeeDto.alternateMobileNumber" 
                                    data-ng-minlength="10" maxlength="10" mobileno>
                                   <!--  <i class="fa fa-asterisk" ></i> -->
                                    <div data-ng-show="Employee.$submitted" class="error_msg_edit_emp">
						            <div data-ng-show="employeeDto.alternateMobileNumber.length<10 || Employee.alternateMobileNumber.$error.minlength" class="error_msg_edit_emp">Please Enter Valid 10 digit Mobile Number</div>
					             </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Mail Id</label>
                                   <input type="email" class="form-control" id="emailId" name="emailId" data-ng-readonly="empreadonly" maxlength="50" data-ng-pattern="emailFormat" class="email" emailidvalid  data-ng-model="employeeDto.emailId" required>
                                   <i class="fa fa-asterisk" ></i>
                                   <div data-ng-show="Employee.$submitted || Employee.emailId.$touched" class="error_msg_edit_emp">
						           <div data-ng-show="Employee.emailId.$error.required" class="error_msg_edit_emp">Please Enter Email Id</div>
						           <div data-ng-show="Employee.emailId.$error.email" class="error_msg_edit_emp">Not a valid email</div>
					               </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Alternative Mail Id </label>
                                   <input type="email" class="form-control" id="alternateEmailId" data-ng-readonly="empreadonly" name="alternateEmailId" maxlength="50"    data-ng-model="employeeDto.alternateEmailId">
                                   <!-- <i class="fa fa-asterisk" ></i> -->
                                   <div data-ng-show="Employee.$submitted || Employee.alternateEmailId.$touched" class="error_msg_edit_emp">
						           <div data-ng-show="Employee.alternateEmailId.$error.required" class="error_msg_edit_emp">Please Enter Alternate Email Id</div>
						           <div data-ng-show="Employee.alternateEmailId.$error.email" class="error_msg_edit_emp">Not a valid email</div>
					              </div>
                                </div>
                            </div>
                            <!-- form 5 -->
                            <div class="row">
                                <h3>Communication Address</h3>
                                <div class="three_column_form_column">
                                    <label>Address Line 1</label> <!-- addressvalid -->
                                    <input type="text" class="form-control" id="taddress1" data-ng-readonly="empreadonly" name="taddress1" addressvalid data-ng-model="employeeDto.taddress1"  data-ng-maxlength="40"  required>
                                    <i class="fa fa-asterisk" ></i>
                                    <div data-ng-show="Employee.$submitted || Employee.taddress1.$touched" class="error_msg_edit_emp">
						            <div data-ng-show="Employee.taddress1.$error.required" class="error_msg_edit_emp">Please Enter address</div>
					              </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Address Line 2</label>
                                   <input type="text" class="form-control" id="taddress2"  data-ng-readonly="empreadonly" name="taddress2" addressvalid data-ng-maxlength="40"   data-ng-model="employeeDto.taddress2">
                                </div>
                                <div class="three_column_form_column">
                                    <label>Address Line 3</label>
                                  <input type="text" class="form-control" id="taddress3" data-ng-readonly="empreadonly" name="taddress3" addressvalid data-ng-maxlength="40"   data-ng-model="employeeDto.taddress3">
                                </div>
                                <div class="three_column_form_column">
                                    <label>Address Line 4</label>
                                   <input type="text" class="form-control" id="taddress4"  data-ng-readonly="empreadonly" name="taddress4" addressvalid data-ng-maxlength="40"   data-ng-model="employeeDto.taddress4">
                                </div>
                                <div class="three_column_form_column">
                                    <label>State</label>
                                    <div class="new-select-option">
								<select name="state" id="state" wb-select2
									data-ng-model="employeeDto.tstate" 
									required class="form-control"
									data-ng-change="getCity(employeeDto.tstate)"
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">
									<option value="" selected></option> 
									<option
										data-ng-repeat="x in stateEntityList track by x.stateName" data-ng-if="x.status=='ACTIVE'"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
							</div>
							 <i class="fa fa-asterisk" ></i>
										<div data-ng-show="Employee.$submitted ||Employee.state.$touched" class="error_msg_edit_emp">
						                <div data-ng-show="Employee.state.$error.required" class="error_msg_edit_emp">Please Select State</div>
						                </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>City</label>
                                    <div class="new-select-option">
								<select name="city" id="city" wb-select2
									data-ng-model="employeeDto.tcity" 
									required class="form-control"
									style="width: 100%; height: 36px;" data-ng-disabled="empreadonly">

									<option value="" selected></option>

									<option
										data-ng-repeat="x in cityEntityList track by x.cityName" data-ng-if="x.status=='ACTIVE'"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
							</div>
							 <i class="fa fa-asterisk" ></i>
										<div data-ng-show="Employee.$submitted || Employee.city.$touched" class="error_msg_edit_emp">
								<div data-ng-show="Employee.city.$error.required" class="error_msg_edit_emp">Please Select City</div>
								</div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Pincode</label>
                                   <input type="text" class="form-control" id="tpinCode" data-ng-readonly="empreadonly" name="tpinCode" data-ng-model="employeeDto.tpinCode" numbersonly nospecialchar maxlength="6" data-ng-maxlength="6"  data-ng-minlength="6" required autocomplete="off">
                                   <i class="fa fa-asterisk" ></i>
                                   <div data-ng-show="Employee.$submitted || Employee.tpinCode.$touched" class="error_msg_edit_emp">
						           <div data-ng-if="!Employee.tpinCode.$valid" class="error_msg_edit_emp">Please Enter 6 digit pincode</div>
					               </div>
                                </div>
                            </div>
                      <div class="check_box_event">
                                <div class="new-check-button full_width_check">
                                   <span>Is communication & permanent address are same:</span><input id="basic_checkbox_1" class="filled-in" data-ng-disabled="empreadonly"   type="checkbox" data-ng-model="employeeDto.isAddressSame" data-ng-change="isCommunicationAddressSame(employeeDto.isAddressSame)"> 
                                        <label for="basic_checkbox_1"><b>YES</b></label>
                                       
                                </div>
                            </div>
                            <!-- form 5 -->
                            <div class="row">
                                <h3>Permanent Address </h3>
                               <!--  <div class="three_column_form_column">
                                    <label>Address Line 1</label>
                                    <input type="text" class="form-control" id="paddress1" name="paddress1" data-ng-model="employeeDto.paddress1" data-ng-readonly="read">
                                </div> -->
                                
                                 <div class="three_column_form_column">
                                    <label>Address Line 1</label>
                                    <input type="text" class="form-control" id="paddress1" data-ng-readonly="empreadonly1"   name="paddress1" data-ng-model="employeeDto.paddress1"  addressvalid  data-ng-maxlength="40" required >
                                    <i class="fa fa-asterisk" ></i>
                                    <div data-ng-show="Employee.$submitted || Employee.paddress1.$touched" class="error_msg_edit_emp">
						            <div data-ng-show="Employee.paddress1.$error.required" class="error_msg_edit_emp">Please Enter address</div>
					              </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Address Line 2</label>
                                   <input type="text" class="form-control" id="paddress2" data-ng-readonly="empreadonly1"   name="paddress2" data-ng-model="employeeDto.paddress2"    addressvalid data-ng-maxlength="40"  >
                                </div>
                                <div class="three_column_form_column">
                                    <label>Address Line 3</label>
                                    <input type="text"class="form-control" id="paddress3" data-ng-readonly="empreadonly1"  name="paddress3" data-ng-model="employeeDto.paddress3" addressvalid data-ng-maxlength="40"  >
                                </div>
                                <div class="three_column_form_column">
                                    <label>Address Line 4</label>
                                   <input type="text" class="form-control" id="paddress4" data-ng-readonly="empreadonly1" name="paddress4" data-ng-model="employeeDto.paddress4" addressvalid  data-ng-maxlength="40" >
                                </div>
                                <div class="three_column_form_column">
                                    <label>State</label>
                                    
                                    <div class="new-select-option">
								<select name="pstate" id="pstate" wb-select2
									data-ng-model="employeeDto.pstate" 
									data-ng-change="getCity(employeeDto.pstate)"
									required class="form-control"
									style="width: 100%; height: 36px;"  data-ng-disabled="empreadonly1">
								<option value="" selected></option> 
									<option
										data-ng-repeat="x in stateEntityList track by x.stateName" data-ng-if="x.status=='ACTIVE'"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
							</div>
							 <i class="fa fa-asterisk" ></i>
										<div data-ng-show="Employee.$submitted ||Employee.pstate.$touched" class="error_msg_edit_emp">
						                <div data-ng-show="Employee.pstate.$error.required" class="error_msg_edit_emp">Please Select State</div>
						                </div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>City</label>
                                    
                                    <div class="new-select-option">
								<select name="pcity" id="pcity" wb-select2
									data-ng-model="employeeDto.pcity" 
									required class="form-control"
									style="width: 100%; height: 36px;"  data-ng-disabled="empreadonly1">
									<option value="" selected></option> 
									<option
										data-ng-repeat="x in cityEntityList track by x.cityName" data-ng-if="x.status=='ACTIVE'"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
							</div>
							 <i class="fa fa-asterisk" ></i>
										<div data-ng-show="Employee.$submitted || Employee.pcity.$touched" class="error_msg_edit_emp">
								<div data-ng-show="Employee.pcity.$error.required" class="error_msg_edit_emp">Please Select City</div>
								</div>
                                </div>
                                <div class="three_column_form_column">
                                    <label>Pincode</label>
                                    <input type="text" class="form-control" id="ppinCode"  name="ppinCode" data-ng-model="employeeDto.ppinCode" data-ng-readonly="empreadonly1"   numbersonly nospecialchar maxlength="6" data-ng-maxlength="6"  data-ng-minlength="6" required autocomplete="off">
                                    <i class="fa fa-asterisk" ></i>
                                    <div data-ng-show="Employee.$submitted || Employee.ppinCode.$touched" class="error_msg_edit_emp">
						           <div data-ng-if="!Employee.ppinCode.$valid" class="error_msg_edit_emp">Please Enter 6 digit pincode</div>
					               </div>
                                </div>
                            </div>
                            <div class="col-12 submit_col text-center">
                            <button class="btn btn-primary" type="button" data-ng-click="editView()"><i class="fa fa-update"></i> Update</button>
					<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
					<span class="btn btn-warning" data-ng-click="editCancel()"><i class="fa fa-close"></i> CANCEL</span>
				</div>
                        </form>
                    </div>
                </div>
                </div>




	</div>




	  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Employee Details</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>Name </th><td>{{employeeDetails.fullName}}</td></tr>
							<tr><th>Designation</th><td>{{employeeDetails.designation}}</td></tr>
							<tr><th>Mobile No</th><td>{{employeeDetails.mobileNumber}}</td></tr>
							<tr><th>Email ID</th><td>{{employeeDetails.emailId}}</td></tr>
							<tr><th>Employee ID</th><td>{{employeeDetails.employeeId}}</td></tr>
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

