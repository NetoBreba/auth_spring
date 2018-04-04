<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<c:url var="loginUrl" value="/login" />

	<div class="row" style="margin-top: 50px">
		<div class="col-md-4 offset-md-4">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger" role="alert">
  					Username or password invalid
				</div>
			</c:if>
		
			<form action="${loginUrl}" method="POST">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						name="username" class="form-control" id="username"
						placeholder="Username">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="password" class="form-control" id="password"
						placeholder="Password">
				</div>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

				<button type="submit" class="btn btn-primary btn-block">Login</button>
			</form>
		</div>
	</div>
</body>
</html>