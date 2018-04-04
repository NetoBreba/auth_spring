<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Books List</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/bootstrap.min.css'/>"></link>
		<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/main.css'/>"></link>
		<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
		<script src="<c:url value='/assets/js/jquery-3.2.1.slim.min.js'/>"></script>
		<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/books.css'/>"></link>
</head>
<body>
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div style="margin-top:50px; text-align: center" class="alert alert-danger" role="alert">
  				Access Denied
			</div>
			
			<a style="color: #ffffff" href="<c:url value="/login" />" class="btn btn-primary btn-block" >Login</a>
		</div>
	</div>
</body>
</html>