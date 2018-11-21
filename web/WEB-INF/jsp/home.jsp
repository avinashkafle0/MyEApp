<%-- 
    Document   : home
    Created on : Jun 18, 2017, 6:15:39 PM
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
        <h1>My E Site!</h1>

        
        <table>
            <tr>
            
                <td >
        <table width="300">
           
                    <c:forEach items="${categoryList }" var="category">
                         <tr>
                <td>
                        <a href="${pageContext.request.contextPath}/home/${category.categoryId}">${category.categoryName}</a>
                    
                </td>
                
            </tr>
                </c:forEach>
                    
                
            
            
        </table>
        </td>   
        <td>
        <table>

            <% int i = 0; %>

            <c:forEach items="${productList }" var="product">
                <% if (i == 2) {
                        i = 0;
                    } %>
                <% if (i == 0) {%>
                <tr>
                    <% } %>	
                    <td>
                        <table>
                            <tr><td><img src="<c:url value='/photo/${product.productImage }'/>"></td></tr>
                            <tr><td>${product.productName}</td></tr>
                            <tr><td>${product.productCode}</td></tr>
                            <tr><td>${product.productPrice}</td></tr>
                            <tr><td><a href="${pageContext.request.contextPath}/add-cart/${product.productId}" >Add To Cart</a></td></tr>
                        </table>

                    </td>

                    <% if (i == 1) {%>
                </tr>
                <% } %>	
                <% i++;%>
            </c:forEach>

        </table>
        </td>
</tr>
</table>
    </body>
</html>
