<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mise à jour des Paramètres de connexion</title>

<!-- DEFINITION DES STYLES CSS -->
<c:import url="includesTeacher/teacherCSS.jsp"></c:import>
<!-- FIN DEFINITION DES STYLES -->

</head>
<body>

	<!-- DEBUT DU HEADER -->
	<c:import url="includes/headerUser.jsp"></c:import>
	<!-- FIN DU HEADER-->
	<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;">
			<ol class="breadcrumb">
 				 <li><a href="homeTeacher">Accueil</a></li>
  				<li><a href="#">Informations Personnelles</a></li>
 				 <li class="active">Modifier mes Paramètres</li>
			</ol>
		</div>
	<!-- DEBUT DU MENU -->
		<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
    <!-- FIN DU MENU -->
<!-- 	<div class="container"> -->

		<div class="col-md-7" style="padding: 0px">
			<!--Contenu-->
			<div class="panel panel-default col-md-8">
				<div class="panel-body">
					<form action="updateParameters" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Email address</label> <input
								type="text" name="login" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Enter email"> <small id="emailHelp"
								class="form-text text-muted">We'll never share your
								email with anyone else.</small>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" name="password" class="form-control"
								id="exampleInputPassword1" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
				<div class="panel-footer">Panel footer</div>
			</div>
		</div>
		<!--/ Contenu-->
		
<!-- 	</div> -->

<!-- DEBUT DE L'ASIDE -->
		<c:import url="includes/aside.jsp"></c:import>
		<!-- FIN DE L'ASIDE -->

<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;"></div>
	<div class="row">
	<!--Footer-->
	<c:import url="includes/footer.jsp"></c:import>
	<!--/ Footer-->
	</div>
	
	
	<!-- INCLUSION DES JS -->
	<c:import url="includesTeacher/teacherJS.jsp"></c:import>
	<!-- FIN INCLUSION DES JS -->
</body>
</html>