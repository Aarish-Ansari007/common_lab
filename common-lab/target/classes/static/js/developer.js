/* Login Form**/

	 
function validateLoginForm() {
	
	  var uEmail = document.LoginForm.staffEmail.value;
	  var uPass = document.LoginForm.staffPassword.value;
	  var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  if(uEmail=="" || !regex.test(uEmail))
		{
		  alert('Please Enter Valid Email!');
		document.LoginForm.staffEmail.focus();
		return false
		}
	else if(uPass=="" || uPass.trim().length<3)
		{
		alert('Please Enter Valid Password!');
		document.LoginForm.staffPassword.focus();
		return false;
		}
	else
		{
	    return true;
	  }
	}


/* validate Test Data Form Form**/
var isBarCodeValid=false;
function getValidBarCode(barCode){
   	$.ajax({
	    url: "get-barcode/"+barCode.value,
	    type: 'GET',
	    datatype:"json",
	    contentType: "application/json; charset=utf-8",
	    success: function (responce)
	    {
	    	isBarCodeValid= responce; 
	    }
	})
}

	
	 
function validateTestRecordForm() {
 	var patientLName = document.testRecordBean.patientLastName.value;
  	var phone = document.testRecordBean.patientPhone.value;
	var age = document.testRecordBean.patientAge.value;
	var barCode = document.testRecordBean.barCode.value;
  	var labName = document.testRecordBean.labId.value;
  	
 if(patientLName.trim()=="")
	{
	  alert('Please Enter Patient Last Name!');
	  document.testRecordBean.patientLastName.focus();
	return false
	}
  else if(barCode.trim()=="")
	{
	  alert('Please Enter Bar Code!');
	  document.testRecordBean.barCode.focus();
	return false
	}

  else if(isBarCodeValid==false)
	{
	  alert('Please Enter Unique Bar Code!');
	  document.testRecordBean.barCode.focus();
	return false
	}
  else if(labName=="")
	{
	
	  alert('Please Select Lab Name!');
	  document.testRecordBean.labId.focus();
	return false
	}
	else
	{
    return true;
  }
}


function addDoctor()
{
var docName =$('#docName').val();
var docCode =$('#docCode').val();
if(docName.trim()=="")
{
	alert('Please Enter Doctor Name!');
	$('#docName').focus();
return false
}
else if(docCode.trim()=="")
	{
	alert('Please Enter Doctor Code!');
	$('#docCode').focus();
return false
	}
else
{
	
  	$.ajax({
	    url: "add-doctor",
	    type: 'POST',
	    data:{"docName":docName, "docCode":docCode},
	    dataType: "text",
	    success: function (responce)
	    {
	    	if(responce!='0')
	    		{
	    		 $(".myselect").select2();
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
	    		$("#doctor-modal").modal("hide");
	    		}
	    	else
	    		{
	    		$("#modelError").html("Record not added. Please Try again !");
	    		}
	    }
	    	
	             
	}); 
}
}


$(function(){

    $("#report").on('change', function(event) {
        var file = event.target.files[0];
        if(file.size>=10*1024*1024) {
            alert("Pdf of maximum 10MB");
            $("#report").val('');
            $("#report").focus();
            return false;
        }
        else if(!file.type.match('pdf*')) {
            alert("only Pdf format");
            $("#report").val('');
            $("#report").focus();
            return false;
        }
        else
        	{
return true;
        	}
    });
    
 
})


function uploadReport()
{
	   var fileInput = document.getElementById('report');
	   var file = fileInput.files[0];
    var recordId = $("#record-id").val();

	   var formData = new FormData();
	   formData.append('file', file);
	   formData.append('recordId', recordId);
	           	  $.ajax({
	                     url: "upload-report",
	                     type: "POST",
	                     data: formData,
	                     enctype: 'multipart/form-data',
	                     processData: false,
	                     contentType: false,
	                     cache: false,
	                     success: function (res) {
	                    	 if(res=='0')
	                    		 {
	                    		 $("#rmodelError").html("Report not uploaded. Please try again!");
	                    		
	                    		 }
	                    	 else
	                    		 {
	                    		 validateFilterData();
	                    		 $("#report-modal").modal("hide");
	                    		 }
	                     },
	                     error: function (err) {
	                    	 $("#rmodelError").html("Report not uploaded. Please try again!");
	                     }
	                 });	

}

function addrecordId(value)
{
	
$('#record-id').val(value);
}
