<div class="w3layouts-main">

	<h2>Sign In Now</h2>
		<form action="staff-login" method="Post" onsubmit="return validateLoginForm()" name="LoginForm">
			<input type="text" class="ggg" name="staffEmail" placeholder="EMAIL" id="email">
			<input type="password" class="ggg" name="staffPassword" placeholder="PASSWORD" id="password">

			<!-- <h6><a href="#">Forgot Password?</a></h6> -->
			<div><p style="color:red">${message}</p></div>
				<div class="clearfix"></div>
				<div style="text-align: center; margin:10px;">
				 <button type="submit" class="btn btn-info" name="login" style="width: 30%">login</button>
				<button class="btn btn-danger" type="reset"  style="width: 30%">Cancel</button>
				</div>
		</form>
<!-- 		<p>Don't Have an Account ?<a href="#">Create an account</a></p> -->
</div>

