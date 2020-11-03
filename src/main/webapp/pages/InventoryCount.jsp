
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
	data-ng-controller="InventoryCountController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">Inventory Details</h3>
		</div>
		<div class="col-md-7 align-self-center"></div>

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
			<h4 class="form_content_title">Inventory Details</h4>

			<div class="table-responsive"
				data-ng-if="TempMaster.length > 0">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Sub Category</th>
							<th>Quantity</th>
						</tr>
					</thead>




					<tbody>

						<%-- <security:authorize access="hasAuthority('USER')">
						<tr data-ng-repeat="inventoryDto in inventoryAssignMasterList">
							<td>{{inventoryDto.subCategory}}</td>
							<td>{{inventoryDto.availableQuantity}}</td>
						</tr>
						</security:authorize> --%>
						<tr data-ng-repeat="inventoryDto in inventoryManagementMaster">
							<td>{{inventoryDto.subCategory}}</td>
							<td>{{inventoryDto.availableQuantity}}</td>
						</tr>
					</tbody>
				</table>
			</div>



			<div class="text-center"
				data-ng-if="TempMaster.length == 0">
				<br> <br> <strong><b>{{alertMsg}}</b></strong>
			</div>

		</div>
	</div>




</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />