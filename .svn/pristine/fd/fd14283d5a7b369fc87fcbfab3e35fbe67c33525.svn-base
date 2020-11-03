<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="dashBoardController1">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">ELCB DETAILS</h3>
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
				<h4 class="form_content_title">Search Elcb Status</h4>


<div class="table-responsive">
				<table data-datatable="ng" data-dt-options="dtOptions" 
					class="table table-striped table-bordered" style="width:100%">
					<thead>
						<tr>
							<th>Date</th>
							<th>Project Name</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="elcb_dto in elcb_Status_Master">
							<td>{{elcb_dto.date}}</td>
							<td>{{elcb_dto.projectName}}</td>
							<td>{{elcb_dto.safetyStatus}}</td>
							<td class="table_btn_group">
							<a href="" data-ng-click="view(elcb_dto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a>
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
          <h4 class="modal-title">ELCB Details</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>Date</th><td>{{elcb_dto.date}}</td></tr>
							<tr><th>Project Name</th><td>{{elcb_dto.projectName}}</td></tr>
							<tr><th>Updated Time</th><td>{{elcb_dto.upDatedTime | date : "dd/MM/yyyy hh:mm:ss"}}</td></tr>
							<tr><th>Status</th><td>{{elcb_dto.safetyStatus}}</td></tr>
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