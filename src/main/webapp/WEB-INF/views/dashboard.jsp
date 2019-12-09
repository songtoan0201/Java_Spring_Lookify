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
		<h1>This is dashboard page</h1>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href="/songs/new">Add New</a></li>
					<li class="nav-item"><a class="nav-link" href="/search/topten">Top
							Songs</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" action="/search/${song.artist}" method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" name="artist">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search
						Artists</button>
				</form>
			</div>
		</nav>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">Song title</th>
					<th scope="col">Artist</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${song.id}"><c:out
									value="${song.title}" /></a></td>
						<td><c:out value="${song.artist}" /></td>
						<td><a href="/songs/${song.id}/delete">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>