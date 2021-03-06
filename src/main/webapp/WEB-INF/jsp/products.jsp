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
                <c:if test = "${products.size() <= 0}">
                    <p><spring:message code="noProducts"/></p>
                </c:if>
                <c:forEach items="${ products }" var="product">
                    <div class="card p-2 productCard" style="width: 20rem;">
                        <a style="color: black; text-decoration: none;" href="<spring:url value="/product/${product.getProductId()}"/>">
                            <img class="card-img-top" height="250px" src='<spring:url value="/images/${product.getImageName()}"/>' alt="Card image cap"/>
                            <div class="card-body">
                                <h5 class="card-title">${ product.getProductName()}</h5>
                                <p class="card-text">${ product.getDescription()}</p>
                                <c:if test = "${product.isOnDiscount()}">
                                    <s><p><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"/>€<p></s>
                                    <p style="color: red;"><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPriceAfterDiscountCalculation()}"/>€<p>
                                    <p style="color: red;">
                                        <spring:message code="discount"/>
                                        ${product.getDiscount().getPercentageOff()}%
                                    </p>
                                </c:if>

                                <c:if test = "${!product.isOnDiscount()}">
                                    <p><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"/>€<p>
                                </c:if>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>