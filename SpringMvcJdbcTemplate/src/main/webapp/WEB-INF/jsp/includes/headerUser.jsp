<header>
	<!-- header-area start -->
	<div id="sticker" class="header-area">
		<!--       <div class="container"> -->
		<div class="row">
			<div class="col-md-12 col-sm-12">

				<!-- Navigation -->
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target=".bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<!-- Brand -->
						<a class="navbar-brand page-scroll sticky-logo"
							style="margin: 0px;" href="index.html">
							<h1>
								<img
									src="${pageContext.request.contextPath}/resources/userResources/img/logo-univ.png"
									height="20px" width="60px" class="img-thumbnail img-circle" /><span>mi</span>
								Departement
							</h1> <!-- Uncomment below if you prefer to use an image logo --> <!-- <img src="img/logo.png" alt="" title=""> -->
						</a>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div
						class="collapse navbar-collapse main-menu bs-example-navbar-collapse-1"
						id="navbar-example">
						<ul class="nav navbar-nav navbar-right">
							<li class="active"><a class="page-scroll" href="${pageContext.request.contextPath}/index"><span class="glyphicon glyphicon-home"></span> Acceuil</a>
							</li>
							<li class="dropdown">
								<a class="page-scroll" data-toggle="dropdown" href="#about">Présentation<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/viewTeacherList"> enseignants du département</a></li>
									<li><a href="${pageContext.request.contextPath}/">organigramme</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a class="page-scroll" data-toggle="dropdown" href="#about">Formations<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/licenceMi"> licence en maths-info</a></li>
									<li><a href="${pageContext.request.contextPath}/masterAlgebra">master en algère</a></li>
									<li><a href="${pageContext.request.contextPath}/masterAnalysis"> master en analyse</a></li>
									<li><a href="${pageContext.request.contextPath}/masterRsd">master en RSD</a></li>
								</ul>
							</li>
							<li><a class="page-scroll" href="${pageContext.request.contextPath}/contact">Contact</a></li>
							<li><a href="#" data-target="#login" data-toggle="modal">Se connecter</a></li>
						</ul>
					</div>
					<!-- navbar-collapse -->
				</nav>
				<!-- END: Navigation -->
			</div>
		</div>
		<!--       </div> -->
	</div>
	<!-- header-area end -->
</header>
<!-- header end -->

<!--Modal box-->
<div class="modal fade" id="login" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content no 1-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title text-center form-title">CONNEXION</h4>
			</div>
			<div class="modal-body padtrbl">

				<div class="login-box-body">
					<p class="login-box-msg">connectez-vous pour débuter votre session</p>
					<div class="form-group">
						<form name="" id="loginForm" action="<c:url value='loginTeacher'/>" method="post" class="text-left form-validate">
							<div class="form-group has-feedback">
								<!----- username -------------->
								<input class="form-control" placeholder="login" id="loginid"
									type="text" autocomplete="off" name="login" /> <span
									style="display: none; font-weight: bold; position: absolute; color: red; position: absolute; padding: 4px; font-size: 11px; background-color: rgba(128, 128, 128, 0.26); z-index: 17; right: 27px; top: 5px;"
									id="span_loginid"></span>
								<!---Alredy exists  ! -->
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
								<span class="text-danger">${errorLogin}</span>
							</div>
							<div class="form-group has-feedback">
								<!----- password -------------->
								<input class="form-control" placeholder="mot de passe" id="loginpsw"
									type="password" autocomplete="off" name="password" /><span
									style="display: none; font-weight: bold; position: absolute; color: grey; position: absolute; padding: 4px; font-size: 11px; background-color: rgba(128, 128, 128, 0.26); z-index: 17; right: 27px; top: 5px;"
									id="span_loginpsw"></span>
					  			<!---Alredy exists  ! -->
								<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								<span class="text-danger">${errorPassword}</span>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<input type="submit" class="btn btn-green btn-block btn-flat"
										onclick="userlogin()"  value="se connecter" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!--/ Modal box-->


