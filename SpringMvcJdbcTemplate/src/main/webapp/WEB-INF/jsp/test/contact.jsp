<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/userResources/css/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<div class="dropdown show">
		<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
			class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>

					</div></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
		</nav>

		<!--Contact-->
		<section id="contact" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="header-section text-center">
					<h2>Contact Us</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Exercitationem nesciunt vitae,<br> maiores, magni dolorum
						aliquam.
					</p>
					<hr class="bottom-line">
				</div>
				<div id="sendmessage">Your message has been sent. Thank you!</div>
				<div id="errormessage"></div>
				<form action="" method="post" role="form" class="contactForm">
					<div class="col-md-6 col-sm-6 col-xs-12 left">
						<div class="form-group">
							<input type="text" name="name" class="form-control form"
								id="name" placeholder="Your Name" data-rule="minlen:4"
								data-msg="Please enter at least 4 chars" />
							<div class="validation"></div>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" name="email" id="email"
								placeholder="Your Email" data-rule="email"
								data-msg="Please enter a valid email" />
							<div class="validation"></div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="subject"
								id="subject" placeholder="Subject" data-rule="minlen:4"
								data-msg="Please enter at least 8 chars of subject" />
							<div class="validation"></div>
						</div>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 right">
						<div class="form-group">
							<textarea class="form-control" name="message" rows="5"
								data-rule="required" data-msg="Please write something for us"
								placeholder="Message"></textarea>
							<div class="validation"></div>
						</div>
					</div>

					<div class="col-xs-12">
						<!-- Button -->
						<button type="submit" id="submit" name="submit"
							class="form contact-form-button light-form-button oswald light">SEND
							EMAIL</button>
					</div>
				</form>

			</div>
		</div>
		</section>
		<!--/ Contact-->
		<script
			src="${pageContext.request.contextPath}/resources/userResources/lib/jquery/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/userResources/lib/bootstrap/js/bootstrap.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/userResources/css/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>