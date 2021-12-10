<%-- 
    Document   : Index
    Created on : 05.12.2021, 07:12:40
    Author     : 34646
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            function dele (t) {
                document.getElementById(t).remove();
            }
            function add () {
                var us = document.getElementById("us");
                var tr = document.createElement("tr");
                var th1 = document.createElement("th");
                var th2 = document.createElement("th");
                var th3 = document.createElement("th");
                var th4 = document.createElement("th");
                var inpFN = document.createElement("input");
                var inpLN = document.createElement("input");
                var inpUN = document.createElement("input");
                var butEN = document.createElement("button");
                var idd = parseInt(Math.random()*2000000);
                console.log(idd);
                tr.id= "a"+idd;
                inpFN.type="text";
                inpLN.type="text";
                inpUN.type="text";
                butEN.type="button";
                inpFN.name="FName"+toString(idd);
                inpLN.name="LName"+toString(idd);
                inpUN.name="UName"+toString(idd);
                butEN.name="Delete"+toString(idd);
                butEN.innerHTML="x";
                th1.append(inpFN);
                th2.append(inpLN);
                th3.append(inpUN);
                th4.append(butEN);
                tr.appendChild(th1);
                tr.appendChild(th2);
                tr.appendChild(th3);
                tr.appendChild(th4);
                us.appendChild(tr);
                butEN.onclick=function() {
                    tr.remove();
                };
            }
        </script>
        <FORM METHOD="POST"   
           ACTION="http://localhost:8080/tp4/controller">
            
            <h3>Input new user(s)</h3>
            
            <table id="us">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Login (Username)</th>
                    <th>Delete this line</th>
                </tr>
                    <c:forEach var="i" begin="0" end="0" step="1">
                    <tr id="us${i}">
                        <th><INPUT TYPE="TEXT" name="FName${i}"/></th>
                        <th><input type="text" name="LName${i}"/></th>
                        <th><input type="text" name="UName${i}"/></th>
                        <th><button type="button" id="Delete${i}" onclick="dele('us${i}')"}/>x</button></th>
                    </tr>
                    </c:forEach>
            </table><br>
            <button type="button" onclick="add()">Put one more user</button><br><br>
            
            <button type="submit" name="action" value="add"/>Add</button>
    </FORM>
        
    </body>
</html>
