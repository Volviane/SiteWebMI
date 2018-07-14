<aside class="col-md-2 pull-right" style="padding: 0px;">
	<section>
		
		<h5>Communiqués</h5>
		<hr>
		<div>

				<h6 class="gras">Titre du communiqué</h6>
				<p>Bienvenu à tous sur le site du département de Maths-Info de l'université de Dschang</p>
				<p>Publié le 02 Juillet 2018</p>
				<a href="" class="btn btn-primary text-center gras">Lire la suite</a>
			</div>
		<hr>
		<c:forEach items="" var="com">
		<hr>
			<div>
				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publié le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center gras">Lire la suite</a>
			</div>
			<hr>
		</c:forEach>		
		<a href="${pageContext.request.contextPath}/viewNews" class="btn btn-primary gras">Voir tous les Communiqués</a>
	</section>
	
	<hr>
	<!-- Début section des évènements -->
	<section style="margin-top: 10px;">
		<h5>Evènements</h5>
		<hr>
		<div>
				
				<h6 class="gras">Titre de l'évènement</h6>
				<p>Bienvenu à tous sur le site du département de Maths-Info de l'université de Dschang</p>
				<p>Publié le 02 Juillet 2018</p>
				<a href="" class="btn btn-primary text-center gras">Lire la suite</a>
			</div>
			<hr>
		<c:forEach items="" var="com">
		<hr>
			<div>
				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publié le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center gras">Lire la suite</a>
			</div>
			<hr>
		</c:forEach>
		<a href="${pageContext.request.contextPath}/viewEvent" class="btn btn-primary gras">Voir tous les évènements</a>
	
	</section>
	<!-- Fin section des évènements -->
	<hr>
	<!-- Début section des résultats -->
	<section>
		<h3>résultats</h3>
		<hr>
			<div>
				<h6 class="gras">Résultats de RSD438</h6>
				<p>Session de Juin 2018</p>
				<p>Publié le 23/06/2018</p>
				<a href="" class="btn btn-primary text-center gras">Consulter</a>
			</div>
			<hr>
		<c:forEach items="" var="result">
		<hr>
			<div>
				<h6 class="gras"><c:out value="${result.resultTitle}"></c:out></h6>
				<p>Session de <c:out value="${result.session}"></c:out></p>
				<p>Publié le <c:out value="${result.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center gras">Consulter</a>
			</div>
			<hr>
		</c:forEach>
		<a href="${pageContext.request.contextPath}/viewResult" class="btn btn-primary gras">Voir tous les résultats</a>
	</section>
</aside>
