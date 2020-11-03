 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="categoryManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">CATEGORY MANAGEMENT</h3>
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
								<h4 class="form_content_title">Edit Category</h4>
								<form class="form-inline"  method="post" role="form" name="new_category" id="new_category" novalidate >
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="email">Category Type:</label> 
											<input type="text" class="form-control" id="categoryType" name="categoryType" data-ng-model="categoryDto.categoryType" ng-init="categoryDto.categoryType='${categoryDto.categoryType}'" maxlength="50" autocomplete="off" required="required" tabindex="1" >
											<i class="fa fa-asterisk" ></i>
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="categoryDto.id" ng-init="categoryDto.id='${categoryDto.id}'" >
										</div>
										<div data-ng-show="new_category.$submitted || new_category.categoryType.$touched" class="error_msg">
									<div data-ng-show="new_category.categoryType.$error.required" class="error_msg">Please Enter Category Type</div>
									</div>	
										<div class="add_icon_asterisk">
											<label for="pwd">Category Code:</label>
											<input type="text" class="form-control" id="categoryCode" name="categoryCode" data-ng-model="categoryDto.categoryCode" ng-init="categoryDto.categoryCode='${categoryDto.categoryCode}'" maxlength="6" autocomplete="off" required="required" tabindex="2">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="new_category.$submitted || new_category.categoryCode.$touched" class="error_msg">
									<div data-ng-show="new_category.categoryCode.$error.required" class="error_msg">Please Enter Category Type</div>
									</div>
									<div class="">
												<label for="email">Asset Tracking :</label>
												
												
									 <div class="new-radio-button-inline">
										
										<input type="radio" data-ng-model="categoryDto.assetTracking" ng-init="categoryDto.assetTracking='${categoryDto.assetTracking}'"  name="assetTracking" required class="with-gap"  id="QTY TRACKING" value="QTY TRACKING" tabindex="7" >
										<label for="QTY TRACKING" >QTY TRACKING</label>
										<input type="radio" data-ng-model="categoryDto.assetTracking" ng-init="categoryDto.assetTracking='${categoryDto.assetTracking}'"  name="assetTracking"  required class="with-gap"  id="INDIVIDUAL TRACKING" value="INDIVIDUAL TRACKING" tabindex="8">
										<label for="INDIVIDUAL TRACKING">INDIVIDUAL</label>
									</div> 
											</div>		
												
<%-- 												<input type="radio" data-ng-model="categoryDto.assetTracking" value="QTY" ng-init="categoryDto.assetTracking='${categoryDto.assetTracking}'">QTY --%>
<%-- 												<input type="radio" data-ng-model="categoryDto.assetTracking" value="INDIVIDUAL" ng-init="categoryDto.assetTracking='${categoryDto.assetTracking}'" >INDIVIDUAL --%>
											
										<div class="">
												<label for="email"> Status :</label>
												
									<div class="new-radio-button-inline">
										
										<input type="radio" data-ng-model="categoryDto.status" ng-init="categoryDto.status='${categoryDto.status}'" name="status" required class="with-gap"  id="ACTIVE" value="ACTIVE" tabindex="9" >
										<label for="ACTIVE" >ACTIVE</label>
										<input type="radio" data-ng-model="categoryDto.status" ng-init="categoryDto.status='${categoryDto.status}'" name="status"  required class="with-gap"  id="INACTIVE" value="INACTIVE" tabindex="10">
										<label for="INACTIVE">INACTIVE</label>
									</div>
									</div>
									
											<div class="">
												<!-- <label for="pwd">createdBy  :</label> -->
												<input type="hidden" class="form-control" id="createdBy" name="createdBy" data-ng-model="categoryDto.createdBy" ng-init="categoryDto.createdBy='${categoryDto.createdBy}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="categoryDto.creationDate" ng-init="categoryDto.creationDate='${categoryDto.creationDate}'">
											</div>
											</div>
											
										
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveCategory()"><i class="fa fa-check"></i> SAVE</button>
											<button class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</button>
										</div>
										
								</form>
								</div>
							</div>
					</div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />	