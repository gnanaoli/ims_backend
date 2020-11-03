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
								<h4 class="form_content_title">Move Inventory</h4>
								<form class="form-inline" name="moveInventory" id="moveInventory" novalidate>
								<div class="col-md-2"></div>
									<div class="col-md-8 col_md text-center">
									<input type="hidden" class="form-control" id="address1" name="address1" data-ng-model="inventoryManagementDto.id" data-ng-init="inventoryManagementDto.id='${inventoryAssignDto.id}'">
										<div class="">
												<label for="pwd">Category Type</label>
												<input type="text" class="form-control" id="address2" name="categoryType" data-ng-model="inventoryManagementDto.categoryType"  required  data-ng-init="inventoryManagementDto.categoryType='${inventoryAssignDto.category}'" readOnly>
										</div>
										<div class="">
												<label for="pwd">SubCategory</label>
												<input type="text" class="form-control" id="subCategory" name="subCategory" data-ng-model="inventoryManagementDto.subCategory"  required  data-ng-init="inventoryManagementDto.subCategory='${inventoryAssignDto.subCategory}'" readOnly>
										</div>
										<div class="">
											<label for="pwd">Model Code </label>
											<input type="text" class="form-control" id="address1" name="modelCode" data-ng-model="inventoryManagementDto.modelCode" name="modelCode" required data-ng-init="inventoryManagementDto.modelCode='${inventoryAssignDto.modelCode}'" readOnly>
										</div>
										<div class="">
												<label for="pwd">Available Quantity</label>
												<input type="text" class="form-control" id="address2" name="quantity" data-ng-model="inventoryManagementDto.quantity" name="quantity" required  data-ng-init="inventoryManagementDto.quantity='${inventoryAssignDto.availableQty}'" readOnly>
										</div>
					                    <div class="add_icon_asterisk">
												<label for="pwd">Quantity to be moved:</label>
												<input type="text" class="form-control" id="quantityToBeMoved" name="quantityToBeMoved" data-ng-model="inventoryManagementDto.quantityToBeMoved" name="quantityToBeMoved" data-ng-blur="checkQuantityMoveForMovePage(inventoryManagementDto.quantityToBeMoved)"  required>
												<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="moveInventory.$submitted || moveInventory.quantityToBeMoved.$touched" class="error_msg">
						                <div data-ng-show="moveInventory.quantityToBeMoved.$error.required" class="error_msg">Please enter Quantity to be moved</div>
					                    </div>
										 <div class="">
										 
												<label for="pwd">From Project Site</label>
												<input type="text" class="form-control" id="site" name="site" data-ng-model="inventoryManagementDto.requestedFrom"  data-ng-init="inventoryManagementDto.requestedFrom='${inventoryAssignDto.assignedLocation}'" readOnly>
										</div>
					                    <div class="add_icon_asterisk">
												<label for="pwd">ACTION</label>
                                                 <select  name="action" class="form-control" data-ng-model="inventoryManagementDto.action" data-ng-options="item for item in actionList" data-ng-change="checkIfvehicle(inventoryManagementDto.action)" required>
                                                 <option value="">--select--</option>
												</select>
												<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="moveInventory.$submitted || moveInventory.action.$touched" class="error_msg">
						                <div data-ng-show="moveInventory.action.$error.required" class="error_msg">Please select action</div>
					                    </div>
					                   <%-- <div class="">
											<label for="email">To WareHouse</label>
											<input type="text" class="form-control" id="site" name="site" data-ng-model="inventoryManagementDto.requestedTo"  data-ng-init="inventoryManagementDto.requestedTo='${inventoryAssignDto.warehouseOrSitename}'" readOnly>
										</div>  --%> 
										  <div class="add_icon_asterisk">
											<label for="email">WareHouse</label>
											<input
											list="wareHouse" class="form-control" 
											id="wareHouse_List" placeholder="" data-ng-readonly="datareadonly" required name="requestedTo" 
											data-ng-model="inventoryManagementDto.requestedTo" autocomplete="off">
											<i class="fa fa-asterisk" ></i>
										<datalist id="wareHouse">
											<option
												data-ng-repeat="x in activeWareHouseList track by x.wareHouseName"
												value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>
										</datalist>
										</div>
										<div data-ng-show="moveInventory.$submitted || moveInventory.requestedTo.$touched" class="error_msg">
						                <div data-ng-show="moveInventory.requestedTo.$error.required" class="error_msg">Please choose wareHouse</div>
					                    </div> 
										
										
										
										<div class="">
												<label for="pwd">Comments : </label>
												<input type="text" class="form-control" id="comments" name="comments" data-ng-model="inventoryManagementDto.comments"  maxlength="50">
										</div>
					                    <div class="">
												<input type="hidden" class="form-control" data-ng-model="inventoryManagementDto.inventoryLocation" data-ng-init="inventoryManagementDto.inventoryLocation='${inventoryAssignDto.inventoryLocation}'">
										</div>
									
									
									<div class="" data-ng-if="showRadio">
												<label for="email">are you moving this through vehicle ?</label>
												
												
									<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="inventoryManagementDto.challanStatus"  required class="with-gap" autocomplete="off" name="challanStatus" id="YES" value="YES" >
										<label for="YES" >YES</label>
										<input type="radio" data-ng-model="inventoryManagementDto.challanStatus"  required class="with-gap" autocomplete="off" name="challanStatus" id="NO" value="NO" >
										<label for="NO">NO</label>
									</div>
									<div data-ng-show="moveInventory.$submitted || moveInventory.challanStatus.$touched" class="error_msg">
						                    <div data-ng-show="moveInventory.challanStatus.$error.required" class="error_msg">Please choose yes or no</div>
					                        </div>
											</div>
											</div>
									
									
									<div class="col-md-2"></div>
									 
										<div class="col-md-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="RequestInventoryToMoveFromProject()"><i class="fa fa-arrow-right"></i> MOVE</button>
											<button class="btn btn-warning" data-ng-click="cancelMove()"><i class="fa fa-close"></i> CANCEL</button>
										</div>
										
									
									</div>								
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />


<script type="text/javascript">

$( document ).ready(function() {
	 $('.dd').datetimepicker({
		    language:  'en',
		    weekStart: 0,
		    todayHighlight: 0,
		    autoclose: true,
			 startView: 2,
			 minView: 2,
			 forceParse: 0,
			format:'dd/mm/yyyy'
		 });
});
	 
	 </script>	
