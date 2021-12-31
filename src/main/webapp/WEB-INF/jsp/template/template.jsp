<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/css" href="<spring:url value='/css/bootstrap.css' />" rel="stylesheet">
    <link href=/css/customStyle.css rel="stylesheet"/>
    <title>${title}</title>

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr" />
    </spring:url>

    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en" />
    </spring:url>
    <script src="https://code.iconify.design/2/2.1.0/iconify.min.js"></script>
</head>
</head>
<body>

<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-1 mb-4 border-bottom">
    <a href="<spring:url value='/'/>"><img class="ms-4" style="height: 100px; width: 150px;" alt="logo" src="<spring:url value='/images/logo.png'/>"/></a>

    <a href="<spring:url value='/'/>" class="category"><spring:message code="category"/></a>

    <ul style="list-style-type: none; display: flex;">
        <li><a href="${localeFr}"><img class="ms-4" style="height: 40px; width: 40px;" alt="logo" src="<spring:url value='/images/countriesFlag/fr.png'/>"/></a></li>
        <li><a href="${localeEn}"><img class="ms-4" style="height: 40px; width: 40px;" alt="logo" src="<spring:url value='/images/countriesFlag/en.jpg'/>"/></a></li>
    </ul>

    <div class="text-md-center me-4 buttons">
        <a href="<spring:url value='/cart'/>"><button type="button" class="btn btn-outline-primary me-2"><spring:message code="cart"/><span class="iconify" data-icon="ion:cart-outline"> </span></button></a>
        <sec:authorize access="isAuthenticated()">
            <p><spring:message code="welcome"/> ${pageContext.request.userPrincipal.principal.username}</p>
            <a href="<spring:url value='/logout'/>"><spring:message code="logout"/></a>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <a href="<spring:url value='/login'/>"><button type="button" class="btn btn-outline-primary me-2"><spring:message code="login"/></button></a>
            <a href="<spring:url value='/registration'/>"  class="btn btn-primary" ><spring:message code="signup"/></a>
        </sec:authorize>
        </div>
</header>

<div class="d-flex flex-row bd-highlight mb-3">
    <div class="container-fluid mx-4" style="width: 90%;">
        <tiles:insertAttribute name="main-content" />
    </div>
</div>

<footer style="margin-top:auto;">
    <p class="text-center text-muted">&copy; 2021 Company, Inc</p>
</footer>
</body>
</html>