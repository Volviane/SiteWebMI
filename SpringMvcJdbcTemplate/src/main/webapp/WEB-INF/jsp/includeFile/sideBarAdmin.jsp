<nav class="side-navbar menu ">
      <div class="side-navbar-wrapper menu">
        <!-- Sidebar Header    -->
        <div class="menu sidenav-header d-flex align-items-center justify-content-center">
          <!-- User Info-->
          <div class="sidenav-header-inner text-center"><img src="${pageContext.request.contextPath}/resources/css/assets/css/img/logo-uds.PNG" alt="person" class="img-fluid rounded-circle">
            <h2 class="h5">ADMIN</h2>
          </div>
          <!-- Small Brand information, appears on minimized sidebar-->
          <div class=" menu sidenav-header-logo"><a href="index.html" class="brand-small text-center"> <strong>B</strong><strong class="text-primary">D</strong></a></div>
        </div>
        <!-- Sidebar Navigation Menus-->
        <div class="main-menu">
          <h5 class="sidenav-heading">Menu</h5>
          <ul id="side-main-menu" class="side-menu list-unstyled">                  
            <li><a href="${pageContext.request.contextPath}/homeAdministrator"> <i class="icon-home"></i>Accueil    
            <li><a href="${pageContext.request.contextPath}/openAcademicYear"> <i class=""></i>Ouvrir une ann�e                          </a></li>
            <li><a href="#item1" aria-expanded="false" data-toggle="collapse"> <i class=""></i>Nouveaux </a>
              <ul id="item1" class="collapse list-unstyled ">
                <li><a href="${pageContext.request.contextPath}/addRole">Nouveau role</a></li>
                <li><a href="${pageContext.request.contextPath}/addCycle">Nouveau cycle</a></li>
                <li><a href="${pageContext.request.contextPath}/addOption">Nouvelle option</a></li>
                <li><a href="${pageContext.request.contextPath}/addLevel">Nouveau niveau </a></li>
                <li><a href="${pageContext.request.contextPath}/addCourse">Nouvelle UE </a></li>
                <li><a href="${pageContext.request.contextPath}/addGrade">Nouveau grade </a></li>
                <li><a href="${pageContext.request.contextPath}/createTeacher">Nouveau enseignant </a></li>
                <li><a href="${pageContext.request.contextPath}/editNews">Nouveau communiqu� </a></li>
                <li><a href="${pageContext.request.contextPath}/createEvent">Nouvel �v�nement </a></li>
                <li><a href="${pageContext.request.contextPath}/createJury">Nouveau jury </a></li>
                 <li><a href="${pageContext.request.contextPath}/addResearchDomain">Nouveau Domaine de recherche </a></li>
              </ul>
            </li>
            <li><a href="#item2" aria-expanded="false" data-toggle="collapse"> <i class=""></i>Listing </a>
              <ul id="item2" class="collapse list-unstyled ">
                <li><a href="${pageContext.request.contextPath}/roleList">Liste des roles</a></li>
                <li><a href="${pageContext.request.contextPath}/cycleList">Liste des cycles</a></li>
                <li><a href="${pageContext.request.contextPath}/optionList">Liste des options</a></li>
                <li><a href="${pageContext.request.contextPath}/levelList">Liste des niveaux </a></li>
                <li><a href="${pageContext.request.contextPath}/courseList">Liste des cours </a></li>
                <li><a href="${pageContext.request.contextPath}/gradeList">Liste des grades </a></li>
                 <li><a href="${pageContext.request.contextPath}/teacherList">Liste des enseignants </a></li>
                  <li><a href="${pageContext.request.contextPath}/addResearchDomain">Liste des Domaines de recherche </a></li>
              </ul>
            </li>
            <li><a href="#item3" aria-expanded="false" data-toggle="collapse"> <i class=""></i>Mise � jour </a>
              <ul id="item3" class="collapse list-unstyled ">
                <li><a href="${pageContext.request.contextPath}/addRole">Modifier role</a></li>
                <li><a href="${pageContext.request.contextPath}/addCycle">Modifier cycle</a></li>
                <li><a href="${pageContext.request.contextPath}/addOption">Modifier option</a></li>
                <li><a href="${pageContext.request.contextPath}/addLevel">Modifier niveau </a></li>
                <li><a href="${pageContext.request.contextPath}/addCourse">Modifier UE </a></li>
                <li><a href="${pageContext.request.contextPath}/addGrade">Modifier grade </a></li>
              </ul>
            </li>
            <li><a href="#item4" aria-expanded="false" data-toggle="collapse"> <i class=""></i>Publications </a>
              <ul id="item4" class="collapse list-unstyled ">
                <li><a href="${pageContext.request.contextPath}/postEvent">Publier un �v�nement </a></li>
                <li><a href="${pageContext.request.contextPath}/postNews">Publier communiqu�</a></li>
                
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>