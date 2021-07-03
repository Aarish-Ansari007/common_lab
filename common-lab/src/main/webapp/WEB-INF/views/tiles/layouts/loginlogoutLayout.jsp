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
<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/font-awesome.css' />"	rel="stylesheet"></link>
<link href="<c:url value='/resources/css/font.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/select2.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/style-responsive.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/modal-style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/css/animate.min.css' />" rel="stylesheet"></link>

<script src="<c:url value="/resources/js/jquery2.0.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/developer.js"/>"></script>

</head>
<body>
<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>
</body>
</html>