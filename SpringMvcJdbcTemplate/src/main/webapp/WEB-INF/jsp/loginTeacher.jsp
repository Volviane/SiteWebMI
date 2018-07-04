<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/vendor/bootstrap/css/bootstrap.css"
	type="text/css" media="all">
	<!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/fontastic.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/css/assets/css/img/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/assets/css/css/style.blue.css" id="theme-stylesheet">
   <link href="${pageContext.request.contextPath}/resources/userResources/lib/materialize/dist/css/materialize.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<div class="page login-page">
     <div class="container">
        <div class="form-outer text-center d-flex align-items-center">
          <div class="form-inner">
            <div class="logo text-uppercase"><strong class="text-primary">CONNEXION ENSEIGNANT</strong></div>
             <form action="<c:url value='loginTeacher'/>" method="post" class="text-left form-validate">
              <div class="form-group-material">
                <input id="login-username" type="text"  name="login" required data-msg="veuillez entrer votre login" class="input-material">
                <label for="login-username" class="label-material">login</label>
              </div>
              		 <c:if test="${errorLogin!=null}">
							<h6 class="text-error"> <font color="red">${errorLogin}</font></h1>
					 </c:if>
              <div class="form-group-material">
                <input id="login-password" type="password"  name="password"  required data-msg="veuillez entrer votre mot de passe" class="input-material">
                <label for="login-password" class="label-material">Password</label>
              </div>
                       <c:if test="${errorPassword!=null}">
							<h6 class="text-error"> <font color="red">${errorPassword}</font></h1>
					   </c:if>
              <div class="form-group text-center">
                <input type="submit" value="SING IN" class="btn btn-info">
                <!-- This should be submit button but I replaced it with <a> for demo purposes-->
              </div>
            </form>
            <a href="#" class="forgot-pass">Mot de passe oublié?</a><small>pas encore de compte </small><a href="${pageContext.request.contextPath}/registrationAdministrator" class="signup">créer compte</a>
          </div>
        </div>
      </div> 
      
      <!-- <div class="container">
      <div class="row">
    <form class="col s12">
      <div class="row">
        <div class="input-field col s6">
          <input placeholder="Placeholder" id="first_name" type="text" class="validate">
          <label for="first_name">First Name</label>
        </div>
        <div class="input-field col s6">
          <input id="last_name" type="text" class="validate">
          <label for="last_name">Last Name</label>
        </div> <i class="material-icons">add</i>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input disabled value="I am not editable" id="disabled" type="text" class="validate">
          <label for="disabled">Disabled</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate">
          <label for="email">Email</label>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          This is an inline input field:
          <div class="input-field inline">
            <input id="email_inline" type="email" class="validate">
            <label for="email_inline">Email</label>
            <span class="helper-text" data-error="wrong" data-success="right">Helper text</span>
          </div>
        </div>
      </div>
    </form>
  </div>
    </div>
    </div>
    -->
    
  <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/bootstrap/js/bootstrap.min.js"></script>    
 <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/jquery-validation/jquery.validate.min.js"></script>
       <script src="${pageContext.request.contextPath}/resources/css/assets/css/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/charts-home.js"></script>
    <!-- Main File-->
    <script src="${pageContext.request.contextPath}/resources/css/assets/css/js/front.js"></script>
    <script src="${pageContext.request.contextPath}/resources/userResources/lib//materialize/dist/js/materialize.js"></script>