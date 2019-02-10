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
			<c:url value="/j_spring_security_logout" var="logout"></c:url>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="/lab_frontView/user/addrecipe"><span
							class="glyphicon glyphicon-plus"></span> Add Recipe</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-left">
					<li><a href="/lab_frontView/user/myrecipe"><span
							class="glyphicon glyphicon-book"></span> MyRecipe's</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-left">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							${user.name}</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${logout}"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</ul>
			</c:if>
		</div>
	</div>
</nav>
<c:if test="${empty user }">
	<div class="row" id="Bigcall">
		<div class="well well-sm visible-xs">
			<div class="page-header">

				<h3 align="center">Welcome Guest</h3>
			</div>
			<center>
				<a href="#" class="btn btn-large btn-block btn-primary"><span
					class="glyphicon glyphicon-hand-right"> Start Exploring</span></a>
			</center>
		</div>
		<div class="col-12">
			<div class="well hidden-xs">
				<div class="page-header">
					<h1 align="center">
						Welcome Guest<small> Thank You For Choosing Us</small>
					</h1>
				</div>
				<center>
					<a href="#" class="btn btn-large btn-primary">Start Exploring</a>
				</center>
			</div>
		</div>
	</div>
</c:if>