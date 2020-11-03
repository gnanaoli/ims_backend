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
                        <h3 class="text-themecolor">RECEIVED TOOLS REQUESTS </h3>
                    </div>
                    <div class="col-md-7 align-self-center">
                         <security:authorize access="hasAuthority('USER')">
                        <ol class="breadcrumb">
                            <li><a class="btn btn-primary waves-effect waves-light" href="common?link=BulkRequest">PLACE REQUEST</a></li>
                        </ol>
                        </security:authorize>
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

			<div class="form-content">
				<h4 class="form_content_title">Tools Requests to the Current User</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Category Type</th>
							 <th>Sub Category</th>
							 <th>Model</th>
							<th>Request From</th>
							<th>Request To</th>
							<th>Quantity</th>
							<th>Action</th> 
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="inventoryRequestDto in inventoryRequestDtoList">
							<td>{{inventoryRequestDto.category}}</td>
							 <td>{{inventoryRequestDto.subCategory}}</td>
							<td>{{inventoryRequestDto.modelCode}}</td>
							<td>{{inventoryRequestDto.requestedFrom}}</td>
							<td>{{inventoryRequestDto.requestedTo}}</td>
							<td>{{inventoryRequestDto.quantity}}</td>
							
							<td class="table_btn_group">
							<security:authorize access="hasAuthority('USER') or hasAuthority('WAREHOUSE ADMINISTRATOR')">
							<a href="" data-ng-click="viewAccept(inventoryRequestDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> VIEW REQUEST</a>
							</security:authorize>
							<security:authorize access="hasAuthority('ENQUIRY')">
							<a href="" data-ng-click="view(inventoryRequestDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> VIEW</a>
							</security:authorize>
							</td> 
						</tr>
					</tbody>
				</table>
</div>



			</div>
		</div>
		
		
		
		
				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Tools Request Details</h4>
							</div>
							<div class="modal-body">
								<table class="table table-bordered table-striped">
									<tr>
										<th>Category Type</th>
										<td>{{inventoryRequestDto.category}}</td>
									</tr>
									<tr>
										<th>Sub Category</th>
										<td>{{inventoryRequestDto.subCategory}}</td>
									</tr>
									<tr>
										<th>Model</th>
										<td>{{inventoryRequestDto.modelCode}}</td>
									</tr>
																		<tr>
										<th>Request From</th>
										<td>{{inventoryRequestDto.requestedFrom}}</td>
									</tr>
																		<tr>
										<th>Request To</th>
										<td>{{inventoryRequestDto.requestedTo}}</td>
									</tr>
																	<tr>
										<th>Quantity</th>
										<td>{{inventoryRequestDto.quantity}}</td>
									</tr>
									
								</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>		
		
		
		
		
		
		
		
		
		
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />