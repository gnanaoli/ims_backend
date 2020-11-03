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
									<div class="col-md-6 col_md text-center">
									<input type="hidden" class="form-control" id="address1" name="address1" data-ng-model="inventoryManagementDto.id" data-ng-init="inventoryManagementDto.id='${confirmInventoryAssignDto.id}'">
										<div class="">
												<label for="pwd">Category Type</label>
												<input type="text" class="form-control" id="address2" name="categoryType" data-ng-model="inventoryManagementDto.categoryType"  required  data-ng-init="inventoryManagementDto.categoryType='${confirmInventoryAssignDto.category}'" readOnly>
										</div>
										<div class="">
												<label for="pwd">SubCategory</label>
												<input type="text" class="form-control" id="subCategory" name="subCategory" data-ng-model="inventoryManagementDto.subCategory"  required  data-ng-init="inventoryManagementDto.subCategory='${confirmInventoryAssignDto.subCategory}'" readOnly>
										</div>
										<div class="">
											<label for="pwd">Model Code </label>
											<input type="text" class="form-control" id="address1" name="modelCode" data-ng-model="inventoryManagementDto.modelCode" name="modelCode" required data-ng-init="inventoryManagementDto.modelCode='${confirmInventoryAssignDto.modelCode}'" readOnly>
										</div>
										<div class="">
												<label for="pwd">Quantity</label>
												<input type="text" class="form-control" id="address2" name="quantity" data-ng-model="inventoryManagementDto.quantity" name="quantity" required  data-ng-init="inventoryManagementDto.quantity='${confirmInventoryAssignDto.quantity}'" readOnly>
										</div>
										 <div class="">
												<label for="pwd">From site</label>
												<input type="text" class="form-control" id="site" name="site" data-ng-model="inventoryManagementDto.site"  data-ng-init="inventoryManagementDto.site='${confirmInventoryAssignDto.requestedFrom}'" readOnly>
										</div>
										<div class="">
												<label for="pwd">To wareHouse</label>
												<input type="text" class="form-control" id="requestedLocation" name="requestedLocation" data-ng-model="inventoryManagementDto.requestedLocation"  data-ng-init="inventoryManagementDto.requestedLocation='${confirmInventoryAssignDto.requestedTo}'" readOnly>
										</div>
										<div class="">
												<label for="pwd">Comments : </label>
												<input type="text" class="form-control" id="comments" name="comments" data-ng-model="inventoryManagementDto.comments" >
										</div>
										
					                    <div class="">
												<input type="hidden" class="form-control" data-ng-model="inventoryManagementDto.location" data-ng-init="inventoryManagementDto.location='${confirmInventoryAssignDto.location}'">
										</div>
										<div class="">
												<input type="hidden" class="form-control" data-ng-model="inventoryManagementDto.action" data-ng-init="inventoryManagementDto.action='${confirmInventoryAssignDto.status}'">
										</div>
									</div>
									<div class="col-md-6 col_md text-center">
										</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="ConfirmMoveInventoryFromProject()"><i class="fa fa-arrow-left"></i> CONFIRM</button>
											<button class="btn btn-warning"><i class="fa fa-close"></i> REJECT</button>
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