 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="requestToolsController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">REQUEST TOOL</h3>
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
								<h4 class="form_content_title">Request Tool</h4>
								<form class="form-inline"  name="requestTools" id="requestTools" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="">
											<label for="email">CategoryType:</label> 
											<input type="text" class="form-control" id="category" name="category" data-ng-model="inventoryRequestDto.category" ng-init="inventoryRequestDto.category='${inventoryEntranceDto.categoryType}'" readonly="readonly">
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="inventoryRequestDto.id" ng-init="inventoryRequestDto.id='${inventoryEntranceDto.id}'" >
											<input type="hidden" class="form-control" id="inventoryNumber" name="inventoryNumber" data-ng-model="inventoryRequestDto.inventoryNumber" ng-init="inventoryRequestDto.inventoryNumber='${inventoryEntranceDto.inventoryNumber}'" >
											<input type="hidden" class="form-control" id="location" name="location" data-ng-model="inventoryRequestDto.location" ng-init="inventoryRequestDto.location='${inventoryEntranceDto.location}'" > 
										</div>
										<div class="">
											<label for="pwd">subCategory:</label>
											<input type="text" class="form-control" id="subCategory" name="subCategory" data-ng-model="inventoryRequestDto.subCategory" ng-init="inventoryRequestDto.subCategory='${inventoryEntranceDto.subCategory}'" readonly="readonly">
										</div>
										<div class="">
											<label for="pwd">model Code :</label> 
											<input type="text" class="form-control" id="modelCode" name="modelCode" data-ng-model="inventoryRequestDto.modelCode" ng-init="inventoryRequestDto.modelCode='${inventoryEntranceDto.modelCode}'" readonly="readonly">
										</div>
										<div class="add_icon_asterisk">
										<label for="pwd">Request From  :</label> 
										<!--  <select data-ng-model="inventoryRequestDto.requestedFrom" name="requestFrom" class="form-control" ng-change="checkrequest(inventoryRequestDto.requestedFrom)" required="required" class="error_msg" tabindex="1">
										<option value="">---select---</option>
										<option data-ng-repeat="x in currentUserProjectDtoList" value="{{x.name}}">{{x.name}}</option>
							          </select> -->
							          
							          <div class="new-select-option">
								<select name="requestFrom" id="requestFrom"
									data-ng-model="inventoryRequestDto.requestedFrom"
									required class="select2 form-control"
									style="width: 100%; height: 36px;" ng-change="checkrequest(inventoryRequestDto.requestedFrom)"data-ng-model="inventoryRequestDto.requestedFrom" required="required" class="error_msg" tabindex="1">

									<option value="" selected>--- select ---</option>

									<option
										data-ng-repeat="x in currentUserNonClosedProjectDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
							          </div>
							          <div data-ng-show="requestTools.$submitted || requestTools.requestFrom.$touched" class="error_msg">
						             <div data-ng-show="requestTools.requestFrom.$error.required" class="error_msg">Please select project</div>
					               </div>	

											</div>
											<div class="col-md-6 col_md text-center">
											
												<div class="">
												<label for="pwd"> Available Quantity:</label>
												<input type="text" class="form-control" id="avilableQuantity" name="avilableQuantity" data-ng-model="inventoryRequestDto.avilableQuantity" ng-init="inventoryRequestDto.avilableQuantity='${inventoryEntranceDto.quantity}'" readonly>
											</div>
										
										
										<div class="add_icon_asterisk">
												<label for="pwd">Required Quantity:</label>
												<input type="text" class="form-control" id="quantity" name="quantity" data-ng-model="inventoryRequestDto.quantity" required numbersonly data-ng-change="validateRequiredQty(inventoryRequestDto.quantity)">
												<i class="fa fa-asterisk" ></i>
												 <div data-ng-show="requestTools.$submitted || requestTools.quantity.$touched" class="error_msg">
						                         <div data-ng-show="requestTools.quantity.$error.required" class="error_msg">Please select quantity</div>
					                             </div>
											</div>
											
											<div class="">
												<label for="pwd">Request To:</label>
												<input type="text" class="form-control" id="wareHouseSiteName" name="wareHouseSiteName" data-ng-model="inventoryRequestDto.requestedTo"  ng-init="inventoryRequestDto.requestedTo='${inventoryEntranceDto.site}'" readonly>
												
											</div>
											<div class="add_icon_asterisk">
												<label for="pwd">Required Days:</label>
												<input type="text" class="form-control" id="requiredDays" name="requiredDays"  numbersonly required data-ng-model="inventoryRequestDto.requiredDays" >
												<i class="fa fa-asterisk" ></i>
												<div data-ng-show="requestTools.$submitted || requestTools.requiredDays.$touched" class="error_msg">
						                         <div data-ng-show="requestTools.requiredDays.$error.required" class="error_msg">Please select Required Days</div>
					                             </div>
											</div>
										<div class="add_icon_asterisk">
											<label for="pwd">Expected Date :</label>
											
											
									<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-start-date="0d" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" name="expectedDateToReach" id="expectedDateToReach" data-ng-model="inventoryRequestDto.expectedDateToReach" readonly required>
                                              
                                            </div>
                                            
                                            
                                           
                                        </div>
                                        <div data-ng-show="requestTools.$submitted || requestTools.expectedDateToReach.$touched" class="error_msg">
						                         <div data-ng-show="requestTools.expectedDateToReach.$error.required" class="error_msg">Please select Expected Date To Reach </div>
					                             </div>
                                         <i class="fa fa-asterisk" ></i>
											
											
			<!-- 		<input type="text" class="form-control" id="expectedDateToReach" name="expectedDateToReach" data-ng-model="inventoryRequestDto.expectedDateToReach" readonly  > -->
										</div>
										
										</div>
										
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveToolsRequest()" ng-disabled="submitButton">REQUEST</button>
																 <security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
					<span class="btn btn-warning" data-ng-click="cancel_req('warehouse')">
						<i class="fa fa-close"></i> CANCEL
					</span>
					</security:authorize>
					<security:authorize access="hasAuthority('USER')">
					<span class="btn btn-warning" data-ng-click="cancel_req('user')">
						<i class="fa fa-close"></i> CANCEL
					</span>
					</security:authorize>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->
<script type="text/javascript">


</script>


<jsp:include page="footer.jsp" />

