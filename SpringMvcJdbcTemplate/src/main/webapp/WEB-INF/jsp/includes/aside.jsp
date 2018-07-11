<aside class="col-md-3 pull-right" style="padding: 0px;">
	<section>
		
		<h5>Communiqu�s</h5>
		<hr>
		<div>

				<h6 class="gras">Titre du communiqu�</h6>
				<p>Bienvenu � tous sur le site du d�partement de Maths-Info de l'universit� de Dschang</p>
				<p>Publi� le 02 Juillet 2018</p>
			</div>
		<hr>
		<c:forEach items="" var="com">
		<hr>
			<div>
				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publi� le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
			<hr>
		</c:forEach>		
		<a href="" class="btn btn-primary">Voir toutes les Publications</a>
		<a href="${pageContext.request.contextPath}/viewNews" class="btn btn-primary">Voir tous les Communiqu�s</a>
	</section>
	<hr>
	<section style="margin-top: 10px;">
		<h5>Ev�nements</h5>
		<hr>
		<div>
				
				<h6 class="gras">Titre de l'�v�nement</h6>
				<p>Bienvenu � tous sur le site du d�partement de Maths-Info de l'universit� de Dschang</p>
				<p>Publi� le 02 Juillet 2018</p>
			</div>
			<hr>
		<a href="${pageContext.request.contextPath}/viewEvent" class="btn btn-primary">Voir tous les �v�nements</a>
				</section>
	<hr>
	<section>
		<h3>r�sultats</h3>
		<hr>
			<div>
				<h6 class="gras"><c:out value="${com.communiqueTitle}"></c:out></h6>
				<p><c:out value="${com.communiqueContent}"></c:out></p>
				<p>Publi� le <c:out value="${com.publicationDate}"/></p>
				<a href="" class="btn btn-primary text-center">Lire la suite</a>
			</div>
			<hr>
		<a href="${pageContext.request.contextPath}/viewResult" class="btn btn-primary">Voir tous les r�sultats</a>
	</section>
</aside>
