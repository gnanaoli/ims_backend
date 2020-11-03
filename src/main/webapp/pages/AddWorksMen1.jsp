<jsp:include page="header.jsp" />



<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid user-top"
	data-ng-controller="WorksmenManagementController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">ADD WORKSMEN</h3>
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
			<h4 class="form_content_title">Add WorksMen</h4>
			<form class="form-inline" method="post" name="addWorksmen" data-ng-submit="addrequestWorksmen(addWorksmen.$valid)" novalidate>
				<div class="col-md-6 col_md text-center">


					<div class="add_icon_asterisk">
						<label for="email">Date</label>
						<div class="input-group date" data-date-format="dd/mm/yyyy"
							data-date-end-date="0d" data-date-start-date="0d" data-date-today-highlight="true"
							data-date-autoclose="true" data-provide="datepicker">
							<div class="input-group-addon inner-addon right-addon ">
								<i class="fa fa-calendar"></i> <input type="text"
									class="form-control" placeholder="" id="date" name="date"
									data-ng-model="WorksmenDto.date" readonly required  autocomplete="off" tabindex="1">
							</div>							
						</div>
						<i class="fa fa-asterisk" ></i>						
					</div>
					

					<div
						data-ng-show="addWorksmen.$submitted || addWorksmen.date.$touched"
						class="error_msg">
						<div data-ng-show="addWorksmen.date.$error.required"
							class="error_msg">Please Select Date</div>
					</div>



					<div class="add_icon_asterisk">
						<label for="pwd">WorksMen Category:</label> 
						
							<div class="new-select-option">
								<select name="category" id="category"
									data-ng-model="WorksmenDto.worksMenCategoryDto.category"
									required class="select2 form-control" tabindex="2"
									style="width: 100%; height: 36px;">
									<option></option>
									<option
										data-ng-repeat="x in WokrsMenCategoryMaster" data-ng-if="x.status=='ACTIVE'"
										value="{{x.category}}">{{x.category}}</option>
								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
						
<!-- 						<input -->
<!-- 							list="worksmen_category" class="form-control" id="project_List" -->
<!-- 							placeholder="" data-ng-readonly="datareadonly" required -->
<!-- 							name="category" -->
<!-- 							data-ng-model="WorksmenDto.worksMenCategoryDto.category" -->
<!-- 							 autocomplete="off" tabindex="2"> -->
<!-- 							<i class="fa fa-asterisk" ></i> -->
<!-- 						<datalist id="worksmen_category"> -->
<!-- 							<option data-ng-repeat="x in WokrsMenCategoryMaster" data-ng-if="x.status=='ACTIVE'" -->
<!-- 								value="{{x.category}}">{{x.category}}</option> -->
<!-- 						</datalist> -->


					</div>

					<div
						data-ng-show="addWorksmen.$submitted || addWorksmen.category.$touched"
						class="error_msg">
						<div data-ng-show="addWorksmen.category.$error.required"
							class="error_msg">Please Select Workmen Category</div>
					</div>



					<div class="">
						<label for="pwd">Comments:</label> <input type="text"
							class="form-control" id="comments" name="comments"
							data-ng-model="WorksmenDto.comments"  autocomplete="off" tabindex="3">
					</div>

					<div
						data-ng-show="addWorksmen.$submitted || addWorksmen.comments.$touched"
						class="error_msg">
						<div data-ng-show="addWorksmen.comments.$error.required"
							class="error_msg">Please Enter Comments</div>
					</div>

				</div>
				<div class="col-md-6 col_md text-center">


					<div class="add_icon_asterisk">
						<label for="email">Project Name</label> 
						
							<div class="new-select-option">
								<select name="name" id="name"
									data-ng-model="WorksmenDto.projectDto.name"
									required class="select2 form-control" tabindex="4"
									style="width: 100%; height: 36px;">
									<option></option>
									<option
										data-ng-repeat="x in projectMasterDtoList track by x.name"
										value="{{x.name}}">{{x.name}}</option>
								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
						
<!-- 						<input list="project" -->
<!-- 							class="form-control" id="project_List" placeholder="" -->
<!-- 							data-ng-readonly="datareadonly" required name="name" -->
<!-- 							data-ng-model="WorksmenDto.projectDto.name"  autocomplete="off" tabindex="3"> -->
<!-- 							<i class="fa fa-asterisk" ></i> -->
<!-- 						<datalist id="project"> -->
<!-- 							<option -->
<!-- 								data-ng-repeat="x in projectMasterDtoList track by x.name" -->
<!-- 								value="{{x.name}}">{{x.name}}</option> -->
<!-- 						</datalist> -->
					</div>

					<div
						data-ng-show="addWorksmen.$submitted || addWorksmen.name.$touched"
						class="error_msg">
						<div data-ng-show="addWorksmen.name.$error.required"
							class="error_msg">Please Select Project</div>
					</div>


					<div class="add_icon_asterisk">
						<label for="pwd"> Resource Count:</label> <input type="text"
							class="form-control" id="resourceCount" name="resourceCount"
							data-ng-model="WorksmenDto.resourceCount" ng-init="WorksmenDto.resourceCount=''" data-ng-change="validate()" numbersonly autocomplete="off" tabindex="5" maxlength="10" required>
							<i class="fa fa-asterisk" ></i>
					</div>

					<div
						data-ng-show="addWorksmen.$submitted || addWorksmen.resourceCount.$touched"
						class="error_msg">
						<div data-ng-show="addWorksmen.resourceCount.$error.required"
							class="error_msg">Please Enter Resource Count</div>
					</div>


				</div>


				<div class="col-12 submit_col text-center">
					<button class="btn btn-primary" type="submit">
						<i class="fa fa-check"></i> ADD
					</button>
					<span class="btn btn-warning" data-ng-click="back()">
						<i class="fa fa-close"></i> CANCEL
					</span>
				</div>
			</form>
		




<br>		

<div data-ng-if="showDetails" class="row">
			<div class="col-md-12">

				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Date</th>
							<th>Project</th>
							<th>Category</th>
							<th>Resource Count</th>
							<th>Comments</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="x in request_worksmen">
							<td>{{$index + 1}}</td>
							<td>{{x.date}}</td>
							<td>{{x.projectDto[0].name}}</td>
							<td>{{x.worksMenCategoryDto[0].category}}</td>
							<td>{{x.resourceCount}}</td>
							<td>{{x.comments}}</td>
							<td><button class="btn btn-danger"
									data-ng-click="removeRow($index)">
									<i class="fa fa-close"></i>
								</button></td>
						</tr>
					</tbody>



				</table>
				<div class="col-12 submit_col text-center">
					<span class="btn btn-primary" data-ng-click="saveWorksmen()">
						<i class="fa fa-check"></i> SAVE
					</span>
</div>
			</div>
		</div>






</div>


	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />