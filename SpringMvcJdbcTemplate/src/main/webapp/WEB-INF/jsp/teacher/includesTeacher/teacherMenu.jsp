<section class="col-md-2" style="min-height: 500px; font-size: 1em;">
	<h5>Menu de navigation</h5>
	<hr style="text-shadow: 3px;">
	<nav class="side-navbar " style=" background-color:#f5f5f5;">
      <div class="side-navbar-wrapper">
        <!-- Sidebar Navigation Menus-->
        <div class="main-menu">
          <ul id="side-main-menu" class="side-menu list-unstyled">                  
           			<li role="presentation" class="active"><a href="homeTeacher"><span class="gyphicon glyphicon-home"></span> ACCUEIL</a></li>
            <li><a href="#item1" aria-expanded="false" data-toggle="collapse"> <i class=""></i>INFORMATION PERSONNELLE </a> <span class="caret"></span>
              <ul id="item1" class="collapse list-unstyled ">
                    <li><a href="informationTeacher?idTeacher=${teacher.idTeacher}"><span class=""></span> Mes Informations personnelles</a></li>
					<li><a href="updateParameterTeacher">Modifier mes Paramètres</a></li>
					<li><a href="editProfil">Editer mon profil</a></li>
			 </ul>
            </li>
            <li><a href="#item2" aria-expanded="false" data-toggle="collapse"> <i class=""></i>GERER MES DOCUMENTS  </a><span class="caret"></span>
              <ul id="item2" class="collapse list-unstyled ">
                              <li><a href="addDocument"><span class="gyphicon glyphicon-plus"></span> Nouveau document</a></li>
								<li><a href="updateDocument"><span class="gyphicon glyphicon-pencil"></span> Modifier Document</a></li>
								<li><a href="listDocuments">Mes Documents<span class="badge pull-right">${documentsNumber}</span></a></li>								
								<li><a href="listDocumentsByType?documentType=Article%20de%20Recherche">Mes Articles <span class="badge pull-right">${articlesNumber}</span></a></li>
								<li><a href="listDocumentsByType?documentType=Support%20de%20Cours">Mes Cours<span class="badge pull-right">${coursNumber }</span></a></li>
								<li><a href="listDocumentsByType?documentType=Fiche%20de%20TD">Mes Fiches de TD<span class="badge pull-right">${ficheTdNumber }</span></a></li>
								<li><a href="listDocumentsByType?documentType=Epreuve">Mes Epreuves<span class="badge pull-right">${epreuvesNumber }</span></a></li>
								<li><a href="listDocumentsByType?documentType=Correction%20Epreuves">Mes corrections<span class="badge pull-right">${correctionEpreuvesNumber }</span></a></li>
								<li><a href="listDocumentsByType?documentType=">Mes Livres </a><span class="badge pull-right"></span></li>
			 </ul>
            </li>
                       			<li role="presentation" class="active"><a href="postResult"> POSTER RESULTATS</a></li>
            
          </ul>
        </div>
      </div>
    </nav>
</section>