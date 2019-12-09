<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>

	<div class="container">
		<form:form action="/songs/${song.id}" method="post"
			modelAttribute="song">
			 <div class="form-group">
				<form:label path="title">Title</form:label>
				<form:errors path="title" />
				<form:input class="form-control" path="title" />
			</div>
			 <div class="form-group">
				<form:label path="artist">Artist</form:label>
				<form:errors path="artist" />
				<form:input class="form-control" path="artist" />
			</div>
			 <div class="form-group">
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating" />
				<form:input class="form-control" type="number" path="rating" />
			</div>
			<input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>