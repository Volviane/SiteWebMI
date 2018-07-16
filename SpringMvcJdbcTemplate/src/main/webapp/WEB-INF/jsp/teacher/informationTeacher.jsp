<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${teacher==null}">
	<c:redirect url="/"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Mes Informations</title>
<c:import url="includesTeacher/teacherCSS.jsp"></c:import>
<style type="text/css">
	.space{ padding-top: 10px;}
	.spaces{ height: 3000px;}
	.backgroundInfo  {
			    width: 400px;
			    heigh: 400px;
			    background-color:#f5f5f5;
			    color:#fff;
			    margin-bottom:10px;
			     padding: 10px;
				}
	.padding {
			   margin-left:10px;
			  
				}
</style>

</head>
<body>

	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includesTeacher/headerTeacher.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div
		style="clear: both; display: block; margin-top: 88px; margin-bottom: 20px; height: 60px;">
		<ol class="breadcrumb">
			<li><a href="homeTeacher">Espace Personnel</a></li>
			<li><a href="#">Informations Personnelles</a></li>
			<li class="active gras">Mes Informations</li>
		</ol>
	</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
	<!-- FIN DU MENU -->
		<section>
			<h3>Mes Informations</h3>
			<hr>
			<div class="col-md-7" style="padding: 0px">
			<!--Contenu-->
			
			<div class="media">
				<div class="media-left">
					
				</div>
				<div class="media-body">
					<c:if test="${teachers.pictureName==null }">
						<img src="${pageContext.request.contextPath}/resources/userResources/img/defaultImage.PNG"
					style="weight: 20px; height:200px" alt="" class="img-thumbnail img-circle media-object" />
					</c:if>
					<c:if test="${teachers.pictureName!=null }">
						<img src="${pageContext.request.contextPath}/resources/userResources/img/${teachers.pictureName }"
					    style="weight: 20px; height:200px" alt="" class="img-thumbnail img-circle media-object" />
					 </c:if>
					 <h4 class="media-heading"><c:out value="${teachers.firstName }" />  <c:out value="${teachers.lastName }" /></h4>
					  <div class="padding">
					  <div class="backgroundInfo">
					   	<c:if test="${teachers.grade.gradeName==null }">
					    	<p><label> Grade:  </label>  <i> non renseigné</i> </p>
					     </c:if>
					     <c:if test="${teachers.grade.gradeName!=null }">
					    	<p><label> Grade:  </label><h7>   <c:out value="${teachers.grade.gradeName }" /></h7> </p>
					     </c:if>
					     <c:if test="${researchDomains.domainLabel==null }">
					    	<p><label> Domaines de Recherche:  </label> <i>  non renseigné</i> </p>
					     </c:if>
					     <c:if test="${researchDomains.domainLabel!=null }">
					     <p><label>Domaines de Recherche:  </label><h7>   <c:out value="${researchDomains.domainLabel }" /></h7></p>
					      </c:if>
					      <c:if test="${teachers.cv==null }">
					    	<p><label> cv:  </label> <i>  non renseigné</i> </p>
					     </c:if>
					     <c:if test="${teachers.cv!=null }">
					      <p> <label>CV:  </label> <h7> <c:out value="${teachers.cv }" /> </h7> </p>
					       </c:if>
					   </div>
					   <div class="backgroundInfo">
					   <c:if test="${teachers.emailAdress==null }">
					    	<p><label> Adresse email:  </label> <i>  non renseigné</i> </p>
					     </c:if>
					    <c:if test="${teachers.emailAdress!=null }">
					     <p><label> Adresse email:  </label><h7>   <c:out value="${teachers.emailAdress }" /></h7> </p>
					    </c:if>
					     <c:if test="${teachers.phoneNumber==null }">
					    	<p><label> télephone:  </label><i>non renseigné</i> </p>
					     </c:if>
					    <c:if test="${teachers.phoneNumber!=null }">
					    <p> <label>télephone:  </label><h7>   <c:out value="${teachers.phoneNumber }" /></h7> </p>
					    </c:if>
					   </div> 
					   <div class="backgroundInfo">
					    <c:if test="${teachers.sexe==null }">
					    	<p><label>sexe:  </label><h7>non renseigné</h7> </p>
					     </c:if>
					     <c:if test="${teachers.sexe!=null }">
					      <p><label>sexe:  </label><h7>   <c:out value="${teachers.sexe }" /></h7> </p>
					     </c:if>
					     <c:if test="${teachers.birthDate==null }">
					    	<p><label>Date de naissance:  </label><i>non renseigné</i> </p>
					     </c:if>
					     <c:if test="${teachers.birthDate!=null }">
					      <p><label>Date de naissance:  </label><h7>   <c:out value="${teachers.birthDate }" /></h7></p>
					      </c:if>
					       <c:if test="${teachers.birthPlace==null }">
					    	 <p><label>Lieu de naissance:  </label>  <i> non renseigné</i> </p>
					       </c:if>
					     <c:if test="${teachers.birthPlace!=null }">
					      <p><label>Lieu de naissance:  </label><h7>   <c:out value="${teachers.birthPlace }" /></h7></p>
					      </c:if>
					   </div> 
					    
					   
<%-- 					     <hr>  <label>Jury:  </label><h7> jury du niveau <c:out value="${jurys.juryLevel }" /></h7>  --%>
					 </div> 
				</div>
			</div>
			<!--/ Contenu-->
		</div>
		</section>
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

</body>
</html>