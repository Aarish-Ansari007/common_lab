<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel">
			
				<header class="panel-heading"> View Test Record Form </header>
				
				<form action="/common-lab/add-report" method="get" name="reportBean" id="reportBean">
				<div class="form-group">
						<table class="table">
						<thead>
						<tr>
						<th>Test Name</th>
						<th>Value</th>
						<th>Measure Unit</th>
						<th>Normal Value</th>
						</tr>
						</thead>
						<tbody class="tbl-body">
						${subCat}
						</tbody>
						</table>
									 		
				</div>
				
				<div class="panel-body">
				<div class="btn-div">
					<button type="button" class="btn btn-success addss">Add More Test</button>
				 	<button type="submit" class="btn btn-info" >Submit</button>
	                <button class="btn btn-danger" type="reset">Reset</button>
	                <button class="btn btn-info" onclick="window.location.replace('/common-lab/dashboard');">Cancel</button>
	                <button class="btn btn-warning" onclick="window.print()">Print</button>
                </div>
				</div>
				</form>
			
			</section>
			</section>
			</section>
			</section>