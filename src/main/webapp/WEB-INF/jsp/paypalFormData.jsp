<%--
  Created by IntelliJ IDEA.
  User: Arnaud
  Date: 01-01-22
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
        <div>
            <p style="text-align: center"><spring:message code="redirecting"/></p>
            <form:form id="paypalFormData"
                       method="POST"
                       name="paypalFormData"
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
            </form:form>
            <script type="text/javascript">
                document.forms["paypalFormData"].submit();
            </script>
        </div>
