<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: xzin
  Date: 27/10/2018
  Time: 2:02 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.3.3.7.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ng-table.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/Movie%20Clapper.png" type="image/x-icon" />
</head>
</head>
<body ng-app="app">

<%
    User user = (User) request.getAttribute("user");
%>



<div class="container-fluid" ng-controller="ctrl">
    <div class="row text-center">

        <h1 class="main-header">Films Api - Welcome!</h1>
        <br>
        <img class="img-thumbnail" style="width: 100px;" src="../resources/img/Movie%20Clapper.png"/>
        <div class="main-view col-lg-12">
            <p>User id : <span id="userKey"><% out.print(user.getId());%></span></p>


            <input type="text" ng-model="keywords">
            <a class="btn btn-primary" ng-click="fetchFilm()">Search</a>
        </div>

    </div>

    <div class="row text-center">
        <hr>

        <div class="main-view col-lg-6 text-center" ng-if="film.Title">

            <img id="poster" ng-if="film.Poster" class="img-responsive" ng-src={{film.Poster}}/>

        </div>

        <div class="main-view col-lg-6 text-center" ng-if="film.Title">

            <h4>Search for film</h4>
            <h4>{{film.Title}}</h4>
            <hr>

            <p>{{film.Year}}</p>
            <p>{{film.Genre}}</p>
            <p>{{film.Director}}</p>
            <p>{{film.Writer}}</p>
            <p>{{film.Actors}}</p>
            <br>
            <p>{{film.Plot}}</p>



        </div>

    </div>

</div>




<script src="${pageContext.request.contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/bootstrap.3.3.7.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular.1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular-ui-router.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/angular-resource.1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/ngStorage.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/lodash.3.10.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<!--<script src="${pageContext.request.contextPath}/resources/js/directives.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/config.js"></script>-->
<script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>
<!--<script src="${pageContext.request.contextPath}/resources/js/controllers/signupCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/ng-table.min.js"></script>-->
<script src="${pageContext.request.contextPath}/resources/lib/dirPagination.js"></script>
</body>
</html>
