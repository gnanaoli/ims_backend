<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ScrapController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">SCRAP DETAILS</h3>
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
				<h4 class="form_content_title">Search Scrap</h4>


				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Category Type</th>
							<th>Category Name</th>
							<th>Model</th>
							<th>Quantity</th>
							<th>From</th>
							<th>To</th>
							<th>Date Of Scrap</th>
							<th>Action</th>

						</tr>
					</thead>
					<tbody>


                <tr data-ng-repeat="ScrapDto in ScrapMaster">
                    <td>{{ScrapDto.category.categoryType}}</td>
                    <td>{{ScrapDto.subCategory.subCategory}}</td>
                    <td>{{ScrapDto.subCategory.model}}</td>
                    <td>{{ScrapDto.quantity}}</td>
                    <td>{{ScrapDto.fromLocation}}</td>
                    <td>{{ScrapDto.warehouseSiteName}}</td>
                    <td>{{ScrapDto.raisedDate | date : "dd/MM/yyyy"}}</td>
                     <td><!-- <a href="" data-ng-click="edit(ScrapDto)"><i class="fa fa-edit"></i> Edit</a> -->
                    <a href="" data-ng-click="view(ScrapDto)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
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
         					<tr><th>Category Type </th><td>{{view_scrap_details.category.categoryType}}</td></tr>
							<tr><th>Category Code</th><td>{{view_scrap_details.category.categoryCode}}</td></tr>
							<tr><th>Category Name</th><td>{{view_scrap_details.subCategory.subCategory}}</td></tr>
							<tr><th>Model</th><td>{{view_scrap_details.subCategory.model}}</td></tr>
							<tr><th>Date Of Scrap</th><td>{{view_scrap_details.raisedDate | date : "dd/MM/yyyy h:mm a"}}</td></tr>
							<tr><th>Status</th><td>{{view_scrap_details.status}}</td></tr>
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