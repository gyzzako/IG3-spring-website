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

                        <h2 class="text-center">${title}</h2>
                        <br><br>
                        <div class="form-group textInput">
                            <form:label path="username"><spring:message code="username"/></form:label>
                            <form:input path="username" class="form-control"></form:input>
                            <form:errors path="username"  class="connexionError"/>
                        </div>
                        <br>
                        <div class="form-group textInput">
                            <form:label path="password"><spring:message code="password"/></form:label>
                            <form:input path="password" type="password" class="form-control"></form:input>
                            <form:errors path="password"  class="connexionError"/>
                            <br>
                        </div>
                        <br>
                        <div class="connexionError">
                            <span> <spring:message code="${badCredentials}"/></span>
                        </div>

                        <div class="mb-2 connexionBtn">
                            <form:button class="btn btn-primary" ><spring:message code="login"/></form:button>
                        </div>
                    </form:form>

                </div>

            </div>

        </div>
