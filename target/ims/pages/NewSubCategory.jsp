<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="subCategoryManagementController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">SUB CATEGORY CREATION</h3>
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
								<h4 class="form_content_title">Create New Sub Category  </h4>
								<form class="form-inline"  method="post" role="form" name="new_subcategory" id="new_category" novalidate >
									<div class="col-md-6 col_md text-center">
										<div class="add_icon_asterisk">
											<label for="email">CategoryType</label>
											<input
											list="category" class="form-control" 
											id="category_List" placeholder="" ng-readonly="datareadonly" 
											data-ng-model="subCategoryDto.categoryDto.categoryType" name="categoryType" data-ng-blur="ValidateCategoryType(subCategoryDto.categoryType)" required autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										<datalist id="category">
											<option
												ng-repeat="x in categoryMasterDtoList track by x.categoryType"
												value="{{x.categoryType}}">{{x.categoryType}}</option>
										</datalist>
										</div>
										
										<div data-ng-show="new_subcategory.$submitted || new_subcategory.categoryType.$touched" class="error_msg">
									<div data-ng-show="new_subcategory.categoryType.$error.required" class="error_msg">Please Select  Category Type</div>
									</div>
										<div class="add_icon_asterisk">
											<label for="pwd"> Sub Category:</label>
											<input type="text" class="form-control" id="subCategory" name="subCategory" data-ng-model="subCategoryDto.subCategory" required="required" autocomplete="off" tabindex="2" >
											<i class="fa fa-asterisk" ></i>
										</div>
										
										<div data-ng-show="new_subcategory.$submitted || new_subcategory.subCategory.$touched" class="error_msg">
									<div data-ng-show="new_subcategory.subCategory.$error.required" class="error_msg">Please Enter Sub Category </div>
									</div>
										<div class="add_icon_asterisk">
											<label for="pwd"> Model Code:</label>
											<input type="text" class="form-control" id="model" name="model" data-ng-model="subCategoryDto.model" required="required" autocomplete="off" tabindex="3">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="new_subcategory.$submitted || new_subcategory.model.$touched" class="error_msg">
									<div data-ng-show="new_subcategory.model.$error.required" class="error_msg">Please Enter Model </div>
									</div>
										
										<div class="add_icon_asterisk">
											<label for="pwd"> HSN Code:</label>
											<input type="text" class="form-control" id="hsnCode" name="hsnCode" data-ng-model="subCategoryDto.hsnCode" required="required" autocomplete="off"  tabindex="4">
											<i class="fa fa-asterisk" ></i>
										</div>
										<div data-ng-show="new_subcategory.$submitted || new_subcategory.hsnCode.$touched" class="error_msg">
									<div data-ng-show="new_subcategory.hsnCode.$error.required" class="error_msg">Please  Enter HSN Code </div>
									</div>
									</div>
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="saveSubCategory()"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />