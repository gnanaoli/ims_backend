 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="projectManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">PROJECT MANAGEMENT</h3>
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
								<h4 class="form_content_title">Edit Project</h4>
								<form class="form-inline" role="form" name="new_project" id="new_project" novalidate>
									<div class="col-md-6 col_md text-center">
										
										<input type="hidden" class="form-control" id="id" name="id" data-ng-model="projectDto.id" data-ng-init="projectDto.id='${projectDto.id}'" >
										<div class="add_icon_asterisk">
											<label for="pwd">Name:</label>
											<input type="text" class="form-control" id="name" name="name" data-ng-model="projectDto.name" data-ng-init="projectDto.name='${projectDto.name}'" maxlength="50" required="required" autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="new_project.$submitted || new_project.name.$touched" class="error_msg">
									<div data-ng-show="new_project.name.$error.required" class="error_msg">Please Enter Project Name </div>
									</div>
										
										<div class="add_icon_asterisk">
											<label for="email">Project Type</label>
											<%-- <input
											list="projectType" class="form-control" 
											id="projectType_List" placeholder="Project Type" data-data-ng-readonly="datareadonly"	data-ng-model="projectDto.projectType" name="projectType" data-ng-init="projectDto.projectType='${projectDto.projectType}'"  required autocomplete="off" tabindex="2" >
											<i class="fa fa-asterisk" ></i>
										<datalist id="projectType">
											<option
												data-data-ng-repeat="x in projectTypeDtoList track by x.projectType"
												value="{{x.projectType}}">{{x.projectType}}</option>
										</datalist> --%>
										<div class="new-select-option">
								<select name="country" id="" wb-select2
									data-ng-model="projectDto.projectType"data-ng-init="projectDto.projectType='${projectDto.projectType}'"
									
									required class="form-control"
									style="width: 100%; height: 36px;">


									<option
										data-ng-repeat="x in projectTypeDtoList track by x.projectType"
										value="{{x.projectType}}">{{x.projectType}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
										</div>
										
										
										<div data-ng-show="new_project.$submitted || new_project.projectType.$touched" class="error_msg">
									<div data-ng-show="new_project.projectType.$error.required" class="error_msg">Please enter project Type </div>
									</div>
									
										<div class="add_icon_asterisk">
												<label for="pwd">In charge Name:</label>
												<input type="text" class="form-control" id="projectInCharge" name="projectInCharge" data-ng-model="projectDto.projectInCharge" data-ng-init="projectDto.projectInCharge='${projectDto.projectInCharge}'" required="required" autocomplete="off" tabindex="3">
												<i class="fa fa-asterisk" ></i>
											</div>
											
											<div data-ng-show="new_project.$submitted || new_project.projectInCharge.$touched" class="error_msg">
									<div data-ng-show="new_project.projectInCharge.$error.required" class="error_msg">Please Enter Project In Charge </div>
									</div>
										<div class="add_icon_asterisk">
											<label for="pwd">Start Date:</label>
											
											<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" name="startDate" id="startDate" data-ng-model="projectDto.startDate" data-ng-init="projectDto.startDate='${projectDto.startDate}'" readonly required autocomplete="off" tabindex="4">
                                               
                                            </div>
                                            <div data-ng-show="new_project.$submitted || new_project.startDate.$touched" class="error_msg">
										<div data-ng-show="new_project.startDate.$error.required" class="error_msg">Please Select Start Date</div>
										</div>
                                        </div>
											<i class="fa fa-asterisk" ></i>
										</div>
										<div class="add_icon_asterisk">
											<label for="pwd">EndtDate:</label>
											
											
												<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" name="endDate" id="endDate" data-ng-model="projectDto.endDate" data-ng-init="projectDto.endDate='${projectDto.endDate}'" data-ng-change="validateEndDate()" readonly required autocomplete="off" tabindex="5">
                                                
                                            </div>
                                        </div>
                                        
                                        
                                        <div data-ng-show="new_project.$submitted || new_project.endDate.$touched" class="error_msg">
										<div data-ng-show="new_project.endDate.$error.required" class="error_msg">Please Select End Date</div>
										</div>
											
									<i class="fa fa-asterisk" ></i>
										</div>

										
										<div class="add_icon_asterisk">
											<label for="pwd">Address 1 :</label>
											<input type="text" class="form-control" id="address1" name="address1" data-ng-model="projectDto.address1" data-ng-init="projectDto.address1='${projectDto.address1}'" required="required" autocomplete="off" tabindex="6">
											<i class="fa fa-asterisk" ></i>
										</div>
										
										<div data-ng-show="new_project.$submitted || new_project.address1.$touched" class="error_msg">
										<div data-ng-show="new_project.address1.$error.required" class="error_msg">Please enter Address1</div>
										</div>
										
										
										<div class="">
												<label for="pwd"> Address 2:</label>
												<input type="text" class="form-control" id="address2" name="address2" data-ng-model="projectDto.address2" data-ng-init="projectDto.address2='${projectDto.address2}'" autocomplete="off"  tabindex="7">
										</div>
										</div>
										<div class="col-md-6 col_md text-center">
										<div class="">
												<label for="pwd"> Address 3:</label>
												<input type="text" class="form-control" id="address3" name="address3" data-ng-model="projectDto.address3" data-ng-init="projectDto.address3='${projectDto.address3}'" autocomplete="off" tabindex="8">
										</div>
										
										<div class="">
												<label for="pwd"> Area / Landmark:</label>
												<input type="text" class="form-control" id="areaLandmark" name="areaLandmark" data-ng-model="projectDto.areaLandmark" data-ng-init="projectDto.areaLandmark='${projectDto.areaLandmark}'" autocomplete="off" tabindex="9">
										</div>
										
									
										
										<div class="add_icon_asterisk">
											<label for="pwd">Country Name</label>
											<%-- <input
											list="country" class="form-control" 
											id="country_List" name="country" placeholder="Country Name" data-ng-readonly="datareadonly" required
											data-ng-model="projectDto.countryName" data-ng-blur="getStates(projectDto.country);" data-ng-init="projectDto.countryName='${projectDto.countryName}'" autocomplete="off" tabindex="10">
											<i class="fa fa-asterisk" ></i>	
										<datalist id="country">
											<option
												data-ng-repeat="x in countryDtoList track by x.countryName"
												value="{{x.countryName}}">{{x.countryName}}</option>
										</datalist> --%>
										<div class="new-select-option">
								<select name="country" id="" wb-select2
									data-ng-model="projectDto.countryName"
									data-ng-change="getStates(projectDto.countryName)"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT COUNTRY ---</option>

									<option
										data-ng-repeat="x in countryDtoList track by x.countryName"
										value="{{x.countryName}}">{{x.countryName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
										</div>
										
										<div data-ng-if="isInValidCountry==true && projectDto.country.toString().length >0" >Please choose valid Country</div>
									<div data-ng-show="new_project.$submitted || new_project.country.$touched" class="error_msg">
									<div data-ng-show="new_project.country.$error.required" class="error_msg">Please Select Country Name</div>
								</div>
								
										
										<div class="add_icon_asterisk">
											<label for="pwd">State</label>
											<%-- <input
											list="state" class="form-control" 
											id="state_List" name="state" placeholder="state Name" data-ng-readonly="datareadonly" required
											data-ng-model="projectDto.state" data-ng-blur="getCity(projectDto.state,projectDto.country)" data-ng-init="projectDto.state='${projectDto.state}'" autocomplete="off" tabindex="11">
											<i class="fa fa-asterisk" ></i>
										<datalist id="state">
											<option
												data-ng-repeat="x in stateEntityList track by x.stateName"
												value="{{x.stateName}}">{{x.stateName}}</option>
										</datalist> --%>
										<div class="new-select-option">
									<select name="state" id="state1" wb-select2
									data-ng-model="projectDto.state"
									data-ng-change="getCity(projectDto.state,projectDto.countryName)"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT STATE ---</option>

									<option
										data-ng-repeat="x in stateEntityList track by x.stateName"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
										</div>
										
									<div data-ng-show="new_project.$submitted ||new_project.state.$touched" class="error_msg">
									<div data-ng-show="new_project.state.$error.required" class="error_msg">Please Select State</div>
								</div>	
					
										<div class="add_icon_asterisk">
											<label for="pwd">City Name</label>
											<%-- <input
											list="city" class="form-control" 
											id="city_List" name="city" placeholder="City Name" data-ng-readonly="datareadonly" required
											data-ng-model="projectDto.city" data-ng-init="projectDto.city='${projectDto.city}'" autocomplete="off" tabindex="12">
											<i class="fa fa-asterisk" ></i>
										<datalist id="city">
											<option
												data-ng-repeat="x in cityEntityList track by x.cityName"
												value="{{x.cityName}}">{{x.cityName}}</option>
										</datalist> --%>
										
								
							<div class="new-select-option">
								<select name="city" id="city" wb-select2
									data-ng-model="projectDto.city"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in cityEntityList track by x.cityName"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
					
										</div>
										
							<div data-ng-show="new_project.$submitted || new_project.city.$touched" class="error_msg">
								<div data-ng-show="new_project.city.$error.required" class="error_msg">Please Select City</div>
								</div>					
											<div class="add_icon_asterisk">
												<label for="email">Pin Code:</label>
												<input type="text" class="form-control" id="pinCode" name="pinCode" data-ng-model="projectDto.pinCode" data-ng-init="projectDto.pinCode='${projectDto.pinCode}'" required="required" autocomplete="off" tabindex="13">
												<i class="fa fa-asterisk" ></i>
											</div>
											<div data-ng-show="new_project.$submitted || new_project.pinCode.$touched" class="error_msg">
											<div data-ng-show="new_project.pinCode.$error.required" class="error_msg">Please enter Pin code</div>
											<div data-ng-show="new_project.pinCode.toString().length<7">Please enter Valid 6 digit Pin Code</div>
											</div>
											<%-- <div class="add_icon_asterisk">
											<label for="email">Status </label>
											<input list="status" class="form-control" 
											id="projectStatus_List" placeholder="Status" data-ng-readonly required data-ng-model="projectDto.status" name="status" data-ng-init="projectDto.status='${projectDto.status}'" autocomplete="off" tabindex="14">
											<i class="fa fa-asterisk" ></i>
										<datalist id="status">
											<option
												data-data-ng-repeat="x in projectStatusDtoList track by x.status"
												value="{{x.status}}">{{x.status}}</option>
										</datalist>
										</div> --%>
										
										<!-- 
										<div data-ng-show="new_project.$submitted || new_project.status.$touched" class="error_msg">
									<div data-ng-show="new_project.status.$error.required" class="error_msg">Please Select  Status</div>
							
									</div> -->
									
									<%-- <div class="add_icon_asterisk">
											<label for="email">Status </label>
											<input list="status" class="form-control" id="projectStatus_List" placeholder="Status" data-ng-readonly="datareadonly" required
											data-ng-model="projectDto.status" data-ng-init="projectDto.status='${projectDto.status}'" name="status" tabindex="14">
											<i class="fa fa-asterisk" ></i>
										<datalist id="status">
											<option
												data-ng-repeat="x in projectStatusDtoList track by x.status"
												value="{{x.status}}">{{x.status}}</option>
										</datalist>
										</div> --%>
										<div class="add_icon_asterisk">
											<label for="email">Status </label>
											<div class="new-select-option">
								<select name="status" id="status" wb-select2
									data-ng-model="projectDto.status"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in projectStatusDtoList track by x.statuse"
										value="{{x.status}}">{{x.status}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
							</div>
										
										<div data-ng-show="new_project.$submitted || new_project.status.$touched" class="error_msg">
									<div data-ng-show="new_project.status.$error.required" class="error_msg">Please Select  Status</div>
							
									</div>
											</div>
											
											
											
												<!-- <label for="pwd">createdBy  :</label> -->
												<input type="hidden" class="form-control" id="createdBy" name="createdBy" data-ng-model="projectDto.createdBy" data-ng-init="projectDto.createdBy='${projectDto.createdBy}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="projectDto.creationDate" data-ng-init="projectDto.creationDate='${projectDto.creationDate}'">
											
											
											
										
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveProject()"><i class="fa fa-check"></i> SAVE</button>
											<button class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</button>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->


<jsp:include page="footer.jsp" />


	