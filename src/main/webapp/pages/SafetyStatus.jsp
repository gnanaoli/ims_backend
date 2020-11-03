 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="SafetyStatusController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-6 align-self-center">
                        <h3 class="text-themecolor">SAFETY STATUS</h3>
                    </div>
                    
                   <div class="col-md-6 align-self-center">
                   
                   <div data-ng-show="SafetyStatusMgt">
                   
                   	<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
                        <ol class="breadcrumb">
                        <li>
                            <a class="btn btn-primary waves-effect waves-light" href="" data-ng-click="newSafetyStatus()">ADD SAFETY STATUS</a>
                        </li>
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
                
                
                


		<div data-ng-if="addnewSafetyStatus==true">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Add Safety Status</h4>
								
								<form class="form-inline" data-ng-submit="saveSafetyStatus(addSafetyStatus.$valid)" method="post" name="addSafetyStatus" novalidate>
									<div class="col-md-6 col_md text-center">

									  <div class="add_icon_asterisk">
											<label for="pwd">Safety Status Name</label>
											<input type="text" class="form-control" id="statusName" onlystring name="statusName"  placeholder=""  data-ng-model="SafetyStatusDto.statusName"   autocomplete="off" tabindex="1" required>
											<i class="fa fa-asterisk" ></i> 
											<!-- <input list="statusName" class="form-control" name="statusName" placeholder="SafetyStatusName"  required
											data-ng-model="SafetyStatusDto.statusName" autocomplete="off" tabindex="1"> -->
										
										</div> 
					<div data-ng-show="addSafetyStatus.$submitted || addSafetyStatus.statusName.$touched" class="error_msg" >
						<div data-ng-show="addSafetyStatus.statusName.$error.required" class="error_msg">Please Enter Safety Status</div>		
									</div>	
									

                 	</div>
					<div class="col-md-6">
				</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>					

							</div>
					</div>
		
		
		
		</div>



                
                
                
                <div data-ng-if="SafetyStatusMgt">
                
                
		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Search Safety Status</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Status </th>
						<th class="not-export-col">Action </th>
					</tr>
					</thead>
					<tbody>
					
						<tr data-ng-repeat="SafetyStatus in SafetyStatusDtoList">
							<td>{{$index+1}}</td>
							<td>{{SafetyStatus.statusName}}</td>
							<td>{{SafetyStatus.status}}</td>	
								<td class="table_btn_group">
							<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
							<a href="" data-ng-click="edit(SafetyStatus)" class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a>
							 </security:authorize> <a href="" data-ng-click="view(SafetyStatus)"
								class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
						</tr>

					</tbody>
				</table>
</div>



			</div>
		</div>
		</div>
		
		
		
		
		
		
		<div data-ng-if="editSafetyStatus==true">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Edit Safety Status</h4>
								
								<form class="form-inline" data-ng-submit="saveSafetyStatus(editSafetyStatus.$valid)" method="post" name="editSafetyStatus" novalidate>
									<div class="col-md-6 col_md text-center">

											<div class="add_icon_asterisk">
											<label for="pwd">Safety Status Name</label>
											
				<input type="text" class="form-control" id="statusName" name="statusName" onlystring data-ng-model="SafetyStatusDto.statusName" required>
				<i class="fa fa-asterisk" ></i> 
				<input type="hidden" class="form-control" id="id" name="id" data-ng-model="SafetyStatusDto.id" required> 
							</div>				
										
					<div data-ng-show="editSafetyStatus.$submitted || editSafetyStatus.statusName.$touched" class="error_msg" class="error_msg">
						<div data-ng-show="editSafetyStatus.statusName.$error.required" class="error_msg" class="error_msg">Please Select Name</div>
					</div>										
									

																				

										<div class="add_icon_asterisk">
											<label for="">Status:</label>
											
											
									<div class="new-radio-button-inline">
										<input type="radio" name="status" id="ACTIVE" value="ACTIVE" required data-ng-model="SafetyStatusDto.status" class="with-gap">
										<label for="ACTIVE" >ACTIVE</label>
										<input type="radio" name="status" id="INACTIVE" value="INACTIVE" required data-ng-model="SafetyStatusDto.status" class="with-gap">
										<label for="INACTIVE">INACTIVE</label> 
									</div>											
											
										<i class="fa fa-asterisk" ></i>	
										</div>
										
					<div data-ng-show="editSafetyStatus.$submitted || editSafetyStatus.status.$touched" class="error_msg">					
						<div data-ng-show="editSafetyStatus.status.$error.required" class="error_msg">Please Enter Status </div>
					</div>	

									</div>
									<div class="col-md-6">
									</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>					

							</div>
					</div>
		
		
		
		</div>
		
		
		

		
		
		  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">SafetyStatus</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th> Name </th><td>{{view_SafetyStatus_details.statusName}}</td></tr>							
							<tr><th>Status</th><td>{{view_SafetyStatus_details.status}}</td></tr>
			</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
		
		
		
		
		
		
		
		
		
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />