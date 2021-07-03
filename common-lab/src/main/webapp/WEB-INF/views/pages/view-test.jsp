<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel">
			
				<header class="panel-heading"> View Test Record Form </header>
				<div class="form-group">
				
						<div class="form-group col-lg-6">
								<label for="curl" class="control-label col-lg-6">Patient Title</label>
								<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.patientTitle}</span></div>
							</div>
							
							<div class="form-group col-lg-6">
								<label for="curl" class="control-label col-lg-6">Patient First Name</label>
								<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.patientFirstName}</span></div>
<!-- 								<div class="col-lg-6"> -->
<!-- 											<select name="patientTitle" id="title" class="form-control"> -->
<%-- 											<option value="${testRecordsBean.patientTitle}">${testRecordsBean.patientTitle}</option> --%>
<!-- 											<option value="Mr">Mr.</option> -->
<!-- 											<option value="Mrs">Mrs.</option> -->
<!-- 											<option value="Miss">Miss.</option> -->
<!-- 											</select> -->
<!-- 										</div> -->
							</div>
							
							<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Patient Last Name</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.patientLastName}</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Phone Number</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.patientPhone}</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">DOB</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff; width: 50%;"><span>${testRecordsBean.patientDOB}</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Age</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.patientAge}</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Patient Sex</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.patientSex}</span></div>
									</div>
									
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Bar Code</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.barCode}</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Payment Mode</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.paymentMode}</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Payment Accepted By</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.paymentAcceptedBy}</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Apply Date</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.createdDate}</span></div>
									</div>
									
									<div class="form-group col-lg-6"> 
									 		<label for="curl" class="control-label col-lg-6">Doctor Reference</label> 
									 		<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testRecordsBean.referenceDoctorId}</span></div>
									 		</div>
									 	
									 	<div class="form-group col-lg-6" > 
									 		<label for="curl" class="control-label col-lg-6">Test Code</label> 
									 		<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testDetailBean[0].testCode}</span></div>
									 	</div>  
							 	
									<div class="form-group col-lg-6">
										<label for="cname" class="control-label col-lg-6">Base Price</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testDetailBean[0].basePrice}</span></div>
									 		
									</div>

									<div class="form-group col-lg-6">
										<label for="cemail" class="control-label col-lg-6">Offer Price</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testDetailBean[0].offerPrice}</span></div>
									 		
									</div>
									
										<div class="form-group col-lg-6">
										<label for="cemail" class="control-label col-lg-6">Offer Rate</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testDetailBean[0].offerRate}</span></div>
									 		
									</div>
									
									<div class="form-group col-lg-6">
										<label for="cemail" class="control-label col-lg-6">Discount</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testDetailBean[0].discount}</span></div>
									 		
									</div>
									
										<div class="form-group col-lg-6">
										<label for="cemail" class="control-label col-lg-6">Net Price</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >${testDetailBean[0].netPrice}</span></div>
									 		
									</div>
									 		
				</div>
				
				<div class="panel-body">
				<div class="btn-div">
					<button type="button" class="btn btn-success addss">Add More Test</button>
				 	<button type="submit" class="btn btn-info">Submit</button>
	                <button class="btn btn-danger" type="reset">Reset</button>
	                <button class="btn btn-info" onclick="window.location.replace('/common-lab/dashboard');">Cancel</button>
	                <button class="btn btn-warning" onclick="window.print()">Print</button>
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
					 
				  debugger;
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
            	
            	
            debugger;
            	if('${staffRole}'=="ADMIN")
            	{
            	$.ajax({
            	    url: "get-lab",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select Lab</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {  
            	            	 
            	htm = htm +' <option value='+item.labId+','+item.labCode+'>'+item.labName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tfLab').html(htm);  
            	             }      
            	}); 
   
            	}
            else
            	{
   	             $('#tfLab').html(' <option value="${staffId},${staffCode}">${staffName}</option>'); 
   	          $('#tfLab').attr('disabled', 'disabled')
   	          getLab("${staffId},${staffCode}","0");
            	}
            	
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
            function getLab(labId,tId)
            {
            	debugger;
            	var id = tId;
 				var labData = labId.split(",");
            	if(labData[1]==='W.')
            		{
            		$('.ofp').removeAttr("readonly");
            		}
            	
 				$('#tfLabCode').val(labData[1]);
            	if (labData[0]=="") 
            		{return;}
            	else
            		{
            	$.ajax({
            	    url: "get-lab-record/"+labData[0],
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
            	  getLab($('#tfLab').val(),nextindex);
            	  var lab = $('#tfLab').val().split(",");
//               	if(lab[1]!='W.')
//         		{
//         		prop = 'readonly';
//         		}
var html = "";
            	   // Adding new div container after last occurance of element class
            	   $(".elementss:last").after("<div class='elementss containerss' id='div_"+ nextindex +"'></div>");
            	 html = html+'<div class="form-group required"><label for="curl" class="control-label col-lg-4">Test Name:</label>'
			 		+'<div class="col-lg-8"> <select class="form-control myselect tfTest" id="tfTest'+ nextindex +'" name="testId" onchange="getTestRecord(this.value,'+ nextindex +')"></select>'
             		+'<input type="hidden" name="testDetailBean['+ (nextindex-1) +'].testCode" id="tfTestCode'+ nextindex +'"></div></div>'
					+'<div class="form-group required"><label for="cname" class="control-label col-lg-4">Base Price</label>'
					+'<div class="col-lg-8"><input class="form-control" type="text" name="testDetailBean['+ (nextindex-1) +'].basePrice" id="tfprice'+ nextindex +'" readonly></div></div>'
					+'<div class="form-group required"><label for="cemail" class="control-label col-lg-4">Offer Price</label>'
					+'<div class="col-lg-8"><input class="form-control" type="text"  name="testDetailBean['+ (nextindex-1) +'].offerPrice" id="tfofferprice'+ nextindex +'" oninput="myFunction(this.value,'+ nextindex +')" '+prop+'></div></div>'
					+'<div class="form-group required"><label for="cemail" class="control-label col-lg-4">Offer Rate</label>'
					+'<div class="col-lg-8"><input class="form-control" type="text"  name="testDetailBean['+ (nextindex-1) +'].offerRate" id="tfofferrate'+ nextindex +'" readonly></div></div>'
					+'<div class="form-group required"><label for="cemail" class="control-label col-lg-4">Discount</label>'
					+'<div class="col-lg-8"><input class="form-control" type="text" name="testDetailBean['+ (nextindex-1) +'].discount" id="offer'+ nextindex +'" readonly></div></div>'
					+'<div class="form-group required"><label for="cemail" class="control-label col-lg-4">Net Price</label>'
					+'<div class="col-lg-8"><input class="form-control" type="text" name="testDetailBean['+ (nextindex-1) +'].netPrice" id="tftotalprice'+ nextindex +'" readonly></div></div>';
            	   // Adding element to <div>
            	   $("#div_" + nextindex).append(html+"<div class='col-lg-2' style='float:right; margin-top: -9%;'><a id='remove_" + nextindex + "' class='add' onclick='deleteDiv("+nextindex+")'><i class='fa fa-times-circle' aria-hidden='true'></i></a></div>");
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
      		
            </script>
            
            <style>
#errmsg
{
color: red;
}

</style>
