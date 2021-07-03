<style>
.hiddenClass {
	display: none;
}

hr.style1{
	border: 1px solid red;
}

.row{
margin-bottom: -10px;
margin-top: -17px;
}
div.col-sm-3 {
  font-size: 11px;
  font-weight: 900;
}
div.col-sm-4 {
  font-size: 15px;
  font-weight: bold;
}
div.col-sm-5 {
  font-size: 13px;
  font-weight: bold;
}

div.a:after {
    position: absolute;
    content: "";
    height: 2px;
    background-color: #242424;
    width: 90%;
    margin-left: -55px;
    top: 90%;
}
.pdetail
{
background-color: white;
}
.tst
{
background-color: blue;
}

</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="site-content">
	<section id="main-content">
		<section class="wrapper">
			<section class="panel">
				<header class="panel-heading"> Patient List</header>
				<div class="panel-body">
					<div class="position-center">
						<form class="cmxform form-horizontal"
							onsubmit="return validateFilterData()" id="supplyForm">

							<div class="panel-body">
								<div class="form">

								<div class="form-group required col-lg-4">
										<label for="curl" class="control-label">From Date</label>
										<div class="">
											<input class="form-control" type="date" name="fromDate" id="rfromDate">
										</div>
									</div>
									
									<div class="form-group required col-lg-4">
										<label for="curl" class="control-label">To Date</label>
										<div class="">
											<input class="form-control" type="date" name="toDate" id="rtoDate">
										</div>
									</div>
								
									

								<span style="color: red; font-size: 16px; font-weight: 786;"
									id="errorMsg">${errorMsg}</span>
								<div class="btn-div form-group col-lg-4">
									<button type="button" class="btn btn-info"
										onclick="validateFilterData()">Submit</button>
									<button class="btn btn-danger" type="reset"
										id="resetSupplyFormBtn">Cancel</button>
								</div>
								</div>
							</div>
						</form>
					</div>


					<div id="content">

						<div class="hiddenClass">
							<div class="center">
								RELIABLE PATHO LAB<br> Corporate Office: 12th Floor,
								Tower–B, SAS Tower, Medicity, Sector-38,<br>
								Gurgaon-122001, Phone:0124-301-6500 , Fax: 0124-423-4468<br>
								<br> CIN No: L74899DL1995PLC065388<br>
								<h2>Patient List</h2>
							</div>
							<div class="left labName"></div>
							<div class="right">
								Invoice Print Date.....: <span class="invoiceDate"></span><br>
								SAC No.................: <span class="sacno"></span>
							</div>
						</div>
						

						<div class="stats-last-agile tableDiv">
						<!-- Custom design -->
						<div class="main">
						
							</div>
						</div>
						<br>
						<c:set var="val" value="${staffRole}" />
						<c:choose>
							<c:when test="${val == 'ADMIN'}">
								<div class="btn-class">
									<button class='btn btn-success export-pdf k-button noExport'>Export as
										PDF</button>
<!-- 										<a href="dashboard"><button type="button" class="btn btn-info">Dashboard</button></a> -->
										<button class="btn btn-info" onclick="window.location.replace('/common-lab/dashboard');">Dashboard</button>
                                <button class="btn btn-warning" onclick="window.print()">Print</button>
<!-- 									<button class='export-excel k-button noExport' -->
<!-- 										id="exportButton">Export as Excel</button> -->
<!-- 									<button class='send-email k-button noExport'>Send Email</button> -->
								</div>
							</c:when>

						</c:choose>

						<div class="center hiddenClass">
							<hr>
							Regd. Office:Dr. Lal PathLabs Ltd., Block E, Sector 18, Rohini,
							New Delhi-110085 ,Phone: 91-11-39885050 , Fax; 91-11-3040-3204
						</div>

					</div>

				</div>
				
			</section>
		</section>
	</section>
</section>


<style>
.k-pdf-export .noExport {
	display: none;
}

.k-pdf-export .hiddenClass {
	display: block;
}
.hideme
{
    display:none;
    visibility:hidden;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				//pdf test record

				$(".export-pdf").click(function() {
					kendo.drawing.drawDOM("#content", {
						paperSize : "A4",
						margin : {
							top : "1.5cm",
							right : "0.5cm",
							bottom : "1cm",
							left : "0.5cm"
						},
						scale : 0.6,
						height : 500,
						repeatHeaders : true,
						multiPage : true,
					}).then(function(group) {
						path = "C:\Users\your\Desktop\Companies",
						kendo.drawing.pdf.saveAs(group, "Patient Record")
					});
				});

	
	//PDF for report
	$(".export-pdf-report").click(function() {
		kendo.drawing.drawDOM("#report-content", {
			paperSize : "A4",
			margin : {
				top : "1.5cm",
				right : "0.5cm",
				bottom : "1cm",
				left : "0.5cm"
			},
			scale : 0.6,
			height : 500,
			repeatHeaders : true,
			multiPage : true,
		}).then(function(group) {
			path = "C:\Users\your\Desktop\Companies",
			kendo.drawing.pdf.saveAs(group, "Report")
		});
	});

});

	//excel

	$(function() {
		$(".export-excel").click(function() {
			$("#example").table2excel({
				exclude : ".tbl-body",
				filename : "Supply-bill.xls",
				columns : [ 0, 1, 2, 3, 4, 5, 6, 7 ]
			});
		});
	});

	$(function() {
		$(".send-email").click(function() {
			
			kendo.drawing.drawDOM($("#content")).then(function(group) {
				// Render the result as a PDF file
				return kendo.drawing.exportPDF(group, {
					paperSize : "auto",
					margin : {
						left : "1cm",
						top : "1cm",
						right : "1cm",
						bottom : "1cm"
					}
				});
			}).done(function(data) {

				$.ajax({
					url : "send-mail",
					data : {
						"to" : "er.aarif7@gmail.com",
						"body" : data
					},
					type : "POST",
					success : function(responce) {
						alert(responce);
					}
				});

			});
		});
	});

	function validateFilterData() {
		var fromDate = $('#rfromDate').val();
		var toDate = $('#rtoDate').val();
		if (fromDate == "") {
			alert('Please Enter Valid fromDate!');
			$('#rfromDate').focus();
			return false
		}
		else if (toDate == "") {
			alert('Please Enter Valid toDate!');
			$('#rtoDate').focus();
			return false
		} else {
			var today = new Date();
			var date = today.getDate() + '/' + (today.getMonth() + 1) + '/'
					+ today.getFullYear();
			$('.invoiceDate').html(date);
// 			$('.sacno').html(labCode);
			
			$.ajax({
						url : "get-supply-bill/" +fromDate
								+ "/" + toDate,
						type : 'GET',
						datatype : "json",
						contentType : "application/json; charset=utf-8",
						success : function(responce) {
							var data = JSON.stringify(responce);
							var obj = JSON.parse(data);
							var totalPayable = 0;
							var htm1="";
							$.each(obj, function(index, item) {
								var sumGP = 0;
								var sumDis = 0;
								var sumNP = 0;
												htm1 = htm1
														+ "<div class='row'>"
														+ "<div class='col-sm-4 col-md-6 col-lg-1'>Name:</div>"
														+ "<div class='col-sm-4 col-md-6 col-lg-2'>"+item.patientFirstName+" "+item.patientLastName+"</div>"
														+ "<div class='col-sm-4 col-md-6 col-lg-2'>BarCode: "+item.barCode+"</div>";
// 														if(role==='ADMIN')
// 															{
															var htm2="";
															var htm3="";
															var htm4 = "";
															if (item.paymentStatus === 0)
																{
		 														htm2 = htm2
		 														+ '<input type="button" value="Pending" class="btn btn-danger" style="height: 32px;" onclick="openModal(\''+ item.recordId+'\',\''+ item.totalAmount+'\',\''+ item.paymentMode+'\',\''+ item.paymentAcceptedBy+'\',\''+ item.receivedAmount+'\',\''+ item.pendingAmount+'\')">';
		 														}
		 													else
		 														{
		 														htm2 = htm2
		 																+ '<input type="button" id="td'
		 																+ item.recordId
		 																+ '" value="Received" class="btn btn-success" style="height: 32px;">';
		 														}
															
															if(item.reportImagePath==null)
		 														{
		 														htm3 = htm3
		 														+ "<a href='view-test/"+ item.recordId+ "'><i class='fa fa-eye-slash' aria-hidden='true' title='No Report Uploaded' style='font-size:x-large'></i></a>";
		 														htm4 = htm4 + "<a  href='#' onclick='addReportForm("+ item.recordId+ ")' class='report' ><i class='fa fa-cloud-upload' aria-hidden='true'></i></a><a href='#' onclick='editViewReportForm("+ item.recordId+ ")'><i class='fa fa-download' aria-hidden='true' title='Download Report' style='font-size:x-large'></i></a>";
		 														}
		 													else
		 														{
		 														htm3 = htm3
		 														+ "<span class='cmtattachment'><a href='download-report/"+item.reportImagePath+"'> <i class='fa fa-eye' aria-hidden='true' title='Report Uploaded' style='font-size:x-large'></i></a></span>";
		 														htm4 = htm4 + "<a href='test-information/"+ item.recordId+ "'  class='report' ><i class='fa fa-cloud-upload' aria-hidden='true'></i></a>";
		 														}
															
															htm1 = htm1+ "<div class='col-sm-4 col-md-6 col-lg-2 noExport' title='Upload Report'>"+htm4+"</div><div class='col-sm-4 col-md-6 col-lg-2 noExport' title='Download and View Report'>"+htm3+"</div>"
															+ "<div class='col-sm-4 col-md-6 col-lg-1 noExport'><i class='fa fa-trash' aria-hidden='true' onclick='deleteTestRecord("+ item.recordId+ ")' title='Delete Test Record' style='font-size:x-large'></i></div><div class='col-sm-4 col-md-6 col-lg-2 noExport' title='Payment status'>"+htm2+"</div>";
// 															}
// 														else
// 															{
// 															var htm3="";
// 															if(item.reportImagePath==null)
// 	 														{
// 	 														htm3 = htm3
// 	 														+ "<a href='view-test/"+ item.recordId+ "'><i class='fa fa-eye-slash' aria-hidden='true' title='No Report Uploaded'></i></a>";
// 	 														}
// 	 													else
// 	 														{
// 	 														htm3 = htm3
// 	 														+ "<span class='cmtattachment'><a href='download-report/"+item.reportImagePath+"'> <i class='fa fa-eye' aria-hidden='true' title='Report Uploaded'></i></a></span>";
// 	 														}
// 															if(item.paymentStatus === 0)
// 																{
// 																htm1 = htm1+ '<span>Pending</span>';
// 																}
// 															else
// 																{
// 																htm1 = htm1+ '<span>Received</span>';
// 																}
															
														
// 															htm1 = htm1+ "<div class='col-sm-4 col-md-6 col-lg-2 noExport' title='Download and View Report' style='font-size:x-large'>"+htm3+"</div>";
// 															}
														htm1 = htm1+ "</div>"
														+ "<hr class='style1'>"
														+ "<div class='row'>"
														+ "<div class='col-sm-5 col-md-6 col-lg-2'>Date</div>"
														+ "<div class='col-sm-5 col-md-6 col-lg-2'>Test Code</div>"
														+ "<div class='col-sm-5 col-md-6 col-lg-5'>Test Name</div>"
														+ "<div class='col-sm-5 col-md-6 col-lg-1'>Gros Amt</div>"
														+ "<div class='col-sm-5 col-md-6 col-lg-1'>Discount</div>"
														+ "<div class='col-sm-5 col-md-6 col-lg-1'>Line Amt</div>"
														+ "</div>"
														+ "<hr class='style1'>";
														$.each(item.testDetailBean, function(index, subItem) {
															sumGP = sumGP+subItem.basePrice;
															sumDis = sumDis+subItem.discount;
															sumNP = sumNP+subItem.netPrice;
															htm1 = htm1	+ "<div class='row'>"
														+ "<div class='col-sm-3 col-md-6 col-lg-2'>"+item.createdDate+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-2'>"+subItem.testCode+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-5'>"+subItem.testBeans.testName+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-1 a'>"+subItem.basePrice+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-1 a'>"+subItem.discount+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-1 a'>"+subItem.netPrice+"</div>"
														+ "</div>";
														});
														htm1 = htm1	+ "<div class='row'>"
														+ "<div class='col-sm-3 col-md-6 col-lg-9'>Total for Patient: "+item.patientFirstName+" "+item.patientLastName+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-1 a'>"+sumGP+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-1 a'>"+sumDis+"</div>"
														+ "<div class='col-sm-3 col-md-6 col-lg-1 a'>"+sumNP+"</div>"
														+ "</div>";
														totalPayable = totalPayable+sumNP;

											});
							htm1 = htm1+"<hr class='style1'><div class='row'><div class='col-sm-4 col-md-6 col-lg-11'>Total Payable (Rs) :</div><div class='col-sm-4 col-md-6 col-lg-1'>"+totalPayable+"</div></div><hr class='style1'>";
							$('.main').html(htm1);
							$("#example_length").addClass("noExport");
							$("#example_filter").addClass("noExport");
							$("#example_info").addClass("noExport");
							$("#example_paginate").addClass("noExport");
						}
					});
		}
	}

	function deleteTestRecord(recordId) {
		var txt;
		var r = confirm("Are You Sure You Want To Delete This Record!");
		if (r == true) {
			$.ajax({
				url : "delete-test-record/" + recordId,
				type : 'GET',
				datatype : "json",
				contentType : "application/json; charset=utf-8",
				success : function(responce) {
					if (responce === 1)
						$('#tr' + recordId).hide();
					validateFilterData();
				}
			});
		} else {
		}
	}

	function openModal(recordId, totalAmt, paymentMode, paymentAcceptedBy, receivedAmount, pendingAmt) {
		$('#recId').val(recordId);
		$('#Ptotalprice').val(totalAmt);
		$('#Ppmtmode').val(paymentMode);
		$('#Ppmtaccby').val(paymentAcceptedBy);
		$('#PpmtSts').val(0);
		$('#Ppayamt').val(receivedAmount);
		$('#Ppenamt').val(pendingAmt); 
		$('#payment-modal').modal('show');
	}
	
	function addReportForm(recordId) {
		$.ajax({
			url : "add-report-form/"+recordId,
			type : 'GET',
			success : function(responce) {
				$('#report-content').html(responce); 
				$('#reportBean').attr('action', '/common-lab/add-report');
				$('.ev-button').hide();
				$('#action-report-modal').modal('show');
			}
		});
		
	}
	
	function editViewReportForm(recordId) {
		$.ajax({
			url : "ev-report-form/"+recordId,
			type : 'GET',
			success : function(responce) {
// 				$('.table-body').html(responce); 
				$('#report-content').html(responce);
				$('#reportBean').attr('action', '/common-lab/ev-report');
				$(".ev-input").css({"background": "rgba(0, 0, 0, 0)", "border": "none","outline": "none"});	
				$('.ev-button').show();
				$('#action-report-modal').modal('show');
			}
		});
		
	}
	
	function evButton(){
		$(".ev-input").css({"background-color": "#fff", "border": "1px solid","outline": "1px"});
	  };
		function eviewButton(){
			$(".ev-input").css({"background": "rgba(0, 0, 0, 0)", "border": "none","outline": "none"});
		  };
	
		function updatePaymentStatus(recordId, totalAmt, pendingAmt) {
		$.ajax({
			url : "update-payment-status/" + recordId + "/" + paymentStatus,
			type : 'GET',
			datatype : "json",
			contentType : "application/json; charset=utf-8",
			success : function(responce) {
				if (responce === 1 && paymentStatus === 1) {
					$('#td' + recordId).val('Received');
					$('#td' + recordId).attr(
							"onclick",
							"updatePaymentStatus('" + recordId + ","
									+ paymentStatus + "')");
					$('#td' + recordId).attr("class", "btn btn-success");
				} else {
					$('#td' + recordId).val('Pending');
					$('#td' + recordId).attr(
							"onclick",
							"updatePaymentStatus('" + recordId + ","
									+ paymentStatus + "')");
					$('#td' + recordId).attr("class", "btn btn-warning");
				}
			}
		});
	
		}

	//pdf
</script>
<!-- https://kendo.cdn.telerik.com/2020.1.406/js/kendo.all.min.js -->
<script src="<c:url value="/resources/js/kendo.all.min.js"/>"></script>
<script src="<c:url value="/resources/js/table2excel.js"/>"></script>




				<!-- payment model -->
<!-- 	<div class="modal modal-success fade" id="payment-modal"> -->
		<div class="modal fade right" id="payment-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalPreviewLabel" aria-hidden="true">
    <div class="modal-dialog-full-width modal-dialog momodel modal-fluid" role="document">
        <div class="modal-content-full-width modal-content ">
            <div class=" modal-header-full-width   modal-header text-center">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<center>Update Payment</center>
				</div>
				
			<div class="modal-footer">
			<section class="panel">
				<div class="panel-body">
					<div class="position-center">
					<form method="POST" id="myform" name="testRecordBean">
				
								<div class="form-group">
										<label for="cemail" class="control-label col-lg-4">Net Price</label>
										<div class="col-lg-8">
											<input class="form-control" type="text" name="totalAmount"  id="Ptotalprice" readonly="readonly">
										</div>
									</div>

									<div class="form-group">
										<label for="curl" class="control-label col-lg-4">Payment Mode</label>
										<div class="col-lg-8">
											<select name="paymentMode" id="Ppmtmode" class="form-control">
											<option value="OFFLINE">OFFLINE.</option>
											<option value="ONLINE">ONLINE.</option>
											<option value="OTHER">OTHER.</option>
											</select>
										</div>
									</div>
									
									<div class="form-group required">
										<label for="curl" class="control-label col-lg-4">Payment Accepted By</label>
										<div class="col-lg-8 barD">
											<input class="form-control" type="text" id="Ppmtaccby" name="paymentAcceptedBy">
										</div>
									</div>
									
									<div class="form-group">
										<label for="curl" class="control-label col-lg-4">Payment Status</label>
										<div class="col-lg-8">
											<select name="paymentStatus" id="PpmtSts" class="form-control">
											<option value="0">Pending</option>
											<option value="1">Done.</option>
											</select>
										</div>
									</div>
									
									<div class="form-group amountDiv1">
										<label for="curl" class="control-label col-lg-4">Payable Amount </label>
										<div class="col-lg-8 barD">
											<input class="form-control" type="number" id="Ppayamt" name="receivedAmount" oninput="getCalc(this.value)">
										</div>
									</div>
									
									<div class="form-group amountDiv1">
										<label for="curl" class="control-label col-lg-4">Pending Amount </label>
										<div class="col-lg-8 barD">
											<input class="form-control" type="number" id="Ppenamt" name="pendingAmount" readonly="readonly">
										</div>
									</div>
									
									
									<input class="form-control" type="hidden" id="recId" name="recordId" >
									
						
								
								
									
									<div class="btn-div">
									 <button type="button" class="btn btn-info" onclick="submitForm(this)">Submit</button>
                                	<button class="btn btn-danger" type="reset">Reset</button>
	                				<button class="btn btn-info" data-dismiss="modal" aria-label="Close">Cancel</button>
	                				<button class="btn btn-warning" onclick="window.print()">Print</button>
                                </div>
                                </div>
								</div>
								</section>
                                </form>
                                <div class="res">

</div>
</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /End payment.modal -->
	
	
					<!-- View Edit model -->
<!-- 	<div class="modal modal-success fade" id="payment-modal"> -->
		<div class="modal fade right" id="action-report-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalPreviewLabel" aria-hidden="true">
    <div class="modal-dialog-full-width modal-dialog momodel modal-fluid" role="document">
        <div class="modal-content-full-width modal-content ">
            <div class=" modal-header-full-width   modal-header text-center">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<center>Report</center>
				</div>
				
			<div class="modal-footer">
			<section class="panel">
				<div class="panel-body">
					<div class="position-center">
					<form action="/common-lab/add-report" method="post" name="reportBean" id="reportBean">
				<div class="form-group" id="report-content">
<!-- 						<table class="table"> -->
<!-- 						<thead> -->
<!-- 						<tr> -->
<!-- 						<th>Test Name</th> -->
<!-- 						<th>Value</th> -->
<!-- 						<th>Measure Unit</th> -->
<!-- 						<th>Normal Value</th> -->
<!-- 						</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody class="table-body"> -->
						
<!-- 						</tbody> -->
<!-- 						</table> -->
									 		
				</div>
				
				<div class="panel-body">
				<div class="btn-div">
					<button type="button" class="btn btn-success ev-button" style="display: none;" onclick="evButton()">Edit</button>
				 	<button type="button" class="btn btn-warning ev-button" style="display: none;" onclick="eviewButton()">View</button>
				 	<button type="submit" class="btn btn-info" >Submit</button>
	                <button class="btn btn-danger" type="reset">Reset</button>
	                <button class="btn btn-info" data-dismiss="modal" aria-label="Close">Cancel</button>
					<button class='btn btn-success export-pdf-report k-button noExport'>Export as PDF</button>
	                <button class="btn btn-warning" onclick="window.print()">Print</button>
                </div>
				</div>
				</form>
                                <div class="res">

</div>
</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /End view-edit.modal -->

	<script>
	
	function submitForm(){
		var myform = document.getElementById("myform");
	    var fd = new FormData(myform );
	    $.ajax({
	        url: "update-payment",
	        data: fd,
	        cache: false,
	        processData: false,
	        contentType: false,
	        type: 'POST',
	        success: function (data) {
	        	if(data==1)
	        		{
	        		$('.res').html('<div class="alert alert-success alert-dismissible" ><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Success!</strong>Payment Updated Successfully.</div>');
	        		}
	        	else
	        		{
	        		$('.res').html('<div class="alert alert-success alert-dismissible" ><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Failure!</strong>Please Try Again.</div>');
	        		}
	        	
	        }
	    });
	}
	
	
		 $("#PpmtSts").change(function (e) {
      			 
      			 var status= $('#PpmtSts').val();
      			 if(status==='1')
      				 {
      				 $('.amountDiv1').hide();
      				$('#Ppayamt').val('0');
      				
      				 }
      			 else
      				 {
      				$('.amountDiv1').show();
      				 }
      			
      		 });
      		 
		 function getCalc(val)
		 {
			var totalAmt = $('#Ptotalprice').val();
			var pendAmt = (totalAmt-val);
			$('#Ppenamt').val(pendAmt);
		 }
      	
            </script>