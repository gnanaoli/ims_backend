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
                        <h3 class="text-themecolor">WAREHOUSE </h3>
                    </div>
              <div class="col-md-7 align-self-center" data-ng-if="wareHouseTable">
                        <ol class="breadcrumb">
                        <li>
                        <security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
                            <a class="btn btn-primary waves-effect waves-light" href="" data-ng-click="newWareHouse()">Add WareHouse</a>
                            </security:authorize>
                                                    <security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
                            <a class="btn btn-primary waves-effect waves-light" href="" data-ng-click="newWareHouse()">Add WareHouse</a>
                            </security:authorize>
                            </li>
                        </ol>
                    </div> 
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                
                
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                <div data-ng-if="wareHouseTable">
		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Search WareHouse</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
								<th>WareHouse Name </th>
								<th>code</th>
								<th> City</th>
								<th>State </th>
								<th>Country</th>
								<th>Start Date </th>
								<th>End Date  </th>
								<th>Status  </th>
								<th class="not-export-col"> Action </th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="wareHouseDto in wareHouseDtoList">
							<td>{{wareHouseDto.wareHouseName}}</td>
							<td>{{wareHouseDto.code}}</td>
							<td>{{wareHouseDto.city}}</td>
							<td>{{wareHouseDto.state}}</td>
							<td>{{wareHouseDto.country}}</td>
							<td>{{wareHouseDto.effectiveStartDate}}</td>
							<td>{{wareHouseDto.effectiveEndDate}}</td>
							<td>{{wareHouseDto.status}}</td>
						        
							<td class="table_btn_group">
							<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
							<a href="" class="btn btn-primary" data-ng-click="edit(wareHouseDto)"><i class="fa fa-edit"></i> Edit</a>
							</security:authorize>
							<a href="" data-ng-click="view(wareHouseDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td> 
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
	<div data-ng-if="addWareHouse">
	
	<div class="form_section">
		<div class="form-content create_form">
			<h4 class="form_content_title">New WareHouse</h4>
			<form class="form-inline" method="post" name="new_wareHouse"
				id="new_wareHouse" data-ng-submit="saveWareHouse(new_wareHouse.$valid)" novalidate>
				<div class="col-md-6 col_md text-center">
					<div class="add_icon_asterisk">
						<label for="email">WareHouse Name:</label> 
						<input type="text"	class="form-control" id="wareHouseName" name="wareHouseName"
							data-ng-model="wareHouseDto.wareHouseName" maxlength="50" autocomplete="off"
							required="required"  allowspacealphanum class="error_msg" tabindex="1"> 
							<input type="hidden"
							class="form-control" id="id" name="id"
							data-ng-model="wareHouseDto.id">
							<i class="fa fa-asterisk" ></i>
					</div>
					
					<div class="error_msg" data-ng-show="new_wareHouse.$submitted || new_wareHouse.wareHouseName.$touched" class="error_msg">
						<div  class="error_msg" data-ng-show="new_wareHouse.wareHouseName.$error.required" class="error_msg">Please
							enter WareHouse Name</div>
					</div>
					<div class="add_icon_asterisk">
						<label for="pwd">Code:</label>
						 <input type="text"	class="form-control" id="code" name="code" alphamumeric
							data-ng-model="wareHouseDto.code" maxlength="3" ng-change="getParentCode()"
							required="required" class="error_msg" tabindex="2">
							<i class="fa fa-asterisk" ></i>
					</div>
					<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.code.$touched" class="error_msg">
						<div ng-show="new_wareHouse.code.$error.required" class="error_msg">Please
							enter code</div>
					</div>
					<div class="add_icon_asterisk">
						<label for="pwd">Parent Code:</label>
						 <input type="text"	class="form-control" id="parentCode" name="parentCode"
							data-ng-model="wareHouseDto.parentCode" maxlength="3"
							required="required" readonly class="error_msg">
							<i class="fa fa-asterisk" ></i>
					</div>
<!-- 					<div -->
<!-- 						ng-show="new_wareHouse.$submitted || new_wareHouse.parentCode.$touched" class="error_msg"> -->
<!-- 						<div ng-show="new_wareHouse.parentCode.$error.required" class="error_msg">Please -->
<!-- 							enter parentCode</div> -->
<!-- 					</div> -->


					<div class="add_icon_asterisk">
						<label for="pwd">Address 1 :</label>
						 <input type="text"	class="form-control" id="address1" name="address1" addressvalid
							data-ng-model="wareHouseDto.address1" maxlength="50"
							required="required" class="error_msg" tabindex="3">
							<i class="fa fa-asterisk" ></i>
					</div>
					<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.address1.$touched" class="error_msg">
						<div ng-show="new_wareHouse.address1.$error.required" class="error_msg">Please
							enter Address1</div>
					</div>


					<div class="">
						<label for="pwd"> Address 2:</label> <input type="text"
							class="form-control" id="address2" name="address2" addressvalid
							data-ng-model="wareHouseDto.address2" maxlength="50" tabindex="4">
					</div>
					<div class="">
						<label for="pwd"> Address 3:</label> <input type="text"
							class="form-control" id="address3" name="address3" addressvalid
							data-ng-model="wareHouseDto.address3" maxlength="50" tabindex="5">
					</div>

					<div class="">
						<label for="pwd"> Area / Landmark:</label>
						 <input type="text"	class="form-control" id="area" name="area" addressvalid
							data-ng-model="wareHouseDto.area" maxlength="50" tabindex="6">
					</div>
				</div>
				<div class="col-md-6 col_md text-center">

					
					
						<!-- <input list="country"
							class="form-control" id="country_List" name="country"
							placeholder="" ng-readonly="datareadonly" required
							data-ng-model="wareHouseDto.country"
							ng-blur="getStates(wareHouseDto.country);" autocomplete="off">
							<i class="fa fa-asterisk" ></i>
						<datalist id="country">
							<option ng-repeat="x in countryDtoList track by x.countryName"
								value="{{x.countryName}}">{{x.countryName}}</option>
								
						</datalist> -->
						<div class="">
						<label for="pwd">Country Name</label> 
						<input type="text"
							class="form-control" id="country" name="country"
							data-ng-model="wareHouseDto.country" maxlength="50" readonly="readonly">
							
							</div>
							
						
						<!-- <div class="new-select-option">
								<select name="country" id="" wb-select2
									data-ng-model="wareHouseDto.country"
									data-ng-change="getStates(wareHouseDto.country)"
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
					
					<div
						data-ng-if="isInValidCountry==true && wareHouseDto.country.toString().length >0">Please
						choose valid Country</div>
					<div
						data-ng-show="new_wareHouse.$submitted || new_wareHouse.country.$touched" class="error_msg">
						<div data-ng-show="new_wareHouse.country.$error.required" class="error_msg">Please
							Select Country Name</div>
					</div> -->

					
						
						<div class="add_icon_asterisk">
						<label for="pwd">State</label>

							<div class="new-select-option">
								<select name="state" id="state1" wb-select2
									data-ng-model="wareHouseDto.state"
									data-ng-change="getCity(wareHouseDto.state,wareHouseDto.country)"
									required class="form-control"
									style="width: 100%; height: 36px;" tabindex="7">

									<option value="" selected>--- SELECT STATE ---</option>

									<option
										data-ng-repeat="x in stateEntityList track by x.stateName"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>	

					</div>
					
					<div
						ng-show="new_wareHouse.$submitted ||new_wareHouse.state.$touched" class="error_msg">
						<div ng-show="new_wareHouse.state.$error.required" class="error_msg">Please
							Select State</div>
					</div>

					
						
						<!-- <input list="city"
							class="form-control" id="city_List" name="city"
							placeholder="" ng-readonly="datareadonly" required
							data-ng-model="wareHouseDto.city" autocomplete="off">
							<i class="fa fa-asterisk" ></i>
						<datalist id="city" >
							<option ng-repeat="x in cityEntityList track by x.cityName"
								value="{{x.cityName}}">{{x.cityName}}</option>
								
						</datalist> -->
						
						<div class="add_icon_asterisk">
						<label for="pwd">City Name</label>
								
							<div class="new-select-option">
								<select name="city" id="city" wb-select2
									data-ng-model="wareHouseDto.city"
									required class="form-control"
									style="width: 100%; height: 36px;" tabindex="8">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in cityEntityList track by x.cityName"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
					</div>
					
					<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.city.$touched" class="error_msg">
						<div ng-show="new_wareHouse.city.$error.required" class="error_msg">Please
							Select City</div>
					</div>

					<%-- <div class="add_icon_asterisk">
						<label for="email">Pin Code:</label> 
						<input type="text" class="form-control" id="pinCode" name="pinCode"
							data-ng-model="wareHouseDto.pinCode" required maxlength="6" data-ng-minlength="6"
							numbersonly tabindex="9">
							<i class="fa fa-asterisk" ></i>
					</div>
					<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.pinCode.$touched" class="error_msg">
						<div ng-show="new_wareHouse.pinCode.$error.required" class="error_msg">Please
							enter Pincode</div>
						
					</div>
					<div ng-show="new_wareHouse.pinCode.toString().length<6"> Please
							enter Valid 6 digit Pin Code</div> --%>
							
							<div class="add_icon_asterisk">
						<label for="email">Pin Code:</label> <input type="text"
							class="form-control" id="pinCode" name="pinCode"
							data-ng-model="wareHouseDto.pinCode" maxlength="6" numbersonly maxlength="6" data-ng-minlength="6"
							required autocomplete="off" tabindex="9">
							<i class="fa fa-asterisk" ></i>
					</div>
                              <div data-ng-show="new_wareHouse.$submitted || new_wareHouse.pinCode.$touched" class="error_msg">
            <div data-ng-show="!new_wareHouse.pinCode.$valid" class="error_msg">Please Enter Valid 6 digit PinCode</div>
               </div>
					<div class="add_icon_asterisk">
						<label for="pwd">Effective Start Date:</label>


						<div class="input-group date" data-date-format="dd/mm/yyyy"
							data-date-today-highlight="true" data-date-autoclose="true"
							data-provide="datepicker">
							<div class="input-group-addon inner-addon right-addon ">
								<i class="fa fa-calendar"></i> <input type="text"
									class="form-control" placeholder="" id="effectiveStartDate"
									name="effectiveStartDate"
									data-ng-model="wareHouseDto.effectiveStartDate" readonly
									required data-ng-change="validateToDate()" tabindex="10">
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
						<label for="pwd"> Effective End Date:</label>


						<div class="input-group date" data-date-format="dd/mm/yyyy"
							data-date-today-highlight="true" data-date-autoclose="true"
							data-provide="datepicker">
							<div class="input-group-addon inner-addon right-addon ">
								<i class="fa fa-calendar"></i> <input type="text"
									class="form-control" placeholder="" id="effectiveEndDate"
									name="effectiveEndDate"
									data-ng-model="wareHouseDto.effectiveEndDate" readonly required data-ng-change="validateToDate()" tabindex="11">
							</div>
						</div>
						<i class="fa fa-asterisk" ></i>


						
					</div>
					<div
						ng-show="new_wareHouse.$submitted || new_wareHouse.effectiveEndDate.$touched" class="error_msg">
						<div ng-show="new_wareHouse.effectiveEndDate.$error.required" class="error_msg">
							Please Select Effective End Date Should Not Be Greater Than Effective Start Date</div>
					</div>


					
					<!-- <div
						ng-show="new_wareHouse.$submitted || new_wareHouse.status.$touched" class="error_msg">
						<div ng-show="new_wareHouse.status.$error.required" class="error_msg">Please
							Select Status</div>

					</div> -->
				</div>
				
				<div class="col-12 submit_col text-center">
									
							<button class="btn btn-primary" data-ng-click="saveWareHouse()"><i class="fa fa-check"></i> SAVE</button>
									
							<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
							
				</div>
				</form>
				</div>
			
		</div>
	</div>


<!-- Row -->
<!-- ============================================================== -->
		
		
		
		
		
		
		
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">WareHouse</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>WareHouse Name </th><td>{{view_warehouse_details.wareHouseName}}</td></tr>
							<tr><th>code</th><td>{{view_warehouse_details.code}}</td></tr>							
							<tr><th>City</th><td>{{view_warehouse_details.city}}</td></tr>
							<tr><th>Start Date</th><td>{{view_warehouse_details.effectiveStartDate}}</td></tr>
							<tr><th>End Date</th><td>{{view_warehouse_details.effectiveEndDate}}</td></tr>
							<tr><th>Status</th><td>{{view_warehouse_details.status}}</td></tr>
			</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>		
		
           
            <!-- ============================================================== -->
            <!-- Start Page Content EDIT WARE HOUSE -->
                <!-- ============================================================== -->
                <!-- Row -->
                <div data-ng-if="editWareHouse">
		<div class="form_section">
			<div class="form-content create_form">
				<h4 class="form_content_title">Edit WareHouse</h4>
				<form class="form-inline" method="post" name="edit_wareHouse" id="edit_wareHouse" data-ng-submit="saveWareHouse(edit_wareHouse.$valid)" novalidate>
					<div class="col-md-6 col_md text-center">
						<div class="add_icon_asterisk">
							<label for="email">WareHouse Name:</label> <input type="text"
								class="form-control" id="wareHouseName" name="wareHouseName"
								data-ng-model="wareHouseDto.wareHouseName" allowspacealphanum maxlength="50" required>
								<i class="fa fa-asterisk" ></i>
							
							<%-- <input type="hidden" class="form-control" id="id" name="id"
								data-ng-model="wareHouseDto.id"
								data-ng-init="wareHouseDto.id='${wareHouseDto.id}'" readonly> --%>
						</div>
						
						<div class="error_msg" data-ng-show="edit_wareHouse.$submitted || edit_wareHouse.wareHouseName.$touched" class="error_msg">
						<div  class="error_msg" data-ng-show="edit_wareHouse.wareHouseName.$error.required" class="error_msg">Please
							enter WareHouse Name</div>
					</div>
						<div class="add_icon_asterisk">
							<label for="pwd">Code:</label> 
							<input type="text" class="form-control" id="code" name="code" alphamumeric
								data-ng-model="wareHouseDto.code" maxlength="3" ng-change="getParentCode()"
								 required>
								<i class="fa fa-asterisk" ></i>
						</div>
						<div ng-show="edit_wareHouse.$submitted || edit_wareHouse.code.$touched" class="error_msg">
						<div ng-show="edit_wareHouse.code.$error.required" class="error_msg">Please
							enter code</div>
					</div>
						<div class="add_icon_asterisk">
							<label for="pwd">Parent Code:</label> <input type="text"
								class="form-control" id="parentCode" name="parentCode"
								data-ng-model="wareHouseDto.parentCode"
								 readonly>
								<i class="fa fa-asterisk" ></i>
						</div>
<!-- 						<div -->
<!-- 						ng-show="edit_wareHouse.$submitted || edit_wareHouse.parentCode.$touched" class="error_msg"> -->
<!-- 						<div ng-show="edit_wareHouse.parentCode.$error.required" class="error_msg">Please -->
<!-- 							enter parentCode</div> -->
<!-- 					</div> -->

						<div class="add_icon_asterisk">
							<label for="pwd">Address 1 :
							</label> <input type="text"	class="form-control" id="address1" name="address1" addressvalid
								data-ng-model="wareHouseDto.address1"
								 maxlength="50" required>
								<i class="fa fa-asterisk" ></i>
						</div>
						<div
						data-ng-show="edit_wareHouse.$submitted || edit_wareHouse.address1.$touched" class="error_msg">
						<div data-ng-show="edit_wareHouse.address1.$error.required" class="error_msg">Please
							enter Address1</div>
					</div>


						<div class="">
							<label for="pwd"> Address 2:</label> <input type="text" 
								class="form-control" id="address2" name="address2" addressvalid
								data-ng-model="wareHouseDto.address2"
								 maxlength="50">
						</div>
						<div class="">
							<label for="pwd"> Address 3:</label> <input type="text"
								class="form-control" id="address3" name="address3" addressvalid
								data-ng-model="wareHouseDto.address3"
								 maxlength="50">
						</div>
						<div class="">
							<label for="pwd"> Area / Landmark:</label> <input type="text"
								class="form-control" id="areaLandmark" name="areaLandmark" addressvalid
								data-ng-model="wareHouseDto.areaLandmark"
								 maxlength="50">
						</div>
					</div>
					<div class="col-md-6 col_md text-center">

						<div class="add_icon_asterisk">
						<label for="pwd">Country Name</label> 
						<input type="text"
							class="form-control" id="country1" name="country"
							data-ng-model="wareHouseDto.country" maxlength="50" readonly="readonly">
						
						<!-- <div class="new-select-option">
								<select name="country" id="country1" wb-select2
									data-ng-model="wareHouseDto.country"
									data-ng-change="getStates(wareHouseDto.country)"
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
						
						
						<div 
						data-ng-if="isInValidCountry==true && wareHouseDto.country.toString().length >0">Please
						choose valid Country</div>
					<div
						data-ng-show="edit_wareHouse.$submitted || edit_wareHouse.country.$touched" class="error_msg">
						<div data-ng-show="edit_wareHouse.country.$error.required" class="error_msg">Please
							Select Country Name</div>
					</div> -->
						
						</div>
						
						<div class="add_icon_asterisk">
						<label for="pwd">State</label>

							<div class="new-select-option">
								<select name="state" id="state1" wb-select2
									data-ng-model="wareHouseDto.state"
									data-ng-change="getCity(wareHouseDto.state,wareHouseDto.country)"
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
						
						
						<div
						ng-show="edit_wareHouse.$submitted ||edit_wareHouse.state.$touched" class="error_msg">
						<div ng-show="edit_wareHouse.state.$error.required" class="error_msg">Please
							Select State</div>
					</div>

						
						<div class="add_icon_asterisk">
						<label for="pwd">City Name</label>
								
							<div class="new-select-option">
								<select name="city" id="city" wb-select2
									data-ng-model="wareHouseDto.city"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in cityEntityList track by x.cityName"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>	
						<!-- <input list="city"
							class="form-control" id="city_List" name="city"
							placeholder="" data-ng-readonly="datareadonly"  required
							data-ng-model="wareHouseDto.city" autocomplete="off">
							<i class="fa fa-asterisk" ></i>
						<datalist id="city" > 
							<option ng-repeat="x in cityEntityList track by x.cityName"
								value="{{x.cityName}}">{{x.cityName}}</option>
						</datalist>-->
					</div>
					<div ng-show="edit_wareHouse.$submitted || edit_wareHouse.city.$touched" class="error_msg">
						<div ng-show="edit_wareHouse.city.$error.required" class="error_msg">Please
							Select City</div>
					</div>
						
						
						<div class="add_icon_asterisk">
						<label for="email">Pin Code:</label> <input type="text"
							class="form-control" id="pinCode" name="pinCode"
							data-ng-model="wareHouseDto.pinCode" maxlength="6" tabindex="11" numbersonly maxlength="6" data-ng-minlength="6"
							required autocomplete="off" >
							<i class="fa fa-asterisk" ></i>
					</div>
                              <div data-ng-show="edit_wareHouse.$submitted ||edit_wareHouse.pinCode.$touched" class="error_msg">
            <div data-ng-show="!edit_wareHouse.pinCode.$valid" class="error_msg">Please Enter Valid 6 digit PinCode</div>
               </div>
						<div class="add_icon_asterisk">
							<label for="pwd">Effective Start Date:</label> 
							
							
										<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="effectiveStartDate" data-ng-change="validateToDate()" name="effectiveStartDate" data-ng-model="wareHouseDto.effectiveStartDate"  readonly required>
                                                
                                            </div>
                                        </div>							
							<i class="fa fa-asterisk" ></i>

						</div>
											<div
						ng-show="edit_wareHouse.$submitted || edit_wareHouse.effectiveStartDate.$touched" class="error_msg">
						<div ng-show="edit_wareHouse.effectiveStartDate.$error.required" class="error_msg">Please
							Select Effective Start Date</div>
					</div>
						
						<div class="add_icon_asterisk">
							<label for="pwd">Effective End Date:</label> 
							
							
							
										<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="effectiveEndDate" data-ng-change="validateToDate()" name="effectiveEndDate" data-ng-model="wareHouseDto.effectiveEndDate"  readonly required>
                                                                                            </div>
                                        </div>
                                        <i class="fa fa-asterisk" ></i>							
						</div>

					<div
						ng-show="edit_wareHouse.$submitted || edit_wareHouse.effectiveEndDate.$touched" class="error_msg">
						<div ng-show="edit_wareHouse.effectiveEndDate.$error.required" class="error_msg">
						Please Select Effective End Date Should Not Be Greater Than Effective Start Date	</div>
					</div>
						
						<div class="add_icon_asterisk">
						<label for="email"> Status :</label>
						
						
						
						<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="wareHouseDto.status"  required class="with-gap" name="status" id="ACTIVE" value="ACTIVE" >
										<label for="ACTIVE" >ACTIVE</label>
										<input type="radio" data-ng-model="wareHouseDto.status"  required class="with-gap" name="status" id="INACTIVE" value="INACTIVE" >
										<label for="INACTIVE" >INACTIVE</label>
									</div>
									<i class="fa fa-asterisk" ></i>	
						
<%-- 						<input type="radio" data-ng-model="wareHouseDto.status" value="ACTIVE" ng-init="wareHouseDto.status='${wareHouseDto.status}'">ACTIVE --%>
<%-- 						<input type="radio" data-ng-model="wareHouseDto.status" value="INACTIVE" ng-init="wareHouseDto.status='${wareHouseDto.status}'" >INACTIVE --%>
						
						
						</div>
						


					<div class="">
						<!-- <label for="pwd">createdBy  :</label> -->
						<input type="hidden" class="form-control" id="createdBy"
							name="createdBy" data-ng-model="wareHouseDto.createdBy">
						<input type="hidden" class="form-control" id="creationDate"
							name="creationDate" data-ng-model="wareHouseDto.creationDate">
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
            
            <!-- Row -->
            <!-- ============================================================== -->






<jsp:include page="footer.jsp" />