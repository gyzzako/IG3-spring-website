<%--
  Created by IntelliJ IDEA.
  User: Donny
  Date: 29-12-21
  Time: 01:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<div style="display: flex; justify-content: center;">
    <div style="display: flex; align-items: center; justify-content: center; margin-right: 20%;">
        <ul>
            <c:forEach items="${ cart.getProducts() }" var="cart">
                <li style="list-style: none; border-bottom: 2px solid black" class="nav-item">
                    <a href="<spring:url value="/product/${cart.key}"/>" class="nav-link link-dark">
                            ${cart.value.getQuantity()}
                            ${cart.value.getName()}
                            <img src='<spring:url value="/images/${cart.value.getImageName()}"/>' width="200px" height="200px" alt="music instrument">
                    </a>
                    <p>${cart.value.getPrice()}</p>
                    <form:form id="addToCartForm"
                               method="POST"
                               action="/cart/quantityUpdate"
                               modelAttribute="cartItem">
                        <form:label path="quantity"><spring:message code="Quantity"/>:</form:label>
                        <form:input type="number" min="1" max="99" value="${cart.value.getQuantity()}" path="quantity"></form:input>

                        <input type="hidden" name="productId" value="${cart.key}" />
                        <form:button class="btn btn-primary" ><spring:message code="update"/></form:button>
                    </form:form>
                </li>
            </c:forEach>

        </ul>
    </div>
    <div style="position:relative; top: 100px;">
        <p>${ cart.getTotalPrice() } €</p>
    </div>
</div>


