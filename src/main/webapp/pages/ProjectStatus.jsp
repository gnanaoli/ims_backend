 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ProjectStatusController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-6 align-self-center">
                        <h3 class="text-themecolor">PROJECT  STATUS</h3>
                    </div>
                    
                   <div class="col-md-6 align-self-center">
                   
                   <div data-ng-show="ProjectStatusTable">
                   
                   	<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
                        <ol class="breadcrumb">
                        <li>
                            <a class="btn btn-primary waves-effect waves-light"  href="" data-ng-click="newProjectStatus()">ADD PROJECT STATUS</a>
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
                
                
                <div data-ng-if="ProjectStatusTable">
                
                
		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Search Project Status</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
					<tr>
					    <th>Id</th>
						<th>Project Status</th>
						<th>Status </th>
						<th class="not-export-col">Action </th>
						
					</tr>
					</thead>
					<tbody>
					
						<tr data-ng-repeat="projectStatus_details in ProjectStatusList">
						<td>{{$index+1}}</td>
							<td>{{projectStatus_details.projectstatus}}</td>
							<td>{{projectStatus_details.status}}</td>	
							
								<td class="table_btn_group">
							<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
							<a href="" data-ng-click="edit(projectStatus_details)" class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a>
							 </security:authorize>
							<a href="" data-ng-click="view(projectStatus_details)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
						</tr>

					</tbody>
				</table>
</div>



			</div>
		</div>
		</div>
		
		
		
		
		
		
		<div data-ng-if="editProjectStatus==true">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Edit Project Status</h4>
								
								<form class="form-inline"  method="post" data-ng-submit="saveProjectStatus(editProjectStatusForm.$valid)" name="editProjectStatusForm" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="pwd"> Project Status:</label>
											<input type="text" class="form-control" id="projectstatus" name="projectstatus" data-ng-model="ProjectDto.projectstatus" allowspace required maxlength="25" autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="ProjectDto.id" required>
										</div>	
										
					<div data-ng-show="editProjectStatus.Form$submitted || editProjectStatusForm.projectstatus.$touched" class="error_msg">					
						<div data-ng-show="editProjectStatusForm.category.$error.required" class="error_msg">Please Enter Project Type</div>
					</div>											
										
								<div class="add_icon_asterisk">
											<label for="">Status:</label>
											
											
									<div class="new-radio-button-inline">
										<input type="radio" name="status" id="ACTIVE" value="ACTIVE"  data-ng-model="ProjectDto.status" class="with-gap" required tabindex="2">
										<label for="ACTIVE" >ACTIVE</label>
										<input type="radio" name="status" id="INACTIVE" value="INACTIVE" data-ng-model="ProjectDto.status" class="with-gap" required tabindex="3">
										<label for="INACTIVE">INACTIVE</label> 
									</div>											
										<i class="fa fa-asterisk" ></i>		
											
										</div>
										
										
									<div data-ng-show="editProjectStatusForm.$submitted || editProjectStatusForm.status.$touched" class="error_msg">					
										<div data-ng-show="editProjectStatusForm.status.$error.required" class="error_msg">Please Select Status </div>
									</div>										

									</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>						

							</div>
					</div>
		
		
		
		</div>
		
		
		
		
		<div data-ng-if="addProjectStatusDiv==true">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Add Project Status</h4>
								
								<form class="form-inline"  method="post" data-ng-submit="saveProjectStatus(addProjectStatus.$valid)" name="addProjectStatus" id="addProjectStatus" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="pwd"> Project Status:</label>
											<input type="text" class="form-control" id="projectstatus" name="projectstatus" data-ng-model="ProjectDto.projectstatus" allowspace required maxlength="25" autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
											<!-- <input type="hidden" class="form-control" id="id" name="id" data-ng-model="ProjectDto.id" required> -->
										</div>	
										
					<div data-ng-show="addProjectStatus.$submitted || addProjectStatus.projectstatus.$touched" class="error_msg">					
						<div data-ng-show="addProjectStatus.projectstatus.$error.required" class="error_msg">Please Enter Project Status</div>
					</div>											

									</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<button class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</button>
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
          <h4 class="modal-title">Project Status</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>Project Status </th><td>{{view_projectStatus_details.projectstatus}}</td></tr>							
							<tr><th>Status</th><td>{{view_projectStatus_details.status}}</td></tr>
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