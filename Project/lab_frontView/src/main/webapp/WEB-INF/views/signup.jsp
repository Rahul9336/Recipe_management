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
<title>Sign Up</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header" id="head">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/lab_frontView/">Maniou's Recipe
				Lab</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/lab_frontView/">Home</a></li>
			</ul>
			<form class="navbar-form navbar-left"
				action="/lab_frontView/searchbox">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						id="searchbox" name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit" id="searchbutton">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
			<c:if test="${pageContext.request.userPrincipal.name==null }">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/lab_frontView/signup"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/lab_frontView/login"><span
							class="glyphicon glyphicon-user"></span> Login</a></li>
				</ul>
			</c:if>
			<ul class="nav navbar-nav navbar-right">
				<c:url value="/j_spring_security_logout" var="logout"></c:url>
				<c:if test="${pageContext.request.userPrincipal.name!=null }">
					<li><a href="${logout}"><span
							class="glyphicon glyphicon-user"></span> Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>
	<div style="margin-top: 10px; margin-right: 60px; margin-left: 60px;">
		<div class="w3-panel w3-red">
			<form:errors path="user1.*" />
		</div>
		<div class="w3-card-4">
			<div class="w3-container w3-teal">
				<h2>Sign Up</h2>
			</div>
			<form class="w3-container" action="/lab_frontView/signupSuccess"
				method="post">
				<p></p>
				<h3 class="w3-red">${message}${Exception}</h3>
				<input class="w3-input w3-border " id="userid" name="user_id"
					type="hidden">
				<p></p>
				<p></p>
				<p>
					<label class="w3-text-orange"><b>Full Name:<span
							class="w3-text-red">*</span></b></label> <input class="w3-input w3-border"
						name="name" type="text">
				</p>
				<p>
					<label class="w3-text-orange"><b>Email_ID:<span
							class="w3-text-red">*</span></b></label> <input class="w3-input w3-border "
						name="email" type="email">
				</p>
				<p>
					<label class="w3-text-orange"><b>Password:<span
							class="w3-text-red">*</span></b></label> <input class="w3-input w3-border "
						name="password" type="password">
				</p>
				<p>
					<label class="w3-text-orange"><b>Address:<span
							class="w3-text-red">*</span></b></label> <input class="w3-input w3-border "
						name="address" type="text">
				</p>
				<p>
					<label class="w3-text-orange"><b>Mobile_No:<span
							class="w3-text-red">*</span></b></label> <input class="w3-input w3-border "
						name="contact" type="number">
				</p>
				<p>
					<button class="w3-btn w3-teal">Register</button>
				</p>
			</form>
		</div>
	</div>
	<br>
	<br>
	<div><%@include file="/WEB-INF/views/footer.jsp"%></div>

</body>
</html>