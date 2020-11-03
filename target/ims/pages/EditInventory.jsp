 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="inventoryManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">INVENTORY MANAGEMENT</h3>
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
								<h4 class="form_content_title">Edit Inventory</h4>
								<form class="form-inline" name="NewInventory" id="NewInventory" novalidate>
									<div class="col-md-6 col_md text-center">
									<input type="hidden" class="form-control" id="address1" name="address1" data-ng-model="inventoryManagementDto.id" data-ng-init="inventoryManagementDto.id='${inventoryManagementDto.id}'">
									<input type="hidden" class="form-control" id="inventoryNumber" name="inventoryNumber" data-ng-model="inventoryManagementDto.inventoryNumber" data-ng-init="inventoryManagementDto.inventoryNumber='${inventoryManagementDto.inventoryNumber}'">
										<div class="">
											<label for="email">CategoryType</label>
										     <input
											list="category" class="form-control" 
											id="category_List" placeholder="categoryType" data-ng-readonly="datareadonly" required name="categoryType"
											data-ng-model="inventoryManagementDto.categoryType" data-ng-init="inventoryManagementDto.categoryType='${inventoryManagementDto.categoryType}'" data-ng-blur="getSubCategoryByCategory(inventoryManagementDto.categoryType)" required>
										<datalist id="category">
											<option
												data-ng-repeat="x in categoryMasterDtoList"
												value="{{x.categoryType}}">{{x.categoryType}}</option>
										</datalist>
										</div>
										<div data-ng-show="NewInventory.$submitted || NewInventory.categoryType.$touched" class="error_msg">
						                <div data-ng-show="NewInventory.categoryType.$error.required" class="error_msg">Please choose CategoryType</div>
					                  </div>
										<div class="">
											<label for="pwd">Sub Category</label>
										     <input
											list="subCategory" class="form-control" 
											id="subCategory_List" placeholder="subCategory" data-ng-readonly="datareadonly" required
											data-ng-model="inventoryManagementDto.subCategory" name="subCategory" data-ng-init="inventoryManagementDto.subCategory='${inventoryManagementDto.subCategory}'" name="city">
										<datalist id="subCategory">
											<option
												data-ng-repeat="x in subCategoryMasterDtoList"
												value="{{x.subCategory}}">{{x.subCategory}}</option>
										</datalist>
							        	</div> 
							        	<div data-ng-show="NewInventory.$submitted || NewInventory.subCategory.$touched" class="error_msg">
						                <div data-ng-show="NewInventory.subCategory.$error.required" class="error_msg">Please choose subCategoryType</div>
					                  </div>
										<div class="">
											<label for="pwd">Model Code </label>
											<input type="text" class="form-control" id="address1" name="modelCode" data-ng-model="inventoryManagementDto.modelCode" name="modelCode" required data-ng-init="inventoryManagementDto.modelCode='${inventoryManagementDto.modelCode}'" readOnly>
										</div>
										<div data-ng-show="NewInventory.$submitted || NewInventory.modelCode.$touched" class="error_msg">
						                <div data-ng-show="NewInventory.modelCode.$error.required" class="error_msg">Please enter modelCode</div>
					                    </div>
										<div class="">
											<label for="pwd">supplier Name</label>
										    <input
											list="supplier" class="form-control" 
											id="supplier_list" placeholder="supplierName" data-ng-readonly="datareadonly" name="supplierName" required 
											data-ng-model="inventoryManagementDto.supplierName" data-ng-init="inventoryManagementDto.supplierName='${inventoryManagementDto.supplierName}'">
										<datalist id="supplier">
											<option
												data-ng-repeat="x in supplierMaster track by x.supplierName"
												value="{{x.supplierName}}">{{x.supplierName}}</option>
										</datalist>
										</div>
										<div data-ng-show="NewInventory.$submitted || NewInventory.supplierName.$touched" class="error_msg">
						                <div data-ng-show="NewInventory.supplierName.$error.required" class="error_msg">Please choose supplierName</div>
					                    </div>
										<div class="">
											<label for="pwd">Manufacturer Name</label>
											<input
											list="manufacturer" class="form-control" 
											id="manufacturer_list" placeholder="manufactuerName" data-ng-readonly="datareadonly" name="manufacturerName" required 
											data-ng-model="inventoryManagementDto.manufacturerName" name="manufacturerName" data-ng-init="inventoryManagementDto.manufacturerName='${inventoryManagementDto.manufacturerName}'">
										<datalist id="manufacturer">
											<option
												data-ng-repeat="x in activeManufacturerList track by x.name"
												value="{{x.name}}">{{x.name}}</option>
										</datalist>
										</div>
										<div data-ng-show="NewInventory.$submitted || NewInventory.manufacturerName.$touched" class="error_msg">
						                <div data-ng-show="NewInventory.manufacturerName.$error.required" class="error_msg">Please choose manufacturerName</div>
					                    </div>
										<div class="">
												<label for="pwd"> Quantity</label>
												<input type="text" class="form-control" id="address2" data-ng-model="inventoryManagementDto.quantity" name="quantity" required  data-ng-init="inventoryManagementDto.quantity='${inventoryManagementDto.quantity}'">
										</div>
										<div data-ng-show="NewInventory.$submitted || NewInventory.quantity.$touched" class="error_msg">
						                <div data-ng-show="NewInventory.quantity.$error.required" class="error_msg">Please enter quantity</div>
					                    </div>
										<div class="">
												<label for="pwd"> purchase Cost INR:</label>
												<input type="text" class="form-control"   data-ng-model="inventoryManagementDto.purchaseCost"  name="purchaseCost" required numbersonly data-ng-init="inventoryManagementDto.purchaseCost='${inventoryManagementDto.purchaseCost}'">
										</div>
										<div data-ng-show="NewInventory.$submitted || NewInventory.purchaseCost.$touched" class="error_msg">
						                <div data-ng-show="NewInventory.purchaseCost.$error.required" class="error_msg">Please enter purchaseCost</div>
					                    </div>
									</div>
									<div class="col-md-6 col_md text-center">
											<div class="">
												<label for="email">purchase Date:</label>
												
										<div class="input-group date" data-date-format="mm/dd/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="purchaseDate" name="purchaseDate" required data-ng-model="inventoryManagementDto.purchaseDate" data-ng-init="inventoryManagementDto.purchaseDate='${inventoryManagementDto.purchaseDate}'" readonly required>
                                            </div>
                                        </div>
												
												
<%-- 												<input type="text" class="form-control dd" id="purchaseDate" name="purchaseCost" required data-ng-model="inventoryManagementDto.purchaseDate" data-ng-init="inventoryManagementDto.purchaseDate='${inventoryManagementDto.purchaseDate}'"> --%>
											</div>
											<div data-ng-show="NewInventory.$submitted || NewInventory.purchaseDate.$touched" class="error_msg">
						                    <div data-ng-show="NewInventory.purchaseDate.$error.required" class="error_msg">Please enter purchaseCost</div>
					                        </div>
											<div class="">
												<label for="email">Warranty Period:</label>
												
												
									<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="inventoryManagementDto.isWarrantyPeriodApplicable" data-ng-init="inventoryManagementDto.isWarrantyPeriodApplicable='${inventoryManagementDto.isWarrantyPeriodApplicable}'" data-ng-change="isWarrantySelected(inventoryManagementDto.isWarrantyPeriodApplicable)" required class="with-gap" name="isWarrantyPeriodApplicable" id="YES" value="YES" >
										<label for="YES" >YES</label>
										<input type="radio" data-ng-model="inventoryManagementDto.isWarrantyPeriodApplicable" data-ng-init="inventoryManagementDto.isWarrantyPeriodApplicable='${inventoryManagementDto.isWarrantyPeriodApplicable}'" data-ng-change="isWarrantySelected(inventoryManagementDto.isWarrantyPeriodApplicable)" required class="with-gap" name="isWarrantyPeriodApplicable" id="NO" value="NO" >
										<label for="NO">NO</label>
									</div>

											
<%-- 												<input type="radio" data-ng-model="inventoryManagementDto.isWarrantyPeriodApplicable" name="isWarrantyPeriodApplicable" required value="YES" data-ng-init="inventoryManagementDto.isWarrantyPeriodApplicable='${inventoryManagementDto.isWarrantyPeriodApplicable}'" data-ng-change="isWarrantySelected(inventoryManagementDto.isWarrantyPeriodApplicable)">YES --%>
<%-- 												<input type="radio" data-ng-model="inventoryManagementDto.isWarrantyPeriodApplicable"  name="isWarrantyPeriodApplicable" required value="NO" data-ng-init="inventoryManagementDto.isWarrantyPeriodApplicable='${inventoryManagementDto.isWarrantyPeriodApplicable}'"  data-ng-change="isWarrantySelected(inventoryManagementDto.isWarrantyPeriodApplicable)">NO --%>

											</div>
											<div data-ng-show="NewInventory.$submitted || NewInventory.isWarrantyPeriodApplicable.$touched" class="error_msg">
						                    <div data-ng-show="NewInventory.isWarrantyPeriodApplicable.$error.required" class="error_msg">Please choose isWarrantyPeriodApplicable</div>
					                        </div>
											<div class="" data-ng-if="inventoryManagementDto.isWarrantyPeriodApplicable=='YES'">
											<label for="email">Warranty expiry Date:</label>
											
											
											<div class="input-group date" data-date-format="mm/dd/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" name="warrantyPeriod" data-ng-model="inventoryManagementDto.warrantyPeriod" id="warrantyPeriod" data-ng-init="inventoryManagementDto.warrantyPeriod='${inventoryManagementDto.warrantyPeriod}'" readonly required>
                                            </div>
                                        </div>											
											</div>
								    <div class="new-radio-button-inline">
										<input type="hidden" data-ng-model="inventoryManagementDto.location" name="location" required data-ng-init="inventoryManagementDto.location='${inventoryManagementDto.location}'" value="WAREHOUSE" data-ng-change="location(inventoryManagementDto.location)" id="WAREHOUSE" class="with-gap">
									</div>
										<div class="" data-ng-if="inventoryManagementDto.location=='WAREHOUSE'">
											<label for="email">if wareHouse Site</label>
											<input
											list="wareHouse" class="form-control" 
											id="wareHouse_List" placeholder="wareHouse" data-ng-readonly="datareadonly" name="site" required
											data-ng-model="inventoryManagementDto.site" data-ng-init="inventoryManagementDto.site='${inventoryManagementDto.location=='WAREHOUSE'?inventoryManagementDto.site:''}'">
										<datalist id="wareHouse">
											<option
												data-ng-repeat="x in activeWareHouseList track by x.wareHouseName"
												value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>
										</datalist>
										</div>
										<div data-ng-if="enableWareHouseSite || enableProjectSite">
										<div data-ng-show="NewInventory.$submitted || NewInventory.site.$touched && enableProjectSite">
						                <div data-ng-show="NewInventory.site.$error.required" class="error_msg">Please choose project</div>
					                    </div>
					                    </div>
										</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="editInventoryManagement()"><i class="fa fa-check"></i> SAVE</button>
											<button class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</button>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />	