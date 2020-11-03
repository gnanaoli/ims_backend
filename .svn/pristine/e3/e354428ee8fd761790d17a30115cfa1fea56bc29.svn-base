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
                        <h3 class="text-themecolor">Assign Inventory</h3>
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
								<h4 class="form_content_title">Assign Inventory</h4>
								<form class="form-inline" name="AssignInventory" id="AssignInventory" novalidate>
								<div class="row">
									<div class="col-md-6 col_md text-center">
									<input type="hidden" class="form-control" id="id" name="id" data-ng-model="inventoryManagementDto.id" data-ng-init="inventoryManagementDto.id='${inventoryManagementDto.id}'">
									<input type="hidden" class="form-control" id="site" name="site" data-ng-model="inventoryManagementDto.site" data-ng-init="inventoryManagementDto.site='${inventoryManagementDto.site}'" readonly>
										<div class="">
										<label for="pwd">Category Type</label>
											<input type="text" class="form-control" id="address1" name="address1" data-ng-model="inventoryManagementDto.categoryType" data-ng-init="inventoryManagementDto.categoryType='${inventoryManagementDto.categoryType}'" readonly tabindex="1">
										</div>
					                  
										<div class="">
											<label for="pwd">Sub Category</label>
											<input type="text" class="form-control" tabindex="2" id="address1" name="address1" data-ng-model="inventoryManagementDto.subCategory" data-ng-init="inventoryManagementDto.subCategory='${inventoryManagementDto.subCategory}'" readonly>
							        	</div> 
					                 
										<div class="">
											<label for="pwd">Model Code </label>
											<input type="text" class="form-control" id="address1" tabindex="3" name="modelCode" data-ng-model="inventoryManagementDto.modelCode" name="modelCode" required data-ng-init="inventoryManagementDto.modelCode='${inventoryManagementDto.modelCode}'" readOnly>
										</div>
										<div class="">
											<label for="pwd">supplier Name</label>
										   <input type="text" class="form-control" id="address1" name="address1" tabindex="4" data-ng-model="inventoryManagementDto.supplierName" data-ng-init="inventoryManagementDto.supplierName='${inventoryManagementDto.supplierName}'" readonly>
										</div>
										
																			
									<div class="">
											<label for="pwd">Manufacturer Name</label>
											 <input type="text" class="form-control" id="address1" name="address1" tabindex="5" data-ng-model="inventoryManagementDto.manufacturerName" data-ng-init="inventoryManagementDto.manufacturerName='${inventoryManagementDto.manufacturerName}'" readonly>
										</div>
										
										<div class="">
												<label for="pwd">Available Quantity</label>
												<input type="text" class="form-control" id="address2" tabindex="6" data-ng-model="inventoryManagementDto.quantity" name="quantity" required  data-ng-init="inventoryManagementDto.quantity='${inventoryManagementDto.quantity}'"readonly>
										</div>
										<div data-ng-show="AssignInventory.$submitted || AssignInventory.quantity.$touched" class="error_msg">
						                <div data-ng-show="AssignInventory.quantity.$error.required" class="error_msg">Please enter quantity</div>
					                    </div>
										</div>
									<div class="col-md-6 col_md text-center">

	                                    <div class="">
												<label for="pwd">Allocatable Quantity</label>
												<input type="text" class="form-control" id="allocatableQuantity" tabindex="7" data-ng-model="inventoryManagementDto.allocatableQuantity" name="allocatableQuantity"  data-ng-blur="checkQuantityLeftOver(inventoryManagementDto.allocatableQuantity)"required>
										</div>
										<div data-ng-show="AssignInventory.$submitted || AssignInventory.allocatableQuantity.$touched" class="error_msg">
						                <div data-ng-show="AssignInventory.allocatableQuantity.$error.required" class="error_msg">Please enter quantity</div>
					                    </div>



					                    <div class="">
												<label for="pwd">Left Over Quantity</label>
												<input type="text" class="form-control" id="leftOverQuantity" tabindex="8" data-ng-model="inventoryManagementDto.leftOverQuantity" name="leftOverQuantity" readonly>
										</div>
										 <div class="">
												<label for="pwd">Asset Number</label>
												<input type="text" class="form-control" id="inventoryNumber" tabindex="9" data-ng-model="inventoryManagementDto.inventoryNumber" name="inventoryNumber" data-ng-init="inventoryManagementDto.inventoryNumber='${inventoryManagementDto.inventoryNumber}'" readonly required>
										</div>
											<div class="">
												<label for="email">purchase Date:</label>
                                                 <input type="text" class="form-control" placeholder="" id="purchaseDate" tabindex="10" name="purchaseDate" required data-ng-model="inventoryManagementDto.purchaseDate" data-ng-init="inventoryManagementDto.purchaseDate='${inventoryManagementDto.purchaseDate}'" readonly required>
											</div>
											<div data-ng-show="AssignInventory.$submitted || AssignInventory.purchaseDate.$touched" class="error_msg">
						                    <div data-ng-show="AssignInventory.purchaseDate.$error.required" class="error_msg">Please enter purchaseCost</div>
					                        </div>
					                        <input type="hidden" data-ng-model="inventoryManagementDto.location" name="location" tabindex="11" required   data-ng-init="inventoryManagementDto.location='${inventoryManagementDto.location}'"  value="WAREHOUSE" data-ng-change="AssignLocation(inventoryManagementDto.location)" id="WAREHOUSE" class="with-gap">
					                        <div>
											<label for="email">Project</label>
											<input
											list="project" class="form-control" 
											id="project_List" placeholder="project" data-ng-readonly="datareadonly" name="project" tabindex="12" required
											data-ng-model="inventoryManagementDto.projectName"  data-ng-change="getProjectSelection(inventoryManagementDto.projectName)" autocomplete="off">
										<datalist id="project">
											<option
												data-ng-repeat="x in projectMasterDtoList track by x.name"
												value="{{x.name}}">{{x.name}}</option>
										</datalist>
										<div data-ng-show="AssignInventory.$submitted || AssignInventory.project.$touched" class="error_msg">
						                <div data-ng-show="AssignInventory.project.$error.required" class="error_msg">Please choose project</div>
					                    </div>
					                    </div>
										</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="AssignInventoryToProject()"><i class="fa fa-arrow-right"></i> ASSIGN</button>
											<button class="btn btn-primary" data-ng-click="AddInventoryForAssign()">
						                    <i class="fa fa-check"></i> ADD
					                        </button>
											<button class="btn btn-warning" data-ng-click="cancelAssign()"><i class="fa fa-close"></i> CANCEL</button>
										</div>
										</div>
								</form>
							</div>
							
							<div class="row">
			<div class="col-md-12">

				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Date</th>
							<th>Project</th>
							<th>Category</th>
							<th>Resource Count</th>
							<th>Comments</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="x in request_worksmen">
							<td>{{$index + 1}}</td>
							<td>{{x.date}}</td>
							<td>{{x.projectDto[0].name}}</td>
							<td>{{x.worksMenCategoryDto[0].category}}</td>
							<td>{{x.resourceCount}}</td>
							<td>{{x.comments}}</td>
							<td><button class="btn btn-danger"
									data-ng-click="removeRow($index)">
									<i class="fa fa-close"></i>
								</button></td>
						</tr>
					</tbody>



				</table>

			</div>
		</div>
							
							
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->









<jsp:include page="footer.jsp" />	