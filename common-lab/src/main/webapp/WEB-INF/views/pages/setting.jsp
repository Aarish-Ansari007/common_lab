<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel">
				<header class="panel-heading"> Update Password </header>
				<div class="panel-body">
					<div class="position-center">
					<span style="color:#f00;" id="errorMsg"></span>
                                <form role="form" onsubmit="validateSettingForm()"  id="settingForm" name="settingForm">
                                <div class="form-group required">
                                    <label for="exampleInputPassword1" class="control-label">Old Password</label>
                                    <input type="password" class="form-control" id="old-pass" name="old-password" placeholder="Password">
                                </div>
                                 <div class="form-group required">
                                    <label for="exampleInputPassword1" class="control-label">New Password</label>
                                    <input type="password" class="form-control" id="new-pass" name="new-password" placeholder="Password">
                                </div>
                                 <div class="form-group required">
                                    <label for="exampleInputPassword1" class="control-label">Confirm Password</label>
                                    <input type="password" class="form-control" id="con-pass" name="confirm-password" placeholder="Password">
                                </div>
                                
                                <button type="submit" class="btn btn-info">Submit</button>
                                <button class="btn btn-danger" type="reset">Cancel</button>
                                
                            </form>
                            </div>
                        </div>
			</section>
			</section>
			</section>
			</section>
                    
                    
                    <script type="text/javascript">
                    
                    var frm = $('#settingForm');

                    frm.submit(function (e) {
                        e.preventDefault();
                        
                        var oldPass = $('#old-pass').val();
                    	  var newPass = $('#new-pass').val();
                    	  var conPass = $('#con-pass').val();
                    	  if(oldPass=="" || oldPass.length<3)
                    		{
                    		  alert('Please Enter Valid Old Password!');
                    		  $('#old-pass').focus();
                    		}
                    	else if(newPass=="" || newPass.trim().length<3 || newPass!=conPass)
                    		{
                    		alert('New Password and Confirm Password Not Match!');
                    		$('#con-pass').focus();
                    		}
                    	else
                    		{
                        $.ajax({
                        	url: "update-setting",
                            data:{oldPassword:$('#old-pass').val(), newPassword:$('#con-pass').val()},
                            type: "POST",
                            success: function (data) {
                            	$('#settingForm')[0].reset();
                            	if(data==="login")
                            	{
                            	window.location.href = "login";
                            	}
                            else
                            	{
                            	$('#errorMsg').html(data);
                            	}
                            },
                            error: function (data) {
                            	window.location.href = "login";
                            },
                        });
                    		}
                    });
</script>

       