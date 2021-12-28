<%--
  Created by IntelliJ IDEA.
  User: Donny
  Date: 06-11-21
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>


<h1 class="text-center">Inscription</h1>
<br> <br>
<%--@elvariable id="registrationForm" type="java"--%>
<form:form id="registration"
           method="post"
           modelAttribute="registrationForm">

    <div class="form-group row">
        <form:label path="username" class="col-sm-4 col-form-label">Email</form:label>
        <div class="col-sm-8">
            <form:input path="username" class="form-control"></form:input>
        </div>
    </div>
    <br>
    <div class="form-group row">
        <form:label path="password" class="col-sm-4 col-form-label">Mot de passe</form:label>
        <div class="col-sm-8">
            <form:input type="password" path="password" class="form-control"></form:input>
        </div>
    </div>
    <br>
    <div class="form-group row">
        <form:label path="firstname" class="col-sm-4 col-form-label">Prénom</form:label>
        <div class="col-sm-8">
            <form:input path="firstname" class="form-control"></form:input>
        </div>
    </div>
    <br>
    <div class="form-group row">
        <form:label path="lastname" class="col-sm-4 col-form-label">Nom</form:label>
        <div class="col-sm-8">
            <form:input path="lastname" class="form-control"></form:input>
        </div>
    </div>
    <br>
    <div class="form-group row">
        <form:label path="phone_number" class="col-sm-4 col-form-label">Téléphone</form:label>
        <div class="col-sm-8">
            <form:input path="phone_number" class="form-control"></form:input>
        </div>
    </div>
    <br>
    <div class="form-group row">
        <form:label path="address" class="col-sm-4 col-form-label">Adresse</form:label>
        <div class="col-sm-8">
            <form:input path="address" class="form-control"></form:input>
        </div>
    </div>
    <br> <br>
    <form:button class="btn btn-primary text-center">s'inscrire</></form:button>
</form:form>
