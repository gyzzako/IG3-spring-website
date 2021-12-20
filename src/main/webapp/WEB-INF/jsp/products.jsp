<%--
  Created by IntelliJ IDEA.
  User: Arnaud
  Date: 20-12-21
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

        <div class="container text-center">
            <div class="row">
                <c:forEach items="${ products }" var="product">
                    <div class="card p-2 productCard" style="width: 20rem;">
                        <a style="color: black; text-decoration: none;" href="<spring:url value="/product/${product.getProduct_id()}"/>">
                            <img class="card-img-top" height="250px" src='<spring:url value="/images/${product.getImageName()}"/>' alt="Card image cap"/>
                            <div class="card-body">
                                <h5 class="card-title">${ product.getProduct_name()}</h5>
                                <p class="card-text">${ product.getDescription()}</p>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>