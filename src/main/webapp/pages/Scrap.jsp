<jsp:include page="header.jsp" />

<section class="content" data-ng-controller="ScrapController">
	<div class="row content_row">
		<div class="col-12 text-center mt-1">
			<h4 class="content_header">SCRAP</h4>
		</div>

		<div class="form_section">

			<div class="form-content">
				<h4 class="form_content_title">Search Scrap</h4>


				<table datatable="ng" dt-options="dtOptions"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Category Type</th>
							<th>Category Code</th>
							<th>Category Name</th>
							<th>Model</th>
							<th>Date Of Scrapping</th>
							<th>Action</th>

						</tr>
					</thead>
					<tbody>


                <tr data-ng-repeat="ScrapDto in ScrapMaster">
                    <td>{{ScrapDto.category.categoryType}}</td>
                    <td>{{ScrapDto.category.categoryCode}}</td>
                    <td>{{ScrapDto.subCategory.subCategory}}</td>
                    <td>{{ScrapDto.subCategory.model}}</td>
                    <td>{{ScrapDto.raised_date | date}}</td>
                    <td><a href="" data-ng-click="edit(ScrapDto)"><i class="fa fa-edit"></i> Edit</a></td>
                </tr>



					</tbody>


				</table>



			</div>
		</div>
	</div>
</section>



<jsp:include page="footer.jsp" />