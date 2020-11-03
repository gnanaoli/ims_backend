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
                        <h3 class="text-themecolor">ASSIGN TOOLS</h3>
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
								<h4 class="form_content_title">ASSIGN TOOLS</h4>
								
								
								<div data-ng-show="viewAssignableTools">
								
								
								<form class="form-inline" role="form" name="add_supplier" id="add_supplier" novalidate>
									
										<div class="col-md-4">
											<label for="email">Category Type</label>
											
											 <div class="new-select-option">
								<select name="proof" id="proof"
									data-ng-model="assignInventoryDto.categoryType"
									data-ng-change="getSubCategoryByCategory(assignInventoryDto.categoryType)"
									required class="select2 form-control"
									style="width: 100%; height: 36px;">

							<option value="" selected></option> 

									<option
										data-ng-repeat="x in categoryMasterDtoList track by x.categoryType" data-ng-if="x.status=='ACTIVE'"
										value="{{x.categoryType}}">{{x.categoryType}}</option>
								</select>
							</div>
											
											
											<!-- <input
											list="category" class="form-control" 
											id="category_List" placeholder="" data-ng-readonly="datareadonly" required
											data-ng-model="assignInventoryDto.categoryType" name="categoryType" data-ng-blur="getSubCategoryByCategory(assignInventoryDto.categoryType)">
										<datalist id="category">
											<option
												data-ng-repeat="x in categoryMasterDtoList track by x.categoryType"
												value="{{x.categoryType}}">{{x.categoryType}}</option>
										</datalist> -->
										</div>
										<div class="col-md-4">
											<label for="pwd">Sub Category</label>
											<div class="new-select-option">
								<select name="proof" id="proof"
									data-ng-model="assignInventoryDto.subCategory"
									required class="select2 form-control"
									style="width: 100%; height: 36px;">

							<option value="" selected></option> 

									<option
										data-ng-repeat="x in subCategoryMasterDtoList track by x.subCategory" data-ng-if="x.status=='ACTIVE'"
										value="{{x.subCategory}}">{{x.subCategory}}</option>
								</select>
							</div>
											
											
											<!--  <input
											list="subCategory" class="form-control" 
											id="subCategory_List" placeholder="" data-ng-readonly="datareadonly" required
											data-ng-model="assignInventoryDto.subCategory" name="city">
										<datalist id="subCategory">
											<option
												data-ng-repeat="x in subCategoryMasterDtoList track by x.subCategory"
												value="{{x.subCategory}}">{{x.subCategory}}</option>
										</datalist> -->
										</div>
										

										<div class="col-md-1 text-center">

<label for="pwd"></label>
								 <button class="btn btn-primary" id="" data-ng-click="search(assignInventoryDto)"><i class="fa fa-search"></i> Search</button> 
										</div>
										</form>
					
					</div>
					
					
					<div data-ng-show="viewAssignableTools">
					
					<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered" style="width:100%">
					<thead>
						<tr>
						    <th>Check</th>
							<th>Category</th>
							<!-- <th>Category Code</th> -->
							 <th>Sub Category</th>
							<th>Model</th>
							<th>Asset Tracking</th>
							<th>Asset No</th>
							<th>Site</th>
							<!-- <th>Total Quantity</th> -->
							<th>available Quantity</th>
							<th>left Over Quantity</th>
							<th>Allocatable quantity</th>
						</tr>
					</thead>
					<tbody>
					<security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
						<tr data-ng-repeat="inventoryManagementDto in assignInventoryManagementDtoList">
						<td>						<div class="new-check-button">
								<input type="checkbox" name="projectName"
									id="{{inventoryManagementDto.id}}"
									data-ng-model="inventoryManagementDto.selected" class="filled-in"  data-ng-change="removeUnchecked(inventoryManagementDto.selected,inventoryManagementDto.id)" />
								<label for="{{inventoryManagementDto.id}}"></label>
						</div></td>
							<td>{{inventoryManagementDto.categoryType}}</td>
							<!-- <td>{{inventoryManagementDto.categoryCode}}</td> -->
							 <td>{{inventoryManagementDto.subCategory}}</td>
							<td>{{inventoryManagementDto.modelCode}}</td>
							<td>{{inventoryManagementDto.assetTracking}}</td>
							<td>{{inventoryManagementDto.inventoryNumber}}</td>
							<td>{{inventoryManagementDto.site}}</td>
							<!-- <td>{{inventoryManagementDto.quantity}}</td> -->
							<td>{{inventoryManagementDto.availableQuantity}}</td>
							<td>{{inventoryManagementDto.leftOverQuantity}}</td>
							<td><input type="text" value="" data-ng-model="inventoryManagementDto.allocatableQuantity"  size="5" numbersonly maxlength="10" data-ng-blur="checkAssignableQuantity(inventoryManagementDto.id,inventoryManagementDto.availableQuantity,inventoryManagementDto.allocatableQuantity)"/></td>
						</tr>
						</security:authorize>
					</tbody>
				</table>
</div>


				 <div class="col-12 submit_col text-center">
					<button class="btn btn-primary"
						data-ng-click="Add()"><i class="fa fa-check"></i> ADD</button>
				   </div>
				   
				   </div>
				   
				   
				   
				   
				   
				   
				   
			<div class="col-md-12" data-ng-show="viewAssign">
<div class="table-responsive">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Category Type</th>
							<th>Category Code</th>
							 <th>Sub Category</th>
							<th>Model</th>
							<th>Asset Tracking</th>
							<th>Asset No</th>
							<th>Site</th>
							<th>allocated quantity</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="x in addedAssignInventoryManagmentDtoList">
							<td>{{$index + 1}}</td>
							<td>{{x.categoryType}}</td>
							<td>{{x.categoryCode}}</td>
							 <td>{{x.subCategory}}</td>
							<td>{{x.modelCode}}</td>
							<td>{{x.assetTracking}}</td>
							<td>{{x.inventoryNumber}}</td>
							<td>{{x.site}}</td>
							<td>{{x.allocatableQuantity}}</td>
							<td><button class="btn btn-danger"
									data-ng-click="removeRow(x.id)">
									<i class="fa fa-close"></i>
								</button></td>
						</tr>
					</tbody>
				</table>
				</div>
                  <div class="col-12 submit_col text-center">
					<button class="btn btn-primary"
						data-ng-click="assignTools()"><i class="fa fa-check"></i> ASSIGN</button>
				   </div>
			</div>
				   
				   
				   
											<div data-ng-show="viewAssignForm">
					                <form class="form-inline" role="form" name="assignInventoryForDispatch" id="assignInventoryForDispatch" novalidate>
					                <div class="row">
					                
					                <div class="col-md-3"></div>
					                
					                 <div class="col-md-6 add_icon_asterisk">
					                
					                <label for="email" style="width:25%;">Project</label>
					                
					                <div class="new-select-option assign_tools_input">
								    <select name="project" id="project"
									data-ng-model="inventoryManagementDto.projectName"
									required class="select2 form-control"
									style="width: 100%; height: 36px;">
							        <option value="" selected></option> 
									<option
										data-ng-repeat="x in projectMasterDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>
								    </select>
								    <i class="fa fa-asterisk" ></i>
							        </div>
                                    
										<div data-ng-show="assignInventoryForDispatch.$submitted || assignInventoryForDispatch.project.$touched" class="error_msg">
						                <div data-ng-show="assignInventoryForDispatch.project.$error.required" class="error_msg">Please choose project</div>
					                    </div>
					                    
					                    </div>
					                    <div class="col-md-3"></div>
					                    </div>
										 <div class="col-12 submit_col text-center">
										  <button class="btn btn-primary"
						            data-ng-click="addInventoryInDispatch()">
						            <i class="fa fa-check"></i> SEND</button>
						            <button class="btn btn-primary"
						            data-ng-click="cancelAssign1()"><i class="fa fa-check"></i> CANCEL</button>
				                          </div>
										</form>
										</div>		   
				   
				   
				   
				   
				</div>
				


		
		
		
		

		
		


					</div>
					
<!-- <div data-ng-show="showloader">					
<img src="resources/img1/icon-loading.gif" width="70" />
</div> -->
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />	