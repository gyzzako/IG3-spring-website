<%--
  Created by IntelliJ IDEA.
  User: Donny
  Date: 06-11-21
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<div class="container">
    <div class="row">

        <form:form id="loginForm"
                   method="post"
                   modelAttribute="customerLogin">

            <h2 class="text-center">Se connecter</h2>
            <br><br>
            <div class="form-group">
                <form:label path="email">Email</form:label>
                <form:input path="email" class="form-control"></form:input>
            </div>
            <br>
            <div class="form-group">
                <form:label path="password">Mot de passe</form:label>
                <form:input path="password" type="password" class="form-control"></form:input>
                <br>
                <div class="mb-2">
                    <form:button class="btn btn-primary" >Connexion</form:button>
                </div>
            </div>
        </form:form>

    </div>

</div>
