<%-- 
    Document   : category-form
    Created on : Jun 13, 2017, 6:00:41 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Category Form!</h1>
        
        <form action="add-category" method="post">
            <input type="hidden" name="categoryId" value="${category.categoryId}">
            Category Name: <input type="text" name="categoryName" value="${category.categoryName}">
            <input type="submit" value="Save" >
        </form>
        
    </body>
</html>
