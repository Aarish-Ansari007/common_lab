<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel">
			
				<header class="panel-heading"> Add Patient Form </header>
				<div class="panel-body">
					<div class="position-center">
				
										<div>${errorMsg}</div>
						<form method="POST" action="save-test-record" class="cmxform" name="testRecordBean" id="testRecordForm" onsubmit="return validateTestRecordForm()" >

							<div class="panel-body">
								<div class="form">
								
								<div class="form-group col-lg-12">
										<label for="curl" class="control-label">Patient Title</label>
										<div class="formInputhldr">	
											<select name="patientTitle" id="title" class="form-control"style="width: 10%">
											<option value="Mr">Mr.</option>
											<option value="Mrs">Mrs.</option>
											<option value="Miss">Miss.</option>
											</select>
										</div>
									</div>
									
									<div class="form-group col-lg-4">
										<label for="curl" class="control-label">Patient First Name</label>
										<div class="">
											<input class="form-control" type="text" name="patientFirstName" id="tfpatientfname">
										</div>
									</div>
									
									<div class="form-group required col-lg-4">
										<label for="curl" class="control-label">Patient Last Name</label>
										<div class="">
											<input class="form-control" type="text" name="patientLastName" id="tfpatientlname">
										</div>
									</div>
									
									<div class="form-group required col-lg-4">
										<label for="curl" class="control-label">Phone Number</label>
										<div class="mobileD">
											<input class="form-control" type="number" name="patientPhone" id="tfphonenumber" required>
										</div>
									</div>
									
									<div class="form-group col-lg-4">
										<label for="curl" class="control-label">Select DOB</label>
										<div class="">
											<input class="form-control" type="date" id="tfdob" name="patientDOB">
										</div>
									</div>
									
									<div class="form-group col-lg-4">
										<label for="curl" class="control-label">Select Age</label>
										<div class="">
											<input class="form-control" type="text" id="tfage" name="patientAge" placeholder="YY-MM-DD">
										</div>
									</div>
									
									<div class="form-group col-lg-4">
										<label for="curl" class="control-label">Patient Sex</label>
										<div class="">
											<select name="patientSex" id="psex" class="form-control">
											<option value="MALE">MALE.</option>
											<option value="FEMALE">FEMALE.</option>
											<option value="OTHER">OTHER.</option>
											</select>
										</div>
									</div>
									
									
									<div class="form-group required col-lg-4">
										<label for="curl" class="control-label">Enter Bar Code</label>
										<div class="barD">
											<input class="form-control" type="text" id="tfbarcode" name="barCode" onchange="getValidBarCode(this)">
										</div>
									</div>
									
									<div class="form-group required col-lg-4">
										<label for="curl" class="control-label">Apply Date</label>
										<div class="barD">
											<input class="form-control" type="date"  id="tfAppdate" name="createdDate">
										</div>
									</div>
									
<!-- 									<div class="form-group required col-lg-12" >  -->
<!-- 									 		<label for="curl" class="control-label">Select Doctor Reference:</label>  -->
<!-- 									 		<div class=""> -->
<!-- <!--                                        <select class="form-control myselect tfTest " id='tfTest0' name="testId" onchange="getTestRecord(this.value,0)"></select> --> 
<!-- 									 		<select class="form-control myselect" id='tfDoctor' name="referenceDoctorId" ></select> -->
<!-- 									 		</div> -->
<!-- 									 </div> -->
									
										<div class="form-group col-lg-12"> 
									 		<label for="curl" class="control-label">Select Doctor Reference:</label> 
									 		<div class="">
                                       <select class="form-control myselect" id='tfDoctor' name="referenceDoctorId" ></select>
									 		</div>
									 		<div class='col-lg-2' style='float:right; margin-top: -5%;'>
                                       <a href="#" data-toggle="modal" data-target="#doctor-modal" class="add"><i class="fa fa-plus-circle"></i></a>
									 		</div>
									 	</div>


									 	<div id="multipleTestRecord">
									 	<div id='div_1' class="containerss elementss">
 									<div class="form-group required col-lg-12" > 
									 		<label for="curl" class="control-label">Test Name:</label> 
									 		<div class="">
                                       <select class="form-control myselect tfTest " id='tfTest0' name="testId" onchange="getTestRecord(this.value,0)"></select>
                                        <input type="hidden" name="testDetailBean[0].testCode" id="tfTestCode0">
									 		</div>
									 </div>  
							 	
									<div class="form-group required col-lg-2">
										<label for="cname" class="control-label">Base Price</label>
										<div class="">
										<input class="form-control" type="text" name="testDetailBean[0].basePrice" id="tfprice0" readonly>
										</div>
									</div>

									<div class="form-group required col-lg-2">
										<label for="cemail" class="control-label">Offer Price</label>
										<div class="">
											<input class="form-control ofp" type="text" name="testDetailBean[0].offerPrice" id="tfofferprice0" oninput="myFunction(this.value,0)" >
										</div>
									</div>
									
										<div class="form-group required col-lg-2">
										<label for="cemail" class="control-label">Offer Rate</label>
										<div class="">
											<input class="form-control" type="text" name="testDetailBean[0].offerRate" id="tfofferrate0" readonly>
										</div>
									</div>
									
									<div class="form-group required col-lg-3">
										<label for="cemail" class="control-label">Discount</label>
										<div class="">
											<input class="form-control" type="text" name="testDetailBean[0].discount" id="offer0" readonly>
										</div>
									</div>
									
										<div class="form-group required col-lg-3">
										<label for="cemail" class="control-label">Net Price</label>
										<div class="">
											<input class="form-control" type="text" name="testDetailBean[0].netPrice" id="tftotalprice0" readonly>
										</div>
									</div>
									</div>
								</div>
<div class="payment col-lg-12">
									<div class="form-group col-lg-3">
										<label for="curl" class="control-label">Payment Mode</label>
										<div class="">
											<select name="paymentMode" id="pm" class="form-control">
											<option value="OFFLINE">OFFLINE.</option>
											<option value="ONLINE">ONLINE.</option>
											<option value="OTHER">OTHER.</option>
											</select>
										</div>
									</div>
									
									<div class="form-group required col-lg-3">
										<label for="curl" class="control-label">Payment Accepted By</label>
										<div class="barD">
											<input class="form-control" type="text" id="tfpab" name="paymentAcceptedBy" value="SELF">
										</div>
									</div>
									
									<div class="form-group col-lg-3">
										<label for="curl" class="control-label">Payment Status</label>
										<div class="">
											<select name="paymentStatus" id="pmtSts" class="form-control">
											<option value="0">Pending</option>
											<option value="1">Done.</option>
											</select>
										</div>
									</div>
									
									<div class="form-group amountDiv col-lg-3">
										<label for="curl" class="control-label">Payable Amount </label>
										<div class="barD">
											<input class="form-control" type="number" value="0" id="tfpamt" name="receivedAmount">
										</div>
									</div>
									</div>
									
									 	</div>
										<div class="btn-div">
										<button type="button" class="btn btn-success addss">Add More Test</button>
									 <button type="submit" class="btn btn-info">Submit</button>
                                <button class="btn btn-danger" type="reset">Reset</button>
                                <button class="btn btn-info" onclick="window.location.replace('/common-lab/dashboard');">Cancel</button>
                                <button class="btn btn-warning" onclick="window.location.replace('/common-lab/dashboard');">Dashboard</button>
                                <button class="btn btn-success" onclick="window.location.replace('/common-lab/supply-bill');">Supply-Bill</button>
                                <button class="btn btn-warning" onclick="window.print()">Print</button>
                                </div>
                              
								</div>
						</form>
					</div>
				</div>
			</section>
			</section>
			</section>
			</section>
			
			
			
			 <script type="text/javascript">
			 function myFunction(val1, val2) {
				 var type=$('#tfofferrate'+val2).val();
				 
				 if(type=='Percent(%)')
					 {
					 if(val1=="" || val1==null )
					   {
					   val1=1;
					   $('#tfofferprice'+val2).val(val1);
					   }
					 
				   var basePrice = $('#tfprice'+val2).val();
				   var calculate = (basePrice * val1)/100; 
				   $('#offer'+val2).val(calculate);
				   
				   $('#tftotalprice'+val2).val(parseFloat(basePrice)-parseFloat(calculate));
					 }
				 else
					 {
					 if(val1=="" || val1==null )
					   {
					   val1=0;
					   $('#tfofferprice'+val2).val(val1);
					   }
				   $('#offer'+val2).val(val1);
				   var basePrice = $('#tfprice'+val2).val();
				   $('#tftotalprice'+val2).val(parseFloat(basePrice)-parseFloat(val1));
					 }
			   
			 }
			 
            $(".myselect").select2();
            $(document).ready(function () {
     
   	          $('#tfLab').html(' <option value="${staffId},${staffCode}">${staffName}</option>'); 
   	          $('#tfLab').attr('disabled', 'disabled')
   	          getLab("0");
            	
            	
            	$.ajax({
            	    url: "get-doctor",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select Doctor</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {  
            	htm = htm +' <option value='+item.doctorCode+'>'+item.doctorName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tfDoctor').html(htm);  
            	             }      
            	}); 
            });
           
            var object="";
            function getLab(tId)
            {
            	var id = tId;
 				
            	$.ajax({
            	    url: "get-lab-record",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    success: function (responce)
            	    {
            	    	
            	    	var htm = "<option value=''> Select Test</option>";
            	    	 var data = JSON.stringify(responce);
            	    	 object = JSON.parse(data);
            	         	
            	         	 $.each(object, function(index,item) { 
            	htm = htm +' <option value='+item.recordId+','+item.testBeans.testCode+'>'+item.testBeans.testName+' ('+item.testBeans.testCode+')</option>';
            	            
            	         	});
            	             htm = htm;
            	             $('#tfTest'+id).html(htm);  
            	             $(".myselect").select2();
            	             }      
            	});
            }
            
            
            function getTestRecord(recordId,id)
            {
        	var testData = recordId.split(",");
				$('#tfTestCode'+id).val(testData[1]);
            	if (testData[0]=="") 
            		{return;}
            	else
            		{
            		 $.each(object, function(index, item){
            			
            			 if(testData[0] == (item.recordId))
     	           		{
         			 		var basePrice = 0;
         			 		var offer = 0;
     	           		$("#tfprice"+id).val(item.testBeans.basePrice);
     	           		 $("#tfofferprice"+id).val(item.offerPrice);
     	           		
     	           		if(item.offerRate != '%')
     	           			{
     	           		$("#tfofferrate"+id).val("In Rupees");
     	           			basePrice = (item.testBeans.basePrice-item.offerPrice);
     	           		offer = item.offerPrice;
     	           			}
     	           		else
     	           			{
     	           		$("#tfofferrate"+id).val("Percent(%)");
     	           			basePrice = 	(item.testBeans.basePrice-((item.testBeans.basePrice*item.offerPrice)/100));
     	           			offer = (item.testBeans.basePrice*item.offerPrice)/100;
     	           			}
     	           			$("#tftotalprice"+id).val(basePrice); 
     	           			$("#offer"+id).val(offer); 
     	           		}
         			 	else
         			 		{
         			 		
         			 		}
            	        });
            		}
            }
            	
            $(document).ready(function(){
            	var prop = '';
                   	 // Add new element
            	 $(".addss").click(function(){
            	  // Finding total number of elements added
            	  var total_element = $(".elementss").length;
            	  // last <div> with element class id
            	  var lastid = $(".elementss:last").attr("id");
            	  var split_id = lastid.split("_");
            	  var nextindex = Number(split_id[1]) + 1;
            	  getLab(nextindex);
            	  //var lab = $('#tfLab').val().split(",");
//               	if(lab[1]!='W.')
//         		{
//         		prop = 'readonly';
//         		}
var html = "";
            	   // Adding new div container after last occurance of element class
            	   $(".elementss:last").after("<div class='elementss containerss' id='div_"+ nextindex +"'></div>");
            	 html = html+'<div class="form-group required  col-lg-12"><label for="curl" class="control-label">Test Name:</label>'
			 		+'<div class=""> <select class="form-control myselect tfTest" id="tfTest'+ nextindex +'" name="testId" onchange="getTestRecord(this.value,'+ nextindex +')"></select>'
             		+'<input type="hidden" name="testDetailBean['+ (nextindex-1) +'].testCode" id="tfTestCode'+ nextindex +'"></div></div>'
					+'<div class="form-group required  col-lg-2"><label for="cname" class="control-label">Base Price</label>'
					+'<div class=""><input class="form-control" type="text" name="testDetailBean['+ (nextindex-1) +'].basePrice" id="tfprice'+ nextindex +'" readonly></div></div>'
					+'<div class="form-group required col-lg-2"><label for="cemail" class="control-label">Offer Price</label>'
					+'<div class=""><input class="form-control" type="text"  name="testDetailBean['+ (nextindex-1) +'].offerPrice" id="tfofferprice'+ nextindex +'" oninput="myFunction(this.value,'+ nextindex +')" '+prop+'></div></div>'
					+'<div class="form-group required col-lg-2"><label for="cemail" class="control-label">Offer Rate</label>'
					+'<div class=""><input class="form-control" type="text"  name="testDetailBean['+ (nextindex-1) +'].offerRate" id="tfofferrate'+ nextindex +'" readonly></div></div>'
					+'<div class="form-group required col-lg-3"><label for="cemail" class="control-label">Discount</label>'
					+'<div class=""><input class="form-control" type="text" name="testDetailBean['+ (nextindex-1) +'].discount" id="offer'+ nextindex +'" readonly></div></div>'
					+'<div class="form-group required col-lg-3"><label for="cemail" class="control-label">Net Price</label>'
					+'<div class=""><input class="form-control" type="text" name="testDetailBean['+ (nextindex-1) +'].netPrice" id="tftotalprice'+ nextindex +'" readonly></div></div>';
            	   // Adding element to <div>
            	   $("#div_" + nextindex).append(html+"<div class='col-lg-2' style='float:right; margin-top: -14%;'><a id='remove_" + nextindex + "' class='add' onclick='deleteDiv("+nextindex+")'><i class='fa fa-times-circle' aria-hidden='true'></i></a></div>");
            	 });
            	
            	});
            // Remove element
            
      	  function deleteDiv(id)
 	 {
      	$("#div_" + id).remove(); 
 	 }
            
      		 $("#tfphonenumber").keypress(function (e) {
      			  var mob= $("#tfphonenumber").val();
      			     
      			     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
      			        //display error message
      			        $(".mobileD").append('&nbsp;<span id="errmsg"></span>');
      			        $("#errmsg").html("Digits Only").show().fadeOut("slow");
      			               return false;
      			    }
      			    else if(mob.length>9 )
      			    {
      			    	$(".mobileD").append('&nbsp;<span id="errmsg"></span>');
      			    $("#errmsg").html("Maximum 10 Digits Only").show().fadeOut("slow");
      			               return false;
      			    }
      			   
      			   });
 
      		 $("#tfbarcode").keypress(function (e) {
     			  var barcode= $("#tfbarcode").val();
     			     
     			     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
     			        //display error message
     			        $(".barD").append('&nbsp;<span id="errmsg"></span>');
     			        $("#errmsg").html("Digits Only").show().fadeOut("slow");
     			               return false;
     			    }
     			    else if(barcode.length>8 )
     			    {
     			    	$(".barD").append('&nbsp;<span id="errmsg"></span>');
     			    $("#errmsg").html("Maximum 9 Digits Only").show().fadeOut("slow");
     			               return false;
     			    }
     			   
     			   });

      		 $("#title").change(function (e) {
      			 var title= $('#title').val();
      			 if(title=='Mr')
      				 {
      				$('#psex').val('MALE');
      				 }
      			 else if(title=='Mrs')
      			 {
      			$('#psex').val('FEMALE');
      			 }
      			 else {
      				$('#psex').val('OTHER');
      			 }
      		 });
      		 
      		 
      		 $("#pmtSts").change(function (e) {
      			 
      			 var status= $('#pmtSts').val();
      			 if(status==='1')
      				 {
      				 $('.amountDiv').hide();
      				$('#tfpamt').val('0');
      				
      				 }
      			 else
      				 {
      				$('.amountDiv').show();
      				 }
      			
      		 });
      		 
      	
            </script>
            
            <style>
#errmsg
{
color: red;
}

</style>
