<%-- 
    Document   : signin
    Created on : Jun 20, 2017, 5:38:04 PM
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
        <h1>Sign In!</h1>
        
        <form action="${pageContext.request.contextPath}/verify-general-user" method="post">
            
            User email: <input type="text" name="generalUserEmail">
            User Password: <input type="password" name="generalUserPassword">
            <input type="submit" value="LogIn" >
            
        </form>
        
    </body>
</html>
