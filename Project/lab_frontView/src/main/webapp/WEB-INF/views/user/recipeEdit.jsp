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
<title>Edit Recipe</title>
</head>
<body>
	<div class="container" id="main">
		<%@include file="/WEB-INF/views/navbar.jsp"%></div>
	<div style="margin-top: 10px; margin-right: 60px; margin-left: 60px;">
		<div class="w3-panel w3-red">
			<form:errors path="recipe.*" />
		</div>
		<div class="w3-card-4">
			<h5>${message}</h5>
			<div class="w3-container w3-teal">
				<br>
				<h5>Update Recipe's</h5>
				<br>
			</div>
			<form:form class="w3-container"
				action="/lab_frontView/user/editRecipe"
				enctype="multipart/form-data" method="post" modelAttribute="recipe">
				<form:hidden path="recipe_id" />
				<p>
					<label class="w3-text-orange"><b>Recipe's Name:</b></label>
					<form:input class="w3-input w3-border" path="recipe_name"
						type="text" />
				</p>
				<p>
					<label class="w3-text-orange"><b>Recipe's Title:</b></label>
					<form:input class="w3-input w3-border" path="recipe_title"
						type="text" />
				</p>
				<p>
					<label class="w3-text-orange"><b>Main Ingredient's:</b></label>
					<form:input class="w3-input w3-border" path="main_ingredients"
						type="text" />
				</p>
				<p>
					<c:if test="${!empty cuisine}">
						<form:select path="cuisine">
							<c:forEach var="cuisine" items="${cuisine}">
								<option value="${cuisine.cuisine_name}">${cuisine.cuisine_name}</option>
							</c:forEach>
						</form:select>
					</c:if>
					<br>
				</p>
				<p>
					<label class="w3-text-orange"><b>Old Image:</b><img
						src="${url_Recipe_img}/${recipe.recipe_name}.jpg"
						alt="recipe_image" width="100px" height="100px"></label>
				</p>
				<label class="w3-text-orange"><b>New Image:</b></label>
				<form:input class="w3-input w3-border " path="file" type="file" />
				<p></p>
				<p>
					<label class="w3-text-orange"><b>Course:</b></label>
					<form:input class="w3-input w3-border " path="course" type="text" />
				</p>
				<p>
					<label class="w3-text-orange"><b>Detail:</b></label>
					<form:textarea path="detail" row="4" cols="60"
						placeholder="Some Detail About Recipe(optional)" rows=""></form:textarea>
				</p>
				<p>
					<label class="w3-text-orange"><b>Prepration Time:</b></label>
					<form:input class="w3-input w3-border " path="prep_time"
						type="text" />
				</p>
				<p>
					<label class="w3-text-orange"><b>Cook Time:</b></label>
					<form:input class="w3-input w3-border " path="cook_time"
						type="text" />
				</p>
				<p>
					<label class="w3-text-orange"><b>Serve:</b></label> <form:input
						class="w3-input w3-border " path="serve" type="text"/>
				</p>
				<br>
				<p>
					<label class="w3-text-orange"><b>Level Of cooking:</b></label>
					<form:select path="level_of_cooking">
						<option value="Easy">Easy</option>
						<option value="Medium">Medium</option>
						<option value="Hard">Hard</option>
					</form:select>
				</p>
				<p>
					<label class="w3-text-orange"><b>Taste:</b></label>
					<form:input class="w3-input w3-border " path="taste" type="text" />
				</p>
				<p></p>
				<p>
					<label class="w3-text-orange"><b>Detail:</b></label>
					<form:textarea path="ingredients" row="4" cols="60"
						placeholder="Some Detail About Recipe(optional)" rows=""></form:textarea>
				</p>
				<p>
					<label class="w3-text-orange"><b>Method:</b></label>
					<form:textarea path="method" row="6" cols="60"
						placeholder="How to Cook )" rows=""></form:textarea>

					<br>
					<form:input type="hidden" path="author_name" />
					<form:input type="hidden" path="user_id" />
				</p>
				<p>
					<label class="w3-text-orange"><b>Rating:</b></label>
					<form:textarea path="user_rating" row="6" cols="60"
						placeholder="Write Something that you like or modify in future...."
						rows=""></form:textarea>
				</p>
				<p>
					<label class="w3-text-orange"><b>Rating:</b></label>
					<form:textarea path="nutiration_value" row="6" cols="60"
						placeholder="Write Something that you like or modify in future...."
						rows=""></form:textarea>
				</p>
				<br>
				<input class="w3-btn w3-teal" type="submit" name="action"
					value="UPDATE">
<br>
			</form:form>
		</div>
	</div>
	<br>
	<br>
	<div><%@include file="/WEB-INF/views/footer.jsp"%></div>
</body>
</html>