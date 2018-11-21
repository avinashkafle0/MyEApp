<%-- 
    Document   : product-list
    Created on : Jun 15, 2017, 5:41:46 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product List!</h1>
        
        <table>
            
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.productCode}</td>
                     <td>${product.productPrice}</td>
                     <td><img src="<c:url value='/photo/${product.productImage }'/>"></td>
                </tr>
            </c:forEach>
            
        </table>
        
        
    </body>
</html>
