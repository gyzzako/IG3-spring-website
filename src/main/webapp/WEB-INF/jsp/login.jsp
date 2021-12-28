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
    <div class="container-fluid connexionForm">
        <div class="row">
            <%--@elvariable id="customerLogin" type="java"--%>
            <form:form id="loginForm"
                       method="POST"
                       modelAttribute="customerLogin">

                <h2 class="text-center">Se connecter</h2>
                <br><br>
                <div class="form-group textInput">
                    <form:label path="username">email</form:label>
                    <form:input path="username" class="form-control"></form:input>
                </div>
                <br>
                <div class="form-group textInput">
                    <form:label path="password">Mot de passe</form:label>
                    <form:input path="password" type="password" class="form-control"></form:input>
                    <br>
                    <div class="mb-2 connexionBtn">
                        <form:button class="btn btn-primary" >Connexion</form:button>
                    </div>
                </div>
            </form:form>

        </div>

    </div>

</div>
