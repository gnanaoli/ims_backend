<jsp:include page="header.jsp" />



<!-- Container fluid  -->
<!-- ============================================================== -->
<div class="container-fluid user-top"
	data-ng-controller="BlockManagementController">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
		<div class="col-md-5 align-self-center">
			<h3 class="text-themecolor">ADD BLOCK</h3>
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
			<h4 class="form_content_title">Add Block</h4>
			<form class="form-inline" method="post" name="addBlock" novalidate>
				<div class="col-md-6 col_md text-center">
					<div class="add_icon_asterisk">
						<label for="email">WareHouse</label>


						<div class="new-select-option">
							<select name="wareHouseName"
								data-ng-model="blockDto.wareHouseDto.wareHouseName" required
								class="select2 form-control" tabindex="1"
								style="width: 100%; height: 36px;">
								<option></option>
								<option
									data-ng-repeat="x in wareHouseDtoList track by x.wareHouseName"
									value="{{x.wareHouseName}}">{{x.wareHouseName}}</option>

							</select> <i class="fa fa-asterisk"></i>
						</div>



						<!-- 						<input list="wareHouse" -->
						<!-- 							class="form-control" id="wareHouse_List" placeholder="" -->
						<!-- 							name="wareHouseName" data-ng-readonly="datareadonly" required -->
						<!-- 							data-ng-model="blockDto.wareHouseDto.wareHouseName" -->
						<!-- 							autocomplete="off" tabindex="1"> <i -->
						<!-- 							class="fa fa-asterisk"></i> -->
						<!-- 						<datalist id="wareHouse"> -->
						<!-- 							<option -->
						<!-- 								data-ng-repeat="x in activeWareHouseList track by x.wareHouseName" -->
						<!-- 								value="{{x.wareHouseName}}">{{x.wareHouseName}}</option> -->
						<!-- 						</datalist> -->
					</div>

					<div
						data-ng-show="addBlock.$submitted || addBlock.wareHouseName.$touched"
						class="error_msg">
						<div data-ng-show="addBlock.wareHouseName.$error.required"
							class="error_msg">Please Select WareHouse</div>
					</div>


					<div class="add_icon_asterisk">
						<label for="pwd"> Block Name:</label> <input type="text"
							class="form-control" id="blocksNames" name="blocksNames"
							allowspacealphanum data-ng-model="blockDto.blocksNames" required
							autocomplete="off" tabindex="2"> <i
							class="fa fa-asterisk"></i>
					</div>


					<div
						data-ng-show="addBlock.$submitted || addBlock.blocksNames.$touched"
						class="error_msg">
						<div data-ng-show="addBlock.blocksNames.$error.required"
							class="error_msg">Enter Block Name</div>
					</div>

					<div class="add_icon_asterisk">
						<label for="pwd"> Block Code:</label> <input type="text"
							class="form-control" id="code" name="code" alphamumeric
							data-ng-model="blockDto.code" required autocomplete="off"
							tabindex="3" maxlength="3"> <i class="fa fa-asterisk"></i>
					</div>

					<div data-ng-show="addBlock.$submitted || addBlock.code.$touched"
						class="error_msg">
						<div data-ng-show="addBlock.code.$error.required"
							class="error_msg">Enter Block Code</div>
					</div>

				</div>
				<div class="col-12 submit_col text-center">
					<button class="btn btn-primary" data-ng-click="saveBlock()">
						<i class="fa fa-check"></i> SAVE
					</button>
					<span class="btn btn-warning" data-ng-click="back()"><i
						class="fa fa-close"></i> CANCEL</span>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Row -->
<!-- ============================================================== -->







<jsp:include page="footer.jsp" />