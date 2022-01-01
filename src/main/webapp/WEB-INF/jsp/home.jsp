<%--
  Created by IntelliJ IDEA.
  User: Arnaud
  Date: 23-10-21
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
        <div class="d-flex flex-column align-items-center justify-content-center bg-light">
            <u><h3><spring:message code="category"/></h3></u>
            <hr>
            <ul class="flex-column">
                <c:forEach items="${ categories }" var="category">
                    <li style="color: inherit; list-style-type: none; margin: 10px 0">
                        <a style="color: inherit; text-decoration: none;" href="<spring:url value="/category/${category.getCategory().getCategoryId()}"/>" >
                                ${category.getLabel()}
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <hr>
        </div>
