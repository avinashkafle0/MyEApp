<%-- 
    Document   : category-list
    Created on : Jun 13, 2017, 6:00:53 PM
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
        <h1>Category List!</h1>
        
        <table>
            <c:forEach items="${categoryList}"  var="category">
                <tr>
                    <td>${category.categoryId}</td>
                    <td>${category.categoryName}</td>
                    <td><a href="edit-category?categoryId=${category.categoryId}">Edit</a></td>
                    <td><a href="delete-category?categoryId=${category.categoryId}">Delete</a></td>
                </tr>
            </c:forEach>
            
        </table>
        
    </body>
</html>
