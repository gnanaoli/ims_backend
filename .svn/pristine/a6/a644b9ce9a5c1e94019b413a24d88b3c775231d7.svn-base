<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="StateController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">ADD STATE</h3>
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
								<h4 class="form_content_title">Add State</h4>
								<form class="form-inline"  method="post" name="addstate" novalidate>
									<div class="col-md-6 col_md text-center">							
									
										<div class="add_icon_asterisk">
											<label for="pwd"> State Code:</label>
											<input type="text" class="form-control" id="statecode" alphamumeric name="statecode"maxlength="3" data-ng-model="stateDto.stateCode" required autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										</div>	
										
					<div data-ng-show="addstate.$submitted || addstate.statecode.$touched" class="error_msg">					
						<div data-ng-show="addstate.statecode.$error.required" class="error_msg">Please Enter StateCode </div>
					</div>										
									
									
										<div class="add_icon_asterisk">
											<label for="pwd"> State Name:</label>
											<input type="text" class="form-control" id="state" name="state" allowspace maxlength="50" data-ng-model="stateDto.stateName" required autocomplete="off" tabindex="2">
											<i class="fa fa-asterisk" ></i>
										</div>	
										
					<div data-ng-show="addstate.$submitted || addstate.state.$touched" class="error_msg">					
						<div data-ng-show="addstate.state.$error.required" class="error_msg">Please Enter StateName </div>
					</div>																	

									</div>
									<div class="col-md-6">
									</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveState()"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />