<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <c:if test="${student==null}">
	<c:redirect url="/"></c:redirect>
</c:if> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Liste des Documents</title>
<c:import url="includesStudent/studentCSS.jsp"></c:import>

</head>
<body>

	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includesStudent/headerStudent.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div
		style="clear: both; display: block; margin-top: 88px; margin-bottom: 30px; height: 60px;">
		<ol class="breadcrumb">
			<li><a href="homeStudent">Espace Personnel</a></li>
			<li><a href="#">Documents</a></li>
			<li class="active gras">Liste des documents</li>
		</ol>
	</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesStudent/studentMenu.jsp"></c:import>
	<!-- FIN DU MENU -->


	<div class="col-md-7" style="padding: 0px">
		<!--Contenu-->
		<section class="col-md-11">


			<div class="card">
				<div class="card-header">
					<h3>
						<span class="glyphicon glyphicon-list-alt"></span> Liste de vos
						Documents
					</h3>
					<hr>

				</div>
				<c:if test="${empty articles }">
					<i class="gras">pas d'articles</i>
				</c:if>
				<c:if test="${!empty articles}">
                   <div class="panel">
						<div class="panel-body" style="min-height: 300px; padding: 0px;">
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead>
										<tr class="info">
											<th>#</th>
											<th>Titre</th>
											<th>Nom</th>
											<th>Resumé</th>
											<th></th>
										</tr>
									</thead>
									<tbody>


										<c:forEach items="${articles}" var="doc" varStatus="i">
											<tr>
												<th scope="row"><c:out value="${i.count}" /></th>
												<td><c:out value="${doc.articleTitle}" /></td>
												<td><c:out value="${doc.articleName}" /></td>
												<td><c:out value="${doc.articleAbstract}" /></td>
																								<td><a
																									href="${pageContext.request.contextPath}/resources/userResources/img/${doc.articleName }"
																									class="btn btn-info">Consulter</a></td>
											</tr>

										</c:forEach>
					

									</tbody>
								</table>
							</div>
						</div>
					</div>
					</c:if>
			</div>



		</section>



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
	<c:import url="includesStudent/studentJS.jsp"></c:import>
	<!-- FIN INCLUSION DES JS -->


</body>
</html>