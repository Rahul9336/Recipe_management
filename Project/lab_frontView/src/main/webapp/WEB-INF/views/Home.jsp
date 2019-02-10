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
<link rel="stylesheet" href="${css}/card.css">
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
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"
	type="text/javascript"></script>
<title>Home</title>
</head>
<body>
	<div classs="container" id="main">
		<%@include file="/WEB-INF/views/navbar.jsp"%></div>
	<div class="container">
		<c:if test="${empty recipelist}">
			<center>
				<h4 class="btn btn-warning">Sorry Currently No Data are
					available</h4>
			</center>
			<br>
			<br>
		</c:if>
		<c:if test="${!empty recipelist}">
			<c:forEach var="recipe" items="${recipelist}">
				<div class="image-flip "
					ontouchstart="this.classList.toggle('hover');"
					style="display: inline-block">
					<div class="mainflip">
						<div class="frontside">
							<div class="card" style="width: 20rem;">
								<img class="card-img-top img- fluid"
									src="${url_Recipe_img}/${recipe.recipe_name}.jpg"
									alt="Recipe Image Folder error"
									style="width: 20rem; height: 15rem;">
								<div class="card-body">
									<h4 class="card-title">${recipe.recipe_title}</h4>
									<h6>
										<strong>${recipe.recipe_name}</strong>
									</h6>
									<p class="card-text">
										Main Ingredients: ${recipe.main_ingredients}<br>Cuisine:
										${recipe.cuisine} <br>Prepration Time:
										${recipe.prep_time}
									</p>
									<p style="margin-left: 0px; opacity: 0.5;">Author:${recipe.author_name}</p>
								</div>
							</div>
						</div>
						<div class="backside">
							<div class="card" style="width: 20rem; margin-bottom: 0;">
								<div class="card-body">
									<h4 class="card-title">${recipe.recipe_title}</h4>
									<h6>
										<strong>${recipe.recipe_name}</strong>
									</h6>
									<p class="card-text">
										Main Ingredients: ${recipe.main_ingredients}<br>Cuisine:
										${recipe.cuisine} <br>Prepration Time:
										${recipe.prep_time} <br>Cook Time: ${recipe.cook_time} <br>Taste:
										${recipe.taste}
									</p>
									<a href="/lab_frontView/recipedetail/${recipe.recipe_id}"
										class="btn btn-info btn-md">Read More About</a>
								</div>
							</div>
						</div>
					</div>
				</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>
		</c:if>
	</div>
	<div><%@include file="/WEB-INF/views/footer.jsp"%></div>
</body>
</html>