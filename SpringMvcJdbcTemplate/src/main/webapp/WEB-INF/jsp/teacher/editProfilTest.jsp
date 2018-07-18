<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${teacher==null}">
			<c:redirect  url="/"></c:redirect>
	     </c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Editer Profil</title>
	<c:import url="includesTeacher/teacherCSS.jsp"></c:import>

</head>
<body>

	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includesTeacher/headerTeacher.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div
		style="clear: both; display: block; margin-top: 88px; margin-bottom:20px; height: 60px;">
			<ol class="breadcrumb">
 				 <li><a href="homeTeacher">Espace Personnel</a></li>
  				<li><a href="#">Informations Personnelles</a></li>
 				 <li class="active gras">Edition du Profil</li>
			</ol>
		</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->


	<div class="col-md-7" style="padding: 0px">
		<!--Contenu-->
		<section>
			<h3><span class="gyphicon glyphicon-pencil"></span>Edition du Profil</h3>
			<hr>
			<p>Vous pouvez ici modifier vos informations personnelles</p>
		
			<form id="form-1" class="well form-horizontal col-md-10" action="<c:url value='editProfilTest'/>" method="post" enctype="multipart/form-data">
				<table id="table-1" class="table table-hover" >
					<tbody>
						<tr>
							<td>
							<div class="form-group">
								<label for="lastName" class="">Nom</label>
								<input class="form-control" id="lastName" name="lastName" type="text" value="<c:out value="${teacher.lastName}"/>" onblur="setEditableOff('lastName')" readonly>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('lastName')"> Modifier</a> </td>
						</tr>
						<tr>
							<td>
							<div class="form-group">
								<label for="firstName" class="">Prenom</label>
								<input class="form-control" id="firstName" name="firstName" type="text" value="<c:out value="${teacher.lastName}"/>" onblur="setEditableOff('firstName')" readonly>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('firstName')"></a> </td>
						</tr>
						<tr>
							<td>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('matricule')"></a> </td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="emailAdress" class="">Adresse mail</label>
								<input class="form-control" id="emailAdress" name="emailAdress" type="text" value="<c:out value="${teacher.emailAdress}"/>" onblur="setEditableOff('emailAdress')" readonly>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('emailAdress')"></a> </td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="phoneNumber" class="">Numéro de Téléphone</label>
								<input class="form-control" id="phoneNumber" name="phoneNumber" type="text" value="<c:out value="${teacher.phoneNumber}"/>" onblur="setEditableOff('phoneNumber')" readonly>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('phoneNumber')"></a> </td>
						</tr>
						<tr>
							<td>
								<label for="sexe" >Sexe</label>
								<div class="radio">
									<label for="male" class="radio-inline">
									    <input type="radio" id="male" name="sex" value="Homme"  disabled>
									    Homme 
									  </label>
									  
								 	<label for="female" class="radio-inline">
									    <input type="radio" id="female" name="sex" value="Femme" disabled>
									   	Femme
								    </label>
								</div>
							  
							 
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setDisabled('male','female')"></a> </td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="birthDate" class="">Date de Naissance</label>
								<input class="form-control" id="birthDate" name="birthDate" type="date" value="<c:out value="${teacher.birthDate}"/>" onblur="setEditableOff('birthDate')">
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('birthDate')"></a> </td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="birthPlace" class="">Lieu de Naissance</label>
								<input class="form-control" id="birthDate" name="birthPlace" type="text" value="<c:out value="${teacher.birthPlace}"/>" onblur="setEditableOff('birthPlace')" readonly>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('birthPlace')"></a> </td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="grade" class="">Grade</label>
								<select name="grade" class="form-control" id="grade" onblur="setEditableOff('grade')" readonly >
									<option value='<c:out value="${teacher.researchDomain.domainLabel}"></c:out>' selected></option>
									<c:forEach items="${grades }" var="grade">
										<option value='<c:out value="${grade.gradeName}"/>'><c:out value="${grade.gradeName}"/></option>
									</c:forEach>
									<option value='Chargé de cours'>Chargé de Cours</option>
									<option value='Assistant'>Assistant</option>
									<option value='Professeur'>Professeur</option>
									<option value='Maitre de Conférence'>Maitre de Conférence</option>
									
								</select>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('grade')"></a> </td>
						</tr>
						
						<tr>
							<td>
							<div class="form-group">
								<label for="domainLabel" class="">Domaine de Recherche</label>
								<select name="domainLabel" class="form-control" id="domainLabel" onblur="setEditableOff('domainLabel')" readonly >
									<option value='<c:out value="${teacher.researchDomain.domainLabel}"></c:out>' selected></option>
									<c:forEach items="${domains }" var="dom">
										<option value='<c:out value="${dom.domainLabel}"/>'><c:out value="${dom.domainLabel}"/></option>
									</c:forEach>
									<option value='Génie Logiciel'>Support de Cours</option>
									<option value='Réseaux et services distribués'>Réseaux et services distribués</option>
									<option value='Algèbre'>Algèbre</option>
									<option value='Analyse'>Analyse</option>
									<option value='Intelligence Artificielle'>Intelligence Artificielle</option>
								</select>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('domainLabel')"></a> </td>
						</tr>
						<tr>
							<td>
								<div class="form-group">
									<label	for="teacherDescription" class="">Brève descripton de Vous</label>
									<textarea class="form-control" name="teacherDescription" id="teacherDescription" rows="5" cols="30" onblur="setEditableOff('teacherDescription')" readonly></textarea>
								</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('teacherDescription')"></a> </td>
						</tr>
						<tr>
							<td>
							<div class="form-group">
								<label for="photo" class="">Choisir une photo</label>
								<input class="form-control" id="photo" name="files" type="file" value="<c:out value="${teacher.pictureName}"/>" onblur="setEditableOff('photo')" readonly>
							</div>
							</td>
							<td class="text-center" style="vertical-align: middle;"> <a class="btn btn-info glyphicon glyphicon-pencil" onclick="setEditableOn('photo')"></a> </td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th>
								<div class="form-group">
									<input type="submit" value="ENREGISTRER" class="btn btn-primary pull-right">
								</div>
							</th>
							<th><div class="form-group">
									<input type="reset" value="REINITIALIZER TOUT" class="btn btn-danger pull-right">
								</div></th>
							
						</tr>
						
					</tfoot>
				</table>
				
			</form>
                          
		</section>
			<c:if test="${error!=null}">
							<h6 class=""> <font color="red">${error}</font></h1>
			       		</c:if>
			        	<c:if test="${error==null}">
							<h6 class=""> <font color="green">modification reussi</font></h1>
					${teachers.pictureName}<img src="${teachers.pictureName}"
						alt="" class="img-thumbnail img-circle media-object" />
			       		</c:if>
			
				
		<!--/ Contenu-->
	</div>
	</div>
	<!-- DEBUT DE L'ASIDE -->
	<c:import url="../includes/aside.jsp"></c:import>
	<!-- FIN DE L'ASIDE -->

<div
		style="clear: both; display: block; margin-top: 88px; height: 60px;"></div>
	

	<!--Footer-->
	<c:import url="../includes/footer.jsp"></c:import>
	<!--/ Footer-->

	<!-- INCLUSION DES JS -->
	<c:import url="includesTeacher/teacherJS.jsp"></c:import>
	<!-- FIN INCLUSION DES JS -->
	
	<script type="text/javascript">
	
		function setEditableOn(target){
			console.log("debut: rendre "+target+" éditable");
			 document.getElementById(target).setAttribute("readonly", "false");
			//$(target).setAttribute("readonly","false");
				console.log("fin: rendre "+target+" éditable");
		}
/* 
		function setEditableOff(target){
			//setAttribute("readonly",true);
			document.getElementById(target).setAttribute("readonly", "true");
		} */
		function setDisabled(target1,target2){
			 document.getElementById(target1).setAttribute("disabled","false");
			 document.getElementById(target2).setAttribute("disabled","false");
		}
	</script>
	
</body>
</html>