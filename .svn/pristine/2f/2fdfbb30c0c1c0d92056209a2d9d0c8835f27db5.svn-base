<jsp:include page="header.jsp" />



<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid user-top"
	data-ng-controller="BulkRequestController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">BULK REQUEST TOOLS</h3>
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
			<h4 class="form_content_title">Bulk Request Tools</h4>


<!-- 			<br> <br> -->
<!-- 			<div data-ng-show="bubble1==false"> -->

<!-- 				<button class="btn btn-primary text-center" data-ng-click="show()" -->
<!-- 					style="display: table; margin: auto;"> -->
<!-- 					<i class="fa fa-plus-square"></i> Give Request -->
<!-- 				</button> -->
<!-- 				<br> -->

<!-- 			</div> -->

			<div data-ng-show="selectTools">
				<form class="form-inline" role="form" name="bulk_request" data-ng-submit="add(bulk_request.$valid)"
					id="bulk_request" novalidate>
					<div class="col-md-6 col_md text-center">

						<div class="add_icon_asterisk">
							<label for="email">Category Type</label>


							<div class="new-select-option">
								<select name="categoryType" id="categoryType"
									data-ng-model="toolsdetails.categoryType"
									data-ng-change="getSubCategoryByCategory(toolsdetails.categoryType)"
									required class="select2 form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- Select Category ---</option>

									<option
										data-ng-repeat="x in categoryMasterDtoList track by x.categoryType"
										value="{{x.categoryType}}">{{x.categoryType}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>







							<!-- 							<input list="category" class="form-control" id="category_List" -->
							<!-- 								placeholder="categoryType" data-ng-readonly="datareadonly" -->
							<!-- 								required data-ng-model="toolsdetails.categoryType" -->
							<!-- 								name="categoryType" -->
							<!-- 								data-ng-blur="getSubCategoryByCategory(toolsdetails.categoryType)"> -->
							<!-- 							<datalist id="category"> -->
							<!-- 								<option -->
							<!-- 									data-ng-repeat="x in categoryMasterDtoList track by x.categoryType" -->
							<!-- 									value="{{x.categoryType}}">{{x.categoryType}}</option> -->
							<!-- 							</datalist> -->
							<input type="hidden" name="id" data-ng-model="toolsdetails.id"
								required> <input type="hidden" name="subCategoryid"
								data-ng-model="toolsdetails.subCategoryid" required> <div
								class="error_msg"
								data-ng-show="bulk_request.$submitted || bulk_request.categoryType.$touched" class="error_msg">
								<div data-ng-show="bulk_request.categoryType.$error.required" class="error_msg">Please
									select Category Type</div>
							</div>
						</div>

						<div class="add_icon_asterisk">
							<label for="pwd">Sub Category</label>



							<div class="new-select-option">
								<select class="select2 form-control" required id="subCategory"
									data-ng-model="toolsdetails.subCategory" name="subCategory"
									data-ng-change="getModelBySubCategoryName(toolsdetails.subCategory)"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- Select SubCategory ---</option>

									<option
										data-ng-repeat="x in subCategoryMasterDtoList track by x.subCategory"
										value="{{x.subCategory}}">{{x.subCategory}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>





							<!-- 							<input list="subCategory" class="form-control" -->
							<!-- 								id="subCategory_List" placeholder="subCategory" -->
							<!-- 								data-ng-readonly="datareadonly" required -->
							<!-- 								data-ng-model="toolsdetails.subCategory" name="subCategory" -->
							<!-- 								data-ng-blur="getModelBySubCategoryName(toolsdetails.subCategory)"> -->
							<!-- 							<datalist id="subCategory"> -->
							<!-- 								<option -->
							<!-- 									data-ng-repeat="x in subCategoryMasterDtoList track by x.subCategory" -->
							<!-- 									value="{{x.subCategory}}">{{x.subCategory}}</option> -->
							<!-- 							</datalist> -->
							<div class="error_msg"
								data-ng-show="bulk_request.$submitted || bulk_request.subCategory.$touched" class="error_msg">
								<div data-ng-show="bulk_request.subCategory.$error.required" class="error_msg">Please
									select sub Category</div>
							</div>
						</div>

						<div class="add_icon_asterisk">
							<label for="pwd">Model Code </label> <input type="text"
								class="form-control" id="address1" name="model"
								data-ng-model="toolsdetails.model" readonly>
								<i class="fa fa-asterisk" ></i> <div
								class="error_msg"
								data-ng-show="bulk_request.$submitted || bulk_request.model.$touched" class="error_msg">
								<div data-ng-show="bulk_request.model.$error.required" class="error_msg">Please
									Select modelCode</div>
							</div>
						</div>

					</div>

					<div class="col-md-6 col_md text-center">

						<div class="add_icon_asterisk">
							<label for="pwd">From Project </label>
							<div class="new-select-option">
								<select name='projectName' id='projectName' data-ng-model="toolsdetails.projectName" required
									class="select2 form-control" style="width: 100%; height: 36px;">

									<option value="" selected>--- Select Project ---</option>

									<option data-ng-repeat="x in allprojects" value="{{x.name}}">{{x.name}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
							<div class="error_msg"
								data-ng-show="bulk_request.$submitted || bulk_request.projectName.$touched" class="error_msg">
								<div data-ng-show="bulk_request.projectName.$error.required" class="error_msg">Please
									Select Project</div>
							</div>
						</div>


						<div class="add_icon_asterisk">
							<label for="pwd">Quantity </label> <input type="text"
								name="quantity" data-ng-model="toolsdetails.quantity" maxlength="5" data-ng-change="validate()"
								class="form-control" numbersonly required><i class="fa fa-asterisk" ></i> <div
								class="error_msg"
								data-ng-show="bulk_request.$submitted || bulk_request.quantity.$touched" class="error_msg">
								<div data-ng-show="bulk_request.quantity.$error.required" class="error_msg">Please
									enter Quantity</div>
							</div>
						</div>


						<div class="add_icon_asterisk">
							<label for="pwd">Expected Date </label>


							<div class="input-group date" data-date-format="dd/mm/yyyy"
								data-date-today-highlight="true" data-date-autoclose="true"
								data-date-start-date="0d" data-provide="datepicker">
								<div class="input-group-addon inner-addon right-addon ">
									<i class="fa fa-calendar"></i> <input type="text"
										class="form-control" placeholder="" name="exceptdate"
										id="exceptdate" data-ng-model="toolsdetails.exceptDate"
										readonly required>
								</div>								
							</div>
							<i class="fa fa-asterisk" ></i>
							<div class="error_msg"
								data-ng-show="bulk_request.$submitted || bulk_request.exceptdate.$touched" class="error_msg">
								<div data-ng-show="bulk_request.exceptdate.$error.required" class="error_msg">Please
									Select Excepted Date</div>
							</div>

							<!-- 											<input type="date" name="exceptdate" data-ng-model="toolsdetails.exceptDate" required> -->
						</div>


					</div>

					<div style="display: block; margin-top: 20px; text-align: center;">
						<button class="btn btn-primary" type="submit">
							<i class="fa fa-cart-plus"></i> Add Request
						</button>
<!-- 						&nbsp;&nbsp;&nbsp; -->
<!-- 						<button class="btn btn-danger" data-ng-click="back()"> -->
<!-- 							<i class="fa fa-close"></i> Back -->
<!-- 						</button> -->
					</div>
				</form>
			</div>

			<!-- 	<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Category Type</th>
							<th>Category Name</th>
							<th>Model Code</th>
							<th>Site</th>
							<th>Quantity</th>
							<th>Expected Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="toolsdetails in alltools">
							<td>{{$index + 1}}</td>
							<td>{{toolsdetails.categoryType}}</td>
							<td>{{toolsdetails.subCategoryitem[0].subCategory}}</td>
							<td>{{toolsdetails.subCategoryitem[0].model}}</td>
							<td>
<select ng-model="toolsdetails.projectName">

    <option ng-repeat="x in allprojects" value="{{x.name}}">{{x.name}}</option>

</select>
</td>
							<td><input type="text" name="quantity{{$index+1}}" data-ng-model="toolsdetails.quantity"></td>
							<td><input type="date" name="exceptdate{{$index+1}}" data-ng-model="toolsdetails.exceptDate"></td>
							<td><a href="" data-ng-click="add(toolsdetails)">Add</a></td>
						</tr>
					</tbody>
				</table>   -->

			<div data-ng-show="requestDetails">
			
			<br>	<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Category Type</th>
							<th>Sub Category</th>
							<th>Model Code</th>
							<th>Site</th>
							<th>Quantity</th>
							<th>Expected Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="x in request_tools">
							<td>{{$index + 1}}</td>
							<td>{{x.categoryType}}</td>
							<td>{{x.subCategoryitem[0].subCategory}}</td>
							<td>{{x.subCategoryitem[0].model}}</td>
							<td>{{x.projectName}}</td>
							<td>{{x.quantity}}</td>
							<td>{{x.exceptDate}}</td>
							<td><button class="btn btn-danger" data-ng-click="removeRow($index)"><i class="fa fa-close"></i></button></td>
						</tr>
					</tbody>
				</table>
				<div class="col-12 submit_col text-center">
					<button class="btn btn-primary" id="" data-ng-click="BulkRequest()" data-ng-disabled="submitStatus">
						<i class="fa fa-send"></i> SEND REQUEST
					</button>
					<!-- 											<button class="btn btn-warning"><i class="fa fa-close"></i> CANCEL</button> -->
				</div>

			</div>





		</div>
	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />