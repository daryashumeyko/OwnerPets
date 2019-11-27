<%-- 
    Document   : lists
    Created on : 27.11.2019, 16:58:13
    Author     : Дарья
--%>

<%@page import="java.util.List"%>
<%@page import="entities.*"%>
<%@page language="java" contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>   
        <h1> Displaying owners and pets info </h1>   
        <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>ID</b></th> 
          <th><b>Name</b></th> 
          <th><b>Address</b></th> 
         </tr> 

        <%List<Owner> owner =  
            (List<Owner>)request.getAttribute("dataP");
        for(Owner p: owner){%> 

            <tr>
                <td><%=p.getId()%></td> 
                <td><%=p.getName()%></td> 
                <td><%=p.getAddress()%></td> 
            </tr> 
            <%}%> 
            
        <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F">
          <th><b>ID</b></th>
          <th><b>Name</b></th> 
          <th><b>birthDate</b></th> 
          <th><b>Type</b></th>
          <th><b>PetOwnerId</b></th> 
         </tr> 
         
        <%List<Pet> pet =  
            (List<Pet>)request.getAttribute("dataO"); 
        for(Pet o: pet){%> 
            <tr> 
                <td><%=o.getId()%></td> 
                <td><%=o.getName()%></td> 
                <td><%=o.getBirthDate()%></td> 
                <td><%=o.getType()%></td> 
                <td><%=o.getPetOwnerId()%></td>
            </tr> 
            <%}%> 
        </table> 
        <a href="index.jsp">На главную</a>
    </body>
</html>

