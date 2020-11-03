 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ServiceInspectionController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">SERVICE INSPECTION DETAILS</h3>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                
                
                <div data-ng-show="InspectionMgt">
                
                
		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">VERIFY INSPECTION</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered ">
					<thead>
					<tr>
						<th>Category Type</th>
						<th>Sub Category</th>
						<th>Requested From</th>
						<th>Requested To </th>
						<th>Status </th>
						<th>Ref No </th>
						<th>Action </th>
						
					</tr>
					</thead>
					<tbody>
					
					<security:authorize access="hasAuthority('SUPER USER') or hasAuthority('USER')">
					
						<tr data-ng-repeat="inspectionDto in InspectionDtoMaster" data-ng-if="!(inspectionDto.subStatus == 'QC VERIFIED' || inspectionDto.subStatus == 'REJECTED' || inspectionDto.subStatus == 'QC APPROVED')">
							<td>{{inspectionDto.categoryType}}</td>
							<td>{{inspectionDto.subCategory}}</td>
							<td>{{inspectionDto.requestedFrom}}</td>
							<td>{{inspectionDto.requestedTo}}</td>
							<td>{{inspectionDto.status}}</td>
							<td>{{inspectionDto.referenceNo}}</td>
							<td class="table_btn_group">
							<a href="" data-ng-click="edit(inspectionDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a>
							</td>
						</tr>
													
					 </security:authorize>
					 
					 <security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
					
						<tr data-ng-repeat="inspectionDto in InspectionDtoMaster" data-ng-if="inspectionDto.subStatus == 'QC VERIFIED' || !inspectionDto.subStatus == 'REJECTED' || !inspectionDto.subStatus == 'QC APPROVED'">
							<td>{{inspectionDto.categoryType}}</td>
							<td>{{inspectionDto.subCategory}}</td>
							<td>{{inspectionDto.requestedFrom}}</td>
							<td>{{inspectionDto.requestedTo}}</td>
							<td>{{inspectionDto.status}}</td>
							<td>{{inspectionDto.referenceNo}}</td>
							<td class="table_btn_group">
							<a href="" data-ng-click="edit(inspectionDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a>
							</td>
						</tr>	
							
					 </security:authorize>
					 	


					</tbody>
				</table>
</div>


			</div>
		</div>
		</div>
		
		
		
		
		
		
		<div data-ng-show="editInspection">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Verify Inspection</h4>
								<form class="form-inline"  method="post" name="approveInspection" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="pwd"> Category Type:</label>
											<input type="text" class="form-control" id="categoryType" name="categoryType" data-ng-model="inspectionDto.categoryType" readonly required autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										</div>
										
					<div data-ng-show="approveInspection.$submitted || approveInspection.categoryType.$touched" class="error_msg">					
						<div data-ng-show="approveInspection.categoryType.$error.required" class="error_msg">Please Enter CategoryType </div>
					</div>											
										
										
										<div class="add_icon_asterisk">
											<label for="pwd"> Sub Category:</label>
											<input type="text" class="form-control" id="subCategory" name="subCategory" data-ng-model="inspectionDto.subCategory" readonly required autocomplete="off" tabindex="2">
											<i class="fa fa-asterisk" ></i>
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="inspectionDto.id" required>
										</div>
										
					<div data-ng-show="approveInspection.$submitted || approveInspection.subCategory.$touched" class="error_msg">					
						<div data-ng-show="approveInspection.subCategory.$error.required" class="error_msg">Please Enter SubCategory</div>
					</div>											
										
										<div class="add_icon_asterisk">
											<label for="pwd"> Status:</label>
											<input type="text" class="form-control" id="status" name="status" data-ng-model="inspectionDto.status" readonly required autocomplete="off" tabindex="3">
											<i class="fa fa-asterisk" ></i>
										</div>		
										
					<div data-ng-show="approveInspection.$submitted || approveInspection.status.$touched" class="error_msg">					
						<div data-ng-show="approveInspection.status.$error.required" class="error_msg">Please Enter Status </div>
					</div>											
								
								

								
																		
										<div class="add_icon_asterisk">
											<label for="">Action:</label>
											
											<security:authorize access="hasAuthority('SUPER USER')">
                                                  <select class="selectpicker1" data-style="form-control" name="subStatus" data-ng-options="item for item in verifyAction" data-ng-model="inspectionDto.subStatus"  required style="padding: 6px;">
                                                        <option value="">-- Select Action --</option> 
                                                    </select>
                                                    <i class="fa fa-asterisk" ></i>										
											</security:authorize>
											<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
                                                  <select class="selectpicker1" data-style="form-control" name="subStatus" data-ng-options="item for item in approveAction" data-ng-model="inspectionDto.subStatus"  required style="padding: 6px;">
                                                        <option value="">-- Select Action --</option> 
                                                    </select>
                                                    <i class="fa fa-asterisk" ></i>										
											</security:authorize>											
											
										</div>
										
					<div data-ng-show="approveInspection.$submitted || approveInspection.subStatus.$touched" class="error_msg">					
						<div data-ng-show="approveInspection.subStatus.$error.required" class="error_msg">Please Select Action </div>
					</div>	
					
					
					

								
										<div class="">
											<label for="pwd"> Comments:</label>
											<input type="text" class="form-control" id="comments" name="comments" data-ng-model="inspectionDto.comments" autocomplete="off" tabindex="4" autofocus>
<!-- 											<i class="fa fa-asterisk" ></i> -->
										</div>		
										
					<div data-ng-show="approveInspection.$submitted || approveInspection.comments.$touched" class="error_msg">					
						<div data-ng-show="approveInspection.comments.$error.required" class="error_msg">Please Enter Comments </div>
					</div>	
															
										
									</div>
										<div class="col-12 submit_col text-center">
										<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
											<button class="btn btn-primary" data-ng-click="approveInspectionDetails()" ng-readonly="readonlyStatus"><i class="fa fa-check"></i> SEND</button>
										</security:authorize>	
										<security:authorize access="hasAuthority('SUPER USER')">
											<button class="btn btn-primary" data-ng-click="verifyInspection()" ng-readonly="readonlyStatus"><i class="fa fa-check"></i> SEND</button>
										</security:authorize>	
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
		
		
		
		</div>
		
		
		
		
		
		
		
		
		
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />