<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel">
				<header class="panel-heading"> Staff List </header>
				<div class="panel-body">
					<div class="position-center">
					<div class="agile-tables">
					<div class="w3l-table-info">
					    <div class="col-sm-12 mail-w3agile" id="table-div">
					    <table class="table stats-table example">
												<thead>
												<tr>
														<th>Sr.NO</th>
														<th>Staff Name</th>
														<th>Total Earning</th>
														<th>Assign Amount</th>
														<th>Update Amount</th>
														<th>Status</th>
												</tr>
														</thead><tbody>
														${staffList}
														</tbody></table>
					    </div>
					</div>
				  

			

			</div>
                            </div>
                        </div>
			</section>
			</section>
			</section>
			</section>
                    
                    
                    <script type="text/javascript">
                   function resetAmt(staffId, amount) {
					$('#assignAmtInput').val(amount);
					$('#staffIdInput').val(staffId);
					$("#resetAmtModal"). modal('show');
				}
                   function resetUpdate() {
					var assignAmt = $('#assignAmtInput').val();
					var staffId = $('#staffIdInput').val();
					
					$.ajax({
                    	url: "update-assign-amount",
                        data:{staffid:staffId, assignamt:assignAmt},
                        type: "POST",
                        success: function (data) {
                       if(data==1)
                    	   {
                    	   window.location.href='staff';
                    	   $("#resetAmtModal"). modal('hide');
                    	   }
                    }
				});
                   }

                    
</script>

       