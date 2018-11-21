<%-- 
    Document   : product-form
    Created on : Jun 15, 2017, 5:41:29 PM
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
        <h1>Product Form!</h1>
        
        <form action="add-product" method="post" enctype="multipart/form-data">
            
            <table>
            
                <tr><td>Category : </td><td>
            <select name="category.categoryId">
                <option>Select Category</option>
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.categoryId}">${category.categoryName}</option>
                </c:forEach>
            </select></td></tr>
            <tr><td>Product Name :</td><td><input type="text" name="productName"></td></tr>
            <tr><td>Product Code :</td><td><input type="text" name="productCode"></td></tr>
            <tr><td>Product Price :</td><td><input type="text" name="productPrice"></td></tr>
            <tr><td>Product Description :</td><td><input type="text" name="productDescription"></td></tr>
            <tr><td>Product Image : </td><td><input type="file" name="image" > </td></tr>
             <tr><td><input type="submit" name="Save"></td></tr>
            </table>
        </form>
        
        
    </body>
</html>
