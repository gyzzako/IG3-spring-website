<%--
  Created by IntelliJ IDEA.
  User: Arnaud
  Date: 07-11-21
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

        <div class="container d-flex justify-content-center" style="height: 73vh;">
            <div class="card border-0 " style="width: 25rem; margin-right: 50px">
                <img src='<spring:url value="/images/${product.getImageName()}"/>' class="card-img-top" alt="music instrument">
                <div class="card-body">
                    <h5 class="card-title">${product.getProductName()}</h5>
                    <p class="card-text">${product.getDescription()}</p>
                    <p class="card-text"><spring:message code="brand"/>: ${product.getBrand()}</p>
                </div>
            </div>
            <div class="productDetails">
                <c:if test = "${product.isOnDiscount()}">
                    <s><h2><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"/>€</h2></s>

                    <h2 style="color: red;"><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPriceAfterDiscountCalculation()}"/>€</h2>
                    <p style="color: red;">
                        <spring:message code="discount"/>
                            ${product.getDiscount().getPercentageOff()}%
                    </p>

                </c:if>
                <c:if test = "${!product.isOnDiscount()}">
                    <h2><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"/>€</h2>
                </c:if>
                <div style="margin-top: 25px">
                    <%--@elvariable id="cartItem" type="java"--%>
                    <form:form id="addToCartForm"
                               method="POST"
                               action="/cart/send"
                               modelAttribute="cartItem">
                        <form:label path="quantity"><spring:message code="Quantity"/>:</form:label>
                        <form:input type="number" min="1" max="99" value="1" path="quantity"></form:input>

                        <form:input type="hidden" value="${product.getProductId()}" path="productId"></form:input>

                        <form:button class="btn btn-primary" ><spring:message code="addToCart"/></form:button>
                    </form:form>
                </div>
            </div>
        </div>
