 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ELCBManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">ELCB</h3>
                    </div>
                    
                   <div class="col-md-7 align-self-center">
                   
                   <div data-ng-show="ELCBMgt">
                    <security:authorize access="hasAuthority('SAFETY ENGINEER')">
                        <ol class="breadcrumb">
                            <li><a class="btn btn-primary waves-effect waves-light" href="common?link=AddELCB">Add ELCB </a></li>
                        </ol>
                        </security:authorize>
                    </div>
                    
                    
                    </div>

                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                
                
                <div data-ng-show="ELCBMgt">
                
                
		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Search ELCB</h4>


				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
					<tr>
						<th>Date </th>
						<th>Project Name</th>
						<th>Updated Time</th>
<!-- 						<th>Status</th> -->
						<th class="not-export-col">Action </th>
						
					</tr>
					</thead>
					<tbody>
					
					
						<security:authorize access="hasAuthority('SAFETY ENGINEER') or hasAuthority('USER')">
							<tr data-ng-repeat="elcp_details in elcpMasterDtoList" data-ng-if="elcp_details.userDto.userName=='<security:authentication property="details.userName"/>'">
						</security:authorize>
						<security:authorize access="hasAuthority('ENQUIRY')">
							<tr data-ng-repeat="elcp_details in elcpMasterDtoList">
						</security:authorize>
							<td>{{elcp_details.date}}</td>
							<td>{{elcp_details.projectDto.name}}</td>
							<td>{{elcp_details.upDatedTime | date : "dd/MM/yyyy"}}</td>
<!-- 							<td>{{elcp_details.safetyStatus}}</td>							 -->
							<td class="table_btn_group">
<%-- 							 <security:authorize access="hasAuthority('SAFETY ENGINEER')"> --%>
							 
<!-- 							<span data-ng-if="(elcp_details.date == todayDate)"><a href="" data-ng-click="edit(elcp_details)" class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a></span> -->
<%-- 							</security:authorize> --%>
							<a href="" data-ng-click="view(elcp_details)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
						</tr>

					</tbody>
				</table>

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">ELCB Details</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>Date </th><td>{{ELCBManagementDetails.date}}</td></tr>
							<tr><th>Project Name</th><td>{{ELCBManagementDetails.projectDto.name}}</td></tr>
<!-- 							<tr><th>Status</th><td>{{ELCBManagementDetails.safetyStatus}}</td></tr> -->
			</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>



			</div>
		</div>
		</div>
		
		
		
		
		
		
		<div data-ng-if="editELCB">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Edit ELCB</h4>
								<form class="form-inline"  method="post" name="addelcb" ng-submit="saveelcb(addelcb.$valid)" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="email">Date</label>
										<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-end-date="0d" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="date" name="date" data-ng-model="elcbDto.date"  readonly>
                                            </div>
                                        </div>
                                        <i class="fa fa-asterisk" ></i>
										</div>
										
										
					<div data-ng-show="addelcb.$submitted || addelcb.date.$touched" class="error_msg">					
						<div data-ng-show="addelcb.date.$error.required" class="error_msg">Please Select Date </div>
					</div>											
										
										<div class="add_icon_asterisk">
											<label for="email">Project Name</label>
											
							<div class="new-select-option">
								<select name="projectName" wb-select2
									data-ng-model="elcbDto.projectDto.name"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- Select Category ---</option>

									<option
										data-ng-repeat="x in projectMasterDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
											
<!-- 											<input -->
<!-- 											list="project" class="form-control"  -->
<!-- 											id="project_List" placeholder="project" data-ng-readonly="datareadonly" required name="projectName" -->
<!-- 											data-ng-model="elcbDto.projectDto.name" autocomplete="off"> -->
<!-- 										<datalist id="project"> -->
<!-- 											<option -->
<!-- 												data-ng-repeat="x in projectMasterDtoList track by x.name" -->
<!-- 												value="{{x.name}}">{{x.name}}</option> -->
<!-- 										</datalist> -->
										
										</div>
										
										
					<div data-ng-show="addelcb.$submitted || addelcb.projectName.$touched" class="error_msg">					
						<div data-ng-show="addelcb.projectName.$error.required" class="error_msg">Please Select Project </div>
					</div>											
										
<!-- 										<div class="add_icon_asterisk"> -->
<!-- 											<label for="pwd">Safety Status:</label> -->
											
<!-- 							<div class="new-select-option"> -->
<!-- 								<select name="safetyStatus" wb-select2 -->
<!-- 									data-ng-model="elcbDto.safetyStatus" -->
<!-- 									required class="form-control" -->
<!-- 									style="width: 100%; height: 36px;"> -->

<!-- 									<option value="" selected>--- Select Category ---</option> -->

<!-- 									<option -->
<!-- 										data-ng-repeat="x in SafetyStatusMasterDtoList" -->
<!-- 										value="{{x.statusName}}">{{x.statusName}}</option> -->

<!-- 								</select> -->
<!-- 								<i class="fa fa-asterisk" ></i> -->
<!-- 							</div> -->


<!-- 									<div class="new-radio-button-inline"> -->
<!-- 										<input type="radio" data-ng-model="elcbDto.safetyStatus" data-ng-change="ischecked(elcbDto.safetyStatus)" data-ng-checked="ischecked(elcbDto.safetyStatus)" required class="with-gap" name="safetyStatus" id="CHECKED" value="CHECKED" > -->
<!-- 										<label for="CHECKED" >CHECKED</label> -->
<!-- 										<input type="radio" data-ng-model="elcbDto.safetyStatus" data-ng-change="ischecked(elcbDto.safetyStatus)" data-ng-checked="ischecked(elcbDto.safetyStatus)" required class="with-gap" name="safetyStatus" id="UNCHECKED" value="UNCHECKED" > -->
<!-- 										<label for="UNCHECKED">UNCHECKED</label> -->
<!-- 									</div> -->
<!-- 							<i class="fa fa-asterisk" ></i> -->

											
											
<!-- 											<input type="text" class="form-control" id="safetyStatus" name="safetyStatus" data-ng-model="elcbDto.safetyStatus" required> -->
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="elcbDto.id" required>
<!-- 										</div>	 -->
										
										
					<div data-ng-show="addelcb.$submitted || addelcb.safetyStatus.$touched" class="error_msg">					
						<div data-ng-show="addelcb.safetyStatus.$error.required" class="error_msg">Please Select SafetyStatus </div>
					</div>	
					
					
														<div class="add_icon_asterisk" data-ng-if="showWorkingStatus">
											<label for="pwd">Working Status:</label>
											
									<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="elcbDto.workingStatus" required class="with-gap" name="workingStatus" id="WORKING" value="WORKING" >
										<label for="WORKING" >WORKING</label>
										<input type="radio" data-ng-model="elcbDto.workingStatus" required class="with-gap" name="workingStatus" id="NON WORKING" value="NON WORKING" >
										<label for="NON WORKING">NON WORKING</label>
									</div>
							<i class="fa fa-asterisk" ></i>
							
											
										</div>	
										
										
					<div data-ng-show="addelcb.$submitted || addelcb.workingStatus.$touched" class="error_msg">					
						<div data-ng-show="addelcb.workingStatus.$error.required" class="error_msg">Please Select Working Status </div>
					</div>	
																				
										<div class="">
											<label for="pwd">Comments:</label>
											<input type="text" class="form-control" id="comments" name="comments" data-ng-model="elcbDto.comments">
										</div>		
										
					<div data-ng-show="addelcb.$submitted || addelcb.comments.$touched" class="error_msg">					
						<div data-ng-show="addelcb.comments.$error.required" class="error_msg">Please Enter Comments </div>
					</div>																		

									</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<button class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</button>
										</div>
								</form>
							</div>
					</div>
		
		
		
		</div>
		
		
		
		
		
		
		
		
		
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />