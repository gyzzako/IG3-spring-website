<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href=/css/customStyle.css rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <title>${title}</title>

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr-BE" />
    </spring:url>

    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en-US" />
    </spring:url>
    <script src="https://code.iconify.design/2/2.1.0/iconify.min.js"></script>
</head>
</head>
<body>

<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-1 mb-4 border-bottom ">
    <a href="<spring:url value='/'/>"><img class="ms-4" style="height: 100px; width: 150px;" alt="logo" src="<spring:url value='/images/logo.png'/>"/></a>

    <a href="<spring:url value='/'/>" class="category"><spring:message code="category"/></a>

    <div class="dropdown">
        <button class="btn btn-light btn-outline-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            <spring:message code="language"/>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li class="mb-2"><a style="color: inherit; text-decoration: none;" href="${localeFr}"><img class="ms-4 mx-2 languageImage" alt="Country flag" src="<spring:url value='/images/countriesFlag/fr.png'/>"/><spring:message code="french"/></a></li>
            <li class="mb-2"><a style="color: inherit; text-decoration: none;" href="${localeEn}"><img class="ms-4 mx-2 languageImage" alt="Country flag" src="<spring:url value='/images/countriesFlag/en.jpg'/>"/><spring:message code="english"/></a></li>
        </ul>
    </div>

    <div class="text-md-center me-4 buttons" style="width: 400px">
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
    <div class="container-fluid mx-4" style="width: 90%; height: auto">
        <tiles:insertAttribute name="main-content" />
    </div>
</div>

<footer class="templateFooter">
    <p class="text-center text-muted">&copy; 2021 Company, Inc | <a href="<spring:url value='/about'/>"><spring:message code="about"/></a></p>
</footer>
</body>
</html>