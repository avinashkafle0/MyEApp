<%-- 
    Document   : add-cart
    Created on : Jun 20, 2017, 5:38:17 PM
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
        <h1>Add Cart!</h1>
    
        <table>
            <c:forEach items="${productsInCart}" var="cartProduct">
        
                <tr>
                    <td>${cartProduct.productName}</td>
                </tr>
        
             </c:forEach>
        
      </table>
        
    </body>
</html>
