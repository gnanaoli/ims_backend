<jsp:include page="header.jsp" />



<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid user-top"
	data-ng-controller="SupplierController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">SUPPLIER</h3>
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
			<h4 class="form_content_title">Create New Supplier</h4>
			<form class="form-inline" role="form" name="add_supplier"
				id="add_supplier" novalidate>
				<div class="col-md-6 col_md text-center">
					<div class="add_icon_asterisk">
						<label for="email">Supplier</label> <input type="text"
							class="form-control" id="supplierName" name="supplierName"
							data-ng-model="supplierDto.supplierName" required addressvalid
							autocomplete="off" tabindex="1">
						<i class="fa fa-asterisk" ></i>
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.supplierName.$touched"
						class="error_msg" class="error_msg">
						<div data-ng-show="add_supplier.supplierName.$error.required"
							class="error_msg" class="error_msg" class="error_msg">Please
							Enter Supplier Name</div>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd">Office  Country</label>
						
						
							<div class="new-select-option">
								<select name="country"
									data-ng-model="supplierDto.country"
									data-ng-change="getStates(supplierDto.country)"
									required class="select2 form-control" tabindex="2"
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
						data-ng-if="isInValidCountry==true && supplierDto.country.toString().length >0">Please
						choose valid Country</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.country.$touched"
						class="error_msg" class="error_msg">
						<div data-ng-show="add_supplier.country.$error.required"
							class="error_msg" class="error_msg">Please Select Country
							Name</div>
					</div>


					<div class="add_icon_asterisk">
						<label for="pwd">Office State</label> 
						
						
							<div class="new-select-option">
								<select name="state"
									data-ng-model="supplierDto.state"
									data-ng-change="getCity(supplierDto.state,supplierDto.country)"
									required class="select2 form-control" tabindex="3"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT STATE ---</option>

									<option
										data-ng-repeat="x in stateEntityList track by x.stateName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
						
					</div>
					<div
						ng-show="add_supplier.$submitted || add_supplier.state.$touched"
						class="error_msg" class="error_msg">
						<div ng-show="add_supplier.state.$error.required"
							class="error_msg" class="error_msg">Please Select State</div>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd">Office City</label> 
						
							<div class="new-select-option">
								<select name="city"
									data-ng-model="supplierDto.city"
									required class="select2 form-control" tabindex="4"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in cityEntityList track by x.cityName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
					</div>
					<div
						ng-show="add_supplier.$submitted || add_supplier.city.$touched"
						class="error_msg" class="error_msg">
						<div ng-show="add_supplier.city.$error.required" class="error_msg"
							class="error_msg">Please Select City</div>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd">Office Address 1 :</label> <input type="text"
							class="form-control" id="address1" name="address1" addressvalid
							data-ng-model="supplierDto.address1" required autocomplete="off"
							tabindex="5">
							<i class="fa fa-asterisk" ></i>
					</div>
					<div
						ng-show="add_supplier.$submitted || add_supplier.address1.$touched"
						class="error_msg" class="error_msg">
						<div ng-show="add_supplier.address1.$error.required"
							class="error_msg" class="error_msg">Please enter Address1</div>
					</div>
					<div class="">
						<label for="pwd">Office  Address 2:</label> <input type="text"
							class="form-control" id="address2" name="address2" addressvalid
							data-ng-model="supplierDto.address2" autocomplete="off"
							tabindex="6">
					</div>
					<div
						ng-show="add_supplier.$submitted || add_supplier.address2.$touched"
						class="error_msg" class="error_msg">
						<div ng-show="add_supplier.address2.$error.required"
							class="error_msg" class="error_msg">Please enter Address2</div>
					</div>

					<div class="">
						<label for="pwd"> Area / Landmark for Office :</label> <input type="text"
							class="form-control" id="area" name="area" addressvalid
							data-ng-model="supplierDto.area" autocomplete="off"
							tabindex="7">
					</div>
					<div
						ng-show="add_supplier.$submitted || add_supplier.area.$touched"
						class="error_msg" class="error_msg">
						<div ng-show="add_supplier.area.$error.required" class="error_msg"
							class="error_msg">Please enter Area</div>
					</div>

				
				
					<div class="add_icon_asterisk">
						<label for="email">Office Pin Code:</label> <input type="text"
							class="form-control" id="pinCode" name="pinCode"
							data-ng-model="supplierDto.pinCode" maxlength="6" numbersonly maxlength="6" data-ng-minlength="6"
							required autocomplete="off" tabindex="8">
							<i class="fa fa-asterisk" ></i>
					</div>
                              <div data-ng-show="add_supplier.$submitted || add_supplier.pinCode.$touched" class="error_msg">
            <div data-ng-show="!add_supplier.pinCode.$valid" class="error_msg">Please Enter Valid 6 digit PinCode</div>
               </div>
               
               
               
              
               <div class="add_icon_asterisk">
						<label for="pwd">Godown Country</label> 
						
						
						
							<div class="new-select-option">
								<select name="godownCountry" id="godownCountry"
									data-ng-model="supplierDto.godownCountry"
									data-ng-change="getGodownStates(supplierDto.godownCountry)"
									required class="select2 form-control" tabindex="9"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT COUNTRY ---</option>

									<option
										data-ng-repeat="x in countryDtoList track by x.countryName"
										value="{{x.countryName}}">{{x.countryName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
						
						
<!-- 						<input list="country" -->
<!-- 							class="form-control" id="country_List" name="country" -->
<!-- 							placeholder="" required -->
<!-- 							data-ng-model="supplierDto.country" -->
<!-- 							data-ng-change="getStates(supplierDto.country);" -->
<%-- 							data-ng-init="supplierDto.country='${lists[0].country}'" --%>
<!-- 							autocomplete="off" tabindex="2"> -->
<!-- 							<i class="fa fa-asterisk" ></i> -->
<!-- 						<datalist id="country"> -->
<!-- 							<option data-ng-repeat="x in countryDtoList track by x.countryName" -->
<!-- 								value="{{x.countryName}}">{{x.countryName}}</option> -->
<!-- 						</datalist> -->
						
						
					</div>
					<div
						data-ng-if="isInValidCountry==true && supplierDto.godownCountry.toString().length >0">Please
						choose valid Country</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.godownCountry.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.godownCountry.$error.required"
							class="error_msg">Please Select Godown  Country Name</div>
					</div>


					<div class="add_icon_asterisk">
						<label for="pwd">Godown State</label> 
						
						
							<div class="new-select-option">
								<select name="godownState" id="godownState"
									data-ng-model="supplierDto.godownState"
									data-ng-change="getGodownCity(supplierDto.godownState,supplierDto.godownCountry)"
									required class="select2 form-control" tabindex="10"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT STATE ---</option>

									<option
										data-ng-repeat="x in godownStateEntityList track by x.stateName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
						
						

					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.godownState.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.godownState.$error.required"
							class="error_msg">Please Select Godown  State</div>
					</div>
					<div class="add_icon_asterisk">
						<label for="pwd">Godown City</label> 
						
						
							<div class="new-select-option">
								<select name="godownCity" id="godownCity"
									data-ng-model="supplierDto.godownCity"
									required class="select2 form-control" tabindex="11"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- SELECT CITY ---</option>

									<option
										data-ng-repeat="x in godownCityEntityList track by x.cityName" data-ng-if="x.status == 'ACTIVE'"
										value="{{x.cityName}}">{{x.cityName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
						
						
						

					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.godownCity.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.godownCity.$error.required" class="error_msg">Please
							Select Godown City</div>
					</div>

					
</div>
               
                <div class="col-md-6 col_md text-center">
					
					<div class="add_icon_asterisk">
						<label for="pwd">Godown Address 1 :</label> <input type="text"
							class="form-control" id="godownAddress1" name="godownAddress1" addressvalid
							data-ng-model="supplierDto.godownAddress1"
							required
							autocomplete="off" tabindex="12">
							<i class="fa fa-asterisk" ></i>
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.godownAddress1.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.godownAddress1.$error.required"
							class="error_msg">Please Enter Godown Address1</div>
					</div>
					<div class="">
						<label for="pwd">Godown  Address 2:</label> <input type="text"
							class="form-control" id="godownAddress2" name="godownAddress2" addressvalid
							data-ng-model="supplierDto.godownAddress2"
							autocomplete="off" tabindex="13">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.godownAddress2.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.godownAddress2.$error.required"
							class="error_msg">Please enter Godown Address2</div>
					</div>
					<div class="">
						<label for="pwd"> Godown Area / Landmark:</label> <input type="text"
							class="form-control" id="godownArea" name="godownArea" addressvalid
							data-ng-model="supplierDto.godownArea"
							autocomplete="off" tabindex="14">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.godownArea.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.godownArea.$error.required" class="error_msg">Please
							enter Area</div>
					</div>

				
				

					<div class="add_icon_asterisk">
						<label for="email">Godown Pin Code:</label> 
						<input type="text"
							class="form-control" id="godownPinCode" name="godownPinCode"
							data-ng-model="supplierDto.godownPinCode"
							 maxlength="6" data-ng-minlength="6"
							numbersonly required autocomplete="off" tabindex="15">
							<i class="fa fa-asterisk" ></i>
					</div>
                              <div data-ng-show="add_supplier.$submitted || add_supplier.godownPinCode.$touched" class="error_msg">
            <div data-ng-show="!add_supplier.godownPinCode.$valid" class="error_msg">Please Enter Valid 6 digit PinCode</div>
               </div>
               
               
					<div class="">
						<label for="pwd">Contact Person:</label> <input type="text"
							class="form-control" id="contactPerson" name="contactPerson" contactman
							data-ng-model="supplierDto.contactPerson" 
							autocomplete="off" tabindex="16">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.contactPerson.$touched"
						class="error_msg" class="error_msg">
						<div data-ng-show="add_supplier.contactPerson.$error.required"
							class="error_msg" class="error_msg">Please enter Contact
							Person</div>
							</div>
              <div class="">

			<label for="pwd">STD Code :</label>
			<input type="text" class="form-control" id="stdCode" name="stdCode" data-ng-model="supplierDto.stdCode"  maxlength="5" numbersonly  data-ng-change="stdChange(manufacturerDto.stdCode)" ng-required="requiredStdTel" tabindex="17">
		  </div>
		  <div class="">
			<label for="pwd">Telephone No :</label>
			<input type="text" class="form-control" id="telePhoneNo" name="telePhoneNo" data-ng-model="supplierDto.telePhoneNo" data-ng-change="stdChange(supplierDto.telePhoneNo)" maxlength="8" numbersonly tabindex="18" ng-required="requiredStdTel">
			</div>
			<div data-ng-show="add_supplier.$submitted || add_supplier.stdCode.$touched || add_supplier.telePhoneNo.$touched"  class="error_msg">
			<div class="error_msg" data-ng-show="add_supplier.telePhoneNo.$error.required || add_supplier.stdCode.$error.required">
		Please Enter Std Code With Telephone Number 
			</div>
			</div> 
               
					<div class="">
						<label for="pwd"> Mobile No:</label> <input type="text"
							class="form-control" id="mobileNo" name="mobileNo" maxlength="10" data-ng-minlength="10"
							mobileNo data-ng-model="supplierDto.mobileNo" 
							autocomplete="off" tabindex="19">
					</div>
                              <div data-ng-show="add_supplier.$submitted || add_supplier.mobileNo.$touched" class="error_msg">
            <div data-ng-show="!add_supplier.mobileNo.$valid" class="error_msg">Please Enter Valid 10 digit Mobile Number</div>
               </div>
               
               <div class="">

			<label for="pwd">Std Code For Fax :</label>
			<input type="text" class="form-control" id="fax" name="fax" data-ng-model="supplierDto.fax"  maxlength="5" numbersonly tabindex="20" data-ng-change="faxChange(supplierDto.fax)" ng-required="requiredFaxfax1" >
         </div>
			<div class="">
			<label for="pwd">Fax No :</label>
			<input type="text" class="form-control" id="fax1" name="fax1" data-ng-model="supplierDto.fax1" data-ng-change="faxChange(supplierDto.fax1)" maxlength="10" numbersonly tabindex="21" ng-required="requiredFaxfax1" >
			</div>
			<div data-ng-show="add_supplier.$submitted || add_supplier.fax.$touched || add_supplier.fax1.$touched"  class="error_msg">
			<div class="error_msg" data-ng-show="add_supplier.fax.$error.required || add_supplier.fax1.$error.required">
			Please Enter Fax No with Fax Std Code 
			</div>
			</div>
					
					<div class="">
					<label for="pwd"> E-Mail Id:</label>
					<input type="email"  id="emailId" name="emailId" class="email" 
					data-ng-model="supplierDto.emailId" maxlength="50" autocomplete="off" tabindex="22">
													 
				</div>
				<div data-ng-show="add_supplier.$submitted || add_supplier.emailId.$touched" class="error_msg" class="error_msg">
				<div class="error_msg" data-ng-show="add_supplier.emailId.$error.email">
				Not a valid Email </div>
</div>
					<div class="add_icon_asterisk">
						<label for="pwd"> GST In:</label> <input type="text"
							class="form-control" id="gstIn" name="gstIn"
							data-ng-model="supplierDto.gstIn" autocomplete="off" data-ng-pattern="/^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[0-9]{1}[A-Z]{1}[0-9A-Z]{1}$/"
							tabindex="23" required data-ng-minlength="15"  maxlength="15" gstinvalid capitalize nospecialchar>
							<i class="fa fa-asterisk" ></i>
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.gstIn.$touched"
						class="error_msg" class="error_msg">
						<div data-ng-show="add_supplier.gstIn.$error.required"
							class="error_msg" class="error_msg">Please enter gstIn No</div>
							<div data-ng-show="add_supplier.gstIn.$error.pattern" class="error_msg"> please enter valid GST No</div>
					</div>
					
				
				
				
			</div>	
	
	<div class="col-12 submit_col text-center">

					<button class="btn btn-primary" id="" tabindex="24"
						data-ng-click="saveSupplier($event,add_supplier)">
						<i class="fa fa-check"></i>ADD
					</button>
					<span class="btn btn-warning" tabindex="25" data-ng-click="cancel()">
						<i class="fa fa-close"></i> CANCEL
					</span>
				</div>
	
	
			</form>
	</div>
	
	
		</div>
	</div>


<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />