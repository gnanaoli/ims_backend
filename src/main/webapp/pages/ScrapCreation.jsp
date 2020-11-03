<jsp:include page="header.jsp" />
<section class="content" data-ng-controller="ScrapCreationController">
	<div class="row content_row">
		<div class="col-12 text-center mt-1">
			<h4 class="">SCRAP CREATION</h4>
		</div>
		<div class="col-12 text-right mt-1 mb-3">
			<a class="btn btn-primary" href="add_supplier">Scrap Creation</a>
		</div>
		<div class="form_section">

			<div class="form-content">

				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Category Type</th>
							<th>Sub Category</th>
							<th>Quantity</th>							
							<th>Site</th>							
							<th>Action</th>
							
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="scrap_details in scrap_master">
							<td>{{scrap_details.categoryType}}</td>
							<td>{{scrap_details.subCategory}}</td>
							<td>{{scrap_details.quantity}}</td>						
							<td>{{scrap_details.site}}</td>						
							<td><a href="" data-ng-click="view_scrap_details(scrap_details)">Move to Scrap</a></td>
						</tr>
					</tbody>
				</table>






					<div class="form_section">
							<div class="form-content create_form">
							<h4 class="form_content_title">Scrap Creation</h4>								
								<form class="form-inline" name="move_Scrap" novalidate>
									<div class="col-md-6 col_md text-center">
										<div class="">
											<label for="email">Category Type:</label>
											<input type="text" class="form-control" id="category" name="category" data-ng-model="scrap_moveDto.category.categoryType" data-ng-init="scrap_moveDto.category.categoryType=''" required>
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="scrap_moveDto.id" data-ng-init="scrap_moveDto.id=''">
									
										</div>
					<div data-ng-show="move_Scrap.$submitted || move_Scrap.category.$touched" class="error_msg">
						<div data-ng-show="move_Scrap.category.$error.required" class="error_msg">Please Select
							Category</div>
					</div>	
										<div class="">
												<label for="email">Quantity:</label>
												<input type="text" class="form-control" id="quantity" name="quantity" data-ng-model="scrap_moveDto.quantity" data-ng-init="scrap_moveDto.quantity=''" numbersonly required>
											</div>
					<div data-ng-show="move_Scrap.$submitted || move_Scrap.quantity.$touched" class="error_msg">
						<div data-ng-show="move_Scrap.quantity.$error.required" class="error_msg">Please Enter
							Quantity</div>
					</div>											
										
										<div class="">
												<label for="email">Comments:</label>
												<input type="text" class="form-control" id="comments" name="comments" data-ng-model="scrap_moveDto.comments" data-ng-init="scrap_moveDto.comments=''" required>
										</div>
					<div data-ng-show="move_Scrap.$submitted || move_Scrap.comments.$touched" class="error_msg">
						<div data-ng-show="move_Scrap.comments.$error.required" class="error_msg">Please Enter
							Comments</div>
					</div>										
									</div>																		
									
									<div class="col-md-6 col_md text-center">
										<div class="">
												<label for="email">Sub Category:</label>
												<input type="text" class="form-control" id="subCategory" name="subCategory" data-ng-model="scrap_moveDto.subCategory.subCategory" data-ng-init="scrap_moveDto.subCategory.subCategory=''" required>
										</div>
						<div data-ng-show="move_Scrap.$submitted || move_Scrap.subCategory.$touched" class="error_msg">
						<div data-ng-show="move_Scrap.subCategory.$error.required" class="error_msg">Please Enter
							Sub Category</div>
					</div>									
										<div class="">
												<label for="email">Moved Quantity:</label>
												<input type="text" class="form-control" id="move_quantity" name="move_quantity" data-ng-model="scrap_moveDto.move_quantity" data-ng-init="scrap_moveDto.move_quantity=''" required>
										</div>
						<div data-ng-show="move_Scrap.$submitted || move_Scrap.move_quantity.$touched" class="error_msg">
						<div data-ng-show="move_Scrap.move_quantity.$error.required" class="error_msg">Please Enter
							Move Quantity</div>
					</div>											
										<div class="col-12 submit_col text-center">
											<button class="btn btn-primary" data-ng-click="movescrap()">Move</button>
											<button class="btn btn-warning"><i class="fa fa-close"></i> CANCEL</button>
										</div>
									</div>	
								</form>
							</div>
					</div>




			</div>
		</div>
	</div>
</section>



<jsp:include page="footer.jsp" />