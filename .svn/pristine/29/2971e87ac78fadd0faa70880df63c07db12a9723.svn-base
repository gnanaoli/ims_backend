 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="wareHouseManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">WAREHOUSE MANAGEMENT</h3>
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
				<h4 class="form_content_title">Edit WareHouse</h4>
				<form class="form-inline" method="post" name="new_wareHouse" id="new_wareHouse" novalidate>
					<div class="col-md-6 col_md text-center">
						<div class="add_icon_asterisk">
							<label for="email">WareHouse Name:</label> <input type="text"
								class="form-control" id="wareHouseName" name="wareHouseName"
								data-ng-model="wareHouseDto.wareHouseName"
								data-ng-init="wareHouseDto.wareHouseName='${wareHouseDto.wareHouseName}'" maxlength="50" required>
								<i class="fa fa-asterisk" ></i>
							
							<input type="hidden" class="form-control" id="id" name="id"
								data-ng-model="wareHouseDto.id"
								data-ng-init="wareHouseDto.id='${wareHouseDto.id}'" readonly>
						</div>
						
						<div class="error_msg" data-ng-show="new_wareHouse.$submitted || new_wareHouse.wareHouseName.$touched" class="error_msg">
						<div  class="error_msg" data-ng-show="new_wareHouse.wareHouseName.$error.required" class="error_msg">Please
							enter WareHouse Name</div>
					</div>
						<div class="add_icon_asterisk">
							<label for="pwd">Code:</label> 
							<input type="text" class="form-control" id="code" name="code"
								data-ng-model="wareHouseDto.code" maxlength="3" ng-change="getParentCode()"
								ng-init="wareHouseDto.code='${wareHouseDto.code}'" required>
								<i class="fa fa-asterisk" ></i>
						</div>
						<div ng-show="new_wareHouse.$submitted || new_wareHouse.code.$touched" class="error_msg">
						<div ng-show="new_wareHouse.code.$error.required" class="error_msg">Please
							enter code</div>
					</div>
						<div class="add_icon_asterisk">
							<label for="pwd">Parent Code:</label> <input type="text"
								class="form-control" id="parentCode" name="parentCode"
								data-ng-model="wareHouseDto.parentCode"
								ng-init="wareHouseDto.parentCode='${wareHouseDto.parentCode}'" readonly>
								<i class="fa fa-asterisk" ></i>
						</div>
						<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.parentCode.$touched" class="error_msg">
						<div ng-show="new_wareHouse.parentCode.$error.required" class="error_msg">Please
							enter parentCode</div>
					</div>

						<div class="add_icon_asterisk">
							<label for="pwd">Address 1 :
							</label> <input type="text"	class="form-control" id="address1" name="address1"
								data-ng-model="wareHouseDto.address1"
								data-ng-init="wareHouseDto.address1='${wareHouseDto.address1}'" maxlength="50" required>
								<i class="fa fa-asterisk" ></i>
						</div>
						<div
						data-ng-show="new_wareHouse.$submitted || new_wareHouse.address1.$touched" class="error_msg">
						<div data-ng-show="new_wareHouse.address1.$error.required" class="error_msg">Please
							enter Address1</div>
					</div>


						<div class="">
							<label for="pwd"> Address 2:</label> <input type="text"
								class="form-control" id="address2" name="address2"
								data-ng-model="wareHouseDto.address2"
								ng-init="wareHouseDto.address2='${wareHouseDto.address2}'" maxlength="50">
						</div>
						<div class="">
							<label for="pwd"> Address 3:</label> <input type="text"
								class="form-control" id="address3" name="address3"
								data-ng-model="wareHouseDto.address3"
								ng-init="wareHouseDto.address3='${wareHouseDto.address3}'" maxlength="50">
						</div>
						<div class="">
							<label for="pwd"> Area / Landmark:</label> <input type="text"
								class="form-control" id="areaLandmark" name="areaLandmark"
								data-ng-model="wareHouseDto.areaLandmark"
								ng-init="wareHouseDto.areaLandmark='${wareHouseDto.areaLandmark}'" maxlength="50">
						</div>
					</div>
					<div class="col-md-6 col_md text-center">

						<div class="add_icon_asterisk">
						<label for="pwd">Country Name</label> 
						<input list="country" class="form-control" id="country_List" name="country"
							placeholder="" ng-readonly="datareadonly" required
							data-ng-model="wareHouseDto.country" ng-blur="getStates(wareHouseDto.country);" ng-init="wareHouseDto.country='${wareHouseDto.country}'" autocomplete="off">
							<i class="fa fa-asterisk" ></i>
						<datalist id="country">
							<option ng-repeat="x in countryDtoList track by x.countryName"
								value="{{x.countryName}}">{{x.countryName}}</option>
								
						</datalist>
					</div>
						
						
						<div  data-ng-init="wareHouseDto.country='${wareHouseDto.country}'"
						data-ng-if="isInValidCountry==true && wareHouseDto.country.toString().length >0">Please
						choose valid Country</div>
					<div
						data-ng-show="new_wareHouse.$submitted || new_wareHouse.country.$touched" class="error_msg">
						<div data-ng-show="new_wareHouse.country.$error.required" class="error_msg">Please
							Select Country Name</div>
					</div>
						<div class="add_icon_asterisk">
						<label for="pwd">State</label> <input list="state"
							class="form-control" id="state_List" name="state"
							placeholder="" ng-readonly="datareadonly"
							required data-ng-model="wareHouseDto.state"
							data-ng-blur="getCity(wareHouseDto.state,wareHouseDto.country)" data-ng-init="wareHouseDto.state='${wareHouseDto.state}'" autocomplete="off">
								<i class="fa fa-asterisk" ></i>
						<datalist id="state">
							<option ng-repeat="x in stateEntityList track by x.stateName"
								value="{{x.stateName}}">{{x.stateName}}</option>
						</datalist>

					</div>
						
						
						<div
						ng-show="new_wareHouse.$submitted ||new_wareHouse.state.$touched" class="error_msg">
						<div ng-show="new_wareHouse.state.$error.required" class="error_msg">Please
							Select State</div>
					</div>

						<div class="add_icon_asterisk">
						<label for="pwd">City Name</label> <input list="city"
							class="form-control" id="city_List" name="city"
							placeholder="" data-ng-readonly="datareadonly" data-ng-init="wareHouseDto.city='${wareHouseDto.city}'" required
							data-ng-model="wareHouseDto.city" autocomplete="off">
							<i class="fa fa-asterisk" ></i>
						<datalist id="city" >
							<option ng-repeat="x in cityEntityList track by x.cityName"
								value="{{x.cityName}}">{{x.cityName}}</option>
						</datalist>
					</div>
					<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.city.$touched" class="error_msg">
						<div ng-show="new_wareHouse.city.$error.required" class="error_msg">Please
							Select City</div>
					</div>
						
						
						<div class="add_icon_asterisk">
							<label for="email">Pin Code:</label> 
							<input type="text" class="form-control" id="pinCode" name="pinCode"
								data-ng-model="wareHouseDto.pinCode"
								ng-init="wareHouseDto.pinCode='${wareHouseDto.pinCode}'" required>
								<i class="fa fa-asterisk" ></i>
						</div>
						<div class="add_icon_asterisk">
							<label for="pwd">Effective Start Date:</label> 
							
							
										<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="effectiveStartDate" name="effectiveStartDate" data-ng-model="wareHouseDto.effectiveStartDate" ng-init="wareHouseDto.effectiveStartDate='${wareHouseDto.effectiveStartDate}'" readonly required>
                                                
                                            </div>
                                        </div>							
							<i class="fa fa-asterisk" ></i>

						</div>
											<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.effectiveStartDate.$touched" class="error_msg">
						<div ng-show="new_wareHouse.effectiveStartDate.$error.required" class="error_msg">Please
							Select Effective Start Date</div>
					</div>
						
						<div class="add_icon_asterisk">
							<label for="pwd">Effective End Date:</label> 
							
							
							
										<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="effectiveEndDate" data-ng-change="validateToDate()" name="effectiveEndDate" data-ng-model="wareHouseDto.effectiveEndDate" ng-init="wareHouseDto.effectiveEndDate='${wareHouseDto.effectiveEndDate}'" readonly required>
                                                                                            </div>
                                        </div>
                                        <i class="fa fa-asterisk" ></i>							
						</div>

					<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.effectiveEndDate.$touched" class="error_msg">
						<div ng-show="new_wareHouse.effectiveEndDate.$error.required" class="error_msg">Please
							Select Effective End Date</div>
					</div>
						
						<div class="">
						<label for="email"> Status :</label>
						
						
						
						<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="wareHouseDto.status" ng-init="wareHouseDto.status='${wareHouseDto.status}'" required class="with-gap" name="status" id="ACTIVE" value="ACTIVE" >
										<label for="ACTIVE" >ACTIVE</label>
										<input type="radio" data-ng-model="wareHouseDto.status" ng-init="wareHouseDto.status='${wareHouseDto.status}'" required class="with-gap" name="status" id="INACTIVE" value="INACTIVE" >
										<label for="INACTIVE" >INACTIVE</label>
									</div>
						
<%-- 						<input type="radio" data-ng-model="wareHouseDto.status" value="ACTIVE" ng-init="wareHouseDto.status='${wareHouseDto.status}'">ACTIVE --%>
<%-- 						<input type="radio" data-ng-model="wareHouseDto.status" value="INACTIVE" ng-init="wareHouseDto.status='${wareHouseDto.status}'" >INACTIVE --%>
						
						
						</div>
						
					</div>


					<div class="">
						<!-- <label for="pwd">createdBy  :</label> -->
						<input type="hidden" class="form-control" id="createdBy"
							name="createdBy" data-ng-model="wareHouseDto.createdBy"
							ng-init="wareHouseDto.createdBy='${wareHouseDto.createdBy}'">
						<input type="hidden" class="form-control" id="creationDate"
							name="creationDate" data-ng-model="wareHouseDto.creationDate"
							ng-init="wareHouseDto.creationDate='${wareHouseDto.creationDate}'">
					</div>



					<div class="col-12 submit_col text-center">
					
					
						<security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">						
						<button class="btn btn-primary" data-ng-click="saveWareHouse('warehouse')"><i class="fa fa-check"></i> SAVE</button>
						</security:authorize>
						<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">						
						<button class="btn btn-primary" data-ng-click="saveWareHouse('office')"><i class="fa fa-check"></i> SAVE</button>
						</security:authorize>
						
						
											
						
						
						<security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">						
						<span class="btn btn-warning" data-ng-click="cancelWareHouse()"><i class="fa fa-close"></i> CANCEL</span>
						</security:authorize>
						<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">						
						<span class="btn btn-warning" data-ng-click="cancelOffice()"><i class="fa fa-close"></i> CANCEL</span>
						</security:authorize>
					</div>
				</form>
			</div>
		</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />	