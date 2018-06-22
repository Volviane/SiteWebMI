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
<title>ouvrir une année académique</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/assets/css/bootstrap.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styleAdmin.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" media="all">
</head>

<body id="page1">
<%@include file="includeFile/navAdmin.jsp"%>
   
    <!-- LOGO HEADER END-->
   
    <!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">
            <div class="row">

            </div>
            <div class="row">
                <div class="col-md-6">
                     <h4 class="page-head-line">ouvrir une année académique</strong></h4>
                    <br />
                    <form action="<c:url value='openAcademicYear'/>" method="post">
                    <label>année</label>
                        <input type="text" class="form-control" name="teacherName"  />
                    <label>niveau</label>
                    
                    	 <select class="form-control">
                     			<option> </option>
                     	 </select>
                    <label>coordonnateur</label>
                    
                    	 <select class="form-control">
                     			<option> </option>
                     	 </select>
                    <label>président du jury </label>
                    
                    	 <select class="form-control">
                     			<option> </option>
                     	 </select>
                        <hr />
                        <a href="/homeAdministrator.jsp" class="btn btn-info"><span class="glyphicon glyphicon-user"></span> &nbsp;ouvrir</a>&nbsp;
                </form>
                </div>
                <div class="col-md-6">
                <div class="space"></div>
                    <div class="alert alert-info">
                 Vous allez pourvoir ici, ouvrir une année académique
                        <br />
                         
                       
                    </div>
                    <div class="alert alert-success">
                         <strong> Instructions:</strong>
                        <ul>
                           <li>
                              Entrer l'entrée académique
                            </li>
                            <li>
                              Entrer un niveau scolaire
                            </li>
                            <li>
                              choisir le coordonnateur du niveau scolaire
                            </li>
                            <li>
                               choisir le président de jury du niveau scolaire 
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