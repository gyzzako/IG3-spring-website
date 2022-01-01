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
                                    ${cart.value.getName()}
                                    <img src='<spring:url value="/images/${cart.value.getImageName()}"/>' width="200px" height="200px" alt="music instrument">
                            </a>
                            <p>${cart.value.getPrice()} €</p>
                            <div class="d-flex flex-wrap align-items-center">
                                <form:form style="margin-right: 5px" id="addToCartForm"
                                           method="POST"
                                           action="/cart/quantityUpdate"
                                           modelAttribute="cartItem">
                                    <form:label path="quantity"><spring:message code="Quantity"/>:</form:label>
                                    <form:input type="number" min="1" max="99" value="${cart.value.getQuantity()}" path="quantity"></form:input>

                                    <form:input type="hidden"  value="${cart.key}" path="productId"></form:input>
                                    <form:button class="btn btn-primary" ><spring:message code="update"/></form:button>
                                </form:form>
                                <form:form id="addToCartForm"
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
                <p><spring:message code="totalPrice"/>: ${cart.getTotalPrice()} €</p>
                <form:form id="addToCartForm"
                           method="POST"
                           action="https://www.sandbox.paypal.com/cgi-bin/webscr"
                           modelAttribute="cartItem">

                    <input type="hidden" name="business" value="sb-1xdo810831003@business.example.com" />
                    <input type="hidden" name="cert_id" value="ASzoCHK6gQfnjbqKzsOMbgvUR3aJpmtvM5UvdeooCDBKpesD0W5SG_ZJ41MTJndTOfqQRVCX0w-jeK1k" />
                    <input type="hidden" name="cmd" value="_cart" />
                    <input type="hidden" name="upload" value="1" />
                    <c:forEach items="${ cart.getProducts() }" var="cart" varStatus="status">
                        <input type="hidden" name="quantity_${status.count}" value="${cart.value.getQuantity()}" />
                        <input type="hidden" name="amount_${status.count}" value="${cart.value.getPrice()}" />
                        <input type="hidden" name="item_name_${status.count}" value="${cart.value.getName()}" />
                    </c:forEach>
                    <input type="hidden" name="return" value="http://localhost:8082/cart/paymentSuccess" />
                    <input type="hidden" name="cancel_return" value="http://localhost:8082/cart/paymentFailed" />
                    <input type="hidden" name="currency_code" value="EUR" />
                    <input type="hidden" name="lc" value="${locale.getLanguage()}-${locale.getCountry()}" />

                    <c:if test="${cart.getTotalPrice() > 0}">
                        <form:button class="btn btn-primary" ><spring:message code="buy"/></form:button>
                    </c:if>
                    <c:if test="${cart.getTotalPrice() <= 0}">
                        <form:button class="btn btn-primary" disabled="true"><spring:message code="buy"/></form:button>
                    </c:if>
                </form:form>
            </div>
        </div>


