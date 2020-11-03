 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="categoryManagementController" ng-init="categoryDto.assetTracking='QTY TRACKING'">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">CATEGORY CREATION</h3>
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
								<h4 class="form_content_title">Create New Category  </h4>
								<form class="form-inline"  method="post" role="form" name="new_category" id="new_category" novalidate >
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="email">Category Type:</label>
											<input type="text" class="form-control" id="categoryType" name="categoryType" data-ng-model="categoryDto.categoryType" required="required" maxlength="50" tabindex="1" autocomplete="off">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="new_category.$submitted || new_category.categoryType.$touched" class="error_msg">
									<div data-ng-show="new_category.categoryType.$error.required" class="error_msg">Please Enter Category Type</div>
									</div>	
										<div class="add_icon_asterisk">
											<label for="pwd">Category Code</label>
											<input type="text" class="form-control" id="categoryCode" name="categoryCode" data-ng-model="categoryDto.categoryCode" required="required" maxlength="6" tabindex="2" autocomplete="off">
											<i class="fa fa-asterisk" ></i>
										</div>
										
										<div data-ng-show="new_category.$submitted || new_category.categoryCode.$touched" class="error_msg">
									<div data-ng-show="new_category.categoryCode.$error.required" class="error_msg">Please Enter Category Type</div>
									</div>	
										
										
									<div class="">	
									<label for="">Asset Tracking:</label>
										<div class="new-radio-button-inline">
										
										<input type="radio" data-ng-model="categoryDto.assetTracking"  name="assetTracking" required class="with-gap"  id="QTY TRACKING" value="QTY TRACKING" tabindex="3" >
										<label for="QTY TRACKING" >QTY TRACKING</label>
										<input type="radio" data-ng-model="categoryDto.assetTracking"  name="assetTracking"  required class="with-gap"  id="INDIVIDUAL TRACKING" value="INDIVIDUAL TRACKING" tabindex="4">
										<label for="INDIVIDUAL TRACKING">INDIVIDUAL TRACKING</label>
									</div>
										</div>
										
										<div data-ng-show="new_category.$submitted || new_category.assetTracking.$touched" class="error_msg">
									<div data-ng-show="new_category.assetTracking.$error.required" class="error_msg">Please Select Asset Tracking</div>
									</div>
									</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveCategory()"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />