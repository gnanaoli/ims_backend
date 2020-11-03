<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ELCBManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">ADD ELCB</h3>
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
								<h4 class="form_content_title">Add ELCB</h4>
								<form class="form-inline"  method="post" name="addelcb" ng-submit="saveelcb(addelcb.$valid)" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="email">Date</label>
										<div class="input-group date" data-date-format="dd/mm/yyyy" data-date-start-date="0d" data-date-end-date="0d" data-date-today-highlight="true" data-date-autoclose="true" data-provide="datepicker">
                                            <div class="input-group-addon inner-addon right-addon ">
                                                <i class="fa fa-calendar"></i>
                                                <input type="text" class="form-control" placeholder="" id="date" name="date" data-ng-model="elcbDto.date"  readonly required  autocomplete="off" tabindex="1">
                                            </div>
                                        </div>
                                        <i class="fa fa-asterisk" ></i>
                                        
					<div data-ng-show="addelcb.$submitted || addelcb.date.$touched" class="error_msg">					
						<div data-ng-show="addelcb.date.$error.required" class="error_msg">Please Select Date </div>
					</div>	                                        
                                        
										</div>
										<div class="add_icon_asterisk">
											<label for="email">Project Name</label>
											
											
							<div class="new-select-option">
								<select name="projectName"
									data-ng-model="elcbDto.projectDto.name"
									required class="select2 form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- Select Category ---</option>

									<option
										data-ng-repeat="x in projectMasterDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
										
										
										
<!-- 											<input -->
<!-- 											list="project" class="form-control"  -->
<!-- 											id="project_List" placeholder="" data-ng-readonly="datareadonly" required name="projectName" -->
<!-- 											data-ng-model="elcbDto.projectDto.name" autocomplete="off" tabindex="2"> -->
<!-- 											<i class="fa fa-asterisk" ></i> -->
<!-- 										<datalist id="project"> -->
<!-- 											<option -->
<!-- 												data-ng-repeat="x in projectMasterDtoList track by x.name" -->
<!-- 												value="{{x.name}}">{{x.name}}</option> -->
<!-- 										</datalist> -->
																			
										
										</div>
										
										
					<div data-ng-show="addelcb.$submitted || addelcb.projectName.$touched" class="error_msg">					
						<div data-ng-show="addelcb.projectName.$error.required" class="error_msg">Please Select Project </div>
					</div>										
										
<!-- 										<div class="add_icon_asterisk"> -->
<!-- 											<label for="pwd">Safety Status:</label> -->
											

<!-- 							<div class="new-select-option"> -->
<!-- 								<select name="safetyStatus" -->
<!-- 									data-ng-model="elcbDto.safetyStatus" -->
<!-- 									required class="select2 form-control" -->
<!-- 									style="width: 100%; height: 36px;"> -->

<!-- 									<option value="" selected>--- Select Category ---</option> -->

<!-- 									<option -->
<!-- 										data-ng-repeat="x in SafetyStatusMasterDtoList" -->
<!-- 										value="{{x.statusName}}">{{x.statusName}}</option> -->

<!-- 								</select> -->
<!-- 								<i class="fa fa-asterisk" ></i> -->
<!-- 							</div> -->
							
							
							
<!-- 									<div class="new-radio-button-inline"> -->
<!-- 										<input type="radio" data-ng-model="elcbDto.safetyStatus" data-ng-change="ischecked(elcbDto.safetyStatus)" required class="with-gap" name="safetyStatus" id="CHECKED" value="CHECKED" > -->
<!-- 										<label for="CHECKED" >CHECKED</label> -->
<!-- 										<input type="radio" data-ng-model="elcbDto.safetyStatus" data-ng-change="ischecked(elcbDto.safetyStatus)" required class="with-gap" name="safetyStatus" id="UNCHECKED" value="UNCHECKED" > -->
<!-- 										<label for="UNCHECKED">UNCHECKED</label> -->
<!-- 									</div> -->
<!-- 							<i class="fa fa-asterisk" ></i> -->
							
											
<!-- 										</div>	 -->
										
										
					<div data-ng-show="addelcb.$submitted || addelcb.safetyStatus.$touched" class="error_msg">					
						<div data-ng-show="addelcb.safetyStatus.$error.required" class="error_msg">Please Select SafetyStatus </div>
					</div>	
					
					
									<div class="add_icon_asterisk" data-ng-if="showWorkingStatus">
											<label for="pwd">Working Status:</label>
											
									<div class="new-radio-button-inline">
										<input type="radio" data-ng-model="elcbDto.workingStatus" required class="with-gap" name="workingStatus" id="WORKING" value="WORKING" >
										<label for="WORKING" >WORKING</label>
										<input type="radio" data-ng-model="elcbDto.workingStatus" required class="with-gap" name="workingStatus" id="NON WORKING" value="NON WORKING" >
										<label for="NON WORKING">NON WORKING</label>
									</div>
							<i class="fa fa-asterisk" ></i>
							
											
										</div>	
										
										
					<div data-ng-show="addelcb.$submitted || addelcb.workingStatus.$touched" class="error_msg">					
						<div data-ng-show="addelcb.workingStatus.$error.required" class="error_msg">Please Select Working Status </div>
					</div>	
					
					
															
																				
										<div class="">
											<label for="pwd">Comments:</label>
											<input type="text" class="form-control" id="comments" name="comments" data-ng-model="elcbDto.comments"  autocomplete="off" tabindex="4">
										</div>	
										
					<div data-ng-show="addelcb.$submitted || addelcb.comments.$touched" class="error_msg">					
						<div data-ng-show="addelcb.comments.$error.required" class="error_msg">Please Enter Comments </div>
					</div>																			

									</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="back()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />