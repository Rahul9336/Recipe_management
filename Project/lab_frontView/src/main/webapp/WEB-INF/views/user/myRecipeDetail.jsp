<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<s:url var="css" value="/resources/css/"></s:url>
<s:url value="/resources/js" var="js"></s:url>
<s:url var="url_img" value="/resources/images/"></s:url>
<s:url var="url_Recipe_img" value="/resources/images/recipe_images"></s:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${css}/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="${js}/jquery.js" type="text/javascript"></script>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"
	type="text/javascript"></script>
<script
	src="https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=8t7rv0vydbhhi2g0c7k7kbuoix5kck3mux35fnnlcbgjt8sv"
	type="text/javascript"></script>
<script type="text/javascript">
	tinymce.init({
		selector : 'textarea'
	});
</script>
<title>Detail Page</title>
</head>
<body>
	<div class="container" id="main">
		<%@include file="/WEB-INF/views/navbar.jsp"%></div>
	<div class="row">
		<c:if test="${empty recipe}">
			<center>
				<h4 class="btn btn-warning">Sorry Currently No Data are
					available</h4>
			</center>
			<br>
			<br>
		</c:if>

		<div class="col-sm-4">
			<span style="font-size: 15px; opacity: 0.5">Note:Most recent
				Recipe At Last</span>
			<c:if test="${!empty recipe}">
				<c:forEach var="recipe" items="${recipe}">
					<br>
					<br>
					<br>
					<img style="margin-left: 30px"
						src="${url_Recipe_img}/${recipe.recipe_name}.jpg"
						alt="recipe_image" width="400" class="pop">
				</c:forEach>
				<br>
				<br>
			</c:if>
		</div>
		<div class="col-sm-4">
			<c:if test="${!empty recipe}">
				<c:forEach var="recipe" items="${recipe}">
					<br>
					<br>
					<br>
					<hr>
					<h3>${recipe.recipe_title}
						&nbsp; <a href="#"><span class="glyphicon glyphicon-pencil"
							style="color: blue"></span></a>
					</h3>
					<span style="color: green; font-size: 15px; opacity: 0.5">${recipe.date }</span>
					<h5 id="recipeName">${recipe.recipe_name}</h5>
					<br>
					<hr>
					<h6>
						<span style="color: green; font-size: 15px; opacity: 0.5">
							Main Ingredients:</span> &nbsp; ${recipe.main_ingredients}
					</h6>
					<hr>
					<h6 id="heading">Detail</h6>
					<br>
					<p id="paragraph">${recipe.detail}</p>
					<hr>
					<h6 id="heading">Ingredients</h6>
					<br>
					<p id="paragraph">${recipe.ingredients}</p>
					<hr>
					<h6 id="heading">Method</h6>
					<hr>
					<p id="paragraph">${recipe.method}</p>
					<hr>
					<h6 id="heading">Some thing More About Recipe</h6>
					<br>
					<p id="paragraph">
						<strong>Preparation Time:-</strong>${recipe.prep_time}</p>
					<br>
					<p id="paragraph">
						<strong>Cook Time:-</strong>${recipe.cook_time}</p>
					<br>
					<p id="paragraph">
						<strong>Course:-</strong>${recipe.course}</p>
					<br>
					<p id="paragraph">
						<strong>Cuisine:-</strong>${recipe.cuisine}</p>
					<br>
					<p id="paragraph">
						<strong>Level Of Cooking:-</strong>${recipe.level_of_cooking}</p>
					<br>
					<p id="paragraph">
						<strong>Taste:-</strong>${recipe.taste}</p>
					<br>
					<p id="paragraph">
						<strong>Serve:-</strong>${recipe.serve}</p>
					<hr>
					<br>
					<p id="heading">Rating</p>
					<p id="paragraph">${recipe.user_rating}</p>
					<hr>
					<p id="heading">Nutrition Detail</p>
					<p id="paragraph">${recipe.nutiration_value}</p>
					<hr>
					<span class="glyphicon glyphicon-pencil" style="color: blue">Last
						Edited</span>
					<hr>
					<br>
					<br>
				</c:forEach>
			</c:if>
		</div>


		<div class="col-sm-4"></div>
	</div>
	<div><%@include file="/WEB-INF/views/footer.jsp"%></div>
</body>
</html>