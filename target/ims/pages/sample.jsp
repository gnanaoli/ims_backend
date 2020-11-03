

<html data-ng-app='ims'>


<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css" rel="stylesheet">


<div data-ng-controller="SupplierController">

<table datatable="ng" dt-options="dtOptions"  class="display nowrap" style="width:100%" >
        <thead>
            <tr>
							<th>Supplier Name</th>
							<th>Supplier Code</th>
							<th>Address1</th>
							<th>Address2</th>
							<th>Area / Landmark</th>
							<th>City</th>
							<th>Status</th>
							<th>Action</th>
            </tr>
        </thead>
					<tbody>
						<tr data-ng-repeat="supplier_details in supplier_master">
							<td>{{supplier_details.supplierName}}</td>
							<td>{{supplier_details.supplierCode}}</td>
							<td>{{supplier_details.address1}}</td>
							<td>{{supplier_details.address2}}</td>
							<td>{{supplier_details.area}}</td>
							<td>{{supplier_details.city}}</td>
							<td>{{supplier_details.status}}</td>
							<td><a href="" data-ng-click="edit(supplier_details)" class="btn btn-primary"><i class="fa fa-edit"></i> Edit</a>
							<a href="" data-ng-click="view(supplier_details)" class="btn btn-primary"><i class="fa fa-drivers-license-o"></i> View</a></td>
						</tr>
					</tbody>

    </table>
	
	
</div>	
	
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>


<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-datatables.min.js"></script>
<script	src="https://unpkg.com/@uirouter/angularjs@1.0.15/release/angular-ui-router.min.js"></script>
<script src="https://js-tutorials.com/demos/angularjs_datatables_export_demo/angular-datatables.buttons.min.js"></script>


<script src="resources/controllers/app.js"></script>
<script src="resources/controllers/SupplierController.js"></script>
<script src="resources/constant/URLConstant.js"></script>
<script src="resources/services/TestService.js"></script>
<script src="resources/services/InsertService.js"></script>
<script src="resources/services/FetchService.js"></script>



<script>

$(document).ready(function() {
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copyHtml5',
            'excelHtml5',
            'csvHtml5',
            'pdfHtml5'
        ]
    } );
} );

</script>

</html>
