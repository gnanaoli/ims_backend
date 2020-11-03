 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ServiceController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">TOOLS IN SERVICE </h3>
                    </div>
                    
                    
                    <div class="col-md-7 align-self-center">
                         <security:authorize access="hasAuthority('USER')">
                        <!-- <ol class="breadcrumb">
                           <a class="btn btn-primary waves-effect waves-light" href="common?link=BulkRequest">PLACE REQUEST</a> 
                        </ol> -->
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
				<h4 class="form_content_title">Tools in Service</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Category Type</th>
							<th>Category Name</th>
							<th>Created By</th>
							 <th>Creation Date</th>
							 <th>Quantity</th>
							 <th>Inventory No</th>
							<th>From</th>
							<th>To</th>
							
				     	<th>Action</th>
						 
					</thead>
					<tbody>
						<tr data-ng-repeat="serviceTrackerDto in serviceTrackerDtoList">
						
						 <td>{{serviceTrackerDto.category1.categoryType}}</td>
                    <td>{{serviceTrackerDto.subCategory1.subCategory}}</td>
						 <td>{{serviceTrackerDto.createdBy}}</td>
							<td>{{serviceTrackerDto.creationDate}}</td>
							<td>{{serviceTrackerDto.quantity}}</td>
							<td>{{serviceTrackerDto.inventoryNumber}}</td>
						
                    
                    <!-- <td>{{ScrapDto.subCategory.model}}</td>
                    <td>{{ScrapDto.quantity}}</td> -->
                    <td>{{serviceTrackerDto.fromLocation}}</td>
                    <td>{{serviceTrackerDto.warehouseSiteName}}</td>
                    
                 
                    
                    
                    
                    <!-- <td class="table_btn_group"><a href="" data-ng-click="sendBack(serviceTrackerDto)" class="btn btn-primary"><i class="fa fa-arrow-left"></i> SEND BACK</a> --> 
							<td><a href="" data-ng-click="view(serviceTrackerDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View	</a></td>					 
						</tr>
						
					</tbody>
				</table>
</div>



			</div>
		</div>
         

            <!-- Row -->
            <!-- ============================================================== -->

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Tools in Service</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>Id </th><td>{{serviceTrackerDto.id}}</td></tr>
							<tr><th>Created By</th><td>{{serviceTrackerDto.createdBy}}</td></tr>
							<tr><th>Creation Date</th><td>{{serviceTrackerDto.creationDate}}</td></tr>
							<tr><th>Quantity</th><td>{{serviceTrackerDto.quantity}}</td></tr>
							<tr><th>Inventory No</th><td>{{serviceTrackerDto.inventoryNumber}}</td></tr>
							<tr><th>Serial Number</th><td>{{serviceTrackerDto.serialNumber}}</td></tr>
							<tr><th>Status</th><td>{{serviceTrackerDto.status}}</td></tr>
							<tr><th>Category Type </th><td>{{serviceTrackerDto.category1.categoryType}}</td></tr>
							<tr><th>Category Name</th><td>{{serviceTrackerDto.subCategory1.subCategory}}</td></tr>
							<tr><th>Status</th><td>{{serviceTrackerDto.status}}</td></tr>
							
							
							
							
			</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>



   </div>

<jsp:include page="footer.jsp" />