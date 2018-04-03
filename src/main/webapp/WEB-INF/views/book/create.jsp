<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Update Book</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Books List</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/bootstrap.min.css'/>"></link>
		<link rel="stylesheet" type="text/css" href="<c:url value='/assets/css/main.css'/>"></link>
		<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
		<script src="<c:url value='/assets/js/jquery-3.2.1.slim.min.js'/>"></script>
		<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.4/combined/js/gijgo.min.js" type="text/javascript"></script>
		<link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.4/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
		<div class="row mg-top">
			<div class="col-md-6 offset-md-3">
				<form:form role="form" commandName="book" servletRelativeAction="" method="POST">
					<div class="form-group">
						<label for="title">Title</label>
						<form:input type="text" class="form-control" id="title" placeholder="book title" path="title" name="title"/>
					</div>
	
					<div class="form-group">
						<label for="author">Author</label>
						<form:input type="text" class="form-control" id="author" placeholder="author" path="author"/>
					</div>
	
					<div class="form-group">
						<label for="publish-date">Publish Date</label>
						<form:input type="text" class="form-control" id="publish-date" placeholder="publish date" path="publishDate"/>
					</div>
	
	
					<div class="form-group">
						<label for="edition">Edition</label>
						<form:input type="text" class="form-control" id="edition" placeholder="book edition" path="edition"/>
					</div>
	
					<button type="submit" class="btn btn-success btn-block">Create
						Book</button>
					<a href="<c:url value='/books/'/>" class="btn btn-info btn-block">Voltar</a>
				</form:form>
			</div>
		</div>
	</body>
	<script>
        $('#publish-date').datepicker({
            uiLibrary: 'bootstrap4',
            dateFormat: "yy-mm-dd"
        });
	</script>
</html>