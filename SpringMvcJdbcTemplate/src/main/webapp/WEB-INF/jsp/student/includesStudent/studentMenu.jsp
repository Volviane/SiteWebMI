<section class="col-md-2" style="min-height: 500px; font-size: 1em;">
	<h5>Menu de navigation</h5>
	<hr style="text-shadow: 3px;">
	<nav class="side-navbar " style=" background-color:#f5f5f5;">
      <div class="side-navbar-wrapper">
        <!-- Sidebar Navigation Menus-->
        <div class="main-menu">
          <ul id="side-main-menu" class="side-menu list-unstyled">                  
           			<li role="presentation" class="active"><a href="homeStudent"><span class="gyphicon glyphicon-home"></span> ACCUEIL</a></li>
            <li><a href="#item1" aria-expanded="false" data-toggle="collapse"> <i class=""></i>INFORMATION PERSONNELLE </a> <span class="caret"></span>
              <ul id="item1" class="collapse list-unstyled ">
<%--                     <li><a href="informationStudent?matricule=${student.matricule}"><span class=""></span> Mes Informations personnelles</a></li> --%>
					<li><a href="updateParameterStudent">Modifier mes Paramètres</a></li>
			 </ul>
            </li>
            <li><a href="#item2" aria-expanded="false" data-toggle="collapse"> <i class=""></i>GERER MES DOCUMENTS  </a><span class="caret"></span>
              <ul id="item2" class="collapse list-unstyled ">
                              <li><a href="addArticle"><span class="gyphicon glyphicon-plus"></span> Nouveau document</a></li>
<!-- 								<li><a href="updateDocument"><span class="gyphicon glyphicon-pencil"></span> Modifier Document</a></li> -->
								<li><a href="listArticle?eventTitle=doctoriale">Mes Articles</a></li>
								<li><a href="listArticle?eventTitle=soutenance">Mes Memoires</a></li>								
			 </ul>
            </li>
                       			
            
          </ul>
        </div>
      </div>
    </nav>
</section>