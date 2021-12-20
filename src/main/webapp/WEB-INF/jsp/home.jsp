<%--
  Created by IntelliJ IDEA.
  User: Arnaud
  Date: 23-10-21
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 250px; height: auto;">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32"></svg>
                <span class="fs-4">Categories</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">
                <c:forEach items="${ categories }" var="category">
                    <li class="nav-item">
                        <a href="<spring:url value="/category/${category.getCategory().getCategory_id()}"/>" class="nav-link link-dark">
                            <svg class="bi me-2" width="16" height="16"></svg>
                                ${category.getLabel()}
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <hr>
        </div>
