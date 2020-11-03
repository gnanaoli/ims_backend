 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="manufacturerManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">MANUFACTURER MANAGEMENT</h3>
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
								<h4 class="form_content_title">Create New Manufacturer</h4>
								<form class="form-inline" role="form" name="new_manufacturer" id="new_manufacturer" novalidate >
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="email">Manufacturer Name:</label>
											<input type="text" class="form-control" id="name" name="name" data-ng-model="manufacturerDto.name"onlystring required maxlength="100" autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="new_manufacturer.$submitted || new_manufacturer.name.$touched" class="error_msg">
									<div data-ng-show="new_manufacturer.name.$error.required" class="error_msg">Please enter Manufacturer Name</div>
									</div>		
										<div class="add_icon_asterisk">
											<label for="email">Manufacturer Code:</label>
											<input type="text" class="form-control" id="code" name="code" data-ng-model="manufacturerDto.code"required maxlength="6" autocomplete="off" tabindex="2">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="new_manufacturer.$submitted || new_manufacturer.code.$touched" class="error_msg">
									<div data-ng-show="new_manufacturer.code.$error.required" class="error_msg">Please enter Manufacturer Code</div>
									</div>	
										
										<div class="add_icon_asterisk">
											<label for="pwd">Address 1 :</label>
											<input type="text" class="form-control" id="address1" name="address1" data-ng-model="manufacturerDto.address1"required maxlength="50" autocomplete="off" tabindex="3">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="new_manufacturer.$submitted || new_manufacturer.address1.$touched" class="error_msg">
										<div ng-show="new_manufacturer.address1.$error.required" class="error_msg">Please enter Address1</div>
										</div>
										<div class="add_icon_asterisk">
												<label for="pwd"> Address 2:</label>
												<input type="text" class="form-control" id="address2" name="address2" data-ng-model="manufacturerDto.address2"required maxlength="50" autocomplete="off" tabindex="4">
												<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="new_manufacturer.$submitted || new_manufacturer.address2.$touched" class="error_msg">
										<div ng-show="new_manufacturer.address2.$error.required" class="error_msg">Please enter Address 2</div>
										</div>
										<div class="add_icon_asterisk">
												<label for="pwd"> Area / Landmark:</label>
												<input type="text" class="form-control" id="areaLandmark" name="areaLandmark" data-ng-model="manufacturerDto.areaLandmark" required maxlength="50" autocomplete="off" tabindex="5">
												<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="new_manufacturer.$submitted || new_manufacturer.areaLandmark.$touched" class="error_msg">
										<div ng-show="new_manufacturer.areaLandmark.$error.required" class="error_msg">Please Enter Area / Landmark</div>
										</div>
									<!-- 	
										<div class="">
											<label for="pwd">Country:</label>
											<input type="text" class="form-control" id="country" name="country" data-ng-model="manufacturerDto.country">

											
										</div> -->
										
											<div class="add_icon_asterisk">
											<label for="pwd">Country Name</label>
											<input
											list="country" class="form-control" 
											id="country_List" name="country" placeholder="" ng-readonly="datareadonly" required
											data-ng-model="manufacturerDto.country" ng-blur="getStates(manufacturerDto.country);" autocomplete="off" tabindex="6">
											<i class="fa fa-asterisk" ></i>
										<datalist id="country">
											<option
												ng-repeat="x in countryDtoList track by x.countryName"
												value="{{x.countryName}}">{{x.countryName}}</option>
										</datalist>
										</div>
										<div data-ng-if="isInValidCountry==true && manufacturerDto.country.toString().length >0" >Please choose valid Country</div>
					<div data-ng-show="new_manufacturer.$submitted || new_manufacturer.country.$touched" class="error_msg">
						<div data-ng-show="new_manufacturer.country.$error.required" class="error_msg">Please Select Country Name</div>
					</div>	
										
										<!-- <div class="">
												<label for="pwd"> State:</label>
												<input type="text" class="form-control" id="state" name="state" data-ng-model="manufacturerDto.state">
										</div> -->
										
										<div class="add_icon_asterisk">
											<label for="pwd">State</label>
											<input
											list="state" class="form-control" 
											id="state_List" name="state" placeholder="" ng-readonly="datareadonly" required='true'
											data-ng-model="manufacturerDto.state" data-ng-blur="getCity(manufacturerDto.state,manufacturerDto.country)" autocomplete="off" tabindex="7">
											<i class="fa fa-asterisk" ></i>
										<datalist id="state">
											<option
												ng-repeat="x in stateEntityList track by x.stateName"
												value="{{x.stateName}}">{{x.stateName}}</option>
										</datalist>
										
										</div>
						<div ng-show="new_manufacturer.$submitted ||new_manufacturer.state.$touched" class="error_msg">
						<div ng-show="new_manufacturer.state.$error.required" class="error_msg">Please Select State</div>
					</div>	
										
										
										<!-- <div class="">
												<label for="pwd"> City:</label>
												<input type="text" class="form-control" id="city" name="city" data-ng-model="manufacturerDto.city">
										
										</div> -->
											<div class="add_icon_asterisk">
											<label for="pwd">City Name</label>
											<input
											list="city" class="form-control" 
											id="city_List" name="city" placeholder="" ng-readonly="datareadonly" required
											data-ng-model="manufacturerDto.city" autocomplete="off" tabindex="8">
											<i class="fa fa-asterisk" ></i>
										<datalist id="city">
											<option
												ng-repeat="x in cityEntityList track by x.cityName"
												value="{{x.cityName}}">{{x.cityName}}</option>
										</datalist>
										</div>
							<div ng-show="new_manufacturer.$submitted || new_manufacturer.city.$touched" class="error_msg">
								<div ng-show="new_manufacturer.city.$error.required" class="error_msg">Please Select City</div>
								</div>	
									</div>	
									<div class="col-md-6 col_md text-center">
											<div class="add_icon_asterisk">
												<label for="email">Pin Code:</label>
												<input type="text" class="form-control" id="pincode" name="pincode" data-ng-model="manufacturerDto.pincode"maxlength="6" numbersonly required autocomplete="off" tabindex="9" >
												<i class="fa fa-asterisk" ></i>
											</div>
											<div ng-show="new_manufacturer.$submitted || new_manufacturer.pincode.$touched" class="error_msg">
						<div ng-show="new_manufacturer.pincode.$error.required" class="error_msg">Please enter Pincode</div>
							<div data-ng-show="new_manufacturer.pincode.toString().length<7">Please
										enter Valid 6 digit Pin Code</div>
					</div>
											<div class="add_icon_asterisk">
												<label for="pwd">Contact Person:</label>
												<input type="text" class="form-control" id="contactPerson" name="contactPerson" data-ng-model="manufacturerDto.contactPerson" required maxlength="50" autocomplete="off" tabindex="10">
												<i class="fa fa-asterisk" ></i>
											</div>
											<div ng-show="new_manufacturer.$submitted || new_manufacturer.contactPerson.$touched" class="error_msg">
										<div ng-show="new_manufacturer.contactPerson.$error.required" class="error_msg">Please enter	Contact Person</div>
										</div>	
											<div class="">
												<label for="pwd">TelePhone No :</label>
												<input type="text" class="form-control" id="telephoneNumber" name="telephoneNumber" data-ng-model="manufacturerDto.telephoneNumber"maxlength="8" numbersonly tabindex="11" >
											</div>
											
											<div class="">
													<label for="pwd"> Mobile No:</label>
													<input type="text" class="form-control" id="mobileNumber" name="mobileNumber" data-ng-model="manufacturerDto.mobileNumber"maxlength="10" numbersonly tabindex="12" >
											</div>
											
						<div data-ng-show="new_manufacturer.mobileNumber.toString().length<10">Please enter Valid 10 digit Mobile Number</div>		
							
								
											<div class="">
													<label for="pwd"> Fax:</label>
													<input type="text" class="form-control" id="fax" name="fax" data-ng-model="manufacturerDto.fax" numbersonly maxlength="20" autocomplete="off" tabindex="13">
											</div>
											<div class="">
													<label for="pwd"> E-Mail Id:</label>
													<input type="text" class="form-control" id="emailId" name="emailId" data-ng-model="manufacturerDto.emailId"maxlength="90" autocomplete="off" tabindex="14">
											</div>
											<div class="">
													<label for="pwd"> GST IN:</label>
													<input type="text" class="form-control" id="gstIn" name="gstIn" data-ng-model="manufacturerDto.gstIn"maxlength="15" autocomplete="off" tabindex="15">
											</div>
											<div class="">
													<label for="pwd"> URl:</label>
													<input type="text" class="form-control" id="url" name="url" data-ng-model="manufacturerDto.url"maxlength="100" autocomplete="off" tabindex="16">
											</div>
										</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveManufacturer()"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />