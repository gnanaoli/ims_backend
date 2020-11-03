 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="MyRequestController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">MY REQUEST</h3>
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
				<h4 class="form_content_title">SEARCH MY REQUEST</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
					<tr>
						<th>category</th>
						<th>subCategory</th>
						<th>modelCode </th>
						<th>quantity</th>
						<th>referenceNo</th>
						<th>RequestedTo</th>
						<th>status</th>
						<th>Sub Status</th>
						
					</tr>
					</thead>
					<tbody>
					
						<tr data-ng-repeat="myRequest in MyRequestDtoList">
							<td>{{myRequest.categoryType}}</td>
							<td>{{myRequest.subCategory}}</td>
							<td>{{myRequest.modelCode}}</td>
							<td>{{myRequest.quantity}}</td>
							<td>{{myRequest.referenceNo}}</td>
							<td>{{myRequest.requestedTo}}</td>
							<td>{{myRequest.status}}</td>
							<td>{{myRequest.subStatus}}</td>
						</tr>

					</tbody>
				</table>

			</div>



			</div>
		</div>

		
		
		
		
		
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />