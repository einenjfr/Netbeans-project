<%-- 
    Document   : bonus
    Created on : 05-dic-2021, 15:42:53
    Author     : 34646
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Tests JDBC</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body>
        <FORM METHOD="POST"   
              ACTION="http://localhost:8080/tp4/controller">
        <h1>Show users</h1>
        <h3>Total : ${ Integer.parseInt(num)+1 }</h3>
        <table>
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
        <!--c:forEach items="{ bonus }" var="bonus"-->
            <c:forEach var="i" begin="0" end="${ num }" step="1">
                
            <tr>
                    <td>${ bonus.get(3*i) }</td>
                    <td>${ bonus.get(3*i+1) }</td>
                    <td>${ bonus.get(3*i+2) }</td>
            </tr>
            </c:forEach>
            </tr>
        <!--/c:forEach-->
        </table>
        <br>
        <button type="submit" name="action" value="menu"/>Turn back</button>
    </FORM>
    </body>
</html>