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
	data-ng-controller="MoveServiedToolsController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">MOVE SERVICED TOOLS </h3>
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
			<%-- <h4 class="form_content_title">REFERENCE
				NO:${inventoryRequestDto.referenceNo}</h4> --%>
			<form class="form-inline" name="backFromService" id="backFromService"
				novalidate>
				<div class="col-md-6 col_md text-center"> 
				<div class="add_icon_asterisk">
 				<div class="">
						<label for="email">INVENTORY NUMBER :</label> <input type="text"
							class="form-control" id="inventoryNumber" name="inventoryNumber"
							data-ng-model="serviceTrackerDto.inventoryNumber"
							data-ng-init="serviceTrackerDto.inventoryNumber='${serviceTrackerDto.inventoryNumber}'"
							readonly> <input type="hidden" class="form-control"
							id="id" name="id" data-ng-model="serviceTrackerDto.id"
							data-ng-init="serviceTrackerDto.id='${serviceTrackerDto.id}'">
						<input type="hidden" class="form-control" id="createdBy"
							name="createdBy" data-ng-model="serviceTrackerDto.createdBy"
							data-ng-init="serviceTrackerDto.createdBy='${serviceTrackerDto.createdBy}'">
							 <input type="hidden" class="form-control"
							id="id" name="creationDate" data-ng-model="serviceTrackerDto.creationDate"
							data-ng-init="serviceTrackerDto.creationDate='${serviceTrackerDto.creationDate}'">
					
					
					
					</div>
					</div>
<div class="add_icon_asterisk">
					<div class="">
						<label for="pwd">SubCategory Name :</label> <input type="text"
							class="form-control" id="subCategory" name="subCategory"
							data-ng-model="serviceTrackerDto.subCategory"
							data-ng-init="serviceTrackerDto.subCategory='${serviceTrackerDto.subCategory}'"
							readonly>
					</div>
					</div>
					<div class="add_icon_asterisk">
					<div class="">
						<label for="pwd"> Model Code :</label> <input type="text"
							class="form-control" id="modelCode" name="modelCode"
							data-ng-model="serviceTrackerDto.modelCode"
							ng-init="serviceTrackerDto.modelCode='${serviceTrackerDto.modelCode}'"
							readonly>
					</div>			
					</div>				
							
							
					

		<div class="add_icon_asterisk">
					<div class="">
						<label for="pwd"> Quantity :</label> <input type="text"
							class="form-control" id="quantity" name="quantity"
							data-ng-model="serviceTrackerDto.quantity"
							data-ng-init="serviceTrackerDto.quantity='${serviceTrackerDto.quantity}'"  readonly="readonly">
							</div>
							</div>
							<div class="add_icon_asterisk">
							<div class="">
						<label for="pwd"> Quantity To Move :</label>	
							<input type="text"
							class="form-control" id="accept_quantity" name="accept_quantity"
							data-ng-model="serviceTrackerDto.accept_quantity"
							data-ng-init="serviceTrackerDto.accept_quantity='${serviceTrackerDto.quantity}'" data-ng-change="validateQty(serviceTrackerDto.accept_quantity)">
					</div>
					</div>	
					</div>
						
												
			<div class="col-md-6 col_md text-center">
					
					
					 <div class="add_icon_asterisk">
						<label for="email"> Move Back To :</label>
						
						
									<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="serviceTrackerDto.moveBackTo" data-ng-change="isWareHouseSeelected(serviceTrackerDto.moveBackTo)" required class="with-gap" autocomplete="off" name="moveBackTo" id="WAREHOUSE" value="WAREHOUSE" >
										<label for="WAREHOUSE" >WareHouse</label>
										
										<input type="radio" data-ng-model="serviceTrackerDto.moveBackTo" data-ng-change="isWareHouseSeelected(serviceTrackerDto.moveBackTo)" required class="with-gap" autocomplete="off" name="moveBackTo" id="PROJECTSITE" value="PROJECTSITE" >
										<label for="PROJECTSITE">ProjectSite</label>
									</div>
						
						</div>
						
						<div data-ng-show="new_manufacturer.$submitted || new_manufacturer.status.$touched" class="error_msg">
										<div data-data-ng-show="new_manufacturer.status.$error.required" class="error_msg">Please select the status</div>
										</div>						
					

					
					
					
        
        
        
        <div class="add_icon_asterisk" ng-if="projectView">
                                                        
                          <label for="email" >Project</label>
                      <input
                   list="project" class="form-control" 
                                      id="project_List" placeholder="" data-ng-readonly="datareadonly" name="project"  required
                    data-ng-model="inventoryManagementDto.projectName" autocomplete="off">
                    <datalist id="project">
                              <option
                                   data-ng-repeat="x in projectMasterDtoList track by x.name"
                           value="{{x.name}}">{{x.name}}</option>
                                            </datalist>
                 <div data-ng-show="moveInventory.$submitted || moveInventory.requestedTo.$touched" class="error_msg">
                      <div data-ng-show="moveInventory.requestedTo.$error.required" class="error_msg">Please choose project</div>
                             </div>
                                                            
                   </div>


        <div class="add_icon_asterisk" ng-if="warehouseView">
        
       
                      <label for="email">WareHouse</label>
                  <input
                 list="wareHouse" class="form-control" 
                 id="wareHouse_List" placeholder="wareHouse" data-ng-readonly="datareadonly" required name="requestedTo" 
                 data-ng-model="inventoryManagementDto.requestedTo" autocomplete="off">
                 <i class="fa fa-asterisk" ></i>
                 <datalist id="wareHouse">
                 <option
                 data-ng-repeat="x in activeWareHouseList track by x.wareHouseName"
                 value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>
                </datalist>
                
                <div data-ng-show="moveInventory.$submitted || moveInventory.requestedTo.$touched" class="error_msg">
                 <div data-ng-show="moveInventory.requestedTo.$error.required" class="error_msg">Please choose wareHouse</div>
                  </div> 
         </div> 
                   

				<!-- <div class="single_select_box" data-ng-if="enableWareHouse">
                                            <label for="email">WareHouse</label>
                                                                                                         
                                               
                                          <div data-ng-show="inventoryManagementDto.moveBackTo=='WAREHOUSE'"> 
											<div data-ng-show="NewInventory.$submitted || NewInventory.$touched" class="error_msg"> 
						                    <div data-ng-show="NewInventory.$error.required" class="error_msg">Please choose WareHouse</div> 
					                        </div>
					                        </div>                          
                                        </div> -->



					<div class="add_icon_asterisk">
						<label for="pwd">Status:</label>
						

						<select class="form-control" id="status" name="status"
							data-ng-model="serviceTrackerDto.status" required ng-disabled="readOnly">
							<option value="">---select---</option>
							<option value="SERVICED">SERVICED
							<option value="NOT SERVICED">NOT SERVICED
								
						</select>
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
					<div class="add_icon_asterisk">
						<label for="pwd">Comments :</label> <input type="text"
							class="form-control" id="comments" name="comments"
							data-ng-model="serviceTrackerDto.comments"
							ng-init="serviceTrackerDto.comments='${serviceTrackerDto.comments}'">
					</div>
					
					<div class="add_icon_asterisk">
						<label for="email"> Need Challan :</label>
						
						
									<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="serviceTrackerDto.needChallan" data-ng-change="isWareHouseSelected(serviceTrackerDto.needChallan)" required class="with-gap" autocomplete="off" name="needChallan" id="YES" value="YES" >
										<label for="YES" >YES</label>
										<input type="radio" data-ng-model="serviceTrackerDto.needChallan" data-ng-change="isWareHouseSelected(serviceTrackerDto.needChallan)" required class="with-gap" autocomplete="off" name="needChallan" id="NO" value="NO" >
										<label for="NO">NO</label>
									</div>
						
						</div>
						<div ng-show="new_manufacturer.$submitted || new_manufacturer.status.$touched" class="error_msg">
										<div ng-show="new_manufacturer.status.$error.required" class="error_msg">Please select the status</div>
										</div>
					
					
					
				</div>
				<%-- <div class="">
					<!-- <label for="pwd">createdBy  :</label> -->
					<input type="hidden" class="form-control" id="actionBy"
						name="actionBy" data-ng-model="ServiceTrackerDto.actionBy"
						ng-init="ServiceTrackerDto.actionBy='${ServiceTrackerDto.actionBy}'">
					<input type="hidden" class="form-control" id="actionDate"
						name="actionDate" data-ng-model="ServiceTrackerDto.actionDate"
						ng-init="ServiceTrackerDto.actionDate='${ServiceTrackerDto.actionDate}'"> --%>
					<%-- <input type="hidden" class="form-control" id="createdBy" name="createdBy" data-ng-model="inventoryRequestDto.createdBy" ng-init="inventoryRequestDto.createdBy='${inventoryRequestDto.createdBy}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="inventoryRequestDto.creationDate" ng-init="inventoryRequestDto.creationDate='${inventoryRequestDto.creationDate}'">
												<input type="hidden" class="form-control" id="createdBy" name="createdBy" data-ng-model="inventoryRequestDto.createdBy" ng-init="inventoryRequestDto.createdBy='${inventoryRequestDto.createdBy}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="inventoryRequestDto.creationDate" ng-init="inventoryRequestDto.creationDate='${inventoryRequestDto.creationDate}'">
												<input type="hidden" class="form-control" id="creationDate" name="creationDate" data-ng-model="inventoryRequestDto.creationDate" ng-init="inventoryRequestDto.creationDate='${inventoryRequestDto.creationDate}'"> --%>
				



				<div class="col-12 submit_col text-center">
					<button class="btn btn-primary"
						data-ng-click="moveBackFromService()">
						<i class="fa fa-check"></i>MOVE
					</button>
					<button class="btn btn-warning" data-ng-click="cancel()">
						<i class="fa fa-close"></i>CANCEL
					</button>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />
