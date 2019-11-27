<%-- 
    Document   : Index
    Created on : 27.11.2019, 16:56:40
    Author     : Дарья
--%>

<%@page import="java.util.List"%>
<%@page import="entities.*"%>
<%@page contentType="text/html" pageEncoding="utf8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-utf8">
        <title>JSP Page</title>
    </head>
    <body>   
        <h1> Welcome to my lab! </h1>   
        
        <a href ="UIController?choose=showAll">Show all tables</a>
        <!--<a href ="UIController?choose=update">Lets update</a>-->
        <a href ="UIController?choose=create">Lets create</a>
        <!--<a href ="UIController?choose=delete">Lets delete</a>-->
    </body>
</html>
