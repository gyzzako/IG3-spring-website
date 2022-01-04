<%--
  Created by IntelliJ IDEA.
  User: Donny
  Date: 06-11-21
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

        <div class="container">
            <div class="container-fluid connexionForm">

                <h1 class="text-center"> ${title} </h1>
                <br> <br>
                <p class="text-center">${mandatory}</p>
                <br><br>
                <%--@elvariable id="currentUser" type="java"--%>
                <form:form id="registration"
                           method="post"
                           action="/registration"
                           modelAttribute="currentUser">

                    <div class="form-group row textInput">
                        <form:label path="username" class="col-sm-4 col-form-label"><spring:message code="username"/>*</form:label>
                        <div class="col-sm-8">
                            <form:input path="username" class="form-control"></form:input>
                            <form:errors path="username" class="connexionError" />
                        </div>
                    </div>
                    <br>
                    <div class="form-group row textInput">
                        <form:label path="email" class="col-sm-4 col-form-label"><spring:message code="email"/>*</form:label>
                        <div class="col-sm-8">
                            <form:input path="email" class="form-control"></form:input>
                            <form:errors path="email" class="connexionError" />
                        </div>
                    </div>
                    <br>
                    <div class="form-group row textInput">
                        <form:label path="password" class="col-sm-4 col-form-label"><spring:message code="password"/>*</form:label>
                        <div class="col-sm-8">
                            <form:input type="password" path="password" class="form-control"></form:input>
                            <form:errors path="password" class="connexionError" />
                        </div>
                    </div>
                    <br>
                    <div class="form-group row textInput">
                        <form:label path="firstname" class="col-sm-4 col-form-label"><spring:message code="firstname"/>*</form:label>
                        <div class="col-sm-8">
                            <form:input path="firstname" class="form-control"></form:input>
                            <form:errors path="firstname" class="connexionError" />
                        </div>
                    </div>
                    <br>
                    <div class="form-group row textInput">
                        <form:label path="lastname" class="col-sm-4 col-form-label"><spring:message code="lastname"/>*</form:label>
                        <div class="col-sm-8">
                            <form:input path="lastname" class="form-control"></form:input>
                            <form:errors path="lastname" class="connexionError" />
                        </div>
                    </div>
                    <br>
                    <div class="form-group row textInput">
                        <form:label path="phoneNumber" class="col-sm-4 col-form-label"><spring:message code="phoneNumber"/>*</form:label>
                        <div class="col-sm-8">
                            <form:input path="phoneNumber" class="form-control"></form:input>
                            <form:errors path="phoneNumber" class="connexionError" />
                        </div>
                    </div>
                    <br>
                    <div class="form-group row textInput">
                        <form:label path="address" class="col-sm-4 col-form-label"><spring:message code="address"/>*</form:label>
                        <div class="col-sm-8">
                            <form:input path="address" class="form-control"></form:input>
                            <form:errors path="address" class="connexionError" />
                        </div>
                    </div>
                    <br>

                    <div class="form-group row textInput">
                        <form:label path="gender" class="col-sm-4 col-form-label"><spring:message code="gender"/></form:label>
                        <div class="col-sm-8">
                            <form:input path="gender" class="form-control"></form:input>
                            <form:errors path="gender" class="connexionError" />
                        </div>
                    </div>
                    <br>
                    <br>
                    <p class="connexionError">${customerExists}</p>
                    <form:button class="btn btn-primary text-center connexionBtn"><spring:message code="signup"/></></form:button>
                </form:form>
            </div>
        </div>

