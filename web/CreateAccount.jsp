<%-- 
    Document   : CreateAccounts
    Created on : Sep 19, 2018, 11:39:49 AM
    Author     : Nuntuch  Thongyoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create Accout</h1>


        <form action="CreateAccount" method="post">
            Email : 
            <input type="text" name="email"/>
            <br>
            Password :
            <input type="password" name="password"/>
            <br>
            <input type="submit" name="Create Account"/>
        </form>
        ${msg}



    </body>
</html>
