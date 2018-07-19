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
						class="collapse navbar-collapse main-menu bs-example-navbar-collapse-1">
<%-- 						 <form class="navbar-form pull-right" action="<c:url value='research'/>" method="post"> --%>
<!-- 							<input type="text" style="width:150px" class="input-sm form-control" -->
<!-- 							placeholder="Recherche"> -->
<!-- 							<input type="submit" class="btn btn-primary btn-sm glyphicon glyphicon-eye-open" value="chercher"> -->
<!-- 						  </form> -->
						<ul class="nav navbar-nav navbar-right">
							<li class="active"><a class="page-scroll" href="${pageContext.request.contextPath}/index">Acceuil</a>
							</li>
							<%-- <li class="dropdown">
								<a class="page-scroll" data-toggle="dropdown" href="#about">PRESENTATION<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="${pageContext.request.contextPath}/viewTeacherList"> enseignants du département</a></li>
									<li><a href="${pageContext.request.contextPath}/">organigramme</a></li>
								</ul>
							</li> --%>
<!-- 							<li class="dropdown"> -->
<!-- 								<a class="page-scroll" data-toggle="dropdown" href="#about">Formations<b class="caret"></b></a> -->
<!-- 								<ul class="dropdown-menu"> -->
<%-- 									<li><a href="${pageContext.request.contextPath}/licenceMi"> licence en maths-info</a></li> --%>
<%-- 									<li><a href="${pageContext.request.contextPath}/masterAlgebra">master en algère</a></li> --%>
<%-- 									<li><a href="${pageContext.request.contextPath}/masterAnalysis"> master en analyse</a></li> --%>
<%-- 									<li><a href="${pageContext.request.contextPath}/masterRsd">master en RSD</a></li> --%>
<!-- 								</ul> -->
<!-- 							</li> -->
							<li><a class="page-scroll" href="${pageContext.request.contextPath}/contact">Contact</a></li>
							<li class="dropdown gras">
								<a class="page-scroll" data-toggle="dropdown" href="#about"><i class="fa fa-sign-in"></i>/<i class="fa fa-sign-out"></i><b class="caret"></b></a>
								<ul class="dropdown-menu">
<!-- 								   <li><a href="login"> <span class="d-none d-sm-inline-block">connexion</span><i class="fa fa-sign-in"></i></a></li> -->
								  
                                  <li><a href="logoutStudent"> <span class="d-none d-sm-inline-block">deconnexion</span><i class="fa fa-sign-out"></i></a></li>
								</ul>
							</li>
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




