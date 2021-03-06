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
                    <div class="col-md-6 align-self-center">
                        <h3 class="text-themecolor">MANUFACTURER</h3>
                    </div>
                    
                   <div class="col-md-6 align-self-center">
                   
                   <div data-ng-show="ManufacturerMgt">
                   
                   	<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
                        <ol class="breadcrumb">
                        <li>
                            <a class="btn btn-primary waves-effect waves-light" href="" data-ng-click="newManufacturer()" >ADD MANUFACTURER</a>
                        </li>
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
            
		<div data-ng-if="addnewManufacturer">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Add Manufacturer</h4>
								
								<form class="form-inline" data-ng-submit="saveManufacturer(editManufacturer.$valid)" method="post" name="editManufacturer" novalidate>
									<div class="col-md-6 col_md text-center">

											<div class="add_icon_asterisk">
											<label for="email">Manufacturer Name:</label>
											<input type="text" class="form-control" id="name" name="name" data-ng-model="manufacturerDto.name" namefieldwithspchar required maxlength="100" autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										</div>
										
				
					<div data-ng-show="editManufacturer.$submitted || editManufacturer.name.$touched" class="error_msg">
									<div data-ng-show="editManufacturer.name.$error.required" class="error_msg">Please enter Manufacturer Name</div>
									</div>										
									
								<div class="add_icon_asterisk">
											<label for="email">Manufacturer Code:</label>
											<input type="text" class="form-control" id="code" name="code" data-ng-model="manufacturerDto.code" alphamumeric required maxlength="6" autocomplete="off" tabindex="2">
											<i class="fa fa-asterisk" ></i>
										</div>
										
										<div data-ng-show="editManufacturer.$submitted || editManufacturer.code.$touched" class="error_msg">
									<div data-ng-show="editManufacturer.code.$error.required" class="error_msg">Please enter Manufacturer Code</div>
									</div>	
										
									 <div class="add_icon_asterisk"> 
                                           
											<label for="pwd">Address 1 :</label>
											<input type="text" class="form-control" id="address1" name="address1" data-ng-model="manufacturerDto.address1" addressvalid required maxlength="50" autocomplete="off" tabindex="3">
											 <i class="fa fa-asterisk" ></i> 
										</div>
										 <div ng-show="editManufacturer.$submitted || editManufacturer.address1.$touched" class="error_msg">
										<div ng-show="editManufacturer.address1.$error.required" class="error_msg">Please enter Address1</div>
										</div> 
										
										<!-- <div class="add_icon_asterisk"> -->
										 <div class="">
												<label for="pwd"> Address 2:</label>
												<input type="text" class="form-control" id="address2" name="address2" data-ng-model="manufacturerDto.address2" addressvalid  maxlength="50" autocomplete="off" tabindex="4">
												<!-- <i class="fa fa-asterisk" ></i> -->
												</div>
										<!-- </div> -->
										<!-- <div ng-show="editManufacturer.$submitted || editManufacturer.address2.$touched" class="error_msg">
										<div ng-show="editManufacturer.address2.$error.required" class="error_msg">Please enter Address 2</div>
										</div> -->
										<!-- <div class="add_icon_asterisk"> -->
                                                 <div class="">
												<label for="pwd"> Address 3:</label>
												<input type="text" class="form-control" id="address3" name="address3" data-ng-model="manufacturerDto.address3" addressvalid  maxlength="50" autocomplete="off" tabindex="5">
												<!-- <i class="fa fa-asterisk" ></i> -->
												</div>

										<div class="">
												<label for="pwd"> Area / Landmark:</label>
												<input type="text" class="form-control" id="areaLandmark" name="areaLandmark" data-ng-model="manufacturerDto.areaLandmark" addressvalid  maxlength="50" autocomplete="off" tabindex="6">
												<!-- <i class="fa fa-asterisk" ></i> -->
										 </div> 
										<!-- <div ng-show="editManufacturer.$submitted || editManufacturer.areaLandmark.$touched" class="error_msg">
										<div ng-show="editManufacturer.areaLandmark.$error.required" class="error_msg">Please Enter Area / Landmark</div>
										</div> -->
									
									
									<div class="add_icon_asterisk">
											<label for="">Country:</label>
											
											
									<div class="new-radio-button-inline">
										<input type="radio" name="indiaOrOutside" id="INDIA" value="INDIA"  data-ng-model="manufacturerDto.indiaOrOutside" class="with-gap" data-ng-change="isCountrySelected(manufacturerDto.indiaOrOutside)"  required tabindex="7">
										<label for="INDIA" >INDIA</label>
										<input type="radio" name="indiaOrOutside" id="OUTSIDE INDIA" value="OUTSIDE INDIA" data-ng-model="manufacturerDto.indiaOrOutside" class="with-gap" data-ng-change="isCountrySelected(manufacturerDto.indiaOrOutside)" required tabindex="8">
										<label for="OUTSIDE INDIA">OUTSIDE INDIA</label> 
										<i class="fa fa-asterisk" ></i>
									</div>											
											
											
										</div>
										
										
					<div data-ng-show="editManufacturer.$submitted || editManufacturer.areaLandmark.$touched" class="error_msg">					
						<div data-ng-show="editManufacturer.indiaOrOutside.$error.required" class="error_msg">Please Select Country </div>
					</div>
									
									
									<span data-ng-if="inSideIndia">
									
									
										
										
										
							<div class="add_icon_asterisk">
							<label for="pwd">State</label>
											
											
							<div class="new-select-option">
								<select name="state" id="state" wb-select2
									data-ng-model="manufacturerDto.state"
									data-ng-change="getCity(manufacturerDto.state,manufacturerDto.country)"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT STATE ---</option>

									<option
										data-ng-repeat="x in stateEntityList track by x.stateName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>											
										
						</div>
						<div ng-show="editManufacturer.$submitted ||editManufacturer.state.$touched" class="error_msg">
						<div ng-show="editManufacturer.state.$error.required" class="error_msg">Please Select State</div>
					</div>
					
					
							<div class="add_icon_asterisk">
						<label for="pwd">City Name</label>
											
											
							<div class="new-select-option">
								<select name="city" id="city" wb-select2
									data-ng-model="manufacturerDto.city"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in cityEntityList track by x.cityName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>											
											
								</div>
							<div ng-show="editManufacturer.$submitted || editManufacturer.city.$touched" class="error_msg">
								<div ng-show="editManufacturer.city.$error.required" class="error_msg">Please Select City</div>
								</div>	
									</span>	
									
									
									<span data-ng-if="outSideIndia">
									
									<div class="add_icon_asterisk">
											<label for="pwd">Country Name :</label>
											<input type="text" class="form-control" id="country" name="country" onlystring data-ng-model="manufacturerDto.country"required maxlength="50" autocomplete="off" tabindex="3">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="editManufacturer.$submitted || editManufacturer.country.$touched" class="error_msg">
										<div ng-show="editManufacturer.country.$error.required" class="error_msg">Please enter Country Name</div>
										</div>
										<div class="add_icon_asterisk">
												<label for="pwd"> State:</label>
												<input type="text" class="form-control" id="state" name="state" onlystring data-ng-model="manufacturerDto.state"required maxlength="50" autocomplete="off" tabindex="4">
												<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="editManufacturer.$submitted || editManufacturer.state.$touched" class="error_msg">
										<div ng-show="editManufacturer.state.$error.required" class="error_msg">Please enter State Name</div>
										</div>
										<div class="add_icon_asterisk">
												<label for="pwd"> City:</label>
												<input type="text" class="form-control" id="city" name="city" onlystring data-ng-model="manufacturerDto.city" required maxlength="50" autocomplete="off" tabindex="5">
												<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="editManufacturer.$submitted || editManufacturer.city.$touched" class="error_msg">
										<div ng-show="editManufacturer.city.$error.required" class="error_msg">Please Enter City</div>
										</div>
									
									
									</span>
									<div class="add_icon_asterisk">
												<label for="email">Pin Code:</label>
												<input type="text" class="form-control" id="pincode" name="pincode" data-ng-model="manufacturerDto.pincode" maxlength='6' data-ng-maxlength="6"  data-ng-minlength="6" numbersonly required autocomplete="off" tabindex="9" >
												<i class="fa fa-asterisk" ></i>
											</div>
											<%-- <div ng-show="editManufacturer.$submitted || editManufacturer.pincode.$touched" class="error_msg">
									<div ng-show="editManufacturer.pincode.$error.required" class="error_msg">Please enter Pincode</div>
											<div data-ng-show="editManufacturer.pincode.toString().length<7">Please
										enter Valid 6 digit Pin Code</div>
										</div> --%>
								<div class="error_msg" ng-show="editManufacturer.$submitted || editManufacturer.pincode.$touched" >		
							 <div class="error_msg"  data-ng-show="editManufacturer.pincode.$error.minlength">Please Enter 6 Digit Pincode</div>
                  <div class="error_msg"  data-ng-show="editManufacturer.pincode.$error.maxlength"  >Please Enter 6 Digit Pincode</div> 	
                   <div  class="error_msg" data-ng-show="editManufacturer.pincode.$error.required">Please Enter Pincode</div>
                  </div>
                                       <div class="">
												<label for="pwd">Contact Person:</label>
												<input type="text" class="form-control" id="contactPerson" name="contactPerson" allowspace data-ng-model="manufacturerDto.contactPerson"  maxlength="50" autocomplete="off" tabindex="10">
												
											</div>
									</div>
									<div class="col-md-6 col_md text-center">
                                
									<div class="">

			<label for="pwd">STD Code :</label>
			<input type="text" class="form-control" id="stdCode" name="stdCode" data-ng-model="manufacturerDto.stdCode"  maxlength="5" numbersonly  data-ng-change="stdChange(manufacturerDto.stdCode)" ng-required="requiredStdTel" tabindex="11">
			</div>
			<div class="">
			<label for="pwd">Telephone No :</label>
			<input type="text" class="form-control" id="telephoneNumber" name="telephoneNumber" data-ng-model="manufacturerDto.telephoneNumber" data-ng-change="stdChange(manufacturerDto.telephoneNumber)" maxlength="8" numbersonly tabindex="12" ng-required="requiredStdTel">
			</div>
			<div data-ng-show="editManufacturer.$submitted || editManufacturer.stdCode.$touched || editManufacturer.telephoneNumber.$touched"  class="error_msg">
			<div class="error_msg" data-ng-show="editManufacturer.telephoneNumber.$error.required || editManufacturer.stdCode.$error.required">
		Please Enter Std Code With Telephone Number 
			</div>
			</div>
			<div class="">
					<label for="pwd"> Mobile No:</label>
					<input type="text" class="form-control" id="mobileNumber" name="mobileNumber" data-ng-model="manufacturerDto.mobileNumber" maxlength='{{length}}' data-ng-maxlength="length"  data-ng-minlength="10" tabindex="13" numbersonly >
			</div>
			<div ng-show="editManufacturer.$submitted || editManufacturer.mobileNumber.$touched" class="error_msg">		
                  <div  class="error_msg"data-ng-show="editManufacturer.mobileNumber.$error.minlength">Please Enter 10 Digit Mobile Number</div>
                  <div  class="error_msg" data-ng-show="editManufacturer.mobileNumber.$error.maxlength">Please Enter 10 Digit  Mobile Number</div> 		
              </div>
	          <div class="">

			<label for="pwd">Std Code For Fax :</label>
			<input type="text" class="form-control" id="fax" name="fax" data-ng-model="manufacturerDto.fax"  maxlength="5" numbersonly tabindex="14" data-ng-change="faxChange(manufacturerDto.fax)" ng-required="requiredFaxfax1" >
			</div>
			<div class="">
			<label for="pwd">Fax No :</label>
			<input type="text" class="form-control" id="fax1" name="fax1" data-ng-model="manufacturerDto.fax1" data-ng-change="faxChange(manufacturerDto.fax1)" maxlength="10" numbersonly tabindex="15" ng-required="requiredFaxfax1" >
			</div>
			<div data-ng-show="editManufacturer.$submitted || editManufacturer.fax.$touched || editManufacturer.fax1.$touched"  class="error_msg">
			<div class="error_msg" data-ng-show="editManufacturer.fax.$error.required || editManufacturer.fax1.$error.required">
			Please Enter Fax No with Fax Std Code 
			</div>
			</div>						
						
						
								
										<!-- 	<div class="">
													<label for="pwd"> Fax:</label>
													<input type="text" class="form-control" id="fax" name="fax" data-ng-model="manufacturerDto.fax" numbersonly maxlength="20" autocomplete="off" tabindex="13">
										<label for="pwd">Fax1:</label>
										<input type="text" class="form-control" id="fax1" name="fax1" data-ng-model="manufacturerDto.fax1" numbersonly maxlength="20" autocomplete="off" tabindex="13">
											</div> -->
		
										
										
											<div class="">
													<label for="pwd"> E-Mail Id:</label>
													<input type="email"  id="emailId" name="emailId" data-ng-pattern="emailFormat" class="email" 
													data-ng-model="manufacturerDto.emailId" maxlength="50" autocomplete="off" tabindex="16">
													 
											</div>
											<div data-ng-show="editManufacturer.$submitted || editManufacturer.emailId.$touched" class="error_msg" class="error_msg">
											<div class="error_msg" data-ng-show="editManufacturer.emailId.$error.email">
											Not a valid Email </div>
											</div>
											
											
											<div class="">
													<label for="pwd">Alternative E-Mail Id:</label>
													<input type="email"  id="alternativeEmailId" name="alternativeEmailId" data-ng-pattern="emailFormat" class="email" 
													data-ng-model="manufacturerDto.alternativeEmailId" maxlength="50" autocomplete="off" tabindex="17">
													 
											</div>
											<div data-ng-show="editManufacturer.$submitted || editManufacturer.alternativeEmailId.$touched" class="error_msg" class="error_msg">
											<div class="error_msg" data-ng-show="editManufacturer.alternativeEmailId.$error.email">
											Not a valid Email </div>
											</div>
											
											<div class="">
													<label for="pwd">Additional Address 1:</label>
													<input type="text" class="form-control" id="additionalAddress" name="additionalAddress" data-ng-model="manufacturerDto.additionalAddress" addressvalid maxlength="50" autocomplete="off" tabindex="18">
											</div>
											
											<div class="">
													<label for="pwd">Additional Address 2:</label>
													<input type="text" class="form-control" id="additionalAddress2" name="additionalAddress2" data-ng-model="manufacturerDto.additionalAddress2" addressvalid maxlength="50" autocomplete="off" tabindex="19">
											</div>
											
											<div class="">
													<label for="pwd">Additional Address 3:</label>
													<input type="text" class="form-control" id="additionalAddress3" name="additionalAddress3" data-ng-model="manufacturerDto.additionalAddress3" addressvalid maxlength="50" autocomplete="off" tabindex="20">
											</div>
											
										<div class="">
													<label for="pwd">Toll Free Num:</label>
													<input type="text" class="form-control" id="tollFreeNo" name="tollFreeNo" data-ng-model="manufacturerDto.tollFreeNo" numbersonly maxlength="20" autocomplete="off" tabindex="21">
											</div>												
										</div>
		
							<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>					

							</div>
					</div>
		
		
		
		</div>


	<!-- Start Page Content -->
	<!-- ============================================================== -->
	<!-- Row -->
                
                <div data-ng-if="ManufacturerMgt">
                
                
		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Manufacturer</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
					<tr>
						<th>Manufacturer Name</th>
							<th>Manufacturer Code</th>
							<th>Address1</th>
							<!-- <th>Address2</th> -->
							<th>Country</th>
							<th>City</th>
							<th>Status</th>
							<th class="not-export-col">Action</th>
					</tr>
					</thead>
					<tbody>
					
						<tr data-ng-repeat="manufacturerDto in manufacturerDtoList">
							<td>{{manufacturerDto.name}}</td>
							<td>{{manufacturerDto.code}}</td>
							<td>{{manufacturerDto.address1}}</td>
							<!-- <td>{{manufacturerDto.address2}}</td> -->
							<td>{{manufacturerDto.country}}</td>
							<td>{{manufacturerDto.city}}</td>
							<td>{{manufacturerDto.status}}</td>	
								<td class="table_btn_group">
							<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
							<a href="" data-ng-click="edit(manufacturerDto)" class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a>
							 </security:authorize> <a href="" data-ng-click="view(manufacturerDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> VIEW</a></td>
						</tr>

					</tbody>
				</table>
</div>



			</div>
		</div>
		</div>
		
		<!-- Start Page Content -->
	<!-- ============================================================== -->
	<!-- Row -->
		
		<div data-ng-if="editManufacturer">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Edit Manufacturer</h4>
								<form class="form-inline" role="form" name="editManufacturer" data-ng-submit="saveManufacturer(editManufacturer.$valid)"  id="editManufacturer" novalidate >
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="email">Manufacturer Name:</label>
											<input type="text" class="form-control" id="name" name="name"  namefieldwithspchar data-ng-model="manufacturerDto.name" autocomplete="off"  tabindex="1" maxlength="100" required>
											<i class="fa fa-asterisk" ></i>
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="manufacturerDto.id"  >
										</div>
										<div data-ng-show="editManufacturer.$submitted || editManufacturer.name.$touched" class="error_msg">
									<div data-ng-show="editManufacturer.name.$error.required" class="error_msg">Please enter Manufacturer Name</div>
									</div>	
									<div class="add_icon_asterisk">
											<label for="email">Manufacturer Code:</label>
											<input type="text" class="form-control" id="code" name="code" alphamumeric data-ng-model="manufacturerDto.code"autocomplete="off" tabindex="2" maxlength="6" required>
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="editManufacturer.$submitted || editManufacturer.code.$touched" class="error_msg">
									<div data-ng-show="editManufacturer.code.$error.required" class="error_msg">Please enter Manufacturer Code</div>
									</div>
										
										<div class="add_icon_asterisk">
											<label for="pwd">Address 1 :</label>
											<input type="text" class="form-control" id="address1" name="address1" addressvalid data-ng-model="manufacturerDto.address1"  autocomplete="off" tabindex="3" required>
											<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="editManufacturer.$submitted || editManufacturer.address1.$touched" class="error_msg">
										<div ng-show="editManufacturer.address1.$error.required" class="error_msg">Please enter Address1</div>
										</div>
										<!-- <div class="add_icon_asterisk"> -->
										<div class="">
												<label for="pwd"> Address 2:</label>
												<input type="text" class="form-control" id="address2" name="address2" addressvalid data-ng-model="manufacturerDto.address2"  autocomplete="off" tabindex="4" >
												<!-- <i class="fa fa-asterisk" ></i> -->
										</div>
										<div class="">
												<label for="pwd"> Address 3:</label>
												<input type="text" class="form-control" id="address3" name="address3" addressvalid data-ng-model="manufacturerDto.address3"  autocomplete="off" tabindex="5" >
										</div>
										<!-- <div ng-show="editManufacturer.$submitted || editManufacturer.address2.$touched" class="error_msg">
										<div ng-show="editManufacturer.address2.$error.required" class="error_msg">Please enter Address 2</div>
										</div> -->
										<div class="">
												<label for="pwd"> Area / Landmark:</label>
												<input type="text" class="form-control" id="areaLandmark" name="areaLandmark" addressvalid data-ng-model="manufacturerDto.areaLandmark" autocomplete="on" tabindex="6" >
												<!-- <i class="fa fa-asterisk" ></i> -->
										</div>
								
								<div class="add_icon_asterisk">
											<label for="">Country:</label>
											
											
									<div class="new-radio-button-inline">
										<input type="radio" name="indiaOrOutside" id="INDIA" value="INDIA"  data-ng-model="manufacturerDto.indiaOrOutside" class="with-gap" data-ng-change="isCountrySelected(manufacturerDto.indiaOrOutside)" required tabindex="7">
										<label for="INDIA" >INDIA</label>
										<input type="radio" name="indiaOrOutside" id="OUTSIDE INDIA" value="OUTSIDE INDIA" data-ng-model="manufacturerDto.indiaOrOutside" class="with-gap" data-ng-change="isCountrySelected(manufacturerDto.indiaOrOutside)" required tabindex="8">
										<label for="OUTSIDE INDIA">OUTSIDE INDIA</label>
										<i class="fa fa-asterisk" ></i> 
									</div>											
											
											
										</div>
										
										
					<div data-ng-show="editManufacturer.$submitted || editManufacturer.areaLandmark.$touched" class="error_msg">					
						<div data-ng-show="editManufacturer.indiaOrOutside.$error.required" class="error_msg">Please Select Country </div>
					</div>
									
									
									<span data-ng-if="inSideIndia">
									
									
										
							<div class="add_icon_asterisk">
							<label for="pwd">State</label>
											
											
							<div class="new-select-option">
								<select name="state" id="state1" wb-select2
									data-ng-model="manufacturerDto.state"
									data-ng-change="getCity(manufacturerDto.state,manufacturerDto.country)"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT STATE ---</option>

									<option
										data-ng-repeat="x in stateEntityList track by x.stateName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>											
										
						</div>
						<div ng-show="editManufacturer.$submitted ||editManufacturer.state.$touched" class="error_msg">
						<div ng-show="editManufacturer.state.$error.required" class="error_msg">Please Select State</div>
					</div>
					
					
							<div class="add_icon_asterisk">
						<label for="pwd">City Name</label>
											
											
							<div class="new-select-option">
								<select name="city" id="city1" wb-select2
									data-ng-model="manufacturerDto.city"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in cityEntityList track by x.cityName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>											
											
								</div>
							<div ng-show="editManufacturer.$submitted || editManufacturer.city.$touched" class="error_msg">
								<div ng-show="editManufacturer.city.$error.required" class="error_msg">Please Select City</div>
								</div>	
									</span>	
									
									
									
									<span data-ng-show="outSideIndia">
									
									<div class="add_icon_asterisk">
											<label for="pwd">Country Name :</label>
											<input type="text" class="form-control" id="country" name="country" onlystring data-ng-model="manufacturerDto.country"required maxlength="50" autocomplete="off" tabindex="3">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="editManufacturer.$submitted || editManufacturer.country.$touched" class="error_msg">
										<div ng-show="editManufacturer.country.$error.required" class="error_msg">Please enter Country Name</div>
										</div>
										<div class="add_icon_asterisk">
												<label for="pwd"> State:</label>
												<input type="text" class="form-control" id="state" name="state" onlystring data-ng-model="manufacturerDto.state"required maxlength="50" autocomplete="off" tabindex="4">
												<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="editManufacturer.$submitted || editManufacturer.state.$touched" class="error_msg">
										<div ng-show="editManufacturer.state.$error.required" class="error_msg">Please enter State Name</div>
										</div>
										<div class="add_icon_asterisk">
												<label for="pwd"> City:</label>
												<input type="text" class="form-control" id="city" name="city" onlystring data-ng-model="manufacturerDto.city" required maxlength="50" autocomplete="off" tabindex="5">
												<i class="fa fa-asterisk" ></i>
										</div>
										<div ng-show="editManufacturer.$submitted || editManufacturer.city.$touched" class="error_msg">
										<div ng-show="editManufacturer.city.$error.required" class="error_msg">Please Enter City</div>
										</div>
										
									</span>
									<div class="add_icon_asterisk">
												<label for="email">Pin Code:</label>
												<input type="text" class="form-control" id="pincode" name="pincode" data-ng-model="manufacturerDto.pincode" maxlength='6' data-ng-maxlength="6"  data-ng-minlength="6" numbersonly required autocomplete="off" tabindex="9">
												<i class="fa fa-asterisk" ></i>
											</div>

										<div data-ng-show="editManufacturer.$submitted || editManufacturer.pincode.$touched" class="error_msg">	
									 <div  class="error_msg" data-ng-show="editManufacturer.pincode.$error.minlength">Please Enter 6 Digit Pincode</div>
                  <div  class="error_msg" data-ng-show="editManufacturer.pincode.$error.maxlength">Please Enter 6 Digit  Pincode</div>
                  <div  class="error_msg" data-ng-show="editManufacturer.pincode.$error.required">Please Enter Pincode</div>
											</div>
											<div class="">
												<label for="pwd">Contact Person:</label>
												<input type="text" class="form-control" id="contactPerson" name="contactPerson" data-ng-model="manufacturerDto.contactPerson" allowspace   autocomplete="off" tabindex="10">
												
											</div>
											</div>
										<div class="col-md-6 col_md text-center">
									
									
									
											
											
											<!-- <div ng-show="editManufacturer.$submitted || editManufacturer.contactPerson.$touched" class="error_msg">
										<div ng-show="editManufacturer.contactPerson.$error.required" class="error_msg">Please enter	Contact Person</div>
										</div> -->
											<div class="">

			<label for="pwd">STD Code :</label>
			<input type="text" class="form-control" id="stdCode" name="stdCode" data-ng-model="manufacturerDto.stdCode"  maxlength="5" numbersonly tabindex="11" data-ng-change="stdChange(manufacturerDto.stdCode)" ng-required="requiredStdTel">
				</div>
					<div class="">
			<label for="pwd">Telephone No :</label>
			<input type="text" class="form-control" id="telephoneNumber" name="telephoneNumber" data-ng-model="manufacturerDto.telephoneNumber" data-ng-change="stdChange(manufacturerDto.telephoneNumber)" maxlength="10" numbersonly tabindex="12" ng-required="requiredStdTel">
			</div>
			<div data-ng-show="editManufacturer.$submitted || editManufacturer.stdCode.$touched || editManufacturer.telephoneNumber.$touched"  class="error_msg">
			<div class="error_msg" data-ng-show="editManufacturer.telephoneNumber.$error.required || editManufacturer.stdCode.$error.required">
			Please Enter Telephone No with Std Code
			</div> 
			</div>
											<div class="">
													<label for="pwd"> Mobile No:</label>
													<input type="text" class="form-control" id="mobileNumber" name="mobileNumber" data-ng-model="manufacturerDto.mobileNumber"  numbersonly  maxlength='{{length}}' data-ng-maxlength="length"  data-ng-minlength="10" autocomplete="off" tabindex="13">
											</div>
												<div ng-show="editManufacturer.$submitted || editManufacturer.mobileNumber.$touched" class="error_msg">	
											<div  class="error_msg" data-ng-show="editManufacturer.mobileNumber.$error.minlength">Please enter Valid  Mobile Number</div>
											<div  class="error_msg" data-ng-show="editManufacturer.mobileNumber.$error.maxlength">Please enter Valid  Mobile Number</div>
											</div>
											<!-- <div class="">
													<label for="pwd"> Fax:</label>
													<input type="text" class="form-control" id="fax" name="fax" data-ng-model="manufacturerDto.fax"  maxlength="10" numbersonly autocomplete="off" tabindex="13">
											</div>
											<div class="">
													<label for="pwd"> Fax1:</label>
													<input type="text" class="form-control" id="fax1" name="fax1" data-ng-model="manufacturerDto.fax1"  maxlength="10" numbersonly autocomplete="off" tabindex="14">
											</div> -->
											
									
							  <div class="">

			<label for="pwd">Std Code For Fax :</label>
			<input type="text" class="form-control" id="fax" name="fax" data-ng-model="manufacturerDto.fax"  maxlength="5" numbersonly tabindex="14" data-ng-change="faxChange(manufacturerDto.fax)" ng-required="requiredFaxfax1">
				</div>
			<div class="">
			<label for="pwd">Fax No :</label>
			<input type="text" class="form-control" id="fax1" name="fax1" data-ng-model="manufacturerDto.fax1" data-ng-change="faxChange(manufacturerDto.fax1)" maxlength="10" numbersonly tabindex="15" ng-required="requiredFaxfax1">
			</div>
			<div data-ng-show="editManufacturer.$submitted || editManufacturer.fax.$touched || editManufacturer.fax1.$touched"  class="error_msg">
			<div class="error_msg" data-ng-show="editManufacturer.fax.$error.required || editManufacturer.fax1.$error.required">
			Please Enter Fax No with Fax Std Code 
			</div>
			</div>						
											<div class="">
													<label for="pwd"> E-Mail Id:</label>
													<input type="email" id="emailId" name="emailId" data-ng-model="manufacturerDto.emailId"   class="email" maxlength="50" autocomplete="off" tabindex="16">
											</div>
											<div data-ng-show="editManufacturer.$submitted || editManufacturer.emailId.$touched" class="error_msg" class="error_msg">
											<div class="error_msg" data-ng-show="editManufacturer.emailId.$error.email">
											Not a valid Email </div>
											</div>
											
											<div class="">
													<label for="pwd">Alternative E-Mail Id:</label>
													<input type="email" id="alternativeEmailId" name="alternativeEmailId" data-ng-model="manufacturerDto.alternativeEmailId"  class="email" maxlength="50" autocomplete="off" tabindex="17">
											</div>
											<div data-ng-show="editManufacturer.$submitted || editManufacturer.alternativeEmailId.$touched" class="error_msg" class="error_msg">
											<div class="error_msg" data-ng-show="editManufacturer.alternativeEmailId.$error.email">
											Not a valid Email </div>
											</div>
											<div class="">
												<label for="pwd">Additional Address 1:</label>
												<input type="text" class="form-control" id="additionalAddress" name="additionalAddress" data-ng-model="manufacturerDto.additionalAddress" addressvalid   autocomplete="off" tabindex="18">
												
											</div>
											<div class="">
												<label for="pwd">Additional Address 2 :</label>
												<input type="text" class="form-control" id="additionalAddress2" name="additionalAddress2" data-ng-model="manufacturerDto.additionalAddress2" addressvalid   autocomplete="off" tabindex="19">
												
											</div>
											<div class="">
												<label for="pwd">Additional Address 3 :</label>
												<input type="text" class="form-control" id="additionalAddress3" name="additionalAddress3" data-ng-model="manufacturerDto.additionalAddress3" addressvalid   autocomplete="off" tabindex="20">
												
											</div>
										
										<div class="">
												<label for="pwd">Toll Free No :</label>
												<input type="text" class="form-control" id="tollFreeNo" name="tollFreeNo" data-ng-model="manufacturerDto.tollFreeNo" numbersonly   autocomplete="off" maxlength="20" tabindex="21">
												
											</div>
							
											<!-- <div class="">
													<label for="pwd"> GST IN:</label>
													<input type="text" class="form-control" id="gstIn" name="gstIn" data-ng-model="manufacturerDto.gstIn"  maxlength="15" autocomplete="off" tabindex="15">
											</div> -->
											<%-- <div class="">
													<label for="pwd"> URL:</label>
													<input type="text" class="form-control" id="url" name="url" data-ng-model="manufacturerDto.url" ng-init="manufacturerDto.url='${manufacturerDto.url}'" maxlength="100" autocomplete="off" tabindex="16">
											</div> --%>
											<div class="add_icon_asterisk">
										<label for="email"> Status :</label>
						
						
									<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="manufacturerDto.status"  required class="with-gap" name="status" id="ACTIVE" value="ACTIVE" tabindex="22" >
										<label for="ACTIVE" >ACTIVE</label>
										<input type="radio" data-ng-model="manufacturerDto.status"  required class="with-gap" name="status" id="INACTIVE" value="INACTIVE" tabindex="23">
										<label for="INACTIVE">INACTIVE</label>
									</div>
								<i class="fa fa-asterisk" ></i>
						</div>
						<div ng-show="editManufacturer.$submitted || editManufacturer.status.$touched" class="error_msg">
										<div ng-show="editManufacturer.status.$error.required" class="error_msg">Please select the status</div>
										</div>
					</div>
											<div class="">
												<input type="hidden" class="form-control" id="createdBy" name="createdBy" data-ng-model="manufacturerDto.createdBy" ng-init="manufacturerDto.createdBy='${manufacturerDto.createdBy}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="manufacturerDto.creationDate" ng-init="manufacturerDto.creationDate='${manufacturerDto.creationDate}'">
											</div>
										
										<div class="col-12 submit_col text-center">
					     	<button class="btn btn-primary"	type="submit">
						    	<i class="fa fa-check"></i> SAVE
						</button>
						<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
										
								</form>
							</div>
					</div>
		
		
		
		</div>
			
		<!-- Start Page Content -->
	<!-- ============================================================== -->
	<!-- Row -->
		
		
		  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Manufacturer</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>Name </th><td>{{manufacturerDetails.name}}</td></tr>
							<tr><th>Code</th><td>{{manufacturerDetails.code}}</td></tr>
							<tr><th>Address 1</th><td>{{manufacturerDetails.address1}}</td></tr>
							<!-- <tr><th>Address 2</th><td>{{manufacturerDetails.address2}}</td></tr> -->
							<tr><th>Country</th><td>{{manufacturerDetails.country}}</td></tr>
							<tr><th>City</th><td>{{manufacturerDetails.city}}</td></tr>
							<tr><th>Status</th><td>{{manufacturerDetails.status}}</td></tr>
			
			
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