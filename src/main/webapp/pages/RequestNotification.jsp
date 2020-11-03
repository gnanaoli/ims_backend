 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="inventoryManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">REQUESTS NOTIFICATIONS</h3>
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
				<h4 class="form_content_title">Search Requests</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Category Type</th>
							 <th>Sub Category</th>
							<th>Model</th>
							<th>Quantity</th>
							<th>Reference No</th>
							<th>From Site</th>
							<th>To Site</th>
							<th>status</th> 
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
						<tr data-ng-repeat="inventoryManagementDto in moveRequestNotificationDtoList">
							<td>{{inventoryManagementDto.category}}</td>
							 <td>{{inventoryManagementDto.subCategory}}</td>
							<td>{{inventoryManagementDto.modelCode}}</td>
							<td>{{inventoryManagementDto.quantity}}</td>
							<td>{{inventoryManagementDto.referenceNo}}</td>
							<td>{{inventoryManagementDto.requestedFrom}}</td>
							<td>{{inventoryManagementDto.requestedTo}}</td>
							<td>{{inventoryManagementDto.status}}</td>
							<td class="table_btn_group"><a href="" data-ng-click="confirm(inventoryManagementDto)" class="btn btn-primary">ACCEPT</a></td> 
						</tr>
						</security:authorize>
					</tbody>
				</table>
</div>



			</div>
		</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />