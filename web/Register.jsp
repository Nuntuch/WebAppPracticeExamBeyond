<%-- 
    Document   : Register
    Created on : Sep 19, 2018, 11:37:24 AM
    Author     : Nuntuch  Thongyoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        
        <form action="Register" method="post">
            Enter Your Email : <input type="text" name ="email" required/> 
            Enter Your Code here : <input type="text" name="key" required/>
            <input type="submit"/>
        </form>
            ${error}
    </body>
</html>
