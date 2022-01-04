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
                        <li style="list-style: none; border-bottom: 2px solid black; padding-bottom: 10px" class="nav-item">
                            <a href="<spring:url value="/product/${cart.key}"/>" class="nav-link link-dark">
                                ${cart.value.getQuantity()}
                                ${cart.value.getProduct().getProductName()}
                                <img src='<spring:url value="/images/${cart.value.getProduct().getImageName()}"/>' width="200px" height="200px" alt="music instrument">
                            </a>

                            <c:if test = "${cart.value.getProduct().isOnDiscount()}">
                                <s><p><fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.value.getProduct().getPrice()}"/>€<p></s>
                                <p style="color: red;"><fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.value.getRealPrice()}"/>€<p>
                                <p style="color: red;">
                                    <spring:message code="discount"/>
                                        ${cart.value.getProduct().getDiscount().getPercentageOff()}%
                                </p>
                            </c:if>
                            <c:if test = "${!cart.value.getProduct().isOnDiscount()}">
                            <p><fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.value.getProduct().getPrice()}"/>€<p>
                            </c:if>
                            <div class="d-flex flex-wrap align-items-center">
                                <%--@elvariable id="cartItem" type="java"--%>
                                <form:form style="margin-right: 5px" id="quantityUpdateForm"
                                           method="POST"
                                           action="/cart/quantityUpdate"
                                           modelAttribute="cartItem">
                                    <form:label path="quantity"><spring:message code="Quantity"/>:</form:label>
                                    <form:input type="number" min="1" max="99" value="${cart.value.getQuantity()}" path="quantity"></form:input>

                                    <form:input type="hidden"  value="${cart.key}" path="productId"></form:input>
                                    <form:button class="btn btn-primary" ><spring:message code="update"/></form:button>
                                </form:form>
                                <form:form id="removeItemForm"
                                           method="POST"
                                           action="/cart/removeItem"
                                           modelAttribute="cartItem">

                                    <form:input type="hidden"  value="${cart.key}" path="productId"></form:input>
                                    <form:button class="btn btn-secondary bi-trash" ></form:button>
                                </form:form>
                            </div>
                        </li>
                    </c:forEach>

                </ul>
            </div>
            <div style="position:relative; top: 100px;">
                <script>
                    const message = "<spring:message code="continueToBuy"/>";
                    function confirmPurchase(e){
                        if(!confirm(message)) {
                            e.preventDefault()
                        }
                    }
                </script>
                <p><spring:message code="totalPrice"/>: <fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.getTotalPrice()}"/>€</p>
                <%--@elvariable id="cartItem" type="java"--%>
                <form:form id="buyForm"
                           method="POST"
                           action="/cart/saveCart"
                           onsubmit="confirmPurchase(event)"
                           modelAttribute="cartItem">
                    
                    <c:if test="${cart.getTotalPrice() > 0}">
                        <sec:authorize access="isAuthenticated()">
                            <form:button class="btn btn-primary" ><spring:message code="buy"/></form:button>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <c:if test="${cart.getTotalPrice() > 0}">
                                <p><spring:message code="mustBeConnected"/></p>
                            </c:if>
                        </sec:authorize>
                    </c:if>
                    <c:if test="${cart.getTotalPrice() <= 0}">
                        <form:button class="btn btn-primary" disabled="true"><spring:message code="buy"/></form:button>
                    </c:if>
                </form:form>
            </div>
        </div>


