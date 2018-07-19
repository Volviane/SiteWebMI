<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${teacher==null}">
	<c:redirect url="/"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MIUDS- Liste des Documents</title>
<c:import url="includesTeacher/teacherCSS.jsp"></c:import>

</head>
<body>

	<div id="preloader"></div>


	<!-- DEBUT DU HEADER -->
	<c:import url="includesTeacher/headerTeacher.jsp"></c:import>
	<!-- FIN DU HEADER-->

	<div
		style="clear: both; display: block; margin-top: 88px; margin-bottom: 30px; height: 60px;">
		<ol class="breadcrumb">
			<li><a href="homeTeacher">Espace Personnel</a></li>
			<li><a href="#">Documents</a></li>
			<li class="active gras">Liste des documents</li>
		</ol>
	</div>

	<!-- DEBUT DU MENU -->
	<c:import url="includesTeacher/teacherMenu.jsp"></c:import>
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
				<c:if test="${empty documents }">
					<i class="gras"><c:out value="${error}"></c:out></i>
				</c:if>
				<c:if test="${!empty documents}">


					<div class="panel">
						<div class="panel-body" style="min-height:300px;padding:0px;">
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead>
										<tr class="info">
											<th>#</th>
											<th>Titre</th>
											<th>Type</th>										
											<th>Date d'ajout</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${documents}" var="doc" varStatus="i">
											<tr>
												<th scope="row"><c:out value="${i.count}" /></th>
												<td><c:out value="${doc.documentTitle}" /></td>
												<td><c:out value="${doc.documentType}" /></td>												
												<td><c:out value="${doc.createDate}" /></td>
												<td><a
													href="${pageContext.request.contextPath}/resources/userResources/img/${doc.documentName }"
													class="btn btn-info">Consulter</a></td>
											</tr>

										</c:forEach>
										<!--  <tr>
                          <th scope="row">1</th>
                          <td>Introduction à l'informatique</td>
                          <td>Support de cours</td>
                          <td>Le support de cours d'introduction à l'informatique du niveau 1</td>
                          <td>21/02/2017</td>
                          <td><a href="" class="btn btn-info">Consulter</a></td>
                        </tr>
                        <tr>
                          <th scope="row">2</th>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                          <td>21/02/2017</td>
                          <td><a href="" class="btn btn-info">Consulter</a></td>
                        </tr>
                        <tr>
                          <th scope="row">3</th>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                          <td>21/02/2017</td>
                          <td><a href="" class="btn btn-info">Consulter</a></td>
                        </tr> -->
									</tbody>
								</table>
							</div>
						</div>
						<div class="panel-footer">
							<nav aria-label="Page navigation">
								<ul class="pagination">
									<c:if test="${precedent}">
										<li><a href="listDocuments?page=${currentPage-1}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:if>
									<c:forEach items="${pages}" varStatus="i">
										<li class="${currentPage==i.index?'active':''}"><a
											href="listDocuments?page=${i.index}">${i.count}</a></li>
									</c:forEach>
									<!-- <li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li> -->
									<c:if test="${suivant}">
										<li><a href="listDocuments?page=${currentPage+1}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:if>
								</ul>
							</nav>
						</div>
					</div>





				</c:if>
			</div>



		</section>



		<!--/ Contenu-->
	</div>
	</div>
	<!-- DEBUT DE L'ASIDE -->
<%-- 	<c:import url="../includes/aside.jsp"></c:import> --%>
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