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
	data-ng-controller="SupplierController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">SUPPLIER MANAGEMENT</h3>
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
			<h4 class="form_content_title">Edit Supplier</h4>
			<form class="form-inline" name="add_supplier" role="form" novalidate>
				<div class="col-md-6 col_md text-center">
					<div class="add_icon_asterisk">
						<label for="email">Supplier</label> <input type="text"
							class="form-control" id="supplierName" name="supplierName"
							data-ng-model="supplierDto.supplierName"
							data-ng-init="supplierDto.supplierName='${lists[0].supplierName}'"
							readonly required autocomplete="off" nospecialchar tabindex="1"> 
							<i class="fa fa-asterisk" ></i>
							
							<input
							type="hidden" class="form-control" id="id" name="id"
							data-ng-model="supplierDto.id"
							data-ng-init="supplierDto.id='${lists[0].id}'" required>
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.supplierName.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.supplierName.$error.required"
							class="error_msg">Please enter Supplier Name</div>
					</div>


					<div class="add_icon_asterisk">
						<label for="pwd">Country</label> <input list="country"
							class="form-control" id="country_List" name="country"
							placeholder="" required
							data-ng-model="supplierDto.country"
							data-ng-change="getStates(supplierDto.country);"
							data-ng-init="supplierDto.country='${lists[0].country}'"
							autocomplete="off" tabindex="2">
							<i class="fa fa-asterisk" ></i>
						<datalist id="country">
							<option data-ng-repeat="x in countryDtoList track by x.countryName"
								value="{{x.countryName}}">{{x.countryName}}</option>
						</datalist>
					</div>
					<div
						data-ng-if="isInValidCountry==true && supplierDto.country.toString().length >0">Please
						choose valid Country</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.country.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.country.$error.required"
							class="error_msg">Please enter Country Name</div>
					</div>


					<div class="add_icon_asterisk">
						<label for="pwd">State</label> <input list="state"
							class="form-control" id="state_List" name="state"
							placeholder="" data-ng-readonly="datareadonly" required
							data-ng-model="supplierDto.state"
							data-ng-blur="getCity(supplierDto.state,supplierDto.country)"
							data-ng-init="supplierDto.state='${lists[0].state}'"
							autocomplete="off" tabindex="3">
							<i class="fa fa-asterisk" ></i>
						<datalist id="state">
							<option
								data-ng-repeat="x in stateEntityList track by x.stateName"
								value="{{x.stateName}}">{{x.stateName}}</option>
						</datalist>

					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.state.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.state.$error.required"
							class="error_msg">Please enter State</div>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd">City</label> <input list="city"
							class="form-control" id="city_List" name="city"
							placeholder="" required
							data-ng-model="supplierDto.city"
							data-ng-init="supplierDto.city='${lists[0].city}'"
							autocomplete="off" tabindex="4">
							<i class="fa fa-asterisk" ></i>
						<datalist id="city">
							<option data-ng-repeat="x in cityEntityList track by x.cityName"
								value="{{x.cityName}}">{{x.cityName}}</option>
						</datalist>
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.city.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.city.$error.required" class="error_msg">Please
							enter City</div>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd">Address 1 :</label> <input type="text"
							class="form-control" id="address1" name="address1"
							data-ng-model="supplierDto.address1"
							data-ng-init="supplierDto.address1='${lists[0].address1}'" required
							autocomplete="off" tabindex="5">
							<i class="fa fa-asterisk" ></i>
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.address1.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.address1.$error.required"
							class="error_msg">Please enter Address1</div>
					</div>
					<div class="">
						<label for="pwd"> Address 2:</label> <input type="text"
							class="form-control" id="address2" name="address2"
							data-ng-model="supplierDto.address2"
							data-ng-init="supplierDto.address2='${lists[0].address2}'" 
							autocomplete="off" tabindex="6">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.address2.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.address2.$error.required"
							class="error_msg">Please enter Address2</div>
					</div>
					<div class="">
						<label for="pwd"> Area / Landmark:</label> <input type="text"
							class="form-control" id="area" name="area"
							data-ng-model="supplierDto.area"
							data-ng-init="supplierDto.area='${lists[0].area}'" 
							autocomplete="off" tabindex="7">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.area.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.area.$error.required" class="error_msg">Please
							enter Area</div>
					</div>

				</div>
				<div class="col-md-6 col_md text-center">

					<div class="add_icon_asterisk">
						<label for="email">Pin Code:</label> <input type="text"
							class="form-control" id="pinCode" name="pinCode"
							data-ng-model="supplierDto.pinCode"
							data-ng-init="supplierDto.pinCode='${lists[0].pinCode}'" maxlength="6" data-ng-minlength="6"
							numbersonly required autocomplete="off" tabindex="8">
							<i class="fa fa-asterisk" ></i>
					</div>
                              <div data-ng-show="add_supplier.$submitted || add_supplier.pinCode.$touched" class="error_msg">
            <div data-ng-show="!add_supplier.pinCode.$valid" class="error_msg">Please Enter Valid 6 digit PinCode</div>
               </div>

					<div class="">
						<label for="pwd">Contact Person:</label> <input type="text"
							class="form-control" id="contactPerson" name="contactPerson"
							data-ng-model="supplierDto.contactPerson"
							data-ng-init="supplierDto.contactPerson='${lists[0].contactPerson}'"
							 autocomplete="off" tabindex="9">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.contactPerson.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.contactPerson.$error.required"
							class="error_msg">Please enter Contact Person</div>
					</div>

					<div class="">
						<label for="pwd">TelePhone No :</label> <input type="text"
							class="form-control" id="telePhoneNo" name="telePhoneNo"
							data-ng-model="supplierDto.telePhoneNo"
							data-ng-init="supplierDto.telePhoneNo='${lists[0].telePhoneNo}'"
							maxlength="11" data-ng-minlength="7"  numbersonly autocomplete="off"
							tabindex="10">
					</div>
                              <div data-ng-show="add_supplier.$submitted || add_supplier.telePhoneNo.$touched" class="error_msg">
            <div data-ng-show="!add_supplier.telePhoneNo.$valid" class="error_msg">Please Enter Valid TelePhone Number</div>
               </div>

					<div class="">
						<label for="pwd"> Mobile No:</label> <input type="text"
							class="form-control" id="mobileNo" name="mobileNo" maxlength="10" data-ng-minlength="10"
							mobileno data-ng-model="supplierDto.mobileNo"
							data-ng-init="supplierDto.mobileNo='${lists[0].mobileNo}'" 
							autocomplete="off" tabindex="11">
					</div>
                              <div data-ng-show="add_supplier.$submitted || add_supplier.mobileNo.$touched" class="error_msg">
            <div data-ng-show="!add_supplier.mobileNo.$valid" class="error_msg">Please Enter Valid 10 digit Mobile Number</div>
               </div>


					<div class="">
						<label for="pwd"> Fax:</label> <input type="text"
							class="form-control" id="fax" name="fax"
							data-ng-model="supplierDto.fax" maxlength="10" data-ng-minlength="10"
							data-ng-init="supplierDto.fax='${lists[0].fax}'" 
							autocomplete="off" tabindex="12">
					</div>
                              <div data-ng-show="add_supplier.$submitted || add_supplier.fax.$touched" class="error_msg">
            <div data-ng-show="!add_supplier.fax.$valid" class="error_msg">Please Enter Valid 10 Fax number</div>
               </div>
					<div class="">
						<label for="pwd"> E-Mail Id:</label> <input type="email"
							class="form-control" id="emailId" name="emailId"
							data-ng-model="supplierDto.emailId"
							data-ng-init="supplierDto.emailId='${lists[0].emailId}'" 
							autocomplete="off" tabindex="13">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.emailId.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.emailId.$error.required"
							class="error_msg">Please enter E-mailid</div>
						<div class="error_msg" data-ng-show="add_supplier.emailId.$error.email">
							Not a valid Email </div>

					</div>
					<div class="">
						<label for="pwd"> GST IN:</label> <input type="text"
							class="form-control" id="gstIn" name="gstIn"
							data-ng-model="supplierDto.gstIn"
							data-ng-init="supplierDto.gstIn='${lists[0].gstIn}'" 
							autocomplete="off" tabindex="14">
					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.gstIn.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.gstIn.$error.required"
							class="error_msg">Please enter GST No</div>
					</div>
					<div class="">
						<label for="pwd"> Status:</label>

						<div class="new-radio-button-inline">
							<input type="radio" data-ng-model="supplierDto.status"
								data-ng-init="supplierDto.status='${lists[0].status}'" required
								class="with-gap" name="status" id="ACTIVE" value="ACTIVE"
								tabindex="15"> <label for="ACTIVE">ACTIVE</label> <input
								type="radio" data-ng-model="supplierDto.status"
								data-ng-init="supplierDto.status='${lists[0].status}'" required
								class="with-gap" name="status" id="INACTIVE" value="INACTIVE"
								tabindex="16"> <label for="INACTIVE">INACTIVE</label>
						</div>

						<div
							data-ng-show="add_supplier.$submitted || add_supplier.status.$touched"
							class="error_msg">
							<div data-ng-show="add_supplier.status.$error.required"
								class="error_msg">Please select the status</div>
						</div>


					</div>
					<div
						data-ng-show="add_supplier.$submitted || add_supplier.gstIn.$touched"
						class="error_msg">
						<div data-ng-show="add_supplier.gstIn.$error.required"
							class="error_msg">Please enter GST No</div>
					</div>
				</div>
				<div class="col-12 submit_col text-center">
					<button class="btn btn-primary"
						data-ng-click="saveSupplier($event,add_supplier)">
						<i class="fa fa-check"></i> SAVE
					</button>
					<span class="btn btn-warning" data-ng-click="cancel()">
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

<script>
// 	$(document).ready(function() {

// 		var data = {
// 			id : '<c:out value="${lists[0].state}" />',
// 			text : '<c:out value="${lists[0].state}" />'
// 		};

// 		if ($('#state_List1').find("option[value='" + data.id + "']").length) {
// 			$('#state_List1').val(data.id).trigger('change');
// 		} else {
// 			// Create a DOM Option and pre-select by default
// 			var newOption = new Option(data.text, data.id, true, true);
// 			// Append it to the select
// 			$('#state_List1').append(newOption).trigger('change');
// 		}

// 	});
</script>

