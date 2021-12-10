<%-- 
    Document   : menu
    Created on : 10-dic-2021, 17:34:30
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <FORM METHOD="POST"   
           ACTION="http://localhost:8080/tp4/controller">
            
            <h3>MENU</h3><br><br>

            <button type="submit" name="action" value="show"/>Show all users</button><br><br>
            <input type="text" name="search"/>
            <button type="submit" name="action" value="search"/>Search for users</button><br><br>
            <button type="submit" name="action" value="index"/>Add data</button><br><br>
            <button type="submit" name="action" value="destroy"/>Reset data</button>
    </FORM>
        
    </body>
</html>
