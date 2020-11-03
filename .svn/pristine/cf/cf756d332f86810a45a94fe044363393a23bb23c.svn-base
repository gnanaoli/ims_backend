 <jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="DesignationController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">ADD DESIGNATION</h3>
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
							<div class="form-content create_form">
								<h4 class="form_content_title">Add Designation</h4>
								<form class="form-inline"  method="post" name="addDesignation" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="pwd"> Designation Name:</label>
											<input type="text" class="form-control" id="designation" name="designation" data-ng-model="DesignationDto.designation" required>
											<i class="fa fa-asterisk" ></i> 
										</div>	
										
					<div data-ng-show="addDesignation.$submitted || addDesignation.designation.$touched" class="error_msg">					
						<div data-ng-show="addDesignation.designation.$error.required" class="error_msg">Please Enter Designation </div>
					</div>																	

									
									</div>
									<div class="col-md-6">
									</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveDesignation()"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="back()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />