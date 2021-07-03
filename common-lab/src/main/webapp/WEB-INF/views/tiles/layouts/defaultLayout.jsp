<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
 <link rel="shortcut icon" href="<c:url value='/resources/images/fav-icon.png' />" ></link>
<link href="<c:url value='/resources/css/bootstrap.min.css' />"	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/font-awesome.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/font.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/jqvmap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/lightbox.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/minimal.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/monthly.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/morris.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/style-responsive.css' />"	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/dataTable.css' />"	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/animate.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/modal-style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/select2.min.css' />" rel="stylesheet"></link>


<script src="<c:url value="/resources/js/jquery2.0.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/raphael-min.js"/>"></script>
<script src="<c:url value="/resources/js/morris.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.dcjqaccordion.2.7.js"/>"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<script type="<c:url value="/resources/js/jquery.slimscroll.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.nicescroll.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.scrollTo.js"/>"></script>
<script src="<c:url value="/resources/js/data.table.js"/>"></script>
<script src="<c:url value="/resources/js/developer.js"/>"></script>
<script src="<c:url value="/resources/js/select2.min.js"/>"></script>
</head>

<body>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>

	<section id="sidemenu">
		<tiles:insertAttribute name="menu" />
	</section>

	<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>

	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>


	<!-- Log out model -->
	<div class="modal modal-success fade" id="modal-success">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<center>Are you sure you want to logout?</center>
				</div>

				<div class="modal-footer">
					<center>
						<button type="button" class="btn btn-outline"
							style="background: #53d769">
							<a href="logout" style="color: #fff">Yes</a>
						</button>
						<button type="button" class="btn btn-outline" data-dismiss="modal"
							style="background: #fc3158; color: #fff">No</button>
					</center>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	
<!-- 	Update Assign amount Modal -->
	<div class="modal modal-success fade" id="resetAmtModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<center>
					<label>Assign Amount:</label>
					<input type="text" id="assignAmtInput" >
					<input type="hidden" id="staffIdInput" >
					</center>
				</div>

				<div class="modal-footer">
					<center>
						<button type="button" class="btn btn-outline"
							style="background: #53d769">
							<a href="#" style="color: #fff" onClick="resetUpdate()">Reset & Update</a>
						</button>
						<button type="button" class="btn btn-outline" data-dismiss="modal"
							style="background: #fc3158; color: #fff">Cancel</button>
					</center>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /Update Assign amount modal -->
	
	
	
	
		<!-- Add doctor model -->
	<div class="modal modal-success fade" id="doctor-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<center>Add Doctor</center>

				</div>
				
<div class="modal-footer">
<center id="modelError" style="color: red"></center>
					<div class=" form">
								
								<div class="form-group required col-lg-12">
										<label for="curl" class="control-label col-lg-4">Doctor Name</label>
										<div class="col-lg-8">
										<input class="form-control" type="text" name="doctorName" id="docName">
										</div>
									</div>
									
									<div class="form-group required col-lg-12">
										<label for="curl" class="control-label col-lg-4">Doctor Code</label>
										<div class="col-lg-8">
											<input class="form-control" type="text" name="doctorCode" id="docCode">
										</div>
									</div>
									</div>
									
									<div class="btn-div">
									 <button type="button" class="btn btn-info" onclick="addDoctor()">Submit</button>
                                <button class="btn btn-danger" data-dismiss="modal"
						aria-label="Close">Cancel</button>
                                </div>
</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	
	
	
	
			<!-- Upload report model -->
<!-- 	<div class="modal modal-success fade" id="report-modal"> -->
		<div class="modal fade right" id="report-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalPreviewLabel" aria-hidden="true">
    <div class="modal-dialog-full-width modal-dialog momodel modal-fluid" role="document">
        <div class="modal-content-full-width modal-content ">
            <div class=" modal-header-full-width   modal-header text-center">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<center>UPLOAD REPORT</center>

				</div>
				
<div class="modal-footer">
<section class="panel">
			
				
				<div class="panel-body">
					<div class="position-center">
<form method="POST">
					<div class="form-group">
				
						<div class="form-group col-lg-6">
								<label for="curl" class="control-label col-lg-6">Date</label>
								<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >ooooo</span></div>
							</div>
							
							<div class="form-group col-lg-6">
								<label for="curl" class="control-label col-lg-6">Patient Name</label>
								<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >oioioio</span></div>

							</div>
							
							<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Patient Age</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >uiiuu</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Phone Number</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >jjbjbj</span></div>
									</div>
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Doctor's Ref.</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >jjbjbj</span></div>
									</div>
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">SEX.</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >jjbjbj</span></div>
									</div>
									</div>
								</form>
								</div>
								</div>
								</section>
								
								
								
								<section class="panel">
			
				
				<div class="panel-body">
					<div class="position-center">
<form method="POST">
					<div class="form-group">
				
						<div class="form-group col-lg-6">
								<label for="curl" class="control-label col-lg-6">Patient Title</label>
								<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >ooooo</span></div>
							</div>
							
							<div class="form-group col-lg-6">
								<label for="curl" class="control-label col-lg-6">Patient First Name</label>
								<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >oioioio</span></div>

							</div>
							
							<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Patient Last Name</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >uiiuu</span></div>
									</div>
									
									<div class="form-group col-lg-6">
										<label for="curl" class="control-label col-lg-6">Phone Number</label>
										<div class="col-lg-6" style="color: #000; background-color: #fff;"><span >jjbjbj</span></div>
									</div>
									</div>
								</form>
								</div>
								</div>
								</section>
									
									<div class="btn-div">
									 <button type="button" class="btn btn-info" onclick="uploadReport()">Submit</button>
                                <button class="btn btn-danger" data-dismiss="modal"
						aria-label="Close">Cancel</button>
                                </div>
</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
	


</body>
</html>
<style>

 .modal-dialog-full-width {
        width: 100% !important;
        height: 100% !important;
        margin: 0 !important;
        padding: 0 !important;
        max-width:none !important;

    }
    </style>
 <script type="text/javascript">
 
 </script>