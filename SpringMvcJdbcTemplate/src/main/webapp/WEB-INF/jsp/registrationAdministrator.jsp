<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.mi.model.User"%>
<%@ page import="com.mi.model.Student"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Inscription</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/assets/css/bootstrap.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/assets/css/styleAdmin.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" media="all">
</head>

<body id="page1">
	<div class="body1">
    <div class="navbar navbar-inverse set-radius-zero">
        </div>
    <!-- LOGO HEADER END-->
   
    <!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">
            <div class="row">

            </div>
            <div class="row">
                <div class="col-md-6">
                     <h4 class="page-head-line"> enregistrement admin</strong></h4>
                    <br />
                 <form action="<c:url value='registrationAdministrator'/>" method="post">
                     <label>login</label>
                        <input type="text" class="form-control" name="loginAdmin"  />
                        <label>mot de passe  </label>
                        <input type="password" class="form-control" name="passwordAdmin"  />
                        <hr />
                        <input type="submit" value="creer admin"><span class="glyphicon glyphicon-user">
              </form>
                </div>
                <div class="col-md-6">
                <div class="space"></div>
                    <div class="alert alert-info">
                        vous pourrez vous enregistrer ici
                        <br />
                         
                       
                    </div>
                    <div class="alert alert-success">
                         <strong> Instructions</strong>
                        <ul>
                            <li>
                              entrer votre login
                            </li>
                            <li>
                                Puis entrer votre mot de passe
                            </li>
                            <li>
                               Enfin vous enregistrer
                            </li>
                            
                        </ul>
                       
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- CONTENT-WRAPPER SECTION END-->
  <%@include file="includeFile/footerAdmin.jsp"%>
   
    <script src="assets/js/bootstrap.js"></script>
</body>
</html>