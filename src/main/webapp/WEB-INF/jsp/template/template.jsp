<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/css" href="<spring:url value='/css/bootstrap.css' />" rel="stylesheet">
    <link href=/css/customStyle.css rel="stylesheet"/>
    <title>${title}</title>
</head>
<body>

<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-1 mb-4 border-bottom">
    <img class="ms-4" style="height: 100px; width: 150px;" alt="logo" src="<spring:url value='/images/logo.png'/>"/>

    <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Features</a></li>
    </ul>

    <div class="text-md-center me-4">
        <button type="button" class="btn btn-outline-primary me-2">Se connecter</button>
        <button type="button" class="btn btn-primary">S'inscrire</button>
    </div>
</header>

<div class="d-flex flex-row bd-highlight mb-3" style="height: auto;">
    <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 250px; height: auto;">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32"></svg>
            <span class="fs-4">Categories</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="#" class="nav-link active" aria-current="page">
                    <svg class="bi me-2" width="16" height="16"></svg>
                    Guitare
                </a>
            </li>
            <li>
                <a href="#" class="nav-link link-dark">
                    <svg class="bi me-2" width="16" height="16"></svg>
                    Piano
                </a>
            </li>
            <li>
                <a href="#" class="nav-link link-dark">
                    <svg class="bi me-2" width="16" height="16"></svg>
                    Flute
                </a>
            </li>
            <li>
                <a href="#" class="nav-link link-dark">
                    <svg class="bi me-2" width="16" height="16"></svg>
                    Violont
                </a>
            </li>
            <li>
                <a href="#" class="nav-link link-dark">
                    <svg class="bi me-2" width="16" height="16"></svg>
                    Batterie
                </a>
            </li>
        </ul>
        <hr>
    </div>

    <div class="container-fluid mx-4" style="width: 90%;">
        <tiles:insertAttribute name="main-content" />
    </div>
</div>

<footer style="margin-top:auto;">
    <ul class="nav justify-content-center border-bottom mb-3">
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
    </ul>
    <p class="text-center text-muted">&copy; 2021 Company, Inc</p>
</footer>
</body>
</html>