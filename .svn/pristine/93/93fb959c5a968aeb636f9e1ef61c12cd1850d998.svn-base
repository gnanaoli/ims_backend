<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="FindToolController">
            
            
                 <div class="search_section">

                        <div class="search_heading">
                            <span>Find a Tool<img src="resources/img1/tool.png"></span>
                            <span></span>                        </div>
                        <form class="form_search" method="post" name="findTools" novalidate>
                                <input type="text" id="tags" name="tags" placeholder="Search for..." required  data-ng-model="findToolsRequestDto.searchKeyword" maxlength="30" style="width: 91%;padding: 4px;">
                         
                                <button class="search_btn" data-ng-click="Search(findToolsRequestDto.searchKeyword)"><i class="fa fa-search search_icon"></i></button>
                                <div
						data-ng-show="findTools.$submitted || findTools.tags.$touched" class="error_msg">
						<div data-ng-show="findTools.tags.$error.required" class="error_msg"> Type the keyWord then Search					
						</div>
					</div>
                            </form>
                </div>
            
            
					<br><br><div class="form_section" data-ng-show="searchtools==true">
							<div class="form-content create_form">
								<h4 class="form_content_title">Find a Tool</h4>
					
					<div class="table-responsive">				
					<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr><th>Id</th>
							<th>Category </th>
							 <th>Sub Category</th>
							 <th>Model</th>
							<th>Quantity</th>
							<th>Location</th>
							<th>Site</th>
							<security:authorize access="hasAuthority('USER')"> 
							<th>Action</th>
							</security:authorize> 
						</tr>
					</thead>
					<tbody>
						<tr data-ng-repeat="inventoryManagementDto in inventoryEntranceDtoList">
							<td>{{$index+1}}</td>
							<td>{{inventoryManagementDto.categoryType}}</td>
							<td>{{inventoryManagementDto.subCategory}}</td>
							 <td>{{inventoryManagementDto.modelCode}}</td>
							<td>{{inventoryManagementDto.quantity}}</td>
							<td>{{inventoryManagementDto.location}}</td>
							<td>{{inventoryManagementDto.site}}</td>
							<security:authorize access="hasAuthority('USER')"> 
							<td><a href="" data-ng-click="requestTools(inventoryManagementDto)" class="btn btn-primary">Request Tools</a></td>
							 </security:authorize>	
							</tr>
					</tbody>
				</table>
				</div>	
							</div>
					</div>
            </div>

            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />	

<script>

  </script>

