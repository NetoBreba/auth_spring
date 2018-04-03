<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
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
			<div class="col-md-6 offset-md-3">
				<a style="margin-bottom: 10px"
					href="<c:url value='create/'/>" class="btn btn-success btn-block">Insert
					Book</a>
				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Pubish Date</th>
							<th>Edition</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${books}" var="book">
						<tr>
							<th>${book.id}</th>
							<td>${book.title}</td>
							<td>${book.publishDate}</td>
							<td>${book.edition}</td>
							<td><a href="<c:url value='update/${book.id}/'/>"
								class="btn btn-primary">Update</a></td>
							<td><a href="<c:url value='delete/${book.id}/'/>"
								class="btn btn-danger">Delete</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
	
</html>