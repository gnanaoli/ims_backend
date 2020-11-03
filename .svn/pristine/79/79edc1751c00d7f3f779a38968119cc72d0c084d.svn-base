<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="WorksMenCategoryManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">WORKSMEN CATEGORY</h3>
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
								<h4 class="form_content_title">Add WorksMen Category</h4>
								<form class="form-inline"  method="post" name="addWorksMenCategory" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="pwd"> Category Name:</label>
											<input type="text" class="form-control" id="category" name="category" data-ng-model="WorksMenDto.category" required autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										</div>	
										
					<div data-ng-show="addWorksMenCategory.$submitted || addWorksMenCategory.category.$touched" class="error_msg">					
						<div data-ng-show="addWorksMenCategory.category.$error.required" class="error_msg">Please Enter Category </div>
					</div>																	

									</div>
									<div class="col-md-6">
									</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveWorksMenCategory()"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="back()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />