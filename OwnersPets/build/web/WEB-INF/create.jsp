<%-- 
    Document   : create
    Created on : 27.11.2019, 17:05:28
    Author     : Дарья
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to create page!</h1>
        <form action="UIController?choose=created" method ="post">
        <dl>
            <dt>AccNumber: </dt>
            <dd><input type="text" name="AccNumber" value="${AccNumber}" /></dd>
        </dl>
        <dl>
            <dt>Name: </dt>
            <dd><input type="text" name="Name" value="${Name}"/></dd>
        </dl>
         <button type="created">Create</button>
        </form>
    </body>
</html>
