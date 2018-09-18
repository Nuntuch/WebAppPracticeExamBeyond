<%-- 
    Document   : calculatorview
    Created on : Sep 18, 2018, 11:43:45 AM
    Author     : Nuntuch  Thongyoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
    <center>  <h1>Calculator</h1> </center>
    
    
<form action="Calculator" method="post">
    X: <input type="number"  name="x" required=""/>
    Y: <input type="number"  name="y" required=""/>
    Oper: <input type="text"  name="oper" required=""/>
        
        <input type="submit" name="cat"/>
    </form>
    <br>    
    <hr>    
    <br>    
    <h2> ANS : </h2>
    
   ${calculator.ans} 
    
    </body>
</html>
