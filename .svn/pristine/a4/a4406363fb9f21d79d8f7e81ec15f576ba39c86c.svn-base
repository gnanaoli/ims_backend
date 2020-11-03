 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="CityController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-6 align-self-center">
                        <h3 class="text-themecolor">CITY</h3>
                    </div>
                    
                   <div class="col-md-6 align-self-center">
                   
                   <div data-ng-show="cityMgt">
                   
                   	<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
                        <ol class="breadcrumb">
                        <li>
                            <a class="btn btn-primary waves-effect waves-light" href="" data-ng-click="addCity()">ADD CITY</a>
                        </li>
                        </ol>
                        </security:authorize>
                    </div>
                    
                    
                    </div>

                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                
                
                


		<div data-ng-if="addCityForm==true">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Add City</h4>
								
								<form class="form-inline" data-ng-submit="saveCity(addcity.$valid)" method="post" name="addcity" novalidate >
									<div class="col-md-6 col_md text-center">

											<div class="add_icon_asterisk">
											<label for="pwd">State Name</label>
											
											
							<div class="new-select-option">
								<select name="stateName" id="stateName" wb-select2
									data-ng-model="addCityDto.stateDto.stateName"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- Select Category ---</option>

									<option
										data-ng-repeat="x in stateDtoList"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
											
<!-- 											<input -->
<!-- 											list="stateList" class="form-control"  -->
<!-- 											name="stateName" placeholder=""  required -->
<!-- 											data-ng-model="addCityDto.stateDto.stateName" autocomplete="off" tabindex="1"> -->
<!-- 											<i class="fa fa-asterisk" ></i> -->
<!-- 										<datalist id="stateList"> -->
<!-- 											<option -->
<!-- 												ng-repeat="x in stateDtoList" -->
<!-- 												value="{{x.stateName}}">{{x.stateName}}</option> -->
<!-- 										</datalist> -->
										
										
										</div>
					<div data-ng-show="addcity.$submitted || addcity.stateName.$touched" class="error_msg" class="error_msg">
						<div data-ng-show="addcity.stateName.$error.required" class="error_msg" class="error_msg">Please Select
							State</div>
					</div>										
									
										<div class="add_icon_asterisk">
											<label for="pwd"> City Code:</label>
											<input type="text" class="form-control" id="cityCode" allowspacealphanum name="cityCode" data-ng-model="addCityDto.cityCode" required maxlength="6" autocomplete="off" tabindex="2">
											<i class="fa fa-asterisk" ></i>
										</div>	
										
					<div data-ng-show="addcity.$submitted || addcity.cityCode.$touched" class="error_msg">					
						<div data-ng-show="addcity.cityCode.$error.required" class="error_msg">Please Enter City Code </div>
					</div>										
									
									
										<div class="add_icon_asterisk">
											<label for="pwd"> City Name:</label>
											<input type="text" class="form-control" id="cityName" name="cityName" allowspace data-ng-model="addCityDto.cityName" required maxlength="50" autocomplete="off" tabindex="3">
											<i class="fa fa-asterisk" ></i>
										</div>	
										
					<div data-ng-show="addcity.$submitted || addcity.cityName.$touched" class="error_msg">					
						<div data-ng-show="addcity.cityName.$error.required" class="error_msg">Please Enter City Name </div>
					</div>				
																				

									</div>
									<div class="col-md-6">
									</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>					

							</div>
					</div>
		
		
		
		</div>



                
                
                
                <div data-ng-if="cityMgt">
                
                
		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Search City</h4>

<div class="table-responsive">
				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
					<tr>
						<th>City Code</th>
						<th>City Name </th>
						<th>State Name</th>
						<th>Status </th>
						<th class="not-export-col">Action </th>
						
					</tr>
					</thead>
					<tbody>
					
						<tr data-ng-repeat="city in cityDtoList">
							<td>{{city.cityCode}}</td>
							<td>{{city.cityName}}</td>
							<td>{{city.stateDto.stateName}}</td>
							<td>{{city.status}}</td>	
							
								<td class="table_btn_group">
							<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
							<a href="" data-ng-click="edit(city)" class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a>
							 </security:authorize>
							<a href="" data-ng-click="view(city)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
						</tr>

					</tbody>
				</table>
</div>



			</div>
		</div>
		</div>
		
		
		
		
		
		
		<div data-ng-if="editCity==true">
		
		
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Edit City</h4>
								
								<form class="form-inline" data-ng-submit="saveCity(editcity.$valid)" method="post" name="editcity" novalidate>
									<div class="col-md-6 col_md text-center">

											<div class="add_icon_asterisk">
											<label for="pwd">State Name</label>
											
							 <div class="new-select-option">
								<select name="stateName" id="stateName" wb-select2
									data-ng-model="addCityDto.stateDto.stateName"
									required class="form-control"
									style="width: 100%; height: 36px;">

									<option value="" selected>--- Select Category ---</option>

									<option
										data-ng-repeat="x in stateDtoList"
										value="{{x.stateName}}">{{x.stateName}}</option>

								</select>
								<i class="fa fa-asterisk" ></i>
							</div>
											
<!-- 											<input -->
<!-- 											list="stateList" class="form-control"  -->
<!-- 											name="stateName" placeholder="State Name"  required -->
<!-- 											data-ng-model="addCityDto.stateDto.stateName" autocomplete="off" tabindex="1"> -->
<!-- 											<i class="fa fa-asterisk" ></i> -->
<!-- 										<datalist id="stateList"> -->
<!-- 											<option -->
<!-- 												ng-repeat="x in stateDtoList" -->
<!-- 												value="{{x.stateName}}">{{x.stateName}}</option> -->
<!-- 										</datalist> -->
										
										</div>
					<div data-ng-show="editcity.$submitted || editcity.stateName.$touched" class="error_msg" class="error_msg">
						<div data-ng-show="editcity.stateName.$error.required" class="error_msg" class="error_msg">Please Select
							State</div>
					</div>										
									
										<div class="add_icon_asterisk">
											<label for="pwd"> City Code:</label>
											<input type="text" class="form-control" id="cityCode" alphamumeric name="cityCode" data-ng-model="addCityDto.cityCode" maxlength="6" required autocomplete="off" tabindex="2">
											<i class="fa fa-asterisk" ></i>
											<input type="hidden" class="form-control" id="id" name="id" data-ng-model="addCityDto.id" required autocomplete="off">
										</div>	
										
					<div data-ng-show="editcity.$submitted || editcity.cityCode.$touched" class="error_msg">					
						<div data-ng-show="editcity.cityCode.$error.required" class="error_msg">Please Enter CityCode </div>
					</div>										
									
									
										<div class="add_icon_asterisk">
											<label for="pwd"> City Name:</label>
											<input type="text" class="form-control" id="cityName" name="cityName" allowspace data-ng-model="addCityDto.cityName" maxlength="50" required autocomplete="off" tabindex="3">
											<i class="fa fa-asterisk" ></i>
										</div>	
										
					<div data-ng-show="editcity.$submitted || editcity.cityName.$touched" class="error_msg">					
						<div data-ng-show="editcity.cityName.$error.required" class="error_msg">Please Enter City Name </div>
					</div>				
																				

										<div class="add_icon_asterisk">
											<label for="">Status:</label>
											
											
									<div class="new-radio-button-inline">
										<input type="radio" name="status" id="ACTIVE" value="ACTIVE" required data-ng-model="addCityDto.status" class="with-gap">
										<label for="ACTIVE" >ACTIVE</label>
										<input type="radio" name="status" id="INACTIVE" value="INACTIVE" required data-ng-model="addCityDto.status" class="with-gap">
										<label for="INACTIVE">INACTIVE</label> 
									</div>											
											
										<i class="fa fa-asterisk" ></i>	
										</div>
										
					<div data-ng-show="editcity.$submitted || editcity.status.$touched" class="error_msg">					
						<div data-ng-show="editcity.status.$error.required" class="error_msg">Please Select Status </div>
					</div>	

									</div>
									<div class="col-md-6">
									</div>
										<div class="col-md-8 submit_col text-center">
											<button class="btn btn-primary" type="submit"><i class="fa fa-check"></i> SAVE</button>
											<span class="btn btn-warning" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>					

							</div>
					</div>
		
		
		
		</div>
		
		
		
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">City Details</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-striped">
         					<tr><th>City Code </th><td>{{view_city_details.cityCode}}</td></tr>
							<tr><th>City Name</th><td>{{view_city_details.cityName}}</td></tr>
							<tr><th>Status</th><td>{{view_city_details.status}}</td></tr>
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