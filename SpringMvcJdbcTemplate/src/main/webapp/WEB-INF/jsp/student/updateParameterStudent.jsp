<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 	<c:if test="${student==null}"> 
			<c:redirect  url="/"></c:redirect>
	     </c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mise à jour des Paramètres de connexion</title>

<!-- DEFINITION DES STYLES CSS -->
<c:import url="includesStudent/studentCSS.jsp"></c:import>
<!-- FIN DEFINITION DES STYLES -->

</head>
<body>

	<!-- DEBUT DU HEADER -->
	<c:import url="includesStudent/headerStudent.jsp"></c:import>
	<!-- FIN DU HEADER-->
	<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;">
			<ol class="breadcrumb">
 				 <li><a href="homestudent">Accueil</a></li>
  				<li><a href="#">Informations Personnelles</a></li>
 				 <li class="active">Modifier mes Paramètres</li>
			</ol>
		</div>
	<!-- DEBUT DU MENU -->
		<c:import url="includesStudent/studentMenu.jsp"></c:import>
    <!-- FIN DU MENU -->
<!-- 	<div class="container"> -->

		<div class="col-md-7" style="padding-left: 100px">
			<!--Contenu-->
			<h2>
				<span class="glyphicon glyphicon-pencil"></span> Modifier les Paramètres de connexion
			</h2>
			<div class="panel panel-defaul col-md-8 ">
				<div class="panel-body">
					<form action="updateParameterStudent" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Entrez l'Ancien login</label><span class="text-danger gras">*</span> <input
								type="text" name="login" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Ancien login"> 
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Entrez le nouveau Login</label><span class="text-danger gras">*</span> <input
								type="text" name="newLogin" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="nouveau Login" required> 
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Entrez l'Ancien Mot de Passe</label><span class="text-danger gras">*</span> <input
								type="password" name="password" class="form-control"
								id="exampleInputPassword1" placeholder="  Ancien Mot de passe" required>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Nouveau Mot de Passe</label><span class="text-danger gras">*</span> <input
								type="password" name="newPassword" class="form-control"
								id="exampleInputPassword1" placeholder="nouveau Mot de passe" required>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Confirmer le Mot de Passe</label><span class="text-danger gras">*</span> <input
								type="password"  class="form-control"
								id="exampleInputPassword1" placeholder="Confirmation de mot de passe" required>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
					<c:if test="${students != null}">
						<div class="alert alert-success" role="alert">Paramètres modifiés avec succès</div>
					</c:if>
					<c:if test="${ errors != null}">
						<div class="alert alert-danger" role="alert">Echec de modifications</div>
					</c:if>
				</div>
			</div>
		</div>
		<!--/ Contenu-->
		
<!-- 	</div> -->

<!-- DEBUT DE L'ASIDE -->
<%-- 		<c:import url="../includes/aside.jsp"></c:import> --%>
		<!-- FIN DE L'ASIDE -->

<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;"></div>
	<div class="row">
	<!--Footer-->
	<c:import url="../includes/footer.jsp"></c:import>
	<!--/ Footer-->
	</div>
	
	
	<!-- INCLUSION DES JS -->
	<c:import url="includesStudent/studentJS.jsp"></c:import>
	<!-- FIN INCLUSION DES JS -->
</body>
</html>