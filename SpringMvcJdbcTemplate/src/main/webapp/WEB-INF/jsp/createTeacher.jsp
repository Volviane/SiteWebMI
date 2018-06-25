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
<title>créer un enseignant</title>
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
                     <h4 class="page-head-line">Créer un enseignant</strong></h4>
                    <br />
               <form action="<c:url value='createTeacher'/>" method="post">
                    <label>nom</label>
                        <input type="text" class="form-control" name="firstName"  />
                     <label>prénom</label>
                        <input type="text" class="form-control" name="lastName"  />
                     <label>email</label>
                        <input type="email" class="form-control" name="emailAdress"  />
                     <label>grade</label>
                        <select class="form-control" name="gradeName">
                     			<c:forEach items="${grades}" var="i">
                     				<option value="${i.gradeName }" ><c:out value="${i.gradeName }"></c:out></option>
                     			</c:forEach>
                       </select>
                      <label>login</label>
                        <input type="text" class="form-control" name="teacherLogin"  />
                     <label>mot de passe  </label>
                        <input type="password" class="form-control" name="teacherPassword"  />
                        <label>téléphone</label>
                        <input type="text" class="form-control" name="teacherPhone"  />
                        <label>date et lieu de naissance</label>
                        <input type="date" class="form-control" name=""  />
                        <hr />
					<input type="submit" value="créer" class="btn btn-info">
               </form>
                </div>
                <div class="col-md-6">
                <div class="space"></div>
                    <div class="alert alert-info">
                        Vous allez pourvoir ici, enregistrer un enseignant du departement de mathematiques-informatique
                        <br />
                         
                       
                    </div>
                    <div class="alert alert-success">
                         <strong> Instructions:</strong>
                        <ul>
                           <li>
                              Entrer son nom
                            </li>
                            <li>
                              Entrer son adresse mail valide
                            </li>
                            <li>
                              Entrer son login
                            </li>
                            <li>
                                 Puis entrer son mot de passe
                            </li>
                            <li>
                              Entrer son numéro de téléphone
                            </li>
                            <li>
                              Entrer sa date et lieu de naissance
                            </li>
                            <li>
                               Enfin l'enregistrer
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