<%--
  Created by IntelliJ IDEA.
  User: Arnaud
  Date: 07-11-21
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

        <div class="container d-flex justify-content-center" style="height: 73vh; width: 80%;">
            <div class="card border-0 " style="width: 18rem">
                <img src='<spring:url value="/images/${product.getImageName()}"/>' class="card-img-top" alt="music instrument">
                <div class="card-body">
                    <h5 class="card-title">${product.getProduct_name()}</h5>
                    <p class="card-text">${product.getDescription()}</p>
                    <p class="card-text">Marque: ${product.getBrand()}</p>
                </div>
            </div>
            <div class="productDetails">
                <h2>${product.getPrice()} €</h2>
                <button type="button" class="btn btn-primary">Ajouter au panier (A voir pour faire avec un "form" pour send les infos</button>
            </div>
        </div>
