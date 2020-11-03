<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ServiceDueDateController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">SERVICE DUE DETAILS</h3>
                    </div>

<!--                    <div class="col-md-7 align-self-center"> -->
<!--                         <ol class="breadcrumb"> -->
<!--                             <a class="btn btn-primary waves-effect waves-light" href="common?link=AddSupplier">Add supplier</a> -->
<!--                         </ol> -->
<!--                     </div> -->
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
				<h4 class="form_content_title">Service Due Details</h4>


				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Category Type</th>
							<th>Sub Category</th>
							<th>Location</th>
							<th>Due Date</th>
							<th>Due Month</th>
							<th>Action</th>

						</tr>
					</thead>
					<tbody>


                <tr data-ng-repeat="ServiceDueDto in ServiceDueMaster">
                    <td>{{ServiceDueDto.categoryType}}</td>
                    <td>{{ServiceDueDto.subCategory}}</td>
                    <td>{{ServiceDueDto.warehouseOrSitename}}</td>
                    <td>{{ServiceDueDto.serviceDueDate}}</td>
                    <td>{{ServiceDueDto.due_month}}</td>
                     <td><!-- <a href="" data-ng-click="edit(ScrapDto)"><i class="fa fa-edit"></i> Edit</a> -->
                    <a href="" data-ng-click="view(ServiceDueDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
                </tr>



					</tbody>


				</table>



			</div>
		</div>
		
		
		
		
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Scrap Details</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>Category Type </th><td>{{ServiceDueDto.categoryType}}</td></tr>
							<tr><th>Sub Category</th><td>{{ServiceDueDto.subCategory}}</td></tr>
							<tr><th>Location</th><td>{{ServiceDueDto.warehouseOrSitename}}</td></tr>
							<tr><th>Service Due Date</th><td>{{ServiceDueDto.serviceDueDate}}</td></tr>
							<tr><th>Due Month</th><td>{{ServiceDueDto.due_month}}</td></tr>
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