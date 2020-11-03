
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
	data-ng-controller="requestToolsController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">ACCEPT TOOLS REQUEST</h3>
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
			<h4 class="form_content_title">REFERENCE
				NO:${inventoryRequestDto.referenceNo}</h4>
			<form class="form-inline" name="acceptTools" id="acceptTools"
				novalidate>
				<div class="col-md-6 col_md text-center">
					<div class="add_icon_asterisk">
						<label for="email">Category Name:</label>
						 <input type="text"	class="form-control" id="category" name="category"
							data-ng-model="inventoryRequestDto.category"
							ng-init="inventoryRequestDto.category='${inventoryRequestDto.category}'"
							readonly> 
							<i class="fa fa-asterisk" ></i>
							<input type="hidden" class="form-control"
							id="id" name="id" data-ng-model="inventoryRequestDto.id"
							ng-init="inventoryRequestDto.id='${inventoryRequestDto.id}'">
							<input type="hidden" class="form-control"
							id="referenceNo" name="referenceNo" data-ng-model="inventoryRequestDto.referenceNo"
							ng-init="inventoryRequestDto.referenceNo='${inventoryRequestDto.referenceNo}'">
						<input type="hidden" class="form-control" id="location"
							name="location" data-ng-model="inventoryRequestDto.location"
							ng-init="inventoryRequestDto.location='${inventoryRequestDto.location}'">
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd">SubCategory Name :</label> <input type="text"
							class="form-control" id="subCategory" name="subCategory"
							data-ng-model="inventoryRequestDto.subCategory"
							ng-init="inventoryRequestDto.subCategory='${inventoryRequestDto.subCategory}'"
							readonly>
							<i class="fa fa-asterisk" ></i>
					</div>
					<div class="add_icon_asterisk">
						<label for="pwd"> Model Code :</label> 
						<input type="text"	class="form-control" id="modelCode" name="modelCode"
							data-ng-model="inventoryRequestDto.modelCode"
							ng-init="inventoryRequestDto.modelCode='${inventoryRequestDto.modelCode}'"
							readonly>
							<i class="fa fa-asterisk" ></i>
					</div>
					<div class="add_icon_asterisk">
						<label for="pwd">Request From</label>
						 <input type="text"	class="form-control" id="requestedFrom" name="requestedFrom"
							data-ng-model="inventoryRequestDto.requestedFrom"
							ng-init="inventoryRequestDto.requestedFrom='${inventoryRequestDto.requestedFrom}'"
							readonly>
							<i class="fa fa-asterisk" ></i>
					</div>

						<security:authorize
							access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
							<c:choose>
								<c:when test="${inventoryRequestDto.location == 'ALL'}">
								<div class="add_icon_asterisk">
									<label for="pwd">Accept From WareHouse :</label>
									<select class="form-control"
										data-ng-model="inventoryRequestDto.requestedTo"
										ng-change="checkAcceptLocation(inventoryRequestDto.requestedTo)"
										required="required" class="error_msg" ng-readonly="datareadonly">
										<option data-ng-repeat="x in currentUserWareHouseDtoList"
											value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>
									</select>
									<i class="fa fa-asterisk" ></i>
									
									</div>
								</c:when>
							</c:choose>
							
						</security:authorize>
					

						<security:authorize access="hasAuthority('USER')">
							<c:choose>
								<c:when test="${inventoryRequestDto.location == 'ALL'}">
								<div class="add_icon_asterisk">
									<label for="pwd">Accept From site :</label>
									<select class="form-control"
										data-ng-model="inventoryRequestDto.requestedTo" name="site"
										data-ng-change="checkAcceptLocation(inventoryRequestDto.requestedTo)"
										required="required" class="error_msg" ng-readonly="datareadonly">
										<option value="">---select---</option>
										<option data-ng-repeat="x in currentUserProjectDtoList"
											value="{{x.name}}">{{x.name}}</option>
									</select>
									<i class="fa fa-asterisk" ></i>
									</div>
												<div
						data-ng-show="acceptTools.$submitted || acceptTools.site.$touched" class="error_msg">
						<div data-ng-show="acceptTools.site.$error.required" class="error_msg">Please
							choose site</div>
					</div>
								</c:when>
							</c:choose>
							
						</security:authorize>
					

					
						<c:choose>
							<c:when test="${inventoryRequestDto.location != 'ALL'}">
							<div class="add_icon_asterisk">
								<label for="pwd">Request To</label>
								<input type="text" class="form-control" id="requestedTo"
									name="requestedTo"
									data-ng-model="inventoryRequestDto.requestedTo"
									ng-init="inventoryRequestDto.requestedTo='${inventoryRequestDto.requestedTo}'"
									readonly>
									<i class="fa fa-asterisk" ></i>
									</div>
							</c:when>
						</c:choose>
							</div>

				<div class="col-md-6 col_md text-center">
					


					<div class="add_icon_asterisk">
						<label for="pwd"> Quantity:</label> <input type="text"
							class="form-control" id="quantity" name="quantity" numbersonly
							data-ng-model="inventoryRequestDto.quantity"
							ng-init="inventoryRequestDto.quantity='${inventoryRequestDto.quantity}'" data-ng-change="validateQty(inventoryRequestDto.quantity)">
							
							<input type="hidden"
							class="form-control" id="requestedQuantity" name="requestedQuantity"
							data-ng-model="inventoryRequestDto.requestedQuantity"
							ng-init="inventoryRequestDto.requestedQuantity='${inventoryRequestDto.quantity}'">
							<i class="fa fa-asterisk" ></i>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd"> Expected Date To Reach:</label>

						<%-- <div class="input-group date" data-date-format="dd/mm/yyyy" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="expectedDateToReach" name="expectedDateToReach" data-ng-model="inventoryRequestDto.expectedDateToReach" ng-init="inventoryRequestDto.expectedDateToReach='${inventoryRequestDto.expectedDateToReach}'" readonly required>
                                            </div>
                                        </div>	 --%>



						<input type="text" class="form-control" id="expectedDateToReach"
							name="expectedDateToReach"
							data-ng-model="inventoryRequestDto.expectedDateToReach"
							ng-init="inventoryRequestDto.expectedDateToReach='${inventoryRequestDto.expectedDateToReach}'"
							readonly>
							<i class="fa fa-asterisk" ></i>
					</div>
					<div class="add_icon_asterisk">
						<label for="pwd"> Dispatch Date :</label>


						<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-start-date="0d"
							data-date-today-highlight="true" data-date-autoclose="true"
							data-provide="datepicker">
							<div class="input-group-addon inner-addon right-addon ">
								<i class="fa fa-calendar"></i> <input type="text"
									class="form-control" placeholder="" id="dispatchDate"
									name="dispatchDate"
									data-ng-model="inventoryRequestDto.dispatchDate"
									ng-init="inventoryRequestDto.dispatchDate='${inventoryRequestDto.dispatchDate}'"
									readonly required>
							</div>
							
						</div>
						<i class="fa fa-asterisk" ></i>


						<%-- 												<input type="text" class="form-control" id="dispatchDate" name="dispatchDate" data-ng-model="inventoryRequestDto.dispatchDate" ng-init="inventoryRequestDto.dispatchDate='${inventoryRequestDto.dispatchDate}'"> --%>
					</div>
					
					<div
						data-ng-show="acceptTools.$submitted || acceptTools.dispatchDate.$touched" class="error_msg">
						<div data-ng-show="acceptTools.dispatchDate.$error.required" class="error_msg">Please
							Select Dispatch date</div>
					</div>
					

					<div class="add_icon_asterisk">
						<label for="pwd">Status:</label>
						<!-- 													<select class="form-control"  id="status" name="status" data-ng-model="inventoryRequestDto.status"> -->

						<!-- 													    <option value="ACCEPTED">ACCEPTED -->
						<!-- 													    <option value="PARTIALY ACCEPTED">PARTIALY ACCEPTED -->
						<!-- 													    <option value="REJECTED">REJECTED -->
						<!-- 													</select> -->

						<select class="form-control" id="status" name="status"
							data-ng-model="inventoryRequestDto.status" required ng-disabled="readOnly">
							<option value="">---select---</option>
							<option value="ACCEPTED">ACCEPTED
							<option value="PARTIALLY ACCEPTED">PARTIALLY ACCEPTED
								<c:choose>
									<c:when test="${inventoryRequestDto.location != 'ALL'}">
										<option value="REJECTED">REJECTED
									</c:when>
								</c:choose>
						</select>
						<i class="fa fa-asterisk" ></i>
					</div>
					<div
						data-ng-show="acceptTools.$submitted || acceptTools.status.$touched" class="error_msg">
						<div data-ng-show="acceptTools.status.$error.required" class="error_msg">Please
							choose status</div>
					</div>

					<%-- <div class="">
													<label for="pwd">Sub Status:</label>
													<input type="text" class="form-control" id="subStatus" name="subStatus" data-ng-model="inventoryRequestDto.subStatus" ng-init="inventoryRequestDto.subStatus='${inventoryRequestDto.subStatus}'">
											</div> --%>
					<div class="">
						<label for="pwd">Comments:</label> <input type="text"
							class="form-control" id="comments" name="comments"
							data-ng-model="inventoryRequestDto.comments"
							ng-init="inventoryRequestDto.comments='${inventoryRequestDto.comments}'">
					</div>
				</div>
				<div class="">
					<!-- <label for="pwd">createdBy  :</label> -->
					<input type="hidden" class="form-control" id="actionBy"
						name="actionBy" data-ng-model="inventoryRequestDto.actionBy"
						ng-init="inventoryRequestDto.actionBy='${inventoryRequestDto.actionBy}'">
					<input type="hidden" class="form-control" id="actionDate"
						name="actionDate" data-ng-model="inventoryRequestDto.actionDate"
						ng-init="inventoryRequestDto.actionDate='${inventoryRequestDto.actionDate}'">
					<%-- <input type="hidden" class="form-control" id="createdBy" name="createdBy" data-ng-model="inventoryRequestDto.createdBy" ng-init="inventoryRequestDto.createdBy='${inventoryRequestDto.createdBy}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="inventoryRequestDto.creationDate" ng-init="inventoryRequestDto.creationDate='${inventoryRequestDto.creationDate}'">
												<input type="hidden" class="form-control" id="createdBy" name="createdBy" data-ng-model="inventoryRequestDto.createdBy" ng-init="inventoryRequestDto.createdBy='${inventoryRequestDto.createdBy}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="inventoryRequestDto.creationDate" ng-init="inventoryRequestDto.creationDate='${inventoryRequestDto.creationDate}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="inventoryRequestDto.creationDate" ng-init="inventoryRequestDto.creationDate='${inventoryRequestDto.creationDate}'"> --%>
				</div>

				<div class="col-12 submit_col text-center">
					
					 <security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
					<button class="btn btn-primary"
						data-ng-click="saveAcceptToolsRequest('warehouse')">
						<i class="fa fa-check"></i>ACCEPT
					</button>
					</security:authorize>
										 <security:authorize access="hasAuthority('USER')">
					<button class="btn btn-primary"
						data-ng-click="saveAcceptToolsRequest('user')">
						<i class="fa fa-check"></i>ACCEPT
					</button>
					</security:authorize>
					
					 <security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
					<span class="btn btn-warning" data-ng-click="cancel('warehouse')">
						<i class="fa fa-close"></i>CANCEL
					</span>
					</security:authorize>
					<security:authorize access="hasAuthority('USER')">
					<span class="btn btn-warning" data-ng-click="cancel('user')">
						<i class="fa fa-close"></i>CANCEL
					</span>
					</security:authorize>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />
